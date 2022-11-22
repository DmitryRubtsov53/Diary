import java.time.LocalDate;
import java.time.LocalDateTime;

public class Yearly extends Task {


    public Yearly(String taskName, String descript, String type, String periodicity) {
        super(taskName, descript, type, periodicity);
    }
//    @Override
//    public boolean isTaskForTomorrow(LocalDate localDate) {
//              return this.dataActivity.toLocalDate().equals(localDate)
//                  || this.dataActivity.toLocalDate().plusYears(1).equals(localDate);
//    }

    @Override
    public void periodicity() {

    }
}