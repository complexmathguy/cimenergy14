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

public class StringProxyValidator {

  /** default constructor */
  protected StringProxyValidator() {}

  /** factory method */
  public static StringProxyValidator getInstance() {
    return new StringProxyValidator();
  }

  /** handles creation validation for a StringProxy */
  public void validate(CreateStringProxyCommand stringProxy) throws Exception {
    Assert.notNull(stringProxy, "CreateStringProxyCommand should not be null");
    //		Assert.isNull( stringProxy.getStringProxyId(), "CreateStringProxyCommand identifier should
    // be null" );
  }

  /** handles update validation for a StringProxy */
  public void validate(UpdateStringProxyCommand stringProxy) throws Exception {
    Assert.notNull(stringProxy, "UpdateStringProxyCommand should not be null");
    Assert.notNull(
        stringProxy.getStringProxyId(), "UpdateStringProxyCommand identifier should not be null");
  }

  /** handles delete validation for a StringProxy */
  public void validate(DeleteStringProxyCommand stringProxy) throws Exception {
    Assert.notNull(stringProxy, "{commandAlias} should not be null");
    Assert.notNull(
        stringProxy.getStringProxyId(), "DeleteStringProxyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a StringProxy */
  public void validate(StringProxyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "StringProxyFetchOneSummary should not be null");
    Assert.notNull(
        summary.getStringProxyId(), "StringProxyFetchOneSummary identifier should not be null");
  }
}
