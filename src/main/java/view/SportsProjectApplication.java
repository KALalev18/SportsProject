package view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsProjectApplication.class, args);
        System.out.println("http://localhost:8080/");
    }

}
