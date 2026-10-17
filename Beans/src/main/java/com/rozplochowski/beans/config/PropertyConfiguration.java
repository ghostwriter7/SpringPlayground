package com.rozplochowski.beans.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:aboutme.properties")
public class PropertyConfiguration {

    @Value("${user.firstname:Unknown}")
    private String userName;

    @Value("${user.age:100}")
    private String userAge;

    @Value("${user.nickname:Buddy}")
    private String userNickname;

    @Value("${user.favoriteColor:Blue}")
    private String userFavoriteColor;

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean(destroyMethod = "destroy")
    public BannerLoader bannerLoader() {
        return new BannerLoader(banner);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @PostConstruct
    public void init() {
        IO.println("""
                Properties are:
                userName: %s
                userAge: %s
                userNickname: %s
                userFavoriteColor: %s
                """.formatted(userName, userAge, userNickname, userFavoriteColor));
    }
}
