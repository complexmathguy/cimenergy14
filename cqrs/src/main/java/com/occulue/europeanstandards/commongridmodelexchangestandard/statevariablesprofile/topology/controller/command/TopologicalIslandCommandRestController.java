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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TopologicalIsland.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologicalIsland")
public class TopologicalIslandCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TopologicalIsland. if not key provided, calls create, otherwise calls save
   *
   * @param TopologicalIsland topologicalIsland
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTopologicalIslandCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
              .createTopologicalIsland(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TopologicalIsland. if no key provided, calls create, otherwise calls save
   *
   * @param TopologicalIsland topologicalIsland
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTopologicalIslandCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTopologicalIslandCommand
      // -----------------------------------------------
      completableFuture =
          TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
              .updateTopologicalIsland(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TopologicalIslandController:update() - successfully update TopologicalIsland - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TopologicalIsland entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID topologicalIslandId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTopologicalIslandCommand command =
        new DeleteTopologicalIslandCommand(topologicalIslandId);

    try {
      TopologicalIslandBusinessDelegate delegate =
          TopologicalIslandBusinessDelegate.getTopologicalIslandInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TopologicalIsland with key " + command.getTopologicalIslandId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save TopologicalIsland on TopologicalIsland
   *
   * @param command AssignTopologicalIslandToTopologicalIslandCommand
   */
  @PutMapping("/assignTopologicalIsland")
  public void assignTopologicalIsland(
      @RequestBody AssignTopologicalIslandToTopologicalIslandCommand command) {
    try {
      TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
          .assignTopologicalIsland(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign TopologicalIsland", exc);
    }
  }

  /**
   * unassign TopologicalIsland on TopologicalIsland
   *
   * @param command UnAssignTopologicalIslandFromTopologicalIslandCommand
   */
  @PutMapping("/unAssignTopologicalIsland")
  public void unAssignTopologicalIsland(
      @RequestBody(required = true) UnAssignTopologicalIslandFromTopologicalIslandCommand command) {
    try {
      TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
          .unAssignTopologicalIsland(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign TopologicalIsland", exc);
    }
  }

  /**
   * save AngleRefTopologicalIsland on TopologicalIsland
   *
   * @param command AssignAngleRefTopologicalIslandToTopologicalIslandCommand
   */
  @PutMapping("/assignAngleRefTopologicalIsland")
  public void assignAngleRefTopologicalIsland(
      @RequestBody AssignAngleRefTopologicalIslandToTopologicalIslandCommand command) {
    try {
      TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
          .assignAngleRefTopologicalIsland(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign AngleRefTopologicalIsland", exc);
    }
  }

  /**
   * unassign AngleRefTopologicalIsland on TopologicalIsland
   *
   * @param command UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand
   */
  @PutMapping("/unAssignAngleRefTopologicalIsland")
  public void unAssignAngleRefTopologicalIsland(
      @RequestBody(required = true)
          UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand command) {
    try {
      TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
          .unAssignAngleRefTopologicalIsland(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign AngleRefTopologicalIsland", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TopologicalIsland topologicalIsland = null;
  private static final Logger LOGGER =
      Logger.getLogger(TopologicalIslandCommandRestController.class.getName());
}
