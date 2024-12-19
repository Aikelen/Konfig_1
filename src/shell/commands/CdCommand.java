package shell.commands;

import shell.utils.FileSystem;

// Класс CdCommand реализует интерфейс Command
public class CdCommand implements Command {
    private final FileSystem fileSystem; // Система файлов

    // Конструктор, который принимает объект FileSystem
    public CdCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    // Метод execute изменяет текущую директорию
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: cd <directory>"); // Проверка на наличие аргументов
            return;
        }
        fileSystem.changeDirectory(args[0]); // Изменяем директорию
    }
}