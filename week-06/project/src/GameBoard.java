/// Created by BB on 2016-11-25.

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameBoard extends JFrame {
    private ArrayList<Card> cards = new ArrayList<>(1);
    private int cardsClicked = 0;
    private Card matchThis;
    private int matchCardNumber;
    private int allMatches = 0;

    /// Constructor

    public GameBoard() {
        this.shuffleCards();
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255,255,255));
        panel.setLayout(new GridLayout(4, 4, 0, 0));
        for (Card card : cards) {
            panel.add(card);
        }
        this.add(panel);
    }

    /// Methods

    public void shuffleCards() {
        ArrayList<Integer> cardIds = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            cardIds.add(i);
            cardIds.add(i);
        }
        Collections.shuffle(cardIds);
        for (int i : cardIds) {
            Card card = new Card(i);
            card.addActionListener(new CardListener(card, this));
            cards.add(card);
        }
    }

    /// Getters and Setters

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getCardsClicked() {
        return cardsClicked;
    }

    public void setCardsClicked(int cardsClicked) {
        this.cardsClicked = cardsClicked;
    }

    public Card getMatchThis() {
        return matchThis;
    }

    public void setMatchThis(Card matchThis) {
        this.matchThis = matchThis;
    }

    public int getMatchCardNumber() {
        return matchCardNumber;
    }

    public void setMatchCardNumber(int matchCardNumber) {
        this.matchCardNumber = matchCardNumber;
    }

    public int getAllMatches() {
        return allMatches;
    }

    public void setAllMatches(int allMatches) {
        this.allMatches = allMatches;
    }
}
