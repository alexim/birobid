package ec.com.birobid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 
/**
 *
 * User Entity
 *
 * @author Alexi Mendoza
 * @since 28 Dic 2013
 * @version 1.0.0
 *
 */
@Entity
@Table(name="User")
public class User {

    private int id;
    private String name;
    private String surname;
	
    /**
     * Get User Id
     *
     * @return int - User Id
     */
    @Id
    @Column(name="Id", unique = true, nullable = false)
    public int getId() {
        return id;
    }
 
    /**
     * Set User Id
     *
     * @param int - User Id
     */
    public void setId(int id) {
        this.id = id;
    }
 
    /**
     * Get User Name
     *
     * @return String - User Name
     */
    @Column(name="Name", unique = true, nullable = false)
    public String getName() {
        return name;
    }
 
    /**
     * Set User Name
     *
     * @param String - User Name
     */
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     * Get User Surname
     *
     * @return String - User Surname
     */
    @Column(name="Surname", unique = true, nullable = false)
    public String getSurname() {
        return surname;
    }
 
    /**
     * Set User Surname
     *
     * @param String - User Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }   
 
    @Override
    public String toString() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("id : ").append(getId());
        strBuff.append(", name : ").append(getName());
        strBuff.append(", surname : ").append(getSurname());
        return strBuff.toString();
    }
}