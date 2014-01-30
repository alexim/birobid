package ec.com.birobid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 
/**
 *
 * Usuario Entity
 *
 * @author Alexi Mendoza
 * @since 28 Dic 2013
 * @version 1.0.0
 *
 */
@Entity
@Table(name="Usuario")
public class Usuario {

    private int id;
    private String name;
    private String surname;
	
    /**
     * Get Usuario Id
     *
     * @return int - Usuario Id
     */
    @Id
    @Column(name="Id", unique = true, nullable = false)
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
    @Column(name="Name", unique = true, nullable = false)
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
    @Column(name="Surname", unique = true, nullable = false)
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
 
    @Override
    public String toString() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("id : ").append(getId());
        strBuff.append(", name : ").append(getName());
        strBuff.append(", surname : ").append(getSurname());
        return strBuff.toString();
    }
}