import java.util.ArrayList;
import java.util.HashMap;

public class Weekly extends Task {


    public Weekly(String taskName, String descript, String type, String periodicity) {
        super(taskName, descript, type, periodicity);
    }

//    @Override
//    public boolean isTaskForTomorrow(LocalDate localDate) {
//           return this.dataActivity.toLocalDate().equals(localDate)
//               || this.dataActivity.toLocalDate().plusWeeks(1).equals(localDate);
//    }

    @Override
    public void periodicity() {

    }
}

