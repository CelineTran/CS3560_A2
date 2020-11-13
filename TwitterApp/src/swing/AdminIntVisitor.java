package swing;

public interface AdminIntVisitor {

    //Visitor patter interface

    public String visit(TotalCount total, AdminPanel ap);
    public String visit(GroupTotal total, AdminPanel ap);
    public String visit(MessagesTotal total, AdminPanel ap);
    public String visit(PositivePercentage perc, AdminPanel ap);
}
