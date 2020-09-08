package com.example.SwaggerApiExposer.ExceptionHandling;

import java.util.Date;

/*
 * This class acts as an error class which holds the information
 * that will be sent back from the database.
 */
public class Error {
    private Date timestamp;
    private String message;
    private String details;

    public Error(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
