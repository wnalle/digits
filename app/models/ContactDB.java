package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formData.ContactFormData;

/**
 * Class for holding an in-memory list of all contacts created so far.
 */
public class ContactDB {
  /**
   * The list of contacts.
   */
  private static Map<Long, Contact> contacts = new HashMap<>();

  private static long currentId = 1;

  /**
   * Add a new contact to the internal list of contacts.
   * @param data The contact data.
   */
  public static void addContact(ContactFormData data) {

    long idVal = (data.getId() == 0) ? currentId++ : data.getId();
    contacts.put(idVal, new Contact(idVal, data.getFirstName(), data.getLastName(), data.getTelephone()));
  }

  /**
   * Deletes a contact given an id.
   * @param id
   */
  public static void deleteContact(long id) {
    contacts.remove(id);
  }

  /**
   * Returns a complete list of contacts that have been added so far.
   * @return
   */
  public static List<Contact> getContacts() {
    return new ArrayList<Contact>(contacts.values());
  }

  /**
   * Get contact information from an id.
   * @param id The id.
   * @return The contact info.
   */
  public static Contact getContact(long id) {
    return contacts.get(id);
  }
}
