import models.ContactDB;
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
  }
}
