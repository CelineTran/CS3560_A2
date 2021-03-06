package swing;

import java.util.ArrayList;

public class User extends Subject implements Id, Observer{

    private String userId;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> newsFeed;
    private ArrayList<String> tweet;
    private long creationTime;
    private long updatedTime;

    @Override
    public String getDisplayName() {
        return userId;
    }

    @Override
    public void update(Subject subject) {
        //add following
        //update newsfeed
        if(subject instanceof User){
            if(!((User)subject).getDisplayName().equals(this.getDisplayName())){
                newsFeed.add(((User)subject).getTweet());
            }
        }
        else{
            System.out.println("Something went wrong there ... ");
        }
    }

    @Override
    public String acceptable(AdminVisitor visitor, AdminPanel ap) {
        return null;
    }

    public User(String userId){
        this.userId = userId;
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
        this.newsFeed = new ArrayList<String>();
        this.tweet = new ArrayList<String>();
        this.setCreationTime(System.currentTimeMillis());
        this.setUpdatedTime(System.currentTimeMillis());
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void setNewsFeed(ArrayList<String> newsFeed) {
        this.newsFeed = newsFeed;
    }

    public ArrayList<String> getNewsFeed() {
        return newsFeed;
    }

    public String getTweet(){
        return tweet.get(tweet.size()-1);
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }


    public void addTweet(String msg){
        setUpdatedTime(System.currentTimeMillis());
        newsFeed.add(this.userId + ": " + msg);
        tweet.add(this.userId + ": " + msg);
        this.notifyObservers();
    }

    public String printFeed(){
        String feed = "";
        for (String tweet: newsFeed){
            feed += "-- " + tweet + "\n";
        }
        return feed;
    }

    // add follower (Observer) to this user
    public void addFollowing(User newUser){
        setUpdatedTime(System.currentTimeMillis());
        if(!following.contains(newUser)){
            following.add(newUser);
            this.attach(newUser);
        }
        else{
            System.out.println(userId + " is already following " + newUser);
        }
    }

    public void addFollower(User newUser){
        setUpdatedTime(System.currentTimeMillis());
        if(!followers.contains(newUser)){
            followers.add(newUser);
            this.attach(newUser);
        }
        else{
            System.out.println(userId + " is already a follower of " + newUser);
        }
    }

    public String printFollowing(){
        String followings = "";
        for(User user: following){
            followings += user.getDisplayName() + "\n";
        }
        return followings;
    }

    public String printTime(){
        long hour = (creationTime/(1000 * 60 * 60)) % 24;
        long minute = (creationTime/(1000 * 60)) % 60;
        long seconds = (creationTime/1000) % 60;

        String createdTime = String.format("%02d:%02d:%02d", ((hour+4)%24), minute, seconds);

        hour = (updatedTime/(1000 * 60 * 60)) % 24;
        minute = (updatedTime/(1000 * 60)) % 60;
        seconds = (updatedTime/1000) % 60;

        String lastUpdatedTime = String.format("%02d:%02d:%02d", ((hour+4)%24), minute, seconds);

        return ("Created time: " + createdTime + "\nLast updated time: " + lastUpdatedTime);
    }

}
