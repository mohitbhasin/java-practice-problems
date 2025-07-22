package slamdunk;

import java.util.ArrayList;
import java.util.List;

public class Team {
    public String name;
    public String conference;
    private List<Player> players;

    public Team(String name, String conference) {
        this.name = name;
        this.conference = conference;
        this.players = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getConference() {
        return conference;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    // Other Member functions
    // Add method to populate teams here
    public static List<Team> populateTeam(String[][] teamData) {
        List<Team> teams = new ArrayList<>();
        for(String[] teamInfo: teamData) {
            teams.add(new Team(teamInfo[0], teamInfo[1]));
        }
        return teams;
    }

    // Method to print individual teams
    public void printTeam() {
        System.out.println("Team Name: " + getName() + ", Conference: " + getConference());
    }

    // Method to print team data
    public static void printTeamData(Team team) {
        System.out.println(" " +  team.getName() + "\n--Players:");
        for (Player player : team.getPlayers()) {
            System.out.println(" --- " + player.getName());
        }
    }
}