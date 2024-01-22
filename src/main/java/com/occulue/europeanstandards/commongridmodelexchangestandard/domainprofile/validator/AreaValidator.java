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

public class AreaValidator {

  /** default constructor */
  protected AreaValidator() {}

  /** factory method */
  public static AreaValidator getInstance() {
    return new AreaValidator();
  }

  /** handles creation validation for a Area */
  public void validate(CreateAreaCommand area) throws Exception {
    Assert.notNull(area, "CreateAreaCommand should not be null");
    //		Assert.isNull( area.getAreaId(), "CreateAreaCommand identifier should be null" );
  }

  /** handles update validation for a Area */
  public void validate(UpdateAreaCommand area) throws Exception {
    Assert.notNull(area, "UpdateAreaCommand should not be null");
    Assert.notNull(area.getAreaId(), "UpdateAreaCommand identifier should not be null");
  }

  /** handles delete validation for a Area */
  public void validate(DeleteAreaCommand area) throws Exception {
    Assert.notNull(area, "{commandAlias} should not be null");
    Assert.notNull(area.getAreaId(), "DeleteAreaCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Area */
  public void validate(AreaFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AreaFetchOneSummary should not be null");
    Assert.notNull(summary.getAreaId(), "AreaFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Area
   *
   * @param command AssignValueToAreaCommand
   */
  public void validate(AssignValueToAreaCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToAreaCommand should not be null");
    Assert.notNull(command.getAreaId(), "AssignValueToAreaCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToAreaCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Area
   *
   * @param command UnAssignValueFromAreaCommand
   */
  public void validate(UnAssignValueFromAreaCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromAreaCommand should not be null");
    Assert.notNull(
        command.getAreaId(), "UnAssignValueFromAreaCommand identifier should not be null");
  }
}
