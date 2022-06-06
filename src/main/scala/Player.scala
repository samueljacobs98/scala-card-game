class Player(private var name: String, private var responseChar: String) {

  def setName(newName: String): Unit =
    name = newName

  def getName: String = name

  def getResponseChar: String = responseChar

}
