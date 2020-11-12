package swing;

public class Group implements Id {

    private String groupName;

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public void acceptable() {

    }

    public Group(String groupName){
        groupName = this.groupName;
    }
}
