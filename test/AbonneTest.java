package test;

import exception.SaisieException;
import model.Abonne;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbonneTest {
    Abonne abonne;

    @BeforeEach
    void setUp() throws SaisieException {
        abonne = new Abonne("Croft","Lara","lara.croft@gh.fr", 1,2,2025 );
    }

    @AfterEach
    void tearDown() {
        abonne = null;
    }

    @Test
    void setAbonnes() {

    }

    @Test
    void setEmail() {
    }

    @Test
    void setDay() {
    }

    @Test
    void setMonth() {
    }

    @Test
    void setYear() {
    }
}