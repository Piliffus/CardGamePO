import java.util.ArrayList;
import java.util.Scanner;

public class GameController
{
    private ArrayList<Player> players;
    private boolean gameEnd;
    private int howManyPlayers;
    private int stake;
    private int pool;
    private Deck deck;

    public void Start(int arg, int[] arg2, int arg3)
    {
        this.howManyPlayers = arg;
        players = new ArrayList<>(howManyPlayers);

        for (int i = 0; i < howManyPlayers; i++)
        {
            players.add(i, new Player(arg2[i]));
        }

        stake = arg3;
        pool = 0;
        playRound();
    }

    private void playRound()
    {
        takeMoney();
        prepareCards();
        giveCards();
        //givePrize(whoWon());
        //resignations();
    }

    private void giveCards()
    {
        int currentCard = 0;

        for (int i = 0; i < players.get(0).getHandSize(); i++)
        {
            for (int y = 0; y < howManyPlayers; y++)
            {
                players.get(y).giveCard(deck.getCard(currentCard));
                currentCard++;
            }
        }
    }

    private void prepareCards()
    {
        deck = new Deck();
        //deck.shuffle();
    }

    private void takeMoney()
    {
        for(int i = 0; i < howManyPlayers; i++)
        {
            players.get(i).setMoney(players.get(i).getMoney() - this.stake);
            this.pool = this.pool + this.stake;
        }
    }

    private void giveMoney(int [] moneyTemp, int howManyPlayersTemp, Scanner scanner)
    {
        System.out.println("Assign money to the players");

        for (int i = 0; i < howManyPlayersTemp; i++)
        {
            System.out.println("How much money for player " + (i+1) + "?");
            moneyTemp[i] = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private int askForStakes(Scanner scanner)
    {
        System.out.println("How high should the stakes be?");
        int stakesTemp = scanner.nextInt();
        scanner.nextLine();
        return stakesTemp;
    }

    public void Start()
    {
        Scanner scanner = new Scanner(System.in);
        int howManyPlayersTemp = 0;
        int[] moneyTemp = askForPlayers(scanner, howManyPlayersTemp);
        giveMoney(moneyTemp, howManyPlayersTemp, scanner);
        int stakesTemp = askForStakes(scanner);
        Start(howManyPlayersTemp, moneyTemp, stakesTemp);
    }

    private int[] askForPlayers(Scanner scanner, int howManyPlayersTemp)
    {
        System.out.print(
                "Choose number of players:\n" +
                "  a) - 2 players\n" +
                "  b) - 3 players\n" +
                "  c) - 4 players\n" +
                "  d) - 5 players\n" +
                "  e) - 6 players\n");

        while (howManyPlayersTemp == 0)
        {
            switch (scanner.nextLine().toLowerCase())
            {
                case "a":
                    howManyPlayersTemp = 2;
                    break;
                case "b":
                    howManyPlayersTemp = 3;
                    break;
                case "c":
                    howManyPlayersTemp = 4;
                    break;
                case "d":
                    howManyPlayersTemp = 5;
                    break;
                case "e":
                    howManyPlayersTemp = 6;
                    break;
                default:
                    howManyPlayersTemp = 0;
                    break;
            }
        }

        return new int[howManyPlayersTemp];
    }

    public GameController()
    {
        this.gameEnd = false;
    }
}
