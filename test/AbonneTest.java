package test;

import exception.SaisieException;
import model.Abonne;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
    @DisplayName("Verif constructeur 6 args")
    public void tConstructeurArgsValide() throws SaisieException {

        Abonne abonne = new Abonne("Doe", "John","joh@doe.fr", 1,2,2025);

        assertEquals("Doe", abonne.getNom());  // methode IDE inverse
        assertEquals("John", abonne.getPrenom());
        assertEquals("joh@doe.fr", abonne.getEmail());
        assertEquals(1, abonne.getDay());
        assertEquals(2, abonne.getMonth());
        assertEquals(2025, abonne.getYear());
    }


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Erreur aucun nom")
    public void testConstructeurArgsNull_Empty(String nom) {
        assertThrows(SaisieException.class, () -> {
            new Abonne (nom, "John","john.doe@jk.fr", 1, 12, 2025);
        });
    }


    @Test
    void setAbonnes() {

    }

    @Test
    @DisplayName("Succes adresse email")
    void setEmail_Sucess() throws SaisieException {
        Abonne.rechercheParEmail("joh@doesii.com");
        assertEquals("lara.croft@gh.fr", abonne.getEmail());
    }

    @Test
    @DisplayName("Erreur email sans @ REGEX")
    void setEmail_Fail() throws SaisieException {
        assertThrows(SaisieException.class, () ->
                Abonne.rechercheParEmail("laracroftgh.fr"));

    }

    @Test
    void setMonth() {
    }

    @Test
    void setYear() {
    }
}