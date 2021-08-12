package br.com.gempe.kongintegration.dataprovider;

import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.dataprovider.feign.KongIntegrationFeign;
import br.com.gempe.kongintegration.entity.ConsumerPayLoadEntity;
import br.com.gempe.kongintegration.entity.CreateAuthenticationEntity;
import br.com.gempe.kongintegration.entity.KeyAuthenticationEntity;
import br.com.gempe.kongintegration.entity.KeysFeignResponse;

import feign.FeignException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class KongIntegrationDataProvider {

    private KongIntegrationFeign kongIntegrationFeign;

    @Autowired
    public void CreateConsumerDataProvider(KongIntegrationFeign kongIntegrationFeign){
        this.kongIntegrationFeign = kongIntegrationFeign;
    }

    public void createConsumer(ConsumerPayLoadEntity consumer){
        try{
            //ConsumerPayLoadEntity consumer = new ConsumerPayLoadEntity(username);
            this.kongIntegrationFeign.createConsumer(consumer);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public void createAuthentication(CreateAuthenticationEntity createAuthentication){
        try{
            this.kongIntegrationFeign.createAuthentication(createAuthentication);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public void createKeyConsumer(String consumer){
        try{
            this.kongIntegrationFeign.createKeyConsumer(consumer);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public void deleteKeyConsumer(String consumer, String key) {
        try{
            this.kongIntegrationFeign.deleteKeyConsumer(consumer, key);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public List<KeyAuthenticationEntity> getKeyConsumer(String consumer) {
        try{
            KeysFeignResponse response = this.kongIntegrationFeign.getKeyConsumer(consumer);
            return Optional.ofNullable(response).map(KeysFeignResponse::getData).orElse(null);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }

    public List<KeyAuthenticationEntity> getAllKeysConsumers() {
        try{
            KeysFeignResponse response = this.kongIntegrationFeign.getAllKeysConsumers();
            return Optional.ofNullable(response).map(KeysFeignResponse::getData).orElse(null);
        }catch (FeignException e){
            throw new DataProviderException(e.getMessage());
        }
    }
}