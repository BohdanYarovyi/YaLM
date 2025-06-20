package io.github.bohdanyarovyi.cli.menu;

import io.github.bohdanyarovyi.cli.action.commandManagement.CommandRegister;
import io.github.bohdanyarovyi.cli.action.operationManagement.OperationRegister;
import io.github.bohdanyarovyi.cli.context.AppContext;
import io.github.bohdanyarovyi.cli.menu.handler.MenuHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Standard implementation of the {@link Menu} interface.
 *
 * <p>
 * This class provides a basic menu structure with a name, submenus,
 * command register, operation register, menu handler, and running state.
 * It does not introduce any new behavior — it simply implements the interface.
 * </p>
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public class SimpleMenu implements Menu {
    private final String menuName;
    private final List<Menu> submenus;
    private final CommandRegister commandRegister;
    private final OperationRegister operationRegister;
    private final MenuHandler menuHandler;
    private boolean isRunning;

    public SimpleMenu(String menuName, MenuHandler menuHandler, AppContext context) {
        this(
                menuName,
                new ArrayList<>(),
                new CommandRegister(context),
                new OperationRegister(context),
                menuHandler
        );
    }

    public SimpleMenu(String menuName,
                      List<Menu> submenus,
                      CommandRegister commandRegister,
                      OperationRegister operationRegister,
                      MenuHandler menuHandler) {
        this.menuName = menuName;
        this.submenus = submenus;
        this.commandRegister = commandRegister;
        this.operationRegister = operationRegister;
        this.menuHandler = menuHandler;
    }

    @Override
    public void addSubmenu(Menu submenu) {
        this.submenus.add(submenu);
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    @Override
    public String getMenuName() {
        return this.menuName;
    }

    @Override
    public MenuHandler getMenuHandler() {
        return this.menuHandler;
    }

    @Override
    public OperationRegister getOperationRegister() {
        return this.operationRegister;
    }

    @Override
    public CommandRegister getCommandRegister() {
        return this.commandRegister;
    }

    @Override
    public List<Menu> getSubmenus() {
        return Collections.unmodifiableList(this.submenus);
    }

}
