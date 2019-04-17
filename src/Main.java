public class Main
{

    public static void main(String[] args)
    {
        Deck deck = new Deck();
        Test.readCardTest(deck.getCards());
        Test.cardPriorityTest(deck.getCards());
        Test.cardNameAndPriorityTest(deck.getCards());


    }
}
