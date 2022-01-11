package com.ksa.eat.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ksa.eat.domain.MenuItemRepository;
import com.ksa.eat.domain.MenuItemRepositoryImpl;
import com.ksa.eat.domain.RestaurantRepository;
import com.ksa.eat.domain.RestaurantRepositoryImpl;

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

  // 의존성 주입을 받는 객체를 juint에 인식 시키는 성정
  @SpyBean(RestaurantRepositoryImpl.class)
  private RestaurantRepository restaurantRepository;

  @SpyBean(MenuItemRepositoryImpl.class)
  private MenuItemRepository menuItemRespository;

  // 가겍 목록 기능 테스트 케이스
  // { "id": 1004, "name": "Bob zip", "address": "Seoul"}
  @Test
  public void list() throws Exception {
    mvc.perform(get("/restaurants"))
      .andExpect(status().isOk()) // HTTP Status 200
      .andExpect(content().string(containsString("\"id\":1004")))
      .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
    }

  // 가게 상세 기능 테스트 케이스
  @Test
  public void detail() throws Exception {
    mvc.perform(get("/restaurants/1004"))
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("\"id\":1004")))
      .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
      .andExpect(content().string(containsString("\"address\":\"Seoul\"")))
      // 메뉴 정보 테스트 케이스
      .andExpect(content().string(containsString("Kimchi")));

      mvc.perform(get("/restaurants/2020"))
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("\"id\":2020")))
      .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")))
      .andExpect(content().string(containsString("\"address\":\"Seoul\"")));
    }
}
