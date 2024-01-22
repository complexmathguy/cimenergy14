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
 * Implements Spring Controller command CQRS processing for entity ActivePowerPerFrequency.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePowerPerFrequency")
public class ActivePowerPerFrequencyCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ActivePowerPerFrequency. if not key provided, calls create, otherwise calls
   * save
   *
   * @param ActivePowerPerFrequency activePowerPerFrequency
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateActivePowerPerFrequencyCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance()
              .createActivePowerPerFrequency(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ActivePowerPerFrequency. if no key provided, calls create, otherwise calls
   * save
   *
   * @param ActivePowerPerFrequency activePowerPerFrequency
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateActivePowerPerFrequencyCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateActivePowerPerFrequencyCommand
      // -----------------------------------------------
      completableFuture =
          ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance()
              .updateActivePowerPerFrequency(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ActivePowerPerFrequencyController:update() - successfully update ActivePowerPerFrequency - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ActivePowerPerFrequency entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID activePowerPerFrequencyId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteActivePowerPerFrequencyCommand command =
        new DeleteActivePowerPerFrequencyCommand(activePowerPerFrequencyId);

    try {
      ActivePowerPerFrequencyBusinessDelegate delegate =
          ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ActivePowerPerFrequency with key "
              + command.getActivePowerPerFrequencyId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on ActivePowerPerFrequency
   *
   * @param command AssignValueToActivePowerPerFrequencyCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToActivePowerPerFrequencyCommand command) {
    try {
      ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance()
          .assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on ActivePowerPerFrequency
   *
   * @param command UnAssignValueFromActivePowerPerFrequencyCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromActivePowerPerFrequencyCommand command) {
    try {
      ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance()
          .unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ActivePowerPerFrequency activePowerPerFrequency = null;
  private static final Logger LOGGER =
      Logger.getLogger(ActivePowerPerFrequencyCommandRestController.class.getName());
}
