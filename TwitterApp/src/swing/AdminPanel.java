package swing;

public class AdminPanel {
    private static AdminPanel panel;

    public static AdminPanel getInstance(){
        if(panel == null){
            synchronized (AdminPanel.class){
                if(panel == null){
                    panel = new AdminPanel();
                }
            }
        }
        return panel;
    }

    private AdminPanel(){

    }
}
