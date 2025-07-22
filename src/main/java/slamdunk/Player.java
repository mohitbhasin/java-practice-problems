package slamdunk;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public String name;
    public int number;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    // Populate players method
    public static List<Player> populatePlayer(String[][] playerData, int teamCounter) {
        List<Player> players = new ArrayList<>();
        for (String[] data : playerData) {
            int teamId = Integer.parseInt(data[0]);  // Get team ID
            if (teamCounter == teamId) {
                Player player = new Player(data[1], Integer.parseInt(data[2]));
                players.add(player);
            }
        }
        return players;
    }

    // Method to print a single player
    public void printPlayer() {
        System.out.println("--- Player Name: " + this.getName() + ", Player Number: " + this.getNumber());
    }
}