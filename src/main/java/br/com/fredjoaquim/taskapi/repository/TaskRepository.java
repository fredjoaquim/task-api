package br.com.fredjoaquim.taskapi.repository;

import br.com.fredjoaquim.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
