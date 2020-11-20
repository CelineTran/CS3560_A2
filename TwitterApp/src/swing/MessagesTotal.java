package swing;

public class MessagesTotal implements AdminElement {
    @Override
    public String acceptable(AdminVisitor visitor, AdminPanel ap) {
        return visitor.visit(this, ap);
    }
}
