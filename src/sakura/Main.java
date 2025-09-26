package sakura;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Producto> productos = new ArrayList<>();
    static ArrayList<Compra> compras = new ArrayList<>();
    static Usuario usuarioLogueado = null;

    public static void main(String[] args) {
        int opcion;
        do {
            String menu = """
                --- Menú Principal ---
                1. Registrar usuario
                2. Iniciar sesión
                3. Alta de producto
                4. Listar productos
                5. Registrar compra
                0. Salir
                """;

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1 -> registrarUsuario();
                case 2 -> login();
                case 3 -> altaProducto();
                case 4 -> listarProductos();
                case 5 -> registrarCompra();
                case 0 -> JOptionPane.showMessageDialog(null, "Hasta luego!");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (opcion != 0);
    }

    static void registrarUsuario() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String email = JOptionPane.showInputDialog("Email:");
        String pass = JOptionPane.showInputDialog("Password:");
        String dir = JOptionPane.showInputDialog("Dirección envío:");
        String tel = JOptionPane.showInputDialog("Teléfono:");

        usuarios.add(new Cliente(usuarios.size()+1, nombre, email, pass, dir, tel));
        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
    }

    static void login() {
        String email = JOptionPane.showInputDialog("Email:");
        String pass = JOptionPane.showInputDialog("Password:");
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getPassword().equals(pass)) {
                usuarioLogueado = u;
                JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNombre());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
    }

    static void altaProducto() {
        if (usuarioLogueado == null) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión.");
            return;
        }
        String nombre = JOptionPane.showInputDialog("Nombre producto:");
        String desc = JOptionPane.showInputDialog("Descripción:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock:"));

        productos.add(new Producto(productos.size()+1, nombre, desc, precio, stock));
        JOptionPane.showMessageDialog(null, "Producto registrado con éxito.");
    }

    static void listarProductos() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Productos disponibles:\n");
        for (Producto p : productos) {
            sb.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    static void registrarCompra() {
        if (usuarioLogueado == null || !(usuarioLogueado instanceof Cliente)) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión como cliente.");
            return;
        }

        Compra compra = new Compra(compras.size()+1, (Cliente) usuarioLogueado);

        int id;
        do {
            listarProductos();
            id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de producto a comprar (0 para terminar):"));
            if (id > 0 && id <= productos.size()) {
                compra.agregarProducto(productos.get(id-1));
                JOptionPane.showMessageDialog(null, "Producto agregado.");
            } else if (id != 0) {
                JOptionPane.showMessageDialog(null, "ID inválido.");
            }
        } while (id != 0);

        compras.add(compra);
        JOptionPane.showMessageDialog(null, "Compra registrada: " + compra);
    }
}
