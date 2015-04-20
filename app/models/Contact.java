package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Class to hold information for a single contact.
 */
@Entity
public class Contact extends play.db.ebean.Model {
  /** The first name. */
  private String firstName;
  /** The last name. */
  private String lastName;
  /** The telephone number. */
  private String telephone;
  /** The id. */
  @Id
  private long id;
  /** The telephone type. */
  @ManyToOne(cascade = CascadeType.PERSIST)
  private TelephoneType telephoneType;
  /** The list of diet types. */
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<DietType> dietTypes;

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTelephoneType(TelephoneType telephoneType) {
    this.telephoneType = telephoneType;
  }

  public void setDietTypes(List<DietType> dietTypes) {
    this.dietTypes = dietTypes;
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }

  /**
   * Initialize a new instance of a contact.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType Type of telephone.
   * @param dietTypes The list of diet types.
   *
   */
  public Contact(String firstName, String lastName, String telephone, TelephoneType telephoneType, List<DietType> dietTypes) {

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
