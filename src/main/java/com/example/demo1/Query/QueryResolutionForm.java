package com.example.demo1.Query;

import java.io.Serializable;

public class QueryResolutionForm<T> implements Serializable {
    private T queryData;
    public QueryResolutionForm(T queryData) {
        this.queryData = queryData;
    }
    public T getQueryData() {
        return queryData;
    }
}
