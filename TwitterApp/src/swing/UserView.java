package swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView {
    private JTextArea userIdTextArea;
    private JButton followUserButton;
    private JList currentFollowing;
    private JTextArea tweetMessage;
    private JButton postTweetButton;
    private JList newsFeed;
    private JPanel userPanel;

    public UserView() {
        followUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        postTweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
    }

    public void newUserView(){
        JFrame frame = new JFrame("User View");
        frame.setContentPane(new UserView().userPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
