package com.wangcaitao.consumer.controller;

import com.wangcaitao.common.entity.Result;
import com.wangcaitao.consumer.entity.ConsumerBO;
import com.wangcaitao.consumer.entity.ConsumerQuery;
import com.wangcaitao.consumer.entity.ConsumerSaveDTO;
import com.wangcaitao.consumer.entity.ConsumerUpdateDTO;
import com.wangcaitao.consumer.service.ConsumerService;
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
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Resource
    private ConsumerService consumerService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<ConsumerBO> getById(@PathVariable(value = "id") Long id) {
        return consumerService.getById(id);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<ConsumerBO>> list(ConsumerQuery query) {
        return consumerService.list(query);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Serializable> save(@RequestBody ConsumerSaveDTO entity) {
        return consumerService.save(entity);
    }

    @PostMapping(value = "/batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Serializable> save(@RequestBody List<ConsumerSaveDTO> entities) {
        return consumerService.save(entities);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Serializable> update(@RequestBody ConsumerUpdateDTO entity) {
        return consumerService.update(entity);
    }

    @PutMapping(value = "/batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Serializable> update(@RequestBody List<ConsumerUpdateDTO> entity) {
        return consumerService.update(entity);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Serializable> delete(@PathVariable(value = "id") Long id) {
        return consumerService.delete(id);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Serializable> delete(@RequestBody List<Long> ids) {
        return consumerService.delete(ids);
    }
}
