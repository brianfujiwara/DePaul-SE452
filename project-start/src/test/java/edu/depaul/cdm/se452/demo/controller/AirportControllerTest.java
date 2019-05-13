package edu.depaul.cdm.se452.demo.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AirportControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AirportController controller;
  
 
  @Test
  void bookFlightReturnsHttpStatusOk() throws Exception {
      /*
    mockMvc.perform(
            get("/airport"))
            .andDo(print()).andExpect(status().isOk());
*/
  } 
}
