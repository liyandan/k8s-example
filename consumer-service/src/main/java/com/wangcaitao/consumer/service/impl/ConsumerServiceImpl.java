package com.wangcaitao.consumer.service.impl;

import com.wangcaitao.common.entity.Result;
import com.wangcaitao.common.util.ResultUtils;
import com.wangcaitao.consumer.entity.ConsumerBO;
import com.wangcaitao.consumer.entity.ConsumerQuery;
import com.wangcaitao.consumer.entity.ConsumerSaveDTO;
import com.wangcaitao.consumer.entity.ConsumerUpdateDTO;
import com.wangcaitao.consumer.service.ConsumerService;
import com.wangcaitao.provider.entity.ProviderBO;
import com.wangcaitao.provider.entity.ProviderQuery;
import com.wangcaitao.provider.entity.ProviderSaveDTO;
import com.wangcaitao.provider.entity.ProviderUpdateDTO;
import com.wangcaitao.provider.util.ProviderClientUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcaitao
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public Result<ConsumerBO> getById(Long id) {
        ConsumerBO consumerBo = new ConsumerBO();
        consumerBo.setId(id);

        ProviderBO providerBo = ResultUtils.getData(ProviderClientUtils.PROVIDER_CLIENT.getById(id));

        consumerBo.setProviderName(providerBo.getName());

        return ResultUtils.success(consumerBo);
    }

    @Override
    public Result<List<ConsumerBO>> list(ConsumerQuery query) {
        ProviderQuery providerQuery = new ProviderQuery();
        BeanUtils.copyProperties(query, providerQuery);
        providerQuery.setName(query.getProviderName());

        List<ProviderBO> providerBos = ResultUtils.getData(ProviderClientUtils.PROVIDER_CLIENT.list(providerQuery));
        List<ConsumerBO> consumerBos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(providerBos)) {
            providerBos.forEach(providerBo -> {
                ConsumerBO consumerBo = new ConsumerBO();
                consumerBo.setId(providerBo.getId());
                consumerBo.setProviderName(providerBo.getName());

                consumerBos.add(consumerBo);
            });
        }

        return ResultUtils.success(consumerBos);
    }

    @Override
    public Result<Serializable> save(ConsumerSaveDTO entity) {
        ProviderSaveDTO providerSaveDto = new ProviderSaveDTO();
        providerSaveDto.setName(entity.getProviderName());

        return ProviderClientUtils.PROVIDER_CLIENT.save(providerSaveDto);
    }

    @Override
    public Result<Serializable> save(List<ConsumerSaveDTO> entities) {
        List<ProviderSaveDTO> providerSaveDtos = new ArrayList<>();
        entities.forEach(entity -> {
            ProviderSaveDTO providerSaveDto = new ProviderSaveDTO();
            providerSaveDto.setName(entity.getProviderName());

            providerSaveDtos.add(providerSaveDto);
        });

        return ProviderClientUtils.PROVIDER_CLIENT.save(providerSaveDtos);
    }

    @Override
    public Result<Serializable> update(ConsumerUpdateDTO entity) {
        ProviderUpdateDTO providerUpdateDto = new ProviderUpdateDTO();
        providerUpdateDto.setId(entity.getId());
        providerUpdateDto.setName(entity.getProviderName());

        return ProviderClientUtils.PROVIDER_CLIENT.update(providerUpdateDto);
    }

    @Override
    public Result<Serializable> update(List<ConsumerUpdateDTO> entities) {
        List<ProviderUpdateDTO> providerUpdateDtos = new ArrayList<>();
        entities.forEach(entity -> {
            ProviderUpdateDTO providerUpdateDto = new ProviderUpdateDTO();
            providerUpdateDto.setId(entity.getId());
            providerUpdateDto.setName(entity.getProviderName());

            providerUpdateDtos.add(providerUpdateDto);
        });

        return ProviderClientUtils.PROVIDER_CLIENT.update(providerUpdateDtos);
    }

    @Override
    public Result<Serializable> delete(Long id) {
        return ProviderClientUtils.PROVIDER_CLIENT.delete(id);
    }

    @Override
    public Result<Serializable> delete(List<Long> ids) {
        return ProviderClientUtils.PROVIDER_CLIENT.delete(ids);
    }
}
