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

public class PhaseTapChangerTabularValidator {

  /** default constructor */
  protected PhaseTapChangerTabularValidator() {}

  /** factory method */
  public static PhaseTapChangerTabularValidator getInstance() {
    return new PhaseTapChangerTabularValidator();
  }

  /** handles creation validation for a PhaseTapChangerTabular */
  public void validate(CreatePhaseTapChangerTabularCommand phaseTapChangerTabular)
      throws Exception {
    Assert.notNull(
        phaseTapChangerTabular, "CreatePhaseTapChangerTabularCommand should not be null");
    //		Assert.isNull( phaseTapChangerTabular.getPhaseTapChangerTabularId(),
    // "CreatePhaseTapChangerTabularCommand identifier should be null" );
  }

  /** handles update validation for a PhaseTapChangerTabular */
  public void validate(UpdatePhaseTapChangerTabularCommand phaseTapChangerTabular)
      throws Exception {
    Assert.notNull(
        phaseTapChangerTabular, "UpdatePhaseTapChangerTabularCommand should not be null");
    Assert.notNull(
        phaseTapChangerTabular.getPhaseTapChangerTabularId(),
        "UpdatePhaseTapChangerTabularCommand identifier should not be null");
  }

  /** handles delete validation for a PhaseTapChangerTabular */
  public void validate(DeletePhaseTapChangerTabularCommand phaseTapChangerTabular)
      throws Exception {
    Assert.notNull(phaseTapChangerTabular, "{commandAlias} should not be null");
    Assert.notNull(
        phaseTapChangerTabular.getPhaseTapChangerTabularId(),
        "DeletePhaseTapChangerTabularCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PhaseTapChangerTabular */
  public void validate(PhaseTapChangerTabularFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PhaseTapChangerTabularFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPhaseTapChangerTabularId(),
        "PhaseTapChangerTabularFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to PhaseTapChangerTabular validation for a PhaseTapChangerTabular
   *
   * @param command AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand
   */
  public void validate(AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerTabularId(),
        "AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand addTo attribute should not be null");
  }

  /**
   * handles remove from PhaseTapChangerTabular validation for a PhaseTapChangerTabular
   *
   * @param command RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand
   */
  public void validate(RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerTabularId(),
        "RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getPhaseTapChangerTabularId(),
        "RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand removeFrom attribubte identifier should not be null");
  }
}
