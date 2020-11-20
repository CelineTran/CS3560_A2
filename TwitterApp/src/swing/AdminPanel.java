package swing;

import java.util.ArrayList;

public class AdminPanel implements Observer{
    // Singleton Design patter

    private static AdminPanel panel;
    private int userTotal;
    private int groupTotal;
    private int tweetTotal;
    private int posTotal;

    public ArrayList<User> users;
    public ArrayList<Group> groups;
    public ArrayList<Id> total;

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
        this.setUserTotal(0);
        this.setGroupTotal(0);
        this.setTweetTotal(0);
        this.setPosTotal(0);
        users = new ArrayList<User>();
        groups = new ArrayList<Group>();
        total = new ArrayList<Id>();
    }

    public int getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(int userTotal) {
        this.userTotal = userTotal;
    }

    public int getGroupTotal() {
        return groupTotal;
    }

    public void setGroupTotal(int groupTotal) {
        this.groupTotal = groupTotal;
    }

    public int getTweetTotal() {
        return tweetTotal;
    }

    public void setTweetTotal(int tweetTotal) {
        this.tweetTotal = tweetTotal;
    }

    public int getPosTotal() {
        return posTotal;
    }

    public void setPosTotal(int posTotal) {
        this.posTotal = posTotal;
    }

    public User getUser(String name){
        for(User user: users){
            if(user.getDisplayName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public void addUser(User user){
        users.add(user);
        userTotal++;
    }

    public void addGroup(Group group){
        groups.add(group);
        groupTotal++;
    }

    public int getIndex(String name){
        int index = 0;
        for(int i = 0; i < users.size(); ++i){
            if(users.get(i).getDisplayName().equals(name)){
                index = i;
            }
        }
        return index;
    }

    public void incPosTotal(String msg){
        this.tweetTotal++;
        if(msg.contains("good")) {
            this.posTotal++;
        }
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof User){
            tweetTotal++;

            if(((User)subject).getTweet().equals("good")){
                posTotal++;
            }
        }
        else{
            System.out.println("Error");
        }
    }
}
