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

public class WindType1or2UserDefinedValidator {

  /** default constructor */
  protected WindType1or2UserDefinedValidator() {}

  /** factory method */
  public static WindType1or2UserDefinedValidator getInstance() {
    return new WindType1or2UserDefinedValidator();
  }

  /** handles creation validation for a WindType1or2UserDefined */
  public void validate(CreateWindType1or2UserDefinedCommand windType1or2UserDefined)
      throws Exception {
    Assert.notNull(
        windType1or2UserDefined, "CreateWindType1or2UserDefinedCommand should not be null");
    //		Assert.isNull( windType1or2UserDefined.getWindType1or2UserDefinedId(),
    // "CreateWindType1or2UserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a WindType1or2UserDefined */
  public void validate(UpdateWindType1or2UserDefinedCommand windType1or2UserDefined)
      throws Exception {
    Assert.notNull(
        windType1or2UserDefined, "UpdateWindType1or2UserDefinedCommand should not be null");
    Assert.notNull(
        windType1or2UserDefined.getWindType1or2UserDefinedId(),
        "UpdateWindType1or2UserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a WindType1or2UserDefined */
  public void validate(DeleteWindType1or2UserDefinedCommand windType1or2UserDefined)
      throws Exception {
    Assert.notNull(windType1or2UserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        windType1or2UserDefined.getWindType1or2UserDefinedId(),
        "DeleteWindType1or2UserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindType1or2UserDefined */
  public void validate(WindType1or2UserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindType1or2UserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindType1or2UserDefinedId(),
        "WindType1or2UserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a WindType1or2UserDefined
   *
   * @param command AssignProprietaryToWindType1or2UserDefinedCommand
   */
  public void validate(AssignProprietaryToWindType1or2UserDefinedCommand command) throws Exception {
    Assert.notNull(command, "AssignProprietaryToWindType1or2UserDefinedCommand should not be null");
    Assert.notNull(
        command.getWindType1or2UserDefinedId(),
        "AssignProprietaryToWindType1or2UserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToWindType1or2UserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a WindType1or2UserDefined
   *
   * @param command UnAssignProprietaryFromWindType1or2UserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromWindType1or2UserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignProprietaryFromWindType1or2UserDefinedCommand should not be null");
    Assert.notNull(
        command.getWindType1or2UserDefinedId(),
        "UnAssignProprietaryFromWindType1or2UserDefinedCommand identifier should not be null");
  }
}
