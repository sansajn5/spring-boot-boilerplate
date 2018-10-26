package nucleus.it.orianna.service.exception;


import nucleus.it.orianna.util.ResourceBundleUtil;

import java.util.Locale;


public class CustomException extends Exception {

    private String localizedErrorMessage;

    private String errorDescription;

    protected CustomException(String resourceBundleExceptionKey, String languageCode) {
        Locale newLanguageCode = new Locale(languageCode);
        this.localizedErrorMessage = translateErrorMessage(resourceBundleExceptionKey, newLanguageCode);
        this.errorDescription = translateErrorMessage(resourceBundleExceptionKey, newLanguageCode);
    }

    protected CustomException(String resourceBundleExceptionKey) {
        this.localizedErrorMessage = translateErrorMessage(resourceBundleExceptionKey, Locale.ENGLISH);
        this.errorDescription = this.localizedErrorMessage;
    }

    private String translateErrorMessage(String resourceBundleExceptionKey, Locale locale) {
        return ResourceBundleUtil.getExceptionValue(locale, resourceBundleExceptionKey);
    }

    public String getLocalizedErrorMessage() {
        return localizedErrorMessage;
    }

    public void setLocalizedErrorMessage(String localizedErrorMessage) {
        this.localizedErrorMessage = localizedErrorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
