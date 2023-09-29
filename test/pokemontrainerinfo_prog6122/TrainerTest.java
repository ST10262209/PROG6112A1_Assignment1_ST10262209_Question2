/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pokemontrainerinfo_prog6122;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cadec
 */
public class TrainerTest {
    
    public TrainerTest() {
    }

    
    @Test
    public void testAddNewTrainer() {
        Trainer[] trainers = new Trainer[10];
        int trainerCount = 0;
        
        String trainerName = "Ash"; // Replace with the desired trainer name

        // Create a byte array containing the trainerName and use it as input for the Scanner
        InputStream inputStream = new ByteArrayInputStream(trainerName.getBytes());
        Scanner scanner = new Scanner(inputStream);

        trainerCount = Trainer.addNewTrainer(trainers, trainerCount, scanner);

        assertEquals(1, trainerCount);
        assertEquals("Ash", trainers[0].getName());
    }
    
    @Test
    public void testAddNewTrainer_MaxLimit() {
        // Create an array of trainers with the maximum limit reached
        Trainer[] trainers = new Trainer[10];
        for (int i = 0; i < trainers.length; i++) {
            trainers[i] = new Trainer("Trainer" + (i + 1));
        }
        
        int trainerCount = trainers.length; // Trainer count is already at the maximum

        String newTrainerName = "New Trainer"; // Replace with the desired trainer name

        // Create a Scanner from the newTrainerName string
        InputStream inputStream = new ByteArrayInputStream(newTrainerName.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Attempt to add a new trainer, but it should not be added due to the maximum limit
        trainerCount = Trainer.addNewTrainer(trainers, trainerCount, scanner);

        // Assert that the trainer count remains the same as the array is already full
        assertEquals(trainers.length, trainerCount);
    }
    
     @Test
    public void testAddPokemonToTrainer() {
        Trainer[] trainers = new Trainer[10];
        int trainerCount = 0;
        
        // Create a trainer and add it to the array
        Trainer ash = new Trainer("Ash");
        trainers[0] = ash;
        trainerCount = 1;

        String trainerName = "Ash"; // Replace with the desired trainer name
        String pokemonName = "Pikachu"; // Replace with the desired Pokemon name
        String pokemonType = "Electric"; // Replace with the desired Pokemon type
        int position = 1; // Replace with the desired position

        // Create a multi-line input string with the desired values
        String input = trainerName + "\n" + pokemonName + "\n" + pokemonType + "\n" + position + "\n";

        // Create a Scanner from the input string
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Call addPokemonToTrainer method with the Scanner
        ash.addPokemonToTrainer(scanner);

        // Retrieve the Pokemon team for the trainer
        Pokemon[] ashPokemon = ash.getPokemons();

        // Assert that a Pokemon was added to the trainer's team
        assertEquals("Pikachu", ashPokemon[0].getName());
        assertEquals("Electric", ashPokemon[0].getType());
    }
    
    @Test
    public void testAddPokemonToTrainer_TrainerNotFound() {
        Trainer[] trainers = new Trainer[10];
        int trainerCount = 0;
        
        // Create a trainer and add it to the array
        Trainer ash = new Trainer("Ash");
        trainers[0] = ash;
        trainerCount = 1;

        // Create a Scanner with the input data to select a trainer that doesn't exist
        String input = "Misty\nPikachu\nElectric\n1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Call addPokemonToTrainer method with the Scanner
        ash.addPokemonToTrainer(scanner);

        // Assert that the trainer count remains the same as the trainer was not found
        assertEquals(1, trainerCount);
    }
    
    @Test
    public void testAddNewTrainer_TrainerArrayFull() {
        // Create an array of trainers with the maximum limit reached
        Trainer[] trainers = new Trainer[10];
        for (int i = 0; i < trainers.length; i++) {
        trainers[i] = new Trainer("Trainer" + (i + 1));
     }
    
        int trainerCount = trainers.length; // Trainer count is already at the maximum

        String newTrainerName = "New Trainer"; // Replace with the desired trainer name

        // Create a Scanner from the newTrainerName string
        InputStream inputStream = new ByteArrayInputStream(newTrainerName.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Attempt to add a new trainer, but it should not be added due to the maximum limit
        trainerCount = Trainer.addNewTrainer(trainers, trainerCount, scanner);

        // Assert that the trainer count remains the same as the array is already full
        assertEquals(trainers.length, trainerCount);
}



}

