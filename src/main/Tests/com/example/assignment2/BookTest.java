package com.example.assignment2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class BookTest {

    private Book Berserk;
    private Book TheInstitute;
    @org.junit.Before
    public void setUp() throws Exception {
        Berserk=new Book("Berserk", "Kentaro","Miura","9781506711980",65.99);
        TheInstitute=new Book("The Institute","Stephen","King","9781982110581",30.99);
    }

    @org.junit.Test
    public void setName() {
        assertEquals("Berserk",Berserk.getName());
        assertEquals("The Institute",TheInstitute.getName());
        TheInstitute.setName("the    institute");
        assertEquals("The Institute",TheInstitute.getName());
        Berserk.setName("berserk");
        assertEquals("Berserk",Berserk.getName());
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setName("     ");});
    }

    @org.junit.Test
    public void setAuthorFirstName() {
        assertEquals("Kentaro",Berserk.getAuthorFirstName());
        assertEquals("Stephen",TheInstitute.getAuthorFirstName());
        Berserk.setAuthorFirstName("KenTAro");
        assertEquals("Kentaro",Berserk.getAuthorFirstName());
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setAuthorFirstName("  ");});
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setAuthorFirstName("   ");});
    }

    @org.junit.Test
    public void setAuthorLastName() {
        assertEquals("Miura",Berserk.getAuthorLastName());
        Berserk.setAuthorLastName("miuRA ");
        assertEquals("Miura",Berserk.getAuthorLastName());
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setAuthorLastName("  ");});
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setAuthorLastName("    ");});
    }

    @org.junit.Test
    public void setISBN() {
        assertEquals("9781506711980",Berserk.getISBN());
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setISBN("1506711987");});
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setISBN("978150671198700");});
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setISBN("97815aa711980");});
    }

    @org.junit.Test
    public void setPrice() {
        assertEquals(65.99,Berserk.getPrice(),0.0);
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setPrice(109.99);});
        Assertions.assertThrows(IllegalArgumentException.class,()->{Berserk.setPrice(1.99);});
    }

    @org.junit.Test
    public void setFileName() {
        assertEquals("images/9781506711980.png",Berserk.getFileName());
    }
}