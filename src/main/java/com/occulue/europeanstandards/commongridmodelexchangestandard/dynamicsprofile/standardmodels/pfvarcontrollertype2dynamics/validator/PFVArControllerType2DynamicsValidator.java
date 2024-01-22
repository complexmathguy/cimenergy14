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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PFVArControllerType2DynamicsValidator {

  /** default constructor */
  protected PFVArControllerType2DynamicsValidator() {}

  /** factory method */
  public static PFVArControllerType2DynamicsValidator getInstance() {
    return new PFVArControllerType2DynamicsValidator();
  }

  /** handles creation validation for a PFVArControllerType2Dynamics */
  public void validate(CreatePFVArControllerType2DynamicsCommand pFVArControllerType2Dynamics)
      throws Exception {
    Assert.notNull(
        pFVArControllerType2Dynamics,
        "CreatePFVArControllerType2DynamicsCommand should not be null");
    //		Assert.isNull( pFVArControllerType2Dynamics.getPFVArControllerType2DynamicsId(),
    // "CreatePFVArControllerType2DynamicsCommand identifier should be null" );
  }

  /** handles update validation for a PFVArControllerType2Dynamics */
  public void validate(UpdatePFVArControllerType2DynamicsCommand pFVArControllerType2Dynamics)
      throws Exception {
    Assert.notNull(
        pFVArControllerType2Dynamics,
        "UpdatePFVArControllerType2DynamicsCommand should not be null");
    Assert.notNull(
        pFVArControllerType2Dynamics.getPFVArControllerType2DynamicsId(),
        "UpdatePFVArControllerType2DynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a PFVArControllerType2Dynamics */
  public void validate(DeletePFVArControllerType2DynamicsCommand pFVArControllerType2Dynamics)
      throws Exception {
    Assert.notNull(pFVArControllerType2Dynamics, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArControllerType2Dynamics.getPFVArControllerType2DynamicsId(),
        "DeletePFVArControllerType2DynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArControllerType2Dynamics */
  public void validate(PFVArControllerType2DynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArControllerType2DynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArControllerType2DynamicsId(),
        "PFVArControllerType2DynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign PFVArControllerType2Dynamics validation for a PFVArControllerType2Dynamics
   *
   * @param command AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand
   */
  public void validate(
      AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand should not be null");
    Assert.notNull(
        command.getPFVArControllerType2DynamicsId(),
        "AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign PFVArControllerType2Dynamics validation for a PFVArControllerType2Dynamics
   *
   * @param command UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsCommand
   */
  public void validate(
      UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsCommand should not be null");
    Assert.notNull(
        command.getPFVArControllerType2DynamicsId(),
        "UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsCommand identifier should not be null");
  }
}
