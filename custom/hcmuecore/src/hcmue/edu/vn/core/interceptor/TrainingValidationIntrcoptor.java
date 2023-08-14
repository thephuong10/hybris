package hcmue.edu.vn.core.interceptor;

import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import hcmue.edu.vn.core.event.TrainingEvent;
import hcmue.edu.vn.core.model.StadiumModel;
import hcmue.edu.vn.core.service.StadiumService;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

public class TrainingValidationIntrcoptor implements ValidateInterceptor {

    @Resource
    private EventService eventService;

    public void AddStadiumPublishEvent(String message, String condition) {
        eventService.publishEvent(new TrainingEvent(message, condition));
    }

    @Override
    public void onValidate(final Object object, final InterceptorContext ctx)
            throws InterceptorException {
        if (object instanceof StadiumModel) {
            final int capacity = ((StadiumModel) object).getCapacity();
            if (capacity == 5000) {
                AddStadiumPublishEvent(((StadiumModel) object).getName(), ((StadiumModel) object).getCapacity().toString());
                throw new InterceptorException("Can not Add The Stadium With capacity 5000!");
            } else if (capacity<=0||capacity>100000) {
                System.out.println("*********************************************************");
                System.out.println("Invalid value, Stadium capacity must be between 1 and 100000");
                System.out.println("*********************************************************");
                throw new InterceptorException("Invalid value, Stadium capacity must be between 1 and 100000");
            }

        }
    }
}
