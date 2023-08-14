package hcmue.edu.vn.core.event;

import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import org.apache.log4j.Logger;

public class TrainingEventListener extends AbstractEventListener<TrainingEvent> {
    private static final Logger LOG =
            Logger.getLogger(TrainingEventListener.class.getName());
    @Override
    protected void onEvent(final TrainingEvent event) {
        LOG.info("**********************************");
        LOG.info("Could not insert stadium " + event.getMessage() +" "+event.getCondition());
        LOG.info("**********************************");
    }
}
