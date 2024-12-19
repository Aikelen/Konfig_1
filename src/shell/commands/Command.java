package shell.commands;

public interface Command {
    /**
     * Выполняет команду с переданными аргументами.
     *
     * @param args аргументы команды
     * @throws Exception если произошла ошибка при выполнении команды
     */
    void execute(String[] args) throws Exception;
}
