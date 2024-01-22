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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TurbineLoadControllerDynamicsValidator {

  /** default constructor */
  protected TurbineLoadControllerDynamicsValidator() {}

  /** factory method */
  public static TurbineLoadControllerDynamicsValidator getInstance() {
    return new TurbineLoadControllerDynamicsValidator();
  }

  /** handles creation validation for a TurbineLoadControllerDynamics */
  public void validate(CreateTurbineLoadControllerDynamicsCommand turbineLoadControllerDynamics)
      throws Exception {
    Assert.notNull(
        turbineLoadControllerDynamics,
        "CreateTurbineLoadControllerDynamicsCommand should not be null");
    //		Assert.isNull( turbineLoadControllerDynamics.getTurbineLoadControllerDynamicsId(),
    // "CreateTurbineLoadControllerDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a TurbineLoadControllerDynamics */
  public void validate(UpdateTurbineLoadControllerDynamicsCommand turbineLoadControllerDynamics)
      throws Exception {
    Assert.notNull(
        turbineLoadControllerDynamics,
        "UpdateTurbineLoadControllerDynamicsCommand should not be null");
    Assert.notNull(
        turbineLoadControllerDynamics.getTurbineLoadControllerDynamicsId(),
        "UpdateTurbineLoadControllerDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a TurbineLoadControllerDynamics */
  public void validate(DeleteTurbineLoadControllerDynamicsCommand turbineLoadControllerDynamics)
      throws Exception {
    Assert.notNull(turbineLoadControllerDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        turbineLoadControllerDynamics.getTurbineLoadControllerDynamicsId(),
        "DeleteTurbineLoadControllerDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TurbineLoadControllerDynamics */
  public void validate(TurbineLoadControllerDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TurbineLoadControllerDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTurbineLoadControllerDynamicsId(),
        "TurbineLoadControllerDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign TurbineLoadControllerDynamics validation for a TurbineLoadControllerDynamics
   *
   * @param command AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand
   */
  public void validate(
      AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand should not be null");
    Assert.notNull(
        command.getTurbineLoadControllerDynamicsId(),
        "AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign TurbineLoadControllerDynamics validation for a TurbineLoadControllerDynamics
   *
   * @param command UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand
   */
  public void validate(
      UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand should not be null");
    Assert.notNull(
        command.getTurbineLoadControllerDynamicsId(),
        "UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand identifier should not be null");
  }
}
