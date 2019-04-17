public class ColorInfo
{
    static public String[] getColorNames()
    {
        String[] names = {"clubs", "diamonds", "hearts", "spades"};
        return names;
    }

    static public int howManyColors()
    {
        return 4;
    }

    static public int assignPriority(String arg)
    {
        switch (arg)
        {
            case "clubs":
                return 0;
            case "diamonds":
                return 1;
            case "hearts":
                return 2;
            case "spades":
                return 3;
            default:
                return -1; // ERROR
        }
    }
}
