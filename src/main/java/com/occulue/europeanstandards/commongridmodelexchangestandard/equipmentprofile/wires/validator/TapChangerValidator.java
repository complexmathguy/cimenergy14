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

public class TapChangerValidator {

  /** default constructor */
  protected TapChangerValidator() {}

  /** factory method */
  public static TapChangerValidator getInstance() {
    return new TapChangerValidator();
  }

  /** handles creation validation for a TapChanger */
  public void validate(CreateTapChangerCommand tapChanger) throws Exception {
    Assert.notNull(tapChanger, "CreateTapChangerCommand should not be null");
    //		Assert.isNull( tapChanger.getTapChangerId(), "CreateTapChangerCommand identifier should be
    // null" );
  }

  /** handles update validation for a TapChanger */
  public void validate(UpdateTapChangerCommand tapChanger) throws Exception {
    Assert.notNull(tapChanger, "UpdateTapChangerCommand should not be null");
    Assert.notNull(
        tapChanger.getTapChangerId(), "UpdateTapChangerCommand identifier should not be null");
  }

  /** handles delete validation for a TapChanger */
  public void validate(DeleteTapChangerCommand tapChanger) throws Exception {
    Assert.notNull(tapChanger, "{commandAlias} should not be null");
    Assert.notNull(
        tapChanger.getTapChangerId(), "DeleteTapChangerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TapChanger */
  public void validate(TapChangerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TapChangerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTapChangerId(), "TapChangerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign HighStep validation for a TapChanger
   *
   * @param command AssignHighStepToTapChangerCommand
   */
  public void validate(AssignHighStepToTapChangerCommand command) throws Exception {
    Assert.notNull(command, "AssignHighStepToTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "AssignHighStepToTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHighStepToTapChangerCommand assignment should not be null");
  }

  /**
   * handles unassign HighStep validation for a TapChanger
   *
   * @param command UnAssignHighStepFromTapChangerCommand
   */
  public void validate(UnAssignHighStepFromTapChangerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHighStepFromTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "UnAssignHighStepFromTapChangerCommand identifier should not be null");
  }
  /**
   * handles assign LowStep validation for a TapChanger
   *
   * @param command AssignLowStepToTapChangerCommand
   */
  public void validate(AssignLowStepToTapChangerCommand command) throws Exception {
    Assert.notNull(command, "AssignLowStepToTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "AssignLowStepToTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLowStepToTapChangerCommand assignment should not be null");
  }

  /**
   * handles unassign LowStep validation for a TapChanger
   *
   * @param command UnAssignLowStepFromTapChangerCommand
   */
  public void validate(UnAssignLowStepFromTapChangerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLowStepFromTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "UnAssignLowStepFromTapChangerCommand identifier should not be null");
  }
  /**
   * handles assign LtcFlag validation for a TapChanger
   *
   * @param command AssignLtcFlagToTapChangerCommand
   */
  public void validate(AssignLtcFlagToTapChangerCommand command) throws Exception {
    Assert.notNull(command, "AssignLtcFlagToTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "AssignLtcFlagToTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLtcFlagToTapChangerCommand assignment should not be null");
  }

  /**
   * handles unassign LtcFlag validation for a TapChanger
   *
   * @param command UnAssignLtcFlagFromTapChangerCommand
   */
  public void validate(UnAssignLtcFlagFromTapChangerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLtcFlagFromTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "UnAssignLtcFlagFromTapChangerCommand identifier should not be null");
  }
  /**
   * handles assign NeutralStep validation for a TapChanger
   *
   * @param command AssignNeutralStepToTapChangerCommand
   */
  public void validate(AssignNeutralStepToTapChangerCommand command) throws Exception {
    Assert.notNull(command, "AssignNeutralStepToTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "AssignNeutralStepToTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNeutralStepToTapChangerCommand assignment should not be null");
  }

  /**
   * handles unassign NeutralStep validation for a TapChanger
   *
   * @param command UnAssignNeutralStepFromTapChangerCommand
   */
  public void validate(UnAssignNeutralStepFromTapChangerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNeutralStepFromTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "UnAssignNeutralStepFromTapChangerCommand identifier should not be null");
  }
  /**
   * handles assign NeutralU validation for a TapChanger
   *
   * @param command AssignNeutralUToTapChangerCommand
   */
  public void validate(AssignNeutralUToTapChangerCommand command) throws Exception {
    Assert.notNull(command, "AssignNeutralUToTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "AssignNeutralUToTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignNeutralUToTapChangerCommand assignment should not be null");
  }

  /**
   * handles unassign NeutralU validation for a TapChanger
   *
   * @param command UnAssignNeutralUFromTapChangerCommand
   */
  public void validate(UnAssignNeutralUFromTapChangerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNeutralUFromTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "UnAssignNeutralUFromTapChangerCommand identifier should not be null");
  }
  /**
   * handles assign NormalStep validation for a TapChanger
   *
   * @param command AssignNormalStepToTapChangerCommand
   */
  public void validate(AssignNormalStepToTapChangerCommand command) throws Exception {
    Assert.notNull(command, "AssignNormalStepToTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "AssignNormalStepToTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNormalStepToTapChangerCommand assignment should not be null");
  }

  /**
   * handles unassign NormalStep validation for a TapChanger
   *
   * @param command UnAssignNormalStepFromTapChangerCommand
   */
  public void validate(UnAssignNormalStepFromTapChangerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNormalStepFromTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "UnAssignNormalStepFromTapChangerCommand identifier should not be null");
  }

  /**
   * handles add to TapChanger validation for a TapChanger
   *
   * @param command AssignTapChangerToTapChangerCommand
   */
  public void validate(AssignTapChangerToTapChangerCommand command) throws Exception {
    Assert.notNull(command, "AssignTapChangerToTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "AssignTapChangerToTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignTapChangerToTapChangerCommand addTo attribute should not be null");
  }

  /**
   * handles remove from TapChanger validation for a TapChanger
   *
   * @param command RemoveTapChangerFromTapChangerCommand
   */
  public void validate(RemoveTapChangerFromTapChangerCommand command) throws Exception {
    Assert.notNull(command, "RemoveTapChangerFromTapChangerCommand should not be null");
    Assert.notNull(
        command.getTapChangerId(),
        "RemoveTapChangerFromTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTapChangerFromTapChangerCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getTapChangerId(),
        "RemoveTapChangerFromTapChangerCommand removeFrom attribubte identifier should not be null");
  }
}
