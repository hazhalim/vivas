import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library
{

    // Instance variables
    private List<Book> bookList;
    private int bookListSize;

    // Constructors
    public Library()
    {

        this.bookList = new ArrayList<>();
        this.bookListSize = this.bookList.size();

    }

    public Library(List<Book> bookList)
    {

        this.bookList = bookList;
        this.bookListSize = bookList.size();

    }

    // Accessor and mutator methods
    // Accessor methods
    public List<Book> getBookList()
    {

        return this.bookList;

    }

    public int getBookListSize()
    {

        return this.bookListSize;

    }

    public void setBookList(List<Book> bookList)
    {
        if (bookList != null)
        {

            this.bookList = bookList;

        } else {

            throw new IllegalArgumentException("Book list cannot be set to null");

        }

    }

    public void setBookListSize(int bookListSize)
    {

        if (bookListSize >= 0)
        {

            this.bookListSize = bookListSize;

        } else {

            throw new IllegalArgumentException("Book list size must be at least 0");

        }

    }

    // Other methods
    void addBook(Book book)
    {

        bookList.add(book);

    }

    void removeBook(String ISBN)
    {

        for (Book book : bookList)
        {

            if (book.getISBN().equals(ISBN))
            {

                bookList.remove(book);

                return;

            }

        }

        throw new IllegalArgumentException("Error: There is no book with the ISBN value provided.");

    }

    void findBooksByTitle(String title)
    {

        System.out.println("Books with title '" + title + "':");

        for (Book book : bookList)
        {

            if (book.getTitle().equals(title))
            {

                System.out.println("-\tTitle: " + book.getTitle());
                System.out.println("\tAuthor: " + book.getAuthor());
                System.out.println("\tISBN: " + book.getISBN());

                System.out.println();

            }

        }

    }

    void findBooksByAuthor(String author)
    {

        System.out.println("Books by author '" + author + "':");

        for (Book book : bookList)
        {

            if (book.getAuthor().equals(author))
            {

                System.out.println("-\tTitle: " + book.getTitle());
                System.out.println("\tAuthor: " + book.getAuthor());
                System.out.println("\tISBN: " + book.getISBN());

                System.out.println();

            }

        }

    }

    boolean isPrime(int number)
    {

        if (number < 2)
        {

            return false;

        }

        for (int i = 2; i <= Math.sqrt((double) number); i++)
        {

            if ((number % i) == 0)
            {

                return false;


            }

        }

        return true;

    }

    boolean borrowBook(String ISBN)
    {

        int isbnLength = ISBN.length();

        int lastTwoISBNDigits = Integer.parseInt(ISBN.substring(isbnLength - 2 , isbnLength));

        return isPrime(lastTwoISBNDigits);

    }

    void sortBooks()
    {

        displayLibrary();

    }

    void displayLibrary()
    {

        List<Book> sortedBookList = getBookList();
        sortedBookList.sort(Comparator.comparing(Book::getTitle));

        System.out.println("Books in the library, sorted by title:");

        for (Book book : sortedBookList)
        {

            System.out.println("-\t Title: " + book.getTitle());
            System.out.println("\tAuthor: " + book.getAuthor());
            System.out.println("\tISBN: " + book.getISBN());

            System.out.println();

        }

    }

    void displayLibrary(List<Book> bookList)
    {

        bookList.sort(Comparator.comparing(Book::getTitle));

        System.out.println("Books in the library, sorted by title:");
        System.out.println();

        for (Book book : bookList)
        {

            System.out.println("-\tTitle: " + book.getTitle());
            System.out.println("\tAuthor: " + book.getAuthor());
            System.out.println("\tISBN: " + book.getISBN());

            System.out.println();

        }

    }

}