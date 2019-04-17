import java.util.ArrayList;

public class Player
{
    int handSize;
    int money;
    ArrayList<Card> cardsOnHand;

    public Player(int money)
    {
        this.money = money;
        this.handSize = 5;
        cardsOnHand = new ArrayList<>(handSize);
    }
}
