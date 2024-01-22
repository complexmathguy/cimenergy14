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

public class FloatProxyValidator {

  /** default constructor */
  protected FloatProxyValidator() {}

  /** factory method */
  public static FloatProxyValidator getInstance() {
    return new FloatProxyValidator();
  }

  /** handles creation validation for a FloatProxy */
  public void validate(CreateFloatProxyCommand floatProxy) throws Exception {
    Assert.notNull(floatProxy, "CreateFloatProxyCommand should not be null");
    //		Assert.isNull( floatProxy.getFloatProxyId(), "CreateFloatProxyCommand identifier should be
    // null" );
  }

  /** handles update validation for a FloatProxy */
  public void validate(UpdateFloatProxyCommand floatProxy) throws Exception {
    Assert.notNull(floatProxy, "UpdateFloatProxyCommand should not be null");
    Assert.notNull(
        floatProxy.getFloatProxyId(), "UpdateFloatProxyCommand identifier should not be null");
  }

  /** handles delete validation for a FloatProxy */
  public void validate(DeleteFloatProxyCommand floatProxy) throws Exception {
    Assert.notNull(floatProxy, "{commandAlias} should not be null");
    Assert.notNull(
        floatProxy.getFloatProxyId(), "DeleteFloatProxyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a FloatProxy */
  public void validate(FloatProxyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "FloatProxyFetchOneSummary should not be null");
    Assert.notNull(
        summary.getFloatProxyId(), "FloatProxyFetchOneSummary identifier should not be null");
  }
}
