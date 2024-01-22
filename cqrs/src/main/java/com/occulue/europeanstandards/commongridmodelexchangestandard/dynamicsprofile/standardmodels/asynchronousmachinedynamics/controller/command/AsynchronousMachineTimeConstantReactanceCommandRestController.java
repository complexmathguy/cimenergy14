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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity
 * AsynchronousMachineTimeConstantReactance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineTimeConstantReactance")
public class AsynchronousMachineTimeConstantReactanceCommandRestController
    extends BaseSpringRestController {

  /**
   * Handles create a AsynchronousMachineTimeConstantReactance. if not key provided, calls create,
   * otherwise calls save
   *
   * @param AsynchronousMachineTimeConstantReactance asynchronousMachineTimeConstantReactance
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateAsynchronousMachineTimeConstantReactanceCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          AsynchronousMachineTimeConstantReactanceBusinessDelegate
              .getAsynchronousMachineTimeConstantReactanceInstance()
              .createAsynchronousMachineTimeConstantReactance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a AsynchronousMachineTimeConstantReactance. if no key provided, calls create,
   * otherwise calls save
   *
   * @param AsynchronousMachineTimeConstantReactance asynchronousMachineTimeConstantReactance
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateAsynchronousMachineTimeConstantReactanceCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAsynchronousMachineTimeConstantReactanceCommand
      // -----------------------------------------------
      completableFuture =
          AsynchronousMachineTimeConstantReactanceBusinessDelegate
              .getAsynchronousMachineTimeConstantReactanceInstance()
              .updateAsynchronousMachineTimeConstantReactance(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AsynchronousMachineTimeConstantReactanceController:update() - successfully update AsynchronousMachineTimeConstantReactance - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a AsynchronousMachineTimeConstantReactance entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID asynchronousMachineTimeConstantReactanceId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAsynchronousMachineTimeConstantReactanceCommand command =
        new DeleteAsynchronousMachineTimeConstantReactanceCommand(
            asynchronousMachineTimeConstantReactanceId);

    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate delegate =
          AsynchronousMachineTimeConstantReactanceBusinessDelegate
              .getAsynchronousMachineTimeConstantReactanceInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted AsynchronousMachineTimeConstantReactance with key "
              + command.getAsynchronousMachineTimeConstantReactanceId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Tpo on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpoToAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignTpo")
  public void assignTpo(
      @RequestBody AssignTpoToAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .assignTpo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpo", exc);
    }
  }

  /**
   * unassign Tpo on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignTpo")
  public void unAssignTpo(
      @RequestBody(required = true)
          UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .unAssignTpo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpo", exc);
    }
  }

  /**
   * save Tppo on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppoToAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignTppo")
  public void assignTppo(
      @RequestBody AssignTppoToAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .assignTppo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tppo", exc);
    }
  }

  /**
   * unassign Tppo on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignTppo")
  public void unAssignTppo(
      @RequestBody(required = true)
          UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .unAssignTppo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tppo", exc);
    }
  }

  /**
   * save Xp on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXpToAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXp")
  public void assignXp(
      @RequestBody AssignXpToAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .assignXp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xp", exc);
    }
  }

  /**
   * unassign Xp on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXp")
  public void unAssignXp(
      @RequestBody(required = true)
          UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .unAssignXp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xp", exc);
    }
  }

  /**
   * save Xpp on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXppToAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXpp")
  public void assignXpp(
      @RequestBody AssignXppToAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .assignXpp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xpp", exc);
    }
  }

  /**
   * unassign Xpp on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXpp")
  public void unAssignXpp(
      @RequestBody(required = true)
          UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .unAssignXpp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xpp", exc);
    }
  }

  /**
   * save Xs on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXsToAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXs")
  public void assignXs(
      @RequestBody AssignXsToAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .assignXs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xs", exc);
    }
  }

  /**
   * unassign Xs on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXs")
  public void unAssignXs(
      @RequestBody(required = true)
          UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand command) {
    try {
      AsynchronousMachineTimeConstantReactanceBusinessDelegate
          .getAsynchronousMachineTimeConstantReactanceInstance()
          .unAssignXs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xs", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AsynchronousMachineTimeConstantReactance asynchronousMachineTimeConstantReactance =
      null;
  private static final Logger LOGGER =
      Logger.getLogger(
          AsynchronousMachineTimeConstantReactanceCommandRestController.class.getName());
}
