package controller;

import Service.AnimalService;
import animal.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animais")

public class AnimalController {
    
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> listar() {
        return animalService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscar(@PathVariable int id) {
        Animal animal = animalService.buscarPorId(id);
        return animal != null ? ResponseEntity.ok(animal) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Animal adicionar(@RequestBody Animal animal) {
        return animalService.salvar(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(@PathVariable int id, @RequestBody Animal animal) {
        Animal animalAtualizado = animalService.atualizarAnimal(id , animal);
        return animalAtualizado != null ? ResponseEntity.ok(animalAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        animalService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
