package models;

/**
 * Class to hold information for a single contact.
 */
public class Contact {
  /** The first name. */
  private String firstName;
  /** The last name. */
  private String lastName;
  /** The telephone number. */
  private String telephone;
  /** The id. */
  private long id;
  /** The telephone type. */
  private String telephoneType;

  /**
   * Initialize a new instance of a contact.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType Type of telephone.
   * @param id The id.
   *
   */
  public Contact(long id, String firstName, String lastName, String telephone, String telephoneType) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.id = id;
  }

  /**
   * Returns the first name.
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name.
   * @return the last name.
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

  /**
   * Returns the telephone type.
   * @return
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /** Returns the id.
   *  @return The id
   */
  public long getId() {
    return id;
  }
}
