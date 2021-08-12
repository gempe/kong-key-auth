package br.com.gempe.kongintegration.dataprovider;

import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.dataprovider.feign.CreateConsumerFeign;
import br.com.gempe.kongintegration.entity.ConsumerPayLoadEntity;
import br.com.gempe.kongintegration.entity.CreateAuthenticationEntity;
import br.com.gempe.kongintegration.entity.KeyAuthenticationEntity;
import br.com.gempe.kongintegration.entity.KeysFeignResponse;

import feign.FeignException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CreateConsumerDataProvider {

    private CreateConsumerFeign createConsumerFeign;

    @Autowired
    public void CreateConsumerDataProvider(CreateConsumerFeign createConsumerFeign){
        this.createConsumerFeign = createConsumerFeign;
    }

    public void createConsumer(ConsumerPayLoadEntity consumer){
        try{
            //ConsumerPayLoadEntity consumer = new ConsumerPayLoadEntity(username);
            this.createConsumerFeign.createConsumer(consumer);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public void createAuthentication(CreateAuthenticationEntity createAuthentication){
        try{
            this.createConsumerFeign.createAuthentication(createAuthentication);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public void createKeyConsumer(String consumer){
        try{
            this.createConsumerFeign.createKeyConsumer(consumer);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public void deleteKeyConsumer(String consumer, String key) {
        try{
            this.createConsumerFeign.deleteKeyConsumer(consumer, key);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public List<KeyAuthenticationEntity> getKeyConsumer(String consumer) {
        try{
            KeysFeignResponse response = this.createConsumerFeign.getKeyConsumer(consumer);
            return Optional.ofNullable(response).map(KeysFeignResponse::getData).orElse(null);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public List<KeyAuthenticationEntity> getAllKeysConsumers() {
        try{
            KeysFeignResponse response = this.createConsumerFeign.getAllKeysConsumers();
            return Optional.ofNullable(response).map(KeysFeignResponse::getData).orElse(null);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }
}