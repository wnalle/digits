package views.formData;

import java.util.ArrayList;
import java.util.List;
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

    return errors.isEmpty() ? null : errors;
  }

}
