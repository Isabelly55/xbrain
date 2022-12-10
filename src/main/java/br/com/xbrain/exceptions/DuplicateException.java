package br.com.xbrain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateException  extends  RuntimeException {
    public DuplicateException(String message) {
        super(message);
    }
}