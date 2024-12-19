package shell.commands;

import shell.utils.FileSystem;

import java.io.File;

// Класс LsCommand реализует интерфейс Command
public class LsCommand implements Command {
    private final FileSystem fileSystem; // Система файлов

    // Конструктор, который принимает объект FileSystem
    public LsCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    // Метод execute выводит список файлов в текущей директории
    @Override
    public void execute(String[] args) {
        File currentDir = fileSystem.getCurrentDirectory(); // Получаем текущую директорию
        File[] files = currentDir.listFiles(); // Получаем список файлов

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName()); // Выводим имя каждого файла
            }
        } else {
            System.out.println("No files found."); // Если файлов нет
        }
    }
}