package shell.commands;

// Класс UptimeCommand реализует интерфейс Command
public class UptimeCommand implements Command {
    private final long startTime; // Время запуска команды

    // Конструктор, который инициализирует время запуска
    public UptimeCommand() {
        this.startTime = System.currentTimeMillis();
    }

    // Метод execute выводит время работы системы
    @Override
    public void execute(String[] args) {
        long uptime = System.currentTimeMillis() - startTime; // Вычисляем время работы
        System.out.println("Uptime: " + uptime / 1000 + " seconds"); // Выводим время в секундах
    }
}