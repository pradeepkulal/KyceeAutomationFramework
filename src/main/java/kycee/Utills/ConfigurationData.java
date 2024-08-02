package kycee.Utills;

import kycee.Base.BaseClass;

public class ConfigurationData extends BaseClass{

	
	

	public static String BA_subhead_text = "Introduction 1";
	public static String domainText = "DOMAINS";
	public static String domain_Header_Text = "Domains We Serve";
	public static String business_Casses_Button_text ="BUSINESS CASES";
	public static String business_Casses_Header_Text= "Business Cases";
	public static String challenges_Button_text ="CHALLENGES";
	public static String challenges_Header_Text= "Challenges";
	public static String About_Us_Tab_Button_text ="ABOUT US";
	public static String Why_KYCEE_text = "WHY KYCEE";
	public static String expectedBeforeTextColor ="#8A90A2";
	public static String expectedAfterTextColor = "#292930";
	public static String expectedTitleList[] = {"About KYCee","Policies","Help & Support","Instagram post"};
	public static String expectedWhyKYCEEButtonText[] = {"Technology","Design","Innovation"};
	public static String expectedYellowColor ="#FBD95E";
	public static String expectedBusinessCasesCardText[] = {"Bulk Processing","Customer Onboarding","Account Recovery","Legal Signatures","Buying & Selling","Decision Making"};
	public static String expectedlightBlueColor ="#82CEFD";
	public static String expectedDarkBlueColor = "#5956E9";
	public static String expectedChallangesButtonText[] = {"Expectations","User Experience","Regulatory","Manual Processes","Data Quality","Evolving Fraud"};
	public static String expectedAIButtonText = "AI'S Magic";
	public static String About_Us_Button_text ="About Us";
	public static String expectedFirstNameValidationMessage = "Please enter a valid first name.";
	public static String expectedLastNameValidationMessage = "Please enter a valid last name.";
	public static String expectedEmailValidationMessage = "Kindly enter a valid email address.";
	public static String expectedCompanyNameValidationMessage = "Please enter a valid company name.";
	public static String expectedDuplicateEmailErrorNotification = "Email address is already in use by another user. Please enter a different email address.";
	public static String expectedSuccessfullAccountNotification = "Account created successfully.";
	public static String expectedDuplicatePhoneNumberErrorNotification = "Phone number already in use.";
	public static String expectedDuplicateCompanyNameErrorNotification = "The company name is already in use by another account. Please choose a different company name.";
	public static String expectedBeforeCardColor = "#FFFFFF";
	public static String expectedAfterCardColor = "#687587";
	//------------------------------------------------------Sign in Page Data --------------------------------//
	public String ExpectedSignInPageHeader = "Sign In";
	//------------------------------------------------------Sign Up Page Data --------------------------------//
	public String ExpectedSignUpPageHeader = "Sign Up";
		
	
	//------------------------------------------------------Forgot Password Page Data --------------------------------//
	public static String forgotPasswordHeaderText = "Forgot Password";
	public String ExpectedResetPasswordPageHeader = "Reset Password";
	
	//------------------------------------------------------DashBoard Page Data --------------------------------//
	public String expectedDashBoardHeader ="Dashboard";
	
	//------------------------------------------------------My Profile Page Data --------------------------------//
	public static String myProfilePageHeaderText = "My Profile";
	
	//------------------------------------------------------Users Page Data --------------------------------//
	public static  String ExpectedUserPageHeader = "Users";
	public String expectedAddUserHeader = "Add User";
	
	//------------------------------------------------------Generate Password Page Data --------------------------------//
	public String ExpectedGeneratePasswordPageHeader = "Generate Password";
	public String expectedPageExpiredText = "Uh oh. This link has expired.";
	
	//------------------------------------------------------Activate Account Page Data --------------------------------//
	public static String expectedExpiredOTPToastMessage = "The OTP you entered has expired. Please request a new OTP to continue.";
	public static String expectedInvalidOTPToastMessage = "The OTP you entered is invalid.";
	public static  String ExpectedSuccessfillActivationOfCustomerNotification = "Account activation successful.";
	
	
	
	/*--------------------------Error validation messages--------------------*/
	public static String expectedEmptyEmailFieldErrorMsg = notificationDataXL.getCellData(constant.validationMessageExcelSheet, constant.validationMessageColName, 6);
	public String expectedInvalidEmailFieldErrorMsg = notificationDataXL.getCellData(constant.validationMessageExcelSheet, constant.validationMessageColName, 7);
	public String expectedEmptyPasswordFieldErrorMsg = notificationDataXL.getCellData(constant.validationMessageExcelSheet, constant.validationMessageColName, 8);
	public String expectedEmptyConfirmPasswordFieldErrorMsg =notificationDataXL.getCellData(constant.validationMessageExcelSheet, constant.validationMessageColName, 11);
	public String expectedMismatchPasswordAndConfirmPasswordFieldErrorMsg = notificationDataXL.getCellData(constant.validationMessageExcelSheet, constant.validationMessageColName, 12);
	/*--------------------------Notitifications messages --------------------*/
	public String expectedNotRegisteredNotifyMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 116);
	public String expectedSuccessfulResetPasswordNotifyMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 117);
	public String expectedRequestNewLinkWithin5MinNotifyMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 117);
	public String expectedAddUserSuccessNotificationMessage = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 66);
	public String ExpectedDuplicateEmailIDErrorNotificationMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 2);
	public String ExpectedDuplicatePhoneNumberErrorNotificationMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 3);
	public String ExpectedDuplicateCompanyNameErrorNotificationMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 6);
	public String ExpectedDuplicateCIN_NumberErrorNotificationMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 4);
	public String ExpectedDuplicateGSTIN_NumberErrorNotificationMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 5);
	public String expectedOldPasswordErrorNotification = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 24);
	public String expectedMaximumAttemptsResetPasswordNotifyMsg = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 27);

	public static  String expectedSuccessfulResetPassswordNotification =  notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 25);

	public static String expectedNewAccountCreationSuccessNotificationMessage = notificationDataXL.getCellData(constant.notificationMessageExcelSheet, constant.notificationMessageColName, 7);;
	
	
	
	

}
