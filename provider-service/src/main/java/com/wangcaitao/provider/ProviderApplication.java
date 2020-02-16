package com.wangcaitao.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangcaitao
 */
@SpringBootApplication(scanBasePackages = {
        "com.wangcaitao.global.handler",
        "com.wangcaitao.provider"
})
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
