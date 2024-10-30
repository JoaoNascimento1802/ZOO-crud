package Service;

import animal.Animal;
import animalRepository.AnimalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public void excluir(int id) {
        animalRepository.deleteById(id);
    }

    public Animal atualizarAnimal(int id, Animal novosDados) {
        Animal animalExistente = animalRepository.findById(id).orElse(null);
        if (animalExistente != null) {
            animalExistente.setNome(novosDados.getNome());
            animalExistente.setEspecie(novosDados.getEspecie());
            animalExistente.setIdade(novosDados.getIdade());
            animalExistente.setHabitat(novosDados.getHabitat());
            return animalRepository.save(animalExistente);
        } else {
            return null;
        }
    }
}