package shell.commands;

import shell.utils.FileSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

// Класс TailCommand реализует интерфейс Command
public class TailCommand implements Command {
    private final FileSystem fileSystem; // Система файлов

    // Конструктор, который принимает объект FileSystem
    public TailCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    // Метод execute выводит последние 10 строк указанного файла
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("Usage: tail <file>"); // Проверка на наличие аргументов
        }

        File file = new File(fileSystem.getCurrentDirectory(), args[0]); // Получаем файл
        if (!file.exists() || !file.isFile()) {
            throw new Exception("File not found: " + args[0]); // Проверка на существование файла
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> lines = new LinkedList<>(); // Список для хранения строк
            String line;
            while ((line = reader.readLine()) != null) {
                if (lines.size() == 10) {
                    lines.remove(0); // Удаляем первую строку, если уже 10 строк
                }
                lines.add(line); // Добавляем строку в список
            }

            for (String tailLine : lines) {
                System.out.println(tailLine); // Выводим последние 10 строк
            }
        }
    }
}