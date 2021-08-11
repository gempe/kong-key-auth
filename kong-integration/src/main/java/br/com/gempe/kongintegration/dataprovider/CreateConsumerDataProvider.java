package br.com.gempe.kongintegration.dataprovider;

import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.dataprovider.feign.CreateConsumerFeign;
import br.com.gempe.kongintegration.entity.CreateAuthenticationEntity;

import feign.FeignException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateConsumerDataProvider {

    private CreateConsumerFeign createConsumerFeign;

    @Autowired
    public void CreateConsumerDataProvider(CreateConsumerFeign createConsumerFeign){
        this.createConsumerFeign = createConsumerFeign;
    }

    public void createConsumer(String username){
        try{
            this.createConsumerFeign.createConsumer(username);
        }catch (FeignException e){
            throw new DataProviderException("Ocorreu um erro ao requisitar o serviço do Kong");
        }
    }

    public void createAuthentication(CreateAuthenticationEntity createAuthentication){
        try{
            this.createConsumerFeign.createAuthentication(createAuthentication);
        }catch (FeignException e){
            throw new DataProviderException("Ocorreu um erro ao requisitar o serviço do Kong");
        }
    }

    public void createKeyConsumer(String consumer){
        try{
            this.createConsumerFeign.createKeyConsumer(consumer);
        }catch (FeignException e){
            throw new DataProviderException("Ocorreu um erro ao requisitar o serviço do Kong");
        }
    }

    public void deleteKeyConsumer(String consumer, String key) {
        try{
            this.createConsumerFeign.deleteKeyConsumer(consumer, key);
        }catch (FeignException e){
            throw new DataProviderException("Ocorreu um erro ao requisitar o serviço do Kong");
        }
    }
}