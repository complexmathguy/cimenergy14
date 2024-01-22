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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity MechanicalLoadDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MechanicalLoadDynamics")
public class MechanicalLoadDynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a MechanicalLoadDynamics. if not key provided, calls create, otherwise calls
   * save
   *
   * @param MechanicalLoadDynamics mechanicalLoadDynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateMechanicalLoadDynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance()
              .createMechanicalLoadDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a MechanicalLoadDynamics. if no key provided, calls create, otherwise calls
   * save
   *
   * @param MechanicalLoadDynamics mechanicalLoadDynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateMechanicalLoadDynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateMechanicalLoadDynamicsCommand
      // -----------------------------------------------
      completableFuture =
          MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance()
              .updateMechanicalLoadDynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "MechanicalLoadDynamicsController:update() - successfully update MechanicalLoadDynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a MechanicalLoadDynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID mechanicalLoadDynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteMechanicalLoadDynamicsCommand command =
        new DeleteMechanicalLoadDynamicsCommand(mechanicalLoadDynamicsId);

    try {
      MechanicalLoadDynamicsBusinessDelegate delegate =
          MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted MechanicalLoadDynamics with key "
              + command.getMechanicalLoadDynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save MechanicalLoadDynamics on MechanicalLoadDynamics
   *
   * @param command AssignMechanicalLoadDynamicsToMechanicalLoadDynamicsCommand
   */
  @PutMapping("/assignMechanicalLoadDynamics")
  public void assignMechanicalLoadDynamics(
      @RequestBody AssignMechanicalLoadDynamicsToMechanicalLoadDynamicsCommand command) {
    try {
      MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance()
          .assignMechanicalLoadDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MechanicalLoadDynamics", exc);
    }
  }

  /**
   * unassign MechanicalLoadDynamics on MechanicalLoadDynamics
   *
   * @param command UnAssignMechanicalLoadDynamicsFromMechanicalLoadDynamicsCommand
   */
  @PutMapping("/unAssignMechanicalLoadDynamics")
  public void unAssignMechanicalLoadDynamics(
      @RequestBody(required = true)
          UnAssignMechanicalLoadDynamicsFromMechanicalLoadDynamicsCommand command) {
    try {
      MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance()
          .unAssignMechanicalLoadDynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MechanicalLoadDynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected MechanicalLoadDynamics mechanicalLoadDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(MechanicalLoadDynamicsCommandRestController.class.getName());
}
