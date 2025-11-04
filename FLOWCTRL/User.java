import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private final List<Cycle> cycles;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.cycles = new ArrayList<>();
    }

    // Encapsulation: private fields with getters/setters
    public String getName() {
        return name;
    }

    // password intentionally has no public getter for safety
    public boolean checkPassword(String attempt) {
        return password.equals(attempt);
    }

    public void addCycle(String startIso, String endIso, String mood, String symptoms) throws InvalidDateException {
        Cycle cycle = new Cycle(startIso, endIso, mood, symptoms);
        cycles.add(cycle);
    }

    public List<Cycle> getCycles() {
        return cycles;
    }

    public String basicReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(name).append("\n");
        sb.append("Total cycles recorded: ").append(cycles.size()).append("\n");
        return sb.toString();
    }

    // Polymorphism example: subclasses can override
    public String getDetailedInfo() {
        return basicReport();
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', cycles=" + cycles.size() + "}";
    }
}
