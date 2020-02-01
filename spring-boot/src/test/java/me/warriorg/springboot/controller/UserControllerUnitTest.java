package me.warriorg.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.warriorg.springboot.model.User;
import me.warriorg.springboot.service.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    User user;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        user = User.builder()
                .name("test")
                .age(12)
                .build();
    }

    @Test
    public void testGetUserSuccessfully() throws Exception {
        String uid = UUID.randomUUID().toString();
        user.setUid(uid);
        User expectedUser = user;
        Mockito.when(userService.getByUid(uid)).thenReturn(expectedUser);

        MvcResult mvcResult = mockMvc.perform(get("/v1/user/" + uid)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(userService, times(1)).getByUid(eq(uid));
        User userResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);
        assertThat(userResponse.getAge()).isEqualTo(12);
        assertThat(userResponse.getName()).isEqualTo("test");
        assertThat(userResponse).isEqualTo(user);
    }
}