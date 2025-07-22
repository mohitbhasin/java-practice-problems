package slamdunk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Game {
    // Data members here
    public Team homeTeam;
    public Team awayTeam;
    public int gameNumber;
    public String date;
    int attendance;
    public List<PlayerGameStats> playersStat;
    int homeTeamScore;
    int awayTeamScore;
    Team winner;

    // Add constructor here
    public Game(int gameNumber, String date, Team team1, Team team2, int attendance) {
        this.gameNumber = gameNumber;
        this.date = date;
        this.homeTeam = team1;
        this.awayTeam = team2;
        this.attendance = attendance;
        this.playersStat = new ArrayList<>();
        this.winner = null;
    }

    // Getters and setters
    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Team getWinner() {
        return this.winner;
    }

    public void addPlayerGameStats(PlayerGameStats stats) {
        playersStat.add(stats);
    }

    public List<PlayerGameStats> getPlayersStat() {
        return playersStat;
    }

    // Add Method to populate games here
    public static List<Game> populateGames(List<Team> teams, String[][] gameData) {
        List<Game> games = new ArrayList<>();
        for(String[] gameInfo: gameData) {
            int gameNumber = Integer.parseInt(gameInfo[0]);
            String date = gameInfo[1];
            Team teamA = teams.get(Integer.parseInt(gameInfo[2]));
            Team teamB = teams.get(Integer.parseInt(gameInfo[3]));
            int attendance = Integer.parseInt(gameInfo[4]);
            games.add(new Game(gameNumber, date, teamA, teamB, attendance));
        }
        return games;
    }

    public void teamScore() {
        homeTeamScore = calculateTeamScore(homeTeam);
        awayTeamScore = calculateTeamScore(awayTeam);
        if(homeTeamScore>awayTeamScore) {
            System.out.println("Team "+homeTeam.getName()+" score: "+homeTeamScore);
            System.out.println("Team "+awayTeam.getName()+" score: "+awayTeamScore);
            winner = homeTeam;
        } else {
            System.out.println("Team "+awayTeam.getName()+" score: "+awayTeamScore);
            System.out.println("Team "+homeTeam.getName()+" score: "+homeTeamScore);
            winner = awayTeam;
        }
    }

    public String gameSummary() {
        teamScore();

        if(homeTeamScore>awayTeamScore) {
            return homeTeam.getName()+" wins against "+awayTeam.getName()+" with a score of "+ homeTeamScore+" - "+awayTeamScore;
        } else if(awayTeamScore>homeTeamScore) {
            return awayTeam.getName()+" wins against "+homeTeam.getName()+" with a score of "+ awayTeamScore+" - "+homeTeamScore;
        } else {
            return "The game between "+homeTeam.getName()+" and "+awayTeam.getName()+" ended in a draw with a score of" + homeTeamScore +" - "+ awayTeamScore;
        }
    }

    private int calculateTeamScore(Team team) {
        int totalScore = 0;
        for(PlayerGameStats playerGameStats: playersStat) {
            Player currPlayer = playerGameStats.getPlayer();
            if(team.getPlayers().contains(currPlayer)) {
                totalScore+=playerGameStats.getPlayerGameScore();
            }
        }
        return totalScore;
    }

    public Player highestScorerInTeam(Team team) {
        int max = 0;
        Player highestTeamScorer = null;
        List<Player> players = team.getPlayers();
        for(PlayerGameStats playerStats: playersStat) {
            if(players.contains(playerStats.getPlayer())) {
                int playerScore = playerStats.getPlayerGameScore();
                if(playerScore>max) {
                    highestTeamScorer = playerStats.getPlayer();
                    max = playerScore;
                }
            }
        }
        return highestTeamScorer;
    }

    public Map<Team, Player> highestScorer() {
        Player homeTeamHighestScorer = highestScorerInTeam(homeTeam);
        Player awayTeamHighestScorer = highestScorerInTeam(awayTeam);
        Map<Team, Player> highestScorerMap = new HashMap<>();
        highestScorerMap.put(homeTeam, homeTeamHighestScorer);
        highestScorerMap.put(awayTeam, awayTeamHighestScorer);
        return highestScorerMap;
    }

    public PlayerGameStats highestScorerInGame() {
        int max = 0;
        PlayerGameStats highestPlayerStat = null;

        for(PlayerGameStats playerStat: playersStat) {
            int score = playerStat.getPlayerGameScore();
            if(score>max) {
                highestPlayerStat = playerStat;
                max=score;
            }
        }
        return highestPlayerStat;
    }
}