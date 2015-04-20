package models;

import java.util.List;

/**
 * Created by wgnalle on 4/19/2015.
 */
public class TelephoneType {
  /** The id. */
  private long id;
  /** The type of phone. */
  private String telephoneType;
  /** The list of contacts associated with this type */
  private List<Contact> contacts;

  public TelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
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
