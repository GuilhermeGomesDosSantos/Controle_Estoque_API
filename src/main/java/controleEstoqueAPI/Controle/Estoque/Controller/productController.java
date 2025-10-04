package controleEstoqueAPI.Controle.Estoque.Controller;

import controleEstoqueAPI.Controle.Estoque.domain.Product.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    private ProductRepository repository;

    @PostMapping("/createProduct")
    @Transactional
    public ResponseEntity registerProduct(@RequestBody @Valid registerProductDTO data, UriComponentsBuilder uriComponentsBuilder){
        var product = new Product(data);
        repository.save(product);

        var uri = uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductDetailsDTO(product));
    }

    @PutMapping("/updateProduct")
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid UpdateProductDTO data){
        var product = repository.getReferenceById(data.id());

        product.atualizaProduto(data);

        return ResponseEntity.ok(new ProductDetailsDTO(product));
    }

    @DeleteMapping("/deleteProduct/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity productId(@PathVariable Long id){
        var product = repository.getReferenceById(id);

        return ResponseEntity.ok(new ProductDetailsDTO(product));
    }

    @GetMapping("/listAll")
    public List<ProductDetailsDTO> listAllProducts(@PageableDefault(sort = {"name"}, size = 5)Pageable pageable){
        return repository.findAll(pageable).stream().map(ProductDetailsDTO::new).toList();
    }

    @GetMapping("name/{name}")
    public ResponseEntity <Page<ProductDetailsDTO>> listProductName(@PathVariable String name, @PageableDefault(sort = {"name"}, size = 5)Pageable pageable){
        var listaProduct =  repository.findByNameContainingIgnoreCase(name, pageable).map(ProductDetailsDTO::new);

        return ResponseEntity.ok(listaProduct);
    }

    @GetMapping("/test")
    public ResponseEntity test(){
        return ResponseEntity.ok().build();
    }
}
