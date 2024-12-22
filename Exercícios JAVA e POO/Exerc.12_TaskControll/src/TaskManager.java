import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private int id = 1;
    private HashMap<Integer, Task> tasks = new HashMap<>();

    void addTask(String description) {

        Task task = new Task(description);
        tasks.put(id, task);
        id++; // O id é adicionado automaticamente e encrementa a cada tarefa
    }

    void updateTask(int id, String newDescription) {
        Task task = tasks.get(id);
        if (tasks.containsKey(id)) {
            task.setDescription(newDescription);
            System.out.printf("task %d updated.\n", id);
        } else {
            System.out.println("Task not found.");
        }
    }

    void completeTask(int id) {
        Task task = tasks.get(id);
        if (tasks.containsKey(id)) {
            task.setCompleted(true);
            System.out.printf("task %d completed.\n", id);
        } else {
            System.out.println("Task not found.");
        }
    }

    void getTaskInfo(int id) {
        Task task = tasks.get(id);
        if (tasks.containsKey(id)) {
            System.out.printf("ID: %d | " + task.toString(), id);
        } else {
            System.out.println("Task not found");
        }
    }

    void listAllTasks() {
        System.out.println("Tasks:");
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) { // O Map.Entry vai percorrer o map para pegar a chave e o valor
            System.out.println(entry.toString());
        }
    }
}
