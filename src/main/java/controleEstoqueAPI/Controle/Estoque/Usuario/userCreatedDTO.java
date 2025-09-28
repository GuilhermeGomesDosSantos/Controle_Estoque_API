package controleEstoqueAPI.Controle.Estoque.Usuario;

public record userCreatedDTO (Long id, String login, String role){
    public userCreatedDTO(Usuario user){
        this(user.getId(), user.getLogin(), user.getRole());
    }
}
