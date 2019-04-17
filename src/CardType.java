public class CardType
{
    private String name;
    private int priority;

    public int getPriority()
    {
        return priority;
    }

    public String getName()
    {
        return name;
    }

    public CardType(String name)
    {
        this.name = name;
        this.priority = TypeInfo.assignPriority(name);
    }
}
