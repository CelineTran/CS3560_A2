package swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView {
    private JTextArea userIdTextArea;
    private JButton followUserButton;
    private JTextArea tweetMessage;
    private JButton postTweetButton;
    private JTextArea newsFeed;
    private JPanel userPanel;
    private JTextArea currentFollowing;
    private JButton updateButton;
    DefaultMutableTreeNode currentNode;
    AdminPanel adminPanel;

    public UserView(AdminPanel ap, DefaultMutableTreeNode cn) {
        this.adminPanel = ap;
        this.currentNode = cn;
        followUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userOne = adminPanel.getIndex(currentNode.toString());
                int userTwo = adminPanel.getIndex(userIdTextArea.getText());
                adminPanel.users.get(userOne).addFollowing(adminPanel.users.get(userTwo));
                currentFollowing.append("\n-" + adminPanel.users.get(userOne).printFollowing());
            }
        });
        postTweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = adminPanel.getIndex(currentNode.toString());
                adminPanel.users.get(index).addTweet(tweetMessage.getText());
                adminPanel.users.get(index).update(adminPanel.users.get(index));
                adminPanel.incPosTotal(tweetMessage.getText());
                newsFeed.setText("News Feed: \n" + adminPanel.users.get(index).printFeed());
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = adminPanel.getIndex(currentFollowing.toString());
                newsFeed.setText("News Feed: \n" + adminPanel.users.get(index).printFeed());
            }
        });
    }

    public void newUserView(String user){
        JFrame frame = new JFrame("User: " + user);
        frame.setContentPane(new UserView(adminPanel,currentNode).userPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
