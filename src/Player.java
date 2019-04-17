import java.util.ArrayList;

public class Player
{
    private int handSize;
    private int money;
    private ArrayList<Card> cardsOnHand;

    public Card highestCard()
    {
        int maxValue = -1;
        Card bestCard = null;

        for (int i = 0; i < handSize; i++)
        {
            if (cardsOnHand.get(i).getPriority() >= maxValue)
            {
                maxValue = cardsOnHand.get(i).getPriority();
                bestCard = cardsOnHand.get(i);
            }
        }

        return bestCard;
    }

    public void takeCardsAway()
    {
        cardsOnHand = new ArrayList<>(handSize);
    }

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
