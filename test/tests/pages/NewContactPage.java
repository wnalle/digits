package tests.pages;

import static org.fluentlenium.core.filter.FilterConstructor.withId;
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

  public void setFirst(String name) {
    fill("#firstName").with(name);
  }

  public void setLast(String password) {
    fill("#lastName").with(password);
  }

  public void setPhone(String password) {
    fill("#telephone").with(password);
  }

  public void submit() {
    submit("#submit");
  }
}