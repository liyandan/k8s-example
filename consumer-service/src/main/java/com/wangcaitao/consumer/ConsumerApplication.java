package com.wangcaitao.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangcaitao
 */
@SpringBootApplication(scanBasePackages = {
        "com.wangcaitao.global.handler",
        "com.wangcaitao.consumer",
        "com.wangcaitao.starter"
})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
