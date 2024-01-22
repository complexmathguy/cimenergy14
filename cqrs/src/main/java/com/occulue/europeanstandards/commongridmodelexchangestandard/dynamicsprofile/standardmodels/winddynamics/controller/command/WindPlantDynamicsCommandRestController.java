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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity WindPlantDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantDynamics")
public class WindPlantDynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindPlantDynamics. if not key provided, calls create, otherwise calls save
   *
   * @param WindPlantDynamics windPlantDynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindPlantDynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
              .createWindPlantDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindPlantDynamics. if no key provided, calls create, otherwise calls save
   *
   * @param WindPlantDynamics windPlantDynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindPlantDynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindPlantDynamicsCommand
      // -----------------------------------------------
      completableFuture =
          WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
              .updateWindPlantDynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindPlantDynamicsController:update() - successfully update WindPlantDynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindPlantDynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windPlantDynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindPlantDynamicsCommand command =
        new DeleteWindPlantDynamicsCommand(windPlantDynamicsId);

    try {
      WindPlantDynamicsBusinessDelegate delegate =
          WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindPlantDynamics with key " + command.getWindPlantDynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save WindPlantDynamics on WindPlantDynamics
   *
   * @param command AssignWindPlantDynamicsToWindPlantDynamicsCommand
   */
  @PutMapping("/assignWindPlantDynamics")
  public void assignWindPlantDynamics(
      @RequestBody AssignWindPlantDynamicsToWindPlantDynamicsCommand command) {
    try {
      WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
          .assignWindPlantDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WindPlantDynamics", exc);
    }
  }

  /**
   * unassign WindPlantDynamics on WindPlantDynamics
   *
   * @param command UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand
   */
  @PutMapping("/unAssignWindPlantDynamics")
  public void unAssignWindPlantDynamics(
      @RequestBody(required = true) UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand command) {
    try {
      WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
          .unAssignWindPlantDynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WindPlantDynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindPlantDynamics windPlantDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantDynamicsCommandRestController.class.getName());
}
