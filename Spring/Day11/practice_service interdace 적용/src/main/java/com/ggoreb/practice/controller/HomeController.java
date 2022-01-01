package com.ggoreb.practice.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Map;

import com.ggoreb.practice.model.User;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "redirect:/question/list";
	}
	@GetMapping("/getKakao")
 public ResponseEntity<Map> getKakao() {
 RestTemplate rt = new RestTemplate();
 RequestEntity requestEntity = null;
 try {
 requestEntity = RequestEntity.get(
 new URI("https://dapi.kakao.com/v2/local/search/address.json?query=" +
 URLEncoder.encode("서울특별시청 04524 서울특별시 중구 세종대로 110", "utf-8")))
 .header("Authorization", "KakaoAK a21ab1d3aef4f356e0de6d82ecea9d6f")
 .build();
 } catch (UnsupportedEncodingException e) {
 e.printStackTrace();
 } catch (URISyntaxException e) {
 e.printStackTrace();
 }
 ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
 return entity;
 }
}
