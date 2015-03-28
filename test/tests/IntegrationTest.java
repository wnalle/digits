package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.NewContactPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {

  private final int testPort = 3333;

  /**
   * Test that the index page can be retrieved.
   */
  @Test
  public void RetrieveIndexPage() {
    running(testServer(testPort, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      @Override
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        IndexPage indexPage = new IndexPage(browser.getDriver(), testPort, 0);
        browser.goTo(indexPage);
        indexPage.isAt();
      }
    });
  }

  @Test
  public void CreateNewContact() {
    running(testServer(testPort, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      @Override
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        NewContactPage ncPage = new NewContactPage(browser.getDriver(), testPort, 0);
        browser.goTo(ncPage);
        ncPage.isAt();
        ncPage.setFirst("will");
        ncPage.setLast("nalle");
        ncPage.setPhone("111-222-3333");
        ncPage.submit();

        IndexPage indexPage = new IndexPage(browser.getDriver(), testPort, 0);
        browser.goTo(indexPage);
        indexPage.isAt();
        assertThat(browser.pageSource().contains("<td>will</td> <td>nalle</td> <td>111-222-3333</td>"));
      }
    });
  }
}
