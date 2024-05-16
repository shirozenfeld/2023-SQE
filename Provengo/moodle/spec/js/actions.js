function findLoginPageAndLogin(session, username,password) {
  sync({request: Event('Start(findLoginPageAndLogin)')})
  session.click(xpaths.loginWindowButton)
  session.writeText(xpaths.loginWindow.usernameInput,username)
  session.writeText(xpaths.loginWindow.passwordInput,password)
  session.click(xpaths.loginWindow.loginButton)
  sync({request: Event('End(findLoginPageAndLogin)')})
}

function goToSoftwareQACourse(session) {
  sync({request: Event('Start(goToSoftwareQACourse)')})
  session.click(xpaths.teacherWindow.teacherHomeButton)
  session.click(xpaths.teacherWindow.teacherClickOnCourse)
  sync({request: Event('End(goToSoftwareQACourse)')})
}

function enterForumAndPostComment(session,commentSubject) {
  sync({request: Event('Start(enterForumAndPostComment)')})
  session.click(xpaths.studentWindow.studentForumButton)
  session.click(xpaths.studentWindow.addDiscussionButton)
  session.writeText(xpaths.studentWindow.subjectInbox,commentSubject)
  //session.writeText(xpaths.studentWindow.messageInbox,"menumessageformat")
  session.click(xpaths.studentWindow.insertButton)
  session.click(xpaths.studentWindow.emojiesButton)
  session.click(xpaths.studentWindow.oneHundredEmojieButton)
  session.click(xpaths.studentWindow.postToForumButton)
  sync({request: Event('End(enterForumAndPostComment)')})
}

function turnOnEditModeAndGoToCourse(session)
{
  sync({request: Event('Start(turnOnEditModeAndGoToCourses)')})
  session.click(xpaths.teacherWindow.editModeButton)
  //session.click(xpaths.teacherWindow.teacherCoursesButton)
  session.click(xpaths.teacherWindow.teacherHomeButton)
  //session.click(xpaths.teacherWindow.teacherSoftwareQACourseButton)
  session.click(xpaths.teacherWindow.teacherClickOnCourse)
  sync({request: Event('End(turnOnEditModeAndGoToCourses)')})
}

function deleteForum(session)
{
  sync({request: Event('Start(deleteForum)')})
  session.click(xpaths.teacherWindow.forumEditOptionsButton)
  session.click(xpaths.teacherWindow.deleteOption)
  session.click(xpaths.teacherWindow.deleteConfirmationPopup)
  sync({request: Event('End(deleteForum)')})
}

function addNewForum(session)
{
  sync({request: Event('Start(addNewForum)')})
  session.click(xpaths.teacherWindow.addActivityButton)
  session.click(xpaths.teacherWindow.forumButton)
  session.writeText(xpaths.teacherWindow.forumNameBox,assignment4)
  session.scrollToElement(xpaths.teacherWindow.saveAndReturnToCourse)
  session.click(xpaths.teacherWindow.saveAndReturnToCourse)
  sync({request: Event('End(addNewForum)')})
}


function assertErrorMessage(session)
{
  sync({request: Event('Start(assertErrorMessage)')})
  session.waitForVisibility("//div[contains(text(),'Activity deletion in progress...')]\"")
  sync({request: Event('End(assertErrorMessage)')})
}


function assertComment(session)
{
  sync({request: Event('Start(assertComment)')})
  session.waitForVisibility("//div[contains(text(),'Did we study DFG?')]\"")
  sync({request: Event('End(assertComment)')})
}
