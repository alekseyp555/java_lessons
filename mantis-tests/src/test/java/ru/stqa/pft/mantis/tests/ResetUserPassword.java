package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetUserPassword extends TestBase {

  @BeforeMethod
  public void startMaiServer() {
    app.mail().start();
  }

  @Test
  public void testResetUserPassword() throws IOException, MessagingException {
    String administrator = "administrator";
    int adminid = app.db().users().stream().filter((p) -> p.getUsername().equals(administrator)).iterator().next().getId();
    UserData account = app.db().users().stream().filter((p) -> p.getId() != adminid).iterator().next();
    String username = account.getUsername();
    String email = account.getEmail();
    String newPassword = "resetpassword";
    app.session().login(administrator, "root");
    app.goTo().manageUser();
    app.user().reset(username);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String conformationLink = findConfirmationLink(mailMessages, email);
    app.user().confirmade(conformationLink, newPassword);
    assertTrue(app.newSession().login(username, newPassword));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findAny().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}