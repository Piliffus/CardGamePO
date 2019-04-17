public class TypeInfo
{
    public static int howManyTypes()
    {
        return 13;
    }

    public static String[] getTypeNames()
    {
        String[] names = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "jack", "queen", "king", "ace"};
        return names;
    }

    public static int assignPriority(String arg)
    {
        switch (arg)
        {
            case "two":
                return 0;
            case "three":
                return (ColorInfo.howManyColors());
            case "four":
                return 2 * (ColorInfo.howManyColors());
            case "five":
                return 3 * (ColorInfo.howManyColors());
            case "six":
                return 4 * (ColorInfo.howManyColors());
            case "seven":
                return 5 * (ColorInfo.howManyColors());
            case "eight":
                return 6 * (ColorInfo.howManyColors());
            case "nine":
                return 7 * (ColorInfo.howManyColors());
            case "ten":
                return 8 * (ColorInfo.howManyColors());
            case "jack":
                return 9 * (ColorInfo.howManyColors());
            case "queen":
                return 10 * (ColorInfo.howManyColors());
            case "king":
                return 11 * (ColorInfo.howManyColors());
            case "ace":
                return 12 * (ColorInfo.howManyColors());
            default:
                return -1; // ERROR
        }
    }
}