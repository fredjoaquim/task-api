package br.com.fredjoaquim.taskapi.service;

import br.com.fredjoaquim.taskapi.model.Task;
import br.com.fredjoaquim.taskapi.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task criar(Task tarefa) {
        return taskRepository.save(tarefa);
    }

    public List<Task> listar() {
        return taskRepository.findAll();
    }


    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Tarefa não encontrada"
                ));
    }


    public Task atualizarTarefa(Long id, Task tarefa) {
        buscarPorId(id);
        tarefa.setId(id);
        return taskRepository.save(tarefa);
    }

    public void excluir(Long id) {
        buscarPorId(id);
        taskRepository.deleteById(id);
    }
}