package br.com.gempe.kongintegration.dataprovider.feign;

import br.com.gempe.kongintegration.entity.ConsumerPayLoadEntity;
import br.com.gempe.kongintegration.entity.CreateAuthenticationEntity;

import br.com.gempe.kongintegration.entity.KeysFeignResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "kongIntegration", url = "${kong.client.host}")
public interface CreateConsumerFeign {

    @PostMapping(value = "/consumers", consumes = "application/json")
    void createConsumer(@RequestBody ConsumerPayLoadEntity consumer);

    @PostMapping(value = "/plugins", consumes = "application/json")
    void createAuthentication(@RequestBody CreateAuthenticationEntity createAuthentication);

    @PostMapping(value = "/consumers/{consumer}/key-auth")
    void createKeyConsumer(@PathVariable("consumer") String consumer);

    @DeleteMapping(value = "/consumers/{consumer}/key-auth/{key}")
    void deleteKeyConsumer(@PathVariable("consumer") String consumer, @PathVariable("key") String key);

    @GetMapping(value = "/consumers/{consumer}/key-auth")
    KeysFeignResponse getKeyConsumer(@PathVariable("consumer") String consumer);

    @GetMapping(value = "/key-auths")
    KeysFeignResponse getAllKeysConsumers();
}