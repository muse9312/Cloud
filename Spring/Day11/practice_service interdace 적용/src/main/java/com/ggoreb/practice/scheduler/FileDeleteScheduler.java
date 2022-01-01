package com.ggoreb.practice.scheduler;

import java.io.File;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileDeleteScheduler {
    @Scheduled(cron = "5* * * * * ") //초마다 동작
    public void test(){
        File file= new File("C:/temp");
       File[] files = file.listFiles();
       for(File f : files){
           f.delete();
       }
        System.out.println("동작!");
    }
    
}
