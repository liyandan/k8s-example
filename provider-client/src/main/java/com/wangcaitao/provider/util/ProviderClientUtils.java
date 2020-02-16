package com.wangcaitao.provider.util;

import com.wangcaitao.provider.client.ProviderClient;
import com.wangcaitao.starter.service.ServiceInternalEndpointConstant;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * @author wangcaitao
 */
public class ProviderClientUtils {

    /**
     * ProviderClient
     */
    public static ProviderClient PROVIDER_CLIENT = Feign.builder()
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .target(ProviderClient.class, ServiceInternalEndpointConstant.PROVIDER_SERVICE);
}
