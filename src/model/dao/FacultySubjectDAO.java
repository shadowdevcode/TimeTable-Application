package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.FacultySubjectTO;

public class FacultySubjectDAO {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(FacultySubjectTO data) {
        try {
            String query = "insert into facultysubject(facultyid,subjectid,iscurrent) values(?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getFacultyID());
            stmt.setString(2, data.getSubjectID());
            stmt.setString(3, data.getIsCurrent());
            
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }

    public boolean updateRecord(FacultySubjectTO data) {
        try {
            String query = "update facultysubject set facultyid=? , subjectid=? , iscurrent=? where SrNo=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getFacultyID());
            stmt.setString(2, data.getSubjectID());
            stmt.setString(3, data.getIsCurrent());
            stmt.setInt(4, data.getSrNo());
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }

    public boolean deleteRecord(int srno) {
        try {
            String query = "delete from facultysubject where srno=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, srno);
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }

    public boolean isTeach(String facid , String subid) {
        try {
            String query = "select * from facultysubject where facultyid=? and subjectid=? and iscurrent='Yes'";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,facid);
            stmt.setString(2,subid);
            ResultSet rs = stmt.executeQuery();
            boolean ans = false;
            if(rs.next()){
                ans= true;
            }
            rs.close();
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }
    public FacultySubjectTO getRecord(int srno) {
        try {
            String query = "select srno , facultyid , subjectid , iscurrent from facultysubject where srno=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, srno);
            FacultySubjectTO ans = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ans = new FacultySubjectTO();
                ans.setSrNo(rs.getInt(1));
                ans.setFacultyID(rs.getString(2));
                ans.setSubjectID(rs.getString(3));
                ans.setIsCurrent(rs.getString(4));
            }
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return null;
        }
    }

    public ArrayList<FacultySubjectTO> getAllRecord() {
        try {
            String query = "select srno , f1.facultyid , f1.subjectid , iscurrent , facultyname, s.subjectname from facultysubject f1\n" +
"join facultyinfo f on f1.facultyid = f.facultyid join subjectinfo s on f1.subjectid = s.subjectid;";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<FacultySubjectTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<FacultySubjectTO>();
                while (rs.next()) {
                    FacultySubjectTO ans = new FacultySubjectTO();
                    ans.setSrNo(rs.getInt(1));
                    ans.setFacultyID(rs.getString(2));
                    ans.setSubjectID(rs.getString(3));
                    ans.setIsCurrent(rs.getString(4));
                    ans.setFacultyName(rs.getString(5));
                    ans.setSubjectName(rs.getString(6)); 
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
    
     public ArrayList<FacultySubjectTO> getAllRecord(String facultyid) {
        try {
            String query = "select srno , f1.facultyid , f1.subjectid , iscurrent , facultyname, s.subjectname from facultysubject f1\n" +
"join facultyinfo f on f1.facultyid = f.facultyid join subjectinfo s on f1.subjectid = s.subjectid where f1.facultyid=?;";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<FacultySubjectTO> data = null;
            stmt.setString(1, facultyid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<FacultySubjectTO>();
                while (rs.next()) {
                    FacultySubjectTO ans = new FacultySubjectTO();
                    ans.setSrNo(rs.getInt(1));
                    ans.setFacultyID(rs.getString(2));
                    ans.setSubjectID(rs.getString(3));
                    ans.setIsCurrent(rs.getString(4));
                    ans.setFacultyName(rs.getString(5));
                    ans.setSubjectName(rs.getString(6)); 
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
    
      public ArrayList<FacultySubjectTO> getAllRecord1(String subjectid) {
        try {
            String query = "select srno , f1.facultyid , f1.subjectid , iscurrent , facultyname, s.subjectname from facultysubject f1\n" +
"join facultyinfo f on f1.facultyid = f.facultyid join subjectinfo s on f1.subjectid = s.subjectid where s.subjectid=?;";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<FacultySubjectTO> data = null;
            stmt.setString(1, subjectid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<FacultySubjectTO>();
                while (rs.next()) {
                    FacultySubjectTO ans = new FacultySubjectTO();
                    ans.setSrNo(rs.getInt(1));
                    ans.setFacultyID(rs.getString(2));
                    ans.setSubjectID(rs.getString(3));
                    ans.setIsCurrent(rs.getString(4));
                    ans.setFacultyName(rs.getString(5));
                    ans.setSubjectName(rs.getString(6)); 
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
    
       public ArrayList<FacultySubjectTO> getAllRecord2(String Iscurrent) {
        try {
            String query = "select srno , f1.facultyid , f1.subjectid , iscurrent , facultyname, s.subjectname from facultysubject f1\n" +
"join facultyinfo f on f1.facultyid = f.facultyid join subjectinfo s on f1.subjectid = s.subjectid where iscurrent=?;";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<FacultySubjectTO> data = null;
            stmt.setString(1, Iscurrent);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<FacultySubjectTO>();
                while (rs.next()) {
                    FacultySubjectTO ans = new FacultySubjectTO();
                    ans.setSrNo(rs.getInt(1));
                    ans.setFacultyID(rs.getString(2));
                    ans.setSubjectID(rs.getString(3));
                    ans.setIsCurrent(rs.getString(4));
                    ans.setFacultyName(rs.getString(5));
                    ans.setSubjectName(rs.getString(6)); 
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
