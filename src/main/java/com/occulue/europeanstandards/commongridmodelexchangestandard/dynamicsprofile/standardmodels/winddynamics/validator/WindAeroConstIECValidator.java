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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class WindAeroConstIECValidator {

  /** default constructor */
  protected WindAeroConstIECValidator() {}

  /** factory method */
  public static WindAeroConstIECValidator getInstance() {
    return new WindAeroConstIECValidator();
  }

  /** handles creation validation for a WindAeroConstIEC */
  public void validate(CreateWindAeroConstIECCommand windAeroConstIEC) throws Exception {
    Assert.notNull(windAeroConstIEC, "CreateWindAeroConstIECCommand should not be null");
    //		Assert.isNull( windAeroConstIEC.getWindAeroConstIECId(), "CreateWindAeroConstIECCommand
    // identifier should be null" );
  }

  /** handles update validation for a WindAeroConstIEC */
  public void validate(UpdateWindAeroConstIECCommand windAeroConstIEC) throws Exception {
    Assert.notNull(windAeroConstIEC, "UpdateWindAeroConstIECCommand should not be null");
    Assert.notNull(
        windAeroConstIEC.getWindAeroConstIECId(),
        "UpdateWindAeroConstIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindAeroConstIEC */
  public void validate(DeleteWindAeroConstIECCommand windAeroConstIEC) throws Exception {
    Assert.notNull(windAeroConstIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windAeroConstIEC.getWindAeroConstIECId(),
        "DeleteWindAeroConstIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindAeroConstIEC */
  public void validate(WindAeroConstIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindAeroConstIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindAeroConstIECId(),
        "WindAeroConstIECFetchOneSummary identifier should not be null");
  }
}
