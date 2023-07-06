package com.example.demo1.Query;

import java.io.File;


public class FileToStringStrategy implements QueryResolutionStrategy<File, String>{
    @Override
    public QueryResolutionResult<String> resolve(QueryResolutionForm<File> form) {
        File queryData = form.getQueryData();
        String resolvedData;

        // Perform the query resolution logic based on your custom implementation
        if (queryData.getName().endsWith(".PNG")) {
            resolvedData = "Mooie png";
        } else {
            resolvedData = queryData + queryData.getName();
        }

        // Return the query resolution result
        return new QueryResolutionResult<>(resolvedData);
    }
}
