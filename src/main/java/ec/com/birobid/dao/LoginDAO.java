package ec.com.birobid.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import ec.com.birobid.dao.impl.ILoginDAO;
import ec.com.birobid.model.Login;

public class LoginDAO implements ILoginDAO{
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
     * Get Usuario
     *
     * @param  int Usuario Id
     * @return Usuario
     */
    @Override
    public Login getUserByUser(String user) {
        @SuppressWarnings("rawtypes")
		List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from Login where Usuario=? and Password =?")
                                            .setParameter(0, user).list();
        return (Login)list.get(0);
    }
 
    /**
     * Get Usuario List
     *
     * @return List - Usuario list
     */
    @Override
    public List<Login> getUsers() {
        @SuppressWarnings("unchecked")
		List<Login> list = getSessionFactory().getCurrentSession().createQuery("from Login").list();
        return list;
    }
}
