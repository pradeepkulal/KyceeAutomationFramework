package kycee.Utills;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import kycee.Base.BaseClass;

public class Constants extends BaseClass {

	
	public static String QA_URL = "https://qa.kycee.in";
	public static String DEV_URL = "https://dev.kycee.in";
	public static String PROD_URL = "https://kycee.in";


	public static String URL = "https://qa.kycee.in";
	/*--------------------------Mail Functionality Configuaration--------------------*/	
	public static String mailosaurAPIKey = "56Kmwh3l9UyaZhd7mAwH31M4mtFuZwZz";
	public static String serverID = "bsgdulpk"; 
	public static String serverDomain = "@bsgdulpk.mailosaur.net";
	
	/*--------------------------Excel Reader Functionality Configuaration--------------------*/	
	public static String errorMessageExcelPath = ".//TestData//Notifications Message on KYCee v2.0-Updated.xlsx";
	public static String validationMessageExcelSheet = "Validation Error Message";
	public static String validationMessageColName = "Updated Messages";
	public static String notificationMessageExcelSheet = "Notification Message";
	public static String notificationMessageColName = "New Notification Message";
	public static String credentialsSheet = "sheet1";
	public static String emailCol = "Email";
	public static String passwordCol = "Password";
	public static String LoginTestDataPath = ".//src//main//resources//LoginTestData.xlsx";
	public static String invalidPNGFIle = "C://Users//Intuitiveapps//eclipse-workspace//Kyce//src//main//resources//LoginTestData.xlsx";
	

	/*--------------------------Abstract Loactors --------------------*/

	public static String loader = "//div[@class='loader']";
	public static String notificationIcon = "//div[contains(@class,'Toastify__toast-icon')]";
	public static String ToastMsg = "//div[contains(@class,'Toastify__toast-container')]";
	public static String thumbLogoNavigationIcon = "//div[@class='side-logo']//div";
	public static String KYCEE_LogoNavigationIcon = "//div[@class='side-logo']";
	public static String dashboardNavigationIcon = "//li[@id='dashboard']";
	public static String verificationsNavigationIcon = "//li[@id='verifications']";
	public static String usersNavigationIcon = "//li[@id='users']";
	public static String walletNavigationIcon = "//li[@id='wallet']";
	public static String accountsNavigationIcon = "//li[@id='accounts']";
	public static String transactionsNavigationIcon = "//li[@id='transactions']";
	public static String ordersNavigationIcon = "//li[@id='orders']";
	public static String testimonialsNavigationIcon = "//li[@id='testimonials']";
	public static String kyceeLogoNavigationIcon = "//div[@class='logobar']";
	public static String pageHeader ="//h4[contains(@class,'sc-bcXHqe kYRFBC')]";
	public static String firstName = "firstName";
	public static String lastName = "lastName";
	public static String email = "email";
	public static String phoneNumber = "phoneNumber";
	public static String formSubmitBtn = "//button[@type='submit']";
	public static String firstRowInList ="(//div[@role='row'])[2]";
	public static String uploadXpath = "//input[@type='file']";
	

	/* -------------------------------------- Locators of Home Page -------------------------------*/


	public static String signUp = "//a[@class='tp-btn-sm active me-3 btn-headers']";

	public static String introductionText= "//p/strong";

	public static String domainsTab= "//a[text()='DOMAINS']";

	public static String businessCassesTab= "//a[text()='BUSINESS CASES']";

	public static String challangesTab= "//a[text()='CHALLENGES']";

	public static String whyKYCEETab= "//a[text()='WHY KYCEE']";

	public static String aboutUsTab= "//a[text()='ABOUT US']";

	public static String domainSectionTitle= "(//h2[@class='tp-title'])[1]";

	public static String BusinessCasesSectionTitle= "(//h2[@class='tp-title'])[2]";

	public static String challengesSectionTitle= "(//h2[@class='tp-title'])[3]";

	public static String aboutUsSection= "aboutus";

	public static String whyKYCEESection= "//h2[contains(@class,'tp-title why-title')]";

	public static String footerTitle = "//h3[@class='footer-title']";

	public static String challengeSectionButtons = "//div[@class='nav-item']//a";

	public static String whyKYCEESectionButtons = "//div[@id='nav-tab']//button";

	public static String footerSection = "//div[contains(@class,'tp-footer-area')]";

	public static String footerSectionPageLink = "//div[@class='container']//li/a";

	public static String businessCasesCards = "tp-sv-content-tow";

	public static String businessCasesCardsTitleText = "//div[@class='business-box']//h3";

	public static String AIsMagicButton = "//a[@class='tp-btn-sm']";

	public static String AboutUsButton = "button.about-btn";

	public static String signInButton = "//a[text()='Sign In']";

	public static String signUpButton = "//a[contains(@class,'me-3 btn-headers')]";

	// --------------------------------------- SignUp Page Constants ---------------------------------- //

	public static String signUpPageHeader = "//h3[text()='Sign Up']";


	public static String password = "password";

	public static String confirmPassword = "confirmPassword";

	public static String yesCheckBox = "//input[@value='yes']";

	public static String noCheckBox = "//input[@value='no']";

	public static String companyName = "companyName";

	public static String cinNumber = "cinNumber";

	public static String gstin = "gstin";

	public static String submitBtn = "//input[@type='submit']";

	public static String SignInPageBtn = "/login";



	public static String validationMessage = "//div[@class='tooltip-customize']";

	public static String passwordErrorIcon = "(//div[@class='right-cnt']//div[1]//div[1]//section[1]//*[name()='svg'])[1]";

	public static String confirmPasswordErrorIcon = "(//div[@class='right-sec']//div[2]//div[1]//section[1]//*[name()='svg'])[1]";

	public static String phoneNumberErrorIcon = "(//div[@class='right-cnt']//div[1]//div[1]//section[1]//*[name()='svg'])[1]";

	public static String emailErrorIcon = "//div[@class='right-sec']//div[2]//div[1]//div//*[name()='svg'][1]";

	public static String firstNameErrorIcon = "//div[@class='right-cnt']//div[1]//div[1]//div//*[name()='svg'][1]";

	public static String lastNameErrorIcon =  "//div[@class='right-cnt']//div[1]//div[2]//div//*[name()='svg'][1]";

	public static String companyNameErrorIcon = "//div[@class='right-cnt']//div[5]//div[1]//div[1]//*[name()='svg'][1]";

	public static String passwordVisibilityIcon = "//div[@class='right-cnt']//div[3]//div[1]//div[1]//*[name()='svg'][2]";

	public static String confirmPasswordVisibilityIcon = "//div[@class='right-cnt']//div[3]//div[1]//div[1]//*[name()='svg'][2]";



	// --------------------------------------- Login Page Constants ---------------------------------- //
	public static String signInPageHeader = "//h3[text()='Sign In']";

	public static String  userEmailInput ="//input[@type='email']";

	public static String userPasswordInput = "//input[@type='password']"; 

	public static String siginInBtn ="//input[@type='submit']";

	public static String forgotPasswordLink = "//a[contains(@href,'forgotPassword')]";

	public static String signUpPageLink = "//a[contains(@href,'signup')]";
	
	// --------------------------------------- Forgot Password Page Constants ---------------------------------- //
	public String forgotPasswordPageHeader = "//h3[normalize-space()='Forgot Password']";
	public String emailFieldForgotPassword = "//input[@class='form-control']";
	public String signUpLink = "//a[@href='/signup']";
	public String signInLink = "//a[@href='/login']";
	// --------------------------------------- Generate Password Page Constants ---------------------------------- //
	public String GeneratePasswordPageHeader ="//h3";
	public String pageExpiredText = "//h1";


	
	
	// --------------------------------------- Activate Account Page Constants ---------------------------------- //
	
	public static String activateAccountPopUpHeader = "//span[text()='Activate your account']";
	public static String activateAccountBtn = "//button[text()='Activate Account']";
	public static String logoutBtn = "//button[normalize-space()='Logout']";
	public static  String OTPField = "//input[@placeholder='-']";
	public static  String resendOTP = "//button[normalize-space()='Resend OTP']";
	public static String timeRemaining = "//span[@class='Resend']" ;
	public static String OTPIn_3 = "(//input[@class='otp-input-field form-control '])[3]";  
	public static String OTPIn_4 = "(//input[@class='otp-input-field form-control '])[4]";
	public static String OTPIn_5 = "(//input[@class='otp-input-field form-control '])[5]";
	public static String OTPIn_6 = "(//input[@class='otp-input-field form-control '])[6]";
	public static String resentOTP_Btn = "//button[text()='Resend OTP']";
	public static String invalidOTPNotification = "//div[text()='The OTP you entered is invalid.']";

	// --------------------------------------- Dashboard Page Constants ---------------------------------- //
	public String tourPreviousBtn = "//button[text()='Prev']";
	public String tourNextBtn = "//button[text()='Next']";
	public String tourDoneBtn = "//button[text()='Done']";
	public String tourTitle = "//h2";
	
	public static String usersCard = "//div[text()='Users']";

	public static String VerificationsCard = "//div[text()='Verifications']/parent::div/parent::div";
	
	public static String CreditsAvailableCard = "//div[text()='Credits Available']/parent::div/parent::div";
	
	public static String selfCreditsCard = "//div[text()='Self Credits']";

	public static String companyCreditsCard = "//div[text()='Company Credits']";

	public static String usersCount = "//div[text()='Users']//following-sibling::div[@class='card-text']";

	public static String VerificationsCount = "a[class='dashboard-link'] section:nth-child(1)";

	public static String selfCreditsCount = "//div[text()='Self Credits']//following-sibling::div[@class='card-text']";

	public static String companyCreditsCount = "//div[text()='Company Credits']//following-sibling::div[@class='card-text']//section[1]";

	public static String successVerificationCount = "//span[@class='text-success']";
	
	public static String notSuccessFullVerificationCount = "//span[@class='text-danger']";
	
	public static String dropdown_profile ="//button[@id='dropdown-profile']";
	
	public static String My_Profile ="//a[text()=' My Profile']";
	
	public static String  Change_Password ="//a[text()=' Change Password']";
	
	public static String  Review  ="//a[text()=' Review']";
	
	public static String  Logout ="//a[text()=' Logout']";
	
	public static String  Settings ="//a[text()=' Settings']";
	
	public static String verifyYourIdentityButton ="//button[text()='Verify Your Identity']";
	
	// --------------------------------------- My Profile Page Constants ---------------------------------- //
	public String profilePhoto = "//div[@class='profile-edit-cion']";
	public String profilePhotoEditIcon = "//label[@for='profile-file']//*[name()='svg']";
	public String profileImgCancelbtn = "//button[text()='Cancel']";
	
	public static String profileImgSubmitbtn = "//button[text()='Submit']";
	public static String userFullName ="//h3[@class='user-profile-name']";
	public static String userType ="//p[@class='text-capitalize']";
	public static String myProfilePageHeader ="//h4[@class='sc-bcXHqe kYRFBC pb-0']";
	public static String personalInfoEditButton = "(//*[name()='svg'][@class='edit-profile'])[1]";
	public static String userFirstName = "//label[text()='First Name']//following-sibling::p";
	public static String userLastName ="//label[text()='Last Name']//following-sibling::p";
	public static String userPhoneNumber ="//label[text()='Phone Number']//following-sibling::p";
	public static String userEmail ="//label[text()='Email']//following-sibling::p";
	
	public static String accountInfoEditButton = "(//*[name()='svg'][@class='edit-profile'])[2]";
	public static String UserCompanyName = "//label[text()='Company Name']//following-sibling::p";
	public static String userCIN_Number ="//label[text()='CIN Number']//following-sibling::p";
	public static String userGSTIN_Number ="//label[text()='GSTIN Number']//following-sibling::p";
	public static String userArea ="//label[text()='Area / House / Street']//following-sibling::p";
	public static String userCity ="//label[text()='City']//following-sibling::p";
	public static String userState ="//label[text()='State']//following-sibling::p";
	public static String userPinCode ="//label[text()='Pin Code']//following-sibling::p";
	
	public static String VerifyYourIdentityButton = "//button[@class='sc-dkrFOg idVDld btn ']";
	
	
	public static String editfirstName = "first_name";
	public static String editlastName = "last_name";
	public static String editemail = "email";
	public static String editphoneNumber = "phone_number";
	public String emailActivationPopUpHeader = "//div[@class='modal-title h4']";
	public static String emailActivationPopUpSubmitbtn = "(//button[@class='sc-dkrFOg idVDld btn '])[2]";
	
	// --------------------------------------- ChangePassword Page Constants ---------------------------------- //
	public String changePasswordPageHeader = "//h4";
	
	public static String oldPasswordField = "//input[@name='password']";
	public static String newPasswordField = "//input[@name='newPassword']"; 
	public static String confirmNewPasswordField = "//input[@name='confirmPassword']";
	public static String toggleEyeIcon = "icon-group-end";
	
	// --------------------------------------- Review Page Constants ---------------------------------- //
	public static String ReviewPageHeader = "//h4";
	public static String reviewTitleInput ="//input[@name='title']";
	public static String reviewDescriptionInput ="//textarea[@name='description']";
	public static String ratingstar1 ="//div[@class='review-container']/div/div[1]//*[name()='svg'][1]";
	public static String ratingstar2="//div[@class='review-container']/div/div[1]//*[name()='svg'][2]";
	public static String ratingstar3 ="//div[@class='review-container']/div/div[1]//*[name()='svg'][3]";
	public static String ratingstar4 ="//div[@class='review-container']/div/div[1]//*[name()='svg'][4]";
	public static String ratingstar5 ="//div[@class='review-container']/div/div[1]//*[name()='svg'][5]";
	
	public String reviewTitle = "(//p[@class='quote'])[1]";
	public String reviewDescription = "(//p[@class='quote'])[2]";
	public String reviewRating1 = "(//div[@class='star-rating']//i)[1]";
	public String reviewRating2 = "(//div[@class='star-rating']//i)[2]";
	public String reviewRating3 = "(//div[@class='star-rating']//i)[3]";
	public String reviewRating4 = "(//div[@class='star-rating']//i)[4]";
	public String reviewRating5 = "(//div[@class='star-rating']//i)[5]";
	
	public String reviewUpdateCancelButton = "//button[@class='sc-iBYQkv jEswLR btn ']";
	public String editReviewIcon = "//div[@class='quote-container']//div[1]";
	public String editReviewPageHeader ="//h4";
	public String editReviewBackIcon = "(//*[name()='svg'])[11]";
	
	
	// --------------------------------------- Wallet Page Constants ---------------------------------- //
	public String walletTourTitle = "//h3";
	public String noDataText = "//p[@class='nodataAvailable']";
	public String onlineOrders = "//li[normalize-space()='Online Orders']";
	public String offlineOrdersTab = "//li[normalize-space()='Offline Orders']";
	public String transactionsTab = "//li[normalize-space()='Transactions']";
	public String addCreditsBtn = "//div[@class='add-redit-transaction']//button[@type='button'][normalize-space()='Add Credits']";
	public String addCreditsHeader = "//div[@class='modal-title h4']";
	public String quantityField = "(//input[@class='form-control'])[2]";
	public String creiditsPrice = "(//td[@class='text-end'])[1]";
	public String creiditsAmount = "(//td[@class='text-end'])[2]";
	public String subTotal = "div[class='purchase-form'] div:nth-child(1) label:nth-child(2)";
	public String gst = "div[class='purchase-form'] div:nth-child(2) label:nth-child(2)";
	public String totalAmount = "div[class='purchase-form'] div:nth-child(3) label:nth-child(2)";
	public String checkoutViaUPIBtn = "//div[@class='modal-footer']//button[@type='button']";
	public String paymentHeader = "//h4[normalize-space()='Payment']"; 
	public String QRCode = "(//div[@class='upi-section']//div)[1]";
	public String UTRNumberField = "//input";
	
	
	// --------------------------------------- Verifications Page Constants ---------------------------------- //
	public static String VerificationPageHeader ="//h4[@class='sc-bcXHqe kYRFBC']";
	
	
	
	// --------------------------------------- Users Page Constants ---------------------------------- //
	public static String addUsersBtn ="//button[contains(@class,'add-user')]";
	
	public static String  userTypeDrop = "#react-select-2-placeholder";
	public static String adminTypeOption = "#react-select-2-option-0";
	public static String userTypeOption = "#react-select-2-option-1";
	public static String allotVerificationInput = "verification";
	
	
}
