package hcmue.edu.vn.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.hcmue.edu.vn.data.StadiumData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import hcmue.edu.vn.core.model.ClubModel;
import hcmue.edu.vn.core.model.StadiumModel;
import org.apache.log4j.Logger;

import java.util.Optional;

public class StadiumReversePopulator implements Populator<StadiumData,StadiumModel> {

    private static final Logger LOG = Logger.getLogger(StadiumReversePopulator.class.getName());


    @Override
    public void populate(StadiumData source, StadiumModel target) throws ConversionException {

        target.setName(source.getName());
        target.setCode(source.getCode());
        target.setCapacity(Optional
                .ofNullable(source.getCapacity())
                .map(c->Integer.parseInt(c))
                .orElse(0)
        );
        target.setOwnered(
                Optional.ofNullable(new ClubModel())
                        .map(c -> {
                            c.setCode(source.getOwner());
                            return c;
                        })
                        .orElse(null)
        );

    }
}
