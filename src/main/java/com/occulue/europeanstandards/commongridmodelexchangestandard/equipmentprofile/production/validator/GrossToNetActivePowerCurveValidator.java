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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class GrossToNetActivePowerCurveValidator {

  /** default constructor */
  protected GrossToNetActivePowerCurveValidator() {}

  /** factory method */
  public static GrossToNetActivePowerCurveValidator getInstance() {
    return new GrossToNetActivePowerCurveValidator();
  }

  /** handles creation validation for a GrossToNetActivePowerCurve */
  public void validate(CreateGrossToNetActivePowerCurveCommand grossToNetActivePowerCurve)
      throws Exception {
    Assert.notNull(
        grossToNetActivePowerCurve, "CreateGrossToNetActivePowerCurveCommand should not be null");
    //		Assert.isNull( grossToNetActivePowerCurve.getGrossToNetActivePowerCurveId(),
    // "CreateGrossToNetActivePowerCurveCommand identifier should be null" );
  }

  /** handles update validation for a GrossToNetActivePowerCurve */
  public void validate(UpdateGrossToNetActivePowerCurveCommand grossToNetActivePowerCurve)
      throws Exception {
    Assert.notNull(
        grossToNetActivePowerCurve, "UpdateGrossToNetActivePowerCurveCommand should not be null");
    Assert.notNull(
        grossToNetActivePowerCurve.getGrossToNetActivePowerCurveId(),
        "UpdateGrossToNetActivePowerCurveCommand identifier should not be null");
  }

  /** handles delete validation for a GrossToNetActivePowerCurve */
  public void validate(DeleteGrossToNetActivePowerCurveCommand grossToNetActivePowerCurve)
      throws Exception {
    Assert.notNull(grossToNetActivePowerCurve, "{commandAlias} should not be null");
    Assert.notNull(
        grossToNetActivePowerCurve.getGrossToNetActivePowerCurveId(),
        "DeleteGrossToNetActivePowerCurveCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GrossToNetActivePowerCurve */
  public void validate(GrossToNetActivePowerCurveFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GrossToNetActivePowerCurveFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGrossToNetActivePowerCurveId(),
        "GrossToNetActivePowerCurveFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to GrossToNetActivePowerCurves validation for a GrossToNetActivePowerCurve
   *
   * @param command AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand
   */
  public void validate(AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand should not be null");
    Assert.notNull(
        command.getGrossToNetActivePowerCurveId(),
        "AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand addTo attribute should not be null");
  }

  /**
   * handles remove from GrossToNetActivePowerCurves validation for a GrossToNetActivePowerCurve
   *
   * @param command RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand
   */
  public void validate(
      RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand should not be null");
    Assert.notNull(
        command.getGrossToNetActivePowerCurveId(),
        "RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getGrossToNetActivePowerCurveId(),
        "RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand removeFrom attribubte identifier should not be null");
  }
}
