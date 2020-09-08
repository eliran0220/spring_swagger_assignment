package com.example.SwaggerApiExposer.ExceptionHandling;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.SwaggerApiExposer.Etc.Constants.*;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ItemExistsException extends Exception {
    private static final long code = ITEM_FOUND_CODE;

    public ItemExistsException() {
        super(ITEM_EXISTS_MSG);
    }
}
