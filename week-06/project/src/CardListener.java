/// Created by BB on 2016-11-25.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardListener implements ActionListener {
    private Card card;
    private GameBoard board;

    /// Constructor

    public CardListener(Card card, GameBoard board) {
        this.card = card;
        this.board = board;
    }

    /// Implement

    @Override
    public void actionPerformed(ActionEvent e) {
        card.setImageIcon(card.getId()+".png");
        switch (board.getCardsClicked()) {
            case 0:
                board.setMatchThis(card);
                board.setMatchCardNumber(board.getCards().indexOf(card));
                board.setCardsClicked(board.getCardsClicked()+1);
                break;
            case 1:
                if (board.getMatchCardNumber() == board.getCards().indexOf(card)) {
                    break;
                } else if (board.getMatchThis().getId() == card.getId()) {
                    match();
                } else {
                   refresh();
                }
                board.setCardsClicked(0);
                break;
        }
    }

    /// Methods

    private void match() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                    board.getMatchThis().setMatched(true);
                    card.setMatched(true);
                    board.getMatchThis().setEnabled(false);
                    card.setEnabled(false);
                    board.setAllMatches(board.getAllMatches() + 1);
                    gameWon();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void gameWon(){
        if (board.getAllMatches() == 8) {
            JOptionPane.showMessageDialog(null, "You win!");
            System.exit(0);
        }
    }

    private void refresh() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    for (Card c : board.getCards()) {
                        if (!c.isMatched()) {
                            c.setImageIcon("back.png");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
