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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Control.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Control")
public class ControlCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Control. if not key provided, calls create, otherwise calls save
   *
   * @param Control control
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateControlCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ControlBusinessDelegate.getControlInstance().createControl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Control. if no key provided, calls create, otherwise calls save
   *
   * @param Control control
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateControlCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateControlCommand
      // -----------------------------------------------
      completableFuture = ControlBusinessDelegate.getControlInstance().updateControl(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ControlController:update() - successfully update Control - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Control entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID controlId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteControlCommand command = new DeleteControlCommand(controlId);

    try {
      ControlBusinessDelegate delegate = ControlBusinessDelegate.getControlInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Control with key " + command.getControlId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save ControlType on Control
   *
   * @param command AssignControlTypeToControlCommand
   */
  @PutMapping("/assignControlType")
  public void assignControlType(@RequestBody AssignControlTypeToControlCommand command) {
    try {
      ControlBusinessDelegate.getControlInstance().assignControlType(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ControlType", exc);
    }
  }

  /**
   * unassign ControlType on Control
   *
   * @param command UnAssignControlTypeFromControlCommand
   */
  @PutMapping("/unAssignControlType")
  public void unAssignControlType(
      @RequestBody(required = true) UnAssignControlTypeFromControlCommand command) {
    try {
      ControlBusinessDelegate.getControlInstance().unAssignControlType(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ControlType", exc);
    }
  }

  /**
   * save OperationInProgress on Control
   *
   * @param command AssignOperationInProgressToControlCommand
   */
  @PutMapping("/assignOperationInProgress")
  public void assignOperationInProgress(
      @RequestBody AssignOperationInProgressToControlCommand command) {
    try {
      ControlBusinessDelegate.getControlInstance().assignOperationInProgress(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OperationInProgress", exc);
    }
  }

  /**
   * unassign OperationInProgress on Control
   *
   * @param command UnAssignOperationInProgressFromControlCommand
   */
  @PutMapping("/unAssignOperationInProgress")
  public void unAssignOperationInProgress(
      @RequestBody(required = true) UnAssignOperationInProgressFromControlCommand command) {
    try {
      ControlBusinessDelegate.getControlInstance().unAssignOperationInProgress(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OperationInProgress", exc);
    }
  }

  /**
   * save TimeStamp on Control
   *
   * @param command AssignTimeStampToControlCommand
   */
  @PutMapping("/assignTimeStamp")
  public void assignTimeStamp(@RequestBody AssignTimeStampToControlCommand command) {
    try {
      ControlBusinessDelegate.getControlInstance().assignTimeStamp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign TimeStamp", exc);
    }
  }

  /**
   * unassign TimeStamp on Control
   *
   * @param command UnAssignTimeStampFromControlCommand
   */
  @PutMapping("/unAssignTimeStamp")
  public void unAssignTimeStamp(
      @RequestBody(required = true) UnAssignTimeStampFromControlCommand command) {
    try {
      ControlBusinessDelegate.getControlInstance().unAssignTimeStamp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign TimeStamp", exc);
    }
  }

  /**
   * save Controls on Control
   *
   * @param command AssignControlsToControlCommand
   */
  @PutMapping("/addToControls")
  public void addToControls(@RequestBody(required = true) AssignControlsToControlCommand command) {
    try {
      ControlBusinessDelegate.getControlInstance().addToControls(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Controls", exc);
    }
  }

  /**
   * remove Controls on Control
   *
   * @param command RemoveControlsFromControlCommand
   */
  @PutMapping("/removeFromControls")
  public void removeFromControls(
      @RequestBody(required = true) RemoveControlsFromControlCommand command) {
    try {
      ControlBusinessDelegate.getControlInstance().removeFromControls(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Controls", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Control control = null;
  private static final Logger LOGGER =
      Logger.getLogger(ControlCommandRestController.class.getName());
}
