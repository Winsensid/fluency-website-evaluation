Fluency Website Evaluation
This repository contains a testing framework to evaluate the Fluency website. The framework includes automated checks for link functionality, page load performance, and general website information. It was built using Selenium and Java.

Features
Link Verification: Checks that all links on the website return a valid HTTP status code.

Page Load Performance: Measures the page load time to ensure the site loads within acceptable performance standards.

Website Information: Gathers basic information about the website, including the number of links and page title.

Requirements
Java 11 or higher

Selenium  WebDriver

TestNG

FireFoxDriver or another WebDriver of your choice

Setup
Clone the repository:

bash
Copy
Edit
git clone https://github.com/Winsensid/fluency-website-evaluation.git
Install required dependencies

bash 
Copy
Edit
mvn install
Run the tests using your preferred IDE or from the command line with TestNG:

bash
Copy
Edit
mvn test
Tests
Link Verification: Validates if all links are working.

Page Load Performance: Ensures the page loads quickly (within the acceptable limit).

Website Information: Prints the number of links and the title of the page.


