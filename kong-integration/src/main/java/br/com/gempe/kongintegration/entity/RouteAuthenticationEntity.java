package br.com.gempe.kongintegration.entity;

import java.io.Serializable;
import java.util.Objects;

public class RouteAuthenticationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public RouteAuthenticationEntity() {
    }

    public RouteAuthenticationEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteAuthenticationEntity that = (RouteAuthenticationEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "RouteAuthentication{" +
                "name='" + name + '\'' +
                '}';
    }

}