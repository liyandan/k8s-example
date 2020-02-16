package com.wangcaitao.provider.entity;

import com.wangcaitao.common.entity.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangcaitao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProviderQuery extends BaseQuery {

    /**
     * name
     */
    private String name;
}
