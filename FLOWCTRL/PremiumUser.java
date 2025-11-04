// Inheritance: a subclass that extends User and overrides behavior
public class PremiumUser extends User {
    public PremiumUser(String name, String password) {
        super(name, password);
    }

    @Override
    public String getDetailedInfo() {
        // premium users show an upgraded message
        return super.basicReport() + "Account Type: Premium\nExtra features unlocked: advanced reporting\n";
    }
}

