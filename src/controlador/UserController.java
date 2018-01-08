/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.UserDA;
import modelo.User;

/**
 *
 * @author KELLY
 */
public class UserController {
    private UserDA userDA;
    public UserController(){
        userDA = new UserDA();
    }
    public User startSession(String username, String password) throws Exception{
        return userDA.startSession(username, password);
    }
    public void insertUser(User user)throws Exception{
        userDA.insertUser(user);
    }
    public String match(User user)throws Exception{
        return userDA.match(user);
    }
}
