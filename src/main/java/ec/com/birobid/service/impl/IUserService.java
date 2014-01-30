package ec.com.birobid.service.impl;

import java.util.List;

import ec.com.birobid.model.Usuario;
 
/**
 *
 * Usuario Service Interface
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface IUserService {
 
    /**
     * Add Usuario
     *
     * @param  Usuario user
     */
    public void addUser(Usuario usuario);
 
    /**
     * Update Usuario
     *
     * @param  Usuario user
     */
    public void updateUser(Usuario usuario);
 
    /**
     * Delete Usuario
     *
     * @param  Usuario user
     */
    public void deleteUser(Usuario usuario);
 
    /**
     * Get Usuario
     *
     * @param  int Usuario Id
     */
    public Usuario getUserById(int id);
 
    /**
     * Get Usuario List
     *
     * @return List - Usuario list
     */
    public List<Usuario> getUsers();
}