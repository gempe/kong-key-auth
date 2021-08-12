package br.com.gempe.kongintegration.service;

import br.com.gempe.kongintegration.dataprovider.CreateConsumerDataProvider;
import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.entity.KeyAuthenticationEntity;
import br.com.gempe.kongintegration.service.exception.ServiceException;
import br.com.gempe.kongintegration.util.ExceptionMessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetKeyConsumerService {

    private final CreateConsumerDataProvider createConsumerDataProvider;

    @Autowired
    public GetKeyConsumerService(CreateConsumerDataProvider createConsumerDataProvider){
        this.createConsumerDataProvider = createConsumerDataProvider;
    }

    public List<KeyAuthenticationEntity> execute(String consumer){
        try{
            return this.createConsumerDataProvider.getKeyConsumer(consumer);
        }catch (DataProviderException e){
            throw new ServiceException(ExceptionMessageUtil.ERRO_INTEGRAR_KONG + e.getMessage());
        }
    }

}