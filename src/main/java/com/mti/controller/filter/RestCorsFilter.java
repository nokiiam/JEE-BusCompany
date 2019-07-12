package com.mti.controller.filter;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RestCorsFilter implements ContainerResponseFilter, ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) {
        requestContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        requestContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        requestContext.getHeaders().putSingle("Access-Control-Allow-Headers", "content-type");
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "content-type");
        response.getHeaders().putSingle("X-Powered-By", "EPITA.");
    }

}
