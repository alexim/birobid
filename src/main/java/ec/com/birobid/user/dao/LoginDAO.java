package ec.com.birobid.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;

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
     * Get User
     *
     * @param  int User Id
     * @return User
     */
    @Override
    public Login getUserByUser(String user) {
        @SuppressWarnings("rawtypes")
		List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from Login where User=? and Password =?")
                                            .setParameter(0, user).list();
        return (Login)list.get(0);
    }
 
    /**
     * Get User List
     *
     * @return List - User list
     */
    @Override
    public List<Login> getUsers() {
        @SuppressWarnings("unchecked")
		List<Login> list = getSessionFactory().getCurrentSession().createQuery("from Login").list();
        return list;
    }
}
