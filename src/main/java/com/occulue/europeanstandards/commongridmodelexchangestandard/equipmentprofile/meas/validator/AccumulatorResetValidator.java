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

public class AccumulatorResetValidator {

  /** default constructor */
  protected AccumulatorResetValidator() {}

  /** factory method */
  public static AccumulatorResetValidator getInstance() {
    return new AccumulatorResetValidator();
  }

  /** handles creation validation for a AccumulatorReset */
  public void validate(CreateAccumulatorResetCommand accumulatorReset) throws Exception {
    Assert.notNull(accumulatorReset, "CreateAccumulatorResetCommand should not be null");
    //		Assert.isNull( accumulatorReset.getAccumulatorResetId(), "CreateAccumulatorResetCommand
    // identifier should be null" );
  }

  /** handles update validation for a AccumulatorReset */
  public void validate(UpdateAccumulatorResetCommand accumulatorReset) throws Exception {
    Assert.notNull(accumulatorReset, "UpdateAccumulatorResetCommand should not be null");
    Assert.notNull(
        accumulatorReset.getAccumulatorResetId(),
        "UpdateAccumulatorResetCommand identifier should not be null");
  }

  /** handles delete validation for a AccumulatorReset */
  public void validate(DeleteAccumulatorResetCommand accumulatorReset) throws Exception {
    Assert.notNull(accumulatorReset, "{commandAlias} should not be null");
    Assert.notNull(
        accumulatorReset.getAccumulatorResetId(),
        "DeleteAccumulatorResetCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AccumulatorReset */
  public void validate(AccumulatorResetFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AccumulatorResetFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAccumulatorResetId(),
        "AccumulatorResetFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign AccumulatorReset validation for a AccumulatorReset
   *
   * @param command AssignAccumulatorResetToAccumulatorResetCommand
   */
  public void validate(AssignAccumulatorResetToAccumulatorResetCommand command) throws Exception {
    Assert.notNull(command, "AssignAccumulatorResetToAccumulatorResetCommand should not be null");
    Assert.notNull(
        command.getAccumulatorResetId(),
        "AssignAccumulatorResetToAccumulatorResetCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignAccumulatorResetToAccumulatorResetCommand assignment should not be null");
  }

  /**
   * handles unassign AccumulatorReset validation for a AccumulatorReset
   *
   * @param command UnAssignAccumulatorResetFromAccumulatorResetCommand
   */
  public void validate(UnAssignAccumulatorResetFromAccumulatorResetCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignAccumulatorResetFromAccumulatorResetCommand should not be null");
    Assert.notNull(
        command.getAccumulatorResetId(),
        "UnAssignAccumulatorResetFromAccumulatorResetCommand identifier should not be null");
  }
}
