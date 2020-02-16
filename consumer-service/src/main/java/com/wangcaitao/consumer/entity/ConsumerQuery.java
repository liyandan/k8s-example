package com.wangcaitao.consumer.entity;

import com.wangcaitao.common.entity.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangcaitao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ConsumerQuery extends BaseQuery {

    /**
     * provider name
     */
    private String providerName;
}
