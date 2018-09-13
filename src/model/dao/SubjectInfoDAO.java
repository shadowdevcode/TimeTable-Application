package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.SubjectInfoTO;

public class SubjectInfoDAO {
    
  private String errorMessage;

    public String geterrorMessage() {
        return errorMessage;
    }
    
    
    
  public boolean insertRecord (SubjectInfoTO data){
    try {
        String query ="insert into subjectinfo(SubjectID,Description,SubjectName) values(?,?,?)";
        PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
        stmt.setString(1, data.getSubjectID());
        stmt.setString(2, data.getDescription());
        stmt.setString(3, data.getSubjectName());
        boolean ans = stmt.executeUpdate() > 0;
        stmt.close();
        return ans;
    }catch(Exception ex){
        System.out.println(ex.getMessage());
        errorMessage = ex.getMessage();
        return false;
    }
}
  
  public boolean updateRecord(SubjectInfoTO data) {
        try {
            String query = "update subjectinfo set description=? , subjectname=? where subjectid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getDescription());
            stmt.setString(2, data.getSubjectName());
            stmt.setString(3, data.getSubjectID());
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }
  
   public boolean deleteRecord(String subjectid) {
        try {
            String query = "delete from subjectinfo where subjectid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, subjectid);
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }
   
    public SubjectInfoTO getRecord(String subjectid) {
        try {
            String query = "select subjectid , description , subjectname from subjectinfo where subjectid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, subjectid);
            SubjectInfoTO ans = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ans = new SubjectInfoTO();
                ans.setSubjectID(rs.getString(1));
                ans.setDescription(rs.getString(2));
                ans.setSubjectName(rs.getString(3));
            }
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return null;
        }
    }
    
     public ArrayList<SubjectInfoTO> getAllRecord() {
        try {
            String query = "select subjectid , description , subjectname from subjectinfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<SubjectInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<SubjectInfoTO>();
                while (rs.next()) {
                    SubjectInfoTO ans = new SubjectInfoTO();
                    ans.setSubjectID(rs.getString(1));
                    ans.setDescription(rs.getString(2));
                    ans.setSubjectName(rs.getString(3));
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
     
     public ArrayList<SubjectInfoTO> getAllRecordFacultyWise(String facultyid) {
        try {
            String query = "select subjectid , description , subjectname from subjectinfo where subjectid in ( select subjectid from facultysubject where facultyid=? and isCurrent='yes' )";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,facultyid);
            ArrayList<SubjectInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<SubjectInfoTO>();
                while (rs.next()) {
                    SubjectInfoTO ans = new SubjectInfoTO();
                    ans.setSubjectID(rs.getString(1));
                    ans.setDescription(rs.getString(2));
                    ans.setSubjectName(rs.getString(3));
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


