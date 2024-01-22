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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class RemoteInputSignalValidator {

  /** default constructor */
  protected RemoteInputSignalValidator() {}

  /** factory method */
  public static RemoteInputSignalValidator getInstance() {
    return new RemoteInputSignalValidator();
  }

  /** handles creation validation for a RemoteInputSignal */
  public void validate(CreateRemoteInputSignalCommand remoteInputSignal) throws Exception {
    Assert.notNull(remoteInputSignal, "CreateRemoteInputSignalCommand should not be null");
    //		Assert.isNull( remoteInputSignal.getRemoteInputSignalId(), "CreateRemoteInputSignalCommand
    // identifier should be null" );
  }

  /** handles update validation for a RemoteInputSignal */
  public void validate(UpdateRemoteInputSignalCommand remoteInputSignal) throws Exception {
    Assert.notNull(remoteInputSignal, "UpdateRemoteInputSignalCommand should not be null");
    Assert.notNull(
        remoteInputSignal.getRemoteInputSignalId(),
        "UpdateRemoteInputSignalCommand identifier should not be null");
  }

  /** handles delete validation for a RemoteInputSignal */
  public void validate(DeleteRemoteInputSignalCommand remoteInputSignal) throws Exception {
    Assert.notNull(remoteInputSignal, "{commandAlias} should not be null");
    Assert.notNull(
        remoteInputSignal.getRemoteInputSignalId(),
        "DeleteRemoteInputSignalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RemoteInputSignal */
  public void validate(RemoteInputSignalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RemoteInputSignalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRemoteInputSignalId(),
        "RemoteInputSignalFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to RemoteInputSignal validation for a RemoteInputSignal
   *
   * @param command AssignRemoteInputSignalToRemoteInputSignalCommand
   */
  public void validate(AssignRemoteInputSignalToRemoteInputSignalCommand command) throws Exception {
    Assert.notNull(command, "AssignRemoteInputSignalToRemoteInputSignalCommand should not be null");
    Assert.notNull(
        command.getRemoteInputSignalId(),
        "AssignRemoteInputSignalToRemoteInputSignalCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignRemoteInputSignalToRemoteInputSignalCommand addTo attribute should not be null");
  }

  /**
   * handles remove from RemoteInputSignal validation for a RemoteInputSignal
   *
   * @param command RemoveRemoteInputSignalFromRemoteInputSignalCommand
   */
  public void validate(RemoveRemoteInputSignalFromRemoteInputSignalCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveRemoteInputSignalFromRemoteInputSignalCommand should not be null");
    Assert.notNull(
        command.getRemoteInputSignalId(),
        "RemoveRemoteInputSignalFromRemoteInputSignalCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveRemoteInputSignalFromRemoteInputSignalCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getRemoteInputSignalId(),
        "RemoveRemoteInputSignalFromRemoteInputSignalCommand removeFrom attribubte identifier should not be null");
  }
}
