package br.com.gempe.kongintegration.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class CreateAuthenticationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private ConfigAuthenticationEntity config;

    private RouteAuthenticationEntity routeAuthenticationEntity;

    public CreateAuthenticationEntity() {
    }

    public CreateAuthenticationEntity(String name, ConfigAuthenticationEntity config, RouteAuthenticationEntity routeAuthenticationEntity) {
        this.name = name;
        this.config = config;
        this.routeAuthenticationEntity = routeAuthenticationEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConfigAuthenticationEntity getConfig() {
        return config;
    }

    public void setConfig(ConfigAuthenticationEntity config) {
        this.config = config;
    }

    public RouteAuthenticationEntity getRouteAuthentication() {
        return routeAuthenticationEntity;
    }

    @JsonProperty("route")
    public void setRouteAuthentication(RouteAuthenticationEntity routeAuthenticationEntity) {
        this.routeAuthenticationEntity = routeAuthenticationEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAuthenticationEntity that = (CreateAuthenticationEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(config, that.config) && Objects.equals(routeAuthenticationEntity, that.routeAuthenticationEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, config, routeAuthenticationEntity);
    }

    @Override
    public String toString() {
        return "CreateAuthenticationEntity{" +
                "name='" + name + '\'' +
                ", config=" + config +
                ", routeAuthentication=" + routeAuthenticationEntity +
                '}';
    }

}