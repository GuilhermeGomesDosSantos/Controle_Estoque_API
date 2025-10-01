package controleEstoqueAPI.Controle.Estoque.Controller;

import controleEstoqueAPI.Controle.Estoque.domain.Product.Product;
import controleEstoqueAPI.Controle.Estoque.domain.Product.ProductDetailsDTO;
import controleEstoqueAPI.Controle.Estoque.domain.Product.ProductRepository;
import controleEstoqueAPI.Controle.Estoque.domain.Product.registerProductDTO;
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
}
