package com.example.demo1.Query;

import java.io.File;


public class FileToStringStrategy implements QueryResolutionStrategy<File, String>{
    @Override
    public QueryResolutionResult<String> resolve(QueryResolutionForm<File> form) {
        File queryData = form.getQueryData();

        // Perform the query resolution logic based on your custom implementation
        String resolvedData;
        if (queryData.getName().endsWith(".png")) {
            resolvedData = "Mooie png";
        } else {
            resolvedData = queryData + queryData.getName();
        }

        // Return the query resolution result
        return new QueryResolutionResult<>(resolvedData);
    }

}
