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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class AsynchronousMachineDynamicsValidator {

  /** default constructor */
  protected AsynchronousMachineDynamicsValidator() {}

  /** factory method */
  public static AsynchronousMachineDynamicsValidator getInstance() {
    return new AsynchronousMachineDynamicsValidator();
  }

  /** handles creation validation for a AsynchronousMachineDynamics */
  public void validate(CreateAsynchronousMachineDynamicsCommand asynchronousMachineDynamics)
      throws Exception {
    Assert.notNull(
        asynchronousMachineDynamics, "CreateAsynchronousMachineDynamicsCommand should not be null");
    //		Assert.isNull( asynchronousMachineDynamics.getAsynchronousMachineDynamicsId(),
    // "CreateAsynchronousMachineDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a AsynchronousMachineDynamics */
  public void validate(UpdateAsynchronousMachineDynamicsCommand asynchronousMachineDynamics)
      throws Exception {
    Assert.notNull(
        asynchronousMachineDynamics, "UpdateAsynchronousMachineDynamicsCommand should not be null");
    Assert.notNull(
        asynchronousMachineDynamics.getAsynchronousMachineDynamicsId(),
        "UpdateAsynchronousMachineDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a AsynchronousMachineDynamics */
  public void validate(DeleteAsynchronousMachineDynamicsCommand asynchronousMachineDynamics)
      throws Exception {
    Assert.notNull(asynchronousMachineDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        asynchronousMachineDynamics.getAsynchronousMachineDynamicsId(),
        "DeleteAsynchronousMachineDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AsynchronousMachineDynamics */
  public void validate(AsynchronousMachineDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AsynchronousMachineDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAsynchronousMachineDynamicsId(),
        "AsynchronousMachineDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign AsynchronousMachineDynamics validation for a AsynchronousMachineDynamics
   *
   * @param command AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsCommand
   */
  public void validate(
      AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineDynamicsId(),
        "AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign AsynchronousMachineDynamics validation for a AsynchronousMachineDynamics
   *
   * @param command UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsCommand
   */
  public void validate(
      UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineDynamicsId(),
        "UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsCommand identifier should not be null");
  }
}
