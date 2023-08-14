package hcmue.edu.vn.core.job;

import de.hybris.hcmuecore.model.MyJobPerformableModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cuppytrail.data.StadiumData;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import hcmue.edu.vn.core.model.StadiumModel;
import hcmue.edu.vn.core.service.StadiumService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyJobPerformable extends AbstractJobPerformable<MyJobPerformableModel> {
    private static final Logger LOG = Logger.getLogger(MyJobPerformable.class.getName());

    @Resource
    private StadiumService stadiumService;
    private String dateRs;

    @Override
    public PerformResult perform(MyJobPerformableModel cronJobModel) {
        try {
            Calendar cal = Calendar.getInstance();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateRs = dateFormat.format(cal.getTime());
            List<StadiumModel> stadiumModels = stadiumService.getStadiumsByDate(dateRs);
            if (!stadiumModels.isEmpty()) {
                List<StadiumData> stadiums = new ArrayList<>();
                LOG.info("********************************");
                LOG.info("New stadium added during the day");
                LOG.info("********************************");
                for (StadiumModel sm : stadiumModels) {
                    stadiums.add(convertModelToData(sm));
                    LOG.info("Stadium name: " + sm.getName() + "\n");
                }
            } else {
                LOG.info("No Stadiums added during the day!");
            }
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        } catch (Exception e) {
            return new PerformResult(CronJobResult.ERROR, CronJobStatus.ABORTED);
        }
    }

    private StadiumData convertModelToData(StadiumModel model) {
        final StadiumData sfd = new StadiumData();
        sfd.setName(model.getName());
        sfd.setCode(model.getCode());
        if (model.getCapacity() != null) {
            sfd.setCapacity(model.getCapacity().toString());
        }
        return sfd;
    }
}
