package com.example.basic.controller;

import com.example.basic.model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// class Member { // 클래스 / 객체지향 파트 내용 확인
//     private String name;
//     public void setName(String name) {
//         this.name = name;
//     }
//     public String getName() {
//         return this.name;
//     }
// }
// 컴포넌트 스캔의 대상
@Controller
public class HtmlController {

    @GetMapping("/html/exam")
    public String htmlExam() {
        return "html/exam";
    }


    @GetMapping("html/object")
    @ResponseBody
    public Member htmlObject() {
        Member member = new Member();
        member.setName("kim");
        return member;
    }

    // 문제점 1) html폴더 밑에 string.html 없음
    // 문제점 2) / 주소는 이미 사용중
    @GetMapping("/") // html/exam
    public String home() {
//        return "html/exam"; // html/exam.html
        return "html/string"; // html 하위의 string.html
    }
}
