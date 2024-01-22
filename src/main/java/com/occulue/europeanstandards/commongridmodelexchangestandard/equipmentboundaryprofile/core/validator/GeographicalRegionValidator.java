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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class GeographicalRegionValidator {

  /** default constructor */
  protected GeographicalRegionValidator() {}

  /** factory method */
  public static GeographicalRegionValidator getInstance() {
    return new GeographicalRegionValidator();
  }

  /** handles creation validation for a GeographicalRegion */
  public void validate(CreateGeographicalRegionCommand geographicalRegion) throws Exception {
    Assert.notNull(geographicalRegion, "CreateGeographicalRegionCommand should not be null");
    //		Assert.isNull( geographicalRegion.getGeographicalRegionId(),
    // "CreateGeographicalRegionCommand identifier should be null" );
  }

  /** handles update validation for a GeographicalRegion */
  public void validate(UpdateGeographicalRegionCommand geographicalRegion) throws Exception {
    Assert.notNull(geographicalRegion, "UpdateGeographicalRegionCommand should not be null");
    Assert.notNull(
        geographicalRegion.getGeographicalRegionId(),
        "UpdateGeographicalRegionCommand identifier should not be null");
  }

  /** handles delete validation for a GeographicalRegion */
  public void validate(DeleteGeographicalRegionCommand geographicalRegion) throws Exception {
    Assert.notNull(geographicalRegion, "{commandAlias} should not be null");
    Assert.notNull(
        geographicalRegion.getGeographicalRegionId(),
        "DeleteGeographicalRegionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GeographicalRegion */
  public void validate(GeographicalRegionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GeographicalRegionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGeographicalRegionId(),
        "GeographicalRegionFetchOneSummary identifier should not be null");
  }
}
