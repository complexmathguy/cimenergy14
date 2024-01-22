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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class StationSupplyValidator {

  /** default constructor */
  protected StationSupplyValidator() {}

  /** factory method */
  public static StationSupplyValidator getInstance() {
    return new StationSupplyValidator();
  }

  /** handles creation validation for a StationSupply */
  public void validate(CreateStationSupplyCommand stationSupply) throws Exception {
    Assert.notNull(stationSupply, "CreateStationSupplyCommand should not be null");
    //		Assert.isNull( stationSupply.getStationSupplyId(), "CreateStationSupplyCommand identifier
    // should be null" );
  }

  /** handles update validation for a StationSupply */
  public void validate(UpdateStationSupplyCommand stationSupply) throws Exception {
    Assert.notNull(stationSupply, "UpdateStationSupplyCommand should not be null");
    Assert.notNull(
        stationSupply.getStationSupplyId(),
        "UpdateStationSupplyCommand identifier should not be null");
  }

  /** handles delete validation for a StationSupply */
  public void validate(DeleteStationSupplyCommand stationSupply) throws Exception {
    Assert.notNull(stationSupply, "{commandAlias} should not be null");
    Assert.notNull(
        stationSupply.getStationSupplyId(),
        "DeleteStationSupplyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a StationSupply */
  public void validate(StationSupplyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "StationSupplyFetchOneSummary should not be null");
    Assert.notNull(
        summary.getStationSupplyId(), "StationSupplyFetchOneSummary identifier should not be null");
  }
}
