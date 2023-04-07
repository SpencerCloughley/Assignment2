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
        setName(name);
        setAuthorFirstName(authorFirstName);
        setAuthorLastName(authorLastName);
        setISBN(ISBN);
        setPrice(price);
        setFileName();
    }

    /**
     * @return returns the name of the book
     */
    public String getName() {return name;    }

    /**
     *
     * @param name accepts any book name longer than 2 characters
     *             will capitalize the first letter of every word after a space
     */
    public void setName(String name) {
        while(name.contains("  ")){
            //removes any instance of double space and prevents entering "    " as a valid name
            name=name.replace("  "," ");
        }
        if(name.length()>2) {
            String words[] = name.split(" ");
            String properName = "";
            for (String word : words) {
                word = word.toLowerCase();
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
                properName += word + " ";
            }
            properName = properName.trim();
            this.name = properName;
        }
        else throw new IllegalArgumentException(name + " is invalid, name of the book must be longar than 2 characters");
    }

    /**
     * @return returns the first name of the author
     */
    public String getAuthorFirstName() {return authorFirstName;    }

    /**
     *
     * @param firstName sets the first name of the author
     *                  capitalizes the first letter and lowercase the rest
     */
    public void setAuthorFirstName(String firstName) {
        firstName = firstName.replace(" ","");
        if(firstName.length()>2) {
            firstName = formatName(firstName);
            this.authorFirstName = firstName;
        }
        else
            throw new IllegalArgumentException(firstName + " invalid, must be longer than 2 characters");
    }

    /**
     * @return returns the last name of the author
     */
    public String getAuthorLastName() {return authorLastName;    }

    /**
     *
     * @param lastName sets the last name of the author
     *                  capitalizes the first letter and lowercase the rest
     */
    public void setAuthorLastName(String lastName) {
        lastName = lastName.replace(" ","");
        if(lastName.length()>2) {
            lastName = formatName(lastName);
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
        if(ISBN.length() == 13) {
            if (ISBN.substring(0,3).equals("978")) {
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

    public String toString(){
        return this.name + " by " + this.authorFirstName + " " + this.authorLastName;
    }
    private String formatName(String name){
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        name = name.trim();
        return name;
    }
}
