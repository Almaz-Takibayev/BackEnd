import akka.actor.typed.{ActorRef, ActorSystem}
import akka.actor.typed.scaladsl.Behaviors
import org.slf4j.{Logger, LoggerFactory}

object Main extends App {

  implicit val log: Logger = LoggerFactory.getLogger(getClass)

  val rootBehavior = Behaviors.setup[Nothing] { context =>

    implicit val ec = context.executionContext
    implicit val sys = context.system

    val calculatorRepository = context.spawn(CalculatorRepository(), "CalculatorRepository")
    val router = new MyRouter(calculatorRepository)

    MyServer.startHttpServer(router.route)
    Behaviors.empty
  }

  val system = ActorSystem[Nothing](rootBehavior, "CalculatorAkkaHttpServer")
}
