package io.github.bohdanyarovyi.cli.menu.handler.inputInterpreter;

import io.github.bohdanyarovyi.cli.action.Inputable;
import io.github.bohdanyarovyi.cli.action.operationManagement.Operation;
import io.github.bohdanyarovyi.cli.action.operationManagement.OperationRegister;
import io.github.bohdanyarovyi.cli.menu.Menu;

/**
 * A default interpreter for domain based operation like "/addWorkout" or "/doSomething".
 * <p>
 *     This interpreter recognize and execute already registered operation
 *     in menu through provided user input.
 * </p>
 *
 * @see Operation
 * @see Interpreter
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public class OperationInterpreter implements Interpreter {

    /**
     * Check whether the user input matches a registered operation in the current menu.
     * <p>
     *     Uses {@link OperationRegister} from the given menu to verify if the input
     *     corresponds to a known command.
     * </p>
     *
     * @return {@code true} if the input is a valid operation; {@code false} otherwise.
     */
    @Override
    public boolean canInterpret(String input, Menu menu) {
        return menu.getOperationRegister().isRegistered(input);
    }

    /**
     * Execute command by user input.
     * <p>
     *     Determines using {@link OperationRegister} from {@link Menu} and calls command
     *     by passing arguments from user input parsed by {@link #getArgs(Inputable, String)}.
     * </p>
     */
    @Override
    public void interpret(String input, Menu menu) {
        OperationRegister operationRegister = menu.getOperationRegister();
        Operation operation = operationRegister.getOperation(input);

        String[] args = getArgs(operation, input);
        operation.doOperation(args);
    }

}
