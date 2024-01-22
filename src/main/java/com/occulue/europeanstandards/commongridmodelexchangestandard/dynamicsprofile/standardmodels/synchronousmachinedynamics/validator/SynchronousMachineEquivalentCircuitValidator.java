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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SynchronousMachineEquivalentCircuitValidator {

  /** default constructor */
  protected SynchronousMachineEquivalentCircuitValidator() {}

  /** factory method */
  public static SynchronousMachineEquivalentCircuitValidator getInstance() {
    return new SynchronousMachineEquivalentCircuitValidator();
  }

  /** handles creation validation for a SynchronousMachineEquivalentCircuit */
  public void validate(
      CreateSynchronousMachineEquivalentCircuitCommand synchronousMachineEquivalentCircuit)
      throws Exception {
    Assert.notNull(
        synchronousMachineEquivalentCircuit,
        "CreateSynchronousMachineEquivalentCircuitCommand should not be null");
    //		Assert.isNull(
    // synchronousMachineEquivalentCircuit.getSynchronousMachineEquivalentCircuitId(),
    // "CreateSynchronousMachineEquivalentCircuitCommand identifier should be null" );
  }

  /** handles update validation for a SynchronousMachineEquivalentCircuit */
  public void validate(
      UpdateSynchronousMachineEquivalentCircuitCommand synchronousMachineEquivalentCircuit)
      throws Exception {
    Assert.notNull(
        synchronousMachineEquivalentCircuit,
        "UpdateSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        synchronousMachineEquivalentCircuit.getSynchronousMachineEquivalentCircuitId(),
        "UpdateSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }

  /** handles delete validation for a SynchronousMachineEquivalentCircuit */
  public void validate(
      DeleteSynchronousMachineEquivalentCircuitCommand synchronousMachineEquivalentCircuit)
      throws Exception {
    Assert.notNull(synchronousMachineEquivalentCircuit, "{commandAlias} should not be null");
    Assert.notNull(
        synchronousMachineEquivalentCircuit.getSynchronousMachineEquivalentCircuitId(),
        "DeleteSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SynchronousMachineEquivalentCircuit */
  public void validate(SynchronousMachineEquivalentCircuitFetchOneSummary summary)
      throws Exception {
    Assert.notNull(
        summary, "SynchronousMachineEquivalentCircuitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSynchronousMachineEquivalentCircuitId(),
        "SynchronousMachineEquivalentCircuitFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign R1d validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR1dToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignR1dToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignR1dToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignR1dToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR1dToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign R1d validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign R1q validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR1qToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignR1qToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignR1qToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignR1qToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR1qToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign R1q validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign R2q validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR2qToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignR2qToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignR2qToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignR2qToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR2qToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign R2q validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Rfd validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignRfdToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignRfdToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignRfdToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignRfdToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRfdToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Rfd validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign X1d validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX1dToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignX1dToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignX1dToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignX1dToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX1dToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign X1d validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign X1q validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX1qToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignX1qToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignX1qToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignX1qToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX1qToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign X1q validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign X2q validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX2qToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignX2qToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignX2qToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignX2qToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX2qToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign X2q validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Xad validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXadToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignXadToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXadToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignXadToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXadToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Xad validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXadFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignXadFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXadFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignXadFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Xaq validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXaqToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignXaqToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXaqToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignXaqToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXaqToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Xaq validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Xf1d validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXf1dToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignXf1dToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXf1dToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignXf1dToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXf1dToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Xf1d validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Xfd validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXfdToSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignXfdToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXfdToSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "AssignXfdToSynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXfdToSynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Xfd validation for a SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineEquivalentCircuitId(),
        "UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
}
