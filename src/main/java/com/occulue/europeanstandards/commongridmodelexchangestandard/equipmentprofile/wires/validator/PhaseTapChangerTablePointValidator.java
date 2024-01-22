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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PhaseTapChangerTablePointValidator {

  /** default constructor */
  protected PhaseTapChangerTablePointValidator() {}

  /** factory method */
  public static PhaseTapChangerTablePointValidator getInstance() {
    return new PhaseTapChangerTablePointValidator();
  }

  /** handles creation validation for a PhaseTapChangerTablePoint */
  public void validate(CreatePhaseTapChangerTablePointCommand phaseTapChangerTablePoint)
      throws Exception {
    Assert.notNull(
        phaseTapChangerTablePoint, "CreatePhaseTapChangerTablePointCommand should not be null");
    //		Assert.isNull( phaseTapChangerTablePoint.getPhaseTapChangerTablePointId(),
    // "CreatePhaseTapChangerTablePointCommand identifier should be null" );
  }

  /** handles update validation for a PhaseTapChangerTablePoint */
  public void validate(UpdatePhaseTapChangerTablePointCommand phaseTapChangerTablePoint)
      throws Exception {
    Assert.notNull(
        phaseTapChangerTablePoint, "UpdatePhaseTapChangerTablePointCommand should not be null");
    Assert.notNull(
        phaseTapChangerTablePoint.getPhaseTapChangerTablePointId(),
        "UpdatePhaseTapChangerTablePointCommand identifier should not be null");
  }

  /** handles delete validation for a PhaseTapChangerTablePoint */
  public void validate(DeletePhaseTapChangerTablePointCommand phaseTapChangerTablePoint)
      throws Exception {
    Assert.notNull(phaseTapChangerTablePoint, "{commandAlias} should not be null");
    Assert.notNull(
        phaseTapChangerTablePoint.getPhaseTapChangerTablePointId(),
        "DeletePhaseTapChangerTablePointCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PhaseTapChangerTablePoint */
  public void validate(PhaseTapChangerTablePointFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PhaseTapChangerTablePointFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPhaseTapChangerTablePointId(),
        "PhaseTapChangerTablePointFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Angle validation for a PhaseTapChangerTablePoint
   *
   * @param command AssignAngleToPhaseTapChangerTablePointCommand
   */
  public void validate(AssignAngleToPhaseTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "AssignAngleToPhaseTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerTablePointId(),
        "AssignAngleToPhaseTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignAngleToPhaseTapChangerTablePointCommand assignment should not be null");
  }

  /**
   * handles unassign Angle validation for a PhaseTapChangerTablePoint
   *
   * @param command UnAssignAngleFromPhaseTapChangerTablePointCommand
   */
  public void validate(UnAssignAngleFromPhaseTapChangerTablePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAngleFromPhaseTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerTablePointId(),
        "UnAssignAngleFromPhaseTapChangerTablePointCommand identifier should not be null");
  }

  /**
   * handles add to PhaseTapChangerTablePoint validation for a PhaseTapChangerTablePoint
   *
   * @param command AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand
   */
  public void validate(AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerTablePointId(),
        "AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand addTo attribute should not be null");
  }

  /**
   * handles remove from PhaseTapChangerTablePoint validation for a PhaseTapChangerTablePoint
   *
   * @param command RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand
   */
  public void validate(RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerTablePointId(),
        "RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getPhaseTapChangerTablePointId(),
        "RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand removeFrom attribubte identifier should not be null");
  }
}
