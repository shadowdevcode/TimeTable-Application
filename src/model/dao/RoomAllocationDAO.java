package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.RoomAllocationTO;

public class RoomAllocationDAO {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(RoomAllocationTO data) {
        try {
            String query = "insert into roomallocation(facultyid,subjectid,roomid,dayname,isactive,lecturetime) values(?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getFacultyID());
            stmt.setString(2, data.getSubjectID());
            stmt.setString(3, data.getRoomID());
            stmt.setString(4, data.getDayName());
            stmt.setString(5, data.getIsActive());
            stmt.setTime(6, data.getLectureTime());
            
            
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }

    public boolean updateRecord(RoomAllocationTO data) {
        try {
            String query = "update roomallocation set facultyid=? , subjectid=? , roomid=? , dayname=? , isactive=? , lecturetime=? where SrNo=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getFacultyID());
            stmt.setString(2, data.getSubjectID());
            stmt.setString(3, data.getRoomID());
            stmt.setString(4, data.getDayName());
            stmt.setString(5, data.getIsActive());
            stmt.setTime(6, data.getLectureTime());
            stmt.setInt(7, data.getSrNO());
           
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
            String query = "delete from roomallocation where srno=?";
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
    
    
     public boolean isAvailable(String facid , String subid , String roomid) {
        try {
            String query = "select * from roomallocation where facultyid=? and subjectid=? and roomid=? and isactive='Yes'";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,facid);
            stmt.setString(2,subid);
            stmt.setString(3, roomid);
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

    public RoomAllocationTO getRecord(int srno) {
        try {
            String query = "select srno , facultyid , subjectid , roomid , dayname , isactive from roomallocation where srno=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, srno);
            RoomAllocationTO ans = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ans = new RoomAllocationTO();
                ans.setSrNO(rs.getInt(1));
                ans.setFacultyID(rs.getString(2));
                ans.setSubjectID(rs.getString(3));
                ans.setRoomID(rs.getString(4));
                ans.setDayName(rs.getString(5));
                ans.setIsActive(rs.getString(6));
                ans.setLectureTime(rs.getTime(7));
            }
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return null;
        }
    }

    public ArrayList<RoomAllocationTO> getAllRecord() {
        try {
            String query = "select srno , r1.facultyid , r1.subjectid , r1.roomid , dayname ,isactive , r1.lecturetime , facultyname , subjectname , roomname\n" +
"from roomallocation r1\n" +
"join facultyinfo f on r1.facultyid = f.facultyid\n" +
"join subjectinfo s on r1.subjectid = s.subjectid join roominfo r on r1.roomid = r.roomid;";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<RoomAllocationTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<RoomAllocationTO>();
                while (rs.next()) {
                    RoomAllocationTO ans = new RoomAllocationTO();
                    ans.setSrNO(rs.getInt(1));
                    ans.setFacultyID(rs.getString(2));
                    ans.setSubjectID(rs.getString(3));
                    ans.setRoomID(rs.getString(4));
                    ans.setDayName(rs.getString(5));
                    ans.setIsActive(rs.getString(6));
                    ans.setLectureTime(rs.getTime(7));
                    ans.setFacultyName(rs.getString(8));
                    ans.setSubjectName(rs.getString(9));
                    ans.setRoomName(rs.getString(10) +" [ " + rs.getString(4) + " ]");
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
    
    public ArrayList<RoomAllocationTO> getAllRecord(String Roomid,String IsActive) {
        try {
            String query = "select srno , r1.facultyid , r1.subjectid , r1.roomid , dayname ,isactive , r1.lecturetime , facultyname , subjectname , roomname\n" +
"from roomallocation r1\n" +
"join facultyinfo f on r1.facultyid = f.facultyid\n" +
"join subjectinfo s on r1.subjectid = s.subjectid join roominfo r on r1.roomid = r.roomid where r1.roomid=? and r1.isactive=?;";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<RoomAllocationTO> data = null;
            stmt.setString(1, Roomid);
            stmt.setString(2, IsActive);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<RoomAllocationTO>();
                while (rs.next()) {
                    RoomAllocationTO ans = new RoomAllocationTO();
                    ans.setSrNO(rs.getInt(1));
                    ans.setFacultyID(rs.getString(2));
                    ans.setSubjectID(rs.getString(3));
                    ans.setRoomID(rs.getString(4));
                    ans.setDayName(rs.getString(5));
                    ans.setIsActive(rs.getString(6));
                    ans.setLectureTime(rs.getTime(7));
                    ans.setFacultyName(rs.getString(8));
                    ans.setSubjectName(rs.getString(9));
                    ans.setRoomName(rs.getString(10) +" [ " + rs.getString(4) + " ]");
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
