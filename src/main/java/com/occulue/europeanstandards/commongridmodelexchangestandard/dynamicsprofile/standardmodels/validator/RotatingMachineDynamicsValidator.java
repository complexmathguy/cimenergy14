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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class RotatingMachineDynamicsValidator {

  /** default constructor */
  protected RotatingMachineDynamicsValidator() {}

  /** factory method */
  public static RotatingMachineDynamicsValidator getInstance() {
    return new RotatingMachineDynamicsValidator();
  }

  /** handles creation validation for a RotatingMachineDynamics */
  public void validate(CreateRotatingMachineDynamicsCommand rotatingMachineDynamics)
      throws Exception {
    Assert.notNull(
        rotatingMachineDynamics, "CreateRotatingMachineDynamicsCommand should not be null");
    //		Assert.isNull( rotatingMachineDynamics.getRotatingMachineDynamicsId(),
    // "CreateRotatingMachineDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a RotatingMachineDynamics */
  public void validate(UpdateRotatingMachineDynamicsCommand rotatingMachineDynamics)
      throws Exception {
    Assert.notNull(
        rotatingMachineDynamics, "UpdateRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        rotatingMachineDynamics.getRotatingMachineDynamicsId(),
        "UpdateRotatingMachineDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a RotatingMachineDynamics */
  public void validate(DeleteRotatingMachineDynamicsCommand rotatingMachineDynamics)
      throws Exception {
    Assert.notNull(rotatingMachineDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        rotatingMachineDynamics.getRotatingMachineDynamicsId(),
        "DeleteRotatingMachineDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RotatingMachineDynamics */
  public void validate(RotatingMachineDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RotatingMachineDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRotatingMachineDynamicsId(),
        "RotatingMachineDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Damping validation for a RotatingMachineDynamics
   *
   * @param command AssignDampingToRotatingMachineDynamicsCommand
   */
  public void validate(AssignDampingToRotatingMachineDynamicsCommand command) throws Exception {
    Assert.notNull(command, "AssignDampingToRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "AssignDampingToRotatingMachineDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDampingToRotatingMachineDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign Damping validation for a RotatingMachineDynamics
   *
   * @param command UnAssignDampingFromRotatingMachineDynamicsCommand
   */
  public void validate(UnAssignDampingFromRotatingMachineDynamicsCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDampingFromRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "UnAssignDampingFromRotatingMachineDynamicsCommand identifier should not be null");
  }
  /**
   * handles assign Inertia validation for a RotatingMachineDynamics
   *
   * @param command AssignInertiaToRotatingMachineDynamicsCommand
   */
  public void validate(AssignInertiaToRotatingMachineDynamicsCommand command) throws Exception {
    Assert.notNull(command, "AssignInertiaToRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "AssignInertiaToRotatingMachineDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInertiaToRotatingMachineDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign Inertia validation for a RotatingMachineDynamics
   *
   * @param command UnAssignInertiaFromRotatingMachineDynamicsCommand
   */
  public void validate(UnAssignInertiaFromRotatingMachineDynamicsCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInertiaFromRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "UnAssignInertiaFromRotatingMachineDynamicsCommand identifier should not be null");
  }
  /**
   * handles assign SaturationFactor validation for a RotatingMachineDynamics
   *
   * @param command AssignSaturationFactorToRotatingMachineDynamicsCommand
   */
  public void validate(AssignSaturationFactorToRotatingMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignSaturationFactorToRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "AssignSaturationFactorToRotatingMachineDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSaturationFactorToRotatingMachineDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign SaturationFactor validation for a RotatingMachineDynamics
   *
   * @param command UnAssignSaturationFactorFromRotatingMachineDynamicsCommand
   */
  public void validate(UnAssignSaturationFactorFromRotatingMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignSaturationFactorFromRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "UnAssignSaturationFactorFromRotatingMachineDynamicsCommand identifier should not be null");
  }
  /**
   * handles assign SaturationFactor120 validation for a RotatingMachineDynamics
   *
   * @param command AssignSaturationFactor120ToRotatingMachineDynamicsCommand
   */
  public void validate(AssignSaturationFactor120ToRotatingMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignSaturationFactor120ToRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "AssignSaturationFactor120ToRotatingMachineDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSaturationFactor120ToRotatingMachineDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign SaturationFactor120 validation for a RotatingMachineDynamics
   *
   * @param command UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand
   */
  public void validate(UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand identifier should not be null");
  }
  /**
   * handles assign StatorLeakageReactance validation for a RotatingMachineDynamics
   *
   * @param command AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand
   */
  public void validate(AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign StatorLeakageReactance validation for a RotatingMachineDynamics
   *
   * @param command UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand
   */
  public void validate(UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand identifier should not be null");
  }
  /**
   * handles assign StatorResistance validation for a RotatingMachineDynamics
   *
   * @param command AssignStatorResistanceToRotatingMachineDynamicsCommand
   */
  public void validate(AssignStatorResistanceToRotatingMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignStatorResistanceToRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "AssignStatorResistanceToRotatingMachineDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStatorResistanceToRotatingMachineDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign StatorResistance validation for a RotatingMachineDynamics
   *
   * @param command UnAssignStatorResistanceFromRotatingMachineDynamicsCommand
   */
  public void validate(UnAssignStatorResistanceFromRotatingMachineDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignStatorResistanceFromRotatingMachineDynamicsCommand should not be null");
    Assert.notNull(
        command.getRotatingMachineDynamicsId(),
        "UnAssignStatorResistanceFromRotatingMachineDynamicsCommand identifier should not be null");
  }
}
