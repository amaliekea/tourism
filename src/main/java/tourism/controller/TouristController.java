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
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("") //GET attraction
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAllAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("/{name}") //GET attractions(name)
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>("Added!", HttpStatus.CREATED);
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


