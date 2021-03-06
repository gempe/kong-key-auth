package br.com.gempe.kongintegration.entity;

import java.io.Serializable;
import java.util.Objects;

public class ConsumerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    public ConsumerEntity() {
    }

    public ConsumerEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerEntity that = (ConsumerEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ConsumerEntity{" +
                "id='" + id + '\'' +
                '}';
    }

}