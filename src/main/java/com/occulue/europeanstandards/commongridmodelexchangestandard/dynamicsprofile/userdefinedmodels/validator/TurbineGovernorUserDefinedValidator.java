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

public class TurbineGovernorUserDefinedValidator {

  /** default constructor */
  protected TurbineGovernorUserDefinedValidator() {}

  /** factory method */
  public static TurbineGovernorUserDefinedValidator getInstance() {
    return new TurbineGovernorUserDefinedValidator();
  }

  /** handles creation validation for a TurbineGovernorUserDefined */
  public void validate(CreateTurbineGovernorUserDefinedCommand turbineGovernorUserDefined)
      throws Exception {
    Assert.notNull(
        turbineGovernorUserDefined, "CreateTurbineGovernorUserDefinedCommand should not be null");
    //		Assert.isNull( turbineGovernorUserDefined.getTurbineGovernorUserDefinedId(),
    // "CreateTurbineGovernorUserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a TurbineGovernorUserDefined */
  public void validate(UpdateTurbineGovernorUserDefinedCommand turbineGovernorUserDefined)
      throws Exception {
    Assert.notNull(
        turbineGovernorUserDefined, "UpdateTurbineGovernorUserDefinedCommand should not be null");
    Assert.notNull(
        turbineGovernorUserDefined.getTurbineGovernorUserDefinedId(),
        "UpdateTurbineGovernorUserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a TurbineGovernorUserDefined */
  public void validate(DeleteTurbineGovernorUserDefinedCommand turbineGovernorUserDefined)
      throws Exception {
    Assert.notNull(turbineGovernorUserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        turbineGovernorUserDefined.getTurbineGovernorUserDefinedId(),
        "DeleteTurbineGovernorUserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TurbineGovernorUserDefined */
  public void validate(TurbineGovernorUserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TurbineGovernorUserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTurbineGovernorUserDefinedId(),
        "TurbineGovernorUserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a TurbineGovernorUserDefined
   *
   * @param command AssignProprietaryToTurbineGovernorUserDefinedCommand
   */
  public void validate(AssignProprietaryToTurbineGovernorUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignProprietaryToTurbineGovernorUserDefinedCommand should not be null");
    Assert.notNull(
        command.getTurbineGovernorUserDefinedId(),
        "AssignProprietaryToTurbineGovernorUserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToTurbineGovernorUserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a TurbineGovernorUserDefined
   *
   * @param command UnAssignProprietaryFromTurbineGovernorUserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromTurbineGovernorUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignProprietaryFromTurbineGovernorUserDefinedCommand should not be null");
    Assert.notNull(
        command.getTurbineGovernorUserDefinedId(),
        "UnAssignProprietaryFromTurbineGovernorUserDefinedCommand identifier should not be null");
  }
}
