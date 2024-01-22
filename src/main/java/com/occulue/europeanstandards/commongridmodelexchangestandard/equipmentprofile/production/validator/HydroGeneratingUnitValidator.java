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

public class HydroGeneratingUnitValidator {

  /** default constructor */
  protected HydroGeneratingUnitValidator() {}

  /** factory method */
  public static HydroGeneratingUnitValidator getInstance() {
    return new HydroGeneratingUnitValidator();
  }

  /** handles creation validation for a HydroGeneratingUnit */
  public void validate(CreateHydroGeneratingUnitCommand hydroGeneratingUnit) throws Exception {
    Assert.notNull(hydroGeneratingUnit, "CreateHydroGeneratingUnitCommand should not be null");
    //		Assert.isNull( hydroGeneratingUnit.getHydroGeneratingUnitId(),
    // "CreateHydroGeneratingUnitCommand identifier should be null" );
  }

  /** handles update validation for a HydroGeneratingUnit */
  public void validate(UpdateHydroGeneratingUnitCommand hydroGeneratingUnit) throws Exception {
    Assert.notNull(hydroGeneratingUnit, "UpdateHydroGeneratingUnitCommand should not be null");
    Assert.notNull(
        hydroGeneratingUnit.getHydroGeneratingUnitId(),
        "UpdateHydroGeneratingUnitCommand identifier should not be null");
  }

  /** handles delete validation for a HydroGeneratingUnit */
  public void validate(DeleteHydroGeneratingUnitCommand hydroGeneratingUnit) throws Exception {
    Assert.notNull(hydroGeneratingUnit, "{commandAlias} should not be null");
    Assert.notNull(
        hydroGeneratingUnit.getHydroGeneratingUnitId(),
        "DeleteHydroGeneratingUnitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a HydroGeneratingUnit */
  public void validate(HydroGeneratingUnitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "HydroGeneratingUnitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getHydroGeneratingUnitId(),
        "HydroGeneratingUnitFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to HydroGeneratingUnits validation for a HydroGeneratingUnit
   *
   * @param command AssignHydroGeneratingUnitsToHydroGeneratingUnitCommand
   */
  public void validate(AssignHydroGeneratingUnitsToHydroGeneratingUnitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignHydroGeneratingUnitsToHydroGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getHydroGeneratingUnitId(),
        "AssignHydroGeneratingUnitsToHydroGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignHydroGeneratingUnitsToHydroGeneratingUnitCommand addTo attribute should not be null");
  }

  /**
   * handles remove from HydroGeneratingUnits validation for a HydroGeneratingUnit
   *
   * @param command RemoveHydroGeneratingUnitsFromHydroGeneratingUnitCommand
   */
  public void validate(RemoveHydroGeneratingUnitsFromHydroGeneratingUnitCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveHydroGeneratingUnitsFromHydroGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getHydroGeneratingUnitId(),
        "RemoveHydroGeneratingUnitsFromHydroGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveHydroGeneratingUnitsFromHydroGeneratingUnitCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getHydroGeneratingUnitId(),
        "RemoveHydroGeneratingUnitsFromHydroGeneratingUnitCommand removeFrom attribubte identifier should not be null");
  }
}
