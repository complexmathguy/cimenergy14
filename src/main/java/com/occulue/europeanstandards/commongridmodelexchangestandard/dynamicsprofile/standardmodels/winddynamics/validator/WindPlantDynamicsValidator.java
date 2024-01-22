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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class WindPlantDynamicsValidator {

  /** default constructor */
  protected WindPlantDynamicsValidator() {}

  /** factory method */
  public static WindPlantDynamicsValidator getInstance() {
    return new WindPlantDynamicsValidator();
  }

  /** handles creation validation for a WindPlantDynamics */
  public void validate(CreateWindPlantDynamicsCommand windPlantDynamics) throws Exception {
    Assert.notNull(windPlantDynamics, "CreateWindPlantDynamicsCommand should not be null");
    //		Assert.isNull( windPlantDynamics.getWindPlantDynamicsId(), "CreateWindPlantDynamicsCommand
    // identifier should be null" );
  }

  /** handles update validation for a WindPlantDynamics */
  public void validate(UpdateWindPlantDynamicsCommand windPlantDynamics) throws Exception {
    Assert.notNull(windPlantDynamics, "UpdateWindPlantDynamicsCommand should not be null");
    Assert.notNull(
        windPlantDynamics.getWindPlantDynamicsId(),
        "UpdateWindPlantDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a WindPlantDynamics */
  public void validate(DeleteWindPlantDynamicsCommand windPlantDynamics) throws Exception {
    Assert.notNull(windPlantDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        windPlantDynamics.getWindPlantDynamicsId(),
        "DeleteWindPlantDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindPlantDynamics */
  public void validate(WindPlantDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindPlantDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindPlantDynamicsId(),
        "WindPlantDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindPlantDynamics validation for a WindPlantDynamics
   *
   * @param command AssignWindPlantDynamicsToWindPlantDynamicsCommand
   */
  public void validate(AssignWindPlantDynamicsToWindPlantDynamicsCommand command) throws Exception {
    Assert.notNull(command, "AssignWindPlantDynamicsToWindPlantDynamicsCommand should not be null");
    Assert.notNull(
        command.getWindPlantDynamicsId(),
        "AssignWindPlantDynamicsToWindPlantDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindPlantDynamicsToWindPlantDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign WindPlantDynamics validation for a WindPlantDynamics
   *
   * @param command UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand
   */
  public void validate(UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand should not be null");
    Assert.notNull(
        command.getWindPlantDynamicsId(),
        "UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand identifier should not be null");
  }
}
