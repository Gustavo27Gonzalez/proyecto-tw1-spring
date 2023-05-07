package ar.edu.unlam.tallerweb1.delivery;

public class DatosLogin {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public DatosLogin() {
	}

	public DatosLogin(String email, String password) {
		setEmail(email);
		setPassword(password);
	}

	public DatosLogin(String email) {
		setEmail(email);
	}
    
    
}
