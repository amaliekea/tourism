package tourism.repository;

import tourism.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> touristAttractions;

    public TouristRepository() {
        touristAttractions = new ArrayList<>();
        touristAttractions.add(new TouristAttraction("Tivoli", "playfull attractions"));
        touristAttractions.add(new TouristAttraction("Zoo", "full of animals"));
    }

    //CREATE
    public void addAttraction(TouristAttraction t) {
        touristAttractions.add(t);
    }

    //READ
    public List<TouristAttraction> getAllAttractions() {
        return touristAttractions;
    }

    public TouristAttraction readIndex(int index) {
        return touristAttractions.get(index);
    }

    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction t : touristAttractions) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    //UPDATE
    public void updateAttraction(int index, TouristAttraction t) {
        touristAttractions.set(index, t);
    }

    //DELETE
    public void deleteAttraction(TouristAttraction t) {
        touristAttractions.remove(t);
    }
}
