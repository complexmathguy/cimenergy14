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

public class TapChangerTablePointValidator {

  /** default constructor */
  protected TapChangerTablePointValidator() {}

  /** factory method */
  public static TapChangerTablePointValidator getInstance() {
    return new TapChangerTablePointValidator();
  }

  /** handles creation validation for a TapChangerTablePoint */
  public void validate(CreateTapChangerTablePointCommand tapChangerTablePoint) throws Exception {
    Assert.notNull(tapChangerTablePoint, "CreateTapChangerTablePointCommand should not be null");
    //		Assert.isNull( tapChangerTablePoint.getTapChangerTablePointId(),
    // "CreateTapChangerTablePointCommand identifier should be null" );
  }

  /** handles update validation for a TapChangerTablePoint */
  public void validate(UpdateTapChangerTablePointCommand tapChangerTablePoint) throws Exception {
    Assert.notNull(tapChangerTablePoint, "UpdateTapChangerTablePointCommand should not be null");
    Assert.notNull(
        tapChangerTablePoint.getTapChangerTablePointId(),
        "UpdateTapChangerTablePointCommand identifier should not be null");
  }

  /** handles delete validation for a TapChangerTablePoint */
  public void validate(DeleteTapChangerTablePointCommand tapChangerTablePoint) throws Exception {
    Assert.notNull(tapChangerTablePoint, "{commandAlias} should not be null");
    Assert.notNull(
        tapChangerTablePoint.getTapChangerTablePointId(),
        "DeleteTapChangerTablePointCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TapChangerTablePoint */
  public void validate(TapChangerTablePointFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TapChangerTablePointFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTapChangerTablePointId(),
        "TapChangerTablePointFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign B validation for a TapChangerTablePoint
   *
   * @param command AssignBToTapChangerTablePointCommand
   */
  public void validate(AssignBToTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "AssignBToTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "AssignBToTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBToTapChangerTablePointCommand assignment should not be null");
  }

  /**
   * handles unassign B validation for a TapChangerTablePoint
   *
   * @param command UnAssignBFromTapChangerTablePointCommand
   */
  public void validate(UnAssignBFromTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBFromTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "UnAssignBFromTapChangerTablePointCommand identifier should not be null");
  }
  /**
   * handles assign G validation for a TapChangerTablePoint
   *
   * @param command AssignGToTapChangerTablePointCommand
   */
  public void validate(AssignGToTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "AssignGToTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "AssignGToTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignGToTapChangerTablePointCommand assignment should not be null");
  }

  /**
   * handles unassign G validation for a TapChangerTablePoint
   *
   * @param command UnAssignGFromTapChangerTablePointCommand
   */
  public void validate(UnAssignGFromTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGFromTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "UnAssignGFromTapChangerTablePointCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a TapChangerTablePoint
   *
   * @param command AssignRToTapChangerTablePointCommand
   */
  public void validate(AssignRToTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "AssignRToTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "AssignRToTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRToTapChangerTablePointCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a TapChangerTablePoint
   *
   * @param command UnAssignRFromTapChangerTablePointCommand
   */
  public void validate(UnAssignRFromTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "UnAssignRFromTapChangerTablePointCommand identifier should not be null");
  }
  /**
   * handles assign Ratio validation for a TapChangerTablePoint
   *
   * @param command AssignRatioToTapChangerTablePointCommand
   */
  public void validate(AssignRatioToTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "AssignRatioToTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "AssignRatioToTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatioToTapChangerTablePointCommand assignment should not be null");
  }

  /**
   * handles unassign Ratio validation for a TapChangerTablePoint
   *
   * @param command UnAssignRatioFromTapChangerTablePointCommand
   */
  public void validate(UnAssignRatioFromTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatioFromTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "UnAssignRatioFromTapChangerTablePointCommand identifier should not be null");
  }
  /**
   * handles assign Step validation for a TapChangerTablePoint
   *
   * @param command AssignStepToTapChangerTablePointCommand
   */
  public void validate(AssignStepToTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "AssignStepToTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "AssignStepToTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStepToTapChangerTablePointCommand assignment should not be null");
  }

  /**
   * handles unassign Step validation for a TapChangerTablePoint
   *
   * @param command UnAssignStepFromTapChangerTablePointCommand
   */
  public void validate(UnAssignStepFromTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignStepFromTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "UnAssignStepFromTapChangerTablePointCommand identifier should not be null");
  }
  /**
   * handles assign X validation for a TapChangerTablePoint
   *
   * @param command AssignXToTapChangerTablePointCommand
   */
  public void validate(AssignXToTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "AssignXToTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "AssignXToTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXToTapChangerTablePointCommand assignment should not be null");
  }

  /**
   * handles unassign X validation for a TapChangerTablePoint
   *
   * @param command UnAssignXFromTapChangerTablePointCommand
   */
  public void validate(UnAssignXFromTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXFromTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getTapChangerTablePointId(),
        "UnAssignXFromTapChangerTablePointCommand identifier should not be null");
  }
}
