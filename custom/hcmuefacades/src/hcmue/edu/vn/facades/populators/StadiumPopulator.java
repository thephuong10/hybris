package hcmue.edu.vn.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.hcmue.edu.vn.data.StadiumData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import hcmue.edu.vn.core.job.MyJobPerformable;
import hcmue.edu.vn.core.model.StadiumModel;
import org.apache.log4j.Logger;

import java.util.Optional;

public class StadiumPopulator implements Populator<StadiumModel,StadiumData> {

    private static final Logger LOG = Logger.getLogger(StadiumPopulator.class.getName());

    @Override
    public void populate(StadiumModel source, StadiumData target) throws ConversionException {

        target.setName(source.getName());
        target.setCode(source.getCode());
        target.setCapacity(Optional
                           .ofNullable(source.getCapacity())
                           .map(c->c.toString())
                           .orElse(null)
        );

    }
}
