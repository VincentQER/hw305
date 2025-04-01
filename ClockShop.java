import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a shop that holds multiple Clock objects.
 * It provides functionality for adding, sorting, finding, and managing clocks.
 *
 * @author VINCENT XU
 */
public class ClockShop {
    private final ArrayList<Clock> myClocks;
    private final static String newline = System.lineSeparator();
    /**
     * Default constructor that creates an empty ClockShop.
     */
    public ClockShop() {
        myClocks = new ArrayList<>();
    }

    /**
     * Reads clocks from a file and fills the ClockShop.
     * The file should have clocks in the format: hh:mm:ss
     *
     * @param theInputFileName The name of the input file to read.
     * @throws FileNotFoundException if the file is not found.
     */
    public void fillClockShop(final String theInputFileName) {
        try {
            Scanner scan = new Scanner(new File(theInputFileName));
            // Set the delimiter to read hour, minute, and second
            scan.useDelimiter("\\s*:\\s*|\\s*\\n\\s*");
            // Read clock data from the file
            while (scan.hasNext()) {
                final int hour = scan.nextInt();
                final int minute = scan.nextInt();
                final int second = scan.nextInt();

                // Create a new Clock object and add it to the myClocks list
                Clock clock = new Clock(hour, minute, second);
                myClocks.add(clock);
            }
            // Close the scanner after reading
            scan.close();
        } catch (FileNotFoundException e) {
            // Throw a runtime exception if the file is not found
            throw new RuntimeException("File not found: " + theInputFileName + ". Error: " + e.getMessage());
        }
    }

    /**
     * Bubble sorts the clocks in the ClockShop in ascending order based on time.
     */
    public void sortClocks() {
        // Bubble Sort
        for (int i = 0; i < myClocks.size() - 1; i++) {
            for (int j = 0; j < myClocks.size() - i - 1; j++) {
                if (myClocks.get(j).compareTo(myClocks.get(j + 1)) > 0) {
                    Clock temp = myClocks.get(j);
                    myClocks.set(j, myClocks.get(j + 1));
                    myClocks.set(j + 1, temp);
                }
            }
        }

    }

    /**
     * Finds the index of a specified Clock in the ClockShop.
     * @param theClock The Clock to find.
     * @return The index of the Clock, or -1 if not found.
     */
    public int findClock(final Clock theClock) {
        // Iterate through the list of clocks
        for (int i = 0; i < myClocks.size(); i++) {
            // Use the equals method to check if the Clock matches
            if (myClocks.get(i).equals(theClock)) {
                return i; // Return the index if a match is found
            }
        }
        return -1; // Return -1 if the Clock is not found
    }

    /**
     * Returns a string of all Clock objects in the ClockShop,
     * with each Clock's string followed by a newline.
     *
     * @return A string of each Clock object, each on a new line.
     */
    @Override
    public String toString() {
        // StringBuilder is used to efficiently build the result string
        StringBuilder result = new StringBuilder();
        // Iterate over all Clock objects in the myClocks
        for (Clock clock : myClocks) {
            // Append each Clock's string representation followed by a newline character
            result.append(clock.toString()).append("\r\n");
        }
        // Convert the StringBuilder content to a string and return it
        return result.toString();
    }

    /**
     * Writes the clocks to a file.
     * @param fileName The name of the file to write to.
     */
    public void writeClocksToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Loop through all Clock objects in myClocks and write them to the file.
            for (Clock clock : myClocks) {
                // Write the string representation of the clock
                writer.write(clock.toString());
                // Write a newline character after each clock
                writer.write("\n");
            }
        } catch (IOException e) {
            // Throw a runtime exception if there is an issue with file writing
            throw new RuntimeException("Failed to write clocks to file: " + fileName, e);
        }
    }

    /**
     * Retrieves the Clock object at the specified index from myClocks.
     * If the index is out of range ,it throws an IllegalArgumentException
     *
     * @param theIndex The index of the clock to retrieve.
     * @return The Clock object at the specified index.
     * @throws IllegalArgumentException if the index is out of range.
     */
    public Clock getClock(final int theIndex) {
        // Check if the index is within valid range (0 <= index < size of the list)
        if (theIndex < 0 || theIndex >= myClocks.size()) {
            // Throw an exception if the index is out of bounds
            throw new IllegalArgumentException("Index out of bounds: " + theIndex);
        }
        // Return the Clock object at the specified index
        return myClocks.get(theIndex);
    }

    /**
     * Replaces the Clock object at the specified index with a new Clock object.
     * If the index is out of range ,it throws an IllegalArgumentException.
     *
     * @param theClock The new Clock object to place in the list.
     * @param theIndex The index at which to replace the existing Clock object.
     * @throws IllegalArgumentException if the index is out of range.
     */
    public void setClock(final Clock theClock, final int theIndex) {
        // Check if the index is within valid range (0 <= index < size of the list)
        if (theIndex < 0 || theIndex >= myClocks.size()) {
            // Throw an exception if the index is out of bounds
            throw new IllegalArgumentException("Index out of bounds: " + theIndex);
        }
        // Replace the Clock object at the specified index with the new one
        myClocks.set(theIndex, theClock);

    }

    /**
     * Adds a Clock object to the ClockShop's list of clocks.
     *
     */
    public void addClock(Clock clock) {
        // Add the Clock object to the ArrayList
        myClocks.add(clock);
    }

}





