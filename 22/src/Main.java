
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    static Validator vali = new Validator();

    public static void main(String[] args) {
        CandidateManager cm = new CandidateManager();
        int choice = 0;
        char ans;

        do {
            displayMainMenu();
            choice = vali.inputIntValue("Choice");

            switch (choice) {
                case 1:
                    //add Exper
                    do {
                        cm.addCandidate(inputExperValue());
                        displayListCanType(choice, cm.getTypeCan(choice));
                        ans = vali.inputCharValue("Do you want continue (Y/N)");
                    } while (ans == 'Y');
                    break;
                case 2:
                    //add Fresh
                    do {
                        cm.addCandidate(inputFreshValue());
                        displayListCanType(choice, cm.getTypeCan(choice));
                        ans = vali.inputCharValue("Do you want continue (Y/N)");
                    } while (ans == 'Y');
                    break;
                case 3:
                    //add Intern
                    do {
                        cm.addCandidate(inputInterValue());
                        displayListCanType(choice, cm.getTypeCan(choice));
                        ans = vali.inputCharValue("Do you want continue (Y/N)");
                    } while (ans == 'Y');
                    break;
                case 4:
                    //seaching
                    String nameSearch = vali.inputStringValue("Name");
                    int typeSearch = vali.inputIntValue("Type");
                    ArrayList<Candidate> searchCan = cm.searchCandidate(nameSearch, typeSearch);
                    displaySearchCan(searchCan);
                    break;
            }
        } while (choice != 5);
    }

    public static Candidate inputSameValue(Candidate newCandidate) {

        newCandidate.setFirstName(vali.inputStringValue("First name"));
        newCandidate.setLastName(vali.inputStringValue("Last name"));
        newCandidate.setBirthDay(vali.inputDateValue("Birth day"));
        newCandidate.setAddress(vali.inputStringValue("Address"));
        newCandidate.setPhone(vali.inputStringValue("Phone"));
        newCandidate.setEmail(vali.inputEmailValue("Email"));

        return newCandidate;
    }

    public static Candidate inputExperValue() {
        ExperienceCandidate newCandidate = new ExperienceCandidate();
        System.out.println("\n--- Experience Candidate info ---");

        inputSameValue(newCandidate);

        newCandidate.setExpInYear(vali.inputIntValue("Year of Experience"));
        newCandidate.setProSkill(vali.inputStringValue("Professional Skill"));

        return newCandidate;
    }

    public static Candidate inputFreshValue() {
        FresherCandidate newCandidate = new FresherCandidate();
        System.out.println("\n--- Fresher Candidate info ---");

        inputSameValue(newCandidate);

        newCandidate.setGraduationDate(vali.inputDateValue("Graduation time"));
        newCandidate.setGraduationRank(vali.inputIntValue("Rank of Graduation"));
        newCandidate.setEducation(vali.inputStringValue("University"));

        return newCandidate;
    }

    public static Candidate inputInterValue() {
        InternCandidate newCandidate = new InternCandidate();
        System.out.println("\n--- Internship Candidate info ---");

        inputSameValue(newCandidate);

        newCandidate.setMajors(vali.inputStringValue("Majors"));
        newCandidate.setSemester(vali.inputIntValue("Semester"));
        newCandidate.setUniversityName(vali.inputStringValue("University"));

        return newCandidate;
    }

    public static void displayMainMenu() {
        System.out.println("\n=== CANDIDATE MANAGEMENT SYSTEM ===");
        System.out.println("\t1.Experience");
        System.out.println("\t2.Fresher");
        System.out.println("\t3.Internship");
        System.out.println("\t4.Search");
        System.out.println("\t5.Exit");
    }

    public static void displayListCanType(int type, ArrayList<Candidate> list) {

        switch (type) {
            case 1:
                System.out.println("\n--- EXPERIENCE CANDIDATE ---");
                break;
            case 2:
                System.out.println("\n--- FRESHER CANDIDATE ---");
                break;
            case 3:
                System.out.println("\n--- INTERN CANDIDATE ---");
                break;
        }

        for (Iterator<Candidate> iterator = list.iterator(); iterator.hasNext();) {
            Candidate next = iterator.next();

            System.out.println(next.getFirstName() + " " + next.getLastName());
        }
    }

    public static void displaySearchCan(ArrayList<Candidate> searchCan) {
        for (Iterator<Candidate> iterator = searchCan.iterator(); iterator.hasNext();) {
            Candidate next = iterator.next();
            
            //Aguirre Eva | 1990 | Sao paulo| 940394 | eva@asante.com | 0 
            System.out.println(next.getFirstName() + " " 
                    + next.getLastName() + " | " 
                    + next.getBirthDay().getYear() + " | " 
                    + next.getAddress() + " | " 
                    + next.getPhone()
            );
        }
    }
}
