package com.mangieproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MangieProjectApplication {

    public static void main(String[] args) {
    /*    File[] list = new File("mangie-vue/src/assets/img/thumbnails").listFiles();
        for(File f : list){
            System.out.println(f.getAbsolutePath());
        }*/
        SpringApplication.run(MangieProjectApplication.class, args);
    }

}