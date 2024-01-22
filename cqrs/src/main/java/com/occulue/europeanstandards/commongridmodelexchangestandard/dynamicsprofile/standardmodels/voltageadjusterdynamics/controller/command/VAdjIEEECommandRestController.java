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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity VAdjIEEE.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VAdjIEEE")
public class VAdjIEEECommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VAdjIEEE. if not key provided, calls create, otherwise calls save
   *
   * @param VAdjIEEE vAdjIEEE
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVAdjIEEECommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().createVAdjIEEE(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VAdjIEEE. if no key provided, calls create, otherwise calls save
   *
   * @param VAdjIEEE vAdjIEEE
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVAdjIEEECommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVAdjIEEECommand
      // -----------------------------------------------
      completableFuture = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().updateVAdjIEEE(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VAdjIEEEController:update() - successfully update VAdjIEEE - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VAdjIEEE entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID vAdjIEEEId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVAdjIEEECommand command = new DeleteVAdjIEEECommand(vAdjIEEEId);

    try {
      VAdjIEEEBusinessDelegate delegate = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted VAdjIEEE with key " + command.getVAdjIEEEId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Adjslew on VAdjIEEE
   *
   * @param command AssignAdjslewToVAdjIEEECommand
   */
  @PutMapping("/assignAdjslew")
  public void assignAdjslew(@RequestBody AssignAdjslewToVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().assignAdjslew(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Adjslew", exc);
    }
  }

  /**
   * unassign Adjslew on VAdjIEEE
   *
   * @param command UnAssignAdjslewFromVAdjIEEECommand
   */
  @PutMapping("/unAssignAdjslew")
  public void unAssignAdjslew(
      @RequestBody(required = true) UnAssignAdjslewFromVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().unAssignAdjslew(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Adjslew", exc);
    }
  }

  /**
   * save Taoff on VAdjIEEE
   *
   * @param command AssignTaoffToVAdjIEEECommand
   */
  @PutMapping("/assignTaoff")
  public void assignTaoff(@RequestBody AssignTaoffToVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().assignTaoff(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Taoff", exc);
    }
  }

  /**
   * unassign Taoff on VAdjIEEE
   *
   * @param command UnAssignTaoffFromVAdjIEEECommand
   */
  @PutMapping("/unAssignTaoff")
  public void unAssignTaoff(
      @RequestBody(required = true) UnAssignTaoffFromVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().unAssignTaoff(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Taoff", exc);
    }
  }

  /**
   * save Taon on VAdjIEEE
   *
   * @param command AssignTaonToVAdjIEEECommand
   */
  @PutMapping("/assignTaon")
  public void assignTaon(@RequestBody AssignTaonToVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().assignTaon(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Taon", exc);
    }
  }

  /**
   * unassign Taon on VAdjIEEE
   *
   * @param command UnAssignTaonFromVAdjIEEECommand
   */
  @PutMapping("/unAssignTaon")
  public void unAssignTaon(@RequestBody(required = true) UnAssignTaonFromVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().unAssignTaon(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Taon", exc);
    }
  }

  /**
   * save Vadjf on VAdjIEEE
   *
   * @param command AssignVadjfToVAdjIEEECommand
   */
  @PutMapping("/assignVadjf")
  public void assignVadjf(@RequestBody AssignVadjfToVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().assignVadjf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vadjf", exc);
    }
  }

  /**
   * unassign Vadjf on VAdjIEEE
   *
   * @param command UnAssignVadjfFromVAdjIEEECommand
   */
  @PutMapping("/unAssignVadjf")
  public void unAssignVadjf(
      @RequestBody(required = true) UnAssignVadjfFromVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().unAssignVadjf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vadjf", exc);
    }
  }

  /**
   * save Vadjmax on VAdjIEEE
   *
   * @param command AssignVadjmaxToVAdjIEEECommand
   */
  @PutMapping("/assignVadjmax")
  public void assignVadjmax(@RequestBody AssignVadjmaxToVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().assignVadjmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vadjmax", exc);
    }
  }

  /**
   * unassign Vadjmax on VAdjIEEE
   *
   * @param command UnAssignVadjmaxFromVAdjIEEECommand
   */
  @PutMapping("/unAssignVadjmax")
  public void unAssignVadjmax(
      @RequestBody(required = true) UnAssignVadjmaxFromVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().unAssignVadjmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vadjmax", exc);
    }
  }

  /**
   * save Vadjmin on VAdjIEEE
   *
   * @param command AssignVadjminToVAdjIEEECommand
   */
  @PutMapping("/assignVadjmin")
  public void assignVadjmin(@RequestBody AssignVadjminToVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().assignVadjmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vadjmin", exc);
    }
  }

  /**
   * unassign Vadjmin on VAdjIEEE
   *
   * @param command UnAssignVadjminFromVAdjIEEECommand
   */
  @PutMapping("/unAssignVadjmin")
  public void unAssignVadjmin(
      @RequestBody(required = true) UnAssignVadjminFromVAdjIEEECommand command) {
    try {
      VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().unAssignVadjmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vadjmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VAdjIEEE vAdjIEEE = null;
  private static final Logger LOGGER =
      Logger.getLogger(VAdjIEEECommandRestController.class.getName());
}
