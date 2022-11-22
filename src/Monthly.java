import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Monthly extends Task {


    public Monthly(String taskName, String descript, String type, String periodicity) {
        super(taskName, descript, type, periodicity);
    }

//    @Override
//    public boolean isTaskForTomorrow(LocalDate localDate) {
//
//        return this.dataActivity.toLocalDate().equals(localDate)
//                || this.dataActivity.toLocalDate().plusMonths(1).equals(localDate);
//    }

    @Override
    public void periodicity() {

    }
}
