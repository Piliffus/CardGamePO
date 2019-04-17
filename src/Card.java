public class Card
{
    private Type type;
    private Color color;

    public void readCard()
    {
        System.out.println(type.getName() + " of " + color.getName() +"s");
    }

    public Card(String type, String color)
    {
        this.type = new Type(type);
        this.color = new Color(color);
    }
}
