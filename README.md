# ITBootcampQAFinalProject  
ITBootcampQAFinalProject is used for testing the functionality of the website

Target URL: https://petstore.octoperf.com/  
Target Browser: Chrome  
Browser version: 81.0.4044.122

**Used libraries:**
* TestNG automation testing framework
* Selenium portable framework for testing web applications
* Apache POI library for manipulating various file formats

**The following website functionalities are tested:**
* Enter store
* Links validation (left menu, top menu, image menu, sign in)
* User registration
* User login
* Add to cart
* Cart validation (all added items are correct)
* Cookies 

## The project has 3 packages
* pages
* tests
* utils 
 
All packages are located in the `src` folder

## Package `pages` contains
* APageTemplate
* BHomePage
* CPetStoreMenuPage
* DSignInPage
* ERegistrationPage
* FStoreItemPage
* GCartPage

## Package `tests` contains
* ATestTemplate
* BEnterStoreTest	
* CPetStoreMenuTest	
* DSignInTest 	
* ERegistrationPageTest	
* GCartTes

## Package `utils` contains
* ExcelUtils
