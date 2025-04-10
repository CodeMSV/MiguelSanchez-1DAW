package test;

import entidades.Item;
import entidades.Medalla;
import entidades.Pokemon;
import entidades.Trainer;
import enums.Naturaleza;
import enums.Tipo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    // Variables de clase
    private Trainer trainer;
    private List<Pokemon> pokemons;
    private List<Item> items;
    private List<Medalla> medallas;

    // Variables necesarias para ejecución test
    private Pokemon pikachu;
    private Item cambiarNaturaleza;
    private Medalla medalla;

    @BeforeEach
    public void setUp() {
        trainer = new Trainer("Ash");
        pokemons = trainer.getPokemons();
        items = trainer.getItems();
        medallas = trainer.getMedallas();
        pikachu = new Pokemon("Pikachu", Tipo.ELECTRICO, Naturaleza.AUDACIOSA);
        cambiarNaturaleza = new Item("Cambio de Naturaleza", "Cambia la naturaleza del pokemon");
        medalla = new Medalla("Medalla puerta acceso", "Medalla de prueba de acceso a la liga pokemon.");
    }

    @Test
    void getPokemons() {
        assertNotNull(pokemons, "La lista no puede ser nula.");
        assertTrue(pokemons.isEmpty(), "La lista está vacía.");
        assertEquals(pokemons, trainer.getPokemons());
    }

    @Test
    void addPokemon() {
        trainer.addPokemon(pikachu);
        assertEquals(1, trainer.getPokemons().size());
        assertTrue(trainer.getPokemons().contains(pikachu), "Tienes al pokemon actualmente!");
    }

    @Test
    void removePokemon() {
        trainer.addPokemon(pikachu);
        trainer.removePokemon(pikachu);
        assertEquals(0, trainer.getPokemons().size());
        assertFalse(trainer.getPokemons().contains(pikachu), "No tienes al pokemon actualmente!");
    }

    @Test
    void getItems() {
        assertNotNull(items, "La lista no puede ser nula.");
        assertTrue(items.isEmpty(), "La lista está vacía.");
        assertEquals(items, trainer.getItems());
    }


    @Test
    void batalla() {
        assertNotNull(pokemons, "La lista no puede ser nula.");
        assertTrue(pokemons.isEmpty(), "La lista está vacía.");

        Pokemon enemigo = new Pokemon("Enemigo", Tipo.AGUA, Naturaleza.CALMADA);
        trainer.addPokemon(pikachu);
        assertEquals(true, trainer.batalla(enemigo));
    }

    @Test
    void capturarPokemon() {
        assertNotNull(pokemons, "La lista no puede ser nula.");
        assertTrue(pokemons.isEmpty(), "La lista está vacía.");

        Pokemon enemigo = new Pokemon("Enemigo", Tipo.AGUA, Naturaleza.CALMADA);
        trainer.addPokemon(pikachu);

        if (!trainer.capturarPokemon(enemigo)) {
            assertEquals(1, trainer.getPokemons().size());
        } else {
            assertEquals(2, trainer.getPokemons().size());
        }
    }

    @Test
    void addItem() {
        assertNotNull(items, "La lista no puede ser nula.");
        assertTrue(items.isEmpty(), "La lista está vacía.");

        trainer.addItem(cambiarNaturaleza);
        assertEquals(1, trainer.getItems().size());
        assertTrue(trainer.getItems().contains(cambiarNaturaleza), "Tienes el item actualmente!");
    }

    @Test
    void usarItem() {
        assertNotNull(pokemons, "La lista no puede ser nula.");
        assertTrue(pokemons.isEmpty(), "La lista está vacía.");

        assertNotNull(items, "La lista no puede ser nula.");
        assertTrue(items.isEmpty(), "La lista está vacía.");

        trainer.addPokemon(pikachu);
        trainer.addItem(cambiarNaturaleza);
        trainer.usarItem(pikachu);
        assertNotEquals(trainer.getPokemons().get(0).getNaturaleza(), pikachu.getTipo().name());
    }

    @Test
    void addMedalla() {
        assertNotNull(medallas, "La lista no puede ser nula.");
        assertTrue(medallas.isEmpty(), "La lista está vacía.");

        trainer.addMedalla(medalla);
        assertEquals(1, trainer.getMedallas().size());
        assertTrue(trainer.getMedallas().contains(medalla), "Tienes la medalla actualmente!");
    }

    @Test
    void removeMedalla() {
        assertNotNull(medallas, "La lista no puede ser nula.");
        assertTrue(medallas.isEmpty(), "La lista está vacía.");

        trainer.addMedalla(medalla);
        trainer.removeMedalla(medalla);
        assertEquals(0, trainer.getMedallas().size());
        assertFalse(trainer.getMedallas().contains(medalla), "No tienes la medalla actualmente!");
    }


    @Test
    void getMedallas() {
        assertNotNull(medallas, "La lista no puede ser nula.");
        assertTrue(medallas.isEmpty(), "La lista está vacía.");
        assertEquals(medallas, trainer.getMedallas());
    }

    @Test
    void testToString() {
        assertEquals("Trainer{pokemons=[], name='Ash'}", trainer.toString());
    }
}