package DateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime {
    /*Gets current date and returns it 
    (used for saving donation date to database)*/

    public static String getDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }
}
