package swing;

public class Driver {

    AdminPanel adminPanel;
    AdminPanelUI window;

    public static void main(String[] args) {
        new Driver();
    }

    public Driver(){
        adminPanel = AdminPanel.getInstance();
        window = new AdminPanelUI(adminPanel);
        window.createWindow();
    }


}
