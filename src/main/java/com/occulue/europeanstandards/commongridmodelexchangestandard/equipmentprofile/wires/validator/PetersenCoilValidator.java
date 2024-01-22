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

public class PetersenCoilValidator {

  /** default constructor */
  protected PetersenCoilValidator() {}

  /** factory method */
  public static PetersenCoilValidator getInstance() {
    return new PetersenCoilValidator();
  }

  /** handles creation validation for a PetersenCoil */
  public void validate(CreatePetersenCoilCommand petersenCoil) throws Exception {
    Assert.notNull(petersenCoil, "CreatePetersenCoilCommand should not be null");
    //		Assert.isNull( petersenCoil.getPetersenCoilId(), "CreatePetersenCoilCommand identifier
    // should be null" );
  }

  /** handles update validation for a PetersenCoil */
  public void validate(UpdatePetersenCoilCommand petersenCoil) throws Exception {
    Assert.notNull(petersenCoil, "UpdatePetersenCoilCommand should not be null");
    Assert.notNull(
        petersenCoil.getPetersenCoilId(),
        "UpdatePetersenCoilCommand identifier should not be null");
  }

  /** handles delete validation for a PetersenCoil */
  public void validate(DeletePetersenCoilCommand petersenCoil) throws Exception {
    Assert.notNull(petersenCoil, "{commandAlias} should not be null");
    Assert.notNull(
        petersenCoil.getPetersenCoilId(),
        "DeletePetersenCoilCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PetersenCoil */
  public void validate(PetersenCoilFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PetersenCoilFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPetersenCoilId(), "PetersenCoilFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign NominalU validation for a PetersenCoil
   *
   * @param command AssignNominalUToPetersenCoilCommand
   */
  public void validate(AssignNominalUToPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "AssignNominalUToPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "AssignNominalUToPetersenCoilCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNominalUToPetersenCoilCommand assignment should not be null");
  }

  /**
   * handles unassign NominalU validation for a PetersenCoil
   *
   * @param command UnAssignNominalUFromPetersenCoilCommand
   */
  public void validate(UnAssignNominalUFromPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNominalUFromPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "UnAssignNominalUFromPetersenCoilCommand identifier should not be null");
  }
  /**
   * handles assign OffsetCurrent validation for a PetersenCoil
   *
   * @param command AssignOffsetCurrentToPetersenCoilCommand
   */
  public void validate(AssignOffsetCurrentToPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "AssignOffsetCurrentToPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "AssignOffsetCurrentToPetersenCoilCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOffsetCurrentToPetersenCoilCommand assignment should not be null");
  }

  /**
   * handles unassign OffsetCurrent validation for a PetersenCoil
   *
   * @param command UnAssignOffsetCurrentFromPetersenCoilCommand
   */
  public void validate(UnAssignOffsetCurrentFromPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOffsetCurrentFromPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "UnAssignOffsetCurrentFromPetersenCoilCommand identifier should not be null");
  }
  /**
   * handles assign PositionCurrent validation for a PetersenCoil
   *
   * @param command AssignPositionCurrentToPetersenCoilCommand
   */
  public void validate(AssignPositionCurrentToPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "AssignPositionCurrentToPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "AssignPositionCurrentToPetersenCoilCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPositionCurrentToPetersenCoilCommand assignment should not be null");
  }

  /**
   * handles unassign PositionCurrent validation for a PetersenCoil
   *
   * @param command UnAssignPositionCurrentFromPetersenCoilCommand
   */
  public void validate(UnAssignPositionCurrentFromPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPositionCurrentFromPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "UnAssignPositionCurrentFromPetersenCoilCommand identifier should not be null");
  }
  /**
   * handles assign XGroundMax validation for a PetersenCoil
   *
   * @param command AssignXGroundMaxToPetersenCoilCommand
   */
  public void validate(AssignXGroundMaxToPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "AssignXGroundMaxToPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "AssignXGroundMaxToPetersenCoilCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXGroundMaxToPetersenCoilCommand assignment should not be null");
  }

  /**
   * handles unassign XGroundMax validation for a PetersenCoil
   *
   * @param command UnAssignXGroundMaxFromPetersenCoilCommand
   */
  public void validate(UnAssignXGroundMaxFromPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXGroundMaxFromPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "UnAssignXGroundMaxFromPetersenCoilCommand identifier should not be null");
  }
  /**
   * handles assign XGroundMin validation for a PetersenCoil
   *
   * @param command AssignXGroundMinToPetersenCoilCommand
   */
  public void validate(AssignXGroundMinToPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "AssignXGroundMinToPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "AssignXGroundMinToPetersenCoilCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXGroundMinToPetersenCoilCommand assignment should not be null");
  }

  /**
   * handles unassign XGroundMin validation for a PetersenCoil
   *
   * @param command UnAssignXGroundMinFromPetersenCoilCommand
   */
  public void validate(UnAssignXGroundMinFromPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXGroundMinFromPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "UnAssignXGroundMinFromPetersenCoilCommand identifier should not be null");
  }
  /**
   * handles assign XGroundNominal validation for a PetersenCoil
   *
   * @param command AssignXGroundNominalToPetersenCoilCommand
   */
  public void validate(AssignXGroundNominalToPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "AssignXGroundNominalToPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "AssignXGroundNominalToPetersenCoilCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXGroundNominalToPetersenCoilCommand assignment should not be null");
  }

  /**
   * handles unassign XGroundNominal validation for a PetersenCoil
   *
   * @param command UnAssignXGroundNominalFromPetersenCoilCommand
   */
  public void validate(UnAssignXGroundNominalFromPetersenCoilCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXGroundNominalFromPetersenCoilCommand should not be null");
    Assert.notNull(
        command.getPetersenCoilId(),
        "UnAssignXGroundNominalFromPetersenCoilCommand identifier should not be null");
  }
}
