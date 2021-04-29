import java.util.UUID

import scala.concurrent.{ExecutionContext, Future}

class InMemoryTodoRepository(initialTodos:Seq[Todo] = Seq.empty)(implicit ec:ExecutionContext) extends TodoRepository {

  private var todos: Vector[Todo] = initialTodos.toVector

  override def all(): Future[Seq[Todo]] = Future.successful(todos)

  override def done(): Future[Seq[Todo]] = Future.successful(todos.filter(_.done))

  override def pending(): Future[Seq[Todo]] = Future.successful(todos.filterNot(_.done))

  override def create(createTodo: CreateTodo): Future[Todo] =
    Future.successful {
      val todo = Todo(
        id = UUID.randomUUID().toString,
        title = createTodo.title,
        description = createTodo.description,
        done = false
      )
      todos = todos :+ todo
      todo
    }

  override def update(id: String, updateTodo: UpdateTodo): Future[Todo] =
    Future.successful {
      val todo = Todo(
        id = id,
        title = updateTodo.title,
        description = updateTodo.description,
        done = updateTodo.done
      )

      todos = todos.filterNot(_.id == id) :+ todo

      todo
    }

  override def existTitle(title: String): Boolean = {
    var exist = false;
    todos.foreach(todo => {
      if (todo.title.equals(title)) {
        exist = true;
      }
    })

    exist
  }

}