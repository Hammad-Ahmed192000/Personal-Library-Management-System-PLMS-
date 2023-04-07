package finalProject;

class passwordException extends Exception
{
    public String toString()
    {
        return "password must be 8-digits";
    }
}
