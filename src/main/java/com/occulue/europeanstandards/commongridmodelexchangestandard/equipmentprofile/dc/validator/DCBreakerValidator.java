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

public class DCBreakerValidator {

  /** default constructor */
  protected DCBreakerValidator() {}

  /** factory method */
  public static DCBreakerValidator getInstance() {
    return new DCBreakerValidator();
  }

  /** handles creation validation for a DCBreaker */
  public void validate(CreateDCBreakerCommand dCBreaker) throws Exception {
    Assert.notNull(dCBreaker, "CreateDCBreakerCommand should not be null");
    //		Assert.isNull( dCBreaker.getDCBreakerId(), "CreateDCBreakerCommand identifier should be
    // null" );
  }

  /** handles update validation for a DCBreaker */
  public void validate(UpdateDCBreakerCommand dCBreaker) throws Exception {
    Assert.notNull(dCBreaker, "UpdateDCBreakerCommand should not be null");
    Assert.notNull(
        dCBreaker.getDCBreakerId(), "UpdateDCBreakerCommand identifier should not be null");
  }

  /** handles delete validation for a DCBreaker */
  public void validate(DeleteDCBreakerCommand dCBreaker) throws Exception {
    Assert.notNull(dCBreaker, "{commandAlias} should not be null");
    Assert.notNull(
        dCBreaker.getDCBreakerId(), "DeleteDCBreakerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCBreaker */
  public void validate(DCBreakerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCBreakerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCBreakerId(), "DCBreakerFetchOneSummary identifier should not be null");
  }
}
