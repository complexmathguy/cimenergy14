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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TurbineGovernorDynamicsValidator {

  /** default constructor */
  protected TurbineGovernorDynamicsValidator() {}

  /** factory method */
  public static TurbineGovernorDynamicsValidator getInstance() {
    return new TurbineGovernorDynamicsValidator();
  }

  /** handles creation validation for a TurbineGovernorDynamics */
  public void validate(CreateTurbineGovernorDynamicsCommand turbineGovernorDynamics)
      throws Exception {
    Assert.notNull(
        turbineGovernorDynamics, "CreateTurbineGovernorDynamicsCommand should not be null");
    //		Assert.isNull( turbineGovernorDynamics.getTurbineGovernorDynamicsId(),
    // "CreateTurbineGovernorDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a TurbineGovernorDynamics */
  public void validate(UpdateTurbineGovernorDynamicsCommand turbineGovernorDynamics)
      throws Exception {
    Assert.notNull(
        turbineGovernorDynamics, "UpdateTurbineGovernorDynamicsCommand should not be null");
    Assert.notNull(
        turbineGovernorDynamics.getTurbineGovernorDynamicsId(),
        "UpdateTurbineGovernorDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a TurbineGovernorDynamics */
  public void validate(DeleteTurbineGovernorDynamicsCommand turbineGovernorDynamics)
      throws Exception {
    Assert.notNull(turbineGovernorDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        turbineGovernorDynamics.getTurbineGovernorDynamicsId(),
        "DeleteTurbineGovernorDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TurbineGovernorDynamics */
  public void validate(TurbineGovernorDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TurbineGovernorDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTurbineGovernorDynamicsId(),
        "TurbineGovernorDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign TurbineGovernorDynamics validation for a TurbineGovernorDynamics
   *
   * @param command AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand
   */
  public void validate(AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand should not be null");
    Assert.notNull(
        command.getTurbineGovernorDynamicsId(),
        "AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign TurbineGovernorDynamics validation for a TurbineGovernorDynamics
   *
   * @param command UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsCommand
   */
  public void validate(UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsCommand should not be null");
    Assert.notNull(
        command.getTurbineGovernorDynamicsId(),
        "UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsCommand identifier should not be null");
  }
}
