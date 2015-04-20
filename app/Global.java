import models.ContactDB;
import models.DietType;
import models.TelephoneType;
import play.Application;
import play.GlobalSettings;
import views.formData.ContactFormData;

/**
 * Initalize system with four contacts.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);
/*
    ContactDB.addContact(new ContactFormData("First", "Contact1", "111-111-1111", 1, "Home"));
    ContactDB.addContact(new ContactFormData("Second", "Contact2", "222-222-2222", 2, "Cell"));
    ContactDB.addContact(new ContactFormData("Third", "Contact3", "333-333-3333", 3, "Fax"));
    ContactDB.addContact(new ContactFormData("Forth", "Contact4", "444-444-4444", 4, "Work"));
*/

    ContactDB.addTelephoneType(new TelephoneType("Mobile"));
    ContactDB.addTelephoneType(new TelephoneType("Home"));
    ContactDB.addTelephoneType(new TelephoneType("Work"));
    ContactDB.addDietType(new DietType("Chicken"));
    ContactDB.addDietType(new DietType("Fish"));
    ContactDB.addDietType(new DietType("Beef"));
    ContactDB.addDietType(new DietType("Dairy"));
    ContactDB.addDietType(new DietType("Gluten"));
  }
}
