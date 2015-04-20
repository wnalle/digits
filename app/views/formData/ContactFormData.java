package views.formData;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import models.DietType;
import models.TelephoneType;
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
  /** The phone type. */
  public TelephoneType telephoneType;
  /** The list of diet types. */
  public List<DietType> dietTypes = new ArrayList<>();

  /**
   * Default constructor.
   */
  public ContactFormData() {
  }

  /**
   * Constructor given contact.
   * @param contact The contact object.
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.id = contact.getId();
    this.telephoneType = contact.getTelephoneType();
    this.dietTypes = contact.getDietTypes();
  }

  /**
   * Constructor given individual fields.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The type of telephone.
   */
  public ContactFormData(String firstName, String lastName, String telephone, TelephoneType telephoneType, List<DietType> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.id = id;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
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
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Get the telephone type.
   * @return The telephone type.
   */
  public TelephoneType getTelephoneType() {
    return telephoneType;
  }

  /**
   * Gets the list of diet types.
   * @return The diet types.
   */
  public List<DietType> getDietTypes() {
    return dietTypes;
  }

  /**
   * Validates the new contact form.
   * @return The list of validation errors. Null if no errors found.
   */
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

    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Telephone type is required."));
    }

    return errors.isEmpty() ? null : errors;
  }

}
