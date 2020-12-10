package swing;

import java.util.ArrayList;

public class AdminPanel implements Observer{
    // Singleton Design patter

    private static AdminPanel panel;
    private int userTotal;
    private int groupTotal;
    private int tweetTotal;
    private int posTotal;
    private boolean valid;
    private String lastUpdateUser;

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
        this.setValid(true);
        this.setLastUpdateUser("N/A");
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

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
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

    public void getValid(){
        ArrayList<String> temp = new ArrayList<String>();
        for(User user: users){
            if(user.getDisplayName().contains(" ") || temp.contains(user.getDisplayName())){
                valid = false;
            }
            else{
                temp.add(user.getDisplayName());
            }
        }
        ArrayList<String> temp2 = new ArrayList<String>();
        for(Group group: groups) {
            if (group.getDisplayName().contains(" ") || temp2.contains(group.getDisplayName())) {
                valid = false;
            }
            else{
                temp2.add(group.getDisplayName());
            }
        }
    }

    public String printUserTime(String newUser){
        for(User user: users) {
            if(user.getDisplayName().equals(newUser)) {
                return user.printTime();
            }
        }
        return ("No time found");
    }

    public String getLastUpdatedUser(){
        User temp;

        if(users.size() > 0){
            temp = users.get(0);

            for(User user: users){
                if(user.getUpdatedTime() > temp.getUpdatedTime()){
                    temp = user;
                }
            }
        }
        else{
            return "Not applicable";
        }

        return temp.getDisplayName();
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
