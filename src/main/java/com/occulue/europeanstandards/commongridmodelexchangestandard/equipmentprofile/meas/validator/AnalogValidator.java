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

public class AnalogValidator {

  /** default constructor */
  protected AnalogValidator() {}

  /** factory method */
  public static AnalogValidator getInstance() {
    return new AnalogValidator();
  }

  /** handles creation validation for a Analog */
  public void validate(CreateAnalogCommand analog) throws Exception {
    Assert.notNull(analog, "CreateAnalogCommand should not be null");
    //		Assert.isNull( analog.getAnalogId(), "CreateAnalogCommand identifier should be null" );
  }

  /** handles update validation for a Analog */
  public void validate(UpdateAnalogCommand analog) throws Exception {
    Assert.notNull(analog, "UpdateAnalogCommand should not be null");
    Assert.notNull(analog.getAnalogId(), "UpdateAnalogCommand identifier should not be null");
  }

  /** handles delete validation for a Analog */
  public void validate(DeleteAnalogCommand analog) throws Exception {
    Assert.notNull(analog, "{commandAlias} should not be null");
    Assert.notNull(analog.getAnalogId(), "DeleteAnalogCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Analog */
  public void validate(AnalogFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AnalogFetchOneSummary should not be null");
    Assert.notNull(summary.getAnalogId(), "AnalogFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign PositiveFlowIn validation for a Analog
   *
   * @param command AssignPositiveFlowInToAnalogCommand
   */
  public void validate(AssignPositiveFlowInToAnalogCommand command) throws Exception {
    Assert.notNull(command, "AssignPositiveFlowInToAnalogCommand should not be null");
    Assert.notNull(
        command.getAnalogId(), "AssignPositiveFlowInToAnalogCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPositiveFlowInToAnalogCommand assignment should not be null");
  }

  /**
   * handles unassign PositiveFlowIn validation for a Analog
   *
   * @param command UnAssignPositiveFlowInFromAnalogCommand
   */
  public void validate(UnAssignPositiveFlowInFromAnalogCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPositiveFlowInFromAnalogCommand should not be null");
    Assert.notNull(
        command.getAnalogId(),
        "UnAssignPositiveFlowInFromAnalogCommand identifier should not be null");
  }
}
