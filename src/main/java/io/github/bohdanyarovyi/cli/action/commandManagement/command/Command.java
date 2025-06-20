package io.github.bohdanyarovyi.cli.action.commandManagement.command;

import io.github.bohdanyarovyi.cli.action.Inputable;
import io.github.bohdanyarovyi.cli.action.commandManagement.CommandRegister;
import io.github.bohdanyarovyi.cli.context.AppContext;
import io.github.bohdanyarovyi.cli.menu.Menu;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The abstract class defines a command.
 * <p>
 *     Command assigned for console operation, like ('/back', '/exit' etc).
 * </p>
 * The framework provides a few build-in commands:
 * <ul>
 *     <li>{@link BackCommand}</li>
 *     <li>{@link ExitCommand}</li>
 * </ul>
 * <p>
 *     {@link CommandRegister} manages commands, so to add new command,
 *     you should register it in the {@link CommandRegister} of a specific menu.
 * </p>
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public abstract class Command implements Inputable {
    /**
     * Application context for component access possibility.
     */
    private AppContext appContext;

    /**
     * Default constructor
     */
    public Command() {}

    /**
     * Executes the logic of a console command.
     * @param menu the menu where the command was invoked
     * @param args args optional arguments provided by the user, separated by commas
     */
    public abstract void execute(Menu menu, String[] args);

    /**
     * Checks if the user input matches the command pattern.
     * <p>
     *     Useful for determining whether the user intended to call this command,
     *     even if arguments are also present.
     * </p>
     *
     * @param input the user input
     * @return {@code true} if the patter matches; {@code false} otherwise.
     */
    public boolean isCommandMatches(String input) {
        return input.matches("^" + Pattern.quote(getPattern()) + "(\\s+.*)?$");
    }

    public void setAppContext(AppContext appContext) {
        this.appContext = appContext;
    }

    public AppContext getAppContext() {
        return this.appContext;
    };

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Command other)) return false;

        return Objects.equals(getPattern(), other.getPattern());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPattern());
    }

}
