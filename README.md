Website Health and SEO Tests
This repository contains automated tests to help improve the health and SEO of the Passes website. The tests include checks for broken links, page load performance, and SEO-related elements like page titles and meta descriptions. It uses Selenium WebDriver for browser automation, TestNG for running the tests, and Java as the programming language.

Tools & Technologies Used
Selenium WebDriver (version 4.27.0) - For web automation and interacting with web pages.
TestNG (version 7.5) - For structuring and running tests.
Java (version 21.0.1) - The programming language used to write the tests.
Maven - For project management and dependency management.
How to Set Up and Run the Tests
Prerequisites
Make sure you have the following installed on your system:

Java (version 21.0.1 or compatible)
Maven (for managing dependencies and building the project)
IDE like IntelliJ IDEA or Eclipse (optional, but helpful)
Selenium WebDriver and TestNG dependencies are managed using Maven, so once you have Maven set up, it will automatically download the required dependencies.
Steps to Set Up
Clone the repository:

Open your terminal (or Git Bash) and run:
bash
Copy
git clone https://github.com/yourusername/yourrepo.git
cd yourrepo
Install dependencies:

Maven will automatically download all necessary dependencies for Selenium and TestNG when you build the project. Run the following command to install them:
bash
Copy
mvn install
Run the tests:

To run all the tests in the project, use the following command:
bash
Copy
mvn test
This will execute all the tests specified in the test classes and show the results in the terminal or your IDE.

Test Classes
BrokenLinkTest: This test class checks for any broken links on the Passes website.
PageLoadTest: This test measures the time it takes for pages to load and provides performance insights.
SEOTests: This test validates key SEO elements like page titles, meta descriptions, and Open Graph tags.
Test Results
After running the tests, the results will be displayed in the terminal or output window in your IDE.
If any broken links are found, they will be listed.
For page load tests, you'll see the time taken to load pages.
The SEO test will check for missing or incorrect meta descriptions and page titles.
License
This project is licensed under the MIT License.