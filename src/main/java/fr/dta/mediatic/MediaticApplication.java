package fr.dta.mediatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import fr.dta.mediatic.media.model.Media;

@SpringBootApplication
@ComponentScan("fr.dta.mediatic")
public class MediaticApplication {

    public static void main1(String[] args) {
        SpringApplication.run(MediaticApplication.class, args);
        System.out.println("coucou");
    }
}
