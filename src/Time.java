import java.text.DecimalFormat;


/**
 * This class represents a time object
 *
 * @author Aaron Lin
 */
public class Time {
    /** Formatting for numbers */
    private DecimalFormat df = new DecimalFormat("00");

    /** The amount of hours */
    private int hours;

    /** The amount of minutes */
    private int minutes;

    /** The amount of seconds */
    private int seconds;


    /**
     * Constructs a Time object with the specified hours, minutes, and seconds.
     *
     * @param hours the hours value
     * @param minutes the minutes value
     * @param seconds the seconds value
     */
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }


    /**
     * Increases the time by one second and updates the minutes, hours, and days if necessary.
     */
    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }


    /**
     * Adds the specified time to this Time object.
     *
     * @param t the time to add
     */
    public void add(Time t) {
        seconds += t.seconds;
        if (seconds >= 60) {
            seconds -= 60;
            minutes++;
        }
        minutes += t.minutes;
        if (minutes >= 60) {
            minutes -= 60;
            hours++;
        }
        hours += t.hours;
        if (hours >= 24) {
            hours -= 24;
        }
    }


    /**
     * Adds the given time to the current time.
     *
     * @param t the time to be added in the format "HH:MM:SS"
     */
    public void add(String t) {
        String[] time = t.split(":");
        int inputSeconds = Integer.parseInt(time[2]);
        int inputMinutes = Integer.parseInt(time[1]);
        int inputHours = Integer.parseInt(time[0]);
        seconds += inputSeconds;
        if (seconds >= 60) {
            seconds -= 60;
            minutes++;
        }
        minutes += inputMinutes;
        if (minutes >= 60) {
            minutes -= 60;
            hours++;
        }
        hours += inputHours;
        if (hours >= 24) {
            hours -= 24;
        }
    }


    /**
     * Returns a formatted string representation of the time.
     *
     * @return The formatted time string in the format "HH:MM:SS".
     */
    public String info() {
        return df.format(hours) + ":" + df.format(minutes) + ":" + df.format(seconds);
    }
}
