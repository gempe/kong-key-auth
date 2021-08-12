package br.com.gempe.kongintegration.service;

import br.com.gempe.kongintegration.dataprovider.KongIntegrationDataProvider;
import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.service.exception.ServiceException;

import br.com.gempe.kongintegration.util.ExceptionMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateKeyConsumerService {

    private final KongIntegrationDataProvider kongIntegrationDataProvider;

    @Autowired
    public CreateKeyConsumerService(KongIntegrationDataProvider kongIntegrationDataProvider){
        this.kongIntegrationDataProvider = kongIntegrationDataProvider;
    }

    public void execute(String consumer){
        try{
            this.kongIntegrationDataProvider.createKeyConsumer(consumer);
        }catch (DataProviderException e){
            throw new ServiceException(ExceptionMessageUtil.ERRO_INTEGRAR_KONG + e.getMessage());
        }
    }

}