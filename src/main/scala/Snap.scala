import scala.io.StdIn.readLine

class Snap (name: String) extends CardGame (name) {

  private var winner = false
  private var previousCard: Card = new Card("", -1)
  private val player1: Player = new Player("", "W")
  private val player2: Player = new Player("", "L")
  private var currentPlayer: Player = player1



  def getCurrentPlayer: Player = currentPlayer

  def setCurrentPlayer(newCurrentPlayer: Player): Unit = currentPlayer = newCurrentPlayer

  def getWinner: Boolean = winner

  def setWinner(newWinner: Boolean): Unit = winner = newWinner

  def setPreviousCard(newPreviousCard: Card): Unit = previousCard = newPreviousCard


  def setupGame(): Unit = {
    println("Player 1: Enter your name")
    val player1name = readLine()
    player1.setName(player1name)

    println("Player 2: Enter your name")
    val player2name = readLine()
    player2.setName(player2name)

    println(s"Hello ${player1.getName} and ${player2.getName}.")
  }

  def runGame(): Unit = {
    println(currentPlayer.getName)

    val newCard = dealCard
    println(newCard.toString)

    val response = readLine()

    if (newCard.getSuit == previousCard.getSuit && response.equalsIgnoreCase(currentPlayer.getResponseChar)) {
        setWinner(true)
    }

    setPreviousCard(newCard)

    if (!getWinner) {
      setCurrentPlayer(if (getCurrentPlayer == player1) player2 else player1)
    }
  }

  def playGame(): Unit = {
    shuffleDeck
    setupGame()

    println("To win, if it's your turn and there is a snap (i.e. to cards in a row with the same suit) then enter:\nPlayer 1: W\nPlayer 2: L")

    println(currentPlayer.getName + ": Press enter to flip the next card")
    readLine()
    while(getDeck.nonEmpty && !winner) {
      runGame()
    }

    var message = ""
    if (winner) message = s"Snap! ${currentPlayer.getName} wins!" else message = "You both lose!"
    println(message)
  }
}
