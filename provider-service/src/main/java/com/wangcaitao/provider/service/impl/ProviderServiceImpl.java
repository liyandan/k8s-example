package com.wangcaitao.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wangcaitao.common.entity.Result;
import com.wangcaitao.common.util.ResultUtils;
import com.wangcaitao.provider.entity.ProviderBO;
import com.wangcaitao.provider.entity.ProviderQuery;
import com.wangcaitao.provider.entity.ProviderSaveDTO;
import com.wangcaitao.provider.entity.ProviderUpdateDTO;
import com.wangcaitao.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcaitao
 */
@Service
@Slf4j
public class ProviderServiceImpl implements ProviderService {

    @Override
    public Result<ProviderBO> getById(Long id) {
        ProviderBO providerBo = new ProviderBO();
        providerBo.setId(id);
        providerBo.setName("provider");

        return ResultUtils.success(providerBo);
    }

    @Override
    public Result<List<ProviderBO>> list(ProviderQuery query) {
        log.info("查询参数: {}", JSONObject.toJSONString(query));
        List<ProviderBO> providerBos = new ArrayList<>();

        ProviderBO providerBo = new ProviderBO();
        providerBo.setId(1L);
        providerBo.setName("provider");

        providerBos.add(providerBo);

        return ResultUtils.success(providerBos);
    }

    @Override
    public Result<Serializable> save(ProviderSaveDTO entity) {
        log.info("保存参数: {}", JSONObject.toJSONString(entity));

        return ResultUtils.success();
    }

    @Override
    public Result<Serializable> save(List<ProviderSaveDTO> entities) {
        log.info("批量保存参数: {}", JSONObject.toJSONString(entities));

        return ResultUtils.success();
    }

    @Override
    public Result<Serializable> update(ProviderUpdateDTO entity) {
        log.info("修改参数: {}", JSONObject.toJSONString(entity));

        return ResultUtils.success();
    }

    @Override
    public Result<Serializable> update(List<ProviderUpdateDTO> entities) {
        log.info("批量修改参数: {}", JSONObject.toJSONString(entities));

        return ResultUtils.success();
    }

    @Override
    public Result<Serializable> delete(Long id) {
        log.info("删除 id: {}", id);

        return ResultUtils.success();
    }

    @Override
    public Result<Serializable> delete(List<Long> ids) {
        log.info("删除 ids: {}", JSONObject.toJSONString(ids));

        return ResultUtils.success();
    }
}
