package com.zoroapp.scheduler.scheduling.exceptions;

public class DuplicateJobException extends RuntimeException {

    public DuplicateJobException() {
        super();
    }

    public DuplicateJobException(String message) {
        super(message);
    }
}
