package ec.com.birobid.dao;

import java.util.List;

import ec.com.birobid.dao.impl.IUserDAO;
import ec.com.birobid.model.Usuario;
import org.hibernate.SessionFactory;
 
/**
 *
 * Usuario DAO
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
 
public class UserDAO implements IUserDAO {
 
    private SessionFactory sessionFactory;
 
    /**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    /**
     * Set Hibernate Session Factory
     *
     * @param SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    /**
     * Add Usuario
     *
     * @param  Usuario user
     */
    @Override
    public void addUser(Usuario usuario) {
        getSessionFactory().getCurrentSession().save(usuario);
    }
 
    /**
     * Delete Usuario
     *
     * @param  Usuario user
     */
    @Override
    public void deleteUser(Usuario usuario) {
        getSessionFactory().getCurrentSession().delete(usuario);
    }
 
    /**
     * Update Usuario
     *
     * @param  Usuario user
     */
    @Override
    public void updateUser(Usuario usuario) {
        getSessionFactory().getCurrentSession().update(usuario);
    }
 
    /**
     * Get Usuario
     *
     * @param  int Usuario Id
     * @return Usuario
     */
    @Override
    public Usuario getUserById(int id) {
        @SuppressWarnings("rawtypes")
		List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from Usuario where id=?")
                                            .setParameter(0, id).list();
        return (Usuario)list.get(0);
    }
 
    /**
     * Get Usuario List
     *
     * @return List - Usuario list
     */
    @Override
    public List<Usuario> getUsers() {
        @SuppressWarnings("unchecked")
		List<Usuario> list = getSessionFactory().getCurrentSession().createQuery("from Usuario").list();
        return list;
    }
 
}