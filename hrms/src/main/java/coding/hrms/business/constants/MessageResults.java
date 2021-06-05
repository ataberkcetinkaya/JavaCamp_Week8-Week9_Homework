package coding.hrms.business.constants;

import java.util.HashMap;
import java.util.Map;

public class MessageResults {
    public static final Map<String, String> models = new HashMap<>();

    static {
        models.put("email", "E-Mail");
        models.put("identityNo", "TC NO");
        models.put("user", "User");
        models.put("personnel", "Personnel");
        models.put("employer", "Employer");
        models.put("employee", "Employee");
        models.put("position", "Position");
        models.put("city", "city");
        models.put("jobAdvertisement", "Job Ad.");
        models.put("resume", "Resume");
        models.put("school", "School");
        models.put("jobExperience", "Job Exp");
        models.put("language", "Language");
        models.put("ability", "Skills");
        models.put("image", "pictures");
    }

    public static final String emptyField = "Do not leave this field blank!";
    public static final String emptyFields = "Do not leave this field blank";
    public static final String passwordMatchFalse = "Passwords matches";
    public static final String verificationSuccessFalse = "Verification failed!";
    public static final String verificationSuccessTrue = "Verification successful!";
    public static final String isRealPersonFalse = "Authentication failed! Please make sure you have entered your information correctly.";
    public static final String isEmailFormatFalse = "The e-mail format is incorrect. Please enter an e-mail in the format 'example@example.com'.";
    public static final String validateEmail = "In order to complete your registration, you need to perform the activation that will be sent to your e-mail.";
    public static final String validateEmailBySystem = "Your registration will be confirmed by our system as soon as possible. Thank you for your patience.";
    public static final String errorWhileUploadingFile = "A problem was encountered while uploading the file!";

    public static String alreadyExists(String model){
        return String.format("Already registered. Try another one.", models.get(model)); //
    }

    public static String notFound(String model){
        return String.format("No such record", models.get(model));
    }

    public static String allDataListed(String model){
        return String.format("All data is listed.", models.get(model));
    }

    public static String dataListed(String model){
        return String.format("%s data listed.", models.get(model));
    }

    public static String saved(String model){
        return String.format("%s successfully added the system.", models.get(model));
    }

    public static String successfullySaved(String model){
        return String.format("%s successfully saved.", models.get(model));
    }

    public static String saved(String model, String extraText){
        return String.format("%s record successfully added to the system. %s", models.get(model), extraText);
    }

    public static String deleted(String model){
        return String.format("%s deleted from the system.", models.get(model));
    }

    public static String updated(String model){
        return String.format("%s updated on the system.", models.get(model));
    }

    public static String emailSent(String email){
        return String.format("E-mail sent: %s", email);
    }

}
