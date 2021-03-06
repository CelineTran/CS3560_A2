package swing;

import java.util.ArrayList;

public class Group implements Id {

    private String groupName;
    private ArrayList<User> groupMembers;
    private long creationTime;

    @Override
    public String getDisplayName() {
        return groupName;
    }

    @Override
    public String acceptable(AdminVisitor visitor, AdminPanel ap) {
        return null;
    }

    public Group(String groupName){
        this.groupName = groupName;
        this.groupMembers = new ArrayList<User>();
        this.setCreateionTime(System.currentTimeMillis());
    }

    public long getCreateionTime() {
        return creationTime;
    }

    public void setCreateionTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public void getGroup(){
        for(User member: groupMembers){
            System.out.println(member.getDisplayName());
        }
    }

    public void addMember(User newUser){
        if(!groupMembers.contains(newUser)){
            groupMembers.add(newUser);
        }
        else{
            System.out.println(newUser + " is already in the group");
        }
    }
}
