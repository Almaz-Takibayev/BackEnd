object Main {
  def main(args:Array[String]) : Unit = {
//    helloWorld()
//    typesOfVariable()
//    declaringVariableTypes()
//    ifElse()
//    matchExpressions(1, true)

//    println(getClassAsString(5))

//    tryCatch()

//    loops()
    whileLoops()
  }

  def helloWorld(): Unit = {
    println("Hello, world")
  }

  def typesOfVariable(): Unit = {
    val x = 1 // immutable
    var y = 1 // mutable
    println("Immutable variable x = " + x)
    println("Mutable variable y = " + y)
  }

  def declaringVariableTypes(): Unit = {
    val x = 1
    val s = "string"

    println("x = " + x + "\ns: " + s)

    val a: Int = 1;
    val str: String = "string"
    println("a = " + a + "\nstr: " + str)
  }

  def ifElse(): Unit = {
    val a = 1;
    val b = 2;

    if (a>b) {
      println("a is greater than b")
    }
    else {
      println("b is greater than a")
    }

    val x = if (a>b) a else b

    println(x)
  }

  def matchExpressions(i: Int, bool: Boolean): Unit = {
    val result = i match {
      case 1 => "one"
      case 2 => "two"
      case _ => "not 1 or 2"
    }

    println(result)

    val booleanAsString = bool match {
      case true => "true"
      case false => "false"
    }

    println(booleanAsString)
  }

  def getClassAsString(x: Any):String = x match {
    case s: String => s + " is a String"
    case i: Int => "Int"
    case f: Float => "Float"
    case l: List[_] => "List"
    case _ => "Unknown"
  }

  def tryCatch(): Unit = {
    val a = 5

    try {
      println(a / 0)
    }
    catch {
      case exception: Exception => println(exception)
    }
  }

  def loops(): Unit = {
//    val subjects = Array("Backend", "Operating Systems", "PLT")
//    for (subject <- subjects) println(subject)

//    for (i <- 0 to 5) println(i)

//    for (i <- 0 to 10 by 2) println(i)

//    val x = for (i <- 1 to 5) yield i * 2
//    for (i <- x) println(i)

    val fruits = List("apple", "banana", "lime", "orange")
    val fruitLengths = for {
      f <- fruits
      if f.length > 4
    } yield f.length
    for (i <- fruitLengths) println(i)
  }

  def whileLoops(): Unit = {
    var a = 5
    val b = 8

    while(b > a) {
    a = a + 1
      println(a)
    }

//    do {
//      a = a + 1
//      println(a)
//    }
//    while(b > a)
  }
}