public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask("Estudar Java");
        taskManager.addTask("Finalizar projeto");

        taskManager.listAllTasks();

        taskManager.updateTask(1, "Estudar Java e Spring");

        taskManager.listAllTasks();

        taskManager.getTaskInfo(1);

        taskManager.completeTask(1);

        taskManager.listAllTasks();
    }
}
