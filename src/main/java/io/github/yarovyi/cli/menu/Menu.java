package io.github.yarovyi.cli.menu;

import io.github.yarovyi.cli.action.commandManagement.CommandRegister;
import io.github.yarovyi.cli.action.operationManagement.OperationRegister;
import io.github.yarovyi.cli.menu.handler.MenuHandler;
import io.github.yarovyi.cli.view.DefaultViewTemplates;

import java.util.List;

import static io.github.yarovyi.cli.view.DefaultViewTemplates.*;

/**
 * <p>
 * Interface for describing menu.
 * </p>
 * <p>
 * The menu starts and runs until {@link #isRunning()} is false.
 * Each iteration prints the submenus, commands, and operations
 * that are available for selection to the console.
 * </p>
 * <p>
 * For printing menu uses prepared templates in {@link DefaultViewTemplates DefaultViewTemplates}
 * </p>
 * <p>
 * The menu has a {@link MenuHandler} to handle user input in the current menu.
 * </p>
 *
 * @author Bohdan Yarovyi
 * @see SimpleMenu
 * @see OperationRegister
 * @see CommandRegister
 * @see DefaultViewTemplates DefaultViewTemplates
 * @since 1.0
 */
public interface Menu {

    /**
     * <p>
     * Method that provides the basic mechanics of the menu.
     * </p>
     * <p>
     * Starts a loop that repeatedly displays the menu and handles user input until the menu is stopped.
     * Each iteration it prints menu and {@link MenuHandler handler} ask user for input.
     * </p>
     */
    default void startMenu() {
        MenuHandler menuHandler = getMenuHandler();

        while (isRunning()) {
            printMenu();
            menuHandler.handleMenu(this);
            PRINT_CONSOLE_SEPARATOR.run();
        }
    }

    /**
     * <p>
     *     Method prints menu uses constants from {@link DefaultViewTemplates DefaultViewTemplates}.
     * </p>
     * <p>
     *     For prints templates method should provide:
     *     <ul>
     *         <li>menuName</li>
     *         <li>submenus</li>
     *         <li>operationRegister</li>
     *         <li>commandRegister</li>
     *     </ul>
     * </p>
     */
    default void printMenu() {
        PRINT_MENU_TITLE.accept(getMenuName());
        PRINT_LIST_OF_SUBMENUS.accept(getSubmenus());
        PRINT_LIST_OF_OPERATIONS.accept(getOperationRegister());
        PRINT_LIST_OF_COMMANDS.accept(getCommandRegister());
    }

    boolean isRunning();

    void setRunning(boolean running);

    String getMenuName();

    MenuHandler getMenuHandler();

    OperationRegister getOperationRegister();

    CommandRegister getCommandRegister();

    List<Menu> getSubmenus();

    /**
     * Method allow to add submenu to this menu
     * @param menu object that implements {@link Menu} and will like submenu inside this
     */
    void addSubmenu(Menu menu);

}
