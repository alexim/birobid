package ec.com.birobid.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.birobid.dao.impl.IUserDAO;
import ec.com.birobid.model.Usuario;
import ec.com.birobid.service.impl.IUserService;
 
/**
 *
 * Usuario Service
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Transactional(readOnly = true)
public class UserService implements IUserService {
 
    // UserDAO is injected...
    IUserDAO userDAO;
 
    /**
     * Add Usuario
     *
     * @param  Usuario user
     */
    @Transactional(readOnly = false)
    @Override
    public void addUser(Usuario usuario) {
        getUserDAO().addUser(usuario);
    }
 
    /**
     * Delete Usuario
     *
     * @param  Usuario user
     */
    @Transactional(readOnly = false)
    @Override
    public void deleteUser(Usuario usuario) {
        getUserDAO().deleteUser(usuario);
    }
 
    /**
     * Update Usuario
     *
     * @param  Usuario user
     */
    @Transactional(readOnly = false)
    @Override
    public void updateUser(Usuario usuario) {
        getUserDAO().updateUser(usuario);
    }
 
    /**
     * Get Usuario
     *
     * @param  int Usuario Id
     */
    @Override
    public Usuario getUserById(int id) {
        return getUserDAO().getUserById(id);
    }
 
    /**
     * Get Usuario List
     *
     */
    @Override
    public List<Usuario> getUsers() {
        return getUserDAO().getUsers();
    }
 
    /**
     * Get Usuario DAO
     *
     * @return IUserDAO - Usuario DAO
     */
    public IUserDAO getUserDAO() {
        return userDAO;
    }
 
    /**
     * Set Usuario DAO
     *
     * @param IUserDAO - Usuario DAO
     */
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
}