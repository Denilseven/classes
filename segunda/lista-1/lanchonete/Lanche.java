package lanchonete;

public class Lanche {
    private String nome;
    private int preco;

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }

    public void setPreco(int preco) { if (precoValido(preco)) this.preco = preco; }
    public int getPreco() { return this.preco; }

    public Lanche(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void exibir() {
        System.out.println(this.nome + " --- R$ " + this.preco);
    }

    public static boolean precoValido(int preco) {
        return (preco >= 0);
    }
}
