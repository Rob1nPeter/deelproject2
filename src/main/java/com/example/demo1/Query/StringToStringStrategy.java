package com.example.demo1.Query;


import java.util.ResourceBundle;

import static com.example.demo1.Logica.TaalLogica.taal;

public class StringToStringStrategy implements QueryResolutionStrategy<String,String>{
    @Override
    public QueryResolutionResult<String> resolve(QueryResolutionForm<String> form) {
        String queryData = form.getQueryData();
        String resolvedData;

        // Perform the query resolution logic based on your custom implementation
        if(queryData.equals("hallo")){
            resolvedData = "Bot: Hey";
        } else{
            resolvedData = translate("bot") + ": " + queryData + "?";
        }



        // Return the query resolution result
        return new QueryResolutionResult<>(resolvedData);
    }
    protected String translate(String bundleKey){
        ResourceBundle bundle = ResourceBundle.getBundle(taal());
        return bundle.getString(bundleKey);
    }
}
