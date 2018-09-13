package model.to;

public class SubjectInfoTO {
    private String SubjectID , Description , SubjectName;

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }
    
    public String toString(){
        return SubjectName + " ( " + SubjectID + " ) ";
    }
}
