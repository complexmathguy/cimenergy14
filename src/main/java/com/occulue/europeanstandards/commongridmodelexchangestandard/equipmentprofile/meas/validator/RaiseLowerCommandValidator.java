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

public class RaiseLowerCommandValidator {

  /** default constructor */
  protected RaiseLowerCommandValidator() {}

  /** factory method */
  public static RaiseLowerCommandValidator getInstance() {
    return new RaiseLowerCommandValidator();
  }

  /** handles creation validation for a RaiseLowerCommand */
  public void validate(CreateRaiseLowerCommandCommand raiseLowerCommand) throws Exception {
    Assert.notNull(raiseLowerCommand, "CreateRaiseLowerCommandCommand should not be null");
    //		Assert.isNull( raiseLowerCommand.getRaiseLowerCommandId(), "CreateRaiseLowerCommandCommand
    // identifier should be null" );
  }

  /** handles update validation for a RaiseLowerCommand */
  public void validate(UpdateRaiseLowerCommandCommand raiseLowerCommand) throws Exception {
    Assert.notNull(raiseLowerCommand, "UpdateRaiseLowerCommandCommand should not be null");
    Assert.notNull(
        raiseLowerCommand.getRaiseLowerCommandId(),
        "UpdateRaiseLowerCommandCommand identifier should not be null");
  }

  /** handles delete validation for a RaiseLowerCommand */
  public void validate(DeleteRaiseLowerCommandCommand raiseLowerCommand) throws Exception {
    Assert.notNull(raiseLowerCommand, "{commandAlias} should not be null");
    Assert.notNull(
        raiseLowerCommand.getRaiseLowerCommandId(),
        "DeleteRaiseLowerCommandCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RaiseLowerCommand */
  public void validate(RaiseLowerCommandFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RaiseLowerCommandFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRaiseLowerCommandId(),
        "RaiseLowerCommandFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to RaiseLowerCommands validation for a RaiseLowerCommand
   *
   * @param command AssignRaiseLowerCommandsToRaiseLowerCommandCommand
   */
  public void validate(AssignRaiseLowerCommandsToRaiseLowerCommandCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignRaiseLowerCommandsToRaiseLowerCommandCommand should not be null");
    Assert.notNull(
        command.getRaiseLowerCommandId(),
        "AssignRaiseLowerCommandsToRaiseLowerCommandCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignRaiseLowerCommandsToRaiseLowerCommandCommand addTo attribute should not be null");
  }

  /**
   * handles remove from RaiseLowerCommands validation for a RaiseLowerCommand
   *
   * @param command RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand
   */
  public void validate(RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand should not be null");
    Assert.notNull(
        command.getRaiseLowerCommandId(),
        "RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getRaiseLowerCommandId(),
        "RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand removeFrom attribubte identifier should not be null");
  }
}
