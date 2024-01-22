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

public class PFVArControllerType1UserDefinedValidator {

  /** default constructor */
  protected PFVArControllerType1UserDefinedValidator() {}

  /** factory method */
  public static PFVArControllerType1UserDefinedValidator getInstance() {
    return new PFVArControllerType1UserDefinedValidator();
  }

  /** handles creation validation for a PFVArControllerType1UserDefined */
  public void validate(CreatePFVArControllerType1UserDefinedCommand pFVArControllerType1UserDefined)
      throws Exception {
    Assert.notNull(
        pFVArControllerType1UserDefined,
        "CreatePFVArControllerType1UserDefinedCommand should not be null");
    //		Assert.isNull( pFVArControllerType1UserDefined.getPFVArControllerType1UserDefinedId(),
    // "CreatePFVArControllerType1UserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a PFVArControllerType1UserDefined */
  public void validate(UpdatePFVArControllerType1UserDefinedCommand pFVArControllerType1UserDefined)
      throws Exception {
    Assert.notNull(
        pFVArControllerType1UserDefined,
        "UpdatePFVArControllerType1UserDefinedCommand should not be null");
    Assert.notNull(
        pFVArControllerType1UserDefined.getPFVArControllerType1UserDefinedId(),
        "UpdatePFVArControllerType1UserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a PFVArControllerType1UserDefined */
  public void validate(DeletePFVArControllerType1UserDefinedCommand pFVArControllerType1UserDefined)
      throws Exception {
    Assert.notNull(pFVArControllerType1UserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArControllerType1UserDefined.getPFVArControllerType1UserDefinedId(),
        "DeletePFVArControllerType1UserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArControllerType1UserDefined */
  public void validate(PFVArControllerType1UserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArControllerType1UserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArControllerType1UserDefinedId(),
        "PFVArControllerType1UserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a PFVArControllerType1UserDefined
   *
   * @param command AssignProprietaryToPFVArControllerType1UserDefinedCommand
   */
  public void validate(AssignProprietaryToPFVArControllerType1UserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignProprietaryToPFVArControllerType1UserDefinedCommand should not be null");
    Assert.notNull(
        command.getPFVArControllerType1UserDefinedId(),
        "AssignProprietaryToPFVArControllerType1UserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToPFVArControllerType1UserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a PFVArControllerType1UserDefined
   *
   * @param command UnAssignProprietaryFromPFVArControllerType1UserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromPFVArControllerType1UserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignProprietaryFromPFVArControllerType1UserDefinedCommand should not be null");
    Assert.notNull(
        command.getPFVArControllerType1UserDefinedId(),
        "UnAssignProprietaryFromPFVArControllerType1UserDefinedCommand identifier should not be null");
  }
}
