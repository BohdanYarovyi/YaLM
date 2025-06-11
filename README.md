![Maven Central](https://img.shields.io/maven-central/v/io.github.bohdanyarovyi/ylmenu)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

# YaLM - Yarovyi Lightweight Menu
**YaLM** - is a simple and lightweight Java framework for building **command-line interface(CLI)** applications
with structured menus, commands, and dependency injection support.

---

## 🌟 Features 
- Menu-based CLI structure with nested commands
- Built-in dependency injection context
- Simple API

---

## 🚀 Getting started 
Use maven:
```xml
<dependency>
    <groupId>io.github.bohdanyarovyi</groupId> 
    <artifactId>ylmenu</artifactId>
    <version>[version]</version>
</dependency>
```
or gradle:
```groovy
implementation 'io.github.bohdanyarovyi:ylmenu:[version]'
```

---

## 🧩 Example of use
First you need extend class from `MenuHandler` and determine, how will user input be taken.
```java
public class SimpleMenuHandler extends MenuHandler {

    @Override
    protected String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">>> ");
        return scanner.nextLine();
    }

}
```

Create an operation to perform some work by extending the `Operation` class.
```java
public class CurrentTimeOperation extends Operation {
    @Override
    public void doOperation(String[] args) {
        String quote = getApplicationContext().getComponent("quote", String.class);
        Time time = Time.valueOf(LocalTime.now());

        System.out.println("Current time: " + time);
        System.out.println("Quote: " + quote);
    }

    @Override
    public String getPattern() {
        return "/currentTime";
    }

    @Override
    public String getDescription() {
        return "Prints current time";
    }
}
```

Now we can configure our menu:
```java
public class Main {

    public static void main(String[] args) {
        Menu menu = createMenu();
        setupMenu(menu);

        menu.setRunning(true);
        menu.startMenu();
    }

    private static void setupMenu(Menu menu) {
        // fill commands
        Command exitCommand = new ExitCommand();
        menu.getCommandRegister().addCommand(exitCommand);

        // fill operations
        Operation time = new CurrentTimeOperation();
        menu.getOperationRegister().addOperation(time);
    }

    public static Menu createMenu() {
        MenuHandler handler = new SimpleMenuHandler();
        AppContext context = new AppContext();
        context.addComponent("quote", "Do one thing, and do it well.");

        return new SimpleMenu("My menu", handler, context);
    }

}
```

Run:
```shell
             📑 My menu 📑             
Chose operation:
    - /currentTime         - Prints current time 
Choose command:
    - /exit                - Urgent exit from the program 
>>> /currentTime
Current time: 01:30:38
Quote: Do one thing, and do it well.
----------------------------------------
```

---

## 💎 Use in projects
YaLM already uses in projects:
- [**Workout Tracker (CLI)**](https://github.com/BohdanYarovyi/workout-cli)
  
> These projects can serve as examples for you to get started quickly and understand how to use the library in real-world tasks.

If you use the library in your project, please let us know — we'll add your link to this list!

---

# 🪪 Contacts
- Author: Bohdan Yarovyi
- GitHub: [@BohdanYarovyi](https://github.com/BohdanYarovyi)
- Email: bogdan.yarovoy.01@gmail.com

---

## 📄 License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

