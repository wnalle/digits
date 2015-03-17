package controllers;

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
    return ok(Index.render("Welcome to the home page."));
  }

  /**
   * Returns a blank new contact page.
   * @return The New Contact.
   */
  public static Result newContact() {
    return ok(NewContact.render(Form.form(ContactFormData.class)));

  }

  /**
   * Pulls the information from the new contact form and prints it to the console.
   * @return A blank new contact form.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("Errors found.");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      System.out.println("Received POST: " + data.getFirstName() + " " + data.getLastName() + " " + data.getTelephone());
      return ok(NewContact.render(Form.form(ContactFormData.class)));
    }
  }
}
