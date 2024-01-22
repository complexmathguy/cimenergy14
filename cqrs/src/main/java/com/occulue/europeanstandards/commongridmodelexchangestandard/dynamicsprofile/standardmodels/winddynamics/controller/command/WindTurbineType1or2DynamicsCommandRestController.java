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
 * Implements Spring Controller command CQRS processing for entity WindTurbineType1or2Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType1or2Dynamics")
public class WindTurbineType1or2DynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindTurbineType1or2Dynamics. if not key provided, calls create, otherwise
   * calls save
   *
   * @param WindTurbineType1or2Dynamics windTurbineType1or2Dynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindTurbineType1or2DynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance()
              .createWindTurbineType1or2Dynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindTurbineType1or2Dynamics. if no key provided, calls create, otherwise
   * calls save
   *
   * @param WindTurbineType1or2Dynamics windTurbineType1or2Dynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindTurbineType1or2DynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindTurbineType1or2DynamicsCommand
      // -----------------------------------------------
      completableFuture =
          WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance()
              .updateWindTurbineType1or2Dynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindTurbineType1or2DynamicsController:update() - successfully update WindTurbineType1or2Dynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindTurbineType1or2Dynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windTurbineType1or2DynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindTurbineType1or2DynamicsCommand command =
        new DeleteWindTurbineType1or2DynamicsCommand(windTurbineType1or2DynamicsId);

    try {
      WindTurbineType1or2DynamicsBusinessDelegate delegate =
          WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindTurbineType1or2Dynamics with key "
              + command.getWindTurbineType1or2DynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save WindTurbineType1or2Dynamics on WindTurbineType1or2Dynamics
   *
   * @param command AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand
   */
  @PutMapping("/assignWindTurbineType1or2Dynamics")
  public void assignWindTurbineType1or2Dynamics(
      @RequestBody AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand command) {
    try {
      WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance()
          .assignWindTurbineType1or2Dynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WindTurbineType1or2Dynamics", exc);
    }
  }

  /**
   * unassign WindTurbineType1or2Dynamics on WindTurbineType1or2Dynamics
   *
   * @param command UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsCommand
   */
  @PutMapping("/unAssignWindTurbineType1or2Dynamics")
  public void unAssignWindTurbineType1or2Dynamics(
      @RequestBody(required = true)
          UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsCommand command) {
    try {
      WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance()
          .unAssignWindTurbineType1or2Dynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WindTurbineType1or2Dynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindTurbineType1or2Dynamics windTurbineType1or2Dynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType1or2DynamicsCommandRestController.class.getName());
}
