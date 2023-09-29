/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemontrainerinfo_prog6122;

import java.util.Scanner;


public class PokemonTrainerInfo_PROG6122 {
    
    /*
    This program allows users to add up to 10 pokemon trainers and then users can add up to 6 pokemon for each
    trainer(this is the amount of pokemon in a team for the classic pokemon games. With this information users 
    can search a trainer they wish to view.This program uses inheritance aswell as advanced arrays.))
    */
    
    public static void main(String[] args) {
        // Set the array size to 10 for a maximum of 10 Trainers
        Trainer[] trainers = new Trainer[10]; 
        int trainerCount = 0;

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Menu Selection: ");
            System.out.println("***************************");
            System.out.println("Enter (1) to enter a new Trainer");
            System.out.println("Enter (2) to add a pokemon to a trainer");
            System.out.println("Enter (3) to display a Trainer with all of their pokemon");
            System.out.println("Enter (4) to exit the program");
            int choice = scanner.nextInt();
            
            switch(choice){
                case 1:
                    //calls the addNewTrainer method
                    trainerCount = Trainer.addNewTrainer(trainers, trainerCount, scanner);
                    break;
                    
                case 2:
                    // Checks if there are trainers available to assign a Pokémon
                    if (trainerCount > 0) {
                        System.out.println("Enter the trainer name: ");
                        String trainerToAssign = scanner.next();
                        
                        // This finds the index of the trainer with the given name
                        int trainerIndex = findTrainerIndexByName(trainers, trainerToAssign, trainerCount);

                        if (trainerIndex != -1) {
                            // If the trainer is found, calls the method to add a Pokémon to the trainer
                            trainers[trainerIndex].addPokemonToTrainer(scanner);
                        } else {
                            // If the trainer is not found, inform the user
                            System.out.println("The trainer could not be found\n");
                        }
                    } else {
                        // If there are no trainers available, it tells the user to add a trainer first
                        System.out.println("No trainers available. Please add a trainer first.\n");    
                    }
                    break;
                    
                case 3:
                    // Checks if there are trainers available to search
                    if (trainerCount > 0) {
                        Trainer.searchTrainer(trainers, trainerCount, scanner);
                    } else {
                        System.out.println("No trainers available. Please add a trainer first.");
                    }
                    break;
                                        
                case 4:
                    // Exits the program
                    System.out.println("Exiting the program.");
                    return;
                     
                default: 
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
         
        
        
    }
    
    public static int findTrainerIndexByName(Trainer[] trainers, String name, int trainerCount) {
    for (int i = 0; i < trainerCount; i++) {
        if (trainers[i] != null && trainers[i].getName().equalsIgnoreCase(name)) {
            return i;
        }
    }
    return -1;
}
    
    
}
    

