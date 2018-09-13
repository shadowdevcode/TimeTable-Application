package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.LoginInfoTO;

public class LoginInfoDAO {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    
    public LoginInfoTO checkLogin(String username , String password){
        try{
            String query = "select username,password,rolename from logininfo where username=? and password=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,username);
            stmt.setString(2,password);
            LoginInfoTO data = null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                data = new LoginInfoTO();
                data.setUserName(rs.getString(1));
                data.setPassword(rs.getString(2));
                data.setRoleName(rs.getString(3));
            }
            rs.close();
            stmt.close();
            return data;
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
       
    public boolean insertRecord (LoginInfoTO data){
    try {
        String query ="insert into logininfo(UserName,Password,RoleName) values(?,?,?)";
        PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
        stmt.setString(1, data.getUserName());
        stmt.setString(2, data.getPassword());
        stmt.setString(3, data.getRoleName());
        boolean ans = stmt.executeUpdate() > 0;
        stmt.close();
        return ans;
    }catch(Exception ex){
        System.out.println(ex.getMessage());
        errorMessage = ex.getMessage();
        return false;
    }
}
    
     public boolean updateRecord(LoginInfoTO data) {
        try {
            String query = "update logininfo set password=?,rolename=? where username=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getPassword());
            stmt.setString(2, data.getUserName());
            stmt.setString(3, data.getRoleName());
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }
     
     public boolean deleteRecord(String username) {
        try {
            String query = "delete from logininfo where username=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, username);
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }

      public LoginInfoTO getRecord(String username) {
        try {
            String query = "select username , password , rolename from logininfo where username=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, username);
            LoginInfoTO ans = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ans = new LoginInfoTO();
                ans.setUserName(rs.getString(1));
                ans.setPassword(rs.getString(2));
            }
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return null;
        }
    }
      
      public ArrayList<LoginInfoTO> getAllRecord() {
        try {
            String query = "select username , password , rolename from logininfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<LoginInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<LoginInfoTO>();
                while (rs.next()) {
                    LoginInfoTO ans = new LoginInfoTO();
                    ans.setUserName(rs.getString(1));
                    ans.setPassword(rs.getString(2));
                    ans.setRoleName(rs.getString(3));
                    data.add(ans);
                }
            }
            stmt.close();
            return data;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return null;
        }
    }
}




