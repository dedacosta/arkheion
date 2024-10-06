package net.mephys.arkheion;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class ArkheionApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/backend");
        SpringApplication application =
                new SpringApplication(ArkheionApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }
}
