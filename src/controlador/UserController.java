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
        //inicializamos el acceso a los datos
        userDA = new UserDA();
    }
    public User startSession(String username, String password) throws Exception{
        //iniciamos sesion
        return userDA.startSession(username, password);
    }
    public void insertUser(User user)throws Exception{
        //insertamos un usuario a la base de datos
        userDA.insertUser(user);
    }
    public String match(User user)throws Exception{
        //obtenemos los resultados
        return userDA.match(user);
    }
    public void updateUser(User user)throws Exception{
        //actualizamos los datos
        userDA.updateUser(user);
    }
}
