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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PFVArControllerType1Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType1Dynamics")
public class PFVArControllerType1DynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PFVArControllerType1Dynamics. if not key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArControllerType1Dynamics pFVArControllerType1Dynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePFVArControllerType1DynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance()
              .createPFVArControllerType1Dynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PFVArControllerType1Dynamics. if no key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArControllerType1Dynamics pFVArControllerType1Dynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePFVArControllerType1DynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePFVArControllerType1DynamicsCommand
      // -----------------------------------------------
      completableFuture =
          PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance()
              .updatePFVArControllerType1Dynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PFVArControllerType1DynamicsController:update() - successfully update PFVArControllerType1Dynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PFVArControllerType1Dynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID pFVArControllerType1DynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePFVArControllerType1DynamicsCommand command =
        new DeletePFVArControllerType1DynamicsCommand(pFVArControllerType1DynamicsId);

    try {
      PFVArControllerType1DynamicsBusinessDelegate delegate =
          PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PFVArControllerType1Dynamics with key "
              + command.getPFVArControllerType1DynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save PFVArControllerType1Dynamics on PFVArControllerType1Dynamics
   *
   * @param command AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand
   */
  @PutMapping("/assignPFVArControllerType1Dynamics")
  public void assignPFVArControllerType1Dynamics(
      @RequestBody
          AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand command) {
    try {
      PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance()
          .assignPFVArControllerType1Dynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PFVArControllerType1Dynamics", exc);
    }
  }

  /**
   * unassign PFVArControllerType1Dynamics on PFVArControllerType1Dynamics
   *
   * @param command UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsCommand
   */
  @PutMapping("/unAssignPFVArControllerType1Dynamics")
  public void unAssignPFVArControllerType1Dynamics(
      @RequestBody(required = true)
          UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsCommand command) {
    try {
      PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance()
          .unAssignPFVArControllerType1Dynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PFVArControllerType1Dynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PFVArControllerType1Dynamics pFVArControllerType1Dynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType1DynamicsCommandRestController.class.getName());
}
