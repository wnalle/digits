package tests.pages;

import static org.fluentlenium.core.filter.FilterConstructor.withId;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements the page object pattern for the index page of this app.
 */
public class IndexPage extends FluentPage {
  private String url;

  public IndexPage(WebDriver webDriver, int port, int id) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Home (digits)");
  }
}
