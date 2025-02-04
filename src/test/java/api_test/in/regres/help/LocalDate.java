package api_test.in.regres.help;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface LocalDate {
    String DATE_LOCAL_MIN_3_HOURS_AND_SEC = LocalDateTime.now().minusHours(3).
            format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")),
            DATE_LOCAL_FUll = LocalDateTime.now().toString(),
            ONLY_DATE = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


}

class asdas implements  LocalDate{
    public static void main(String[] args) {
        System.out.println(ONLY_DATE);
    }
}

