package swing;

public class AdminVisitor implements AdminIntVisitor{

    @Override
    public String visit(GroupTotal total, AdminPanel ap) {
        return null;
    }

    @Override
    public String visit(TotalCount total, AdminPanel ap) {
        return null;
    }

    @Override
    public String visit(MessagesTotal total, AdminPanel ap) {
        return null;
    }

    @Override
    public String visit(PositivePercentage perc, AdminPanel ap) {
        return null;
    }
}
