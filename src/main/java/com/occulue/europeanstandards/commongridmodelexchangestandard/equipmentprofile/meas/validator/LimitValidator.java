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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class LimitValidator {

  /** default constructor */
  protected LimitValidator() {}

  /** factory method */
  public static LimitValidator getInstance() {
    return new LimitValidator();
  }

  /** handles creation validation for a Limit */
  public void validate(CreateLimitCommand limit) throws Exception {
    Assert.notNull(limit, "CreateLimitCommand should not be null");
    //		Assert.isNull( limit.getLimitId(), "CreateLimitCommand identifier should be null" );
  }

  /** handles update validation for a Limit */
  public void validate(UpdateLimitCommand limit) throws Exception {
    Assert.notNull(limit, "UpdateLimitCommand should not be null");
    Assert.notNull(limit.getLimitId(), "UpdateLimitCommand identifier should not be null");
  }

  /** handles delete validation for a Limit */
  public void validate(DeleteLimitCommand limit) throws Exception {
    Assert.notNull(limit, "{commandAlias} should not be null");
    Assert.notNull(limit.getLimitId(), "DeleteLimitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Limit */
  public void validate(LimitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LimitFetchOneSummary should not be null");
    Assert.notNull(summary.getLimitId(), "LimitFetchOneSummary identifier should not be null");
  }
}
