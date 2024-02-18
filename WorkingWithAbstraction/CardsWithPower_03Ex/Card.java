package WorkingWithAbstraction.CardsWithPower_03Ex;

public class Card {
    private CardRank rank;
    private CardSuit suit;
    private int power;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.rank = cardRank;
        this.suit = cardSuit;
    }

    public CardRank getRank() {
        return rank;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public int getPower() {
        return (this.rank.getPower() + this.suit.getPower());
    }

    public void setPower(int power) {
        this.power = power;
    }
}
