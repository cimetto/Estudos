public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Task: %s | Is Completed: %s\n", getDescription(), isCompleted());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
