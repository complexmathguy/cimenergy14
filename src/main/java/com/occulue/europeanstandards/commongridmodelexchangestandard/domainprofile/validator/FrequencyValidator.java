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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class FrequencyValidator {

  /** default constructor */
  protected FrequencyValidator() {}

  /** factory method */
  public static FrequencyValidator getInstance() {
    return new FrequencyValidator();
  }

  /** handles creation validation for a Frequency */
  public void validate(CreateFrequencyCommand frequency) throws Exception {
    Assert.notNull(frequency, "CreateFrequencyCommand should not be null");
    //		Assert.isNull( frequency.getFrequencyId(), "CreateFrequencyCommand identifier should be
    // null" );
  }

  /** handles update validation for a Frequency */
  public void validate(UpdateFrequencyCommand frequency) throws Exception {
    Assert.notNull(frequency, "UpdateFrequencyCommand should not be null");
    Assert.notNull(
        frequency.getFrequencyId(), "UpdateFrequencyCommand identifier should not be null");
  }

  /** handles delete validation for a Frequency */
  public void validate(DeleteFrequencyCommand frequency) throws Exception {
    Assert.notNull(frequency, "{commandAlias} should not be null");
    Assert.notNull(
        frequency.getFrequencyId(), "DeleteFrequencyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Frequency */
  public void validate(FrequencyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "FrequencyFetchOneSummary should not be null");
    Assert.notNull(
        summary.getFrequencyId(), "FrequencyFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Frequency
   *
   * @param command AssignValueToFrequencyCommand
   */
  public void validate(AssignValueToFrequencyCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToFrequencyCommand should not be null");
    Assert.notNull(
        command.getFrequencyId(), "AssignValueToFrequencyCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToFrequencyCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Frequency
   *
   * @param command UnAssignValueFromFrequencyCommand
   */
  public void validate(UnAssignValueFromFrequencyCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromFrequencyCommand should not be null");
    Assert.notNull(
        command.getFrequencyId(),
        "UnAssignValueFromFrequencyCommand identifier should not be null");
  }
}
