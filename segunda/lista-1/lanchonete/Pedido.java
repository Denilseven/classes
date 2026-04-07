package lanchonete;
import java.util.ArrayList;

public class Pedido {
    public ArrayList<Lanche> lanches;

    public Pedido() {
        this.lanches = new ArrayList<Lanche>();
    }

    public void adicionarLanche(Lanche lanche) {
        lanches.add(lanche);
    }
}
