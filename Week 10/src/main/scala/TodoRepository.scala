
import scala.concurrent.Future

trait TodoRepository {
  def all(): Future[Seq[Todo]]

  def done(): Future[Seq[Todo]]

  def pending(): Future[Seq[Todo]]

  def create(createTodo: CreateTodo):Future[Todo]

  def update(id: String, updateTodo: UpdateTodo): Future[Todo]

  def existTitle(title: String): Boolean
}