package slamdunk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tournament {
    public String name;
    public String season;
    public List<Team> teams;
    public List<Game> games;
    public Player mvp;
    int mvpRebounds;
    int mvpAssists;
    int mvpGamesPlayed;
    int mvpTotalPoints;

    public Tournament(String name, String season) {
        this.name = name;
        this.season = season;
        this.teams = new ArrayList<>();
        this.games = new ArrayList<>();
        this.mvpRebounds = 0;
        this.mvpAssists = 0;
        this.mvpGamesPlayed = 0;
        this.mvpTotalPoints = 0;
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public List<Team> getTeams() {
        return this.teams;
    }

    public String getName() {
        return this.name;
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public List<Game> getGames() {
        return this.games;
    }

    public void setMvp(Player player) {
        this.mvp = player;
    }

    public Player getMvp() {
        return this.mvp;
    }

    public int getMvpRebounds() {
        return mvpRebounds;
    }

    public int getMvpAssists() {
        return mvpAssists;
    }

    public int getMvpGamesPlayed() {
        return mvpGamesPlayed;
    }

    public int getMvpTotalPoints() {
        return mvpTotalPoints;
    }

    public Player highestScorer(List<Game> games) {
        int maxScore = 0;
        Player player = null;
        for(Game game: games) {
            PlayerGameStats highestPlayerStatForGame = game.highestScorerInGame();
            int currScore = highestPlayerStatForGame.getPlayerGameScore();
            if(currScore>maxScore) {
                maxScore = currScore;
                player = highestPlayerStatForGame.getPlayer();
            }
        }
        setMvp(player);
        return player;
    }

    public void mvpStats(Player player) {
        for(Game game: games) {
            for(PlayerGameStats playerStat: game.getPlayersStat()) {
                if(playerStat.getPlayer().equals(player)) {
                    mvpRebounds+=playerStat.getOffensiveRebound() + playerStat.getDefensiveRebound();
                    mvpAssists+=playerStat.getAssist();
                    mvpGamesPlayed++;
                    mvpTotalPoints+=playerStat.getPlayerGameScore();
                }
            }
        }
    }

    public Team getTournamentWinner(List<Game> games) {
        Map<Team, Integer> winningTeams = new HashMap<>();
        for(Game game: games) {
            Team winner = game.winner;
            winningTeams.putIfAbsent(winner, 0);
            winningTeams.put(winner, winningTeams.get(winner)+1);
        }

        int max = 0;
        Team winningTeam = null;
        for(Map.Entry<Team, Integer> entry: winningTeams.entrySet()) {
            if(entry.getValue()>max) {
                winningTeam = entry.getKey();
                max = entry.getValue();
            }
        }
        return winningTeam;
    }
}
