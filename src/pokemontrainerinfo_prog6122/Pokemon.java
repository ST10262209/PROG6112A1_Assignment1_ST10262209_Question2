/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemontrainerinfo_prog6122;


public class Pokemon extends PocketMonster{
    private String type;

    public Pokemon(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    
}
