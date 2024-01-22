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

public class GroundDisconnectorValidator {

  /** default constructor */
  protected GroundDisconnectorValidator() {}

  /** factory method */
  public static GroundDisconnectorValidator getInstance() {
    return new GroundDisconnectorValidator();
  }

  /** handles creation validation for a GroundDisconnector */
  public void validate(CreateGroundDisconnectorCommand groundDisconnector) throws Exception {
    Assert.notNull(groundDisconnector, "CreateGroundDisconnectorCommand should not be null");
    //		Assert.isNull( groundDisconnector.getGroundDisconnectorId(),
    // "CreateGroundDisconnectorCommand identifier should be null" );
  }

  /** handles update validation for a GroundDisconnector */
  public void validate(UpdateGroundDisconnectorCommand groundDisconnector) throws Exception {
    Assert.notNull(groundDisconnector, "UpdateGroundDisconnectorCommand should not be null");
    Assert.notNull(
        groundDisconnector.getGroundDisconnectorId(),
        "UpdateGroundDisconnectorCommand identifier should not be null");
  }

  /** handles delete validation for a GroundDisconnector */
  public void validate(DeleteGroundDisconnectorCommand groundDisconnector) throws Exception {
    Assert.notNull(groundDisconnector, "{commandAlias} should not be null");
    Assert.notNull(
        groundDisconnector.getGroundDisconnectorId(),
        "DeleteGroundDisconnectorCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GroundDisconnector */
  public void validate(GroundDisconnectorFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GroundDisconnectorFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGroundDisconnectorId(),
        "GroundDisconnectorFetchOneSummary identifier should not be null");
  }
}
