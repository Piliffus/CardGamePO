public class CardColor
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

    public CardColor(String name)
    {
        this.name = name;
        this.priority = ColorInfo.assignPriority(name);
    }
}
