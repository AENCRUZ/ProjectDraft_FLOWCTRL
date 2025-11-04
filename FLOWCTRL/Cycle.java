import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Cycle {
    private LocalDate startDate;
    private LocalDate endDate;
    private String moodSummary;
    private String[] symptoms; // demonstrate use of arrays

    public Cycle(String startIso, String endIso, String mood, String symptomsCsv) throws InvalidDateException {
        try {
            this.startDate = LocalDate.parse(startIso);
            this.endDate = LocalDate.parse(endIso);
        } catch (DateTimeParseException ex) {
            throw new InvalidDateException("Dates must be in YYYY-MM-DD format.");
        }

        if (endDate.isBefore(startDate)) {
            throw new InvalidDateException("End date cannot be before start date.");
        }

        this.moodSummary = mood == null ? "" : mood;
        if (symptomsCsv == null || symptomsCsv.trim().isEmpty()) {
            this.symptoms = new String[0];
        } else {
            // store symptoms in array (requirement: arrays)
            this.symptoms = Arrays.stream(symptomsCsv.split(","))
                                  .map(String::trim)
                                  .toArray(String[]::new);
        }
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public long lengthDays() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    public String getMoodSummary() {
        return moodSummary;
    }

    public String[] getSymptoms() {
        return symptoms;
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "start=" + startDate +
                ", end=" + endDate +
                ", length=" + lengthDays() +
                ", mood='" + moodSummary + '\'' +
                ", symptoms=" + Arrays.toString(symptoms) +
                '}';
    }
}
