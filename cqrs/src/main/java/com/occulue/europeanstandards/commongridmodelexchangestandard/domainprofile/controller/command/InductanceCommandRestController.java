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
 * Implements Spring Controller command CQRS processing for entity Inductance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Inductance")
public class InductanceCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Inductance. if not key provided, calls create, otherwise calls save
   *
   * @param Inductance inductance
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateInductanceCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          InductanceBusinessDelegate.getInductanceInstance().createInductance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Inductance. if no key provided, calls create, otherwise calls save
   *
   * @param Inductance inductance
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateInductanceCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateInductanceCommand
      // -----------------------------------------------
      completableFuture =
          InductanceBusinessDelegate.getInductanceInstance().updateInductance(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "InductanceController:update() - successfully update Inductance - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Inductance entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID inductanceId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteInductanceCommand command = new DeleteInductanceCommand(inductanceId);

    try {
      InductanceBusinessDelegate delegate = InductanceBusinessDelegate.getInductanceInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Inductance with key " + command.getInductanceId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Inductance
   *
   * @param command AssignValueToInductanceCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToInductanceCommand command) {
    try {
      InductanceBusinessDelegate.getInductanceInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Inductance
   *
   * @param command UnAssignValueFromInductanceCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromInductanceCommand command) {
    try {
      InductanceBusinessDelegate.getInductanceInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Inductance inductance = null;
  private static final Logger LOGGER =
      Logger.getLogger(InductanceCommandRestController.class.getName());
}
