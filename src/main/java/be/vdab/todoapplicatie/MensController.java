package be.vdab.todoapplicatie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController @RequestMapping("/mensen")
public class MensController {
    private final MensService mensService;


    public MensController(MensService mensService) {

        this.mensService = mensService;

    }
    @GetMapping("/{id}")
    Mens findById(@PathVariable long id) {
        return mensService.findById(id).orElseThrow();
    }

    @PostMapping
    ResponseEntity<String> voegMensToe(@RequestBody NieuweMens nieuweMens) {
        mensService.voegMensToe(nieuweMens);
        return new ResponseEntity<>("Mens toegevoegd", HttpStatus.CREATED);
    }

    @PostMapping("/{id}/todos")
    ResponseEntity<String> voegTodoToe(@PathVariable long id, @RequestBody NieuweTodo nieuweTodo) {
        Optional<Mens> optionalMens = mensService.findById(id);
        if (optionalMens.isPresent()) {
            var mens = optionalMens.get();
            var todo = new Todo(nieuweTodo.tekst(), nieuweTodo.prioriteit());
            mensService.updateMensWithNewTodo(mens.getId(), todo);
            return new ResponseEntity<>("Todo toegevoegd", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Mens niet gevonden", HttpStatus.NOT_FOUND);
    }
}
