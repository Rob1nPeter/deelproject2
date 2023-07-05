package com.example.demo1.Query;



public class StringToStringStrategy implements QueryResolutionStrategy<String,String>{
    @Override
    public QueryResolutionResult<String> resolve(QueryResolutionForm<String> form) {
        String queryData = form.getQueryData();
        String resolvedData;

        // Perform the query resolution logic based on your custom implementation
        if(queryData.equals("hallo")){
            resolvedData = "Hey";
        } else{
            resolvedData = "Wat bedoel je " + queryData + "?";
        }

        // Return the query resolution result
        return new QueryResolutionResult<>(resolvedData);
    }
}
