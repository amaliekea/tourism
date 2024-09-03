package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;


@Service
public class TouristService {
    TouristRepository touristRepository = new TouristRepository();

    //CREATE
    public void addAttraction(String name, String description) {
        TouristAttraction t = new TouristAttraction(name, description);
        touristRepository.addAttraction(t);
    }

    //READ
    public TouristAttraction readIndex(int index) {
        return touristRepository.readIndex(index);
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    //UPDATE
    public void updateAttraction(int index, TouristAttraction t) {
        touristRepository.getAllAttractions().get(index).setDescription(t.getDescription());
        touristRepository.getAllAttractions().get(index).setName(t.getName());
        // touristAttractions.set(index, t);
    }

    //DELETE
    public void deleteAttraction(TouristAttraction t) {
        touristRepository.getAllAttractions().remove(t);
    }

}