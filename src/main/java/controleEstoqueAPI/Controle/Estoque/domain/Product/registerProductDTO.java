package controleEstoqueAPI.Controle.Estoque.domain.Product;

import controleEstoqueAPI.Controle.Estoque.domain.Weight.ProductDetailsWeight;
import controleEstoqueAPI.Controle.Estoque.domain.Weight.Weight;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record registerProductDTO(
        @NotBlank
        String name,
        @NotNull
        Integer amount,
        @NotNull
        double price,
        @NotNull
        Category category,
        @NotBlank
        String brand,
        @NotNull
        @Valid
        ProductDetailsWeight weight
) {
}
