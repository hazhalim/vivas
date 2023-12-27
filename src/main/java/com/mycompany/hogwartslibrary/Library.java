
package com.mycompany.hogwartslibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Library {

    private final String fileName = "HogwartsLibrary.csv";
    private final String tempFileName = "tempHogwartsLibrary.csv";

    // method use to Register the book into the system.
    public void addBook(Book book) {
        try {
            FileWriter file = new FileWriter(fileName, true);
            file.write(book.title + "," + book.author + "," + book.isbnCode + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method use to find book by author's name
    public void findBooksByAuthor(String author) {
        System.out.println("Books by author \'" + author + "\' : ");
        try {
            boolean isMatched = false;
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into book information
                String[] bookInfo = line.split(",");
                //Check if the author name matches the given author
                if (bookInfo.length >= 3 && bookInfo[1].equals(author)) {
                    // create the object from Book Class
                    Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2]);
                    displayBook(book);
                    isMatched = true;
                    break;
                }
            }

            if (!isMatched) {
                System.out.println("There are no books by " + author + " in the library.\nSorry for the inconvenience.\n\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method use to find book by title
    public void findBooksByTitle(String title) {
        System.out.println("Books by author \'" + title + "\' : ");
        try {
            boolean isMatched = false;
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into book information
                String[] bookInfo = line.split(",");
                //Check if the title of the book matches the given title
                if (bookInfo.length >= 3 && bookInfo[0].equals(title)) {
                    // create the object from Book Class
                    Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2]);
                    displayBook(book);
                    isMatched = true;
                    break;
                }
            }

            if (!isMatched) {
                System.out.println("There are no book called " + title + " in the library.\nSorry for the inconvenience.\n\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method use to find book by ISBN code.
    public void findBooksByisbnCode(String isbnCode) {
        System.out.println("Checking the availability for borrowing for book with ISBN Code :\'" + isbnCode + "\'");
        try {
            boolean isMatched = false;
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into book information
                String[] bookInfo = line.split(",");
                //Check if the title of the book matches the given title
                if (bookInfo.length >= 3 && bookInfo[2].equals(isbnCode)) {
                    // create the object from Book Class
                    Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2]);
                    displayBook(book);
                    isMatched = true;
                    break;
                }
            }

            if (!isMatched) {
                System.out.println("There are no book for " + isbnCode + " in the library.\nSorry for the inconvenience.\n\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to check the availability of the book for borrowing
    public boolean canBorrow(String isbnCode) {
        int toInt = Integer.parseInt(isbnCode);
        int lastTwoDigit = toInt % 100;
        findBooksByisbnCode(isbnCode);
        return isPrime(lastTwoDigit);
    }

    // method to check if the last 2 digits of ISBN code is a prime number
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // method to display the book that users are looking for.
    public void displayBook(Book book) {
        System.out.println("Book Title : " + book.title + "\nAuthor's Name : " + book.author + "\nISBN : " + book.isbnCode);
    }

    public void sortBooks() {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String[] bookInfo = br.lines().toArray(String[]::new);
            br.close();

            // Bubble sort based on book titles
            for (int i = 0; i < bookInfo.length - 1; i++) {
                for (int j = 0; j < bookInfo.length - i - 1; j++) {
                    String title1 = bookInfo[j].split(",")[0];
                    String title2 = bookInfo[j + 1].split(",")[0];
                    if (title1.compareTo(title2) > 0) {
                        // Swap bookInfo
                        String temp = bookInfo[j];
                        bookInfo[j] = bookInfo[j + 1];
                        bookInfo[j + 1] = temp;
                    }
                }
            }

            // Rewrite the sorted content back to the file
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String sortedLine : bookInfo) {
                bw.write(sortedLine);
                bw.newLine();
            }
            bw.close();

            // Display unique sorted books
            System.out.println("\n\nSorted Unique Books:");
            String previousTitle = "";
            for (String sortedLine : bookInfo) {
                String title = sortedLine.split(",")[0];
                if (!title.equals(previousTitle)) {
                    System.out.println("\nTitle : " + sortedLine.split(",")[0] + "\nAuthor : " + sortedLine.split(",")[1] + "\nISBN : " + sortedLine.split(",")[2]);
                    previousTitle = title;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeBook(String isbnCode) {
        try {
            
            File inputFile = new File(fileName);
            File tempFile = new File(tempFileName);

            FileReader fr = new FileReader(inputFile);
            FileWriter fw = new FileWriter(tempFile);

            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                String[] bookInfo = currentLine.split(",");
                if (bookInfo.length >= 3 && bookInfo[2].equals(isbnCode)) {
                    continue;
                }

                bw.write(currentLine + "\n");
            }
            bw.close();
            br.close();

        } catch (IOException e) {
        }
    }

    public void displayLibrary() {
        try {
            FileReader fr = new FileReader(tempFileName);
            BufferedReader br = new BufferedReader(fr);
            String[] bookInfo = br.lines().toArray(String[]::new);
            String line;

            System.out.println("\n\nUpdated Library Contents:");
            String previousTitle = "";
            for (String sortedLine : bookInfo) {
                String title = sortedLine.split(",")[0];
                if (!title.equals(previousTitle)) {
                    System.out.println("\nTitle : " + sortedLine.split(",")[0] + "\nAuthor : " + sortedLine.split(",")[1] + "\nISBN : " + sortedLine.split(",")[2]);
                    previousTitle = title;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}