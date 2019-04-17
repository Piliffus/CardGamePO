public class Color
{
    private String name;
    private int priority;

    public String getName()
    {
        return name;
    }

    public Color(String color)
    {
        this.name = color;
        this.priority = ColorInfo.assignPriority(color);
    }
}
