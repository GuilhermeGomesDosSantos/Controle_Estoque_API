package controleEstoqueAPI.Controle.Estoque.domain.Usuario;

public record userCreatedDTO (Long id, String login, userRole role){
    public userCreatedDTO(Usuario user){
        this(user.getId(), user.getLogin(), user.getRole());
    }
}
