package com.ftx.ftxrenewal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@EnableJpaAuditing
public class FtxRenewalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FtxRenewalApplication.class, args);
    }

}
