package com.example.basic.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.example.basic.mapper.DemoMapper;
import com.example.basic.model.Demo;
import com.example.basic.model.JavaBoard;
import com.example.basic.model.Sunbyul;
import com.example.basic.repository.DemoRepository;
import com.example.basic.repository.JavaBoardRepository;
import com.example.basic.repository.SunbyulRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DBController {
    @Autowired
    JdbcTemplate jt;

    @Autowired
    DataSource ds;

    @Autowired
    DemoMapper demoMapper;

    @Autowired
    DemoRepository demoRepository;
    @Autowired
    JavaBoardRepository jbRepository;

    @Autowired
    SunbyulRepository sunbyulRepository;

    @GetMapping("/sunbyul")
    @ResponseBody
    public List<Sunbyul> sunbyul(
        @RequestParam String address, int p) {
        PageRequest page = PageRequest.of(p, 10);
        return sunbyulRepository.findByAddressContaining(address, page).getContent();
        // return sunbyulRepository.findByAddressContaining(address);

        // return sunbyulRepository.findAll();
    }

    @GetMapping("/jpa/add")
    @ResponseBody
    public JavaBoard jpaAdd() {
        JavaBoard javaBoard = new JavaBoard();
        javaBoard.setTitle("제목");
        javaBoard.setContent("내용");
        javaBoard.setMemberId("mariadb");
        javaBoard.setCreDate(new Date());
        return jbRepository.save(javaBoard);
    }

    @GetMapping("/jpa/demo")
    @ResponseBody
    public List<Demo> jpaDemo() {
        return demoRepository.findAll();
    }

    @GetMapping("/mybatis/demo")
    @ResponseBody
    public List<Map<String, Object>> mybatisDemo() {
        return demoMapper.findByUser("A");
        // return demoMapper.select();
    }

    @GetMapping("/db/parking")
    @ResponseBody
    public List<Map<String, Object>> parking(
        @RequestParam(value="page", defaultValue="1") int page,
        @RequestParam(value="address", defaultValue="") String address) {
                
        page = page * 10 - 10;

        return jt.queryForList(
            "select * " +
            " from holiday_parking" + 
            " where address like concat('%', ?, '%')" +
            " limit ?, 10",
            address, page);
    }

    @GetMapping("/db/test")
    @ResponseBody
    public List<Map<String, Object>> dbTest(
        @RequestParam(
            value="user", required=false,
            defaultValue="") String user) {
        
        return jt.queryForList(
            //                           admin or 1=1# 
            "select * from demo " +
            " where user like concat('%', ?, '%')", user);

        // return "";
    }
}
