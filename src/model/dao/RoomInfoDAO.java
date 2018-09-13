package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.RoomInfoTO;

public class RoomInfoDAO {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(RoomInfoTO data) {
        try {
            String query = "insert into roominfo(roomid,roomname,noofchair) values(?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getRoomID());
            stmt.setString(2, data.getRoomName());
            stmt.setInt(3, data.getNoofChair());
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }

    public boolean updateRecord(RoomInfoTO data) {
        try {
            String query = "update roominfo set roomname=? , noofchair=? where roomid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getRoomName());
            stmt.setString(3, data.getRoomID());
            stmt.setInt(2, data.getNoofChair());
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }

    public boolean deleteRecord(String roomid) {
        try {
            String query = "delete from roominfo where roomid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, roomid);
            boolean ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return false;
        }
    }

    public RoomInfoTO getRecord(String roomid) {
        try {
            String query = "select roomid , roomname from roominfo where roomid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, roomid);
            RoomInfoTO ans = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ans = new RoomInfoTO();
                ans.setRoomID(rs.getString(1));
                ans.setRoomName(rs.getString(2));
                ans.setNoofChair(rs.getInt(3));
            }
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorMessage = ex.getMessage();
            return null;
        }
    }

    public ArrayList<RoomInfoTO> getAllRecord() {
        try {
            String query = "select roomid , roomname , noofchair from roominfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ArrayList<RoomInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                data = new ArrayList<RoomInfoTO>();
                while (rs.next()) {
                    RoomInfoTO ans = new RoomInfoTO();
                    ans.setRoomID(rs.getString(1));
                    ans.setRoomName(rs.getString(2));
                    ans.setNoofChair(rs.getInt(3));
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
