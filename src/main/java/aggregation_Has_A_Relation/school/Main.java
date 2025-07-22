package aggregation_Has_A_Relation.school;

import java.util.ArrayList;
import java.util.List;

class Player {
    int id;
    String team;
    String name;
    public Player(int id, String team, String name) {
        this.id = id;
        this.team = team;
        this.name = name;
    }
}

/* Team class contains a list of Player
Objects.*/
class Team {
    List<Player> players;
    String name;

    public Team(List<Player> players, String name) {
        this.players = players;
        this.name = name;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}

/* School class contains a list of Team
Objects.*/
class School {
    List<Team> teams;
    String schoolName;

    public School(List<Team> teams, String schoolName) {
        this.teams = teams;
        this.schoolName = schoolName;
    }

    public int getTotalPlayersinSchool() {
        int count=0;
        for(Team team: teams) {
            count+=team.getPlayers().size();
        }
        return count;
    }
}

// Main class
class Main {

    public static void main (String[] args) {
        Player p1 = new Player(1, "Red", "Harris");
        Player p2 = new Player(2, "Red", "Carol");
        Player p3 = new Player(1, "Blue", "Johnny");
        Player p4 = new Player(2, "Blue", "Sarah");
        List<Player> players1 = new ArrayList<>();
        players1.add(p1);
        players1.add(p2);
        List<Player> players2 = new ArrayList<>();
        players2.add(p3);
        players2.add(p4);
        Team t1 = new Team(players1, "Red");
        Team t2 = new Team(players2, "Blue");
        List<Team> teams = new ArrayList<>();
        teams.add(t1);
        teams.add(t2);
        School school = new School(teams, "ABC School");
        System.out.println(school.getTotalPlayersinSchool());
    }
}
