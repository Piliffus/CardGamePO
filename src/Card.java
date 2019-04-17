public class Card
{
    private CardType cardType;
    private CardColor cardColor;
    private int priority;

    public void readCard()
    {
        System.out.println(cardType.getName() + " of " + cardColor.getName() +"s");
    }

    public void readCardPriority()
    {
        System.out.println(this.toString());
    }

    @Override
    public String toString()
    {
        return "priority = " + priority;
    }

    public Card(String cardType, String cardColor)
    {
        this.cardType = new CardType(cardType);
        this.cardColor = new CardColor(cardColor);
        priority = this.cardType.getPriority() + this.cardColor.getPriority();
    }
}
