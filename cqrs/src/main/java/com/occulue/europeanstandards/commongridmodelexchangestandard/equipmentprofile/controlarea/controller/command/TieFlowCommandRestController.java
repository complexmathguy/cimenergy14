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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TieFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TieFlow")
public class TieFlowCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TieFlow. if not key provided, calls create, otherwise calls save
   *
   * @param TieFlow tieFlow
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTieFlowCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = TieFlowBusinessDelegate.getTieFlowInstance().createTieFlow(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TieFlow. if no key provided, calls create, otherwise calls save
   *
   * @param TieFlow tieFlow
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTieFlowCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTieFlowCommand
      // -----------------------------------------------
      completableFuture = TieFlowBusinessDelegate.getTieFlowInstance().updateTieFlow(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TieFlowController:update() - successfully update TieFlow - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TieFlow entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID tieFlowId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTieFlowCommand command = new DeleteTieFlowCommand(tieFlowId);

    try {
      TieFlowBusinessDelegate delegate = TieFlowBusinessDelegate.getTieFlowInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted TieFlow with key " + command.getTieFlowId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save PositiveFlowIn on TieFlow
   *
   * @param command AssignPositiveFlowInToTieFlowCommand
   */
  @PutMapping("/assignPositiveFlowIn")
  public void assignPositiveFlowIn(@RequestBody AssignPositiveFlowInToTieFlowCommand command) {
    try {
      TieFlowBusinessDelegate.getTieFlowInstance().assignPositiveFlowIn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PositiveFlowIn", exc);
    }
  }

  /**
   * unassign PositiveFlowIn on TieFlow
   *
   * @param command UnAssignPositiveFlowInFromTieFlowCommand
   */
  @PutMapping("/unAssignPositiveFlowIn")
  public void unAssignPositiveFlowIn(
      @RequestBody(required = true) UnAssignPositiveFlowInFromTieFlowCommand command) {
    try {
      TieFlowBusinessDelegate.getTieFlowInstance().unAssignPositiveFlowIn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PositiveFlowIn", exc);
    }
  }

  /**
   * save TieFlow on TieFlow
   *
   * @param command AssignTieFlowToTieFlowCommand
   */
  @PutMapping("/addToTieFlow")
  public void addToTieFlow(@RequestBody(required = true) AssignTieFlowToTieFlowCommand command) {
    try {
      TieFlowBusinessDelegate.getTieFlowInstance().addToTieFlow(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set TieFlow", exc);
    }
  }

  /**
   * remove TieFlow on TieFlow
   *
   * @param command RemoveTieFlowFromTieFlowCommand
   */
  @PutMapping("/removeFromTieFlow")
  public void removeFromTieFlow(
      @RequestBody(required = true) RemoveTieFlowFromTieFlowCommand command) {
    try {
      TieFlowBusinessDelegate.getTieFlowInstance().removeFromTieFlow(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set TieFlow", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TieFlow tieFlow = null;
  private static final Logger LOGGER =
      Logger.getLogger(TieFlowCommandRestController.class.getName());
}
