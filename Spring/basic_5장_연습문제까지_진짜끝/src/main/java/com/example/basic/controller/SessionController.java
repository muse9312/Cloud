package com.example.basic.controller;

import javax.servlet.http.HttpSession;

import com.example.basic.model.Member;
import com.example.basic.model.User;
import com.example.basic.repository.MemberRepository;
import com.example.basic.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {
  @Autowired
  UserRepository userRepository;

  @Autowired
  MemberRepository memberRepository;

  @GetMapping("/member")
  public String member() {
    return "member";
  }
  @PostMapping("/member")
  @ResponseBody
  public String member(@ModelAttribute Member member) {
    memberRepository.save(member);
    
    return member.getUserId() + " 등록 완료";
  }
  
  @GetMapping("/signup")
  public String signup() {
    return "signup"; // templates/signup.html
  }

  @PostMapping("/signup") // 오버로딩
  @ResponseBody
  public String signup(@ModelAttribute User user) {
    System.out.println(user);
    userRepository.save(user);
    return "<script>" +
           "alert('가입완료');" +
           "location = '/login';" +
           "</script>";

    // return "redirect:/login";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String loginPost(
    User user, HttpSession session) {

    String userId = user.getUserId();
    String userPw = user.getUserPw();
    User result = userRepository.findByUserIdAndUserPw(userId, userPw);
    System.out.println(result);
    if(result != null) { // 로그인 성공
      session.setAttribute("user", user);
    } else { // 로그인 실패
      // 아무것도 하지 않음.. 사용자에게 특별한 메시지 출력
    } 

    return "redirect:/main";
  }

  @GetMapping("/main")
  public String main() {
    return "main";
  }
}
