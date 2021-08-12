package br.com.gempe.kongintegration.entity;

import java.io.Serializable;
import java.util.Objects;

public class KeyAuthenticationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private ConsumerEntity consumer;

    private String key;

    public KeyAuthenticationEntity(){
    }

    public KeyAuthenticationEntity(String id, ConsumerEntity consumer, String key) {
        this.id = id;
        this.consumer = consumer;
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConsumerEntity getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerEntity consumer) {
        this.consumer = consumer;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyAuthenticationEntity that = (KeyAuthenticationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(consumer, that.consumer) && Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, consumer, key);
    }

    @Override
    public String toString() {
        return "KeyAuthenticationEntity{" +
                "id='" + id + '\'' +
                ", consumer=" + consumer +
                ", key='" + key + '\'' +
                '}';
    }

}