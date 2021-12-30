package com.ggoreb.practice.scheduler;

import java.io.File;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileDeleteScheduler {
    @Scheduled(cron = "0/5 * * * * *")
    public void test() {
        File f = new File("../img");
        File[] fs = f.listFiles();
        for (File f : fs) {
            f.delete();
        }

        System.out.println("동작");
    }

}
