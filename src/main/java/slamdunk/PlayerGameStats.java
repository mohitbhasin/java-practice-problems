package slamdunk;

import java.util.ArrayList;
import java.util.List;

public class PlayerGameStats {
    Game game;
    Player player;
    int fieldGoals;
    int threePoints;
    int freeThrows;
    int offensiveRebound;
    int defensiveRebound;
    int assist;

    public PlayerGameStats(Game game, Player player, int fieldGoals, int threePoints, int freeThrows, int offensiveRebound, int defRebound, int assist) {
        this.game = game;
        this.player = player;
        this.fieldGoals = fieldGoals;
        this.threePoints = threePoints;
        this.freeThrows = freeThrows;
        this.offensiveRebound = offensiveRebound;
        this.defensiveRebound = defRebound;
        this.assist = assist;
    }

    public Player getPlayer() {
        return player;
    }

    public int getOffensiveRebound() {
        return offensiveRebound;
    }

    public int getDefensiveRebound() {
        return defensiveRebound;
    }

    public int getAssist() {
        return assist;
    }

    public int getPlayerGameScore() {
        return (fieldGoals * 2) + threePoints + freeThrows;
    }

    public static List<PlayerGameStats> populatePlayerGameStats(Game game, List<Player> players, int[][] gameStats) {
        List<PlayerGameStats> playerGameStats = new ArrayList<>();
        for(int i=0; i<players.size(); i++) {
            PlayerGameStats playerStats = new PlayerGameStats(game,
                    players.get(i),
                    gameStats[i][0],
                    gameStats[i][1],
                    gameStats[i][2],
                    gameStats[i][3],
                    gameStats[i][4],
                    gameStats[i][5]);
            playerGameStats.add(playerStats);
        }
        return playerGameStats;
    }
}
