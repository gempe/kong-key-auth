package br.com.gempe.kongintegration.entity;

import java.io.Serializable;
import java.util.Objects;

public class ConsumerPayLoadEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    public ConsumerPayLoadEntity() {
    }

    public ConsumerPayLoadEntity(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerPayLoadEntity that = (ConsumerPayLoadEntity) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "ConsumerPayLoadEntity{" +
                "username='" + username + '\'' +
                '}';
    }

}