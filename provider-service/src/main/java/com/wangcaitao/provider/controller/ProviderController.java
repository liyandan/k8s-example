package com.wangcaitao.provider.controller;

import com.wangcaitao.common.entity.Result;
import com.wangcaitao.provider.client.ProviderClient;
import com.wangcaitao.provider.entity.ProviderBO;
import com.wangcaitao.provider.entity.ProviderQuery;
import com.wangcaitao.provider.entity.ProviderSaveDTO;
import com.wangcaitao.provider.entity.ProviderUpdateDTO;
import com.wangcaitao.provider.service.ProviderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author wangcaitao
 */
@RestController
@RequestMapping(value = "/provider")
public class ProviderController implements ProviderClient {

    @Resource
    private ProviderService providerService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Result<ProviderBO> getById(@PathVariable(value = "id") Long id) {
        return providerService.getById(id);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Result<List<ProviderBO>> list(ProviderQuery query) {
        return providerService.list(query);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Result<Serializable> save(@RequestBody ProviderSaveDTO entity) {
        return providerService.save(entity);
    }

    @PostMapping(value = "/batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Result<Serializable> save(@RequestBody List<ProviderSaveDTO> entities) {
        return providerService.save(entities);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Result<Serializable> update(@RequestBody ProviderUpdateDTO entity) {
        return providerService.update(entity);
    }

    @PutMapping(value = "/batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Result<Serializable> update(@RequestBody List<ProviderUpdateDTO> entity) {
        return providerService.update(entity);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Result<Serializable> delete(@PathVariable(value = "id") Long id) {
        return providerService.delete(id);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Result<Serializable> delete(@RequestBody List<Long> ids) {
        return providerService.delete(ids);
    }
}
