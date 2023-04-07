package com.example.assignment2;

import javafx.scene.image.Image;

public class Book {
    private String name;
    private String authorFirstName;
    private String authorLastName;
    private String ISBN;
    private double price;
    private String fileName;

    public Book(String name, String authorFirstName, String authorLastName, String ISBN, double price) {
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.ISBN = ISBN;
        this.price = price;
        setFileName();
    }

    /**
     * @return returns the name of the book
     */
    public String getName() {return name;    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return returns the first name of the author
     */
    public String getAuthorFirstName() {return authorFirstName;    }

    public void setAuthorFirstName(String firstName) {
        if(firstName.length()>2) {
            firstName = firstName.toLowerCase();
            firstName = firstName.substring(0,1).toUpperCase() +firstName.substring(1);
            firstName = firstName.trim();
            this.authorFirstName = firstName;
        }
        else
            throw new IllegalArgumentException(firstName + " invalid, must be longer than 2 characters");
    }

    /**
     * @return returns the last name of the author
     */
    public String getAuthorLastName() {return authorLastName;    }

    public void setAuthorLastName(String lastName) {
        if(lastName.length()>2) {
            lastName = lastName.toLowerCase();
            lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
            lastName = lastName.trim();
            this.authorLastName = lastName;
        }
        else
            throw new IllegalArgumentException(lastName + " invalid, must be longer than 2 characters");
    }

    /**
     * @return returns the international standard book number for the book
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     *
     * @param ISBN the ISBN of the book
     *             must start with 978 and is 13 digits long
     */
    public void setISBN(String ISBN) {
        if(ISBN.substring(0,3).equals("978")) {
            if (ISBN.length() == 13) {
                for (int i = 0; i < ISBN.length(); i++) {
                    if (!Character.isDigit(ISBN.charAt(i))) {
                        throw new IllegalArgumentException(ISBN + " is invalid, ISBN must be all numbers, 13 numbers long and start with 978");
                    }
                }
                this.ISBN = ISBN;
            }
            else throw new IllegalArgumentException(ISBN + " is invalid, ISBN must be all numbers, 13 numbers long and start with 978");
        }
        else throw new IllegalArgumentException(ISBN + " is invalid, ISBN must be all numbers, 13 numbers long and start with 978");

    }

    /**
     * @return returns the price of the book
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price sets the price of the book
     *              must be within $9.99 and $99.99
     */
    public void setPrice(double price) {
        if(price>=9.99 && price <=99.99)
            this.price = price;
        else
            throw new IllegalArgumentException(price + " invalid, must be between 9.99 and 99.99");
    }

    /**
     * @return returns the String version of the fileName
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * sets the name of the image file for the book as the ISBN.png
     */
    public void setFileName() {
        this.fileName = "images/" + this.ISBN + ".png";
    }

    public Image getImage(){
        return new Image(Book.class.getResourceAsStream(fileName));
    }
}
