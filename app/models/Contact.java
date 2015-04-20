package models;

import java.util.List;

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
  private TelephoneType telephoneType;
  /** The list of diet types. */
  private List<DietType> dietTypes;

  /**
   * Initialize a new instance of a contact.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType Type of telephone.
   * @param id The id.
   * @param dietTypes The list of diet types.
   *
   */
  public Contact(long id, String firstName, String lastName, String telephone, TelephoneType telephoneType, List<DietType> dietTypes) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.id = id;
    this.dietTypes = dietTypes;
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
   * @return the telephone number.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Returns the telephone type.
   * @return the telephone type.
   */
  public TelephoneType getTelephoneType() {
    return telephoneType;
  }

  /** Returns the id.
   *  @return The id
   */
  public long getId() {
    return id;
  }

  /**
   * Returns the list of diet types.
   * @return Diet types.
   */
  public List<DietType> getDietTypes() {
    return dietTypes;
  }
}
