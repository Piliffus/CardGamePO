public class Type
{
    private String name;
    private int priority;

    public Type(String type)
    {
        this.name = type;
        this.priority = TypeInfo.assignPriority(type);
    }
}