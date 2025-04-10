package entidades;

import enums.Naturaleza;
import enums.Tipo;
import interfaces.ITrainer;

import java.util.ArrayList;
import java.util.List;


public class Trainer extends Persona implements ITrainer {

    private List<Pokemon> pokemons;
    private List<Item> items;
    private List<Medalla> medallas;

    /**
     * Constructor de Trainer.
     *
     * @param name nombre del entrenador.
     */
    public Trainer(String name) {
        super(name);
        this.pokemons = new ArrayList<>();
        this.items = new ArrayList<>();
        this.medallas = new ArrayList<>();
    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    @Override
    public void addPokemon(Pokemon pokemon) {
        if (pokemon != null && !this.pokemons.contains(pokemon)) {
            this.pokemons.add(pokemon);
            System.out.println(String.format("Se ha añadido el pokemon %s de tipo %s y de naturaleza %s al inventario correctamente",
                    pokemon.getNamePokemon(), pokemon.getTipo(), pokemon.getNaturaleza()));
        }
    }

    @Override
    public void removePokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
    }

    public List<Item> getItems() {
        return this.items;
    }

    @Override
    public void addItem(Item item) {
        if (item != null && !this.pokemons.contains(item)) {
            this.items.add(item);
            System.out.println("Se ha añadido el item.");
        }
    }


    @Override
    public void usarItem(Pokemon pokemon) {
        if (pokemon != null) {
            if (items.isEmpty()) {
                System.out.println("No tienes items para usar.");
            } else {
                System.out.println("Usando item: " + items.get(0).getNombreItem());
                items.get(0).efecto(pokemon);
            }
        }
    }

    /**
     * Simula una batalla entre el primer Pokemon del entrenador y un Pokémon enemigo.
     *
     * @param pokemonEnemigo el Pokémon enemigo al que se enfrenta.
     * @return true si se gana la batalla, false en caso contrario.
     */
    @Override
    public Boolean batalla(Pokemon pokemonEnemigo) {
        if (pokemons.isEmpty()) {
            System.out.println("No tienes Pokémon para batallar.");
            return false;
        }

        Pokemon miPokemon = pokemons.get(0);

        boolean victoria = false;
        switch (miPokemon.getTipo()) {
            case FUEGO:
                // FUEGO es efectivo contra PLANTA y HIELO
                victoria = (pokemonEnemigo.getTipo() == Tipo.PLANTA || pokemonEnemigo.getTipo() == Tipo.HIELO);
                break;
            case AGUA:
                // AGUA es efectivo contra FUEGO y TIERRA
                victoria = (pokemonEnemigo.getTipo() == Tipo.FUEGO || pokemonEnemigo.getTipo() == Tipo.TIERRA);
                break;
            case PLANTA:
                // PLANTA es efectivo contra AGUA y TIERRA
                victoria = (pokemonEnemigo.getTipo() == Tipo.AGUA || pokemonEnemigo.getTipo() == Tipo.TIERRA);
                break;
            case ELECTRICO:
                // ELECTRICO es efectivo contra AGUA
                victoria = (pokemonEnemigo.getTipo() == Tipo.AGUA);
                break;
            case TIERRA:
                // TIERRA es efectiva contra ELECTRICO y FUEGO
                victoria = (pokemonEnemigo.getTipo() == Tipo.ELECTRICO || pokemonEnemigo.getTipo() == Tipo.FUEGO);
                break;
            case HIELO:
                // HIELO es efectivo contra PLANTA y TIERRA
                victoria = (pokemonEnemigo.getTipo() == Tipo.PLANTA || pokemonEnemigo.getTipo() == Tipo.TIERRA);
                break;
        }

        // Mostrar el resultado de la batalla
        System.out.println("Tu Pokémon: " + miPokemon.getNamePokemon() + " (" + miPokemon.getTipo() + ")");
        System.out.println("Pokémon enemigo: " + pokemonEnemigo.getNamePokemon() + " (" + pokemonEnemigo.getTipo() + ")");
        if (victoria) {
            System.out.println("¡Has ganado la batalla!");
        } else {
            System.out.println("Has perdido la batalla.");
        }

        return victoria;
    }

    /**
     * Intenta capturar un Pokemon basándose en un valor aleatorio.
     *
     * @param pokemon el Pokemon que se intenta capturar.
     * @return true si la captura es exitosa, false en caso contrario.
     */
    @Override
    public Boolean capturarPokemon(Pokemon pokemon) {
        // Genera un valor aleatorio entre 0.0 y 1.0
        double suerte = Math.random();

        // Definimos un umbral de captura (por ejemplo, 0.3, lo que equivale al 30% de probabilidad)
        double umbral = 0.3;

        if (suerte < umbral) {
            addPokemon(pokemon);
            System.out.println("¡Capturaste a " + pokemon.getNamePokemon() + "!");
            return true;
        } else {
            System.out.println("No lograste capturar a " + pokemon.getNamePokemon() + ".");
            return false;
        }
    }


    @Override
    public void addMedalla(Medalla medalla) {
        if (medallas != null) {
            this.medallas.add(medalla);
            System.out.println("Se ha añadido la medalla.");
        }
    }

    @Override
    public List<Medalla> getMedallas() {
        return this.medallas;
    }


    @Override
    public void removeMedalla(Medalla medalla) {
        if (medallas != null && medallas.contains(medalla)) {
            this.medallas.remove(medalla);
        }
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "pokemons=" + this.pokemons +
                ", name='" + this.name + '\'' +
                '}';
    }
}
