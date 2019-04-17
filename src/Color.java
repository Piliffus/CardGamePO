public class Color
{
    private String name;
    private int priority;

    public Color(String color)
    {
        this.name = color;
        this.priority = ColorInfo.assignPriority(color);
    }
}
