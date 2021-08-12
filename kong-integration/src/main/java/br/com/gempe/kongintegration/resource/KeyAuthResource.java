package br.com.gempe.kongintegration.resource;

import br.com.gempe.kongintegration.entity.ConsumerPayLoadEntity;
import br.com.gempe.kongintegration.entity.CreateAuthenticationEntity;
import br.com.gempe.kongintegration.entity.KeyAuthenticationEntity;
import br.com.gempe.kongintegration.service.*;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/kong/services")
public class KeyAuthResource {

    private final CreateConsumerService createConsumerService;
    private final CreateAuthenticationService createAuthenticationService;
    private final CreateKeyConsumerService createKeyConsumerService;
    private final DeleteKeyConsumerService deleteKeyConsumerService;
    private final GetKeyConsumerService getKeyConsumerService;
    private final GetAllKeysConsumersService getAllKeysConsumersService;

    @Autowired
    public KeyAuthResource(CreateConsumerService createConsumerService,
                           CreateAuthenticationService createAuthenticationService,
                           CreateKeyConsumerService createKeyConsumerService,
                           DeleteKeyConsumerService deleteKeyConsumerService,
                           GetKeyConsumerService getKeyConsumerService,
                           GetAllKeysConsumersService getAllKeysConsumersService){
        this.createConsumerService = createConsumerService;
        this.createAuthenticationService = createAuthenticationService;
        this.createKeyConsumerService = createKeyConsumerService;
        this.deleteKeyConsumerService = deleteKeyConsumerService;
        this.getKeyConsumerService = getKeyConsumerService;
        this.getAllKeysConsumersService = getAllKeysConsumersService;
    }

    @ApiOperation(value = "Responsável por criar um consumidor")
    @PostMapping(path = "/create-consumers")
    public ResponseEntity<Void> createConsumer(@RequestBody ConsumerPayLoadEntity consumer){
        this.createConsumerService.execute(consumer);
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

    @ApiOperation(value = "Responsável por buscar chaves de autenticação de um consumidor")
    @GetMapping("/get-key-consumers/{consumer}")
    public ResponseEntity<List<KeyAuthenticationEntity>> getKeysConsumer(@PathVariable(value = "consumer", required = false) String consumer){
        List<KeyAuthenticationEntity> keysAuthentication = this.getKeyConsumerService.execute(consumer);
        if (keysAuthentication == null || keysAuthentication.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(keysAuthentication);
    }

    @ApiOperation(value = "Responsável por buscar chaves de autenticação de todos consumidores")
    @GetMapping("/get-key-consumers")
    public ResponseEntity<List<KeyAuthenticationEntity>> getAllKeysConsumers(){
        List<KeyAuthenticationEntity> keysAuthentication = this.getAllKeysConsumersService.execute();
        if (keysAuthentication == null || keysAuthentication.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(keysAuthentication);
    }

}