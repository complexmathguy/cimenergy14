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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DCLineSegmentValidator {

  /** default constructor */
  protected DCLineSegmentValidator() {}

  /** factory method */
  public static DCLineSegmentValidator getInstance() {
    return new DCLineSegmentValidator();
  }

  /** handles creation validation for a DCLineSegment */
  public void validate(CreateDCLineSegmentCommand dCLineSegment) throws Exception {
    Assert.notNull(dCLineSegment, "CreateDCLineSegmentCommand should not be null");
    //		Assert.isNull( dCLineSegment.getDCLineSegmentId(), "CreateDCLineSegmentCommand identifier
    // should be null" );
  }

  /** handles update validation for a DCLineSegment */
  public void validate(UpdateDCLineSegmentCommand dCLineSegment) throws Exception {
    Assert.notNull(dCLineSegment, "UpdateDCLineSegmentCommand should not be null");
    Assert.notNull(
        dCLineSegment.getDCLineSegmentId(),
        "UpdateDCLineSegmentCommand identifier should not be null");
  }

  /** handles delete validation for a DCLineSegment */
  public void validate(DeleteDCLineSegmentCommand dCLineSegment) throws Exception {
    Assert.notNull(dCLineSegment, "{commandAlias} should not be null");
    Assert.notNull(
        dCLineSegment.getDCLineSegmentId(),
        "DeleteDCLineSegmentCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCLineSegment */
  public void validate(DCLineSegmentFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCLineSegmentFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCLineSegmentId(), "DCLineSegmentFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Capacitance validation for a DCLineSegment
   *
   * @param command AssignCapacitanceToDCLineSegmentCommand
   */
  public void validate(AssignCapacitanceToDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignCapacitanceToDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "AssignCapacitanceToDCLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignCapacitanceToDCLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign Capacitance validation for a DCLineSegment
   *
   * @param command UnAssignCapacitanceFromDCLineSegmentCommand
   */
  public void validate(UnAssignCapacitanceFromDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCapacitanceFromDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "UnAssignCapacitanceFromDCLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign Inductance validation for a DCLineSegment
   *
   * @param command AssignInductanceToDCLineSegmentCommand
   */
  public void validate(AssignInductanceToDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignInductanceToDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "AssignInductanceToDCLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInductanceToDCLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign Inductance validation for a DCLineSegment
   *
   * @param command UnAssignInductanceFromDCLineSegmentCommand
   */
  public void validate(UnAssignInductanceFromDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInductanceFromDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "UnAssignInductanceFromDCLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign Length validation for a DCLineSegment
   *
   * @param command AssignLengthToDCLineSegmentCommand
   */
  public void validate(AssignLengthToDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignLengthToDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "AssignLengthToDCLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignLengthToDCLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign Length validation for a DCLineSegment
   *
   * @param command UnAssignLengthFromDCLineSegmentCommand
   */
  public void validate(UnAssignLengthFromDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLengthFromDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "UnAssignLengthFromDCLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign Resistance validation for a DCLineSegment
   *
   * @param command AssignResistanceToDCLineSegmentCommand
   */
  public void validate(AssignResistanceToDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignResistanceToDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "AssignResistanceToDCLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignResistanceToDCLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign Resistance validation for a DCLineSegment
   *
   * @param command UnAssignResistanceFromDCLineSegmentCommand
   */
  public void validate(UnAssignResistanceFromDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignResistanceFromDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "UnAssignResistanceFromDCLineSegmentCommand identifier should not be null");
  }

  /**
   * handles add to DCLineSegments validation for a DCLineSegment
   *
   * @param command AssignDCLineSegmentsToDCLineSegmentCommand
   */
  public void validate(AssignDCLineSegmentsToDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignDCLineSegmentsToDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "AssignDCLineSegmentsToDCLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignDCLineSegmentsToDCLineSegmentCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DCLineSegments validation for a DCLineSegment
   *
   * @param command RemoveDCLineSegmentsFromDCLineSegmentCommand
   */
  public void validate(RemoveDCLineSegmentsFromDCLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "RemoveDCLineSegmentsFromDCLineSegmentCommand should not be null");
    Assert.notNull(
        command.getDCLineSegmentId(),
        "RemoveDCLineSegmentsFromDCLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDCLineSegmentsFromDCLineSegmentCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDCLineSegmentId(),
        "RemoveDCLineSegmentsFromDCLineSegmentCommand removeFrom attribubte identifier should not be null");
  }
}
