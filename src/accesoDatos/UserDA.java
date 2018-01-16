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
import utils.QuickSort;

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
            user_response.setId(rs.getInt("id"));
            user_response.setName(rs.getString("name"));
            user_response.setSex(rs.getString("sex"));
            user_response.setDetails(rs.getString("details"));
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
        stmt = con.createStatement();
        stmt.executeUpdate(query);
        con.close();
    }
    public String match(User current_user)throws Exception{
        User user = startSession(current_user.getUsername(),current_user.getPassword());
        Connection con = DAInfo.getConnection();
        Statement stmt = null;
        String query,output;
         query = "SELECT * FROM usuario_project where sex='Man'";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int min=0;
        output="";
        ArrayList<User>sortList=new ArrayList<>();
        while(rs.next()){
            User u=new User();
            u.setName(rs.getString("name"));
            u.setPoints(getPoint(user,rs.getString("details")));
            u.setId(rs.getInt("id"));
            sortList.add(u);

        }

        QuickSort.sort(sortList);
        output+="Nombre: "+sortList.get(0).getName()+ "  -   "+String.format("%.02f",(float)sortList.get(0).getPoints()/6*100)+"%\n";
        output+="Nombre: "+sortList.get(1).getName()+ "  -   "+String.format("%.02f",(float)sortList.get(1).getPoints()/6*100)+"%\n";
        output+="Nombre: "+sortList.get(2).getName()+ "  -   "+String.format("%.02f",(float)sortList.get(2).getPoints()/6*100)+"%\n";
        output+="Nombre: "+sortList.get(3).getName()+ "  -   "+String.format("%.02f",(float)sortList.get(3).getPoints()/6*100)+"%\n";
        return output;
    }
    private int getPoint(User user,String details){
        int result=0;
        String listaMujer[]=details.split(",");
        String listaHombre[]=user.getDetails().split(",");
        for(int i=0;i<6;i++){
            if(listaMujer[i].equals(listaHombre[i]))result++;
        }
        return result;
    }
    public void updateUser(User user)throws Exception{
        Connection con = DAInfo.getConnection();
	Statement stmt = null;
        String preferences=user.getPreferences().get(0)+","+
                user.getPreferences().get(1)+","+user.getPreferences().get(2)+","+
                user.getPreferences().get(3)+","+user.getPreferences().get(4)+","+
                user.getPreferences().get(5);
        String query="UPDATE usuario_project SET details='"+preferences+"' where id="+user.getId()+" ";
        stmt = con.createStatement();
        stmt.executeUpdate(query);
        con.close();
    }
}
