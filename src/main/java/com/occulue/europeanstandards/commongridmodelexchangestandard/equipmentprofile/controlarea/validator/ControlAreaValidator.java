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

public class ControlAreaValidator {

  /** default constructor */
  protected ControlAreaValidator() {}

  /** factory method */
  public static ControlAreaValidator getInstance() {
    return new ControlAreaValidator();
  }

  /** handles creation validation for a ControlArea */
  public void validate(CreateControlAreaCommand controlArea) throws Exception {
    Assert.notNull(controlArea, "CreateControlAreaCommand should not be null");
    //		Assert.isNull( controlArea.getControlAreaId(), "CreateControlAreaCommand identifier should
    // be null" );
  }

  /** handles update validation for a ControlArea */
  public void validate(UpdateControlAreaCommand controlArea) throws Exception {
    Assert.notNull(controlArea, "UpdateControlAreaCommand should not be null");
    Assert.notNull(
        controlArea.getControlAreaId(), "UpdateControlAreaCommand identifier should not be null");
  }

  /** handles delete validation for a ControlArea */
  public void validate(DeleteControlAreaCommand controlArea) throws Exception {
    Assert.notNull(controlArea, "{commandAlias} should not be null");
    Assert.notNull(
        controlArea.getControlAreaId(), "DeleteControlAreaCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ControlArea */
  public void validate(ControlAreaFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ControlAreaFetchOneSummary should not be null");
    Assert.notNull(
        summary.getControlAreaId(), "ControlAreaFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign ControlArea validation for a ControlArea
   *
   * @param command AssignControlAreaToControlAreaCommand
   */
  public void validate(AssignControlAreaToControlAreaCommand command) throws Exception {
    Assert.notNull(command, "AssignControlAreaToControlAreaCommand should not be null");
    Assert.notNull(
        command.getControlAreaId(),
        "AssignControlAreaToControlAreaCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignControlAreaToControlAreaCommand assignment should not be null");
  }

  /**
   * handles unassign ControlArea validation for a ControlArea
   *
   * @param command UnAssignControlAreaFromControlAreaCommand
   */
  public void validate(UnAssignControlAreaFromControlAreaCommand command) throws Exception {
    Assert.notNull(command, "UnAssignControlAreaFromControlAreaCommand should not be null");
    Assert.notNull(
        command.getControlAreaId(),
        "UnAssignControlAreaFromControlAreaCommand identifier should not be null");
  }
}
