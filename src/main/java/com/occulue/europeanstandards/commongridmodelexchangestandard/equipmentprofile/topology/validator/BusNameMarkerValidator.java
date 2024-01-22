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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class BusNameMarkerValidator {

  /** default constructor */
  protected BusNameMarkerValidator() {}

  /** factory method */
  public static BusNameMarkerValidator getInstance() {
    return new BusNameMarkerValidator();
  }

  /** handles creation validation for a BusNameMarker */
  public void validate(CreateBusNameMarkerCommand busNameMarker) throws Exception {
    Assert.notNull(busNameMarker, "CreateBusNameMarkerCommand should not be null");
    //		Assert.isNull( busNameMarker.getBusNameMarkerId(), "CreateBusNameMarkerCommand identifier
    // should be null" );
  }

  /** handles update validation for a BusNameMarker */
  public void validate(UpdateBusNameMarkerCommand busNameMarker) throws Exception {
    Assert.notNull(busNameMarker, "UpdateBusNameMarkerCommand should not be null");
    Assert.notNull(
        busNameMarker.getBusNameMarkerId(),
        "UpdateBusNameMarkerCommand identifier should not be null");
  }

  /** handles delete validation for a BusNameMarker */
  public void validate(DeleteBusNameMarkerCommand busNameMarker) throws Exception {
    Assert.notNull(busNameMarker, "{commandAlias} should not be null");
    Assert.notNull(
        busNameMarker.getBusNameMarkerId(),
        "DeleteBusNameMarkerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a BusNameMarker */
  public void validate(BusNameMarkerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "BusNameMarkerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getBusNameMarkerId(), "BusNameMarkerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Priority validation for a BusNameMarker
   *
   * @param command AssignPriorityToBusNameMarkerCommand
   */
  public void validate(AssignPriorityToBusNameMarkerCommand command) throws Exception {
    Assert.notNull(command, "AssignPriorityToBusNameMarkerCommand should not be null");
    Assert.notNull(
        command.getBusNameMarkerId(),
        "AssignPriorityToBusNameMarkerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPriorityToBusNameMarkerCommand assignment should not be null");
  }

  /**
   * handles unassign Priority validation for a BusNameMarker
   *
   * @param command UnAssignPriorityFromBusNameMarkerCommand
   */
  public void validate(UnAssignPriorityFromBusNameMarkerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPriorityFromBusNameMarkerCommand should not be null");
    Assert.notNull(
        command.getBusNameMarkerId(),
        "UnAssignPriorityFromBusNameMarkerCommand identifier should not be null");
  }

  /**
   * handles add to BusNameMarker validation for a BusNameMarker
   *
   * @param command AssignBusNameMarkerToBusNameMarkerCommand
   */
  public void validate(AssignBusNameMarkerToBusNameMarkerCommand command) throws Exception {
    Assert.notNull(command, "AssignBusNameMarkerToBusNameMarkerCommand should not be null");
    Assert.notNull(
        command.getBusNameMarkerId(),
        "AssignBusNameMarkerToBusNameMarkerCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignBusNameMarkerToBusNameMarkerCommand addTo attribute should not be null");
  }

  /**
   * handles remove from BusNameMarker validation for a BusNameMarker
   *
   * @param command RemoveBusNameMarkerFromBusNameMarkerCommand
   */
  public void validate(RemoveBusNameMarkerFromBusNameMarkerCommand command) throws Exception {
    Assert.notNull(command, "RemoveBusNameMarkerFromBusNameMarkerCommand should not be null");
    Assert.notNull(
        command.getBusNameMarkerId(),
        "RemoveBusNameMarkerFromBusNameMarkerCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveBusNameMarkerFromBusNameMarkerCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getBusNameMarkerId(),
        "RemoveBusNameMarkerFromBusNameMarkerCommand removeFrom attribubte identifier should not be null");
  }
}
