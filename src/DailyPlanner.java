import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class DailyPlanner {

    private final String heading;
    private String description;
    private final Type taskType;
    private final LocalDate localDate;
    private Repeatability repeatability;

    public DailyPlanner(String heading,
                        String description,
                        Type taskType,
                        Repeatability repeatability,
                        LocalDate localDate) {
        if (heading == null) {
            throw new IllegalArgumentException("Добавьте название задачи!!!");
        } else {
            this.heading = heading;
        }
        setDescription(description);
        if (taskType == null) {
            throw new IllegalArgumentException("Тип задачи не указан!!!");
        } else {
            this.taskType = taskType;
        }
        this.localDate = localDate;
        setRepeatability(repeatability);
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Описание задачи не заполнено");
        } else {
            this.description = description;
        }
    }

    public Type getTaskType() {
        return taskType;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        if (repeatability == null) {
            throw new IllegalArgumentException("Введите повторяемость!!!");
        } else {
            this.repeatability = repeatability;
        }
    }

    public static void inputTask(Map<DailyPlanner, Integer> planer) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.println("Введите описание");
        String description = scanner.next();
        System.out.println("Введите дату");
        LocalDate date = LocalDate.parse(scanner.next(), dateTimeFormatter);
        System.out.println("Введите ид задачи");
        Integer id = scanner.nextInt();
        planer.put(new DailyPlanner(taskName, description, Type.WORKED, Repeatability.SINGLE, date), id);
        System.out.println("Вы добавили задачу : \n"+planer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyPlanner that = (DailyPlanner) o;
        return heading.equals(that.heading) && description.equals(that.description) && taskType == that.taskType
                && localDate.equals(that.localDate) && repeatability == that.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, description, taskType, localDate, repeatability);
    }

    @Override
    public String toString() {
        return "Задача -" + "\n" +
                "Название - " + heading + '\n' +
                "Описание - " + description + '\n' +
                "Тип - " + taskType.getType() + '\n' +
                "Дата - " + localDate + '\n' +
                "Частота повторений - " + repeatability.getNameR();
    }

    public static void createDaily() {
    }

    public static void getDailyPlan(Map<DailyPlanner, Integer> planer) {
        System.out.println("Введите дату: ");
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println("Список задач на деньь");
        for (DailyPlanner planner : planer.keySet()) {
            if (planner.getLocalDate().equals(date)) {
                System.out.println(planer);
            }
        }
    }

    public static void delete(Map<DailyPlanner, Integer> planer) {
        System.out.println("Введите номер пункта для удаления");
        Scanner scanner = new Scanner(System.in);
        for (DailyPlanner planner : planer.keySet()) {
            planer.remove(planner, scanner.nextInt());
            System.out.println("Вы успешно удалил задачу");
        }
    }
}
