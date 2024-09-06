package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;


@Service
public class TouristService {
    TouristRepository touristRepository = new TouristRepository();

    //CREATE
    public void addAttraction(TouristAttraction t) {
         touristRepository.addAttraction(t);
    }

    //READ
    public TouristAttraction readIndex(int index) { //KORREKT TJEK INTRO TIL SP
        return touristRepository.readIndex(index);
    }

    public TouristAttraction getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    //UPDATE
    public void updateAttraction(int index, TouristAttraction t) {
        touristRepository.updateAttraction(index, t);
    }

    //DELETE
    public void deleteAttraction(TouristAttraction t) {
        touristRepository.deleteAttraction(t);
    }

}