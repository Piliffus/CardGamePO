public class Main
{
    // TODO Manual input wrong simulations - money, stakes input > int, wrong inputs at money and stakes,
    //  stakes larger than money or too small
    //  buffer overflow (to many rounds) - hard limit and too big difference between mon and stk, money <= 0, stakes <= 0,


    // TODO better shuffling???
    // TODO tools for running large numbers of simulations

    public static void main(String[] args)
    {
        GameController gameController = new GameController();
        gameController.setup();
    }
}
