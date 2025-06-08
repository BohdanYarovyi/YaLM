package io.github.yarovyi.cli.exception;

import io.github.yarovyi.cli.action.operationManagement.OperationRegister;

/**
 * Thrown when a requested operation is not found.
 * <p>
 *     When {@link OperationRegister OperationRegister}
 *     try to find specific operation using pattern from user input, and if not found such operation,
 *     throws this exception.
 * </p>
 *
 * @since 1.0
 * @author Bohnda Yarovyi
 */
public class OperationNotFoundException extends RuntimeException {

    public OperationNotFoundException() {
    }

    public OperationNotFoundException(String message) {
        super(message);
    }

    public OperationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationNotFoundException(Throwable cause) {
        super(cause);
    }

    public OperationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
