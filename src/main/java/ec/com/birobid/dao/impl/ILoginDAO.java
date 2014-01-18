package ec.com.birobid.dao.impl;

import java.util.List;

import ec.com.birobid.model.Login;

public interface ILoginDAO {
	
    public Login getUserByUser(String user);
    
    public List<Login> getUsers();
}
