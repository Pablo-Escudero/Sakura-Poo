package sakura;

//Producto
public class Producto {
 private int id;
 private String nombre;
 private String descripcion;
 private double precio;
 private int stock;

 public Producto(int id, String nombre, String descripcion, double precio, int stock) {
     this.id = id;
     this.nombre = nombre;
     this.descripcion = descripcion;
     this.precio = precio;
     this.stock = stock;
 }

 @Override
 public String toString() {
     return id + " - " + nombre + " ($" + precio + ")";
 }
 
 public int getId() { return id; }
 public String getNombre() { return nombre; }
 public String getDescripcion() { return descripcion; }
 public double getPrecio() { return precio; }
 public int getStock() { return stock; }
 
 
}