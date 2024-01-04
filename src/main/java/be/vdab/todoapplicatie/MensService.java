package be.vdab.todoapplicatie;

import jakarta.persistence.Table;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MensService {
    private final MensRepository mensRepository;

    public MensService(MensRepository mensRepository) {
        this.mensRepository = mensRepository;
    }

    @Transactional
    public long voegMensToe(NieuweMens nieuweMens) {
        Mens mens = new Mens(nieuweMens.voornaam(), nieuweMens.familienaam());
        return mensRepository.save(mens).getId();
    }

    public Optional<Mens> findById(long id) {
        return mensRepository.findById(id);
    }

    public void updateMensWithNewTodo(long mensId, Todo newTodo) {
        Optional<Mens> optionalMens = mensRepository.findById(mensId);

        if (optionalMens.isPresent()) {
            Mens mens = optionalMens.get();
            mens.addTodo(newTodo);

            mensRepository.save(mens);
        } else {
            // Handle case where Mens with the given ID is not found
        }
    }
}
