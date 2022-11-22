import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class Task {

    private String taskName;
    private String descript;
    private String type;
    private String periodicity;

    private ArrayList<Task> tasks = new ArrayList<>();

    public Task (String taskName, String descript, String type, String periodicity) {
        this.taskName = taskName;
        this.descript = descript;
        this.type = type;
        this.periodicity = periodicity;
    }

    // Getters ---------------------------------------------------------------------------
    public String getTaskName() { return taskName;
    }
    public String getDescript() { return descript;
    }
    public String getType() { return type;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
// Setters ----------------------------------------------------------------------------

    public void setTaskName(String taskName) {  // добавил static, убрал this
        this.taskName = taskName;
    }
    public void setDescript(String descript) {
        this.descript = descript;
    }
    public void setType(String type) {
        this.type = type;
    }
    //    public void setDataActivity(String dataActivity) {  // было LocalDateTime стало String
//        this.dataActivity = dataActivity;
//    }
    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

// Methods -------------------------------------------------------------------------------

    @Override
    public String toString() {
        return  taskName + ": " +
                descript + ", тип - " + type + ", периодичность - " + periodicity + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return  Objects.equals(type, task.type)
                && Objects.equals(periodicity, task.periodicity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, periodicity);
    }

    // public abstract boolean isTaskForTomorrow(LocalDate localDate);
    // localDate - дата дня, для которого нужен список дел.
    public abstract void periodicity();


}


