package tourism.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tourism.model.TouristAttraction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {

    @Test
    void addAttraction() {
        //Arrange-setup our test objects*
        TouristRepository touristRepository = new TouristRepository();
        TouristAttraction frb = new TouristAttraction("frederiksberg have", "pretty garden");
        touristRepository.addAttraction(frb);
        //Act- do the actual calc or method*
        List<TouristAttraction> actual = touristRepository.getAllAttractions();

        //Assert-check if actual val is equal to expected val*
        for (TouristAttraction t : actual) {
            if (t.getName().equals(frb.getName())) {
                Assertions.assertTrue(actual.contains(t));
            }
        }
    }

    @Test
    void getTouristAttractions() {
        //Arrange
        TouristRepository touristRepository = new TouristRepository();
        //Act
        int expected = 2;
        int actual = touristRepository.getAllAttractions().size();

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateAttraction() {
        //Arrange
        TouristRepository touristRepository = new TouristRepository();
        touristRepository.updateAttraction(1, new TouristAttraction("Amalie", "sweet"));
        //Act
        List<TouristAttraction> actual = touristRepository.getAllAttractions();

        //Assert
        Assertions.assertTrue(actual.get(1).getName().equals("Amalie"));
    }

    @Test
    void deleteAttraction() {
        //Arrange
        TouristRepository touristRepository = new TouristRepository();
        List<TouristAttraction> actual = touristRepository.getAllAttractions();
        actual.remove(1);
        //Act
        int actualSize = actual.size();
        int expectedSize = 1;


        //Assert
        Assertions.assertEquals(expectedSize, actualSize);
    }
}