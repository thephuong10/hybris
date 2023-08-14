package hcmue.edu.vn.core.event;

import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public class TrainingEvent extends AbstractEvent {
    private String message;
    private String condition;

    public TrainingEvent(String message, String condition) {
        super();
        this.message = message;
        this.condition = condition;
    }
    public TrainingEvent(){
        this.message="No message";
        this.condition="No condition";
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
