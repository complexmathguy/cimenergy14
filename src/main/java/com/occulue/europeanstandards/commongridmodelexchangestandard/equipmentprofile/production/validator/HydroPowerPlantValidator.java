/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class HydroPowerPlantValidator {

  /** default constructor */
  protected HydroPowerPlantValidator() {}

  /** factory method */
  public static HydroPowerPlantValidator getInstance() {
    return new HydroPowerPlantValidator();
  }

  /** handles creation validation for a HydroPowerPlant */
  public void validate(CreateHydroPowerPlantCommand hydroPowerPlant) throws Exception {
    Assert.notNull(hydroPowerPlant, "CreateHydroPowerPlantCommand should not be null");
    //		Assert.isNull( hydroPowerPlant.getHydroPowerPlantId(), "CreateHydroPowerPlantCommand
    // identifier should be null" );
  }

  /** handles update validation for a HydroPowerPlant */
  public void validate(UpdateHydroPowerPlantCommand hydroPowerPlant) throws Exception {
    Assert.notNull(hydroPowerPlant, "UpdateHydroPowerPlantCommand should not be null");
    Assert.notNull(
        hydroPowerPlant.getHydroPowerPlantId(),
        "UpdateHydroPowerPlantCommand identifier should not be null");
  }

  /** handles delete validation for a HydroPowerPlant */
  public void validate(DeleteHydroPowerPlantCommand hydroPowerPlant) throws Exception {
    Assert.notNull(hydroPowerPlant, "{commandAlias} should not be null");
    Assert.notNull(
        hydroPowerPlant.getHydroPowerPlantId(),
        "DeleteHydroPowerPlantCommand identifier should not be null");
  }

  /** handles fetchOne validation for a HydroPowerPlant */
  public void validate(HydroPowerPlantFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "HydroPowerPlantFetchOneSummary should not be null");
    Assert.notNull(
        summary.getHydroPowerPlantId(),
        "HydroPowerPlantFetchOneSummary identifier should not be null");
  }
}
