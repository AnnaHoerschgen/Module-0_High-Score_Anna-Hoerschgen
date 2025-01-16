
// Imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// main
public class Main {
    public void main(String[] args) {
        String currentPath = System.getProperty("user.dir");
        Player[] playerList = readPlayersFile(currentPath);
    }

    public Player[] readPlayersFile(String filepath) {
        BufferedReader br = null;
        try {
            // Define instances of class objects
            CSVParser myParser = new CSVParser();
            Player[] players = new Player[500];

            br = new BufferedReader(new FileReader(filepath));
            String line;

            int playerIndex = 0;
            while ((line = br.readLine()) != null) {

                // Split the line by commas and print each value
                String[] values = myParser.parseLine(line);
                players[playerIndex].setPlayerName(values[0]);
                players[playerIndex].setHighScore(Integer.parseInt(values[1]));
            }
            br.close();
            return players;

        } catch (IOException e) {
            System.out.println("An error happened while reading the file!");
            return new Player[1];
        }
    }
}

// Player class
class Player {
    private String name;
    private int highScore = 0;

    public int getHighScore() {
        return this.highScore;
    }

    public String getPlayerName() {
        return this.name;
    }

    public void setHighScore(int score) {
        this.highScore = score;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }
}

class CSVParser {
    public String[] parseLine(String line) {
      return line.split(",");
    }
}