package io.github.zelinskyi.controllers;


import io.github.zelinskyi.domain.User;
import io.github.zelinskyi.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private static final long USER_ID = 1L;
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController controller = new UserController();
    private final MockMvc mockMvc = standaloneSetup(controller).build();


    @Test
    public void testSave() throws Exception {
        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"1\"}")).andExpect(status().isOk());
        verify(userService).save(any(User.class));
    }

    @Test
    public void testFind() throws Exception {

        User searchResult = new User();
        searchResult.setId(USER_ID);
        when(userService.find(USER_ID)).thenReturn(searchResult);
        mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));

    }
}