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

public class DCChopperValidator {

  /** default constructor */
  protected DCChopperValidator() {}

  /** factory method */
  public static DCChopperValidator getInstance() {
    return new DCChopperValidator();
  }

  /** handles creation validation for a DCChopper */
  public void validate(CreateDCChopperCommand dCChopper) throws Exception {
    Assert.notNull(dCChopper, "CreateDCChopperCommand should not be null");
    //		Assert.isNull( dCChopper.getDCChopperId(), "CreateDCChopperCommand identifier should be
    // null" );
  }

  /** handles update validation for a DCChopper */
  public void validate(UpdateDCChopperCommand dCChopper) throws Exception {
    Assert.notNull(dCChopper, "UpdateDCChopperCommand should not be null");
    Assert.notNull(
        dCChopper.getDCChopperId(), "UpdateDCChopperCommand identifier should not be null");
  }

  /** handles delete validation for a DCChopper */
  public void validate(DeleteDCChopperCommand dCChopper) throws Exception {
    Assert.notNull(dCChopper, "{commandAlias} should not be null");
    Assert.notNull(
        dCChopper.getDCChopperId(), "DeleteDCChopperCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCChopper */
  public void validate(DCChopperFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCChopperFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCChopperId(), "DCChopperFetchOneSummary identifier should not be null");
  }
}
