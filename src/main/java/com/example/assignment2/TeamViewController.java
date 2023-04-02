package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TeamViewController implements Initializable {

    @FXML
    private Label assistsLabel;

    @FXML
    private Button btnNextPlayer;

    @FXML
    private Button btnNextTeam;

    @FXML
    private ListView<?> championList;

    @FXML
    private Label deathsLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label kdaLabel;

    @FXML
    private Label killsLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private ListView<?> playerList;

    @FXML
    private Label positionLabel;

    @FXML
    private Label teamAcronym;

    @FXML
    private ImageView teamImage;

    @FXML
    private Label teamName;

    @FXML
    private Label usernameLabel;

    @FXML
    void nextPlayer(ActionEvent event) {

    }

    @FXML
    void nextTeam(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
