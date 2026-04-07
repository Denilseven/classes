// Observação: agora q tô pensando nisso, não era nem um pouco necessário criar
// uma classe USUÁRIO e BANCO para cumprir os requisitos da atividade... só um
// "usuário == admin, senha == admin" já era suficiente, mas eu já implementei
// isso tudo então fazer o quê né ,_,

package principal;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha; // WARNING: "Segurança 10000%"
    private ArrayList<String> carrinho;

    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.carrinho = new ArrayList<String>();
    }

    public boolean validar(String senha) {
        return this.senha.equals(senha);
    }

    public void adicionarAoCarrinho(String item) {
        this.carrinho.add(item);
    }
    public String removerDoCarrinho(String item) { // Bro pq vc escreveu essa função lmao nem precisou também
        for (int i = 0; i < this.carrinho.size(); i++) {
            if (this.carrinho.get(i).equals(item)) {
                String result = this.carrinho.get(i);
                this.carrinho.remove(i);
                return result;
            }
        }
        return null;
    }
    public String removerDoCarrinho(int index) {
        if (index >= 0 && index < this.carrinho.size()) {
            String result = this.carrinho.get(index);
            this.carrinho.remove(index);
            return result;
        }
        return null;
    }
    public ArrayList<String> getCarrinho() {
        return this.carrinho;
    }
}
