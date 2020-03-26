package FunctionLayer;

/**
 * Formålet til denne klasse er at kunne generere en bruger. Der er lavet getters
 * & setters for de ulike atributer i klassen slik at de nås udenfra.
 *
 */
public class User {

    public User( String email, String password, String role, int saldo ) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.saldo = saldo;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private int saldo;

    public User (int id, String email, String password, String role, int saldo ) {
        this.id = id ;
        this.email = email;
        this.password = password;
        this.role = role;
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

}
