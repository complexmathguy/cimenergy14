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
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SwitchItValidator {

  /** default constructor */
  protected SwitchItValidator() {}

  /** factory method */
  public static SwitchItValidator getInstance() {
    return new SwitchItValidator();
  }

  /** handles creation validation for a SwitchIt */
  public void validate(CreateSwitchItCommand switchIt) throws Exception {
    Assert.notNull(switchIt, "CreateSwitchItCommand should not be null");
    //		Assert.isNull( switchIt.getSwitchItId(), "CreateSwitchItCommand identifier should be null"
    // );
  }

  /** handles update validation for a SwitchIt */
  public void validate(UpdateSwitchItCommand switchIt) throws Exception {
    Assert.notNull(switchIt, "UpdateSwitchItCommand should not be null");
    Assert.notNull(switchIt.getSwitchItId(), "UpdateSwitchItCommand identifier should not be null");
  }

  /** handles delete validation for a SwitchIt */
  public void validate(DeleteSwitchItCommand switchIt) throws Exception {
    Assert.notNull(switchIt, "{commandAlias} should not be null");
    Assert.notNull(switchIt.getSwitchItId(), "DeleteSwitchItCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SwitchIt */
  public void validate(SwitchItFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SwitchItFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSwitchItId(), "SwitchItFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Open validation for a SwitchIt
   *
   * @param command AssignOpenToSwitchItCommand
   */
  public void validate(AssignOpenToSwitchItCommand command) throws Exception {
    Assert.notNull(command, "AssignOpenToSwitchItCommand should not be null");
    Assert.notNull(
        command.getSwitchItId(), "AssignOpenToSwitchItCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignOpenToSwitchItCommand assignment should not be null");
  }

  /**
   * handles unassign Open validation for a SwitchIt
   *
   * @param command UnAssignOpenFromSwitchItCommand
   */
  public void validate(UnAssignOpenFromSwitchItCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOpenFromSwitchItCommand should not be null");
    Assert.notNull(
        command.getSwitchItId(), "UnAssignOpenFromSwitchItCommand identifier should not be null");
  }
}
