package swing;

public class PositivePercentage implements AdminElement {
    @Override
    public String acceptable(AdminVisitor visitor, AdminPanel ap) {
        return visitor.visit(this, ap);
    }
}
