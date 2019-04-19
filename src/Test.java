import java.util.ArrayList;

public class Test
{
    public static void cardTypeAndColorReadingTest(ArrayList<Card> arg)
    {
        for (int i = 0; i < arg.size(); i++)
        {
            arg.get(i).readCard();
        }
    }

    public static void cardPriorityReadingTest(ArrayList<Card> arg)
    {
        for (int i = 0; i < arg.size(); i++)
        {
            arg.get(i).readCardPriority();
        }
    }

    public static void cardAllInfoReadingTest(ArrayList<Card> arg)
    {
        for (int i = 0; i < arg.size(); i++)
        {
            arg.get(i).readCard();
            arg.get(i).readCardPriority();
        }
    }

    public static void cardTypeAndColorReadingTest(Card arg)
    {
        arg.readCard();
    }

    public static void cardPriorityReadingTest(Card arg)
    {
        arg.readCardPriority();
    }

    public static void cardAllInfoReadingTest(Card arg)
    {
        arg.readCard();
        arg.readCardPriority();
    }

    public static void everythingRandomMoneyNotEqual(GameController testedGame)
    {

    }

    public static void everythingRandomMoneyIsEqual(GameController testedGame)
    {

    }

    public static void checkTypesInformation()
    {

    }

    public static void checkColorsInformation()
    {

    }

    public static void deckSizeTest()
    {

    }
}
