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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SvStatusValidator {

  /** default constructor */
  protected SvStatusValidator() {}

  /** factory method */
  public static SvStatusValidator getInstance() {
    return new SvStatusValidator();
  }

  /** handles creation validation for a SvStatus */
  public void validate(CreateSvStatusCommand svStatus) throws Exception {
    Assert.notNull(svStatus, "CreateSvStatusCommand should not be null");
    //		Assert.isNull( svStatus.getSvStatusId(), "CreateSvStatusCommand identifier should be null"
    // );
  }

  /** handles update validation for a SvStatus */
  public void validate(UpdateSvStatusCommand svStatus) throws Exception {
    Assert.notNull(svStatus, "UpdateSvStatusCommand should not be null");
    Assert.notNull(svStatus.getSvStatusId(), "UpdateSvStatusCommand identifier should not be null");
  }

  /** handles delete validation for a SvStatus */
  public void validate(DeleteSvStatusCommand svStatus) throws Exception {
    Assert.notNull(svStatus, "{commandAlias} should not be null");
    Assert.notNull(svStatus.getSvStatusId(), "DeleteSvStatusCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SvStatus */
  public void validate(SvStatusFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SvStatusFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSvStatusId(), "SvStatusFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign InService validation for a SvStatus
   *
   * @param command AssignInServiceToSvStatusCommand
   */
  public void validate(AssignInServiceToSvStatusCommand command) throws Exception {
    Assert.notNull(command, "AssignInServiceToSvStatusCommand should not be null");
    Assert.notNull(
        command.getSvStatusId(), "AssignInServiceToSvStatusCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignInServiceToSvStatusCommand assignment should not be null");
  }

  /**
   * handles unassign InService validation for a SvStatus
   *
   * @param command UnAssignInServiceFromSvStatusCommand
   */
  public void validate(UnAssignInServiceFromSvStatusCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInServiceFromSvStatusCommand should not be null");
    Assert.notNull(
        command.getSvStatusId(),
        "UnAssignInServiceFromSvStatusCommand identifier should not be null");
  }
  /**
   * handles assign SvStatus validation for a SvStatus
   *
   * @param command AssignSvStatusToSvStatusCommand
   */
  public void validate(AssignSvStatusToSvStatusCommand command) throws Exception {
    Assert.notNull(command, "AssignSvStatusToSvStatusCommand should not be null");
    Assert.notNull(
        command.getSvStatusId(), "AssignSvStatusToSvStatusCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSvStatusToSvStatusCommand assignment should not be null");
  }

  /**
   * handles unassign SvStatus validation for a SvStatus
   *
   * @param command UnAssignSvStatusFromSvStatusCommand
   */
  public void validate(UnAssignSvStatusFromSvStatusCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSvStatusFromSvStatusCommand should not be null");
    Assert.notNull(
        command.getSvStatusId(),
        "UnAssignSvStatusFromSvStatusCommand identifier should not be null");
  }
}
