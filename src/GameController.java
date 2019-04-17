import java.util.ArrayList;
import java.util.Scanner;

public class GameController
{
    private ArrayList<Player> players;
    private boolean gameEnd;
    private int howManyPlayers;

    public void Start(int arg)
    {
        this.howManyPlayers = arg;
    }

    public void Start()
    {
        Scanner scanner = new Scanner(System.in);
        int howManyPlayersTemp = 0;

        System.out.print("Choose number of players:\n" +
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

        Start(howManyPlayersTemp);
    }


}
