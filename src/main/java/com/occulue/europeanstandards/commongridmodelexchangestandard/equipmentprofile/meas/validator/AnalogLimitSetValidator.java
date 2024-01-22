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

public class AnalogLimitSetValidator {

  /** default constructor */
  protected AnalogLimitSetValidator() {}

  /** factory method */
  public static AnalogLimitSetValidator getInstance() {
    return new AnalogLimitSetValidator();
  }

  /** handles creation validation for a AnalogLimitSet */
  public void validate(CreateAnalogLimitSetCommand analogLimitSet) throws Exception {
    Assert.notNull(analogLimitSet, "CreateAnalogLimitSetCommand should not be null");
    //		Assert.isNull( analogLimitSet.getAnalogLimitSetId(), "CreateAnalogLimitSetCommand identifier
    // should be null" );
  }

  /** handles update validation for a AnalogLimitSet */
  public void validate(UpdateAnalogLimitSetCommand analogLimitSet) throws Exception {
    Assert.notNull(analogLimitSet, "UpdateAnalogLimitSetCommand should not be null");
    Assert.notNull(
        analogLimitSet.getAnalogLimitSetId(),
        "UpdateAnalogLimitSetCommand identifier should not be null");
  }

  /** handles delete validation for a AnalogLimitSet */
  public void validate(DeleteAnalogLimitSetCommand analogLimitSet) throws Exception {
    Assert.notNull(analogLimitSet, "{commandAlias} should not be null");
    Assert.notNull(
        analogLimitSet.getAnalogLimitSetId(),
        "DeleteAnalogLimitSetCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AnalogLimitSet */
  public void validate(AnalogLimitSetFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AnalogLimitSetFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAnalogLimitSetId(),
        "AnalogLimitSetFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to LimitSets validation for a AnalogLimitSet
   *
   * @param command AssignLimitSetsToAnalogLimitSetCommand
   */
  public void validate(AssignLimitSetsToAnalogLimitSetCommand command) throws Exception {
    Assert.notNull(command, "AssignLimitSetsToAnalogLimitSetCommand should not be null");
    Assert.notNull(
        command.getAnalogLimitSetId(),
        "AssignLimitSetsToAnalogLimitSetCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignLimitSetsToAnalogLimitSetCommand addTo attribute should not be null");
  }

  /**
   * handles remove from LimitSets validation for a AnalogLimitSet
   *
   * @param command RemoveLimitSetsFromAnalogLimitSetCommand
   */
  public void validate(RemoveLimitSetsFromAnalogLimitSetCommand command) throws Exception {
    Assert.notNull(command, "RemoveLimitSetsFromAnalogLimitSetCommand should not be null");
    Assert.notNull(
        command.getAnalogLimitSetId(),
        "RemoveLimitSetsFromAnalogLimitSetCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveLimitSetsFromAnalogLimitSetCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getAnalogLimitSetId(),
        "RemoveLimitSetsFromAnalogLimitSetCommand removeFrom attribubte identifier should not be null");
  }
}
