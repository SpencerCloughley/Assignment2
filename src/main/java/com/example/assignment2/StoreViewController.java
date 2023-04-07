package com.example.assignment2;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreViewController implements Initializable {

    @FXML
    private Label ISBNLabel;

    @FXML
    private Button addBook;
    @FXML
    private ListView<Book> bookList;

    @FXML
    private Label authorLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label storeLabel;

    @FXML
    private Label titleLabel;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField authorField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField ISBNField;
    @FXML
    private ImageView bookView;
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
    All ISBNs will work with the setISBN, these are the ones that I have included pictures for
    */

    private Store Indigo;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Book Berserk=new Book("Berserk", "Kentaro","Miura","9781506711980",65.99);
        Book TheInstitute=new Book("The Institute","Stephen","King","9781982110581",30.99);
        Book DemonSlayer=new Book("Demon Slayer Volume 1","Koyoharu","Gotouge","9781974700523",12.99);
        ArrayList<Book> stock = new ArrayList<>();
        stock.add(Berserk);
        stock.add(TheInstitute);
        stock.add(DemonSlayer);
        Indigo=new Store("Indigo",stock);
        updateLabels();
        displayBook(Indigo.getStock().get(0));
    }
    private void updateLabels(){
        bookList.setItems(FXCollections.observableArrayList(Indigo.getStock()));
        storeLabel.setText(Indigo.getName());
        errorLabel.setText("");
    }

    private void displayBook(Book display){
        bookView.setImage(display.getImage());
        titleLabel.setText(display.getName());
        authorLabel.setText(display.getAuthorFirstName() + " " + display.getAuthorLastName());
        priceLabel.setText(Double.toString(display.getPrice()));
        ISBNLabel.setText(display.getISBN());
    }
    @FXML
    void addBook(ActionEvent event) {
        try {
            String title = titleField.getText();
            String author = authorField.getText();
            double price = Double.parseDouble(priceField.getText());
            String ISBN = ISBNField.getText();
            String names[] = author.split(" ");
            if(names.length>1) {
                String authorFirst = names[0];
                String authorLast = names[1];
                try {
                    Book temp = new Book(title, authorFirst, authorLast, ISBN, price);
                    Indigo.getStock().add(temp);
                } catch (Exception e) {
                    errorLabel.setText(e.getMessage());
                }
                updateLabels();
            }
            else {
                errorLabel.setText("Please enter first and last name for author");
            }
        }catch (Exception e){
            errorLabel.setText("Please fill out all fields correctly");
        }
    }

    @FXML
    void changeBook(MouseEvent event) {
        try {
            Book current = bookList.getSelectionModel().getSelectedItem();
            displayBook(current);
        }
        catch (Exception e){

        }
    }
}

