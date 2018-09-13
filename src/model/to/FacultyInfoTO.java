package model.to;

public class FacultyInfoTO {
    private String FacultyID , FacultyName , EmailID;
   
    public String getFacultyID() {
        return FacultyID;
    }

    public void setFacultyID(String FacultyID) {
        this.FacultyID = FacultyID;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String FacultyName) {
        this.FacultyName = FacultyName;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String EmailID) {
        this.EmailID = EmailID;
    }
    
    public String toString() {
        return FacultyName + " ( " + FacultyID + " ) ";
    }
}
