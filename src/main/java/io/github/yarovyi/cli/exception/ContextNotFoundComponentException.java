package io.github.yarovyi.cli.exception;

import io.github.yarovyi.cli.context.AppContext;

/**
 * Throws if not found requested component.
 *
 * @see AppContext AppContext
 * @author Bohdan Yarovyi
 * @since 1.0
 */
public class ContextNotFoundComponentException extends RuntimeException {

    public ContextNotFoundComponentException() {}

    public ContextNotFoundComponentException(String message) {
        super(message);
    }

    public ContextNotFoundComponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContextNotFoundComponentException(Throwable cause) {
        super(cause);
    }

    public ContextNotFoundComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
