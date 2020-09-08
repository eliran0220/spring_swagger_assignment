package com.example.SwaggerApiExposer.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.SwaggerApiExposer.Etc.Constants.*;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends Exception {
    private static final long code = ITEM_NOT_FOUND_CODE;

    public ItemNotFoundException() {
        super(ITEM_NOT_FOUND_MSG);
    }
}
