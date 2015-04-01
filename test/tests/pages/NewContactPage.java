package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements the page object pattern for the index page of this application. 
 * See: https://github.com/FluentLenium/FluentLenium#what-is-fluentlenium-
 * And: http://ics-software-engineering.github.io/play-example-fluentlenium/
 */
public class NewContactPage extends FluentPage {
  private String url;

  /**
   * Construct the page. Note that you must always pass a studentID.  
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/NewContact";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("NewContact (digits)");
  }

  /**
   * Sets the first name.
   * @param name The first name.
   */
  public void setFirst(String name) {
    fill("#firstName").with(name);
  }

  /**
   * Sets the last name.
   * @param password The last name.
   */
  public void setLast(String password) {
    fill("#lastName").with(password);
  }

  /**
   * Sets the phone number.
   * @param password The phone number.
   */
  public void setPhone(String password) {
    fill("#telephone").with(password);
  }

  /**
   * Submits the form.
   */
  public void submit() {
    submit("#submit");
  }
}