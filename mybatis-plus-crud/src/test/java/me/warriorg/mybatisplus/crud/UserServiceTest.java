package me.warriorg.mybatisplus.crud;

import me.warriorg.mybatisplus.crud.model.User;
import me.warriorg.mybatisplus.crud.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void saveTest() {
        User user = new User();
        user.setName("小羊");
        user.setAge(3);
        user.setEmail("abc@mp.com");


        assertThat(userService.save((user))).isTrue();
        // 成功直接拿会写的 ID
        assertThat(user.getId()).isNotNull();
    }


    @Test
    public void getTest() {
        User user = userService.getById(1);
        assertThat(user.getName()).isEqualTo("Jone");
    }
}
