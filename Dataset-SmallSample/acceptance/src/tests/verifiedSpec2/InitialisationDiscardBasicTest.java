package tests.verifiedSpec2;

import java.util.LinkedList;
import java.util.List;

import framework.Test;
import framework.cards.Card;
import framework.interfaces.GameState;
import framework.interfaces.MoveMaker;
/**
 * Testing the basic mechanics of victory point addition and removal.
 * @author Damon (Stacey damon.stacey)
 */
public class InitialisationDiscardBasicTest extends Test {

   @Override
   public String getShortDescription() {
      return "Checking Discard pile can be initialised as required..";
   }

   @Override
   public void run(GameState gameState, MoveMaker move)
                                          throws AssertionError,
                                          UnsupportedOperationException,
                                          IllegalArgumentException {

      List<Card> discard = new LinkedList<Card>();
      gameState.setDiscard(discard);
      discard = gameState.getDiscard();
      assert (discard.size() == 0);     
      
      List<Card> cards = getPopulatedCards();
      for (Card c : cards) {
         discard = new LinkedList<Card>();
         gameState.setDiscard(discard);
         if (!c.toString().equals("Not A Card")) {           
            for (int i = 0; i < 52; i++) {
               discard.add(c); 
               gameState.setDiscard(discard);
               discard = gameState.getDiscard();
               assert (discard.size() == i + 1);
               for (int j = 0; j < i; j++) {        
                  assert (discard.get(j).toString().equals(c.toString()));     
               }
            }
         }
      }
      discard = new LinkedList<Card>();
      gameState.setDiscard(discard);
      discard = gameState.getDiscard();
      assert (discard.size() == 0);     
   }

   private boolean contains (List<Card> cards, Card card) {
      boolean contains = false;
      for (int i = 0; i < cards.size() && (!contains); i++) {
         if (cards.get(i).toString().equals(card.toString())) {
            contains = true;
         } 
      } 
      return contains;   
   }

   private List<Card> getPopulatedCards() {
      List<Card> cards = new LinkedList<Card>();
      cards.add(Card.AESCULAPINUM);
      cards.add(Card.ARCHITECTUS);
      cards.add(Card.BASILICA);
      cards.add(Card.CENTURIO);
      cards.add(Card.CONSILIARIUS);
      cards.add(Card.CONSUL);
      cards.add(Card.ESSEDUM);
      cards.add(Card.FORUM);
      cards.add(Card.GLADIATOR);
      cards.add(Card.HARUSPEX);
      cards.add(Card.LEGAT);
      cards.add(Card.LEGIONARIUS);
      cards.add(Card.MACHINA);
      cards.add(Card.MERCATOR);
      cards.add(Card.MERCATUS);
      cards.add(Card.NERO);
      cards.add(Card.ONAGER);
      cards.add(Card.PRAETORIANUS);
      cards.add(Card.SCAENICUS);
      cards.add(Card.SENATOR);
      cards.add(Card.SICARIUS);
      cards.add(Card.TEMPLUM);
      cards.add(Card.TRIBUNUSPLEBIS);
      cards.add(Card.TURRIS);
      cards.add(Card.VELITES);
      cards.add(Card.NOT_A_CARD);
      return cards;
   }

}
