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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DecimalProxyValidator {

  /** default constructor */
  protected DecimalProxyValidator() {}

  /** factory method */
  public static DecimalProxyValidator getInstance() {
    return new DecimalProxyValidator();
  }

  /** handles creation validation for a DecimalProxy */
  public void validate(CreateDecimalProxyCommand decimalProxy) throws Exception {
    Assert.notNull(decimalProxy, "CreateDecimalProxyCommand should not be null");
    //		Assert.isNull( decimalProxy.getDecimalProxyId(), "CreateDecimalProxyCommand identifier
    // should be null" );
  }

  /** handles update validation for a DecimalProxy */
  public void validate(UpdateDecimalProxyCommand decimalProxy) throws Exception {
    Assert.notNull(decimalProxy, "UpdateDecimalProxyCommand should not be null");
    Assert.notNull(
        decimalProxy.getDecimalProxyId(),
        "UpdateDecimalProxyCommand identifier should not be null");
  }

  /** handles delete validation for a DecimalProxy */
  public void validate(DeleteDecimalProxyCommand decimalProxy) throws Exception {
    Assert.notNull(decimalProxy, "{commandAlias} should not be null");
    Assert.notNull(
        decimalProxy.getDecimalProxyId(),
        "DeleteDecimalProxyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DecimalProxy */
  public void validate(DecimalProxyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DecimalProxyFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDecimalProxyId(), "DecimalProxyFetchOneSummary identifier should not be null");
  }
}
