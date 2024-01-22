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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class CoordinateSystemValidator {

  /** default constructor */
  protected CoordinateSystemValidator() {}

  /** factory method */
  public static CoordinateSystemValidator getInstance() {
    return new CoordinateSystemValidator();
  }

  /** handles creation validation for a CoordinateSystem */
  public void validate(CreateCoordinateSystemCommand coordinateSystem) throws Exception {
    Assert.notNull(coordinateSystem, "CreateCoordinateSystemCommand should not be null");
    //		Assert.isNull( coordinateSystem.getCoordinateSystemId(), "CreateCoordinateSystemCommand
    // identifier should be null" );
  }

  /** handles update validation for a CoordinateSystem */
  public void validate(UpdateCoordinateSystemCommand coordinateSystem) throws Exception {
    Assert.notNull(coordinateSystem, "UpdateCoordinateSystemCommand should not be null");
    Assert.notNull(
        coordinateSystem.getCoordinateSystemId(),
        "UpdateCoordinateSystemCommand identifier should not be null");
  }

  /** handles delete validation for a CoordinateSystem */
  public void validate(DeleteCoordinateSystemCommand coordinateSystem) throws Exception {
    Assert.notNull(coordinateSystem, "{commandAlias} should not be null");
    Assert.notNull(
        coordinateSystem.getCoordinateSystemId(),
        "DeleteCoordinateSystemCommand identifier should not be null");
  }

  /** handles fetchOne validation for a CoordinateSystem */
  public void validate(CoordinateSystemFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "CoordinateSystemFetchOneSummary should not be null");
    Assert.notNull(
        summary.getCoordinateSystemId(),
        "CoordinateSystemFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign CrsUrn validation for a CoordinateSystem
   *
   * @param command AssignCrsUrnToCoordinateSystemCommand
   */
  public void validate(AssignCrsUrnToCoordinateSystemCommand command) throws Exception {
    Assert.notNull(command, "AssignCrsUrnToCoordinateSystemCommand should not be null");
    Assert.notNull(
        command.getCoordinateSystemId(),
        "AssignCrsUrnToCoordinateSystemCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignCrsUrnToCoordinateSystemCommand assignment should not be null");
  }

  /**
   * handles unassign CrsUrn validation for a CoordinateSystem
   *
   * @param command UnAssignCrsUrnFromCoordinateSystemCommand
   */
  public void validate(UnAssignCrsUrnFromCoordinateSystemCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCrsUrnFromCoordinateSystemCommand should not be null");
    Assert.notNull(
        command.getCoordinateSystemId(),
        "UnAssignCrsUrnFromCoordinateSystemCommand identifier should not be null");
  }
}
