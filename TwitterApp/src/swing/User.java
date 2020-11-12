package swing;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User extends Subject implements Id, Observer{

    private String userId;
    private ArrayList<String> followers;
    private ArrayList<String> following;
    private ArrayList<String> newsFeed;

    @Override
    public String getDisplayName() {
        return userId;
    }

    @Override
    public void update(Subject subject) {
        //add following
        //update newsfeed
    }

    @Override
    public void acceptable() {

    }

    public User(String userId){
        this.userId = userId;
        this.followers = new ArrayList<String>();
        this.following = new ArrayList<String>();
        this.newsFeed = new ArrayList<String>();
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }

    public ArrayList<String> getFollowing() {
        return following;
    }

    public void setNewsFeed(ArrayList<String> newsFeed) {
        this.newsFeed = newsFeed;
    }

    public ArrayList<String> getNewsFeed() {
        return newsFeed;
    }

    public void addFollower(String userId){
        if(!followers.contains(userId)){
            followers.add(userId);
            //call an update on User
        }
        else{
            System.out.println("You are already following " + userId);
        }
    }

}
