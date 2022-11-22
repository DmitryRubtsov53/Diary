import java.util.ArrayList;
import java.util.HashMap;

public class TaskMega {
    private final Integer id ;
    private static int counter = 1;
    //private HashMap<Integer, HashMap<String, ArrayList<Task>>> taskMaps = new HashMap<>();

    public TaskMega(Integer id, ArrayList<Task> taskMaps) {
        this.id = counter;
        counter++;
        //this.taskMaps = taskMaps;
    }
    //    public HashMap<Integer, HashMap<String, ArrayList<Task>>> getTaskMaps() {
//        return taskMaps;
//    }
    public Integer getId() { return id;
    }
    public static int getCounter() { return counter;
    }

}