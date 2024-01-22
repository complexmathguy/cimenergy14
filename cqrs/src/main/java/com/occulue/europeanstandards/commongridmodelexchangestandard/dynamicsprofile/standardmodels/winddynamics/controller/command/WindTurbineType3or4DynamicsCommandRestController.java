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
 * Implements Spring Controller command CQRS processing for entity WindTurbineType3or4Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType3or4Dynamics")
public class WindTurbineType3or4DynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindTurbineType3or4Dynamics. if not key provided, calls create, otherwise
   * calls save
   *
   * @param WindTurbineType3or4Dynamics windTurbineType3or4Dynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindTurbineType3or4DynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance()
              .createWindTurbineType3or4Dynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindTurbineType3or4Dynamics. if no key provided, calls create, otherwise
   * calls save
   *
   * @param WindTurbineType3or4Dynamics windTurbineType3or4Dynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindTurbineType3or4DynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindTurbineType3or4DynamicsCommand
      // -----------------------------------------------
      completableFuture =
          WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance()
              .updateWindTurbineType3or4Dynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindTurbineType3or4DynamicsController:update() - successfully update WindTurbineType3or4Dynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindTurbineType3or4Dynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windTurbineType3or4DynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindTurbineType3or4DynamicsCommand command =
        new DeleteWindTurbineType3or4DynamicsCommand(windTurbineType3or4DynamicsId);

    try {
      WindTurbineType3or4DynamicsBusinessDelegate delegate =
          WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindTurbineType3or4Dynamics with key "
              + command.getWindTurbineType3or4DynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save WindTurbineType3or4Dynamics on WindTurbineType3or4Dynamics
   *
   * @param command AssignWindTurbineType3or4DynamicsToWindTurbineType3or4DynamicsCommand
   */
  @PutMapping("/assignWindTurbineType3or4Dynamics")
  public void assignWindTurbineType3or4Dynamics(
      @RequestBody AssignWindTurbineType3or4DynamicsToWindTurbineType3or4DynamicsCommand command) {
    try {
      WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance()
          .assignWindTurbineType3or4Dynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WindTurbineType3or4Dynamics", exc);
    }
  }

  /**
   * unassign WindTurbineType3or4Dynamics on WindTurbineType3or4Dynamics
   *
   * @param command UnAssignWindTurbineType3or4DynamicsFromWindTurbineType3or4DynamicsCommand
   */
  @PutMapping("/unAssignWindTurbineType3or4Dynamics")
  public void unAssignWindTurbineType3or4Dynamics(
      @RequestBody(required = true)
          UnAssignWindTurbineType3or4DynamicsFromWindTurbineType3or4DynamicsCommand command) {
    try {
      WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance()
          .unAssignWindTurbineType3or4Dynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WindTurbineType3or4Dynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindTurbineType3or4Dynamics windTurbineType3or4Dynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType3or4DynamicsCommandRestController.class.getName());
}
