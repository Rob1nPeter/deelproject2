package com.example.demo1.Query;

import java.io.Serializable;

public class QueryResolutionResult<T> implements Serializable {
    private final T resultData;

    public QueryResolutionResult(T resultData) {
        this.resultData = resultData;
    }

    public T getData() {
        return resultData;
    }

}
