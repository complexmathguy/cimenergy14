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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TurbineLoadControllerDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbineLoadControllerDynamics")
public class TurbineLoadControllerDynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TurbineLoadControllerDynamics. if not key provided, calls create, otherwise
   * calls save
   *
   * @param TurbineLoadControllerDynamics turbineLoadControllerDynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTurbineLoadControllerDynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance()
              .createTurbineLoadControllerDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TurbineLoadControllerDynamics. if no key provided, calls create, otherwise
   * calls save
   *
   * @param TurbineLoadControllerDynamics turbineLoadControllerDynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTurbineLoadControllerDynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTurbineLoadControllerDynamicsCommand
      // -----------------------------------------------
      completableFuture =
          TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance()
              .updateTurbineLoadControllerDynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TurbineLoadControllerDynamicsController:update() - successfully update TurbineLoadControllerDynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TurbineLoadControllerDynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID turbineLoadControllerDynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTurbineLoadControllerDynamicsCommand command =
        new DeleteTurbineLoadControllerDynamicsCommand(turbineLoadControllerDynamicsId);

    try {
      TurbineLoadControllerDynamicsBusinessDelegate delegate =
          TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TurbineLoadControllerDynamics with key "
              + command.getTurbineLoadControllerDynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save TurbineLoadControllerDynamics on TurbineLoadControllerDynamics
   *
   * @param command AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand
   */
  @PutMapping("/assignTurbineLoadControllerDynamics")
  public void assignTurbineLoadControllerDynamics(
      @RequestBody
          AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand command) {
    try {
      TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance()
          .assignTurbineLoadControllerDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign TurbineLoadControllerDynamics", exc);
    }
  }

  /**
   * unassign TurbineLoadControllerDynamics on TurbineLoadControllerDynamics
   *
   * @param command UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand
   */
  @PutMapping("/unAssignTurbineLoadControllerDynamics")
  public void unAssignTurbineLoadControllerDynamics(
      @RequestBody(required = true)
          UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand command) {
    try {
      TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance()
          .unAssignTurbineLoadControllerDynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign TurbineLoadControllerDynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TurbineLoadControllerDynamics turbineLoadControllerDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(TurbineLoadControllerDynamicsCommandRestController.class.getName());
}
