package controleEstoqueAPI.Controle.Estoque.domain.Weight;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDetailsWeight(
        @NotNull
        BigDecimal value_,
        @NotBlank
        String unit
) {
}
