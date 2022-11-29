import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Yearly extends Task {

    Scanner scanner = new Scanner(System.in);
    public Yearly(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName, descript, type, dataActivity, periodicity);
    }
    @Override
    public boolean isTaskForDate(LocalDate localDate) {
        return dataActivity.toLocalDate().equals(localDate)              // без this работает так же !?
                || (dataActivity.toLocalDate().isBefore(localDate) &&
                dataActivity.toLocalDate().plusYears(localDate.getYear() -
                        dataActivity.toLocalDate().getYear()).equals(localDate));
    }
}
