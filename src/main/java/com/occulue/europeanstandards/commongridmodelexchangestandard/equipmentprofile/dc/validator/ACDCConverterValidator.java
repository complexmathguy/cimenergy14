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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ACDCConverterValidator {

  /** default constructor */
  protected ACDCConverterValidator() {}

  /** factory method */
  public static ACDCConverterValidator getInstance() {
    return new ACDCConverterValidator();
  }

  /** handles creation validation for a ACDCConverter */
  public void validate(CreateACDCConverterCommand aCDCConverter) throws Exception {
    Assert.notNull(aCDCConverter, "CreateACDCConverterCommand should not be null");
    //		Assert.isNull( aCDCConverter.getACDCConverterId(), "CreateACDCConverterCommand identifier
    // should be null" );
  }

  /** handles update validation for a ACDCConverter */
  public void validate(UpdateACDCConverterCommand aCDCConverter) throws Exception {
    Assert.notNull(aCDCConverter, "UpdateACDCConverterCommand should not be null");
    Assert.notNull(
        aCDCConverter.getACDCConverterId(),
        "UpdateACDCConverterCommand identifier should not be null");
  }

  /** handles delete validation for a ACDCConverter */
  public void validate(DeleteACDCConverterCommand aCDCConverter) throws Exception {
    Assert.notNull(aCDCConverter, "{commandAlias} should not be null");
    Assert.notNull(
        aCDCConverter.getACDCConverterId(),
        "DeleteACDCConverterCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ACDCConverter */
  public void validate(ACDCConverterFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ACDCConverterFetchOneSummary should not be null");
    Assert.notNull(
        summary.getACDCConverterId(), "ACDCConverterFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseS validation for a ACDCConverter
   *
   * @param command AssignBaseSToACDCConverterCommand
   */
  public void validate(AssignBaseSToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseSToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignBaseSToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBaseSToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign BaseS validation for a ACDCConverter
   *
   * @param command UnAssignBaseSFromACDCConverterCommand
   */
  public void validate(UnAssignBaseSFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseSFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignBaseSFromACDCConverterCommand identifier should not be null");
  }
  /**
   * handles assign IdleLoss validation for a ACDCConverter
   *
   * @param command AssignIdleLossToACDCConverterCommand
   */
  public void validate(AssignIdleLossToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignIdleLossToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignIdleLossToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignIdleLossToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign IdleLoss validation for a ACDCConverter
   *
   * @param command UnAssignIdleLossFromACDCConverterCommand
   */
  public void validate(UnAssignIdleLossFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIdleLossFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignIdleLossFromACDCConverterCommand identifier should not be null");
  }
  /**
   * handles assign MaxUdc validation for a ACDCConverter
   *
   * @param command AssignMaxUdcToACDCConverterCommand
   */
  public void validate(AssignMaxUdcToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxUdcToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignMaxUdcToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxUdcToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MaxUdc validation for a ACDCConverter
   *
   * @param command UnAssignMaxUdcFromACDCConverterCommand
   */
  public void validate(UnAssignMaxUdcFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxUdcFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignMaxUdcFromACDCConverterCommand identifier should not be null");
  }
  /**
   * handles assign MinUdc validation for a ACDCConverter
   *
   * @param command AssignMinUdcToACDCConverterCommand
   */
  public void validate(AssignMinUdcToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMinUdcToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignMinUdcToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinUdcToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MinUdc validation for a ACDCConverter
   *
   * @param command UnAssignMinUdcFromACDCConverterCommand
   */
  public void validate(UnAssignMinUdcFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinUdcFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignMinUdcFromACDCConverterCommand identifier should not be null");
  }
  /**
   * handles assign NumberOfValves validation for a ACDCConverter
   *
   * @param command AssignNumberOfValvesToACDCConverterCommand
   */
  public void validate(AssignNumberOfValvesToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignNumberOfValvesToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignNumberOfValvesToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNumberOfValvesToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign NumberOfValves validation for a ACDCConverter
   *
   * @param command UnAssignNumberOfValvesFromACDCConverterCommand
   */
  public void validate(UnAssignNumberOfValvesFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNumberOfValvesFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignNumberOfValvesFromACDCConverterCommand identifier should not be null");
  }
  /**
   * handles assign RatedUdc validation for a ACDCConverter
   *
   * @param command AssignRatedUdcToACDCConverterCommand
   */
  public void validate(AssignRatedUdcToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedUdcToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignRatedUdcToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedUdcToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign RatedUdc validation for a ACDCConverter
   *
   * @param command UnAssignRatedUdcFromACDCConverterCommand
   */
  public void validate(UnAssignRatedUdcFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedUdcFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignRatedUdcFromACDCConverterCommand identifier should not be null");
  }
  /**
   * handles assign ResistiveLoss validation for a ACDCConverter
   *
   * @param command AssignResistiveLossToACDCConverterCommand
   */
  public void validate(AssignResistiveLossToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignResistiveLossToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignResistiveLossToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignResistiveLossToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign ResistiveLoss validation for a ACDCConverter
   *
   * @param command UnAssignResistiveLossFromACDCConverterCommand
   */
  public void validate(UnAssignResistiveLossFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignResistiveLossFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignResistiveLossFromACDCConverterCommand identifier should not be null");
  }
  /**
   * handles assign SwitchingLoss validation for a ACDCConverter
   *
   * @param command AssignSwitchingLossToACDCConverterCommand
   */
  public void validate(AssignSwitchingLossToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignSwitchingLossToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignSwitchingLossToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSwitchingLossToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign SwitchingLoss validation for a ACDCConverter
   *
   * @param command UnAssignSwitchingLossFromACDCConverterCommand
   */
  public void validate(UnAssignSwitchingLossFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSwitchingLossFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignSwitchingLossFromACDCConverterCommand identifier should not be null");
  }
  /**
   * handles assign ValveU0 validation for a ACDCConverter
   *
   * @param command AssignValveU0ToACDCConverterCommand
   */
  public void validate(AssignValveU0ToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignValveU0ToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignValveU0ToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValveU0ToACDCConverterCommand assignment should not be null");
  }

  /**
   * handles unassign ValveU0 validation for a ACDCConverter
   *
   * @param command UnAssignValveU0FromACDCConverterCommand
   */
  public void validate(UnAssignValveU0FromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValveU0FromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "UnAssignValveU0FromACDCConverterCommand identifier should not be null");
  }

  /**
   * handles add to ConverterDCSides validation for a ACDCConverter
   *
   * @param command AssignConverterDCSidesToACDCConverterCommand
   */
  public void validate(AssignConverterDCSidesToACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignConverterDCSidesToACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "AssignConverterDCSidesToACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignConverterDCSidesToACDCConverterCommand addTo attribute should not be null");
  }

  /**
   * handles remove from ConverterDCSides validation for a ACDCConverter
   *
   * @param command RemoveConverterDCSidesFromACDCConverterCommand
   */
  public void validate(RemoveConverterDCSidesFromACDCConverterCommand command) throws Exception {
    Assert.notNull(command, "RemoveConverterDCSidesFromACDCConverterCommand should not be null");
    Assert.notNull(
        command.getACDCConverterId(),
        "RemoveConverterDCSidesFromACDCConverterCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveConverterDCSidesFromACDCConverterCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getACDCConverterId(),
        "RemoveConverterDCSidesFromACDCConverterCommand removeFrom attribubte identifier should not be null");
  }
}
