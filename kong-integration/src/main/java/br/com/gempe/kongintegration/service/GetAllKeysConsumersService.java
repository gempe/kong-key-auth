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
public class GetAllKeysConsumersService {

    private final CreateConsumerDataProvider createConsumerDataProvider;

    @Autowired
    public GetAllKeysConsumersService(CreateConsumerDataProvider createConsumerDataProvider){
        this.createConsumerDataProvider = createConsumerDataProvider;
    }

    public List<KeyAuthenticationEntity> execute(){
        try{
            return this.createConsumerDataProvider.getAllKeysConsumers();
        }catch (DataProviderException e){
            throw new ServiceException(ExceptionMessageUtil.ERRO_INTEGRAR_KONG + e.getMessage());
        }
    }

}