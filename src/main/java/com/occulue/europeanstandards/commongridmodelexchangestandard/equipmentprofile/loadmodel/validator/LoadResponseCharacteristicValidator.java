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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class LoadResponseCharacteristicValidator {

  /** default constructor */
  protected LoadResponseCharacteristicValidator() {}

  /** factory method */
  public static LoadResponseCharacteristicValidator getInstance() {
    return new LoadResponseCharacteristicValidator();
  }

  /** handles creation validation for a LoadResponseCharacteristic */
  public void validate(CreateLoadResponseCharacteristicCommand loadResponseCharacteristic)
      throws Exception {
    Assert.notNull(
        loadResponseCharacteristic, "CreateLoadResponseCharacteristicCommand should not be null");
    //		Assert.isNull( loadResponseCharacteristic.getLoadResponseCharacteristicId(),
    // "CreateLoadResponseCharacteristicCommand identifier should be null" );
  }

  /** handles update validation for a LoadResponseCharacteristic */
  public void validate(UpdateLoadResponseCharacteristicCommand loadResponseCharacteristic)
      throws Exception {
    Assert.notNull(
        loadResponseCharacteristic, "UpdateLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        loadResponseCharacteristic.getLoadResponseCharacteristicId(),
        "UpdateLoadResponseCharacteristicCommand identifier should not be null");
  }

  /** handles delete validation for a LoadResponseCharacteristic */
  public void validate(DeleteLoadResponseCharacteristicCommand loadResponseCharacteristic)
      throws Exception {
    Assert.notNull(loadResponseCharacteristic, "{commandAlias} should not be null");
    Assert.notNull(
        loadResponseCharacteristic.getLoadResponseCharacteristicId(),
        "DeleteLoadResponseCharacteristicCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LoadResponseCharacteristic */
  public void validate(LoadResponseCharacteristicFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LoadResponseCharacteristicFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLoadResponseCharacteristicId(),
        "LoadResponseCharacteristicFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign ExponentModel validation for a LoadResponseCharacteristic
   *
   * @param command AssignExponentModelToLoadResponseCharacteristicCommand
   */
  public void validate(AssignExponentModelToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignExponentModelToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignExponentModelToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignExponentModelToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign ExponentModel validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignExponentModelFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignExponentModelFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignExponentModelFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignExponentModelFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign PConstantCurrent validation for a LoadResponseCharacteristic
   *
   * @param command AssignPConstantCurrentToLoadResponseCharacteristicCommand
   */
  public void validate(AssignPConstantCurrentToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignPConstantCurrentToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignPConstantCurrentToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPConstantCurrentToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign PConstantCurrent validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign PConstantImpedance validation for a LoadResponseCharacteristic
   *
   * @param command AssignPConstantImpedanceToLoadResponseCharacteristicCommand
   */
  public void validate(AssignPConstantImpedanceToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignPConstantImpedanceToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignPConstantImpedanceToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPConstantImpedanceToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign PConstantImpedance validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign PConstantPower validation for a LoadResponseCharacteristic
   *
   * @param command AssignPConstantPowerToLoadResponseCharacteristicCommand
   */
  public void validate(AssignPConstantPowerToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignPConstantPowerToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignPConstantPowerToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPConstantPowerToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign PConstantPower validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantPowerFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignPConstantPowerFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignPConstantPowerFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignPConstantPowerFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign PFrequencyExponent validation for a LoadResponseCharacteristic
   *
   * @param command AssignPFrequencyExponentToLoadResponseCharacteristicCommand
   */
  public void validate(AssignPFrequencyExponentToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignPFrequencyExponentToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignPFrequencyExponentToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPFrequencyExponentToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign PFrequencyExponent validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign PVoltageExponent validation for a LoadResponseCharacteristic
   *
   * @param command AssignPVoltageExponentToLoadResponseCharacteristicCommand
   */
  public void validate(AssignPVoltageExponentToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignPVoltageExponentToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignPVoltageExponentToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPVoltageExponentToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign PVoltageExponent validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign QConstantCurrent validation for a LoadResponseCharacteristic
   *
   * @param command AssignQConstantCurrentToLoadResponseCharacteristicCommand
   */
  public void validate(AssignQConstantCurrentToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignQConstantCurrentToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignQConstantCurrentToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQConstantCurrentToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign QConstantCurrent validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign QConstantImpedance validation for a LoadResponseCharacteristic
   *
   * @param command AssignQConstantImpedanceToLoadResponseCharacteristicCommand
   */
  public void validate(AssignQConstantImpedanceToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignQConstantImpedanceToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignQConstantImpedanceToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQConstantImpedanceToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign QConstantImpedance validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign QConstantPower validation for a LoadResponseCharacteristic
   *
   * @param command AssignQConstantPowerToLoadResponseCharacteristicCommand
   */
  public void validate(AssignQConstantPowerToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignQConstantPowerToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignQConstantPowerToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQConstantPowerToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign QConstantPower validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantPowerFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignQConstantPowerFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignQConstantPowerFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignQConstantPowerFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign QFrequencyExponent validation for a LoadResponseCharacteristic
   *
   * @param command AssignQFrequencyExponentToLoadResponseCharacteristicCommand
   */
  public void validate(AssignQFrequencyExponentToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignQFrequencyExponentToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignQFrequencyExponentToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQFrequencyExponentToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign QFrequencyExponent validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand identifier should not be null");
  }
  /**
   * handles assign QVoltageExponent validation for a LoadResponseCharacteristic
   *
   * @param command AssignQVoltageExponentToLoadResponseCharacteristicCommand
   */
  public void validate(AssignQVoltageExponentToLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignQVoltageExponentToLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "AssignQVoltageExponentToLoadResponseCharacteristicCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQVoltageExponentToLoadResponseCharacteristicCommand assignment should not be null");
  }

  /**
   * handles unassign QVoltageExponent validation for a LoadResponseCharacteristic
   *
   * @param command UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand
   */
  public void validate(UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand should not be null");
    Assert.notNull(
        command.getLoadResponseCharacteristicId(),
        "UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand identifier should not be null");
  }
}
