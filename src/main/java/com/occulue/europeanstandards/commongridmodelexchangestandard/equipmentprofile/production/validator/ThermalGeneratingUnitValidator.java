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

public class ThermalGeneratingUnitValidator {

  /** default constructor */
  protected ThermalGeneratingUnitValidator() {}

  /** factory method */
  public static ThermalGeneratingUnitValidator getInstance() {
    return new ThermalGeneratingUnitValidator();
  }

  /** handles creation validation for a ThermalGeneratingUnit */
  public void validate(CreateThermalGeneratingUnitCommand thermalGeneratingUnit) throws Exception {
    Assert.notNull(thermalGeneratingUnit, "CreateThermalGeneratingUnitCommand should not be null");
    //		Assert.isNull( thermalGeneratingUnit.getThermalGeneratingUnitId(),
    // "CreateThermalGeneratingUnitCommand identifier should be null" );
  }

  /** handles update validation for a ThermalGeneratingUnit */
  public void validate(UpdateThermalGeneratingUnitCommand thermalGeneratingUnit) throws Exception {
    Assert.notNull(thermalGeneratingUnit, "UpdateThermalGeneratingUnitCommand should not be null");
    Assert.notNull(
        thermalGeneratingUnit.getThermalGeneratingUnitId(),
        "UpdateThermalGeneratingUnitCommand identifier should not be null");
  }

  /** handles delete validation for a ThermalGeneratingUnit */
  public void validate(DeleteThermalGeneratingUnitCommand thermalGeneratingUnit) throws Exception {
    Assert.notNull(thermalGeneratingUnit, "{commandAlias} should not be null");
    Assert.notNull(
        thermalGeneratingUnit.getThermalGeneratingUnitId(),
        "DeleteThermalGeneratingUnitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ThermalGeneratingUnit */
  public void validate(ThermalGeneratingUnitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ThermalGeneratingUnitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getThermalGeneratingUnitId(),
        "ThermalGeneratingUnitFetchOneSummary identifier should not be null");
  }
}
