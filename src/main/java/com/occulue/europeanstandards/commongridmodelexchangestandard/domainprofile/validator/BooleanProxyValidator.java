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

public class BooleanProxyValidator {

  /** default constructor */
  protected BooleanProxyValidator() {}

  /** factory method */
  public static BooleanProxyValidator getInstance() {
    return new BooleanProxyValidator();
  }

  /** handles creation validation for a BooleanProxy */
  public void validate(CreateBooleanProxyCommand booleanProxy) throws Exception {
    Assert.notNull(booleanProxy, "CreateBooleanProxyCommand should not be null");
    //		Assert.isNull( booleanProxy.getBooleanProxyId(), "CreateBooleanProxyCommand identifier
    // should be null" );
  }

  /** handles update validation for a BooleanProxy */
  public void validate(UpdateBooleanProxyCommand booleanProxy) throws Exception {
    Assert.notNull(booleanProxy, "UpdateBooleanProxyCommand should not be null");
    Assert.notNull(
        booleanProxy.getBooleanProxyId(),
        "UpdateBooleanProxyCommand identifier should not be null");
  }

  /** handles delete validation for a BooleanProxy */
  public void validate(DeleteBooleanProxyCommand booleanProxy) throws Exception {
    Assert.notNull(booleanProxy, "{commandAlias} should not be null");
    Assert.notNull(
        booleanProxy.getBooleanProxyId(),
        "DeleteBooleanProxyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a BooleanProxy */
  public void validate(BooleanProxyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "BooleanProxyFetchOneSummary should not be null");
    Assert.notNull(
        summary.getBooleanProxyId(), "BooleanProxyFetchOneSummary identifier should not be null");
  }
}
