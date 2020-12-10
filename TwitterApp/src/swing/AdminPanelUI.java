package swing;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.InputMethodListener;

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
    private JButton validateIDsButton;
    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode currentNode;
    private DefaultTreeModel treeModel;
    AdminPanel adminPanel;

    public AdminPanelUI(AdminPanel ap) {
        this.adminPanel = ap;

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser(currentNode, userIdTextArea.getText());
                treeModel.reload(root);
            }
        });
        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGroup(currentNode, groupIdTextArea.getText());
                treeModel.reload(root);
            }
        });
        openUserViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserView user = new UserView(adminPanel, currentNode);
                user.newUserView(currentNode.toString());
            }
        });
        showUserTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, adminPanel.getUserTotal());
            }
        });
        showGroupTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, adminPanel.getGroupTotal());
            }
        });
        showMessagesTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, adminPanel.getTweetTotal());
            }
        });
        showPositivePercentageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, adminPanel.getPosTotal());
            }
        });


        TreeView.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = e.getPath();
                currentNode = (DefaultMutableTreeNode) path.getPathComponent(path.getPathCount() - 1);
                if (!path.getPathComponent(path.getPathCount() - 1).toString().equals("Root")) {
                    userIdTextArea.setText("User ID: " + path.getPathComponent(path.getPathCount() - 1).toString());
                } else {
                    userIdTextArea.setText("User ID: ");
                }

                if ((path.getPathCount() - 2) < 0) {
                    groupIdTextArea.setText(("Group ID: Root"));
                } else {
                    groupIdTextArea.setText(("Group ID:" + path.getPathComponent(path.getPathCount() - 2).toString()));
                }
            }
        });

        validateIDsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                adminPanel.getValid();
                String output;
                if(adminPanel.isValid()){
                    output = "All user and group IDs are valid";
                }
                else{
                    output = "Invalid user or group IDs are present";
                }
                JOptionPane.showMessageDialog(frame, output);
            }
        });
    }

    public void createWindow(){
        JFrame frame = new JFrame("Twitter App");
        frame.setContentPane(new AdminPanelUI(adminPanel).panelMane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        createUIComponents();

    }

    private void createUIComponents() {
        root = new DefaultMutableTreeNode("Root");
        currentNode = root;

        treeModel = new DefaultTreeModel(root);
        TreeView = new JTree(treeModel);
        TreeView.setEditable(true);
    }

    public void addUser(DefaultMutableTreeNode oldNode, String newNode){
        DefaultMutableTreeNode newUser = new DefaultMutableTreeNode(newNode);
        adminPanel.addUser(new User(newNode));
        oldNode.add(newUser);
        TreeView = new JTree(root);
        ((DefaultTreeModel)TreeView.getModel()).reload(root);
    }

    public void addGroup(DefaultMutableTreeNode oldNode, String newNode){
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(newNode);
        adminPanel.addGroup(new Group(newNode));
        oldNode.add(newGroup);
        TreeView = new JTree(root);
        ((DefaultTreeModel)TreeView.getModel()).reload(root);
    }
}
