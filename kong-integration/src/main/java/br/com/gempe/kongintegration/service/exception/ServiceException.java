package br.com.gempe.kongintegration.service.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String message){
        super(message);
    }
}
