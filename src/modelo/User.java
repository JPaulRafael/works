/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author KELLY
 */
public class User {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    private String name;
    private String username;
    private String password;
    private ArrayList<String> preferences;
    private String sex;
    private String details;
    private int points;
    private int id;
    public User(){}
    public User(String name,String username,String password,ArrayList<String>preferences,String sex){
        this.name = name;
        this.username = username;
        this.password = password;
        this.preferences=preferences;
        this.sex=sex;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the preferences
     */
    public ArrayList<String> getPreferences() {
        return preferences;
    }

    /**
     * @param preferences the preferences to set
     */
    public void setPreferences(ArrayList<String> preferences) {
        this.preferences = preferences;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void printDetail(){
        for(int i=0;i<this.preferences.size();i++){
            System.out.println(this.preferences.get(i));
        }
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }
    public int getPoints(){
      return points;
    }
    public void setPoints(int points){
      this.points=points;
    }
}
