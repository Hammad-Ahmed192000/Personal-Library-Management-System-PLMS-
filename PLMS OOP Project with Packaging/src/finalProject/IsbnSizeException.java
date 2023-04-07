package finalProject;

class IsbnSizeException extends Exception
{
    public String toString()
    {
        return "ISBN must be 13-digits";
    }
}
