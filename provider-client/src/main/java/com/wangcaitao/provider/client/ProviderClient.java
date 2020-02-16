package com.wangcaitao.provider.client;

import com.wangcaitao.common.entity.Result;
import com.wangcaitao.provider.entity.ProviderBO;
import com.wangcaitao.provider.entity.ProviderQuery;
import com.wangcaitao.provider.entity.ProviderSaveDTO;
import com.wangcaitao.provider.entity.ProviderUpdateDTO;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangcaitao
 */
public interface ProviderClient {

    /**
     * 详情
     *
     * @param id id
     * @return Result
     */
    @RequestLine(value = "GET /provider/{id}")
    Result<ProviderBO> getById(@Param(value = "id") Long id);

    /**
     * 列表
     *
     * @param query query
     * @return Result
     */
    @RequestLine(value = "GET /provider")
    Result<List<ProviderBO>> list(@QueryMap ProviderQuery query);

    /**
     * 保存
     *
     * @param entity entity
     * @return Result
     */
    @RequestLine(value = "POST /provider")
    @Headers("Content-Type: application/json")
    Result<Serializable> save(ProviderSaveDTO entity);

    /**
     * 批量保存
     *
     * @param entities entities
     * @return Result
     */
    @RequestLine(value = "POST /provider/batch")
    @Headers("Content-Type: application/json")
    Result<Serializable> save(List<ProviderSaveDTO> entities);

    /**
     * 更新
     *
     * @param entity entity
     * @return Result
     */
    @RequestLine(value = "PUT /provider")
    @Headers("Content-Type: application/json")
    Result<Serializable> update(ProviderUpdateDTO entity);

    /**
     * 批量更新
     *
     * @param entity entity
     * @return Result
     */
    @RequestLine(value = "PUT /provider/batch")
    @Headers("Content-Type: application/json")
    Result<Serializable> update(List<ProviderUpdateDTO> entity);

    /**
     * 删除
     *
     * @param id id
     * @return Result
     */
    @RequestLine(value = "DELETE /provider/{id}")
    Result<Serializable> delete(@Param(value = "id") Long id);

    /**
     * 批量删除
     *
     * @param ids ids
     * @return Result
     */
    @RequestLine(value = "DELETE /provider")
    @Headers("Content-Type: application/json")
    Result<Serializable> delete(List<Long> ids);
}
