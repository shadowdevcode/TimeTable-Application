package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.FacultyInfoTO;

public class FacultyInfoDAO {
  private String errorMessage;

    public String geterrorMessage() {
        return errorMessage;
    }
    
    
    
  public boolean insertRecord (FacultyInfoTO data){
    try {
        String query ="insert into facultyinfo(facultyid,facultyname,emailid) values(?,?,?)";
        PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
        stmt.setString(1, data.getFacultyID());
        stmt.setString(2, data.getFacultyName());
        stmt.setString(3, data.getEmailID());
        boolean ans = stmt.executeUpdate() > 0;
        stmt.close();
        return ans;
    }catch(Exception ex){
        System.out.println(ex.getMessage());
        errorMessage = ex.getMessage();
        return false;
    }
}
  
  public boolean updateRecord(FacultyInfoTO data) {
        try {
            String query = "update facultyinfo set facultyname=? , emailid=? where facultyid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getFacultyName());
            stmt.setString(2, data.getEmailID());
            stmt.setString(3, data.getFacultyID());
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }
  
   public boolean deleteRecord(String facultyid) {
        try {
            String query = "delete from facultyinfo where facultyid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, facultyid);
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }
   
    public FacultyInfoTO getRecord(String facultyid) {
        try {
            String query = "select facultyid , facultyname, emailid from facultyinfo where facultyid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, facultyid);
            FacultyInfoTO ans = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ans = new FacultyInfoTO();
                ans.setFacultyID(rs.getString(1));
                ans.setFacultyName(rs.getString(2));
                ans.setEmailID(rs.getString(3));
            }
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return null;
        }
    }
    
     public ArrayList<FacultyInfoTO> getAllRecord() {
        try {
            String query = "select facultyid , facultyname , emailid from facultyinfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<FacultyInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<FacultyInfoTO>();
                while (rs.next()) {
                    FacultyInfoTO ans = new FacultyInfoTO();
                    ans.setFacultyID(rs.getString(1));
                    ans.setFacultyName(rs.getString(2));
                    ans.setEmailID(rs.getString(3));
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



