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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.command;

import com.occulue.api.*;
import com.occulue.command.*;
import com.occulue.controller.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller command CQRS processing for entity DCSeriesDevice.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCSeriesDevice")
public class DCSeriesDeviceCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DCSeriesDevice. if not key provided, calls create, otherwise calls save
   *
   * @param DCSeriesDevice dCSeriesDevice
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDCSeriesDeviceCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().createDCSeriesDevice(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DCSeriesDevice. if no key provided, calls create, otherwise calls save
   *
   * @param DCSeriesDevice dCSeriesDevice
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDCSeriesDeviceCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDCSeriesDeviceCommand
      // -----------------------------------------------
      completableFuture =
          DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().updateDCSeriesDevice(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DCSeriesDeviceController:update() - successfully update DCSeriesDevice - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DCSeriesDevice entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dCSeriesDeviceId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDCSeriesDeviceCommand command = new DeleteDCSeriesDeviceCommand(dCSeriesDeviceId);

    try {
      DCSeriesDeviceBusinessDelegate delegate =
          DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DCSeriesDevice with key " + command.getDCSeriesDeviceId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Inductance on DCSeriesDevice
   *
   * @param command AssignInductanceToDCSeriesDeviceCommand
   */
  @PutMapping("/assignInductance")
  public void assignInductance(@RequestBody AssignInductanceToDCSeriesDeviceCommand command) {
    try {
      DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().assignInductance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Inductance", exc);
    }
  }

  /**
   * unassign Inductance on DCSeriesDevice
   *
   * @param command UnAssignInductanceFromDCSeriesDeviceCommand
   */
  @PutMapping("/unAssignInductance")
  public void unAssignInductance(
      @RequestBody(required = true) UnAssignInductanceFromDCSeriesDeviceCommand command) {
    try {
      DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().unAssignInductance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Inductance", exc);
    }
  }

  /**
   * save RatedUdc on DCSeriesDevice
   *
   * @param command AssignRatedUdcToDCSeriesDeviceCommand
   */
  @PutMapping("/assignRatedUdc")
  public void assignRatedUdc(@RequestBody AssignRatedUdcToDCSeriesDeviceCommand command) {
    try {
      DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().assignRatedUdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedUdc", exc);
    }
  }

  /**
   * unassign RatedUdc on DCSeriesDevice
   *
   * @param command UnAssignRatedUdcFromDCSeriesDeviceCommand
   */
  @PutMapping("/unAssignRatedUdc")
  public void unAssignRatedUdc(
      @RequestBody(required = true) UnAssignRatedUdcFromDCSeriesDeviceCommand command) {
    try {
      DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().unAssignRatedUdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedUdc", exc);
    }
  }

  /**
   * save Resistance on DCSeriesDevice
   *
   * @param command AssignResistanceToDCSeriesDeviceCommand
   */
  @PutMapping("/assignResistance")
  public void assignResistance(@RequestBody AssignResistanceToDCSeriesDeviceCommand command) {
    try {
      DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().assignResistance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Resistance", exc);
    }
  }

  /**
   * unassign Resistance on DCSeriesDevice
   *
   * @param command UnAssignResistanceFromDCSeriesDeviceCommand
   */
  @PutMapping("/unAssignResistance")
  public void unAssignResistance(
      @RequestBody(required = true) UnAssignResistanceFromDCSeriesDeviceCommand command) {
    try {
      DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().unAssignResistance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Resistance", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCSeriesDevice dCSeriesDevice = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCSeriesDeviceCommandRestController.class.getName());
}
