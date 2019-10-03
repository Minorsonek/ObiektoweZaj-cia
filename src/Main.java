import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    /**
     * Main function
     * @param args
     */
    public static void main(String[] args)
    {
        Login properLogin = new Login("Ala", "Makota");

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);

        try
        {
            System.out.print("Podaj swoją nazwę: ");
            String name = buffer.readLine();

            System.out.print("Podaj swoje hasło: ");
            String password = buffer.readLine();

            Login userLogin = new Login(name, password);

            if(properLogin.IsEqualTo(userLogin))
            {
                System.out.print("Prawidłowe hasło, zostałeś zalogowany!");
            }
            else
            {
                System.out.print("Nieprawidłowe hasło, spróbuj ponownie.");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
