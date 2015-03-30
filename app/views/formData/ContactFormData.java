package views.formData;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.ValidationError;

/**
 * Contact form class for the new contact page.
 */
public class ContactFormData {
  /** The first name. */
  public String firstName = "";
  /** The last name. */
  public String lastName = "";
  /** The phone number. */
  public String telephone = "";
  /** The id. */
  public long id = 0;
  /** The phone type */
  public String telephoneType = "";

  /**
   * Default constructor.
   */
  public ContactFormData() {
  }

  /**
   * Constructor given contact.
   * @param contact
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.id = contact.getId();
    this.telephoneType = contact.getTelephoneType();
  }

  /**
   * Constructor given individual fields.
   * @param firstName
   * @param lastName
   * @param telephone
   * @param id
   */
  public ContactFormData(String firstName, String lastName, String telephone, long id, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.id = id;
    this.telephoneType = telephoneType;
  }

  /**
   * Get the first name.
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the last name.
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the telephone number.
   * @return The telephone number.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Get the id.
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * Get the telephone type.
   * @return
   */
  public String getTelephoneType() {
    return telephoneType;
  }
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }

    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }

    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone number is required."));
    }

    if (telephone.length() != 12) {
      errors.add(new ValidationError("telephone", "Telephone number be in xxx-xxx-xxxx format."));
    }

    if (TelephoneTypes.isType(telephoneType) == false) {
      errors.add(new ValidationError("telephoneType", "Telephone type is required."));
    }

    return errors.isEmpty() ? null : errors;
  }

}
