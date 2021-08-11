package br.com.gempe.kongintegration.service;

import br.com.gempe.kongintegration.dataprovider.CreateConsumerDataProvider;
import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteKeyConsumerService {

    private CreateConsumerDataProvider createConsumerDataProvider;

    @Autowired
    public void DeleteKeyConsumerService(CreateConsumerDataProvider createConsumerDataProvider){
        this.createConsumerDataProvider = createConsumerDataProvider;
    }

    public void execute(String consumer, String key){
        try{
            this.createConsumerDataProvider.deleteKeyConsumer(consumer, key);
        }catch (DataProviderException e){
            throw new ServiceException("Foi retornado um erro ao realizar integração com o Kong");
        }
    }

}