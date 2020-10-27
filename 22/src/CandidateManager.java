
import java.util.ArrayList;
import java.util.Iterator;

public class CandidateManager {

    private ArrayList<Candidate> listCandidate;

    public CandidateManager() {
        listCandidate = new ArrayList<>();
    }

    public void addCandidate(Candidate newCandidate) {
        listCandidate.add(newCandidate);
    }

    public ArrayList<Candidate> searchCandidate(String name, int type) {
        ArrayList<Candidate> searchType = getTypeCan(type);
        ArrayList<Candidate> search = new ArrayList<>();

        for (Iterator<Candidate> iterator = searchType.iterator(); iterator.hasNext();) {
            Candidate next = iterator.next();
                
            if (next.getFirstName().contains(name) || next.getLastName().contains(name)) {
                search.add(next);
            }
            
        }

        return search;
    }

    public ArrayList<Candidate> getTypeCan(int type) {
        ArrayList<Candidate> can = new ArrayList<>();
        
        for (Iterator<Candidate> iterator = listCandidate.iterator(); iterator.hasNext();) {
            Candidate next = iterator.next();
            
            switch (type) {
                case 1:
                    if (next.getClass().equals(new ExperienceCandidate().getClass())) {
                        can.add(next);
                    }
                    break;
                case 2:
                    if (next.getClass().equals(new FresherCandidate().getClass())) {
                        can.add(next);
                    }
                    break;
                case 3:
                    if (next.getClass().equals(new InternCandidate().getClass())) {
                        can.add(next);
                    }
                    break;
            }
        }
        
        return can;
    }
}
