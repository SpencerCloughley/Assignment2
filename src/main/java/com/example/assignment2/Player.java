package com.example.assignment2;

import java.util.ArrayList;

public class Player {
    //players first name
    private String firstName;

    //players last name
    private String lastName;

    //username the player goes by in game
    private String username;

    //what role the player plays (Top,Jungle, Mid,ADC, Support)
    private String position;

    //amount of kills the player has gotten this season
    private int kills;

    //amount of deaths the player has gotten this season
    private int deaths;

    //amount of assists the player has gotten this season
    private int assists;

    //(kills+assists)/deaths
    private double kda;

    //Characters they play in the game
    private ArrayList<String> champions;
}
