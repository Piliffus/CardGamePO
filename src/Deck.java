import java.util.ArrayList;

public class Deck
{
    ArrayList<Card> cards;

    private void putCards()
    {
        String[] typeNames = TypeInfo.getTypeNames();
        String[] colorNames = ColorInfo.getColorNames();

        int currentCard = 0;

        for (int i = 0; i < ColorInfo.howManyColors(); i++)
        {
            for (int y = 0; y < TypeInfo.howManyTypes(); y++)
            {
                this.cards.add(currentCard, new Card(typeNames[y], colorNames[i]));
                currentCard++;
            }
        }
    }

    public Deck()
    {
        this.cards = new ArrayList<>(ColorInfo.howManyColors() * TypeInfo.howManyTypes());
        putCards();
    }
}
