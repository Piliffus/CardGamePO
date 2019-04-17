import java.util.ArrayList;

public class Player
{
    private int handSize;
    private int money;
    private ArrayList<Card> cardsOnHand;

    public int getHandSize()
    {
        return handSize;
    }

    public void giveCard(Card card)
    {
            cardsOnHand.add(card);
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public Player(int money)
    {
        this.money = money;
        this.handSize = 5;
        cardsOnHand = new ArrayList<>(handSize);
    }
}
