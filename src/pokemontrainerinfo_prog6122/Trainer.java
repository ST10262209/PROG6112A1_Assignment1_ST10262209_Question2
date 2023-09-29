/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemontrainerinfo_prog6122;

import java.util.Scanner;
import static pokemontrainerinfo_prog6122.PokemonTrainerInfo_PROG6122.findTrainerIndexByName;


public class Trainer extends PocketMonster{
    private Pokemon[] pokemons;

    public Trainer(String name) {
        super(name);
        this.pokemons = new Pokemon[6];
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon, int position) {
        // Bneath checks if the position is within the valid range (0 to 5)
        if (position >= 0 && position < 6) {
            // Beneath assigns the Pokémon to the specified position in the trainer's team
            pokemons[position] = pokemon;
        }
    }
    
    public static int addNewTrainer(Trainer[] trainers, int trainerCount, Scanner scanner){
        // The if checks if there is room to add a new trainer
        if (trainerCount < trainers.length) {
        System.out.print("Enter Trainer Name: ");
        String trainerName = scanner.next();
        
        // Creates a new Trainer object with the entered name and add it to the array
        trainers[trainerCount] = new Trainer(trainerName);
        
        System.out.println("Trainer added successfully.");
        return trainerCount + 1; // Return the updated trainerCount  
    } else {
        System.out.println("Maximum number of trainers reached.");
        return trainerCount; // Return the original trainerCount
    }
    }
    
    public void addPokemonToTrainer(Scanner scanner){
        scanner.nextLine();
        System.out.println("Enter the name of the pokemon: ");
        String pokemonName = scanner.nextLine();
        System.out.println("Enter the pokemon's type: ");
        String pokemonType = scanner.nextLine();
        
        // This creates a new Pokémon object with the entered name and type
        Pokemon newPokemon = new Pokemon(pokemonName, pokemonType);
         
        System.out.println("Enter the team position of the pokemon from (1-6): ");
        int position = scanner.nextInt();
        
        // this adjusts the position from the user to be a valid index (0-5)
        position = position - 1;
        
        // Below calls the addPokemon method to add the new Pokémon to the trainer's team
        addPokemon(newPokemon, position);
    }
    
    public static void searchTrainer(Trainer[] trainer, int trainerCount, Scanner scanner){
        System.out.println("Enter the name of the trainer you would like to view");
        String searchedTrainer = scanner.next();
        
        // This finds the index of the trainer with the entered name above
        int foundTrainerIndex = findTrainerIndexByName(trainer, searchedTrainer, trainerCount);

        // This if statement checks if a trainer with the entered name was found in the trainers array
        if (foundTrainerIndex != -1) {
            
            // If it is found the system retrieves the trainer object at the found index
            Trainer foundTrainer = trainer[foundTrainerIndex];
            System.out.println("Trainer: " + foundTrainer.getName() + "'s pokemon");
            System.out.println("******************");
            
            // This for loop iterates through the trainer's Pokémon
            for (Pokemon pokemon : foundTrainer.getPokemons()) {
                
                // The if checks if the current Pokémon slot is not empty
                if (pokemon != null) {
                System.out.println("Name: " + pokemon.getName());
                System.out.println("Type: " + pokemon.getType() + "\n");
                }
            }
            } else {
            
            // If no trainer with the entered name was found, inform the user
            System.out.println("Trainer not found.\n");
            }
    }
    
    
    
}
