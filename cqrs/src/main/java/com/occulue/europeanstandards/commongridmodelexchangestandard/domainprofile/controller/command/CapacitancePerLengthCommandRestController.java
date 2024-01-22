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
 * Implements Spring Controller command CQRS processing for entity CapacitancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CapacitancePerLength")
public class CapacitancePerLengthCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a CapacitancePerLength. if not key provided, calls create, otherwise calls save
   *
   * @param CapacitancePerLength capacitancePerLength
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateCapacitancePerLengthCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance()
              .createCapacitancePerLength(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a CapacitancePerLength. if no key provided, calls create, otherwise calls save
   *
   * @param CapacitancePerLength capacitancePerLength
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateCapacitancePerLengthCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateCapacitancePerLengthCommand
      // -----------------------------------------------
      completableFuture =
          CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance()
              .updateCapacitancePerLength(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "CapacitancePerLengthController:update() - successfully update CapacitancePerLength - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a CapacitancePerLength entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID capacitancePerLengthId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteCapacitancePerLengthCommand command =
        new DeleteCapacitancePerLengthCommand(capacitancePerLengthId);

    try {
      CapacitancePerLengthBusinessDelegate delegate =
          CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted CapacitancePerLength with key "
              + command.getCapacitancePerLengthId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on CapacitancePerLength
   *
   * @param command AssignValueToCapacitancePerLengthCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToCapacitancePerLengthCommand command) {
    try {
      CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on CapacitancePerLength
   *
   * @param command UnAssignValueFromCapacitancePerLengthCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromCapacitancePerLengthCommand command) {
    try {
      CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected CapacitancePerLength capacitancePerLength = null;
  private static final Logger LOGGER =
      Logger.getLogger(CapacitancePerLengthCommandRestController.class.getName());
}
