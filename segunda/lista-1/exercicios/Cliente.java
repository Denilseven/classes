public class Cliente {
    static int totalClientes = 0;

    private String nome;
    private String email;
    private String telefone;

    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return this.telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        Cliente.totalClientes++;
    }
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.telefone = "Não informado";
        Cliente.totalClientes++;
    }
    public Cliente(String nome) {
        this.nome = nome;
        this.email = "Não informado";
        this.telefone = "Não informado";
        Cliente.totalClientes++;
    }

    public void exibir() {
        System.out.println("CLIENTE:");
        System.out.println("  Nome:     " + this.nome);
        System.out.println("  Email:    " + this.email);
        System.out.println("  Telefone: " + this.telefone);
    }
}
