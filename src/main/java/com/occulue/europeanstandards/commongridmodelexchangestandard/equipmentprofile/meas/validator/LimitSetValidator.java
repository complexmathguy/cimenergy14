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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class LimitSetValidator {

  /** default constructor */
  protected LimitSetValidator() {}

  /** factory method */
  public static LimitSetValidator getInstance() {
    return new LimitSetValidator();
  }

  /** handles creation validation for a LimitSet */
  public void validate(CreateLimitSetCommand limitSet) throws Exception {
    Assert.notNull(limitSet, "CreateLimitSetCommand should not be null");
    //		Assert.isNull( limitSet.getLimitSetId(), "CreateLimitSetCommand identifier should be null"
    // );
  }

  /** handles update validation for a LimitSet */
  public void validate(UpdateLimitSetCommand limitSet) throws Exception {
    Assert.notNull(limitSet, "UpdateLimitSetCommand should not be null");
    Assert.notNull(limitSet.getLimitSetId(), "UpdateLimitSetCommand identifier should not be null");
  }

  /** handles delete validation for a LimitSet */
  public void validate(DeleteLimitSetCommand limitSet) throws Exception {
    Assert.notNull(limitSet, "{commandAlias} should not be null");
    Assert.notNull(limitSet.getLimitSetId(), "DeleteLimitSetCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LimitSet */
  public void validate(LimitSetFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LimitSetFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLimitSetId(), "LimitSetFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign PercentageLimitsFlag validation for a LimitSet
   *
   * @param command AssignPercentageLimitsFlagToLimitSetCommand
   */
  public void validate(AssignPercentageLimitsFlagToLimitSetCommand command) throws Exception {
    Assert.notNull(command, "AssignPercentageLimitsFlagToLimitSetCommand should not be null");
    Assert.notNull(
        command.getLimitSetId(),
        "AssignPercentageLimitsFlagToLimitSetCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPercentageLimitsFlagToLimitSetCommand assignment should not be null");
  }

  /**
   * handles unassign PercentageLimitsFlag validation for a LimitSet
   *
   * @param command UnAssignPercentageLimitsFlagFromLimitSetCommand
   */
  public void validate(UnAssignPercentageLimitsFlagFromLimitSetCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPercentageLimitsFlagFromLimitSetCommand should not be null");
    Assert.notNull(
        command.getLimitSetId(),
        "UnAssignPercentageLimitsFlagFromLimitSetCommand identifier should not be null");
  }
}
