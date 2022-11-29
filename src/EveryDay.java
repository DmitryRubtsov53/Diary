import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class EveryDay extends Task {
    Scanner scanner = new Scanner(System.in);
    public EveryDay(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName, descript, type, dataActivity, periodicity);
    }

    @Override
    public boolean isTaskForDate(LocalDate localDate) {
        return dataActivity.toLocalDate().isBefore(localDate)
                || dataActivity.toLocalDate().equals(localDate);
    }
}
