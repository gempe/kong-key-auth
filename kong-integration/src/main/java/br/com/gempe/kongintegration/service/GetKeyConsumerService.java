package br.com.gempe.kongintegration.service;

import br.com.gempe.kongintegration.dataprovider.KongIntegrationDataProvider;
import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.entity.KeyAuthenticationEntity;
import br.com.gempe.kongintegration.service.exception.ServiceException;
import br.com.gempe.kongintegration.util.ExceptionMessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetKeyConsumerService {

    private final KongIntegrationDataProvider kongIntegrationDataProvider;

    @Autowired
    public GetKeyConsumerService(KongIntegrationDataProvider kongIntegrationDataProvider){
        this.kongIntegrationDataProvider = kongIntegrationDataProvider;
    }

    public List<KeyAuthenticationEntity> execute(String consumer){
        try{
            return this.kongIntegrationDataProvider.getKeyConsumer(consumer);
        }catch (DataProviderException e){
            throw new ServiceException(ExceptionMessageUtil.ERRO_INTEGRAR_KONG + e.getMessage());
        }
    }

}