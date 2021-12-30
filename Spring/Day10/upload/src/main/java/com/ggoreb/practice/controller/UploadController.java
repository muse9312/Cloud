package com.ggoreb.practice.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.ggoreb.practice.model.FileInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {
    @GetMapping("/upload1")
    public String upload1() {
        return "upload1";
    }

    @PostMapping("/upload1")
    @ResponseBody
    public String upload1Post(MultipartHttpServletRequest mRequest) {
        String result = "";

        Iterator<String> it = mRequest.getFileNames();
        while (it.hasNext()) {
            String f = it.next();
            List<MultipartFile> mFiles = mRequest.getFiles("file");
            for (MultipartFile mFile : mFiles) {
                result += mFile.getOriginalFilename() + "/";
            }
        }

        // List<MultipartFile> mFiles = mRequest.getFiles("file");
        // for (MultipartFile mFile : mFiles) {
        // result += mFile.getOriginalFilename() + "/";
        // }

        return result;
    }

    // 파일 저장하기 RequestParam

    @GetMapping("/upload2")
    public String upload2() {
        return "upload2";
    }

    @PostMapping("/upload2")
    @ResponseBody
    public String upload2Post(@RequestParam("file") MultipartFile mFile) {
        String result = "";
        String oName = mFile.getOriginalFilename();

        try {
            mFile.transferTo(new File("../../../../../../../img/" + oName));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        result += oName + "\n";
        return result;
    }

    @GetMapping("/upload3")
    public String upload3() {
        return "upload3";
    }

    @PostMapping("/upload3")
    @ResponseBody
    public String upload3Post(@ModelAttribute FileInfo info) {
        String result = "";
        String oName = info.getFile().getOriginalFilename();
        result += oName + "\n";
        return result;
    }
}
