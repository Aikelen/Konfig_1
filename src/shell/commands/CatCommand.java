package shell.commands;

import shell.utils.FileSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CatCommand implements Command {
    private final FileSystem fileSystem;

    public CatCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("Usage: cat <file>");
        }

        File file = new File(fileSystem.getCurrentDirectory(), args[0]);
        if (!file.exists() || !file.isFile()) {
            throw new Exception("File not found: " + args[0]);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
