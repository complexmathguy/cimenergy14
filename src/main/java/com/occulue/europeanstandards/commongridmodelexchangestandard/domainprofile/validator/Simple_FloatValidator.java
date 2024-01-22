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

public class Simple_FloatValidator {

  /** default constructor */
  protected Simple_FloatValidator() {}

  /** factory method */
  public static Simple_FloatValidator getInstance() {
    return new Simple_FloatValidator();
  }

  /** handles creation validation for a Simple_Float */
  public void validate(CreateSimple_FloatCommand simple_Float) throws Exception {
    Assert.notNull(simple_Float, "CreateSimple_FloatCommand should not be null");
    //		Assert.isNull( simple_Float.getSimple_FloatId(), "CreateSimple_FloatCommand identifier
    // should be null" );
  }

  /** handles update validation for a Simple_Float */
  public void validate(UpdateSimple_FloatCommand simple_Float) throws Exception {
    Assert.notNull(simple_Float, "UpdateSimple_FloatCommand should not be null");
    Assert.notNull(
        simple_Float.getSimple_FloatId(),
        "UpdateSimple_FloatCommand identifier should not be null");
  }

  /** handles delete validation for a Simple_Float */
  public void validate(DeleteSimple_FloatCommand simple_Float) throws Exception {
    Assert.notNull(simple_Float, "{commandAlias} should not be null");
    Assert.notNull(
        simple_Float.getSimple_FloatId(),
        "DeleteSimple_FloatCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Simple_Float */
  public void validate(Simple_FloatFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "Simple_FloatFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSimple_FloatId(), "Simple_FloatFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Simple_Float
   *
   * @param command AssignValueToSimple_FloatCommand
   */
  public void validate(AssignValueToSimple_FloatCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToSimple_FloatCommand should not be null");
    Assert.notNull(
        command.getSimple_FloatId(),
        "AssignValueToSimple_FloatCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToSimple_FloatCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Simple_Float
   *
   * @param command UnAssignValueFromSimple_FloatCommand
   */
  public void validate(UnAssignValueFromSimple_FloatCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromSimple_FloatCommand should not be null");
    Assert.notNull(
        command.getSimple_FloatId(),
        "UnAssignValueFromSimple_FloatCommand identifier should not be null");
  }
}
