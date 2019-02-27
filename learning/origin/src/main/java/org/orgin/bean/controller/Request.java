package org.orgin.bean.controller;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.orgin.emnu.RequestMethod;

public class Request {

    private String requestMapping;

    private RequestMethod requestMethod;

    public Request(String requestMapping, RequestMethod requestMethod) {
        this.requestMapping = requestMapping;
        this.requestMethod = requestMethod;
    }

    public String getRequestMapping() {
        return requestMapping;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
