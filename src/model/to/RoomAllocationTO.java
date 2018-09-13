package model.to;

import java.sql.Time;

public class RoomAllocationTO {
    private String FacultyID , SubjectID , RoomID , DayName; 
    private String FacultyName;
    private String IsActive;

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String IsActive) {
        this.IsActive = IsActive;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String FacultyName) {
        this.FacultyName = FacultyName;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String RoomName) {
        this.RoomName = RoomName;
    }
    private String SubjectName;
    private String RoomName;
    

    public String getFacultyID() {
        return FacultyID;
    }

    public void setFacultyID(String FacultyID) {
        this.FacultyID = FacultyID;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public String getDayName() {
        return DayName;
    }

    public void setDayName(String DayName) {
        this.DayName = DayName;
    }

    public Integer getSrNO() {
        return SrNO;
    }

    public void setSrNO(Integer SrNO) {
        this.SrNO = SrNO;
    }

   
    private Integer SrNO;
    private Time LectureTime;

    public Time getLectureTime() {
        return LectureTime;
    }

    public void setLectureTime(Time LectureTime) {
        this.LectureTime = LectureTime;
    }
}
