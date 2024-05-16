/* @provengo summon selenium */
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
  session.click(xpaths.teacherWindow.teacherHomeButton)
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
