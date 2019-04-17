import java.util.ArrayList;

public class Player
{
    private int handSize;
    private int money;
    private ArrayList<Card> cardsOnHand;

    public void sayCards()
    {
        for (int i = 0; i < this.handSize; i++)
        {
            this.cardsOnHand.get(i).readCard();
            System.out.print(", ");
        }

        System.out.print("\n");
    }

    public Card highestCard()
    {
        int maxValue = -1;
        Card bestCard = null;

        for (int i = 0; i < this.handSize; i++)
        {
            if (this.cardsOnHand.get(i).getPriority() >= maxValue)
            {
                maxValue = this.cardsOnHand.get(i).getPriority();
                bestCard = this.cardsOnHand.get(i);
            }
        }

        return bestCard;
    }

    public void takeCardsAway()
    {
        this.cardsOnHand = new ArrayList<>(handSize);
    }

    public int getHandSize()
    {
        return handSize;
    }

    public void giveCard(Card card)
    {
        this.cardsOnHand.add(card);
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
        this.cardsOnHand = new ArrayList<>(handSize);
    }
}
