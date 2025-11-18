package com.cjbdevlabs;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import jakarta.inject.Named;

import java.util.Map;

@Named("myLambdaHandler")
public class MyLambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        // Extract query string parameters
        Map<String, String> qs = event.getQueryStringParameters();
        String foo = null;
        if (qs != null) {
            foo = qs.get("foo");  // e.g. ?foo=bar
        }

        // Do something with foo

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(200);
        response.setBody("Received foo = " + foo);
        return response;
    }
}
