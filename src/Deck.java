import java.util.ArrayList;

public class Deck
{
    private ArrayList<Card> cards;

    private void putCards()
    {
        String[] typeNames = TypeInfo.getTypeNames();
        String[] colorNames = ColorInfo.getColorNames();

        int currentCard = 0;

        for (int y = 0; y < TypeInfo.howManyTypes(); y++)
        {
            for (int i = 0; i < ColorInfo.howManyColors(); i++)
            {
                this.cards.add(currentCard, new Card(typeNames[y], colorNames[i]));
                currentCard++;
            }
        }
    }

    public Card getCard(int i)
    {
        return cards.get(i);
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public Deck()
    {
        this.cards = new ArrayList<>(ColorInfo.howManyColors() * TypeInfo.howManyTypes());
        putCards();
    }
}
