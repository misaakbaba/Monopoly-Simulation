import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.setGame();
        ArrayList<Person> players = game.getPlayers();
        Jail jail = ((Jail) game.getGameBoard().getGameboard().get(30));
        Dice dice = new Dice();//zar objesi oluşturuldu

        //oyunun oynandığı döngü burası
        boolean state = true;//oyunun bittiğini anlamak için durum
        int dices[];//zar objesinden dönen degerleri tutmak için değişken
        int playerNumber = players.size();
        int cyclecount = 0;
        while (state) {
            game.setCycle(++cyclecount);
            for (int i = 0; i < playerNumber; i++) {
                game.setTurn(i + 1);
                game.beforeRollingDices(players.get(i));
                dices = dice.rollDice();
                if (players.get(i).getInJail()) {
                    if (players.get(i).attemtpExitJail(dices, jail)) {
                        System.out.println(players.get(i).getName() + " is released from jail");
                    }
                    continue;
                }
                game.move(players.get(i), dices[2]);
                game.updateStatus(players.get(i));
                game.afterRollingDices(players.get(i), dices);
                if (game.isBankrupt(players.get(i))) {
                    System.out.println(players.get(i).getName() + " is bankrupt");
                    players.remove(players.get(i));
                    playerNumber = players.size();
                    i--;
                }
                if (game.isGameOver()) {
                    System.out.println("Game is over. Winner is: " + players.get(0).getName() + ". Player's current balance is: " + players.get(0).getCurrentBalance());
//                    state = false;
                    System.exit(0);
                }


            }
        }
    }
}
