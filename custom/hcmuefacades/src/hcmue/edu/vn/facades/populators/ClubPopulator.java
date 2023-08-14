package hcmue.edu.vn.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.hcmue.edu.vn.data.ClubData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import hcmue.edu.vn.core.model.ClubModel;

public class ClubPopulator implements Populator<ClubModel, ClubData> {
    @Override
    public void populate(ClubModel source, ClubData target) throws ConversionException {
        target.setCode(source.getCode());
        target.setName(source.getName());
    }
}
