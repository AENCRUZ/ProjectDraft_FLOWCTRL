import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReportGenerator implements Reportable {

    @Override
    public void generateReport(User user) {
        String filename = user.getName() + "_CycleReport.txt";
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("FlowCtrl System - Cycle Report\n");
            fw.write("==============================\n\n");

            fw.write(user.getDetailedInfo());
            fw.write("\nCycle Details:\n");

            if (user.getCycles().isEmpty()) {
                fw.write("No cycles recorded.\n");
            } else {
                DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
                int i = 1;
                for (Cycle c : user.getCycles()) {
                    fw.write(String.format("[%d] Start: %s | End: %s | Length: %d days\n",
                            i++,
                            c.getStartDate().format(fmt),
                            c.getEndDate().format(fmt),
                            c.lengthDays()));
                    if (!c.getMoodSummary().isBlank()) {
                        fw.write("    Mood: " + c.getMoodSummary() + "\n");
                    }
                    if (c.getSymptoms().length > 0) {
                        fw.write("    Symptoms: " + String.join(", ", c.getSymptoms()) + "\n");
                    }
                }
            }

            fw.flush();
            System.out.println();
            System.out.println("--- EXPORT REPORT ---");
            System.out.println("Report successfully saved as:");
            System.out.println("\"" + filename + "\" ✅");
        } catch (IOException e) {
            System.out.println("Failed to save report: " + e.getMessage());
        }
    }
}
