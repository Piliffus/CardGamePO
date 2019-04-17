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
    private int roundNumber;

    private int howManyPlayersTemp; //used by input/output functions

    public void Start(int playerAmount, int[] playerWallets, int stake)
    {
        this.howManyPlayers = playerAmount;
        this.players = new ArrayList<>(this.howManyPlayers);

        for (int i = 0; i < this.howManyPlayers; i++)
        {
            this.players.add(i, new Player(playerWallets[i]));
        }

        this.stake = stake;
        this.pool = 0;

        this.roundNumber = 0;

        playRound();
    }

    private void playRound()
    {
        Player winner;
        this.roundNumber++;
        clearCards();
        takeMoney();
        prepareCards();
        giveCards();
        winner = whoWon();
        givePrize(winner);
        resignations();
        report(winner);

        if (!gameEnd)
        {
            playRound();
        }
    }

    private void report(Player winner)
    {
        System.out.println("The results of round " + this.roundNumber + " are as follows:");

        for (int i = 0; i < this.howManyPlayers; i++)
        {
            System.out.println("Player " + (i+1) + " has following cards:");
            this.players.get(i).sayCards();
        }

        System.out.println("The winner of this round is player " + (this.players.indexOf(winner)+1));

        for (int i = 0; i < this.howManyPlayers; i++)
        {
            System.out.println("Player " + (i+1) + " has " + players.get(i).getMoney() + "$ remaining");
        }

        if (this.gameEnd)
        {
            System.out.println("The game is over");
        }
    }

    private void resignations()
    {
        for (int i = 0; i < this.howManyPlayers; i++)
        {
            if (this.players.get(i).getMoney() < stake)
            {
                this.gameEnd = true;
                break;
            }
        }
    }

    private void givePrize(Player winner)
    {
        winner.setMoney(winner.getMoney() + this.pool);
        this.pool = 0;
    }

    private Player whoWon()
    {
        int highestValue = -1;
        Player winner = null;

        for (int i = 0; i < howManyPlayers; i++)
        {
            if (players.get(i).highestCard().getPriority() > highestValue)
            {
                highestValue = players.get(i).highestCard().getPriority();
                winner = players.get(i);
            }

            if (highestValue >= (TypeInfo.highestTypeValue() + ColorInfo.highestColorValue()))
            {
                break;
            }
        }

        return winner;
    }

    private void clearCards()
    {
        for (int i = 0; i < howManyPlayers; i++)
        {
            players.get(i).takeCardsAway();
        }
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

    private void giveMoney(int [] moneyTemp, Scanner scanner)
    {
        System.out.println("Assign money to the players");

        for (int i = 0; i < this.howManyPlayersTemp; i++)
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
        this.howManyPlayersTemp = 0;
        Scanner scanner = new Scanner(System.in);
        int[] moneyTemp = askForPlayers(scanner);
        giveMoney(moneyTemp, scanner);
        int stakesTemp = askForStakes(scanner);
        Start(howManyPlayersTemp, moneyTemp, stakesTemp);
    }

    private int[] askForPlayers(Scanner scanner)
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
