import java.util.ArrayList;
import java.util.HashMap;

public class TaskSuper{
    public  String dataActivity;  // было LocalDateTime стало String
    private HashMap<String, ArrayList<Task>> listHashMap = new HashMap<>(); // было LocalDateTime стало String

    public TaskSuper(String dataActivity, Task listHashMap) {
        this.dataActivity = dataActivity;
        //this.listHashMap = listHashMap;
    }

    public HashMap<String, ArrayList<Task>> getListHashMap() {  // было LocalDate стало String
        return listHashMap;
    }
    public String getDataActivity() { return dataActivity; // было LocalDateTime стало String
    }
}
