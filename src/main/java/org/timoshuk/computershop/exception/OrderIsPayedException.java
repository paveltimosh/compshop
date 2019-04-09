package org.timoshuk.computershop.exception;

public class OrderIsPayedException extends RuntimeException {

    public OrderIsPayedException() {
        super();
    }

    public OrderIsPayedException(String message) {
        super(message);
    }

    public OrderIsPayedException(String message, Throwable cause) {
        super(message, cause);
    }
}
