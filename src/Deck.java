import java.util.ArrayList;
import java.util.Random;

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

    public void shuffle()
    {
        int deckSize = cards.size();
        ArrayList<Card> cardsOne = new ArrayList<>(cards.subList(0, deckSize / 2));
        ArrayList<Card> cardsTwo = new ArrayList<>(cards.subList(deckSize / 2, deckSize));

        cards.clear();

        int y = 0;
        for (int i = 0; i < deckSize / 2; i++)
        {
            cards.add(y, cardsOne.get(i));
            y++;
            cards.add(y, cardsTwo.get(i));
            y++;
        }

        for (int i = 0; i < 5; i++)
        {
            Random generator = new Random();
            int separationPoint = (generator.nextInt(deckSize-2))+1;

            ArrayList<Card> nextCards = new ArrayList<>(deckSize);

            int h = 0;

            for (int z = separationPoint; z < deckSize; z++)
            {
                nextCards.add(h, cards.get(z));
                h++;
            }

            for (int z = 0; z < separationPoint; z++)
            {
                nextCards.add(h, cards.get(z));
                h++;
            }

            cards = nextCards;
        }
    }
}
