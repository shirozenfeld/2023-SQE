/* @provengo summon selenium */
/* @provengo summon ctrl */

/**
 * This story does the following:
 *  1) opens the Chrome browser on Moodle page
 *  2) logs in as a student in the system
 *  3) enters to Software QA course
 *  4) posts a comment on the course's forum called 'Assignment 4' (comment consists of topic and an emoji)
 */

bthread('studentPostsACommentOnForum',function () {

  let s1 = new SeleniumSession('studentMoodleSession').start(URL)
  sync({request:Event('End(findLoginPageAndLogin)')},findLoginPageAndLogin(s1,studentUsername,studentPassword))
  sync({request:Event('End(goToSoftwareQACourse)')},goToSoftwareQACourse(s1))
  sync({request:Event('Start(enterForumAndPostComment)'),waitFor:Event('Start(deleteForum)')},enterForumAndPostComment(s1,commentSubject))
});

/**
 * This story does the following:
 *  1) opens the Chrome browser on Moodle page
 *  2) logs in as an admin in the system, which is a teacher
 *  3) goes on Edit Mode and enters the Software QA course
 *  4) deletes the forum called 'Assignment 4'
 */
bthread('teacherDeletesForum', function () {
  let s2 = new SeleniumSession('teacherMoodleSession').start(URL)
  sync({request:Event('End(findLoginPageAndLogin)')},findLoginPageAndLogin(s2,teacherUsername,teacherPassword))
  sync({request:Event('End(turnOnEditModeAndGoToCourse)')},turnOnEditModeAndGoToCourse(s2))
  sync({request:Event('End(deleteForum)')},deleteForum(s2))

});

/**
 * This story assures that once the teacher has deleted the forum, the student can't enter it and post a comment
 */
bthread('teacherDeletesForumWhileStudentIsBannedFromForum', function () {
  sync({waitFor:Event('End(deleteForum)')})
  sync({block:Event('Start(enterForumAndPostComment)')})
});
