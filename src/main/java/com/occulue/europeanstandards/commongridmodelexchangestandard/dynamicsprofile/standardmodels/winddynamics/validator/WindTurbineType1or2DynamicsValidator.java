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

public class WindTurbineType1or2DynamicsValidator {

  /** default constructor */
  protected WindTurbineType1or2DynamicsValidator() {}

  /** factory method */
  public static WindTurbineType1or2DynamicsValidator getInstance() {
    return new WindTurbineType1or2DynamicsValidator();
  }

  /** handles creation validation for a WindTurbineType1or2Dynamics */
  public void validate(CreateWindTurbineType1or2DynamicsCommand windTurbineType1or2Dynamics)
      throws Exception {
    Assert.notNull(
        windTurbineType1or2Dynamics, "CreateWindTurbineType1or2DynamicsCommand should not be null");
    //		Assert.isNull( windTurbineType1or2Dynamics.getWindTurbineType1or2DynamicsId(),
    // "CreateWindTurbineType1or2DynamicsCommand identifier should be null" );
  }

  /** handles update validation for a WindTurbineType1or2Dynamics */
  public void validate(UpdateWindTurbineType1or2DynamicsCommand windTurbineType1or2Dynamics)
      throws Exception {
    Assert.notNull(
        windTurbineType1or2Dynamics, "UpdateWindTurbineType1or2DynamicsCommand should not be null");
    Assert.notNull(
        windTurbineType1or2Dynamics.getWindTurbineType1or2DynamicsId(),
        "UpdateWindTurbineType1or2DynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a WindTurbineType1or2Dynamics */
  public void validate(DeleteWindTurbineType1or2DynamicsCommand windTurbineType1or2Dynamics)
      throws Exception {
    Assert.notNull(windTurbineType1or2Dynamics, "{commandAlias} should not be null");
    Assert.notNull(
        windTurbineType1or2Dynamics.getWindTurbineType1or2DynamicsId(),
        "DeleteWindTurbineType1or2DynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindTurbineType1or2Dynamics */
  public void validate(WindTurbineType1or2DynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindTurbineType1or2DynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindTurbineType1or2DynamicsId(),
        "WindTurbineType1or2DynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindTurbineType1or2Dynamics validation for a WindTurbineType1or2Dynamics
   *
   * @param command AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand
   */
  public void validate(
      AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType1or2DynamicsId(),
        "AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign WindTurbineType1or2Dynamics validation for a WindTurbineType1or2Dynamics
   *
   * @param command UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsCommand
   */
  public void validate(
      UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType1or2DynamicsId(),
        "UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsCommand identifier should not be null");
  }
}
