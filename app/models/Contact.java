package models;

/**
 * Class to hold information for a single contact.
 */
public class Contact {
  /** The first name */
  private String firstName;
  /** The last name */
  private String lastName;
  /** The telephone number */
  private String telephone;

  /**
   * Initialize a new instance of a contact.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   */
  public Contact(String firstName, String lastName, String telephone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
  }

  /**
   * Returns the first name.
   * @return
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name.
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the telephone number.
   * @return
   */
  public String getTelephone() {
    return telephone;
  }
}
