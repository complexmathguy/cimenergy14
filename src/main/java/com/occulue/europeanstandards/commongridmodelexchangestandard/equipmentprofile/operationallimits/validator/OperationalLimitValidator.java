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

public class OperationalLimitValidator {

  /** default constructor */
  protected OperationalLimitValidator() {}

  /** factory method */
  public static OperationalLimitValidator getInstance() {
    return new OperationalLimitValidator();
  }

  /** handles creation validation for a OperationalLimit */
  public void validate(CreateOperationalLimitCommand operationalLimit) throws Exception {
    Assert.notNull(operationalLimit, "CreateOperationalLimitCommand should not be null");
    //		Assert.isNull( operationalLimit.getOperationalLimitId(), "CreateOperationalLimitCommand
    // identifier should be null" );
  }

  /** handles update validation for a OperationalLimit */
  public void validate(UpdateOperationalLimitCommand operationalLimit) throws Exception {
    Assert.notNull(operationalLimit, "UpdateOperationalLimitCommand should not be null");
    Assert.notNull(
        operationalLimit.getOperationalLimitId(),
        "UpdateOperationalLimitCommand identifier should not be null");
  }

  /** handles delete validation for a OperationalLimit */
  public void validate(DeleteOperationalLimitCommand operationalLimit) throws Exception {
    Assert.notNull(operationalLimit, "{commandAlias} should not be null");
    Assert.notNull(
        operationalLimit.getOperationalLimitId(),
        "DeleteOperationalLimitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a OperationalLimit */
  public void validate(OperationalLimitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "OperationalLimitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getOperationalLimitId(),
        "OperationalLimitFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to OperationalLimit validation for a OperationalLimit
   *
   * @param command AssignOperationalLimitToOperationalLimitCommand
   */
  public void validate(AssignOperationalLimitToOperationalLimitCommand command) throws Exception {
    Assert.notNull(command, "AssignOperationalLimitToOperationalLimitCommand should not be null");
    Assert.notNull(
        command.getOperationalLimitId(),
        "AssignOperationalLimitToOperationalLimitCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignOperationalLimitToOperationalLimitCommand addTo attribute should not be null");
  }

  /**
   * handles remove from OperationalLimit validation for a OperationalLimit
   *
   * @param command RemoveOperationalLimitFromOperationalLimitCommand
   */
  public void validate(RemoveOperationalLimitFromOperationalLimitCommand command) throws Exception {
    Assert.notNull(command, "RemoveOperationalLimitFromOperationalLimitCommand should not be null");
    Assert.notNull(
        command.getOperationalLimitId(),
        "RemoveOperationalLimitFromOperationalLimitCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveOperationalLimitFromOperationalLimitCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getOperationalLimitId(),
        "RemoveOperationalLimitFromOperationalLimitCommand removeFrom attribubte identifier should not be null");
  }

  /**
   * handles add to OperationalLimitValue validation for a OperationalLimit
   *
   * @param command AssignOperationalLimitValueToOperationalLimitCommand
   */
  public void validate(AssignOperationalLimitValueToOperationalLimitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignOperationalLimitValueToOperationalLimitCommand should not be null");
    Assert.notNull(
        command.getOperationalLimitId(),
        "AssignOperationalLimitValueToOperationalLimitCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignOperationalLimitValueToOperationalLimitCommand addTo attribute should not be null");
  }

  /**
   * handles remove from OperationalLimitValue validation for a OperationalLimit
   *
   * @param command RemoveOperationalLimitValueFromOperationalLimitCommand
   */
  public void validate(RemoveOperationalLimitValueFromOperationalLimitCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveOperationalLimitValueFromOperationalLimitCommand should not be null");
    Assert.notNull(
        command.getOperationalLimitId(),
        "RemoveOperationalLimitValueFromOperationalLimitCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveOperationalLimitValueFromOperationalLimitCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getOperationalLimitId(),
        "RemoveOperationalLimitValueFromOperationalLimitCommand removeFrom attribubte identifier should not be null");
  }
}
