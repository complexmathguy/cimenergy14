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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DynamicsmodelValidator {

  /** default constructor */
  protected DynamicsmodelValidator() {}

  /** factory method */
  public static DynamicsmodelValidator getInstance() {
    return new DynamicsmodelValidator();
  }

  /** handles creation validation for a Dynamicsmodel */
  public void validate(CreateDynamicsmodelCommand dynamicsmodel) throws Exception {
    Assert.notNull(dynamicsmodel, "CreateDynamicsmodelCommand should not be null");
    //		Assert.isNull( dynamicsmodel.getDynamicsmodelId(), "CreateDynamicsmodelCommand identifier
    // should be null" );
  }

  /** handles update validation for a Dynamicsmodel */
  public void validate(UpdateDynamicsmodelCommand dynamicsmodel) throws Exception {
    Assert.notNull(dynamicsmodel, "UpdateDynamicsmodelCommand should not be null");
    Assert.notNull(
        dynamicsmodel.getDynamicsmodelId(),
        "UpdateDynamicsmodelCommand identifier should not be null");
  }

  /** handles delete validation for a Dynamicsmodel */
  public void validate(DeleteDynamicsmodelCommand dynamicsmodel) throws Exception {
    Assert.notNull(dynamicsmodel, "{commandAlias} should not be null");
    Assert.notNull(
        dynamicsmodel.getDynamicsmodelId(),
        "DeleteDynamicsmodelCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Dynamicsmodel */
  public void validate(DynamicsmodelFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DynamicsmodelFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDynamicsmodelId(), "DynamicsmodelFetchOneSummary identifier should not be null");
  }
}
