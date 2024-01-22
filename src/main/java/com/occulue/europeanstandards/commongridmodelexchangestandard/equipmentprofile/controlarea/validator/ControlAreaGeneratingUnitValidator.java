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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ControlAreaGeneratingUnitValidator {

  /** default constructor */
  protected ControlAreaGeneratingUnitValidator() {}

  /** factory method */
  public static ControlAreaGeneratingUnitValidator getInstance() {
    return new ControlAreaGeneratingUnitValidator();
  }

  /** handles creation validation for a ControlAreaGeneratingUnit */
  public void validate(CreateControlAreaGeneratingUnitCommand controlAreaGeneratingUnit)
      throws Exception {
    Assert.notNull(
        controlAreaGeneratingUnit, "CreateControlAreaGeneratingUnitCommand should not be null");
    //		Assert.isNull( controlAreaGeneratingUnit.getControlAreaGeneratingUnitId(),
    // "CreateControlAreaGeneratingUnitCommand identifier should be null" );
  }

  /** handles update validation for a ControlAreaGeneratingUnit */
  public void validate(UpdateControlAreaGeneratingUnitCommand controlAreaGeneratingUnit)
      throws Exception {
    Assert.notNull(
        controlAreaGeneratingUnit, "UpdateControlAreaGeneratingUnitCommand should not be null");
    Assert.notNull(
        controlAreaGeneratingUnit.getControlAreaGeneratingUnitId(),
        "UpdateControlAreaGeneratingUnitCommand identifier should not be null");
  }

  /** handles delete validation for a ControlAreaGeneratingUnit */
  public void validate(DeleteControlAreaGeneratingUnitCommand controlAreaGeneratingUnit)
      throws Exception {
    Assert.notNull(controlAreaGeneratingUnit, "{commandAlias} should not be null");
    Assert.notNull(
        controlAreaGeneratingUnit.getControlAreaGeneratingUnitId(),
        "DeleteControlAreaGeneratingUnitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ControlAreaGeneratingUnit */
  public void validate(ControlAreaGeneratingUnitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ControlAreaGeneratingUnitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getControlAreaGeneratingUnitId(),
        "ControlAreaGeneratingUnitFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to ControlAreaGeneratingUnit validation for a ControlAreaGeneratingUnit
   *
   * @param command AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand
   */
  public void validate(AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getControlAreaGeneratingUnitId(),
        "AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand addTo attribute should not be null");
  }

  /**
   * handles remove from ControlAreaGeneratingUnit validation for a ControlAreaGeneratingUnit
   *
   * @param command RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand
   */
  public void validate(RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getControlAreaGeneratingUnitId(),
        "RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getControlAreaGeneratingUnitId(),
        "RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand removeFrom attribubte identifier should not be null");
  }
}
