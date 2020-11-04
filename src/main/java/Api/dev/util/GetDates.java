package Api.dev.util;

import java.util.Calendar;
import java.util.Date;

public class GetDates {

    public static Date getdate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
}
