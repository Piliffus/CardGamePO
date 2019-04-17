public class Card
{
    private Type type;
    private Color color;

    public Card(String type, String color)
    {
        this.type = new Type(type);
        this.color = new Color(color);
    }
}
