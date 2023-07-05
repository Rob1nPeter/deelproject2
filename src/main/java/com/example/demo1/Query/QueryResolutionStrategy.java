package com.example.demo1.Query;

public interface QueryResolutionStrategy<T,R> {
    QueryResolutionResult<R> resolve(QueryResolutionForm<T> form);
}
