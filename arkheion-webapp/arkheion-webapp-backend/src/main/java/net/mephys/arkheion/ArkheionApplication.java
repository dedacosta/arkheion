package net.mephys.arkheion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ArkheionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArkheionApplication.class, args);
    }

}
