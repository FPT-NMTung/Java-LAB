
public class ExperienceCandidate extends Candidate {

    private int expInYear;
    private String proSkill;

    public ExperienceCandidate() {
    }

    public ExperienceCandidate(String firstName, String lastName) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

}
