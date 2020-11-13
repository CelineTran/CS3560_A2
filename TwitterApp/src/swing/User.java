package swing;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User extends Subject implements Id, Observer{

    private String userId;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> newsFeed;
    private ArrayList<String> tweet;

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
    public void acceptable() {

    }

    public User(String userId){
        this.userId = userId;
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
        this.newsFeed = new ArrayList<String>();
        this.tweet = new ArrayList<String>();
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

    public void addTweet(String msg){
        newsFeed.add(this.userId + ": " + msg);
        tweet.add(this.userId + ": " + msg);
        this.notifyObservers();
    }

    // add follower (Observer) to this user
    public void addFollowing(User newUser){
        if(!following.contains(newUser)){
            following.add(newUser);
            this.attach(newUser);
        }
        else{
            System.out.println(userId + " is already following " + newUser);
        }
    }

    public void addFollower(User newUser){
        if(!followers.contains(newUser)){
            followers.add(newUser);
            this.attach(newUser);
        }
        else{
            System.out.println(userId + " is already a follower of " + newUser);
        }
    }

}
