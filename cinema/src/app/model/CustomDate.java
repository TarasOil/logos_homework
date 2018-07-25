package app.model;

import java.util.GregorianCalendar;

public class CustomDate extends GregorianCalendar {
    public CustomDate(int year, int month, int dayOfMonth, int hourOfDay, int minute){
        super(year, month, dayOfMonth, hourOfDay, minute);
    }
    @Override
    public String toString() {
        String s = this.get(DAY_OF_MONTH) + "." + (this.get(MONTH)+1) + "." + this.get(YEAR) + " " + this.get(HOUR_OF_DAY) + ":" + this.get(MINUTE);
        return s;
    }
}
