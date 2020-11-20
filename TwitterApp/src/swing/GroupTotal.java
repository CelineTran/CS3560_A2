package swing;

public class GroupTotal implements AdminElement {
    @Override
    public String acceptable(AdminVisitor visitor, AdminPanel ap) {
        return visitor.visit(this, ap);
    }
}
