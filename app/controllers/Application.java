package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formData.ContactFormData;
import views.html.Index;
import views.html.NewContact;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns a blank new contact page.
   * @return The New Contact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render(formData));  }

  /**
   * Deletes a contact from the contact DB.
   * @param id
   * @return
   */
  public static Result deleteContact(long id) {
    System.out.println("Delete");
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }
  /**
   * Pulls the information from the new contact form and prints it to the console.
   * @return A blank new contact form.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println(formData.errors().values());
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      System.out.println("Received POST: " + data.getFirstName() + " " + data.getLastName() + " " + data.getTelephone());
      ContactDB.addContact(data);
      return ok(NewContact.render(Form.form(ContactFormData.class)));
    }
  }
}
