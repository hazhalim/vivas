/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hogwartslibrary;

/**
 *
 * @author tmhta_
 */
public class HogwartsLibrary {

    public static void main(String[] args) {
        Library hogwartsLibrary = new Library();

        //Register books
        Book book1 = new Book("The Standard Book of Spells", "Miranda Goshawk", "9452297");
        Book book2 = new Book("Advanced Potion-Making", "Libatius Borage", "4826972");
        Book book3 = new Book("Fantastic Beasts and Where to Find Them", "Newt Scamander", "1564815");
        Book book4 = new Book("The Dark Forces: A Guide to Self-Protection", "Quirinus Quirrell", "1891568");
        Book book5 = new Book("Forbidden Spells", "Salazar Slytherin", "7134567");
        
        //Add book into library
        hogwartsLibrary.addBook(book1);
        hogwartsLibrary.addBook(book2);
        hogwartsLibrary.addBook(book3);
        hogwartsLibrary.addBook(book4);
        hogwartsLibrary.addBook(book5);
        
        System.out.println("Hi! Welcome to Hogwarts Main Library.");
                           
        System.out.println("Searching book by author : ");
        hogwartsLibrary.findBooksByAuthor("Miranda Goshawk");
        System.out.println("");
        
        System.out.println("Searching book by title : ");
        hogwartsLibrary.findBooksByTitle("The Standard Book of Spells");
        System.out.println("");
        
        String isbnCode = "7134567";
        boolean canBorrow = hogwartsLibrary.canBorrow(isbnCode);
        if (!canBorrow){
            System.out.println("You've borrowed the book.");
        } else {
            System.out.println("Sorry, this book is not available for borrowing.");
        }

        hogwartsLibrary.sortBooks();
        hogwartsLibrary.removeBook("1564815");
        hogwartsLibrary.displayLibrary();
        
        
    }
}