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

public class SolarGeneratingUnitValidator {

  /** default constructor */
  protected SolarGeneratingUnitValidator() {}

  /** factory method */
  public static SolarGeneratingUnitValidator getInstance() {
    return new SolarGeneratingUnitValidator();
  }

  /** handles creation validation for a SolarGeneratingUnit */
  public void validate(CreateSolarGeneratingUnitCommand solarGeneratingUnit) throws Exception {
    Assert.notNull(solarGeneratingUnit, "CreateSolarGeneratingUnitCommand should not be null");
    //		Assert.isNull( solarGeneratingUnit.getSolarGeneratingUnitId(),
    // "CreateSolarGeneratingUnitCommand identifier should be null" );
  }

  /** handles update validation for a SolarGeneratingUnit */
  public void validate(UpdateSolarGeneratingUnitCommand solarGeneratingUnit) throws Exception {
    Assert.notNull(solarGeneratingUnit, "UpdateSolarGeneratingUnitCommand should not be null");
    Assert.notNull(
        solarGeneratingUnit.getSolarGeneratingUnitId(),
        "UpdateSolarGeneratingUnitCommand identifier should not be null");
  }

  /** handles delete validation for a SolarGeneratingUnit */
  public void validate(DeleteSolarGeneratingUnitCommand solarGeneratingUnit) throws Exception {
    Assert.notNull(solarGeneratingUnit, "{commandAlias} should not be null");
    Assert.notNull(
        solarGeneratingUnit.getSolarGeneratingUnitId(),
        "DeleteSolarGeneratingUnitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SolarGeneratingUnit */
  public void validate(SolarGeneratingUnitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SolarGeneratingUnitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSolarGeneratingUnitId(),
        "SolarGeneratingUnitFetchOneSummary identifier should not be null");
  }
}
