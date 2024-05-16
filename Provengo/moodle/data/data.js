/* @provengo summon selenium */
/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */
const assignment4 = 'Assignment 4';
const studentUsername = 'student';
const studentPassword = 'Teacher2024*';
const teacherUsername = 'admin';
const teacherPassword = 'Sandbox2024*';
const commentSubject ='Did we study DFG?';
const URL = 'http://localhost/';
const xpaths = {
    loginWindowButton: "//*[@id=\"usernavigation\"]/div/div/span/a",
    loginWindow:
        {
            usernameInput: '//*[@id=\"username\"]',
            passwordInput: '//*[@id=\"password\"]',
            loginButton: '//*[@id=\"loginbtn\"]',
        },
    teacherWindow:
        {
            editModeButton:'/html/body/div[2]/nav/div/div[2]/form/div/div/input',
            teacherCoursesButton:'/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a',
            teacherHomeButton: '//a[contains(text(), \'Home\')]',
            teacherClickOnCourse:'//a[text()=\'SQE course\']',
            teacherSoftwareQACourseButton:'/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a/span[3]/span[2]',
            forumEditOptionsButton:'/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div[4]/div/div/div/div/a/i',
            deleteOption: '/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div[4]/div/div/div/div/div/a[8]/span',
            deleteConfirmationPopup: '//button[text()=\'Delete\']'

        },
    studentWindow:
        {
            studentCoursesButton: '/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a',
            studentSoftwareQACourseButton: '/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a/span[3]/span[2]',
            studentForumButton: '/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div/div[2]/ul/li[2]/div/div[2]/div[2]/div/div/a',
            addDiscussionButton: '/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[1]/div/div[2]/a',
            subjectInbox : '//*[@id=\"id_subject\"]',
            insertButton :'/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[3]/span',
            emojiesButton: '/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[2]',
            oneHundredEmojieButton: '/html/body/div[5]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[20]/div',
            postToForumButton: '/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[4]/div[2]/div[1]/div/div[1]/span/input'
        }
}


