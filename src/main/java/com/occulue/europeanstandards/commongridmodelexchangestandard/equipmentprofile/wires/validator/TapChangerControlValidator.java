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

public class TapChangerControlValidator {

  /** default constructor */
  protected TapChangerControlValidator() {}

  /** factory method */
  public static TapChangerControlValidator getInstance() {
    return new TapChangerControlValidator();
  }

  /** handles creation validation for a TapChangerControl */
  public void validate(CreateTapChangerControlCommand tapChangerControl) throws Exception {
    Assert.notNull(tapChangerControl, "CreateTapChangerControlCommand should not be null");
    //		Assert.isNull( tapChangerControl.getTapChangerControlId(), "CreateTapChangerControlCommand
    // identifier should be null" );
  }

  /** handles update validation for a TapChangerControl */
  public void validate(UpdateTapChangerControlCommand tapChangerControl) throws Exception {
    Assert.notNull(tapChangerControl, "UpdateTapChangerControlCommand should not be null");
    Assert.notNull(
        tapChangerControl.getTapChangerControlId(),
        "UpdateTapChangerControlCommand identifier should not be null");
  }

  /** handles delete validation for a TapChangerControl */
  public void validate(DeleteTapChangerControlCommand tapChangerControl) throws Exception {
    Assert.notNull(tapChangerControl, "{commandAlias} should not be null");
    Assert.notNull(
        tapChangerControl.getTapChangerControlId(),
        "DeleteTapChangerControlCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TapChangerControl */
  public void validate(TapChangerControlFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TapChangerControlFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTapChangerControlId(),
        "TapChangerControlFetchOneSummary identifier should not be null");
  }
}
