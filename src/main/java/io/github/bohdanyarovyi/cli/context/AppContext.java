package io.github.bohdanyarovyi.cli.context;

import io.github.bohdanyarovyi.cli.action.commandManagement.CommandRegister;
import io.github.bohdanyarovyi.cli.action.operationManagement.OperationRegister;
import io.github.bohdanyarovyi.cli.exception.ContextNotFoundComponentException;
import io.github.bohdanyarovyi.cli.menu.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple application context for managing components.
 * <p>
 *      This class provides centralized access to application-level components.
 *      Any component can be registered by name and later retrieved
 *      in key points of program, like
 *     (
 *     eg.,
 *     {@link Menu Menu},
 *     {@link OperationRegister OperationRegister},
 *     {@link CommandRegister CommandRegister}
 *     ).
 * </p>
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public class AppContext {

    /**
     * Stores registered components by their name.
     */
    private final Map<String, Object> components = new HashMap<>();

    /**
     * Default constructor
     */
    public AppContext() {}

    /**
     * Adds component in context.
     *
     * @param name name specific component
     * @param component specific component
     */
    public void addComponent(String name, Object component) {
        this.components.put(name, component);
    }

    /**
     * Allows to get access to registered component in context.
     *
     * @param name the unique name of the component
     * @param type type of required component
     * @param <T>  the generic type of the expected component
     * @return object of the specified type from the context
     * @throws ContextNotFoundComponentException when not found component with such name in the context
     * @throws ClassCastException when found component, but type doesn't match
     */
    public <T> T getComponent(String name, Class<T> type) {
        Object result = components.get(name);

        if (result == null) {
            throw new ContextNotFoundComponentException("Not found component with name " + name + " in context");
        }

        return type.cast(result);
    }

    /**
     * Checks if a component with the given name is registered.
     *
     * @param name the unique name of the component
     * @return {@code true} if context contains component with such name; {@code false} otherwise.
     */
    public boolean containsComponent(String name) {
        return components.containsKey(name);
    }

}
