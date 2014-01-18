package ec.com.birobid.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.birobid.dao.impl.ILoginDAO;
import ec.com.birobid.model.Login;
import ec.com.birobid.service.impl.ILoginService;

@Transactional(readOnly = true)
public class LoginService implements ILoginService {
	ILoginDAO loginDAO;
	
	 /**
     * Get User
     *
     * @param  int User Id
     */
    @Override
    public Login getByUser(String user) {
        return getUserDAO().getUserByUser(user);
    }
 
    /**
     * Get User List
     *
     */
    @Override
    public List<Login> getUsers() {
        return getUserDAO().getUsers();
    }
    
    /**
     * Get User DAO
     *
     * @return IUserDAO - User DAO
     */
    public ILoginDAO getUserDAO() {
        return loginDAO;
    }
    
    /**
     * Set User DAO
     *
     * @param IUserDAO - User DAO
     */
    public void setUserDAO(ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
}
