package tests.pages;

import static org.fluentlenium.core.filter.FilterConstructor.withId;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements the page object pattern for the index page of this app.
 */
public class NewContactPage extends FluentPage {
  private String url;

  public NewContactPage(WebDriver webDriver, int port, int id) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/NewContact";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  public void setFirst(String first) {
    fill("#firstName").with(first);
  }

  public void setLast(String last) {
    fill("#lastName").with(last);
  }

  public void setPhone(String phone) {
    fill("#telephone").with(phone);
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("NewContact (digits)");
  }

  public void submit() {
    submit("#submit");
  }

  public boolean noErrorMessage() {
    return findFirst("div", withId("error-message")) == null;
  }

}
