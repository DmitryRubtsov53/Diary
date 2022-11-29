import java.util.ArrayList;
import java.util.HashMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Weekly extends Task {

    Scanner scanner = new Scanner(System.in);
    public Weekly(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName, descript, type, dataActivity, periodicity);
    }

    @Override
    public boolean isTaskForDate(LocalDate localDate) {
        return dataActivity.toLocalDate().equals(localDate)
                || (dataActivity.toLocalDate().isBefore(localDate) &&
                dataActivity.toLocalDate().getDayOfWeek().equals(localDate.getDayOfWeek()));
    }
}

