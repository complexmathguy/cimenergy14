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
 * Implements Spring Controller command CQRS processing for entity Capacitance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Capacitance")
public class CapacitanceCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Capacitance. if not key provided, calls create, otherwise calls save
   *
   * @param Capacitance capacitance
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateCapacitanceCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          CapacitanceBusinessDelegate.getCapacitanceInstance().createCapacitance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Capacitance. if no key provided, calls create, otherwise calls save
   *
   * @param Capacitance capacitance
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateCapacitanceCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateCapacitanceCommand
      // -----------------------------------------------
      completableFuture =
          CapacitanceBusinessDelegate.getCapacitanceInstance().updateCapacitance(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "CapacitanceController:update() - successfully update Capacitance - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Capacitance entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID capacitanceId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteCapacitanceCommand command = new DeleteCapacitanceCommand(capacitanceId);

    try {
      CapacitanceBusinessDelegate delegate = CapacitanceBusinessDelegate.getCapacitanceInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Capacitance with key " + command.getCapacitanceId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Capacitance
   *
   * @param command AssignValueToCapacitanceCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToCapacitanceCommand command) {
    try {
      CapacitanceBusinessDelegate.getCapacitanceInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Capacitance
   *
   * @param command UnAssignValueFromCapacitanceCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromCapacitanceCommand command) {
    try {
      CapacitanceBusinessDelegate.getCapacitanceInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Capacitance capacitance = null;
  private static final Logger LOGGER =
      Logger.getLogger(CapacitanceCommandRestController.class.getName());
}
