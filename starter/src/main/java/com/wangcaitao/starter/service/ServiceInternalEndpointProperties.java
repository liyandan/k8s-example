package com.wangcaitao.starter.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wangcaitao
 */
@Component
@ConfigurationProperties(prefix = "k8s.service.internal-endpoint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInternalEndpointProperties {

    /**
     * provider-service
     */
    private String providerService;

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        ServiceInternalEndpointConstant.PROVIDER_SERVICE = providerService;
    }
}
