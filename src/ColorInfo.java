public class ColorInfo
{
    static public String[] getColorNames()
    {
        String[] names = {"club", "diamond", "heart", "spade"};
        return names;
    }

    public static int highestColorValue()
    {
        return 3;
    }

    static public int howManyColors()
    {
        return 4;
    }

    static public int assignPriority(String arg)
    {
        switch (arg)
        {
            case "club":
                return 0;
            case "diamond":
                return 1;
            case "heart":
                return 2;
            case "spade":
                return 3;
            default:
                return -1; // ERROR
        }
    }
}
