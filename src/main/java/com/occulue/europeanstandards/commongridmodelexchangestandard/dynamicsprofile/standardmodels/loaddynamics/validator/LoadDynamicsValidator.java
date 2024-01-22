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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class LoadDynamicsValidator {

  /** default constructor */
  protected LoadDynamicsValidator() {}

  /** factory method */
  public static LoadDynamicsValidator getInstance() {
    return new LoadDynamicsValidator();
  }

  /** handles creation validation for a LoadDynamics */
  public void validate(CreateLoadDynamicsCommand loadDynamics) throws Exception {
    Assert.notNull(loadDynamics, "CreateLoadDynamicsCommand should not be null");
    //		Assert.isNull( loadDynamics.getLoadDynamicsId(), "CreateLoadDynamicsCommand identifier
    // should be null" );
  }

  /** handles update validation for a LoadDynamics */
  public void validate(UpdateLoadDynamicsCommand loadDynamics) throws Exception {
    Assert.notNull(loadDynamics, "UpdateLoadDynamicsCommand should not be null");
    Assert.notNull(
        loadDynamics.getLoadDynamicsId(),
        "UpdateLoadDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a LoadDynamics */
  public void validate(DeleteLoadDynamicsCommand loadDynamics) throws Exception {
    Assert.notNull(loadDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        loadDynamics.getLoadDynamicsId(),
        "DeleteLoadDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LoadDynamics */
  public void validate(LoadDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LoadDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLoadDynamicsId(), "LoadDynamicsFetchOneSummary identifier should not be null");
  }
}
