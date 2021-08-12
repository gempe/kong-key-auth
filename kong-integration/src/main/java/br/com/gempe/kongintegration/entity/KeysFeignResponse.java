package br.com.gempe.kongintegration.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class KeysFeignResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<KeyAuthenticationEntity> data;

    public KeysFeignResponse() {
    }

    public KeysFeignResponse(List<KeyAuthenticationEntity> data) {
        this.data = data;
    }

    public List<KeyAuthenticationEntity> getData() {
        return data;
    }

    public void setData(List<KeyAuthenticationEntity> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeysFeignResponse that = (KeysFeignResponse) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "KeysFeignResponse{" +
                "data=" + data +
                '}';
    }

}