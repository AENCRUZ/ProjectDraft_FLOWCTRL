import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CycleManager {
    private final Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getName().toLowerCase(), user);
    }

    public boolean userExists(String name) {
        return users.containsKey(name.toLowerCase());
    }

    public int totalUsers() {
        return users.size();
    }

    public User authenticate(String name, String password) {
        User user = users.get(name.toLowerCase());
        if (user == null) return null;
        return user.checkPassword(password) ? user : null;
    }

    public void viewHistory(User user) {
        List<Cycle> cycles = user.getCycles();
        if (cycles.isEmpty()) {
            System.out.println("No cycle history found.");
            return;
        }

        System.out.println("--- CYCLE HISTORY ---");
        for (int i = 0; i < cycles.size(); i++) {
            Cycle c = cycles.get(i);
            System.out.printf("[%d] Start: %s | End: %s | Length: %d days | Mood: %s | Symptoms: %s\n",
                    i + 1, c.getStartDate(), c.getEndDate(), c.lengthDays(), c.getMoodSummary(),
                    String.join(", ", c.getSymptoms()));
        }
    }

    public void predictNextCycle(User user) {
        List<Cycle> cycles = user.getCycles();
        if (cycles.size() < 2) {
            System.out.println("Not enough data to predict next cycle (need at least 2 cycles).");
            return;
        }

        // compute differences between start dates
        List<Long> diffs = new ArrayList<>();
        for (int i = 1; i < cycles.size(); i++) {
            LocalDate prev = cycles.get(i - 1).getStartDate();
            LocalDate cur = cycles.get(i).getStartDate();
            long d = ChronoUnit.DAYS.between(prev, cur);
            diffs.add(d);
        }

        long sum = 0;
        for (Long d : diffs) sum += d;
        double avg = (double) sum / diffs.size();
        long avgRounded = Math.round(avg);

        // next predicted start is last cycle start + avgRounded
        LocalDate lastStart = cycles.get(cycles.size() - 1).getStartDate();
        LocalDate prediction = lastStart.plusDays(avgRounded);

        System.out.println();
        System.out.println("--- PREDICT NEXT CYCLE ---");
        System.out.println("Calculating average cycle length...");
        System.out.printf("Average: %.0f days\n", avg);
        System.out.println("Your next period is likely to start on: " + prediction + " \uD83C\uDF19");
    }
}
