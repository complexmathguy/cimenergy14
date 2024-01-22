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

public class PhaseTapChangerAsymmetricalValidator {

  /** default constructor */
  protected PhaseTapChangerAsymmetricalValidator() {}

  /** factory method */
  public static PhaseTapChangerAsymmetricalValidator getInstance() {
    return new PhaseTapChangerAsymmetricalValidator();
  }

  /** handles creation validation for a PhaseTapChangerAsymmetrical */
  public void validate(CreatePhaseTapChangerAsymmetricalCommand phaseTapChangerAsymmetrical)
      throws Exception {
    Assert.notNull(
        phaseTapChangerAsymmetrical, "CreatePhaseTapChangerAsymmetricalCommand should not be null");
    //		Assert.isNull( phaseTapChangerAsymmetrical.getPhaseTapChangerAsymmetricalId(),
    // "CreatePhaseTapChangerAsymmetricalCommand identifier should be null" );
  }

  /** handles update validation for a PhaseTapChangerAsymmetrical */
  public void validate(UpdatePhaseTapChangerAsymmetricalCommand phaseTapChangerAsymmetrical)
      throws Exception {
    Assert.notNull(
        phaseTapChangerAsymmetrical, "UpdatePhaseTapChangerAsymmetricalCommand should not be null");
    Assert.notNull(
        phaseTapChangerAsymmetrical.getPhaseTapChangerAsymmetricalId(),
        "UpdatePhaseTapChangerAsymmetricalCommand identifier should not be null");
  }

  /** handles delete validation for a PhaseTapChangerAsymmetrical */
  public void validate(DeletePhaseTapChangerAsymmetricalCommand phaseTapChangerAsymmetrical)
      throws Exception {
    Assert.notNull(phaseTapChangerAsymmetrical, "{commandAlias} should not be null");
    Assert.notNull(
        phaseTapChangerAsymmetrical.getPhaseTapChangerAsymmetricalId(),
        "DeletePhaseTapChangerAsymmetricalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PhaseTapChangerAsymmetrical */
  public void validate(PhaseTapChangerAsymmetricalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PhaseTapChangerAsymmetricalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPhaseTapChangerAsymmetricalId(),
        "PhaseTapChangerAsymmetricalFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindingConnectionAngle validation for a PhaseTapChangerAsymmetrical
   *
   * @param command AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand
   */
  public void validate(AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerAsymmetricalId(),
        "AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand assignment should not be null");
  }

  /**
   * handles unassign WindingConnectionAngle validation for a PhaseTapChangerAsymmetrical
   *
   * @param command UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalCommand
   */
  public void validate(UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerAsymmetricalId(),
        "UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalCommand identifier should not be null");
  }
}
