package sakura;

public abstract class Usuario {
	
    protected int id;
    protected String nombre;
    protected String email;
    protected String password;

    public Usuario(int id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getNombre() { return nombre; }
    
}

