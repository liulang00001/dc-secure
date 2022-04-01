package com.payermax.data.secure.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Date 2022/2/22
 * @Author cyy
 */
@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.payermax.data.secure"})
public class DcSecureMain {

    public static void main(String[] args) {
        SpringApplication.run(DcSecureMain.class, args);
    }
}
