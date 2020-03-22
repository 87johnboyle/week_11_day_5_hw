import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerName = "";

        while(playerName.equals(""))
        {
            System.out.println("Please enter a name for the player:");
            playerName = scanner.nextLine();
        }

        System.out.println("Welcome " + playerName + "!");

        Game game = new Game(playerName);
        game.play();
    }
}