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

public class EnergyConsumerValidator {

  /** default constructor */
  protected EnergyConsumerValidator() {}

  /** factory method */
  public static EnergyConsumerValidator getInstance() {
    return new EnergyConsumerValidator();
  }

  /** handles creation validation for a EnergyConsumer */
  public void validate(CreateEnergyConsumerCommand energyConsumer) throws Exception {
    Assert.notNull(energyConsumer, "CreateEnergyConsumerCommand should not be null");
    //		Assert.isNull( energyConsumer.getEnergyConsumerId(), "CreateEnergyConsumerCommand identifier
    // should be null" );
  }

  /** handles update validation for a EnergyConsumer */
  public void validate(UpdateEnergyConsumerCommand energyConsumer) throws Exception {
    Assert.notNull(energyConsumer, "UpdateEnergyConsumerCommand should not be null");
    Assert.notNull(
        energyConsumer.getEnergyConsumerId(),
        "UpdateEnergyConsumerCommand identifier should not be null");
  }

  /** handles delete validation for a EnergyConsumer */
  public void validate(DeleteEnergyConsumerCommand energyConsumer) throws Exception {
    Assert.notNull(energyConsumer, "{commandAlias} should not be null");
    Assert.notNull(
        energyConsumer.getEnergyConsumerId(),
        "DeleteEnergyConsumerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EnergyConsumer */
  public void validate(EnergyConsumerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EnergyConsumerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEnergyConsumerId(),
        "EnergyConsumerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Pfixed validation for a EnergyConsumer
   *
   * @param command AssignPfixedToEnergyConsumerCommand
   */
  public void validate(AssignPfixedToEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "AssignPfixedToEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "AssignPfixedToEnergyConsumerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPfixedToEnergyConsumerCommand assignment should not be null");
  }

  /**
   * handles unassign Pfixed validation for a EnergyConsumer
   *
   * @param command UnAssignPfixedFromEnergyConsumerCommand
   */
  public void validate(UnAssignPfixedFromEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPfixedFromEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "UnAssignPfixedFromEnergyConsumerCommand identifier should not be null");
  }
  /**
   * handles assign PfixedPct validation for a EnergyConsumer
   *
   * @param command AssignPfixedPctToEnergyConsumerCommand
   */
  public void validate(AssignPfixedPctToEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "AssignPfixedPctToEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "AssignPfixedPctToEnergyConsumerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPfixedPctToEnergyConsumerCommand assignment should not be null");
  }

  /**
   * handles unassign PfixedPct validation for a EnergyConsumer
   *
   * @param command UnAssignPfixedPctFromEnergyConsumerCommand
   */
  public void validate(UnAssignPfixedPctFromEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPfixedPctFromEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "UnAssignPfixedPctFromEnergyConsumerCommand identifier should not be null");
  }
  /**
   * handles assign Qfixed validation for a EnergyConsumer
   *
   * @param command AssignQfixedToEnergyConsumerCommand
   */
  public void validate(AssignQfixedToEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "AssignQfixedToEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "AssignQfixedToEnergyConsumerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQfixedToEnergyConsumerCommand assignment should not be null");
  }

  /**
   * handles unassign Qfixed validation for a EnergyConsumer
   *
   * @param command UnAssignQfixedFromEnergyConsumerCommand
   */
  public void validate(UnAssignQfixedFromEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQfixedFromEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "UnAssignQfixedFromEnergyConsumerCommand identifier should not be null");
  }
  /**
   * handles assign QfixedPct validation for a EnergyConsumer
   *
   * @param command AssignQfixedPctToEnergyConsumerCommand
   */
  public void validate(AssignQfixedPctToEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "AssignQfixedPctToEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "AssignQfixedPctToEnergyConsumerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQfixedPctToEnergyConsumerCommand assignment should not be null");
  }

  /**
   * handles unassign QfixedPct validation for a EnergyConsumer
   *
   * @param command UnAssignQfixedPctFromEnergyConsumerCommand
   */
  public void validate(UnAssignQfixedPctFromEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQfixedPctFromEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "UnAssignQfixedPctFromEnergyConsumerCommand identifier should not be null");
  }

  /**
   * handles add to EnergyConsumer validation for a EnergyConsumer
   *
   * @param command AssignEnergyConsumerToEnergyConsumerCommand
   */
  public void validate(AssignEnergyConsumerToEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "AssignEnergyConsumerToEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "AssignEnergyConsumerToEnergyConsumerCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignEnergyConsumerToEnergyConsumerCommand addTo attribute should not be null");
  }

  /**
   * handles remove from EnergyConsumer validation for a EnergyConsumer
   *
   * @param command RemoveEnergyConsumerFromEnergyConsumerCommand
   */
  public void validate(RemoveEnergyConsumerFromEnergyConsumerCommand command) throws Exception {
    Assert.notNull(command, "RemoveEnergyConsumerFromEnergyConsumerCommand should not be null");
    Assert.notNull(
        command.getEnergyConsumerId(),
        "RemoveEnergyConsumerFromEnergyConsumerCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveEnergyConsumerFromEnergyConsumerCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getEnergyConsumerId(),
        "RemoveEnergyConsumerFromEnergyConsumerCommand removeFrom attribubte identifier should not be null");
  }
}
