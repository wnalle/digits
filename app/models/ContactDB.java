package models;

import java.util.ArrayList;
import java.util.List;
import views.formData.ContactFormData;

/**
 * Class for holding an in-memory list of all contacts created so far.
 */
public class ContactDB {
  /**
   * The list of contacts.
   */
  private static List<Contact> contacts = new ArrayList<>();

  /**
   * Add a new contact to the internal list of contacts.
   * @param data The contact data.
   */
  public static void addContact(ContactFormData data) {
    contacts.add(new Contact(data.getFirstName(), data.getLastName(), data.getTelephone()));
  }

  /**
   * Returns a complete list of contacts that have been added so far.
   * @return
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
}
