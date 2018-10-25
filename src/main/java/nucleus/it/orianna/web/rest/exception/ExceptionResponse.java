package nucleus.it.orianna.web.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {

    @JsonProperty("status")
    private int status;

    @JsonProperty("status_text")
    private String statusText;

    @JsonProperty("localized_error_message")
    private String localizedErrorMessage;

    @JsonProperty("error_description")
    private String errorDescription;

    private List<String> data;

    ExceptionResponse(String localizedErrorMessage, String errorDescription, HttpStatus status) {
        this.status = status.value();
        this.statusText = status.getReasonPhrase();
        this.localizedErrorMessage = localizedErrorMessage;
        this.errorDescription = errorDescription;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
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

    void setErrors(List<String> data) {
        this.data = data;
    }
}
