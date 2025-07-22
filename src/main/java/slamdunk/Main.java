package slamdunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Game> games = new ArrayList<>();  // List to store games
    static Tournament tournament = null;

    public static void main(String[] args) {
        tournament = createTournament();

        // Printing tournament details
        printTournamentResult();
    }

    public static Tournament createTournament() {
        Tournament tournament = new Tournament("Philadelphia 76ers at Los Angeles Lakers", "2001");
        List<Team> teams = createTeams();
        List<Player> players = createPlayers(teams);
        for(Team team: teams) {
            tournament.addTeam(team);
        }
        List<Game> games = createGame(teams, players);
        for(Game game: games) {
            tournament.addGame(game);
        }

        return tournament;
    }

    // Method to create a game
    public static List<Game> createGame(List<Team> teams, List<Player> players) {
        int[][][] playerStatsOfAllGames = {
                {
                        {18, 3, 9, 2, 3, 6},
                        {3, 1, 2, 2, 5, 9},
                        {4, 0, 5, 5, 11, 0},
                        {1, 0, 2, 1, 5, 0},
                        {2, 0, 0, 0, 0, 0},
                        {7, 0, 1, 0, 3, 5},
                        {17, 0, 10, 6, 14, 5},
                        {7, 3, 2, 1, 6, 5},
                        {3, 0, 2, 4, 1, 0},
                        {0, 0, 0, 0, 0, 1}
                },
                {
                        {10, 3, 0, 0, 4, 3},
                        {6, 2, 0, 4, 2, 6},
                        {5, 0, 6, 4, 9, 1},
                        {1, 0, 0, 1, 4, 0},
                        {1, 1, 0, 0, 3, 0},
                        {11, 1, 8, 1, 7, 6},
                        {12, 0, 4, 8, 12, 9},
                        {5, 2, 2, 0, 0, 3},
                        {0, 0, 0, 1, 5, 2},
                        {2, 0, 2, 2, 3, 2}
                },
                {
                        {12, 3, 10, 2, 10, 4},
                        {9, 0, 5, 5, 7, 0},
                        {2, 0, 1, 1, 5, 8},
                        {1, 0, 0, 0, 2, 0},
                        {1, 1, 0, 0, 1, 0},
                        {13, 0, 6, 0, 6, 3},
                        {11, 0, 8, 3, 9, 3},
                        {2, 0, 3, 1, 1, 2},
                        {2, 0, 0, 3, 4, 1},
                        {1, 0, 1, 0, 0, 2}
                },
                {
                        {12, 1, 10, 1, 3, 4},
                        {9, 0, 1, 3, 6, 0},
                        {1, 0, 3, 0, 3, 2},
                        {3, 0, 1, 2, 5, 1},
                        {0, 0, 0, 1, 2, 1},
                        {6, 0, 7, 2, 8, 9},
                        {1, 0, 8, 8, 6, 5},
                        {4, 2, 0, 0, 1, 1},
                        {2, 1, 2, 0, 1, 4},
                        {1, 0, 0, 0, 5, 0}
                }
        };

        String[] gameDates = {
                "2001-06-06",
                "2001-06-08",
                "2001-06-10",
                "2001-06-13"
        };

        int[] gameAttendance = {
                18997,
                18997,
                20900,
                20896
        };

        // Creating new games
        String[][] gameData = new String[gameDates.length][5];
        for(int i=0; i<gameData.length; i++) {
            String[] gameInfo = new String[5];
            gameInfo[0] = String.valueOf(i+1);
            gameInfo[1] = gameDates[i];
            gameInfo[2] = "0";
            gameInfo[3] = "1";
            gameInfo[4] = String.valueOf(gameAttendance[i]);
            gameData[i] = gameInfo;
        }
        games = Game.populateGames(teams, gameData);

        for(int i=0; i<games.size(); i++) {
            Game game = games.get(i);
            List<PlayerGameStats> playerGameStats = PlayerGameStats.populatePlayerGameStats(games.get(i), players, playerStatsOfAllGames[i]);
            for(PlayerGameStats playerStats: playerGameStats) {
                game.addPlayerGameStats(playerStats);
            }
        }
        return games;
    }

    // Method to create teams and call createPlayers
    public static List<Team> createTeams() {

        String[][] teamData = {
                {"Philadelphia 76ers", "Conference 1"},
                {"Los Angeles Lakers", "Conference 2"}
        };

        // Populate teams here
        List<Team> teams = Team.populateTeam(teamData);

        return teams;
    }

    // Method to create players and associate them with teams
    public static List<Player> createPlayers(List<Team> teams) {
        List<Player> players = new ArrayList<>();

        String[][] playerData = {
                {"0", "Allen Iverson", "1"},
                {"0", "Aaron McKie", "2"},
                {"0", "Dikembe Mutombo", "3"},
                {"0", "Tyrone Hill", "4"},
                {"0", "Jumaine Jones", "5"},
                {"1", "Kobe Bryant", "6"},
                {"1", "Shaquille O'Neal", "7"},
                {"1", "Rick Fox", "8"},
                {"1", "Horace Grant", "9"},
                {"1", "Derek Fisher", "10"}
        };

        // Populate players into the teams here
        int teamCounter = 0;
        for(Team team: teams) {
            List<Player> teamPlayers = Player.populatePlayer(playerData, teamCounter++);
            for(Player player: teamPlayers) {
                team.addPlayer(player);
                players.add(player);
            }
        }
        return players;
    }

    // Method to print game results.
    public static void printTournamentResult() {
        System.out.println("\nTournament: "+tournament.getName());
        System.out.println("-------------------------------------------------------\n");
        System.out.println("---Game-wise Stats---");
        int gameCount = 1;
        for(Game game: games) {
            System.out.println("Game # " + gameCount++ + ":");
            System.out.println(game.gameSummary());
            System.out.println("-------------------------------------------------------\n");
            Map<Team, Player> highestScorerMap = game.highestScorer();
            System.out.println("Team: "+ game.homeTeam.getName() + ", Highest Scorer: "+highestScorerMap.get(game.homeTeam).getName());
            System.out.println("Team: "+ game.awayTeam.getName() + ", Highest Scorer: "+highestScorerMap.get(game.awayTeam).getName());
            System.out.println("-------------------------------------------------------\n");
        }
        Team tournamentWinner = tournament.getTournamentWinner(games);
        Player mvp = tournament.highestScorer(games);
        tournament.mvpStats(mvp);
        System.out.println("Tournament Winner: "+ tournamentWinner.getName());
        System.out.println("Highest Scorer of the Tournament: "+ mvp.getName());
        System.out.println("-------------------------------------------------------");
        System.out.println("MVP Stats:");
        System.out.println("-- MVP Player: "+mvp.getName());
        System.out.println("-- Total Rebounds: "+tournament.getMvpRebounds());
        System.out.println("-- Total Assists: "+tournament.getMvpAssists());
        System.out.println("-- Total Games Played: "+tournament.getMvpGamesPlayed());
        System.out.println("-- Total Points Scored: "+tournament.getMvpTotalPoints());
        System.out.println("-------------------------------------------------------");
    }
}