/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.User;

/**
 *
 * @author KELLY
 */
public class UserDA {
    
    public User startSession(String username,String password) throws Exception{
        User user_response = new User();
        Connection con = DAInfo.getConnection();
	Statement stmt = null;
        String query = "select * from usuario_project where username = '" + username + "' and password= '"+password+"'";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int counter=0;
        while(rs.next()){
            user_response.setName(rs.getString("name"));
            user_response.setSex(rs.getString("sex"));
            user_response.setDetails("details");
            user_response.setPassword(password);
            user_response.setUsername(username);
            counter++;
        }
        if(counter>=1){
            con.close();
            return user_response;
        }else{ 
            con.close();
            return null;
        }
        
    }
    public void insertUser(User user)throws Exception{
        Connection con = DAInfo.getConnection();
        Statement stmt = null;
        String preferences=user.getPreferences().get(0)+","+
                user.getPreferences().get(1)+","+user.getPreferences().get(2)+","+
                user.getPreferences().get(3)+","+user.getPreferences().get(4)+","+
                user.getPreferences().get(5);
        String query = "INSERT INTO usuario_project (username,password,name,details,sex) "
                + "values('"+user.getUsername()+"','"+user.getPassword()+
                "','"+user.getName()+"','"+preferences+"','"+user.getSex()+"')";
        System.out.println(query);
        stmt = con.createStatement();
        stmt.executeUpdate(query);
        con.close();
    }
    public String match(User user){
        return null;
    }
}
