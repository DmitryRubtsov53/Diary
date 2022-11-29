import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class OneOff extends Task {

    Scanner scanner = new Scanner(System.in);
    public OneOff(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName,descript, type, dataActivity, periodicity);
    }

    @Override
    public boolean isTaskForDate(LocalDate localDate) {
                return dataActivity.toLocalDate().equals(localDate);
    }
}

