package com.example.assignment2;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StoreTest {

    private Store Indigo;
    private Book Berserk;
    private Book TheInstitute;
    private ArrayList<Book> stock;
    @Before
    public void setUp() throws Exception {
        Berserk=new Book("Berserk", "Kentaro","Miura","9781506711980",65.99);
        TheInstitute=new Book("The Institute","Stephen","King","9781982110581",30.99);
        stock = new ArrayList<>();
        stock.add(Berserk);
        stock.add(TheInstitute);
        Indigo = new Store("Indigo",stock);
    }

    @Test
    public void setName() {
        assertEquals("Indigo",Indigo.getName());
        Indigo.setName("indIGo");
        assertEquals("Indigo",Indigo.getName());
        Assertions.assertThrows(IllegalArgumentException.class,()->{Indigo.setName("     ");});
        Indigo.setName("The   STore");
        assertEquals("The Store",Indigo.getName());
    }

    @Test
    public void setStock() {
        assertEquals(stock,Indigo.getStock());
        ArrayList<Book> empty = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,()->{Indigo.setStock(empty);});
    }
}