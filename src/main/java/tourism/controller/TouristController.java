package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

//FORSØG AT LAV ROOT TIL HTML
@Controller
@RequestMapping("/attractions") //angiver at klassen er en controller og mappes til '/attractions' URL'en
public class TouristController {
    private final TouristService touristService; //dependency injection af touristservice

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("") //håndterer GET-forespørgsler til "/attractions"
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAllAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);  // Returnerer listen over attraktioner med HTTP-statuskoden 200 (OK)
    }

    @GetMapping("/{name}") //GET attractions(name)
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")  // Håndterer POST-forespørgsler til "/attractions/add"
    public ResponseEntity<String> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>("Added!", HttpStatus.CREATED); // Returnerer en succesbesked med HTTP-status 201 (CREATED)
    }

    @PostMapping("/update") //UPDATE
    public ResponseEntity<String> updateAttraction(@RequestParam int index, @RequestBody TouristAttraction updatedAttraction) {
        touristService.updateAttraction(index, updatedAttraction);
        return new ResponseEntity<>("Updated!", HttpStatus.OK);
    }

    @PostMapping("/delete/{name}") //DELETE
    public ResponseEntity<String> deleteAttraction(@PathVariable String name) {
        TouristAttraction existingAttractrion = touristService.getAttractionByName(name);
        touristService.deleteAttraction(existingAttractrion);
        return new ResponseEntity<>("Deleted!", HttpStatus.FOUND);
    }


//    @GetMapping("/{id}") //EKSTRA?
//    public ResponseEntity<TouristAttraction> readIndex(@PathVariable int id) {
//        TouristAttraction touristAttraction = touristService.readIndex(id);
//        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
//    }


}


