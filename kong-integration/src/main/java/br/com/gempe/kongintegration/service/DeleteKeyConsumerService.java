package br.com.gempe.kongintegration.service;

import br.com.gempe.kongintegration.dataprovider.CreateConsumerDataProvider;
import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.service.exception.ServiceException;
import br.com.gempe.kongintegration.util.ExceptionMessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteKeyConsumerService {

    private final CreateConsumerDataProvider createConsumerDataProvider;

    @Autowired
    public DeleteKeyConsumerService(CreateConsumerDataProvider createConsumerDataProvider){
        this.createConsumerDataProvider = createConsumerDataProvider;
    }

    public void execute(String consumer, String key){
        try{
            this.createConsumerDataProvider.deleteKeyConsumer(consumer, key);
        }catch (DataProviderException e){
            throw new ServiceException(ExceptionMessageUtil.ERRO_INTEGRAR_KONG + e.getMessage());
        }
    }

}