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
 * Implements Spring Controller command CQRS processing for entity Resistance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Resistance")
public class ResistanceCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Resistance. if not key provided, calls create, otherwise calls save
   *
   * @param Resistance resistance
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateResistanceCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ResistanceBusinessDelegate.getResistanceInstance().createResistance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Resistance. if no key provided, calls create, otherwise calls save
   *
   * @param Resistance resistance
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateResistanceCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateResistanceCommand
      // -----------------------------------------------
      completableFuture =
          ResistanceBusinessDelegate.getResistanceInstance().updateResistance(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ResistanceController:update() - successfully update Resistance - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Resistance entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID resistanceId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteResistanceCommand command = new DeleteResistanceCommand(resistanceId);

    try {
      ResistanceBusinessDelegate delegate = ResistanceBusinessDelegate.getResistanceInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Resistance with key " + command.getResistanceId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Resistance
   *
   * @param command AssignValueToResistanceCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToResistanceCommand command) {
    try {
      ResistanceBusinessDelegate.getResistanceInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Resistance
   *
   * @param command UnAssignValueFromResistanceCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromResistanceCommand command) {
    try {
      ResistanceBusinessDelegate.getResistanceInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Resistance resistance = null;
  private static final Logger LOGGER =
      Logger.getLogger(ResistanceCommandRestController.class.getName());
}
