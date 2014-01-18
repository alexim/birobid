package ec.com.birobid.service.impl;

import java.util.List;

import ec.com.birobid.model.Login;

public interface ILoginService {
	/**
     * Get User
     *
     * @param  int User Id
     */
    public Login getByUser(String user);
 
    /**
     * Get User List
     *
     * @return List - User list
     */
    public List<Login> getUsers();
}
