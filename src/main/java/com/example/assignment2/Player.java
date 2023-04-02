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

    public Player(String firstName, String lastName, String username, String position, int kills, int deaths, int assists, ArrayList<String> champions) {
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPosition(position);
        setKills(kills);
        setDeaths(deaths);
        setAssists(assists);
        setKda();
        setChampions(champions);
    }

    /**
     * @return returns the first name of the player
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     *  set the first name of the player
     *  validates that it is longer than 2 characters
     *  sets it to format of "Spencer"
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if(firstName.length()>2) {
            firstName = firstName.toLowerCase();
            firstName = firstName.substring(0,1).toUpperCase() +firstName.substring(1);
            firstName = firstName.trim();
            this.firstName = firstName;
        }
        else
            throw new IllegalArgumentException(firstName + " invalid, must be longer than 2 characters");
    }

    /**
     * @return returns the last name of the player
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *  set the last name of the player
     *  validates that it is longer than 2 characters
     *  set it to format of "Cloughley"
     * @param lastName
     */
    public void setLastName(String lastName) {
        if(lastName.length()>2) {
            lastName = lastName.toLowerCase();
            lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
            lastName = lastName.trim();
            this.lastName = lastName;
        }
        else
            throw new IllegalArgumentException(lastName + " invalid, must be longer than 2 characters");
    }

    /**
     * @return returns the players username
     */
    public String getUsername() {
        return username;
    }

    /**
     *  sets the username of the player
     *  can be in any format, all uppercase, all lowercase, a mix, etc.
     *  must be longer than 2 characters
     *
     * @param username
     */
    public void setUsername(String username) {
        if(lastName.length()>2) {
            this.lastName = lastName;
        }
        else
            throw new IllegalArgumentException(lastName + " invalid, must be longer than 2 characters");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public double getKda() {
        return kda;
    }

    public void setKda() {

    }

    public ArrayList<String> getChampions() {
        return champions;
    }

    public void setChampions(ArrayList<String> champions) {
        this.champions = champions;
    }
}
