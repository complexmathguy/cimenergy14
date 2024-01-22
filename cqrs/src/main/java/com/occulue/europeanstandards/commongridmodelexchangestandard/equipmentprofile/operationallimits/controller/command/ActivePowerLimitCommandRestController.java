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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ActivePowerLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePowerLimit")
public class ActivePowerLimitCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ActivePowerLimit. if not key provided, calls create, otherwise calls save
   *
   * @param ActivePowerLimit activePowerLimit
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateActivePowerLimitCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance()
              .createActivePowerLimit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ActivePowerLimit. if no key provided, calls create, otherwise calls save
   *
   * @param ActivePowerLimit activePowerLimit
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateActivePowerLimitCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateActivePowerLimitCommand
      // -----------------------------------------------
      completableFuture =
          ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance()
              .updateActivePowerLimit(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ActivePowerLimitController:update() - successfully update ActivePowerLimit - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ActivePowerLimit entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID activePowerLimitId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteActivePowerLimitCommand command = new DeleteActivePowerLimitCommand(activePowerLimitId);

    try {
      ActivePowerLimitBusinessDelegate delegate =
          ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ActivePowerLimit with key " + command.getActivePowerLimitId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on ActivePowerLimit
   *
   * @param command AssignValueToActivePowerLimitCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToActivePowerLimitCommand command) {
    try {
      ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on ActivePowerLimit
   *
   * @param command UnAssignValueFromActivePowerLimitCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromActivePowerLimitCommand command) {
    try {
      ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ActivePowerLimit activePowerLimit = null;
  private static final Logger LOGGER =
      Logger.getLogger(ActivePowerLimitCommandRestController.class.getName());
}
