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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class LocationValidator {

  /** default constructor */
  protected LocationValidator() {}

  /** factory method */
  public static LocationValidator getInstance() {
    return new LocationValidator();
  }

  /** handles creation validation for a Location */
  public void validate(CreateLocationCommand location) throws Exception {
    Assert.notNull(location, "CreateLocationCommand should not be null");
    //		Assert.isNull( location.getLocationId(), "CreateLocationCommand identifier should be null"
    // );
  }

  /** handles update validation for a Location */
  public void validate(UpdateLocationCommand location) throws Exception {
    Assert.notNull(location, "UpdateLocationCommand should not be null");
    Assert.notNull(location.getLocationId(), "UpdateLocationCommand identifier should not be null");
  }

  /** handles delete validation for a Location */
  public void validate(DeleteLocationCommand location) throws Exception {
    Assert.notNull(location, "{commandAlias} should not be null");
    Assert.notNull(location.getLocationId(), "DeleteLocationCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Location */
  public void validate(LocationFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LocationFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLocationId(), "LocationFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Location validation for a Location
   *
   * @param command AssignLocationToLocationCommand
   */
  public void validate(AssignLocationToLocationCommand command) throws Exception {
    Assert.notNull(command, "AssignLocationToLocationCommand should not be null");
    Assert.notNull(
        command.getLocationId(), "AssignLocationToLocationCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLocationToLocationCommand assignment should not be null");
  }

  /**
   * handles unassign Location validation for a Location
   *
   * @param command UnAssignLocationFromLocationCommand
   */
  public void validate(UnAssignLocationFromLocationCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLocationFromLocationCommand should not be null");
    Assert.notNull(
        command.getLocationId(),
        "UnAssignLocationFromLocationCommand identifier should not be null");
  }
}
