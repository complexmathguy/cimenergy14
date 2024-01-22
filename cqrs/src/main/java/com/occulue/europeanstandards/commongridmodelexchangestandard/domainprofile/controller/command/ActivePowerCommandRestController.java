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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ActivePower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePower")
public class ActivePowerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ActivePower. if not key provided, calls create, otherwise calls save
   *
   * @param ActivePower activePower
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateActivePowerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ActivePowerBusinessDelegate.getActivePowerInstance().createActivePower(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ActivePower. if no key provided, calls create, otherwise calls save
   *
   * @param ActivePower activePower
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateActivePowerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateActivePowerCommand
      // -----------------------------------------------
      completableFuture =
          ActivePowerBusinessDelegate.getActivePowerInstance().updateActivePower(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ActivePowerController:update() - successfully update ActivePower - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ActivePower entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID activePowerId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteActivePowerCommand command = new DeleteActivePowerCommand(activePowerId);

    try {
      ActivePowerBusinessDelegate delegate = ActivePowerBusinessDelegate.getActivePowerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ActivePower with key " + command.getActivePowerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on ActivePower
   *
   * @param command AssignValueToActivePowerCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToActivePowerCommand command) {
    try {
      ActivePowerBusinessDelegate.getActivePowerInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on ActivePower
   *
   * @param command UnAssignValueFromActivePowerCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromActivePowerCommand command) {
    try {
      ActivePowerBusinessDelegate.getActivePowerInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ActivePower activePower = null;
  private static final Logger LOGGER =
      Logger.getLogger(ActivePowerCommandRestController.class.getName());
}
