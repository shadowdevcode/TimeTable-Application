package model.to;

public class FacultySubjectTO {
    private String FacultyID , SubjectID;
    private String FacultyName;

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
    private String SubjectName;

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

    public String getIsCurrent() {
        return IsCurrent;
    }

    public void setIsCurrent(String IsCurrent) {
        this.IsCurrent = IsCurrent;
    }

    public Integer getSrNo() {
        return SrNo;
    }

    public void setSrNo(Integer SrNo) {
        this.SrNo = SrNo;
    }
    private String IsCurrent;
    private Integer SrNo;
}
