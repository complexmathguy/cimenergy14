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

public class AsynchronousMachineEquivalentCircuitValidator {

  /** default constructor */
  protected AsynchronousMachineEquivalentCircuitValidator() {}

  /** factory method */
  public static AsynchronousMachineEquivalentCircuitValidator getInstance() {
    return new AsynchronousMachineEquivalentCircuitValidator();
  }

  /** handles creation validation for a AsynchronousMachineEquivalentCircuit */
  public void validate(
      CreateAsynchronousMachineEquivalentCircuitCommand asynchronousMachineEquivalentCircuit)
      throws Exception {
    Assert.notNull(
        asynchronousMachineEquivalentCircuit,
        "CreateAsynchronousMachineEquivalentCircuitCommand should not be null");
    //		Assert.isNull(
    // asynchronousMachineEquivalentCircuit.getAsynchronousMachineEquivalentCircuitId(),
    // "CreateAsynchronousMachineEquivalentCircuitCommand identifier should be null" );
  }

  /** handles update validation for a AsynchronousMachineEquivalentCircuit */
  public void validate(
      UpdateAsynchronousMachineEquivalentCircuitCommand asynchronousMachineEquivalentCircuit)
      throws Exception {
    Assert.notNull(
        asynchronousMachineEquivalentCircuit,
        "UpdateAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        asynchronousMachineEquivalentCircuit.getAsynchronousMachineEquivalentCircuitId(),
        "UpdateAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }

  /** handles delete validation for a AsynchronousMachineEquivalentCircuit */
  public void validate(
      DeleteAsynchronousMachineEquivalentCircuitCommand asynchronousMachineEquivalentCircuit)
      throws Exception {
    Assert.notNull(asynchronousMachineEquivalentCircuit, "{commandAlias} should not be null");
    Assert.notNull(
        asynchronousMachineEquivalentCircuit.getAsynchronousMachineEquivalentCircuitId(),
        "DeleteAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AsynchronousMachineEquivalentCircuit */
  public void validate(AsynchronousMachineEquivalentCircuitFetchOneSummary summary)
      throws Exception {
    Assert.notNull(
        summary, "AsynchronousMachineEquivalentCircuitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAsynchronousMachineEquivalentCircuitId(),
        "AsynchronousMachineEquivalentCircuitFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Rr1 validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignRr1ToAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignRr1ToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignRr1ToAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "AssignRr1ToAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRr1ToAsynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Rr1 validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Rr2 validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignRr2ToAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignRr2ToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignRr2ToAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "AssignRr2ToAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRr2ToAsynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Rr2 validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Xlr1 validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Xlr1 validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Xlr2 validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Xlr2 validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
  /**
   * handles assign Xm validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXmToAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(AssignXmToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignXmToAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "AssignXmToAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXmToAsynchronousMachineEquivalentCircuitCommand assignment should not be null");
  }

  /**
   * handles unassign Xm validation for a AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand
   */
  public void validate(UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineEquivalentCircuitId(),
        "UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand identifier should not be null");
  }
}
