package net.mephys.arkheion.configuration;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("net.mephys.arkheion.api.model")
@EnableJpaRepositories(basePackages = {"net.mephys.arkheion.api.repository"})
@ComponentScan("net.mephys.arkheion.api")
public class SpringComponentScanApp {
}
