package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements the page object pattern for the index page of this application. 
 * See: https://github.com/FluentLenium/FluentLenium#what-is-fluentlenium-
 * And: http://ics-software-engineering.github.io/play-example-fluentlenium/
 */
public class IndexPage extends FluentPage {
  private String url;

  /**
   * Construct the page. Note that you must always pass a studentID.  
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
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