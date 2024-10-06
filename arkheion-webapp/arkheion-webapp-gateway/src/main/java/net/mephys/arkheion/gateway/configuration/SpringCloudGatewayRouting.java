package net.mephys.arkheion.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("backend", r->r.path("/backend/**").uri("lb://BACKEND")) //static routing
                .route("fronten", r->r.path("/arkheion/**").uri("lb://FRONTEND")) //dynamic routing
                .build();
    }
}
