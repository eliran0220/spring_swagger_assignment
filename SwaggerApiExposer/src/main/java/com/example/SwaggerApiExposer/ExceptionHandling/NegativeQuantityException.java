package com.example.SwaggerApiExposer.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import static com.example.SwaggerApiExposer.Etc.Constants.*;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegativeQuantityException extends Exception {
    private static final long code = NEGATIVE_WINDRAW_CODE;

    public NegativeQuantityException() {
        super(NEGATIVE_QUANTITY_MSG);
    }
}
