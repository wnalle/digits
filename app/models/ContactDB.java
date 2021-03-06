package models;

import java.util.ArrayList;
import java.util.List;
import views.formData.ContactFormData;
import views.formData.DietTypes;

/**
 * Class for holding an in-memory list of all contacts created so far.
 */
public class ContactDB {

  /**
   * Link the string of a telephone type to the associated instance.
   * @param telephoneType The instance of the telephone type.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneType.save();
  }

  /**
   * Link the string of a diet type to the associated instance.
   * @param dietType The instance of the telephone type.
   */
  public static void addDietType(DietType dietType) {
    dietType.save();
  }

  /**
   * Returns the instance of the given telephone type.
   * @param typeString the string name of the telephone type.
   * @return
   */
  public static TelephoneType getTelephoneType(String typeString) {
    TelephoneType telephoneType = TelephoneType.find().where().eq("telephoneType", typeString).findUnique();
    if (telephoneType == null) {
      throw new RuntimeException();
    }

    return telephoneType;
  }

  /**
   * Returns the instance of the given diet type.
   * @param typeString the string name of the telephone type.
   * @return the diet type.
   */
  public static DietType getDietType(String typeString) {
    DietType dietType = DietType.find().where().eq("dietType", typeString).findUnique();
    if (dietType == null) {
      throw new RuntimeException();
    }
    return dietType;
  }

  /**
   * Add a new contact to the internal list of contacts.
   * @param data The contact data.
   */
  public static void addContact(ContactFormData data) {
    TelephoneType telephoneType = getTelephoneType(data.getTelephoneType().getTelephoneType());
    List<DietType> dietTypes = new ArrayList<>();
    for (DietType dt : data.getDietTypes()) {
      dietTypes.add(dt);
    }

    Contact contact;
    if (data.id == 0) {
      contact = new Contact(data.firstName, data.lastName, data.telephone, data.telephoneType, data.dietTypes);
    }
    else {
      contact = Contact.find().byId(data.id);
      contact.setFirstName(data.firstName);
      contact.setLastName(data.lastName);
      contact.setTelephone(data.telephone);
      contact.setTelephoneType(data.telephoneType);
      contact.setDietTypes(data.dietTypes);
    }


    // Make relationships bi-directional.
    telephoneType.addContact(contact);
    for (DietType dt : dietTypes) {
      dt.addContact(contact);
    }

    contact.save();
  }

  /**
   * Deletes a contact given an id.
   * @param id the id.
   */
  public static void deleteContact(long id) {
    Contact contact = Contact.find().byId(id);
    TelephoneType telephoneType = TelephoneType.find().byId(contact.getTelephoneType().getId());
    contact.deleteManyToManyAssociations("dietTypes");
    contact.delete();
  }

  /**
   * Returns a complete list of contacts that have been added so far.
   * @return list of contacts.
   */
  public static List<Contact> getContacts() {
    return Contact.find().orderBy("id").findList();
  }

  /**
   * Get contact information from an id.
   * @param id The id.
   * @return The contact info.
   */
  public static Contact getContact(long id) {
    Contact contact = Contact.find().byId(id);

    if (contact == null) {
      throw new RuntimeException();
    }

    return contact;

  }
}
