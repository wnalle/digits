package controllers;

import play.mvc.Controller;
import play.mvc.Result;
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
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The NewContact.
   */
  public static Result newContact() {
    return ok(NewContact.render("Welcome to the New Contact page."));

  }

}
