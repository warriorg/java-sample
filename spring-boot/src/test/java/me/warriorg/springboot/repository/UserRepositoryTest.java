package me.warriorg.springboot.repository;

import me.warriorg.springboot.entity.UserEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    private UserEntity userEntity;

    @Before
    public void setUp() {
        userEntity = UserEntity.builder()
                .name("test")
                .age(100)
                .build();
        userRepo.deleteAll();
    }

    @Test//(expected = DuplicateKeyException.class)
    public void createSampleAccount() {
        userRepo.save(userEntity);
        assertTrue(userRepo.existsById(userEntity.getUid()));
    }

    @Test
    public void listAccount() {
        Pageable pageRequest = PageRequest.of(0, 2);
        // test empty
        Page<UserEntity> accounts = userRepo.findAll(pageRequest);
        assertEquals(0, accounts.getTotalElements());

        // create 1 new
        userRepo.save(userEntity);
        assertEquals(1, userRepo.count());

        // create 2 more
        userEntity.setUid(null);
        userRepo.save(userEntity);
        assertEquals(2, userRepo.count());
        userEntity.setUid(null);
        userRepo.save(userEntity);
        assertEquals(3, userRepo.count());
        accounts = userRepo.findAll(pageRequest);
        assertEquals(2, accounts.getNumberOfElements());
        pageRequest = pageRequest.next();
        accounts = userRepo.findAll(pageRequest);
        assertEquals(1, accounts.getNumberOfElements());
        assertEquals(2, accounts.getTotalPages());
        assertEquals(3, accounts.getTotalElements());
    }

    @After
    public void destroy() {
        userRepo.deleteAll();
    }
}
