import java.util.ArrayList;

public class Test
{
    public static void readCardTest(ArrayList<Card> arg)
    {
        for (int i = 0; i < arg.size(); i++)
        {
            arg.get(i).readCard();
        }
    }

    public static void cardPriorityTest(ArrayList<Card> arg)
    {
        for (int i = 0; i < arg.size(); i++)
        {
            arg.get(i).readCardPriority();
        }
    }

    public static void cardNameAndPriorityTest(ArrayList<Card> arg)
    {
        for (int i = 0; i < arg.size(); i++)
        {
            arg.get(i).readCard();
            arg.get(i).readCardPriority();
        }
    }
}
