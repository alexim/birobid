package ec.com.birobid.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import ec.com.birobid.model.Login;
import ec.com.birobid.model.Login.Estado;

/**
 *
 * @author Alexi
 */
@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean implements Serializable{  

    /**
	 * 
	 */
	private static final long serialVersionUID = -7883301876834795924L;
	
	/**
	 * 
	 	Spring Login Service is injected...
		@ManagedProperty(value="#{LoginService}")
	    ILoginService loginService;
	 * 
	 * */
	
    List<Login> loginList;
    
    private String user;
	private String password;
	private Estado estado = Estado.ACTIVO;

    public String getUser() {  
        return user;  
    }  

    public void setUser(String user) {  
        this.user = user;  
    }  

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getPassword() {  
        return password;  
    }  

    public void setPassword(String password) {  
        this.password = password;  
    }  

    public void login() {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  

        if((user != null ||  user != "") && (password != null || password !="")) {  
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inciando sesión", user);  
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al iniciar sesión", "Credenciales Incorrectas");  
        }  

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
}