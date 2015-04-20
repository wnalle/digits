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

  /** The map of telephone types. */
  private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();

  /** The map of diet types */
  private static Map<String, DietType> dietTypes = new HashMap<>();

  /** The current ID */
  private static long currentId = 1;

  /**
   * Link the string of a telephone type to the associated instance.
   * @param telephoneType The instance of the telephone type.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneTypes.put(telephoneType.getTelephoneType(), telephoneType);
  }

  /**
   * Link the string of a diet type to the associated instance.
   * @param dietType The instance of the telephone type.
   */
  public static void addDietType(DietType dietType) {
    dietTypes.put(dietType.getDietType(), dietType);
  }

  /**
   * Returns the instance of the given telephone type.
   * @param telephoneType the string name of the telephone type.
   * @return
   */
  public static TelephoneType getTelephoneType(String telephoneType) {
    if (telephoneTypes.containsKey(telephoneType))
      return telephoneTypes.get(telephoneType);
    throw new RuntimeException();
  }

  /**
   * Returns the instance of the given diet type.
   * @param dietType the string name of the telephone type.
   * @return
   */
  public static DietType getDietType(String dietType) {
    if (dietTypes.containsKey(dietType))
      return dietTypes.get(dietType);
    throw new RuntimeException();
  }

  /**
   * Add a new contact to the internal list of contacts.
   * @param data The contact data.
   */
  public static void addContact(ContactFormData data) {

    long idVal = (data.getId() == 0) ? currentId++ : data.getId();
    contacts.put(idVal, new Contact(idVal, data.getFirstName(), data.getLastName(),
        data.getTelephone(), data.getTelephoneType(), data.getDietTypes()));
  }

  /**
   * Deletes a contact given an id.
   * @param id the id.
   */
  public static void deleteContact(long id) {
    contacts.remove(id);
  }

  /**
   * Returns a complete list of contacts that have been added so far.
   * @return list of contacts.
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
