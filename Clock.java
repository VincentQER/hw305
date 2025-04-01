import java.util.Calendar;

/**
 * Represents Clock that stores time in hour, minutes, and seconds.
 * Provides methods to advance time and compare Clocks
 *
 * @author  Vincent Xu
 */
public class Clock implements Comparable <Clock> {
    //Instance variable to store hour,minutes,second
    private int myHour;
    private int myMinute;
    private int mySecond;

    /**
     * Returns the current hour of the clock.
     *
     * @return The hour of the clock.
     */
    public int getSecond() {
        return mySecond;
    }

    /**
     * Returns the current minute of the clock.
     *
     * @return The minute of the clock.
     */
    public int getMinute() {
        return myMinute;
    }

    /**
     * Returns the current second of the clock.
     *
     * @return The second of the clock.
     */
    public int getHour() {
        return myHour;
    }

    /**
     * Sets the hour of the clock.
     *
     * @param theHour The hour to set (0-23).
     * @throws IllegalArgumentException if the hour is out of range.
     */
    public void setHour(final int theHour) {
        if (theHour > 23 || theHour < 0) {
            throw new IllegalArgumentException(" The hour must be between 0 and 23 ");
        }
        myHour = theHour;
    }

    /**
     * Sets the minute of the clock.
     *
     * @param theMinute The minute to set (0-59).
     * @throws IllegalArgumentException if the minute is out of range.
     */
    public void setMinute(final int theMinute) {
        if (theMinute > 59 || theMinute < 0) {
            throw new IllegalArgumentException(" The minute must be between 0 and 59 ");
        }
        myMinute = theMinute;
    }

    /**
     * Sets the second of the clock.
     *
     * @param theSecond The second to set (0-59).
     * @throws IllegalArgumentException if the second is out of range.
     */
    public void setSecond(final int theSecond) {
        if (theSecond > 59 || theSecond < 0) {
            throw new IllegalArgumentException(" The second must be between 0 and 59 ");
        }
        mySecond = theSecond;
    }

    /**
     * Advances the hour by a given amount.
     *
     * @param theAmount The amount to advance the hour (must be non-negative).
     * @throws IllegalArgumentException if the amount is negative.
     */
    public void advanceHour(final int theAmount) {
        if (theAmount < 0) {
            throw new IllegalArgumentException(" The advancement hour must be between 0 or greater! ");
        }
        //Modulo 24 ensure the hours wraps around if it exceeds 23
        myHour = (myHour + theAmount) % 24;
    }

    /**
     * Advances the minute by a given amount.
     *
     * @param theAmount The amount to advance the minutes (must be non-negative).
     * @throws IllegalArgumentException if the amount is negative.
     */
    public void advanceMinute(final int theAmount) {
        if (theAmount < 0) {
            throw new IllegalArgumentException("The advancementMinutes must be 0 or greater! ");
        }
        int totalMinutes = myMinute + theAmount;
        //Convert excess minutes to hour
        myMinute = totalMinutes % 60;
        myHour = (myHour + totalMinutes / 60) % 24;

    }

    /**
     * Default constructor that sets the time to 23:58:00.
     */
    public Clock() {
        this(23,58,0);
    }

    /**
     * Constructor with parameters to initialize hour, minute, and second.
     * Uses setter methods to validate inputs.
     *
     * @param theHour   The hour to set (0-23).
     * @param theMinute The minute to set (0-59).
     * @param theSecond The second to set (0-59).
     */
    public Clock(final int theHour, final int theMinute, final int theSecond) {
        setHour(theHour);
        setMinute(theMinute);
        setSecond(theSecond);
    }

    /**
     * Returns a string representation of the Clock object in the format "hh:mm:ss".
     *
     * @return A string representing the time in the format "hh:mm:ss".
     */
    @Override
    public String toString() {
        return myHour + ":" + myMinute + ":" + mySecond;

    }

    /**
     * Compares this Clock object with another Clock object for order.
     *
     * @param theOtherClock The Clock object to be compared.
     * @return A negative integer, zero, or a positive integer as this Clock
     *         is less than, equal to, or greater than the specified Clock.
     */
    @Override
    public int compareTo(final Clock theOtherClock) {
        // Compare hours first
        if (this.myHour != theOtherClock.myHour) {
            // Return difference in hours
            return this.myHour - theOtherClock.myHour;
            // If hours are equal, compare minutes
        } else if (this.myMinute != theOtherClock.myMinute) {
            // Return difference in minutes
            return this.myMinute - theOtherClock.myMinute;
        } else {
            // If both hours and minutes are equal, compare seconds
            // Return difference in seconds
            return this.mySecond - theOtherClock.mySecond;
        }
    }


    /**
     * Compares two Clock objects are considered equal if they represent the same time.
     *
     * @param theObject The object to compare with this Clock.
     * @return true if the specified object is equal to this Clock; false otherwise.
     */
    @Override
    public boolean equals(final Object theObject) {
        if (this == theObject) {
            return true;
        } else if (theObject instanceof Clock) {
            return this.compareTo((Clock) theObject) == 0;
        }
            return false;
    }

    /**
     * Sets the time of this Clock object to the current system time.
     * This method retrieves the current hour, minute, and second from the system's clock
     * using the Calendar class and updates the attributes of this Clock object.
     */
    public void setToCurrentTime() {
        // Get the current time from the system.
        Calendar calendar = Calendar.getInstance();
        // Update the clock's hour , minute, and second with system's current data
        setHour(calendar.get(Calendar.HOUR_OF_DAY));
        setMinute(calendar.get(Calendar.MINUTE));
        setSecond(calendar.get(Calendar.SECOND));
    }
}


