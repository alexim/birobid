package ec.com.birobid.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
 



import org.springframework.dao.DataAccessException;
 



import ec.com.birobid.model.Usuario;
import ec.com.birobid.service.impl.IUserService;

/**
 *
 * Usuario Managed Bean
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@ManagedBean(name="userMB")
@RequestScoped
public class UserManagedBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
 
    //Spring Usuario Service is injected...
    @ManagedProperty(value="#{UserService}")
    IUserService userService;
 
    List<Usuario> userList;
 
    private int id;
    private String name;
    private String surname;
 
    /**
     * Add Usuario
     *
     * @return String - Response Message
     */
    public String addUser() {
        try {
            Usuario usuario = new Usuario();
            usuario.setId(getId());
            usuario.setName(getName());
            usuario.setSurname(getSurname());
            getUserService().addUser(usuario);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
 
        return ERROR;
    }
 
    /**
     * Reset Fields
     *
     */
    public void reset() {
        this.setId(0);
        this.setName("");
        this.setSurname("");
    }
 
    /**
     * Get Usuario List
     *
     * @return List - Usuario List
     */
    public List<Usuario> getUserList() {
        userList = new ArrayList<Usuario>();
        userList.addAll(getUserService().getUsers());
        return userList;
    }
 
    /**
     * Get Usuario Service
     *
     * @return IUserService - Usuario Service
     */
    public IUserService getUserService() {
        return userService;
    }
 
    /**
     * Set Usuario Service
     *
     * @param IUserService - Usuario Service
     */
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
 
    /**
     * Set Usuario List
     *
     * @param List - Usuario List
     */
    public void setUserList(List<Usuario> userList) {
        this.userList = userList;
    }
 
    /**
     * Get Usuario Id
     *
     * @return int - Usuario Id
     */
    public int getId() {
        return id;
    }
 
    /**
     * Set Usuario Id
     *
     * @param int - Usuario Id
     */
    public void setId(int id) {
        this.id = id;
    }
 
    /**
     * Get Usuario Name
     *
     * @return String - Usuario Name
     */
    public String getName() {
        return name;
    }
 
    /**
     * Set Usuario Name
     *
     * @param String - Usuario Name
     */
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     * Get Usuario Surname
     *
     * @return String - Usuario Surname
     */
    public String getSurname() {
        return surname;
    }
 
    /**
     * Set Usuario Surname
     *
     * @param String - Usuario Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
 
}