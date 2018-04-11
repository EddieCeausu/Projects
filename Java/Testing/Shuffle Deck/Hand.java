public class Hand extends Deck {
  List<Cards> cards = new ArrayList<Cards>();
  int cardCount = cards.length;
  Cards currentCard;

  public Hand(Deck[] cards) {
    for (int i = 0; i < card.length; i++) {
      this.cards.add(cards[i]);
    }
    currentCard = this.cards.get(0);
  }

  public void sort() {
    for (int i = 0; i < cards.size(); i++)
      for (int j = i; j >= 0; j--) {

        //if(cards.get(i)
      }
  }

  @Override
  public int compareTo(Cards otherCard) {
    if (Deck.std.indexOf(otherCard) > Deck.std.indexOf(this.currentCard))
      return otherCard;
    return this.currentCard;
  }

}
