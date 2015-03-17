package test;

import models.ContactDB;
import org.junit.Test;
import play.data.Form;
import play.twirl.api.Content;


import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;


/**
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 */
public class ApplicationTest {

  /**
   * Tests that the Index template renders correctly.
   */
  @Test
  public void renderTemplate() {
    Content html = views.html.Index.render(ContactDB.getContacts());
    assertThat(contentType(html)).isEqualTo("text/html");
    assertThat(contentAsString(html)).contains("Home");
  }


}
