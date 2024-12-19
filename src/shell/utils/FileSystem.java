package shell.utils;

import java.io.File;

public class FileSystem {
    private File currentDirectory;

    public FileSystem(String tarFilePath) throws Exception {
        // TODO: Добавить логику для распаковки tar-файла в виртуальную файловую систему.
        this.currentDirectory = new File("."); // По умолчанию текущая директория
    }

    /**
     * Возвращает текущую директорию.
     *
     * @return текущая директория
     */
    public File getCurrentDirectory() {
        return currentDirectory;
    }

    /**
     * Возвращает текущий путь в виде строки.
     *
     * @return абсолютный путь текущей директории
     */
    public String getCurrentPath() {
        return currentDirectory.getAbsolutePath();
    }

    /**
     * Изменяет текущую директорию на указанную.
     *
     * @param path путь к новой директории
     * @throws Exception если директория не найдена
     */
    public void changeDirectory(String path) throws Exception {
        File newDir = new File(currentDirectory, path);
        if (newDir.exists() && newDir.isDirectory()) {
            currentDirectory = newDir;
        } else {
            throw new Exception("Directory not found: " + path);
        }
    }
}
