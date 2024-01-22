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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VoltageAdjusterUserDefinedValidator {

  /** default constructor */
  protected VoltageAdjusterUserDefinedValidator() {}

  /** factory method */
  public static VoltageAdjusterUserDefinedValidator getInstance() {
    return new VoltageAdjusterUserDefinedValidator();
  }

  /** handles creation validation for a VoltageAdjusterUserDefined */
  public void validate(CreateVoltageAdjusterUserDefinedCommand voltageAdjusterUserDefined)
      throws Exception {
    Assert.notNull(
        voltageAdjusterUserDefined, "CreateVoltageAdjusterUserDefinedCommand should not be null");
    //		Assert.isNull( voltageAdjusterUserDefined.getVoltageAdjusterUserDefinedId(),
    // "CreateVoltageAdjusterUserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a VoltageAdjusterUserDefined */
  public void validate(UpdateVoltageAdjusterUserDefinedCommand voltageAdjusterUserDefined)
      throws Exception {
    Assert.notNull(
        voltageAdjusterUserDefined, "UpdateVoltageAdjusterUserDefinedCommand should not be null");
    Assert.notNull(
        voltageAdjusterUserDefined.getVoltageAdjusterUserDefinedId(),
        "UpdateVoltageAdjusterUserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a VoltageAdjusterUserDefined */
  public void validate(DeleteVoltageAdjusterUserDefinedCommand voltageAdjusterUserDefined)
      throws Exception {
    Assert.notNull(voltageAdjusterUserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        voltageAdjusterUserDefined.getVoltageAdjusterUserDefinedId(),
        "DeleteVoltageAdjusterUserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VoltageAdjusterUserDefined */
  public void validate(VoltageAdjusterUserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VoltageAdjusterUserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVoltageAdjusterUserDefinedId(),
        "VoltageAdjusterUserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a VoltageAdjusterUserDefined
   *
   * @param command AssignProprietaryToVoltageAdjusterUserDefinedCommand
   */
  public void validate(AssignProprietaryToVoltageAdjusterUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignProprietaryToVoltageAdjusterUserDefinedCommand should not be null");
    Assert.notNull(
        command.getVoltageAdjusterUserDefinedId(),
        "AssignProprietaryToVoltageAdjusterUserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToVoltageAdjusterUserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a VoltageAdjusterUserDefined
   *
   * @param command UnAssignProprietaryFromVoltageAdjusterUserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromVoltageAdjusterUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignProprietaryFromVoltageAdjusterUserDefinedCommand should not be null");
    Assert.notNull(
        command.getVoltageAdjusterUserDefinedId(),
        "UnAssignProprietaryFromVoltageAdjusterUserDefinedCommand identifier should not be null");
  }
}
