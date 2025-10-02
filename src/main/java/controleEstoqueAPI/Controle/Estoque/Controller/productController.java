package controleEstoqueAPI.Controle.Estoque.Controller;

import controleEstoqueAPI.Controle.Estoque.domain.Product.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/registerProduct")
public class productController {
    @Autowired
    private ProductRepository repository;

    @PostMapping("/product")
    @Transactional
    public ResponseEntity registerProduct(@RequestBody @Valid registerProductDTO data, UriComponentsBuilder uriComponentsBuilder){
        var product = new Product(data);
        repository.save(product);

        var uri = uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductDetailsDTO(product));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid UpdateProductDTO data){
        var product = repository.getReferenceById(data.id());

        product.atualizaProduto(data);

        return ResponseEntity.ok(new ProductDetailsDTO(product));
    }
}
