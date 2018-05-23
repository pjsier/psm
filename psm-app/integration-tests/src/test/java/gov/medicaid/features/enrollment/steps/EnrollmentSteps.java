package gov.medicaid.features.enrollment.steps;

import gov.medicaid.features.enrollment.ui.EnrollmentDetailsPage;
import gov.medicaid.features.enrollment.ui.EnrollmentPage;
import gov.medicaid.features.enrollment.ui.IndividualInfoPage;
import gov.medicaid.features.enrollment.ui.IndividualSummaryPage;
import gov.medicaid.features.enrollment.ui.LicenseInfoPage;
import gov.medicaid.features.enrollment.ui.OrganizationInfoPage;
import gov.medicaid.features.enrollment.ui.OrganizationSummaryPage;
import gov.medicaid.features.enrollment.ui.OwnershipInfoPage;
import gov.medicaid.features.enrollment.ui.PersonalInfoPage;
import gov.medicaid.features.enrollment.ui.PracticeInfoPage;
import gov.medicaid.features.enrollment.ui.ProviderStatementPage;
import gov.medicaid.features.enrollment.ui.SelectProviderTypePage;
import gov.medicaid.features.general.ui.DashboardPage;
import gov.medicaid.features.general.ui.LoginPage;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unused")
public class EnrollmentSteps {
    private static final String FIRST_NAME = "FirstName";
    private static final String MIDDLE_NAME = "MiddleName";
    private static final String LAST_NAME = "LastName";
    private static final String NPI = "0000000006";
    private static final String SSN = "000-00-0000";
    private static final LocalDate DATE_OF_BIRTH =
            LocalDate.of(1970, 1, 1);
    private static final String EMAIL = "p1@example.com";

    private static String licenseType;
    private static final String LICENSE_NUMBER = "1";
    private static final LocalDate LICENSE_ISSUE_DATE =
            LocalDate.now().minusWeeks(30);
    private static final LocalDate BEFORE_LICENSE_ISSUE_DATE =
            LICENSE_ISSUE_DATE.minusDays(1);
    private static final LocalDate LICENSE_RENEWAL_DATE =
            LocalDate.now().plusWeeks(30);
    private static final String LICENSE_ISSUING_STATE_FULL = "Minnesota";
    private static final String LICENSE_ISSUING_STATE_ABBR = "MN";

    private static final String PRIVATE_PRACTICE_NAME = "My Private Practice";
    private static final String PRACTICE_GROUP_NPI = "1111111112";
    private static final LocalDate PRACTICE_EFFECTIVE_DATE =
            LocalDate.of(2000, 1, 1);
    private static final String PRACTICE_ADDRESS_1 = "1234 Main St";
    private static final String PRACTICE_ADDRESS_2 = "Suite 56";
    private static final String PRACTICE_CITY = "Springfield";
    private static final String PRACTICE_STATE_FULL = "Illinois";
    private static final String PRACTICE_STATE_ABBR = "IL";
    private static final String PRACTICE_ZIP = "12345-6789";
    private static final String PRACTICE_PHONE = "444-555-6666";
    private static final String PRACTICE_FEIN = "12-3456789";
    private static final String PRACTICE_STATE_TAX_ID = "1234567";
    private static final String PRACTICE_YEAR_END = "12/31";

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private EnrollmentPage enrollmentPage;
    private SelectProviderTypePage selectProviderTypePage;
    private OrganizationInfoPage organizationInfoPage;
    private IndividualInfoPage individualInfoPage;
    private PersonalInfoPage personalInfoPage;
    private LicenseInfoPage licenseInfoPage;
    private PracticeInfoPage practiceInfoPage;
    private OwnershipInfoPage ownershipInfoPage;
    private IndividualSummaryPage individualSummaryPage;
    private OrganizationSummaryPage organizationSummaryPage;
    private ProviderStatementPage providerStatementPage;
    private EnrollmentDetailsPage enrollmentDetailsPage;

    private SimpleDateFormat formFieldDateFormat = new SimpleDateFormat("MMddyyyy");

    public void createEnrollment() {
        dashboardPage.clickOnNewEnrollment();
    }

    public void selectOrganizationalProviderType() {
        selectProviderTypePage.selectProviderType("Head Start");
        licenseType = "Head Start Agency Certification";
        selectProviderTypePage.clickNext();
    }

    public void selectIndividualProviderType() {
        selectProviderTypePage.selectProviderType("Speech Language Pathologist");
        licenseType = "Speech Language Pathologist";
        selectProviderTypePage.clickNext();
    }

    @Step
    void enterIndividualPersonalInfo() {
        personalInfoPage.enterFirstName(FIRST_NAME);
        personalInfoPage.enterMiddleName(MIDDLE_NAME);
        personalInfoPage.enterLastName(LAST_NAME);
        personalInfoPage.enterNPI(NPI);
        personalInfoPage.enterSSN(SSN);
        personalInfoPage.enterDOB(DATE_OF_BIRTH);
        personalInfoPage.enterEmail(EMAIL);
        personalInfoPage.checkSameAsAbove();
    }

    @Step
    void advanceFromIndividualPersonalInfoToLicenseInfo() {
        personalInfoPage.clickNext();
        assertThat(personalInfoPage.getTitle()).contains("License Information");
    }

    @Step
    void advanceFromOrganizationInfoToLicenseInfo() {
        organizationInfoPage.clickNext();
        assertThat(organizationInfoPage.getTitle()).contains("Facility Credentials");
    }

    @Step
    void clickAddLicense() {
        licenseInfoPage.addLicense();
    }

    public void enterOrganizationInfo() {
        organizationInfoPage.setNPI("1234567893");
        organizationInfoPage.setEffectiveDate(generateEffectiveDate());
        organizationInfoPage.setDoingBusinessAs("Test DBA");
        organizationInfoPage.setLegalName("Test Name");
        organizationInfoPage.setAddr1("123 Test St");
        organizationInfoPage.setCity("TestCity");
        organizationInfoPage.selectState("Texas");
        organizationInfoPage.setZipcode("77706");
        organizationInfoPage.selectCounty("Beltrami");
        organizationInfoPage.setPhoneNumber("2221113333");
        organizationInfoPage.setFEIN("123456789");
    }

    public void enterContactInfo() {
        organizationInfoPage.setContactName("Test Contact");
        organizationInfoPage.setContactPhone("4445556666");
        organizationInfoPage.setContactEmail("scontact@example.com");
    }

    public String generateEffectiveDate() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, -6);
        String dateStr = formFieldDateFormat.format(cal.getTime());
        return dateStr;
    }

    public void openIndividualMemberPanel() {
        individualInfoPage.enterIndividualMember();
    }

    public void enterIndividualMember() {
        individualInfoPage.enterIndividualMember();
        individualInfoPage.setIndividualOwnerNPI("1234567893");
        individualInfoPage.setIndividualOwnerName("Test Owner");
        individualInfoPage.setIndividualProviderType("Dentist");
        individualInfoPage.setIndividualOwnerSoSec("123456789");
        individualInfoPage.setIndividualOwnerDOB("01011970");
        individualInfoPage.setIndividualHireDate("01012000");
    }

    @Step
    public void checkForTooYoungError() throws Exception {
        personalInfoPage.checkForTooYoungError();
    }

    @Step
    public void checkForRenewalDateError() throws Exception {
        licenseInfoPage.checkForRenewalDateError();
    }

    @Step
    public void checkForFeinError() throws Exception {
        organizationInfoPage.checkForFeinError();
    }

    @Step
    public void inputProviderAtPublicHealthServiceIndianHospital(boolean checkYes) {
        licenseInfoPage.checkProviderAtPublicHealthServiceIndianHospital(checkYes);
    }

    @Step
    public void enterLicenseInfo() {
        licenseInfoPage.addLicense();
        licenseInfoPage.addLicenseType(licenseType);
        licenseInfoPage.enterLicenseNumber(LICENSE_NUMBER);
        licenseInfoPage.enterIssueDate(LICENSE_ISSUE_DATE);
        licenseInfoPage.enterRenewalDate(LICENSE_RENEWAL_DATE);
        licenseInfoPage.enterIssueState(LICENSE_ISSUING_STATE_FULL);
    }

    @Step
    public void enterLicenseInfoWithRenewalDateBeforeIssueDate() {
        licenseInfoPage.addLicense();
        licenseInfoPage.addLicenseType(licenseType);
        licenseInfoPage.enterLicenseNumber(LICENSE_NUMBER);
        licenseInfoPage.enterIssueDate(LICENSE_ISSUE_DATE);
        licenseInfoPage.enterRenewalDate(BEFORE_LICENSE_ISSUE_DATE);
        licenseInfoPage.enterIssueState(LICENSE_ISSUING_STATE_FULL);
    }

    @Step
    public void uploadLicense() throws IOException {
        licenseInfoPage.uploadSampleFile();
    }

    @Step
    public void advanceFromIndividualLicenseInfoToPracticeInfo() {
        licenseInfoPage.clickNext();
        assertThat(licenseInfoPage.getTitle()).contains("Practice Information");
    }

    @Step
    void advanceFromOrganizationLicenseInfoToIndividualMemberInfo() {
        licenseInfoPage.clickNext();
        assertThat(licenseInfoPage.getTitle()).contains("Member Information");
    }

    @Step
    public void indicateMaintainOwnPrivatePractice(boolean isPrivatePractice) {
        practiceInfoPage.checkPrivatePractice(isPrivatePractice);
    }

    @Step
    public void indicateGroupPractice(boolean isGroupPractice) {
        practiceInfoPage.checkGroupPractice(isGroupPractice);
    }

    @Step
    public void clickAddPracticeLocation() {
        practiceInfoPage.clickAddPracticeLocation();
    }

    @Step
    public void openPracticeLookupModal() {
        practiceInfoPage.clickPracticeLookupButton();
    }

    @Step
    void enterIndividualPrivatePracticeInfo() {
        practiceInfoPage.checkPrivatePractice(true);
        practiceInfoPage.checkGroupPractice(false);
        practiceInfoPage.enterPracticeName(PRIVATE_PRACTICE_NAME);
        practiceInfoPage.enterGroupNPI(PRACTICE_GROUP_NPI);
        practiceInfoPage.enterEffectiveDate(PRACTICE_EFFECTIVE_DATE);
        practiceInfoPage.enterPracticeAddress1(PRACTICE_ADDRESS_1);
        practiceInfoPage.enterPracticeAddress2(PRACTICE_ADDRESS_2);
        practiceInfoPage.enterCity(PRACTICE_CITY);
        practiceInfoPage.enterState(PRACTICE_STATE_FULL);
        practiceInfoPage.enterZipCode(PRACTICE_ZIP);
        practiceInfoPage.enterPhoneNumber(PRACTICE_PHONE);
        practiceInfoPage.clickSameAsAbove();
        practiceInfoPage.enterFein(PRACTICE_FEIN);
        practiceInfoPage.enterStateTaxId(PRACTICE_STATE_TAX_ID);
        practiceInfoPage.enterFiscalYearEnd(PRACTICE_YEAR_END);
        practiceInfoPage.checkYesEftAccepted();
        practiceInfoPage.checkFirstRemittanceSequence();
    }

    @Step
    public void enterOrganizationOwnershipInfo() {
        ownershipInfoPage.selectEntityType("Sole Proprietorship");
        ownershipInfoPage.addIndividualOwnership();
        ownershipInfoPage.selectOwnershipType("Managing Employee");
        ownershipInfoPage.setOwnershipFirstName("First");
        ownershipInfoPage.setOwnershipMiddleName("Middle");
        ownershipInfoPage.setOwnershipLastName("Last");
        ownershipInfoPage.setOwnershipSoSec("123456789");
        ownershipInfoPage.setOwnershipAddr1("OwnerAddr1");
        ownershipInfoPage.setOwnershipDOB("01011970");
        ownershipInfoPage.setOwnershipHireDate("01012000");
        ownershipInfoPage.setOwnershipCity("Ownertown");
        ownershipInfoPage.selectOwnershipState("Texas");
        ownershipInfoPage.setOwnershipZip("77706");
        ownershipInfoPage.selectOwnershipCounty("Beltrami");
    }

    @Step
    void advanceFromIndividualPracticeInfoToSummaryPage() {
        practiceInfoPage.clickNext();
        assertThat(individualSummaryPage.getTitle()).contains("Summary Information");
    }

    @Step
    void clickSaveAsDraft() {
        enrollmentPage.clickSaveAsDraft();
    }

    @Step
    void clickPrintButton() {
        individualSummaryPage.clickPrintButton();
    }

    @Step
    void advanceFromOrganizationIndividualMemberInfoToOwnershipInfo() {
        individualInfoPage.clickNext();
        assertThat(ownershipInfoPage.getTitle()).contains("Ownership Information");
    }

    @Step
    void addIndividualOwnership() {
        ownershipInfoPage.addIndividualOwnership();
    }

    @Step
    void addBusinessOwnership() {
        ownershipInfoPage.addBusinessOwnership();
    }

    @Step
    void setNoToAllDisclosures() {
        ownershipInfoPage.setNoToAllDisclosures();
    }

    @Step
    void validatePersonalSummaryInformation() {
        assertThat(individualSummaryPage.getFirstName())
                .isEqualToIgnoringWhitespace(FIRST_NAME);
        assertThat(individualSummaryPage.getMiddleName())
                .isEqualToIgnoringWhitespace(MIDDLE_NAME);
        assertThat(individualSummaryPage.getLastName())
                .isEqualToIgnoringWhitespace(LAST_NAME);
        assertThat(individualSummaryPage.getNPI())
                .isEqualToIgnoringWhitespace(NPI);
        assertThat(individualSummaryPage.getSSN())
                .isEqualToIgnoringWhitespace(SSN);
        assertThat(individualSummaryPage.getDOB())
                .isEqualTo(DATE_OF_BIRTH);
        assertThat(individualSummaryPage.getEmail())
                .isEqualToIgnoringWhitespace(EMAIL);
    }

    @Step
    void validateLicenseSummaryInfo() {
        assertThat(individualSummaryPage.isProviderAtPublicHealthServiceIndianHospital())
                .isFalse();
        assertThat(individualSummaryPage.getFirstLicenseType())
                .isEqualToIgnoringWhitespace(licenseType);
        assertThat(individualSummaryPage.getFirstLicenseNumber())
                .isEqualToIgnoringWhitespace(LICENSE_NUMBER);
        assertThat(individualSummaryPage.getFirstLicenseOriginalIssueDate())
                .isEqualTo(LICENSE_ISSUE_DATE);
        assertThat(individualSummaryPage.getFirstLicenseRenewalEndDate())
                .isEqualTo(LICENSE_RENEWAL_DATE);
        assertThat(individualSummaryPage.getFirstLicenseIssuingState())
                .isEqualToIgnoringWhitespace(LICENSE_ISSUING_STATE_ABBR);
    }

    @Step
    void validatePracticeSummaryInformation() {
        assertThat(individualSummaryPage.isPrivatePractice()).isTrue();
        assertThat(individualSummaryPage.isPartOfGroupPractice()).isFalse();
        assertThat(individualSummaryPage.getPrivatePracticeName())
                .isEqualToIgnoringWhitespace(PRIVATE_PRACTICE_NAME);
        assertThat(individualSummaryPage.getGroupNPI())
                .isEqualToIgnoringWhitespace(PRACTICE_GROUP_NPI);
        assertThat(individualSummaryPage.getEffectiveDate())
                .isEqualTo(PRACTICE_EFFECTIVE_DATE);
        assertThat(individualSummaryPage.getPracticeAddressLine1())
                .isEqualToIgnoringWhitespace(PRACTICE_ADDRESS_1);
        assertThat(individualSummaryPage.getPracticeAddressLine2())
                .isEqualToIgnoringWhitespace(PRACTICE_ADDRESS_2);
        assertThat(individualSummaryPage.getPracticeCity())
                .isEqualToIgnoringWhitespace(PRACTICE_CITY);
        assertThat(individualSummaryPage.getPracticeState())
                .isEqualToIgnoringWhitespace(PRACTICE_STATE_ABBR);
        assertThat(individualSummaryPage.getPracticeZip())
                .isEqualToIgnoringWhitespace(PRACTICE_ZIP);
        assertThat(individualSummaryPage.getPracticePhoneNumber())
                .isEqualToIgnoringWhitespace(PRACTICE_PHONE);
        assertThat(individualSummaryPage.isBillingAddressSameAsPracticeAddress())
                .isTrue();
        assertThat(individualSummaryPage.getFein())
                .isEqualToIgnoringWhitespace(PRACTICE_FEIN);
        assertThat(individualSummaryPage.getStateTaxId())
                .isEqualToIgnoringWhitespace(PRACTICE_STATE_TAX_ID);
        assertThat(individualSummaryPage.getFiscalYearEnd())
                .isEqualToIgnoringWhitespace(PRACTICE_YEAR_END);
        assertThat(individualSummaryPage.getEftAccepted())
                .isTrue();
        assertThat(individualSummaryPage.getRemittanceSequence())
                .isEqualToIgnoringWhitespace("Patient Account or Own Reference Number Order");
    }

    @Step
    void advanceFromOrganizationOwnershipInfoToSummaryPage() {
        ownershipInfoPage.clickNext();
        assertThat(organizationSummaryPage.getTitle()).contains("Summary Information");
    }

    @Step
    void advanceFromIndividualSummaryToProviderStatementPage() {
        individualSummaryPage.clickNext();
    }

    @Step
    void advanceFromOrganizationSummaryToProviderStatementPage() {
        organizationSummaryPage.clickNext();
    }

    @Step
    void checkNoOnProviderDisclosureQuestions() {
        providerStatementPage.checkNoCriminalConviction();
        providerStatementPage.checkNoCivilPenalty();
        providerStatementPage.checkNoPreviousExclusion();
    }

    @Step
    void signAndDateProviderStatement() {
        providerStatementPage.enterProviderName(LAST_NAME);
        providerStatementPage.enterProviderTitle("Title");
        providerStatementPage.enterValidDate();
    }

    @Step
    void submitEnrollment() {
        providerStatementPage.clickSubmitButton();
    }

    @Step
    void verifySubmitModal() {
        enrollmentDetailsPage.verifySubmitModal();
    }

    @Step
    void closeSubmitModal() {
        enrollmentDetailsPage.closeSubmitModal();
    }
}
