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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PFVArControllerType1DynamicsValidator {

  /** default constructor */
  protected PFVArControllerType1DynamicsValidator() {}

  /** factory method */
  public static PFVArControllerType1DynamicsValidator getInstance() {
    return new PFVArControllerType1DynamicsValidator();
  }

  /** handles creation validation for a PFVArControllerType1Dynamics */
  public void validate(CreatePFVArControllerType1DynamicsCommand pFVArControllerType1Dynamics)
      throws Exception {
    Assert.notNull(
        pFVArControllerType1Dynamics,
        "CreatePFVArControllerType1DynamicsCommand should not be null");
    //		Assert.isNull( pFVArControllerType1Dynamics.getPFVArControllerType1DynamicsId(),
    // "CreatePFVArControllerType1DynamicsCommand identifier should be null" );
  }

  /** handles update validation for a PFVArControllerType1Dynamics */
  public void validate(UpdatePFVArControllerType1DynamicsCommand pFVArControllerType1Dynamics)
      throws Exception {
    Assert.notNull(
        pFVArControllerType1Dynamics,
        "UpdatePFVArControllerType1DynamicsCommand should not be null");
    Assert.notNull(
        pFVArControllerType1Dynamics.getPFVArControllerType1DynamicsId(),
        "UpdatePFVArControllerType1DynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a PFVArControllerType1Dynamics */
  public void validate(DeletePFVArControllerType1DynamicsCommand pFVArControllerType1Dynamics)
      throws Exception {
    Assert.notNull(pFVArControllerType1Dynamics, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArControllerType1Dynamics.getPFVArControllerType1DynamicsId(),
        "DeletePFVArControllerType1DynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArControllerType1Dynamics */
  public void validate(PFVArControllerType1DynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArControllerType1DynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArControllerType1DynamicsId(),
        "PFVArControllerType1DynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign PFVArControllerType1Dynamics validation for a PFVArControllerType1Dynamics
   *
   * @param command AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand
   */
  public void validate(
      AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand should not be null");
    Assert.notNull(
        command.getPFVArControllerType1DynamicsId(),
        "AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign PFVArControllerType1Dynamics validation for a PFVArControllerType1Dynamics
   *
   * @param command UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsCommand
   */
  public void validate(
      UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsCommand should not be null");
    Assert.notNull(
        command.getPFVArControllerType1DynamicsId(),
        "UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsCommand identifier should not be null");
  }
}
