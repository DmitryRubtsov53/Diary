import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class OneOff extends Task {


    public OneOff(String taskName, String descript, String type, String periodicity) {
        super(taskName,descript, type, periodicity);
    }

//    @Override
//    public boolean isTaskForTomorrow(LocalDate localDate) {
//        return this.dataActivity.toLocalDate().equals(localDate);
//    }

    @Override
    public void periodicity() {
        String periodicity = "Однократная";
        // передать параметр в Мапу..................
        System.out.println("Периодичность задачи: " + periodicity);
    }
}

