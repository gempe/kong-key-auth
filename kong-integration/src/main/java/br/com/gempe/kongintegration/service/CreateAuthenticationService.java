package br.com.gempe.kongintegration.service;

import br.com.gempe.kongintegration.dataprovider.CreateConsumerDataProvider;
import br.com.gempe.kongintegration.dataprovider.exception.DataProviderException;
import br.com.gempe.kongintegration.entity.CreateAuthenticationEntity;
import br.com.gempe.kongintegration.service.exception.ServiceException;

import br.com.gempe.kongintegration.util.ExceptionMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthenticationService {

    private final CreateConsumerDataProvider createConsumerDataProvider;

    @Autowired
    public CreateAuthenticationService(CreateConsumerDataProvider createConsumerDataProvider){
        this.createConsumerDataProvider = createConsumerDataProvider;
    }

    public void execute(CreateAuthenticationEntity createAuthentication){
        try{
            this.createConsumerDataProvider.createAuthentication(createAuthentication);
        }catch (DataProviderException e){
            throw new ServiceException(ExceptionMessageUtil.ERRO_INTEGRAR_KONG + e.getMessage());
        }
    }

}