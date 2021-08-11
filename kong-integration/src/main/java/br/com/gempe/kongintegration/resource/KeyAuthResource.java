package br.com.gempe.kongintegration.resource;

import br.com.gempe.kongintegration.entity.CreateAuthenticationEntity;
import br.com.gempe.kongintegration.service.CreateAuthenticationService;
import br.com.gempe.kongintegration.service.CreateConsumerService;
import br.com.gempe.kongintegration.service.CreateKeyConsumerService;
import br.com.gempe.kongintegration.service.DeleteKeyConsumerService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/kong/servicos/")
public class KeyAuthResource {

    private CreateConsumerService createConsumerService;
    private CreateAuthenticationService createAuthenticationService;
    private CreateKeyConsumerService createKeyConsumerService;
    private DeleteKeyConsumerService deleteKeyConsumerService;

    @Autowired
    public void KeyAuthResource(CreateConsumerService createConsumerService,
                                CreateAuthenticationService createAuthenticationService,
                                CreateKeyConsumerService createKeyConsumerService,
                                DeleteKeyConsumerService deleteKeyConsumerService){
        this.createConsumerService = createConsumerService;
        this.createAuthenticationService = createAuthenticationService;
        this.createKeyConsumerService = createKeyConsumerService;
        this.deleteKeyConsumerService = deleteKeyConsumerService;
    }

    @ApiOperation(value = "Responsável por criar um consumidor")
    @PostMapping(path = "/create-consumers")
    public ResponseEntity<Void> createConsumer(@RequestBody String username){
        this.createConsumerService.execute(username);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Responsável por criar validação de autenticação a uma rota")
    @PostMapping(path = "/create-authentication-routes")
    public ResponseEntity<Void> createAuthentication(@RequestBody CreateAuthenticationEntity createAuthentication){
        this.createAuthenticationService.execute(createAuthentication);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Responsável por criar uma key de autenticação a um consumidor")
    @PostMapping(path = "/create-key-consumers/{consumer}")
    public ResponseEntity<Void> createKeyConsumers(@PathVariable String consumer){
        this.createKeyConsumerService.execute(consumer);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Responsável por deletar uma chave de autenticação de um consumidor")
    @DeleteMapping("/delete-key-consumers/{consumer}/key-auth/{key}")
    public ResponseEntity<Void> deleteKeyConsumers(@PathVariable("consumer") String consumer,
                                                   @PathVariable("key") String key){
        this.deleteKeyConsumerService.execute(consumer, key);
        return ResponseEntity.ok().build();
    }

}