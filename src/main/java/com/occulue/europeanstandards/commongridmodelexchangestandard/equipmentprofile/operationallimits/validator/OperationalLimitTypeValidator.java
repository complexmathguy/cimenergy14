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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class OperationalLimitTypeValidator {

  /** default constructor */
  protected OperationalLimitTypeValidator() {}

  /** factory method */
  public static OperationalLimitTypeValidator getInstance() {
    return new OperationalLimitTypeValidator();
  }

  /** handles creation validation for a OperationalLimitType */
  public void validate(CreateOperationalLimitTypeCommand operationalLimitType) throws Exception {
    Assert.notNull(operationalLimitType, "CreateOperationalLimitTypeCommand should not be null");
    //		Assert.isNull( operationalLimitType.getOperationalLimitTypeId(),
    // "CreateOperationalLimitTypeCommand identifier should be null" );
  }

  /** handles update validation for a OperationalLimitType */
  public void validate(UpdateOperationalLimitTypeCommand operationalLimitType) throws Exception {
    Assert.notNull(operationalLimitType, "UpdateOperationalLimitTypeCommand should not be null");
    Assert.notNull(
        operationalLimitType.getOperationalLimitTypeId(),
        "UpdateOperationalLimitTypeCommand identifier should not be null");
  }

  /** handles delete validation for a OperationalLimitType */
  public void validate(DeleteOperationalLimitTypeCommand operationalLimitType) throws Exception {
    Assert.notNull(operationalLimitType, "{commandAlias} should not be null");
    Assert.notNull(
        operationalLimitType.getOperationalLimitTypeId(),
        "DeleteOperationalLimitTypeCommand identifier should not be null");
  }

  /** handles fetchOne validation for a OperationalLimitType */
  public void validate(OperationalLimitTypeFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "OperationalLimitTypeFetchOneSummary should not be null");
    Assert.notNull(
        summary.getOperationalLimitTypeId(),
        "OperationalLimitTypeFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign AcceptableDuration validation for a OperationalLimitType
   *
   * @param command AssignAcceptableDurationToOperationalLimitTypeCommand
   */
  public void validate(AssignAcceptableDurationToOperationalLimitTypeCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignAcceptableDurationToOperationalLimitTypeCommand should not be null");
    Assert.notNull(
        command.getOperationalLimitTypeId(),
        "AssignAcceptableDurationToOperationalLimitTypeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignAcceptableDurationToOperationalLimitTypeCommand assignment should not be null");
  }

  /**
   * handles unassign AcceptableDuration validation for a OperationalLimitType
   *
   * @param command UnAssignAcceptableDurationFromOperationalLimitTypeCommand
   */
  public void validate(UnAssignAcceptableDurationFromOperationalLimitTypeCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignAcceptableDurationFromOperationalLimitTypeCommand should not be null");
    Assert.notNull(
        command.getOperationalLimitTypeId(),
        "UnAssignAcceptableDurationFromOperationalLimitTypeCommand identifier should not be null");
  }
}
