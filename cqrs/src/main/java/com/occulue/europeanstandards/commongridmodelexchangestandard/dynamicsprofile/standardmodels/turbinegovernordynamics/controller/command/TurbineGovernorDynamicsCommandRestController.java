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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TurbineGovernorDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbineGovernorDynamics")
public class TurbineGovernorDynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TurbineGovernorDynamics. if not key provided, calls create, otherwise calls
   * save
   *
   * @param TurbineGovernorDynamics turbineGovernorDynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTurbineGovernorDynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance()
              .createTurbineGovernorDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TurbineGovernorDynamics. if no key provided, calls create, otherwise calls
   * save
   *
   * @param TurbineGovernorDynamics turbineGovernorDynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTurbineGovernorDynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTurbineGovernorDynamicsCommand
      // -----------------------------------------------
      completableFuture =
          TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance()
              .updateTurbineGovernorDynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TurbineGovernorDynamicsController:update() - successfully update TurbineGovernorDynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TurbineGovernorDynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID turbineGovernorDynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTurbineGovernorDynamicsCommand command =
        new DeleteTurbineGovernorDynamicsCommand(turbineGovernorDynamicsId);

    try {
      TurbineGovernorDynamicsBusinessDelegate delegate =
          TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TurbineGovernorDynamics with key "
              + command.getTurbineGovernorDynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save TurbineGovernorDynamics on TurbineGovernorDynamics
   *
   * @param command AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand
   */
  @PutMapping("/assignTurbineGovernorDynamics")
  public void assignTurbineGovernorDynamics(
      @RequestBody AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand command) {
    try {
      TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance()
          .assignTurbineGovernorDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign TurbineGovernorDynamics", exc);
    }
  }

  /**
   * unassign TurbineGovernorDynamics on TurbineGovernorDynamics
   *
   * @param command UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsCommand
   */
  @PutMapping("/unAssignTurbineGovernorDynamics")
  public void unAssignTurbineGovernorDynamics(
      @RequestBody(required = true)
          UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsCommand command) {
    try {
      TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance()
          .unAssignTurbineGovernorDynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign TurbineGovernorDynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TurbineGovernorDynamics turbineGovernorDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(TurbineGovernorDynamicsCommandRestController.class.getName());
}
