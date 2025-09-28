package controleEstoqueAPI.Controle.Estoque.Controller;

import controleEstoqueAPI.Controle.Estoque.Usuario.Usuario;
import controleEstoqueAPI.Controle.Estoque.Usuario.UsuarioRepository;
import controleEstoqueAPI.Controle.Estoque.Usuario.userCreatedDTO;
import controleEstoqueAPI.Controle.Estoque.Usuario.userDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/register")
public class usuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerUser(@RequestBody @Valid userDTO data, UriComponentsBuilder uriComponentsBuilder){
        var user = new Usuario(data);
        repository.save(user);

        var uri = uriComponentsBuilder.path("/login/{id}").buildAndExpand(user.getId()).toUri();

        return  ResponseEntity.created(uri).body(new userCreatedDTO(user));
    }
}
