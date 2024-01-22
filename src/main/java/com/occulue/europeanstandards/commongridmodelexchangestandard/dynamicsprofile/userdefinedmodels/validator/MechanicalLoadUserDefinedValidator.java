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

public class MechanicalLoadUserDefinedValidator {

  /** default constructor */
  protected MechanicalLoadUserDefinedValidator() {}

  /** factory method */
  public static MechanicalLoadUserDefinedValidator getInstance() {
    return new MechanicalLoadUserDefinedValidator();
  }

  /** handles creation validation for a MechanicalLoadUserDefined */
  public void validate(CreateMechanicalLoadUserDefinedCommand mechanicalLoadUserDefined)
      throws Exception {
    Assert.notNull(
        mechanicalLoadUserDefined, "CreateMechanicalLoadUserDefinedCommand should not be null");
    //		Assert.isNull( mechanicalLoadUserDefined.getMechanicalLoadUserDefinedId(),
    // "CreateMechanicalLoadUserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a MechanicalLoadUserDefined */
  public void validate(UpdateMechanicalLoadUserDefinedCommand mechanicalLoadUserDefined)
      throws Exception {
    Assert.notNull(
        mechanicalLoadUserDefined, "UpdateMechanicalLoadUserDefinedCommand should not be null");
    Assert.notNull(
        mechanicalLoadUserDefined.getMechanicalLoadUserDefinedId(),
        "UpdateMechanicalLoadUserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a MechanicalLoadUserDefined */
  public void validate(DeleteMechanicalLoadUserDefinedCommand mechanicalLoadUserDefined)
      throws Exception {
    Assert.notNull(mechanicalLoadUserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        mechanicalLoadUserDefined.getMechanicalLoadUserDefinedId(),
        "DeleteMechanicalLoadUserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a MechanicalLoadUserDefined */
  public void validate(MechanicalLoadUserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "MechanicalLoadUserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getMechanicalLoadUserDefinedId(),
        "MechanicalLoadUserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a MechanicalLoadUserDefined
   *
   * @param command AssignProprietaryToMechanicalLoadUserDefinedCommand
   */
  public void validate(AssignProprietaryToMechanicalLoadUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignProprietaryToMechanicalLoadUserDefinedCommand should not be null");
    Assert.notNull(
        command.getMechanicalLoadUserDefinedId(),
        "AssignProprietaryToMechanicalLoadUserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToMechanicalLoadUserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a MechanicalLoadUserDefined
   *
   * @param command UnAssignProprietaryFromMechanicalLoadUserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromMechanicalLoadUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignProprietaryFromMechanicalLoadUserDefinedCommand should not be null");
    Assert.notNull(
        command.getMechanicalLoadUserDefinedId(),
        "UnAssignProprietaryFromMechanicalLoadUserDefinedCommand identifier should not be null");
  }
}
