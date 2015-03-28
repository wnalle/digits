package tests;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;


import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.NewContactPage;


public class IntegrationTest {
  private final int testPort = 3333;

  /**
   * Test simple retrieval of the index page.
   */
  @Test
  public void testRetrieveIndexPage() {
    running(testServer(testPort, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      @Override
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        IndexPage indexPage = new IndexPage(browser.getDriver(), testPort);
        browser.goTo(indexPage);
        indexPage.isAt();
      }
    });
  }

  /**
   * Test submission of an new contact.
   */
  @Test
  public void testCreateNewContact() {
    running(testServer(testPort, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      @Override
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        NewContactPage ncp = new NewContactPage(browser.getDriver(), testPort);
        ncp.goTo(ncp);
        ncp.isAt();
        ncp.setFirst("will");
        ncp.setLast("nalle");
        ncp.setPhone("111-111-1111");
        ncp.submit();

        IndexPage ip = new IndexPage(browser.getDriver(), testPort);
        browser.goTo(ip);
        assertThat(browser.pageSource().contains("will"));
        assertThat(browser.pageSource().contains("nalle"));
        assertThat(browser.pageSource().contains("111-111-1111"));
      }
    });
  }

}