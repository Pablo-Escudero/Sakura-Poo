package sakura;

import java.util.ArrayList;

public class Compra {
    private int id;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private double total;

    public Compra(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        total += p.getPrecio();
    }

    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "Compra #" + id + " - Total: $" + total;
    }
}
