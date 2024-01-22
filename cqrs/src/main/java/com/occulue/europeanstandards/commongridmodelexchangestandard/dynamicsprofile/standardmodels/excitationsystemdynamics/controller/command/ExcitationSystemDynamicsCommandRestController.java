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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ExcitationSystemDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcitationSystemDynamics")
public class ExcitationSystemDynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcitationSystemDynamics. if not key provided, calls create, otherwise calls
   * save
   *
   * @param ExcitationSystemDynamics excitationSystemDynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcitationSystemDynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance()
              .createExcitationSystemDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcitationSystemDynamics. if no key provided, calls create, otherwise calls
   * save
   *
   * @param ExcitationSystemDynamics excitationSystemDynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcitationSystemDynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcitationSystemDynamicsCommand
      // -----------------------------------------------
      completableFuture =
          ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance()
              .updateExcitationSystemDynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcitationSystemDynamicsController:update() - successfully update ExcitationSystemDynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcitationSystemDynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID excitationSystemDynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcitationSystemDynamicsCommand command =
        new DeleteExcitationSystemDynamicsCommand(excitationSystemDynamicsId);

    try {
      ExcitationSystemDynamicsBusinessDelegate delegate =
          ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ExcitationSystemDynamics with key "
              + command.getExcitationSystemDynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save ExcitationSystemDynamics on ExcitationSystemDynamics
   *
   * @param command AssignExcitationSystemDynamicsToExcitationSystemDynamicsCommand
   */
  @PutMapping("/assignExcitationSystemDynamics")
  public void assignExcitationSystemDynamics(
      @RequestBody AssignExcitationSystemDynamicsToExcitationSystemDynamicsCommand command) {
    try {
      ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance()
          .assignExcitationSystemDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ExcitationSystemDynamics", exc);
    }
  }

  /**
   * unassign ExcitationSystemDynamics on ExcitationSystemDynamics
   *
   * @param command UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsCommand
   */
  @PutMapping("/unAssignExcitationSystemDynamics")
  public void unAssignExcitationSystemDynamics(
      @RequestBody(required = true)
          UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsCommand command) {
    try {
      ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance()
          .unAssignExcitationSystemDynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ExcitationSystemDynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcitationSystemDynamics excitationSystemDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcitationSystemDynamicsCommandRestController.class.getName());
}
