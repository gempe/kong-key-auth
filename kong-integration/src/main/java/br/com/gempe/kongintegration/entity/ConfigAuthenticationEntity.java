package br.com.gempe.kongintegration.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ConfigAuthenticationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("key_names")
    private List<String> keyNames;

    @JsonProperty("key_in_header")
    private Boolean keiInHeader;

    @JsonProperty("key_in_query")
    private Boolean keyInQuery;

    @JsonProperty("key_in_body")
    private Boolean keiInBody;

    public ConfigAuthenticationEntity(){
    }

    public ConfigAuthenticationEntity(List<String> keyNames, Boolean keiInHeader, Boolean keyInQuery, Boolean keiInBody) {
        this.keyNames = keyNames;
        this.keiInHeader = keiInHeader;
        this.keyInQuery = keyInQuery;
        this.keiInBody = keiInBody;
    }

    public List<String> getKeyNames() {
        return keyNames;
    }

    public void setKeyNames(List<String> keyNames) {
        this.keyNames = keyNames;
    }

    public Boolean getKeiInHeader() {
        return keiInHeader;
    }

    public void setKeiInHeader(Boolean keiInHeader) {
        this.keiInHeader = keiInHeader;
    }

    public Boolean getKeyInQuery() {
        return keyInQuery;
    }

    public void setKeyInQuery(Boolean keyInQuery) {
        this.keyInQuery = keyInQuery;
    }

    public Boolean getKeiInBody() {
        return keiInBody;
    }

    public void setKeiInBody(Boolean keiInBody) {
        this.keiInBody = keiInBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigAuthenticationEntity that = (ConfigAuthenticationEntity) o;
        return Objects.equals(keyNames, that.keyNames) && Objects.equals(keiInHeader, that.keiInHeader) && Objects.equals(keyInQuery, that.keyInQuery) && Objects.equals(keiInBody, that.keiInBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyNames, keiInHeader, keyInQuery, keiInBody);
    }

    @Override
    public String toString() {
        return "ConfigAuthentication{" +
                "keyNames=" + keyNames +
                ", keiInHeader=" + keiInHeader +
                ", keyInQuery=" + keyInQuery +
                ", keiInBody=" + keiInBody +
                '}';
    }

}