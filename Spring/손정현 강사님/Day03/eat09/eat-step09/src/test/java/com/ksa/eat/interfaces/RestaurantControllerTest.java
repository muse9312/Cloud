package com.ksa.eat.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.ksa.eat.application.RestaurantService;
import com.ksa.eat.domain.MenuItem;
import com.ksa.eat.domain.MenuItemRepository;
import com.ksa.eat.domain.Restaurant;
import com.ksa.eat.domain.RestaurantRepository;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

// junit5 spring 테스트 설정
@ExtendWith(SpringExtension.class)
// 웹 컨트롤러 설정
@WebMvcTest(controllers = RestaurantController.class)
public class RestaurantControllerTest {

  // 웹서버 없이 서버 흉내
  @Autowired
  private MockMvc mvc;

  // 객체를 흉내를 내는 Mock Object 설정
  @MockBean
  private RestaurantService restaurantService;

  // 가겍 목록 기능 테스트 케이스
  // { "id": 1004, "name": "Bob zip", "address": "Seoul"}
  @Test
  public void list() throws Exception {
    List<Restaurant> restaurants = new ArrayList<>();
    restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
    restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));

    given(restaurantService.getRestaurants()).willReturn(restaurants);

    mvc.perform(get("/restaurants"))
      .andExpect(status().isOk()) // HTTP Status 200
      .andExpect(content().string(containsString("\"id\":1004")))
      .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
      .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }

  // 가게 상세 기능 테스트 케이스
  @Test
  public void detail() throws Exception {
    Restaurant restaurant1 = new Restaurant(1004L, "Bob zip", "Seoul");
    restaurant1.addMenuItem(new MenuItem("Kimchi"));
    Restaurant restaurant2 = new Restaurant(2020L, "Cyber Food", "Seoul");

    given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
    given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

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

    // 전송 할 데이터 : json 포멧
    // {"name":"BeRyong", "address":"Busan"}
    @Test
    public void create() throws Exception {
      given(restaurantService.addRestaurant(any())).will(
        invocation -> {
          Restaurant restaurant = invocation.getArgument(0);
          return new Restaurant(1234L, restaurant.getName(),
          restaurant.getAddress());
        }
      );
      mvc.perform(post("/restaurants")
        // 전송 하는 데이터 포멧 지정
        .contentType(MediaType.APPLICATION_JSON)
        // 전송 하는 데이터 지정
        .content("{\"name\":\"BeRyong\", \"address\":\"Busan\"}"))

        .andExpect(status().isCreated())
        .andExpect(header().string("location", "/restaurants/1234"))
        .andExpect(content().string("{}"));
      verify(restaurantService).addRestaurant(any());
    }
}
