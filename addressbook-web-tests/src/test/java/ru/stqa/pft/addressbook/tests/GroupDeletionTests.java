package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
public class GroupDeletionTests extends TestBase{

  @Test
<<<<<<< HEAD
  public void testGroupDeletion()   {

=======
  public void testGroupDeletion() throws Exception {
>>>>>>> parent of 4dade17... Половина работы по выделению помощников для создания нового контакта
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}