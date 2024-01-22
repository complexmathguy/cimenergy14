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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class AsynchronousMachineValidator {

  /** default constructor */
  protected AsynchronousMachineValidator() {}

  /** factory method */
  public static AsynchronousMachineValidator getInstance() {
    return new AsynchronousMachineValidator();
  }

  /** handles creation validation for a AsynchronousMachine */
  public void validate(CreateAsynchronousMachineCommand asynchronousMachine) throws Exception {
    Assert.notNull(asynchronousMachine, "CreateAsynchronousMachineCommand should not be null");
    //		Assert.isNull( asynchronousMachine.getAsynchronousMachineId(),
    // "CreateAsynchronousMachineCommand identifier should be null" );
  }

  /** handles update validation for a AsynchronousMachine */
  public void validate(UpdateAsynchronousMachineCommand asynchronousMachine) throws Exception {
    Assert.notNull(asynchronousMachine, "UpdateAsynchronousMachineCommand should not be null");
    Assert.notNull(
        asynchronousMachine.getAsynchronousMachineId(),
        "UpdateAsynchronousMachineCommand identifier should not be null");
  }

  /** handles delete validation for a AsynchronousMachine */
  public void validate(DeleteAsynchronousMachineCommand asynchronousMachine) throws Exception {
    Assert.notNull(asynchronousMachine, "{commandAlias} should not be null");
    Assert.notNull(
        asynchronousMachine.getAsynchronousMachineId(),
        "DeleteAsynchronousMachineCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AsynchronousMachine */
  public void validate(AsynchronousMachineFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AsynchronousMachineFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAsynchronousMachineId(),
        "AsynchronousMachineFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign ConverterFedDrive validation for a AsynchronousMachine
   *
   * @param command AssignConverterFedDriveToAsynchronousMachineCommand
   */
  public void validate(AssignConverterFedDriveToAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignConverterFedDriveToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignConverterFedDriveToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignConverterFedDriveToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign ConverterFedDrive validation for a AsynchronousMachine
   *
   * @param command UnAssignConverterFedDriveFromAsynchronousMachineCommand
   */
  public void validate(UnAssignConverterFedDriveFromAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignConverterFedDriveFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignConverterFedDriveFromAsynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign Efficiency validation for a AsynchronousMachine
   *
   * @param command AssignEfficiencyToAsynchronousMachineCommand
   */
  public void validate(AssignEfficiencyToAsynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignEfficiencyToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignEfficiencyToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEfficiencyToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign Efficiency validation for a AsynchronousMachine
   *
   * @param command UnAssignEfficiencyFromAsynchronousMachineCommand
   */
  public void validate(UnAssignEfficiencyFromAsynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfficiencyFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignEfficiencyFromAsynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign IaIrRatio validation for a AsynchronousMachine
   *
   * @param command AssignIaIrRatioToAsynchronousMachineCommand
   */
  public void validate(AssignIaIrRatioToAsynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignIaIrRatioToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignIaIrRatioToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignIaIrRatioToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign IaIrRatio validation for a AsynchronousMachine
   *
   * @param command UnAssignIaIrRatioFromAsynchronousMachineCommand
   */
  public void validate(UnAssignIaIrRatioFromAsynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIaIrRatioFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignIaIrRatioFromAsynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign NominalFrequency validation for a AsynchronousMachine
   *
   * @param command AssignNominalFrequencyToAsynchronousMachineCommand
   */
  public void validate(AssignNominalFrequencyToAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNominalFrequencyToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignNominalFrequencyToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNominalFrequencyToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign NominalFrequency validation for a AsynchronousMachine
   *
   * @param command UnAssignNominalFrequencyFromAsynchronousMachineCommand
   */
  public void validate(UnAssignNominalFrequencyFromAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNominalFrequencyFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignNominalFrequencyFromAsynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign NominalSpeed validation for a AsynchronousMachine
   *
   * @param command AssignNominalSpeedToAsynchronousMachineCommand
   */
  public void validate(AssignNominalSpeedToAsynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignNominalSpeedToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignNominalSpeedToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNominalSpeedToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign NominalSpeed validation for a AsynchronousMachine
   *
   * @param command UnAssignNominalSpeedFromAsynchronousMachineCommand
   */
  public void validate(UnAssignNominalSpeedFromAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNominalSpeedFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignNominalSpeedFromAsynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign PolePairNumber validation for a AsynchronousMachine
   *
   * @param command AssignPolePairNumberToAsynchronousMachineCommand
   */
  public void validate(AssignPolePairNumberToAsynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignPolePairNumberToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignPolePairNumberToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPolePairNumberToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign PolePairNumber validation for a AsynchronousMachine
   *
   * @param command UnAssignPolePairNumberFromAsynchronousMachineCommand
   */
  public void validate(UnAssignPolePairNumberFromAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignPolePairNumberFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignPolePairNumberFromAsynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign RatedMechanicalPower validation for a AsynchronousMachine
   *
   * @param command AssignRatedMechanicalPowerToAsynchronousMachineCommand
   */
  public void validate(AssignRatedMechanicalPowerToAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignRatedMechanicalPowerToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignRatedMechanicalPowerToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedMechanicalPowerToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign RatedMechanicalPower validation for a AsynchronousMachine
   *
   * @param command UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand
   */
  public void validate(UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign Reversible validation for a AsynchronousMachine
   *
   * @param command AssignReversibleToAsynchronousMachineCommand
   */
  public void validate(AssignReversibleToAsynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignReversibleToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignReversibleToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignReversibleToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign Reversible validation for a AsynchronousMachine
   *
   * @param command UnAssignReversibleFromAsynchronousMachineCommand
   */
  public void validate(UnAssignReversibleFromAsynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignReversibleFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignReversibleFromAsynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign RxLockedRotorRatio validation for a AsynchronousMachine
   *
   * @param command AssignRxLockedRotorRatioToAsynchronousMachineCommand
   */
  public void validate(AssignRxLockedRotorRatioToAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignRxLockedRotorRatioToAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "AssignRxLockedRotorRatioToAsynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRxLockedRotorRatioToAsynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign RxLockedRotorRatio validation for a AsynchronousMachine
   *
   * @param command UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand
   */
  public void validate(UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getAsynchronousMachineId(),
        "UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand identifier should not be null");
  }
}
