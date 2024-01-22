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
 * Implements Spring Controller command CQRS processing for entity Temperature.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Temperature")
public class TemperatureCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Temperature. if not key provided, calls create, otherwise calls save
   *
   * @param Temperature temperature
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTemperatureCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TemperatureBusinessDelegate.getTemperatureInstance().createTemperature(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Temperature. if no key provided, calls create, otherwise calls save
   *
   * @param Temperature temperature
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTemperatureCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTemperatureCommand
      // -----------------------------------------------
      completableFuture =
          TemperatureBusinessDelegate.getTemperatureInstance().updateTemperature(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TemperatureController:update() - successfully update Temperature - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Temperature entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID temperatureId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTemperatureCommand command = new DeleteTemperatureCommand(temperatureId);

    try {
      TemperatureBusinessDelegate delegate = TemperatureBusinessDelegate.getTemperatureInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Temperature with key " + command.getTemperatureId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Temperature
   *
   * @param command AssignValueToTemperatureCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToTemperatureCommand command) {
    try {
      TemperatureBusinessDelegate.getTemperatureInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Temperature
   *
   * @param command UnAssignValueFromTemperatureCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromTemperatureCommand command) {
    try {
      TemperatureBusinessDelegate.getTemperatureInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Temperature temperature = null;
  private static final Logger LOGGER =
      Logger.getLogger(TemperatureCommandRestController.class.getName());
}
