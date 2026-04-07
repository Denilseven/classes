// Observação: agora q tô pensando nisso, não era nem um pouco necessário criar
// uma classe USUÁRIO e BANCO para cumprir os requisitos da atividade... só um
// "usuário == admin, senha == admin" já era suficiente, mas eu já implementei
// isso tudo então fazer o quê né ,_,

package principal;

public class Usuario {
    private String nome;
    private String senha; // WARNING: "Segurança 10000%"

    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public boolean validar(String senha) {
        return this.senha.equals(senha);
    }
}
