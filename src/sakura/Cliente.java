package sakura;

public class Cliente extends Usuario {
	
    private String direccionEnvio;
    private String telefono;

    public Cliente(int id, String nombre, String email, String password, String direccionEnvio, String telefono) {
        super(id, nombre, email, password);
        this.direccionEnvio = direccionEnvio;
        this.telefono = telefono;
    }
    
}