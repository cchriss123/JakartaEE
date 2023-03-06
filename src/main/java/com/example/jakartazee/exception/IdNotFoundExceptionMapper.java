package com.example.jakartazee.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IdNotFoundExceptionMapper implements ExceptionMapper<IdNotFoundException> {
    @Override
    public Response toResponse(IdNotFoundException e) {
        String html = "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>404 Not Found</title>"
                + "<img alt=\"Cat hiding in a box\" src=\"https://httpcats.com/404.jpg\" width=\"200\" height=\"200\"/>"
                + "</head>"
                + "<body>"
                + "<p>" + e.getMessage() + "</p>"
                + "</body>"
                + "</html>";
        return Response.status(404).entity(html).build();
        //return Response.status(404).entity(e.getMessage()).build();
    }
}
