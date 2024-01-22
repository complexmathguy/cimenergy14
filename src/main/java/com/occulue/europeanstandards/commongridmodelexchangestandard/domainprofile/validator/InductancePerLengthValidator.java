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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class InductancePerLengthValidator {

  /** default constructor */
  protected InductancePerLengthValidator() {}

  /** factory method */
  public static InductancePerLengthValidator getInstance() {
    return new InductancePerLengthValidator();
  }

  /** handles creation validation for a InductancePerLength */
  public void validate(CreateInductancePerLengthCommand inductancePerLength) throws Exception {
    Assert.notNull(inductancePerLength, "CreateInductancePerLengthCommand should not be null");
    //		Assert.isNull( inductancePerLength.getInductancePerLengthId(),
    // "CreateInductancePerLengthCommand identifier should be null" );
  }

  /** handles update validation for a InductancePerLength */
  public void validate(UpdateInductancePerLengthCommand inductancePerLength) throws Exception {
    Assert.notNull(inductancePerLength, "UpdateInductancePerLengthCommand should not be null");
    Assert.notNull(
        inductancePerLength.getInductancePerLengthId(),
        "UpdateInductancePerLengthCommand identifier should not be null");
  }

  /** handles delete validation for a InductancePerLength */
  public void validate(DeleteInductancePerLengthCommand inductancePerLength) throws Exception {
    Assert.notNull(inductancePerLength, "{commandAlias} should not be null");
    Assert.notNull(
        inductancePerLength.getInductancePerLengthId(),
        "DeleteInductancePerLengthCommand identifier should not be null");
  }

  /** handles fetchOne validation for a InductancePerLength */
  public void validate(InductancePerLengthFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "InductancePerLengthFetchOneSummary should not be null");
    Assert.notNull(
        summary.getInductancePerLengthId(),
        "InductancePerLengthFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a InductancePerLength
   *
   * @param command AssignValueToInductancePerLengthCommand
   */
  public void validate(AssignValueToInductancePerLengthCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToInductancePerLengthCommand should not be null");
    Assert.notNull(
        command.getInductancePerLengthId(),
        "AssignValueToInductancePerLengthCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToInductancePerLengthCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a InductancePerLength
   *
   * @param command UnAssignValueFromInductancePerLengthCommand
   */
  public void validate(UnAssignValueFromInductancePerLengthCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromInductancePerLengthCommand should not be null");
    Assert.notNull(
        command.getInductancePerLengthId(),
        "UnAssignValueFromInductancePerLengthCommand identifier should not be null");
  }
}
