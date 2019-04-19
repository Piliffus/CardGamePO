import java.util.ArrayList;
import java.util.Random;
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

    public void setup()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a) Random simulation\nb) Random simulation with equal money\nc) Manual data input\n");

        String input = "wrongInput";

        while (input.equals("wrongInput"))
        {
            input = scanner.nextLine().toLowerCase();

            switch (input)
            {
                case "a":
                    this.everythingRandomSimulation(false);
                    break;
                case "b":
                    this.everythingRandomSimulation(true);
                    break;
                case "c":
                    this.start();
                    break;
                default:
                    input = "wrongInput";
                    break;
            }
        }
    }

    private void everythingRandomSimulation(boolean equalMoney)
    {
        Random generator = new Random();
        int players = (generator.nextInt(4)+2);
        int[] playerWallets = new int[players];
        int money = 0;
        int lowestMoney = 9990 + 10;

        if (equalMoney)
        {
            money = generator.nextInt(9990)+10; // 10 000 (9 990 + 10) could be replaced with max int - 10
        }

        for (int i = 0; i < players; i++)
        {
            if (!equalMoney)
            {
                money =  generator.nextInt(9990)+10;
            }

            if (money < lowestMoney)
            {
                lowestMoney = money;
            }

            playerWallets[i] = money;
        }

        int stakes = lowestMoney / (generator.nextInt(8)+2);

        System.out.println("Running game with " + players + " players. Stake is " + stakes + "$");
        for (int i = 0; i < players; i++)
        {
            System.out.println("Player " + (i+1) + " starts with " + playerWallets[i] + "$");
        }

        this.start(players, playerWallets, stakes);
    }

    private void start(int playerAmount, int[] playerWallets, int stake)
    {
        this.gameEnd = false;
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
        else
        {
            playAgain();
        }
    }

    private void playAgain()
    {
        String input = "wrongInput";
        Scanner scanner = new Scanner(System.in);

        while (input.equals("wrongInput"))
        {
            System.out.println("Do you want to run another simulation? y/n");
            input = scanner.nextLine().toLowerCase();
            switch (input)
            {
                case "y":
                    this.setup();
                    break;
                case "n":
                    break;
                default:
                    input = "wrongInput";
                    break;
            }
        }
    }

    private void report(Player winner)
    {
        System.out.println();
        System.out.println("The results of round " + this.roundNumber + " are as follows:");

        for (int i = 0; i < this.howManyPlayers; i++)
        {
            System.out.println("Player " + (i+1) + " has following cards:");
            this.players.get(i).sayCards();
        }

        System.out.print("The winner of this round is player " + (this.players.indexOf(winner)+1) +
                ", and the winning card is ");
        this.players.get(this.players.indexOf(winner)).highestCard().readCard();
        System.out.print("\n");

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
        deck.shuffle();
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

    private void start()
    {
        this.howManyPlayersTemp = 0;
        Scanner scanner = new Scanner(System.in);
        int[] moneyTemp = askForPlayers(scanner);
        giveMoney(moneyTemp, scanner);
        int stakesTemp = askForStakes(scanner);
        start(howManyPlayersTemp, moneyTemp, stakesTemp);
    }

    private int[] askForPlayers(Scanner scanner)
    {
        while (howManyPlayersTemp == 0)
        {
            System.out.print(
                    "Choose number of players:\n" +
                            "  a) - 2 players\n" +
                            "  b) - 3 players\n" +
                            "  c) - 4 players\n" +
                            "  d) - 5 players\n" +
                            "  e) - 6 players\n");


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
    }
}
