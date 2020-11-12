package swing;

public class Driver {

    public static void main(String[] args) {
        AdminPanel.getInstance().createWindow();

        Group root = new Group("root");

        User bob = new User("bob");
        User joe = new User("joe");
        User jane = new User("jane");
        User john = new User("john");

    }
}
