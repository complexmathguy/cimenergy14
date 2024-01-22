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

public class AccumulatorLimitSetValidator {

  /** default constructor */
  protected AccumulatorLimitSetValidator() {}

  /** factory method */
  public static AccumulatorLimitSetValidator getInstance() {
    return new AccumulatorLimitSetValidator();
  }

  /** handles creation validation for a AccumulatorLimitSet */
  public void validate(CreateAccumulatorLimitSetCommand accumulatorLimitSet) throws Exception {
    Assert.notNull(accumulatorLimitSet, "CreateAccumulatorLimitSetCommand should not be null");
    //		Assert.isNull( accumulatorLimitSet.getAccumulatorLimitSetId(),
    // "CreateAccumulatorLimitSetCommand identifier should be null" );
  }

  /** handles update validation for a AccumulatorLimitSet */
  public void validate(UpdateAccumulatorLimitSetCommand accumulatorLimitSet) throws Exception {
    Assert.notNull(accumulatorLimitSet, "UpdateAccumulatorLimitSetCommand should not be null");
    Assert.notNull(
        accumulatorLimitSet.getAccumulatorLimitSetId(),
        "UpdateAccumulatorLimitSetCommand identifier should not be null");
  }

  /** handles delete validation for a AccumulatorLimitSet */
  public void validate(DeleteAccumulatorLimitSetCommand accumulatorLimitSet) throws Exception {
    Assert.notNull(accumulatorLimitSet, "{commandAlias} should not be null");
    Assert.notNull(
        accumulatorLimitSet.getAccumulatorLimitSetId(),
        "DeleteAccumulatorLimitSetCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AccumulatorLimitSet */
  public void validate(AccumulatorLimitSetFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AccumulatorLimitSetFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAccumulatorLimitSetId(),
        "AccumulatorLimitSetFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to LimitSets validation for a AccumulatorLimitSet
   *
   * @param command AssignLimitSetsToAccumulatorLimitSetCommand
   */
  public void validate(AssignLimitSetsToAccumulatorLimitSetCommand command) throws Exception {
    Assert.notNull(command, "AssignLimitSetsToAccumulatorLimitSetCommand should not be null");
    Assert.notNull(
        command.getAccumulatorLimitSetId(),
        "AssignLimitSetsToAccumulatorLimitSetCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignLimitSetsToAccumulatorLimitSetCommand addTo attribute should not be null");
  }

  /**
   * handles remove from LimitSets validation for a AccumulatorLimitSet
   *
   * @param command RemoveLimitSetsFromAccumulatorLimitSetCommand
   */
  public void validate(RemoveLimitSetsFromAccumulatorLimitSetCommand command) throws Exception {
    Assert.notNull(command, "RemoveLimitSetsFromAccumulatorLimitSetCommand should not be null");
    Assert.notNull(
        command.getAccumulatorLimitSetId(),
        "RemoveLimitSetsFromAccumulatorLimitSetCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveLimitSetsFromAccumulatorLimitSetCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getAccumulatorLimitSetId(),
        "RemoveLimitSetsFromAccumulatorLimitSetCommand removeFrom attribubte identifier should not be null");
  }
}
