package net.mephys.arkheion.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class ArkheionGatewayServer {

    public static void main(String[] args) {
        SpringApplication application =
                new SpringApplication(ArkheionGatewayServer.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }

}
