class Card(suit: String, value: Int) {
  private val symbol = returnSymbol(value)

  override def toString: String = suit + symbol

  def returnSymbol(input: Int): String = {
    if (input < 11) return input.toString
    input match {
      case 11 => "J"
      case 12 => "Q"
      case 13 => "K"
      case 14 => "A"
      case _ => "-1"
    }
  }

  def getValue: Int = value
  def getSuit: String = suit

}
