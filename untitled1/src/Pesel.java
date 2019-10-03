import java.util.ArrayList;
import java.util.List;

public class Pesel
{
    private final String mPesel;

    public Pesel(String pesel)
    {
        mPesel = pesel;
    }

    public String GetPesel()
    {
        return mPesel;
    }

    public static boolean Check(String pesel)
    {
        int calculatedSum = 0;
        List<Integer> peselMultipliers = new ArrayList<Integer>();
        peselMultipliers.add(9);
        peselMultipliers.add(7);
        peselMultipliers.add(3);
        peselMultipliers.add(1);

        for(int i = 0; i < pesel.length() - 1; i++)
        {
            char currentLetter = pesel.charAt(i);
            calculatedSum +=  peselMultipliers.get(i % 4) * Character.getNumericValue(currentLetter);
        }

        if (calculatedSum % 10 == Character.getNumericValue(pesel.charAt(pesel.length() - 1)))
        {
            return true;
        }

        return false;
    }
}
