package swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanelUI {
    private JTree TreeView;
    private JTextArea userIdTextArea;
    private JTextArea groupIdTextArea;
    private JButton addUserButton;
    private JButton addGroupButton;
    private JButton openUserViewButton;
    private JButton showUserTotalButton;
    private JButton showGroupTotalButton;
    private JButton showMessagesTotalButton;
    private JButton showPositivePercentageButton;
    private JPanel panelMane;

    public AdminPanelUI() {
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame.getFrames();
            }
        });
        openUserViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserView user = new UserView();
                user.newUserView();
            }
        });
        showUserTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame.getFrames();
            }
        });
        showGroupTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame.getWindows();
            }
        });
        showMessagesTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JWindow.getWindows();
            }
        });
        showPositivePercentageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JWindow.getWindows();
            }
        });


    }

    public void createWindow(){
        JFrame frame = new JFrame("Twitter App");
        frame.setContentPane(new AdminPanelUI().panelMane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
