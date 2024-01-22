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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PowerSystemStabilizerDynamicsValidator {

  /** default constructor */
  protected PowerSystemStabilizerDynamicsValidator() {}

  /** factory method */
  public static PowerSystemStabilizerDynamicsValidator getInstance() {
    return new PowerSystemStabilizerDynamicsValidator();
  }

  /** handles creation validation for a PowerSystemStabilizerDynamics */
  public void validate(CreatePowerSystemStabilizerDynamicsCommand powerSystemStabilizerDynamics)
      throws Exception {
    Assert.notNull(
        powerSystemStabilizerDynamics,
        "CreatePowerSystemStabilizerDynamicsCommand should not be null");
    //		Assert.isNull( powerSystemStabilizerDynamics.getPowerSystemStabilizerDynamicsId(),
    // "CreatePowerSystemStabilizerDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a PowerSystemStabilizerDynamics */
  public void validate(UpdatePowerSystemStabilizerDynamicsCommand powerSystemStabilizerDynamics)
      throws Exception {
    Assert.notNull(
        powerSystemStabilizerDynamics,
        "UpdatePowerSystemStabilizerDynamicsCommand should not be null");
    Assert.notNull(
        powerSystemStabilizerDynamics.getPowerSystemStabilizerDynamicsId(),
        "UpdatePowerSystemStabilizerDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a PowerSystemStabilizerDynamics */
  public void validate(DeletePowerSystemStabilizerDynamicsCommand powerSystemStabilizerDynamics)
      throws Exception {
    Assert.notNull(powerSystemStabilizerDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        powerSystemStabilizerDynamics.getPowerSystemStabilizerDynamicsId(),
        "DeletePowerSystemStabilizerDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PowerSystemStabilizerDynamics */
  public void validate(PowerSystemStabilizerDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PowerSystemStabilizerDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPowerSystemStabilizerDynamicsId(),
        "PowerSystemStabilizerDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign PowerSystemStabilizerDynamics validation for a PowerSystemStabilizerDynamics
   *
   * @param command AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsCommand
   */
  public void validate(
      AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsCommand should not be null");
    Assert.notNull(
        command.getPowerSystemStabilizerDynamicsId(),
        "AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign PowerSystemStabilizerDynamics validation for a PowerSystemStabilizerDynamics
   *
   * @param command UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsCommand
   */
  public void validate(
      UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsCommand should not be null");
    Assert.notNull(
        command.getPowerSystemStabilizerDynamicsId(),
        "UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsCommand identifier should not be null");
  }
}
