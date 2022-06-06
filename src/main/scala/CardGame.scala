import scala.collection.mutable.ListBuffer
import scala.util.Random

class CardGame(name: String) {
  private var deckOfCards = initialiseDeck

  def getDeck: List[Card] = deckOfCards.toList

  def getSuitFromSuitNum(suitNum: Int): String = {
    suitNum match {
      case 0 => "♥"
      case 1 => "♦"
      case 2 => "♠"
      case 3 => "♣"
      case _ => "-1"
      // remove default and throw exception instead
    }
  }

  def initialiseDeck: ListBuffer[Card] = {
    val temporaryDeck = new ListBuffer[Card]
      for (value <- 2 until 15) {
        for (suitNum <- 0 until 4) {
          val suit = getSuitFromSuitNum(suitNum)
          temporaryDeck.addOne(new Card(suit, value))
        }
      }
    temporaryDeck
  }

  def dealCard: Card = {
    val temporaryCard = deckOfCards.head
    deckOfCards.remove(0)
    temporaryCard
  }

  def shuffleDeck(): Unit = {
    deckOfCards = Random.shuffle(deckOfCards)
  }

  def sortDeckInNumberOrder(): Unit = {
    val temporaryDeck = new ListBuffer[Card]
    for (value <- 2 until 15) {
      deckOfCards.foreach(card => if (card.getValue == value) temporaryDeck.addOne(card))
    }
    deckOfCards = temporaryDeck
  }
}
