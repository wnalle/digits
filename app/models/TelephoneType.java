package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by wgnalle on 4/19/2015.
 */
@Entity
public class TelephoneType extends play.db.ebean.Model {
  /** The id. */
  @Id
  private long id;
  /** The type of phone. */
  private String telephoneType;
  /** The list of contacts associated with this type. */
  @OneToMany(mappedBy = "telephoneType", cascade = CascadeType.PERSIST)
  private List<Contact> contacts;

  /**
   * Constructor that takes telephone type as string.
   * @param telephoneType The string telephone type.
   */
  public TelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, TelephoneType> find() {
    return new Finder<Long, TelephoneType>(Long.class, TelephoneType.class);
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
   * @param telephoneType The telephone type.
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
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
  public String getTelephoneType() {
    return telephoneType;
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
