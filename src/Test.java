import java.util.ArrayList;
import java.util.Arrays;

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
        String[] testedNames = TypeInfo.getTypeNames();
        String[] expectedNames = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "jack", "queen", "king", "ace"};

        int testedTypesNumber = TypeInfo.howManyTypes();
        int expectedTypesNumber = expectedNames.length;

        int testedHighestValue = TypeInfo.highestTypeValue();
        int expectedHighestValue = TypeInfo.assignPriority(expectedNames[expectedNames.length-1]); // could be updated with info from colortests

        System.out.println("Checking TypeInfo:");
        testNames(testedNames, expectedNames);
        System.out.println();
        testTypesNumber(testedTypesNumber, expectedTypesNumber);
        System.out.println();
        testHighestValue(testedHighestValue, expectedHighestValue);
    }

    private static void testHighestValue(int testedHighestValue, int expectedHighestValue)
    {
        System.out.println("Expected highest value is " + expectedHighestValue +
            " and the number used by simulation is " + testedHighestValue);
        System.out.println("The highest value is " + (testedHighestValue == expectedHighestValue ? "correct" : "wrong"));
    }

    private static void testTypesNumber(int testedTypesNumber, int expectedTypesNumber)
    {
        System.out.println("Expected number of types is " + expectedTypesNumber +
                " and the number used by simulation is " + testedTypesNumber);
        System.out.println("The number of types is " + (testedTypesNumber == expectedTypesNumber ? "correct" : "wrong"));
    }

    private static void testNames(String[] testedNames, String[] expectedNames)
    {
        System.out.println("Expected names of types are:");
        for (int i = 0; i < expectedNames.length; i++)
        {
            System.out.print(expectedNames[i] + " ");
        }
        System.out.print('\n');

        System.out.println("Names of types used by simulation are:");
        for (int i = 0; i < testedNames.length; i++)
        {
            System.out.print(testedNames[i] + " ");
        }
        System.out.print('\n');

        if (Arrays.equals(testedNames, expectedNames))
        {
            System.out.println("No discrepancy detected");
        }

        else System.out.println("Discrepancy detected");
    }

    public static void checkColorsInformation()
    {

    }

    public static void deckSizeTest(Deck deck)
    {
        int testedSize = deck.getCards().size();
        int expectedSize = ColorInfo.howManyColors() * TypeInfo.howManyTypes();

        System.out.println("The size of the deck is" + testedSize + "and the expected number is " + expectedSize);
        System.out.println("The size is " + (testedSize == expectedSize ? "correct" : "wrong"));
    }
}
