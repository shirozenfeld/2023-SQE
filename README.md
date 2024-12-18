
# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [Moodle](https://github.com/BGU-SE-Courses/2023-mbt-52-06).

Moodle is a free and open-source learning management system, used for blended learning, distance education, flipped classroom and other online learning projects in schools, universities, workplaces and other sectors. 
![Demo](PROVENGO-gif.gif)
[Download the demo video](PROVENGO-run.mp4)

## Installation
To use this project, follow these steps:
1. **Clone the repository** to your local lost using Git.
2. **Navigate to the project directory**.
3. **Install Provengo** according to the [Provengo Installation Guide] (https://docs.provengo.tech/ProvengoCli/0.9.5/installation.html), follow the provided steps for installation and validation.
4. **Make sure the Selenium Server is working**, see [Selenium/README.md] in the project directory for more details.
5. **Install Graphviz** to generate the graphs’ PDF from [Graphviz.org] (https://graphviz.org/). After installing, run the command line dot -V to ensure it is set.
6. **Install Moodle on your local host** by downloading the latest version suitable for the Operation System you are running, from [Moodle Installation] https://download.moodle.org/releases/latest/. Afterwards, extract the zip file to your Desktop and run it according to the steps in the README.txt file.
7. No further installastions needed in order to run Cucumber but the given files in this project.

That's it! If you encounter any issues during the installation process, please [contact us](shirmor98@gmail.com) for assistance.


## What we tested
We tested the Forum module, which enables both students and the teacher to have discussions and post comments, but is managed by the tacher only. We chose to test the following user stories: 
*User story 1:* The student comments on a forum

*Preconditions:* There is a course which is managed by a teacher, and there is a student which is signed up to the course. The course contains a forum.

*Expected outcome:* The comment is posted to the forum and is visible to everyone.

*User story 2:* The teacher deletes the forum.

*Preconditions:* There is a course which is managed by the teacher, and contains a forum.

*Expected outcome:* The forum is deleted successfully.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 
