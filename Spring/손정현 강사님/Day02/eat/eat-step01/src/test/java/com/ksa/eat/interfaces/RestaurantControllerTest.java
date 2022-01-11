package com.ksa.eat.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

// junit5 spring 테스트 설정
@ExtendWith(SpringExtension.class)
// 웹 컨트롤러 설정
@WebMvcTest(controllers = RestaurantController.class)
public class RestaurantControllerTest {

  // 웹서버 없이 서버 흉내
  @Autowired
  private MockMvc mvc;

  // 가겍 목록 기능 테스트 케이스
  // { "id": 1004, "name": "Bob zip", "address": "Seoul"}
  String a = "\"id\"";
  @Test
  public void list() throws Exception {
    mvc.perform(get("/restaurants"))
      .andExpect(status().isOk()) // HTTP Status 200
      .andExpect(content().string(containsString("\"id\":1004")))
      .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
      .andExpect(content().string(containsString("\"address\":\"Seoul\"")));
    }
}
