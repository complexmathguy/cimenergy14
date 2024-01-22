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

public class BreakerValidator {

  /** default constructor */
  protected BreakerValidator() {}

  /** factory method */
  public static BreakerValidator getInstance() {
    return new BreakerValidator();
  }

  /** handles creation validation for a Breaker */
  public void validate(CreateBreakerCommand breaker) throws Exception {
    Assert.notNull(breaker, "CreateBreakerCommand should not be null");
    //		Assert.isNull( breaker.getBreakerId(), "CreateBreakerCommand identifier should be null" );
  }

  /** handles update validation for a Breaker */
  public void validate(UpdateBreakerCommand breaker) throws Exception {
    Assert.notNull(breaker, "UpdateBreakerCommand should not be null");
    Assert.notNull(breaker.getBreakerId(), "UpdateBreakerCommand identifier should not be null");
  }

  /** handles delete validation for a Breaker */
  public void validate(DeleteBreakerCommand breaker) throws Exception {
    Assert.notNull(breaker, "{commandAlias} should not be null");
    Assert.notNull(breaker.getBreakerId(), "DeleteBreakerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Breaker */
  public void validate(BreakerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "BreakerFetchOneSummary should not be null");
    Assert.notNull(summary.getBreakerId(), "BreakerFetchOneSummary identifier should not be null");
  }
}
