import java.util.*;

public class Game{

    private String playerName;

    public Game(String playerName){
        this.playerName = playerName;
    }

    public void play()
    {
        System.out.println("Let's set up the game!");

        Player player = new Player(playerName);
        Dealer dealer = new Dealer("Dealer");
        Deck deck = new Deck();
        dealer.setDeck(deck);

        dealer.dealCard(player);
        dealer.dealCard(player);
        System.out.println("Dealer dealt two cards to " + player.getName() + ".");

        dealer.dealCard(dealer);
        dealer.dealCard(dealer);
        System.out.println("Dealer dealt two cards to itself.");

        interactWithHumanPlayer(player, dealer);

        if(player.showScore() > 21)
        {
            System.out.println("Game over. House wins");
        }else
        {
            automateComputerPlayer(player, dealer);
            checkWinner(dealer.compareScores(player));
        }
    }

    private void checkWinner(GameActor winner)
    {
        if(winner == null)
        {
            System.out.println("Draw!");
        }else
        {
            System.out.println( winner.getName() + " is the winner!");
        }
    }


    private void interactWithHumanPlayer(Player player, Dealer dealer)
    {
        Scanner scanner = new Scanner(System.in);
        boolean twist = true;

        System.out.println("\n" + player.getName() + "'s current hand:\n" + player.toString());

        while(askTwistOrStick(player)){

            System.out.println("Would you like to twist (t) or stick (s)? ");

            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("T")){
                dealer.dealCard(player);
                System.out.println(player.getName() + "'s hand:\n" + player.toString());
            }else if(answer.equalsIgnoreCase("S")){
                System.out.println(player.getName() + " sticks. Dealer turn");
                break;
            }else{
                System.out.println("'" + answer + "' is not a valid answer.");
            }
        }

        if(player.showScore() > 21)
        {
            System.out.println(player.getName() + " is bust! Final score is " + player.showScore());
        }else if (player.showScore() == 21) {
            System.out.println(player.getName() + " has 21. Let's see what the dealer has ");
        }else
        {
            System.out.println(player.getName() + " has decided to stick on " + player.showScore());
        }
    }

    private boolean askTwistOrStick(Player player)
    {
        if(player.showScore() < 21)
        {
            return true;
        }else
        {
            return false;
        }
    }

    private void automateComputerPlayer(Player player, Dealer dealer)
    {
        System.out.println("Dealer's hand:\n" + dealer.toString());

        while(dealer.showScore() < 17)
        {
            dealer.dealCard(dealer);
            System.out.println("Dealer's hand:\n" + dealer.toString());
        }

        if(dealer.showScore() > 21)
        {
            System.out.println("Dealer is bust! Final score is" + dealer.showScore());
        }else {
            System.out.println("Dealer sticks. Final score is  " + dealer.showScore());
        }
    }

}