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

public class PowerSystemStabilizerUserDefinedValidator {

  /** default constructor */
  protected PowerSystemStabilizerUserDefinedValidator() {}

  /** factory method */
  public static PowerSystemStabilizerUserDefinedValidator getInstance() {
    return new PowerSystemStabilizerUserDefinedValidator();
  }

  /** handles creation validation for a PowerSystemStabilizerUserDefined */
  public void validate(
      CreatePowerSystemStabilizerUserDefinedCommand powerSystemStabilizerUserDefined)
      throws Exception {
    Assert.notNull(
        powerSystemStabilizerUserDefined,
        "CreatePowerSystemStabilizerUserDefinedCommand should not be null");
    //		Assert.isNull( powerSystemStabilizerUserDefined.getPowerSystemStabilizerUserDefinedId(),
    // "CreatePowerSystemStabilizerUserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a PowerSystemStabilizerUserDefined */
  public void validate(
      UpdatePowerSystemStabilizerUserDefinedCommand powerSystemStabilizerUserDefined)
      throws Exception {
    Assert.notNull(
        powerSystemStabilizerUserDefined,
        "UpdatePowerSystemStabilizerUserDefinedCommand should not be null");
    Assert.notNull(
        powerSystemStabilizerUserDefined.getPowerSystemStabilizerUserDefinedId(),
        "UpdatePowerSystemStabilizerUserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a PowerSystemStabilizerUserDefined */
  public void validate(
      DeletePowerSystemStabilizerUserDefinedCommand powerSystemStabilizerUserDefined)
      throws Exception {
    Assert.notNull(powerSystemStabilizerUserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        powerSystemStabilizerUserDefined.getPowerSystemStabilizerUserDefinedId(),
        "DeletePowerSystemStabilizerUserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PowerSystemStabilizerUserDefined */
  public void validate(PowerSystemStabilizerUserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PowerSystemStabilizerUserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPowerSystemStabilizerUserDefinedId(),
        "PowerSystemStabilizerUserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a PowerSystemStabilizerUserDefined
   *
   * @param command AssignProprietaryToPowerSystemStabilizerUserDefinedCommand
   */
  public void validate(AssignProprietaryToPowerSystemStabilizerUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignProprietaryToPowerSystemStabilizerUserDefinedCommand should not be null");
    Assert.notNull(
        command.getPowerSystemStabilizerUserDefinedId(),
        "AssignProprietaryToPowerSystemStabilizerUserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToPowerSystemStabilizerUserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a PowerSystemStabilizerUserDefined
   *
   * @param command UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand should not be null");
    Assert.notNull(
        command.getPowerSystemStabilizerUserDefinedId(),
        "UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand identifier should not be null");
  }
}
