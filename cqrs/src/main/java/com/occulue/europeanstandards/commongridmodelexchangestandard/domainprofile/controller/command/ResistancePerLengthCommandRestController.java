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
 * Implements Spring Controller command CQRS processing for entity ResistancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ResistancePerLength")
public class ResistancePerLengthCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ResistancePerLength. if not key provided, calls create, otherwise calls save
   *
   * @param ResistancePerLength resistancePerLength
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateResistancePerLengthCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance()
              .createResistancePerLength(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ResistancePerLength. if no key provided, calls create, otherwise calls save
   *
   * @param ResistancePerLength resistancePerLength
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateResistancePerLengthCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateResistancePerLengthCommand
      // -----------------------------------------------
      completableFuture =
          ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance()
              .updateResistancePerLength(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ResistancePerLengthController:update() - successfully update ResistancePerLength - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ResistancePerLength entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID resistancePerLengthId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteResistancePerLengthCommand command =
        new DeleteResistancePerLengthCommand(resistancePerLengthId);

    try {
      ResistancePerLengthBusinessDelegate delegate =
          ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ResistancePerLength with key "
              + command.getResistancePerLengthId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on ResistancePerLength
   *
   * @param command AssignValueToResistancePerLengthCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToResistancePerLengthCommand command) {
    try {
      ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on ResistancePerLength
   *
   * @param command UnAssignValueFromResistancePerLengthCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromResistancePerLengthCommand command) {
    try {
      ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ResistancePerLength resistancePerLength = null;
  private static final Logger LOGGER =
      Logger.getLogger(ResistancePerLengthCommandRestController.class.getName());
}
