package controleEstoqueAPI.Controle.Estoque.Controller;

import controleEstoqueAPI.Controle.Estoque.domain.Product.ProductRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deleteProduct/{id}")
public class deleteProductController {
    @Autowired
    private ProductRepository repository;

    @DeleteMapping
    public ResponseEntity deleteProduct(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
