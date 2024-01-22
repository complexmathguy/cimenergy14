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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PFVArControllerType2Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType2Dynamics")
public class PFVArControllerType2DynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PFVArControllerType2Dynamics. if not key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArControllerType2Dynamics pFVArControllerType2Dynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePFVArControllerType2DynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance()
              .createPFVArControllerType2Dynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PFVArControllerType2Dynamics. if no key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArControllerType2Dynamics pFVArControllerType2Dynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePFVArControllerType2DynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePFVArControllerType2DynamicsCommand
      // -----------------------------------------------
      completableFuture =
          PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance()
              .updatePFVArControllerType2Dynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PFVArControllerType2DynamicsController:update() - successfully update PFVArControllerType2Dynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PFVArControllerType2Dynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID pFVArControllerType2DynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePFVArControllerType2DynamicsCommand command =
        new DeletePFVArControllerType2DynamicsCommand(pFVArControllerType2DynamicsId);

    try {
      PFVArControllerType2DynamicsBusinessDelegate delegate =
          PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PFVArControllerType2Dynamics with key "
              + command.getPFVArControllerType2DynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save PFVArControllerType2Dynamics on PFVArControllerType2Dynamics
   *
   * @param command AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand
   */
  @PutMapping("/assignPFVArControllerType2Dynamics")
  public void assignPFVArControllerType2Dynamics(
      @RequestBody
          AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand command) {
    try {
      PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance()
          .assignPFVArControllerType2Dynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PFVArControllerType2Dynamics", exc);
    }
  }

  /**
   * unassign PFVArControllerType2Dynamics on PFVArControllerType2Dynamics
   *
   * @param command UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsCommand
   */
  @PutMapping("/unAssignPFVArControllerType2Dynamics")
  public void unAssignPFVArControllerType2Dynamics(
      @RequestBody(required = true)
          UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsCommand command) {
    try {
      PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance()
          .unAssignPFVArControllerType2Dynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PFVArControllerType2Dynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PFVArControllerType2Dynamics pFVArControllerType2Dynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType2DynamicsCommandRestController.class.getName());
}
