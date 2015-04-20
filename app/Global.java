import java.util.ArrayList;
import java.util.List;
import models.Contact;
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
*/
    if (TelephoneType.find().all().isEmpty()) {
      ContactDB.addTelephoneType(new TelephoneType("Mobile"));
      ContactDB.addTelephoneType(new TelephoneType("Home"));
      ContactDB.addTelephoneType(new TelephoneType("Work"));
    }

    if (DietType.find().all().isEmpty()) {
      ContactDB.addDietType(new DietType("Chicken"));
      ContactDB.addDietType(new DietType("Fish"));
      ContactDB.addDietType(new DietType("Beef"));
      ContactDB.addDietType(new DietType("Dairy"));
      ContactDB.addDietType(new DietType("Gluten"));
    }

    if (Contact.find().all().isEmpty()) {
      List<DietType> diets = new ArrayList<>();
      TelephoneType ty = TelephoneType.find().where().eq("telephoneType", "Home").findUnique();
      ContactDB.addContact(new ContactFormData("First", "Contact1", "111-111-1111", ty, diets));
      ContactDB.addContact(new ContactFormData("Second", "Contact2", "222-222-2222", ty, diets));
      ContactDB.addContact(new ContactFormData("Third", "Contact3", "333-333-3333", ty, diets));
      ContactDB.addContact(new ContactFormData("Forth", "Contact4", "444-444-4444", ty, diets));

    }
  }
}
