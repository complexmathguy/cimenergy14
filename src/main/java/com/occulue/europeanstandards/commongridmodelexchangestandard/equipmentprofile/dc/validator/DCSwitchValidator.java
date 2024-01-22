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

public class DCSwitchValidator {

  /** default constructor */
  protected DCSwitchValidator() {}

  /** factory method */
  public static DCSwitchValidator getInstance() {
    return new DCSwitchValidator();
  }

  /** handles creation validation for a DCSwitch */
  public void validate(CreateDCSwitchCommand dCSwitch) throws Exception {
    Assert.notNull(dCSwitch, "CreateDCSwitchCommand should not be null");
    //		Assert.isNull( dCSwitch.getDCSwitchId(), "CreateDCSwitchCommand identifier should be null"
    // );
  }

  /** handles update validation for a DCSwitch */
  public void validate(UpdateDCSwitchCommand dCSwitch) throws Exception {
    Assert.notNull(dCSwitch, "UpdateDCSwitchCommand should not be null");
    Assert.notNull(dCSwitch.getDCSwitchId(), "UpdateDCSwitchCommand identifier should not be null");
  }

  /** handles delete validation for a DCSwitch */
  public void validate(DeleteDCSwitchCommand dCSwitch) throws Exception {
    Assert.notNull(dCSwitch, "{commandAlias} should not be null");
    Assert.notNull(dCSwitch.getDCSwitchId(), "DeleteDCSwitchCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCSwitch */
  public void validate(DCSwitchFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCSwitchFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCSwitchId(), "DCSwitchFetchOneSummary identifier should not be null");
  }
}
