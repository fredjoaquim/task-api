package br.com.fredjoaquim.taskapi.controller;

import br.com.fredjoaquim.taskapi.model.Task;
import br.com.fredjoaquim.taskapi.service.TaskService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task criar(@Valid @RequestBody Task tarefa) {
        return taskService.criar(tarefa);
    }

    @GetMapping
    public List<Task> listar() {
        return taskService.listar();
    }

    @GetMapping("/{id}")
    public Task buscarPorId(@PathVariable Long id) {
        return taskService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Task atualizarTarefa(@PathVariable Long id, @Valid @RequestBody Task tarefa) {
        return taskService.atualizarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        taskService.excluir(id);
    }
}