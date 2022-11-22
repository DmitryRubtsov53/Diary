import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashMap;

public class EveryDay extends Task {


    public EveryDay(String taskName, String descript, String type, String periodicity) {
        super(taskName, descript, type, periodicity);
    }

//    @Override
//    public boolean isTaskForTomorrow(LocalDate localDate) {
//            return this.dataActivity.toLocalDate().isBefore(localDate)
//                || this.dataActivity.toLocalDate().equals(localDate);
//    }

    @Override
    public void periodicity() {

    }
}
