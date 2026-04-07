// Observação: agora q tô pensando nisso, não era nem um pouco necessário criar
// uma classe USUÁRIO e BANCO para cumprir os requisitos da atividade... só um
// "usuário == admin, senha == admin" já era suficiente, mas eu já implementei
// isso tudo então fazer o quê né ,_,

package principal;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Usuario> usuariosCadastrados;

    public Banco() {
        usuariosCadastrados = new ArrayList<Usuario>();
    }

    public Usuario cadastrarUsuario(String nome, String senha) {
        if (getUsuario(nome) != null) {
            System.out.println("Erro ao cadastrar usuário: usuário com esse nome já existe no banco");
            return null;
        }
        Usuario novoUsuario = new Usuario(nome, senha);
        usuariosCadastrados.add(novoUsuario);

        System.out.println("Novo usuário \"" + novoUsuario.getNome() + "\" cadastrado com sucesso!");
        return novoUsuario;
    }

    public Usuario getUsuario(String nome) {
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            if (usuariosCadastrados.get(i).getNome().equalsIgnoreCase(nome)) {
                return usuariosCadastrados.get(i);
            }
        }
        return null;
    }
}
