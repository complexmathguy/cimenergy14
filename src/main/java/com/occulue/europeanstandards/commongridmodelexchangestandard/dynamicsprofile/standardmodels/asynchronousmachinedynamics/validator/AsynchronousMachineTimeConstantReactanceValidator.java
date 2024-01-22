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

public class AsynchronousMachineTimeConstantReactanceValidator {

  /** default constructor */
  protected AsynchronousMachineTimeConstantReactanceValidator() {}

  /** factory method */
  public static AsynchronousMachineTimeConstantReactanceValidator getInstance() {
    return new AsynchronousMachineTimeConstantReactanceValidator();
  }

  /** handles creation validation for a AsynchronousMachineTimeConstantReactance */
  public void validate(
      CreateAsynchronousMachineTimeConstantReactanceCommand
          asynchronousMachineTimeConstantReactance)
      throws Exception {
    Assert.notNull(
        asynchronousMachineTimeConstantReactance,
        "CreateAsynchronousMachineTimeConstantReactanceCommand should not be null");
    //		Assert.isNull(
    // asynchronousMachineTimeConstantReactance.getAsynchronousMachineTimeConstantReactanceId(),
    // "CreateAsynchronousMachineTimeConstantReactanceCommand identifier should be null" );
  }

  /** handles update validation for a AsynchronousMachineTimeConstantReactance */
  public void validate(
      UpdateAsynchronousMachineTimeConstantReactanceCommand
          asynchronousMachineTimeConstantReactance)
      throws Exception {
    Assert.notNull(
        asynchronousMachineTimeConstantReactance,
        "UpdateAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        asynchronousMachineTimeConstantReactance.getAsynchronousMachineTimeConstantReactanceId(),
        "UpdateAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }

  /** handles delete validation for a AsynchronousMachineTimeConstantReactance */
  public void validate(
      DeleteAsynchronousMachineTimeConstantReactanceCommand
          asynchronousMachineTimeConstantReactance)
      throws Exception {
    Assert.notNull(asynchronousMachineTimeConstantReactance, "{commandAlias} should not be null");
    Assert.notNull(
        asynchronousMachineTimeConstantReactance.getAsynchronousMachineTimeConstantReactanceId(),
        "DeleteAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AsynchronousMachineTimeConstantReactance */
  public void validate(AsynchronousMachineTimeConstantReactanceFetchOneSummary summary)
      throws Exception {
    Assert.notNull(
        summary, "AsynchronousMachineTimeConstantReactanceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAsynchronousMachineTimeConstantReactanceId(),
        "AsynchronousMachineTimeConstantReactanceFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Tpo validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpoToAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignTpoToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTpoToAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "AssignTpoToAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpoToAsynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Tpo validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Tppo validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppoToAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignTppoToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTppoToAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "AssignTppoToAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTppoToAsynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Tppo validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Xp validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXpToAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignXpToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXpToAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "AssignXpToAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXpToAsynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Xp validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Xpp validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXppToAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignXppToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXppToAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "AssignXppToAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXppToAsynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Xpp validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Xs validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXsToAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignXsToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXsToAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "AssignXsToAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXsToAsynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Xs validation for a AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineTimeConstantReactanceId(),
        "UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
}
