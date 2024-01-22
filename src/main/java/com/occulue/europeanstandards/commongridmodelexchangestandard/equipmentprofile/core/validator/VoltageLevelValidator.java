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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VoltageLevelValidator {

  /** default constructor */
  protected VoltageLevelValidator() {}

  /** factory method */
  public static VoltageLevelValidator getInstance() {
    return new VoltageLevelValidator();
  }

  /** handles creation validation for a VoltageLevel */
  public void validate(CreateVoltageLevelCommand voltageLevel) throws Exception {
    Assert.notNull(voltageLevel, "CreateVoltageLevelCommand should not be null");
    //		Assert.isNull( voltageLevel.getVoltageLevelId(), "CreateVoltageLevelCommand identifier
    // should be null" );
  }

  /** handles update validation for a VoltageLevel */
  public void validate(UpdateVoltageLevelCommand voltageLevel) throws Exception {
    Assert.notNull(voltageLevel, "UpdateVoltageLevelCommand should not be null");
    Assert.notNull(
        voltageLevel.getVoltageLevelId(),
        "UpdateVoltageLevelCommand identifier should not be null");
  }

  /** handles delete validation for a VoltageLevel */
  public void validate(DeleteVoltageLevelCommand voltageLevel) throws Exception {
    Assert.notNull(voltageLevel, "{commandAlias} should not be null");
    Assert.notNull(
        voltageLevel.getVoltageLevelId(),
        "DeleteVoltageLevelCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VoltageLevel */
  public void validate(VoltageLevelFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VoltageLevelFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVoltageLevelId(), "VoltageLevelFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign HighVoltageLimit validation for a VoltageLevel
   *
   * @param command AssignHighVoltageLimitToVoltageLevelCommand
   */
  public void validate(AssignHighVoltageLimitToVoltageLevelCommand command) throws Exception {
    Assert.notNull(command, "AssignHighVoltageLimitToVoltageLevelCommand should not be null");
    Assert.notNull(
        command.getVoltageLevelId(),
        "AssignHighVoltageLimitToVoltageLevelCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignHighVoltageLimitToVoltageLevelCommand assignment should not be null");
  }

  /**
   * handles unassign HighVoltageLimit validation for a VoltageLevel
   *
   * @param command UnAssignHighVoltageLimitFromVoltageLevelCommand
   */
  public void validate(UnAssignHighVoltageLimitFromVoltageLevelCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHighVoltageLimitFromVoltageLevelCommand should not be null");
    Assert.notNull(
        command.getVoltageLevelId(),
        "UnAssignHighVoltageLimitFromVoltageLevelCommand identifier should not be null");
  }
  /**
   * handles assign LowVoltageLimit validation for a VoltageLevel
   *
   * @param command AssignLowVoltageLimitToVoltageLevelCommand
   */
  public void validate(AssignLowVoltageLimitToVoltageLevelCommand command) throws Exception {
    Assert.notNull(command, "AssignLowVoltageLimitToVoltageLevelCommand should not be null");
    Assert.notNull(
        command.getVoltageLevelId(),
        "AssignLowVoltageLimitToVoltageLevelCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignLowVoltageLimitToVoltageLevelCommand assignment should not be null");
  }

  /**
   * handles unassign LowVoltageLimit validation for a VoltageLevel
   *
   * @param command UnAssignLowVoltageLimitFromVoltageLevelCommand
   */
  public void validate(UnAssignLowVoltageLimitFromVoltageLevelCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLowVoltageLimitFromVoltageLevelCommand should not be null");
    Assert.notNull(
        command.getVoltageLevelId(),
        "UnAssignLowVoltageLimitFromVoltageLevelCommand identifier should not be null");
  }

  /**
   * handles add to VoltageLevel validation for a VoltageLevel
   *
   * @param command AssignVoltageLevelToVoltageLevelCommand
   */
  public void validate(AssignVoltageLevelToVoltageLevelCommand command) throws Exception {
    Assert.notNull(command, "AssignVoltageLevelToVoltageLevelCommand should not be null");
    Assert.notNull(
        command.getVoltageLevelId(),
        "AssignVoltageLevelToVoltageLevelCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignVoltageLevelToVoltageLevelCommand addTo attribute should not be null");
  }

  /**
   * handles remove from VoltageLevel validation for a VoltageLevel
   *
   * @param command RemoveVoltageLevelFromVoltageLevelCommand
   */
  public void validate(RemoveVoltageLevelFromVoltageLevelCommand command) throws Exception {
    Assert.notNull(command, "RemoveVoltageLevelFromVoltageLevelCommand should not be null");
    Assert.notNull(
        command.getVoltageLevelId(),
        "RemoveVoltageLevelFromVoltageLevelCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveVoltageLevelFromVoltageLevelCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getVoltageLevelId(),
        "RemoveVoltageLevelFromVoltageLevelCommand removeFrom attribubte identifier should not be null");
  }

  /**
   * handles add to VoltageLevels validation for a VoltageLevel
   *
   * @param command AssignVoltageLevelsToVoltageLevelCommand
   */
  public void validate(AssignVoltageLevelsToVoltageLevelCommand command) throws Exception {
    Assert.notNull(command, "AssignVoltageLevelsToVoltageLevelCommand should not be null");
    Assert.notNull(
        command.getVoltageLevelId(),
        "AssignVoltageLevelsToVoltageLevelCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignVoltageLevelsToVoltageLevelCommand addTo attribute should not be null");
  }

  /**
   * handles remove from VoltageLevels validation for a VoltageLevel
   *
   * @param command RemoveVoltageLevelsFromVoltageLevelCommand
   */
  public void validate(RemoveVoltageLevelsFromVoltageLevelCommand command) throws Exception {
    Assert.notNull(command, "RemoveVoltageLevelsFromVoltageLevelCommand should not be null");
    Assert.notNull(
        command.getVoltageLevelId(),
        "RemoveVoltageLevelsFromVoltageLevelCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveVoltageLevelsFromVoltageLevelCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getVoltageLevelId(),
        "RemoveVoltageLevelsFromVoltageLevelCommand removeFrom attribubte identifier should not be null");
  }
}
