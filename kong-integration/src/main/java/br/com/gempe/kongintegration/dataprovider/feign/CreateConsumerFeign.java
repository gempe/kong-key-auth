package br.com.gempe.kongintegration.dataprovider.feign;

import br.com.gempe.kongintegration.entity.CreateAuthenticationEntity;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "kongIntegration", url = "${kong.client.host}")
public interface CreateConsumerFeign {

    @PostMapping(value = "/consumers", consumes = "application/json")
    void createConsumer(@RequestBody String username);

    @PostMapping(value = "/plugins", consumes = "application/json")
    void createAuthentication(@RequestBody CreateAuthenticationEntity createAuthentication);

    @PostMapping(value = "/consumers/{consumer}/key-auth")
    void createKeyConsumer(@PathVariable("consumer") String consumer);

    @DeleteMapping(value = "/consumers/{consumer}/key-auth/{key}")
    void deleteKeyConsumer(@PathVariable("consumer") String consumer, @PathVariable("key") String key);
}