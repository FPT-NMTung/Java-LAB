
import java.util.Date;

public class FresherCandidate extends Candidate {

    private Date graduationDate;
    private int graduationRank;
    private String education;

    public FresherCandidate() {
    }

    public FresherCandidate(String firstName, String lastName, String education) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.education = education;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public int getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(int graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

}
