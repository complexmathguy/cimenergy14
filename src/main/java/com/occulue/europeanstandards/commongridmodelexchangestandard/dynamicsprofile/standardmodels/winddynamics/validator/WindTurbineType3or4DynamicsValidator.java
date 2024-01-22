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

public class WindTurbineType3or4DynamicsValidator {

  /** default constructor */
  protected WindTurbineType3or4DynamicsValidator() {}

  /** factory method */
  public static WindTurbineType3or4DynamicsValidator getInstance() {
    return new WindTurbineType3or4DynamicsValidator();
  }

  /** handles creation validation for a WindTurbineType3or4Dynamics */
  public void validate(CreateWindTurbineType3or4DynamicsCommand windTurbineType3or4Dynamics)
      throws Exception {
    Assert.notNull(
        windTurbineType3or4Dynamics, "CreateWindTurbineType3or4DynamicsCommand should not be null");
    //		Assert.isNull( windTurbineType3or4Dynamics.getWindTurbineType3or4DynamicsId(),
    // "CreateWindTurbineType3or4DynamicsCommand identifier should be null" );
  }

  /** handles update validation for a WindTurbineType3or4Dynamics */
  public void validate(UpdateWindTurbineType3or4DynamicsCommand windTurbineType3or4Dynamics)
      throws Exception {
    Assert.notNull(
        windTurbineType3or4Dynamics, "UpdateWindTurbineType3or4DynamicsCommand should not be null");
    Assert.notNull(
        windTurbineType3or4Dynamics.getWindTurbineType3or4DynamicsId(),
        "UpdateWindTurbineType3or4DynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a WindTurbineType3or4Dynamics */
  public void validate(DeleteWindTurbineType3or4DynamicsCommand windTurbineType3or4Dynamics)
      throws Exception {
    Assert.notNull(windTurbineType3or4Dynamics, "{commandAlias} should not be null");
    Assert.notNull(
        windTurbineType3or4Dynamics.getWindTurbineType3or4DynamicsId(),
        "DeleteWindTurbineType3or4DynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindTurbineType3or4Dynamics */
  public void validate(WindTurbineType3or4DynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindTurbineType3or4DynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindTurbineType3or4DynamicsId(),
        "WindTurbineType3or4DynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindTurbineType3or4Dynamics validation for a WindTurbineType3or4Dynamics
   *
   * @param command AssignWindTurbineType3or4DynamicsToWindTurbineType3or4DynamicsCommand
   */
  public void validate(
      AssignWindTurbineType3or4DynamicsToWindTurbineType3or4DynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignWindTurbineType3or4DynamicsToWindTurbineType3or4DynamicsCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType3or4DynamicsId(),
        "AssignWindTurbineType3or4DynamicsToWindTurbineType3or4DynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindTurbineType3or4DynamicsToWindTurbineType3or4DynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign WindTurbineType3or4Dynamics validation for a WindTurbineType3or4Dynamics
   *
   * @param command UnAssignWindTurbineType3or4DynamicsFromWindTurbineType3or4DynamicsCommand
   */
  public void validate(
      UnAssignWindTurbineType3or4DynamicsFromWindTurbineType3or4DynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWindTurbineType3or4DynamicsFromWindTurbineType3or4DynamicsCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType3or4DynamicsId(),
        "UnAssignWindTurbineType3or4DynamicsFromWindTurbineType3or4DynamicsCommand identifier should not be null");
  }
}
