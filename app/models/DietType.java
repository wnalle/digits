package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Created by wgnalle on 4/19/2015.
 */
@Entity
public class DietType extends play.db.ebean.Model {
  /** The id. */
  @Id
  private long id;
  /** The type of phone. */
  private String dietType;
  /** The list of contacts associated with this type */
  @ManyToMany(mappedBy = "dietTypes", cascade = CascadeType.PERSIST)
  private List<Contact> contacts;

  public DietType(String dietType) {
    this.dietType = dietType;
  }

  public void setDietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, DietType> find() {
    return new Finder<Long, DietType>(Long.class, DietType.class);
  }

  /**
   * Set the id.
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Set the telephone type.
   * @param dietType The telephone type.
   */
  public void setTelephoneType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Set the list of contacts.
   * @param contacts the list of contacts.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Get the id.
   * @return the id.
   */
  public long getId() {
    return id;
  }

  /**
   * Get the telephone type.
   * @return the telephone type.
   */
  public String getDietType() {
    return dietType;
  }

  /**
   * Get the contacts.
   * @return The contacts.
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  public void addContact(Contact contact) {
    contacts.add(contact);
  }
}
