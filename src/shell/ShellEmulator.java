package shell;

import shell.commands.*;
import shell.utils.FileSystem;

import java.util.Scanner;

public class ShellEmulator {
    private final FileSystem fileSystem;
    private final String username;

    public ShellEmulator(String username, String tarFilePath) throws Exception {
        this.username = username;
        this.fileSystem = new FileSystem(tarFilePath);
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) { // Используем try-with-resources
            while (true) {
                System.out.print(username + "@" + fileSystem.getCurrentPath() + " $ ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty())
                    continue;

                String[] parts = input.split("\\s+");
                String command = parts[0];
                String[] args = parts.length > 1 ? input.substring(command.length()).trim().split("\\s+")
                        : new String[0];

                try {
                    switch (command) {
                        case "ls" -> new LsCommand(fileSystem).execute(args);
                        case "cd" -> new CdCommand(fileSystem).execute(args);
                        case "exit" -> {
                            System.out.println("Goodbye!");
                            return;
                        }
                        case "tail" -> new TailCommand(fileSystem).execute(args);
                        case "uptime" -> new UptimeCommand().execute(args);
                        case "cat" -> new CatCommand(fileSystem).execute(args);
                        default -> System.out.println("Unknown command: " + command);
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error initializing scanner: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ShellEmulator <username> <tar-file-path>");
            return;
        }
        try {
            new ShellEmulator(args[0], args[1]).start();
        } catch (Exception e) {
            System.err.println("Failed to start emulator: " + e.getMessage());
        }
    }
}
