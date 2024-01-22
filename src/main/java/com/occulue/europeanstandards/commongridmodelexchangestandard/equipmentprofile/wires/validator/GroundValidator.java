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

public class GroundValidator {

  /** default constructor */
  protected GroundValidator() {}

  /** factory method */
  public static GroundValidator getInstance() {
    return new GroundValidator();
  }

  /** handles creation validation for a Ground */
  public void validate(CreateGroundCommand ground) throws Exception {
    Assert.notNull(ground, "CreateGroundCommand should not be null");
    //		Assert.isNull( ground.getGroundId(), "CreateGroundCommand identifier should be null" );
  }

  /** handles update validation for a Ground */
  public void validate(UpdateGroundCommand ground) throws Exception {
    Assert.notNull(ground, "UpdateGroundCommand should not be null");
    Assert.notNull(ground.getGroundId(), "UpdateGroundCommand identifier should not be null");
  }

  /** handles delete validation for a Ground */
  public void validate(DeleteGroundCommand ground) throws Exception {
    Assert.notNull(ground, "{commandAlias} should not be null");
    Assert.notNull(ground.getGroundId(), "DeleteGroundCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Ground */
  public void validate(GroundFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GroundFetchOneSummary should not be null");
    Assert.notNull(summary.getGroundId(), "GroundFetchOneSummary identifier should not be null");
  }
}
