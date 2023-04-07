package com.example.assignment2;

import java.util.ArrayList;

public class Store {

    /*ISBN's with pictures available
    9781982110581 - The Institute by Stephen King
    9780062316110 - Sapiens by Yuval Harari
    9780593157701 - Star Wars: Thrawn Ascendancy Book I by Timothy Zahn
    9780593358573 - Star Wars: Brotherhood by Mike Chen
    9780786838653 - The Lightning Thief by Rick Riordan
    9781506711980 - Berserk Deluxe Volume 1 by Kentaro Miura
    9781635575583 - A Court of Thorns And Rose by Sarah Maas
    9781668002179 - Fairy Tale by Stephen King
    9781974700523 - Demon Slayer Volume 1 by Koyoharu Gotouge
    9781982173623 - Billy Summers by Stephen King
    */
    private String name;
    private ArrayList<Book> stock;

    public Store(String name, ArrayList<Book> stock) {
        setName(name);
        setStock(stock);
    }

    public String getName() {
        return name;
    }

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
        else throw new IllegalArgumentException(name + " is invalid, store name must be at least 2 characters long");
    }

    public ArrayList<Book> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Book> stock) {
        if(!stock.isEmpty())
            this.stock = stock;
        else throw new IllegalArgumentException(" Stock is invalid, it must contain at least 1 book");
    }
}
