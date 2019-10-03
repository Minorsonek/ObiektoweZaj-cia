public class Login
{
    private final String Name;
    private final String Password;

    public Login(String name, String password)
    {
        Name = name;
        Password = password;
    }

    public boolean IsEqualTo(Login otherLogin)
    {
        if (Name.equals(otherLogin.GetName()) && Password.equals(otherLogin.GetPassword()))
        {
            return true;
        }

        return false;
    }

    public String GetName()
    {
        return Name;
    }

    public String GetPassword()
    {
        return Password;
    }
}
