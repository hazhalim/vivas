public class Book
{

    // Instance variables
    private String title;
    private String author;
    private String ISBN;

    // Constructors
    public Book() // Default constructor
    {

        throw new IllegalArgumentException("No arguments passed into constructor");

    }

    public Book(String title, String author, String ISBN)
    {

        this.title = title;
        this.author = author;
        this.ISBN = ISBN;

    }

    // Accessor and mutator methods
    // Accessor methods
    String getTitle()
    {

        return this.title;

    }

    String getAuthor()
    {

        return this.author;

    }

    String getISBN()
    {

        return this.ISBN;

    }

    // Mutator methods
    void setTitle(String title)
    {

        if (!title.isEmpty())
        {

            this.title = title;

        } else {

            throw new IllegalArgumentException("Book title cannot be left blank");

        }

    }

    void setAuthor(String author)
    {

        if (!author.isEmpty())
        {

            this.author = author;

        } else {

            throw new IllegalArgumentException("Book author cannot be left blank");

        }

    }

    void setISBN(String ISBN)
    {

        if (!ISBN.isEmpty())
        {

            this.ISBN = ISBN;

        } else {

            throw new IllegalArgumentException("Book ISBN cannot be left blank");

        }

    }

    // Other methods

}