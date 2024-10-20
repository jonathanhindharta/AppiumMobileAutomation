Appium Mobile Automation By Jonathan Hindharta
This is an example project of Mobile Automation using Appium
https://github.com/jonathanhindharta/AppiumMobileAutomation

Prerequisites Software to run this project :
1. Java JDK
2. Maven
3. Eclipse for Java Developers
4. Android cmdLine-Tools, Android BuildTools, Android Emulator (Or Real Devices), Android Platform and Platform-tools
5. Appium

How To run The Project:
1. After successful clone and open the project in Eclipse, go to menu Help > Install New Software
2. Click Add, and Then Fill Name With TestNG, Fill Location With https://testng.org/testng-eclipse-update-site
3. Select All The List, and Then Next until it finished to install
4. After TestNG Installed and eclipse restarted make sure TestNG show in the list in menu Help > Install New Software after click "what is already installed in"
5. Before Run The Test Make Sure Appium is Running (appium --allow-cors)
5. For Scenario Verify Price (high to low) and (low to high) filter are working as expected. Run PriceFilterTest.java as TestNG Test
6. For Scenario Verify Checkout flow till success with valid user information along with necessary
verifications. Run CheckOutTest.java as TestNG Test
7. After Finished To Run The File, there will be some report file generated in test-output folder (in html and xml format)

