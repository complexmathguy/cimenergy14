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

public class VsConverterValidator {

  /** default constructor */
  protected VsConverterValidator() {}

  /** factory method */
  public static VsConverterValidator getInstance() {
    return new VsConverterValidator();
  }

  /** handles creation validation for a VsConverter */
  public void validate(CreateVsConverterCommand vsConverter) throws Exception {
    Assert.notNull(vsConverter, "CreateVsConverterCommand should not be null");
    //		Assert.isNull( vsConverter.getVsConverterId(), "CreateVsConverterCommand identifier should
    // be null" );
  }

  /** handles update validation for a VsConverter */
  public void validate(UpdateVsConverterCommand vsConverter) throws Exception {
    Assert.notNull(vsConverter, "UpdateVsConverterCommand should not be null");
    Assert.notNull(
        vsConverter.getVsConverterId(), "UpdateVsConverterCommand identifier should not be null");
  }

  /** handles delete validation for a VsConverter */
  public void validate(DeleteVsConverterCommand vsConverter) throws Exception {
    Assert.notNull(vsConverter, "{commandAlias} should not be null");
    Assert.notNull(
        vsConverter.getVsConverterId(), "DeleteVsConverterCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VsConverter */
  public void validate(VsConverterFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VsConverterFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVsConverterId(), "VsConverterFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign MaxModulationIndex validation for a VsConverter
   *
   * @param command AssignMaxModulationIndexToVsConverterCommand
   */
  public void validate(AssignMaxModulationIndexToVsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxModulationIndexToVsConverterCommand should not be null");
    Assert.notNull(
        command.getVsConverterId(),
        "AssignMaxModulationIndexToVsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxModulationIndexToVsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MaxModulationIndex validation for a VsConverter
   *
   * @param command UnAssignMaxModulationIndexFromVsConverterCommand
   */
  public void validate(UnAssignMaxModulationIndexFromVsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxModulationIndexFromVsConverterCommand should not be null");
    Assert.notNull(
        command.getVsConverterId(),
        "UnAssignMaxModulationIndexFromVsConverterCommand identifier should not be null");
  }
  /**
   * handles assign MaxValveCurrent validation for a VsConverter
   *
   * @param command AssignMaxValveCurrentToVsConverterCommand
   */
  public void validate(AssignMaxValveCurrentToVsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxValveCurrentToVsConverterCommand should not be null");
    Assert.notNull(
        command.getVsConverterId(),
        "AssignMaxValveCurrentToVsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxValveCurrentToVsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MaxValveCurrent validation for a VsConverter
   *
   * @param command UnAssignMaxValveCurrentFromVsConverterCommand
   */
  public void validate(UnAssignMaxValveCurrentFromVsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxValveCurrentFromVsConverterCommand should not be null");
    Assert.notNull(
        command.getVsConverterId(),
        "UnAssignMaxValveCurrentFromVsConverterCommand identifier should not be null");
  }

  /**
   * handles add to VsConverterDCSides validation for a VsConverter
   *
   * @param command AssignVsConverterDCSidesToVsConverterCommand
   */
  public void validate(AssignVsConverterDCSidesToVsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignVsConverterDCSidesToVsConverterCommand should not be null");
    Assert.notNull(
        command.getVsConverterId(),
        "AssignVsConverterDCSidesToVsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignVsConverterDCSidesToVsConverterCommand addTo attribute should not be null");
  }

  /**
   * handles remove from VsConverterDCSides validation for a VsConverter
   *
   * @param command RemoveVsConverterDCSidesFromVsConverterCommand
   */
  public void validate(RemoveVsConverterDCSidesFromVsConverterCommand command) throws Exception {
    Assert.notNull(command, "RemoveVsConverterDCSidesFromVsConverterCommand should not be null");
    Assert.notNull(
        command.getVsConverterId(),
        "RemoveVsConverterDCSidesFromVsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveVsConverterDCSidesFromVsConverterCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getVsConverterId(),
        "RemoveVsConverterDCSidesFromVsConverterCommand removeFrom attribubte identifier should not be null");
  }
}
