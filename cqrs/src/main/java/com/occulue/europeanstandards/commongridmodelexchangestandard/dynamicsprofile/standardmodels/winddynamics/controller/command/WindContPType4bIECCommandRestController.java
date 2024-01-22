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
 * Implements Spring Controller command CQRS processing for entity WindContPType4bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType4bIEC")
public class WindContPType4bIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindContPType4bIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindContPType4bIEC windContPType4bIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindContPType4bIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance()
              .createWindContPType4bIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindContPType4bIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindContPType4bIEC windContPType4bIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindContPType4bIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindContPType4bIECCommand
      // -----------------------------------------------
      completableFuture =
          WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance()
              .updateWindContPType4bIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindContPType4bIECController:update() - successfully update WindContPType4bIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindContPType4bIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windContPType4bIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindContPType4bIECCommand command =
        new DeleteWindContPType4bIECCommand(windContPType4bIECId);

    try {
      WindContPType4bIECBusinessDelegate delegate =
          WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindContPType4bIEC with key " + command.getWindContPType4bIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dpmax on WindContPType4bIEC
   *
   * @param command AssignDpmaxToWindContPType4bIECCommand
   */
  @PutMapping("/assignDpmax")
  public void assignDpmax(@RequestBody AssignDpmaxToWindContPType4bIECCommand command) {
    try {
      WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().assignDpmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dpmax", exc);
    }
  }

  /**
   * unassign Dpmax on WindContPType4bIEC
   *
   * @param command UnAssignDpmaxFromWindContPType4bIECCommand
   */
  @PutMapping("/unAssignDpmax")
  public void unAssignDpmax(
      @RequestBody(required = true) UnAssignDpmaxFromWindContPType4bIECCommand command) {
    try {
      WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().unAssignDpmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dpmax", exc);
    }
  }

  /**
   * save Tpaero on WindContPType4bIEC
   *
   * @param command AssignTpaeroToWindContPType4bIECCommand
   */
  @PutMapping("/assignTpaero")
  public void assignTpaero(@RequestBody AssignTpaeroToWindContPType4bIECCommand command) {
    try {
      WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().assignTpaero(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpaero", exc);
    }
  }

  /**
   * unassign Tpaero on WindContPType4bIEC
   *
   * @param command UnAssignTpaeroFromWindContPType4bIECCommand
   */
  @PutMapping("/unAssignTpaero")
  public void unAssignTpaero(
      @RequestBody(required = true) UnAssignTpaeroFromWindContPType4bIECCommand command) {
    try {
      WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().unAssignTpaero(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpaero", exc);
    }
  }

  /**
   * save Tpord on WindContPType4bIEC
   *
   * @param command AssignTpordToWindContPType4bIECCommand
   */
  @PutMapping("/assignTpord")
  public void assignTpord(@RequestBody AssignTpordToWindContPType4bIECCommand command) {
    try {
      WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().assignTpord(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpord", exc);
    }
  }

  /**
   * unassign Tpord on WindContPType4bIEC
   *
   * @param command UnAssignTpordFromWindContPType4bIECCommand
   */
  @PutMapping("/unAssignTpord")
  public void unAssignTpord(
      @RequestBody(required = true) UnAssignTpordFromWindContPType4bIECCommand command) {
    try {
      WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().unAssignTpord(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpord", exc);
    }
  }

  /**
   * save Tufilt on WindContPType4bIEC
   *
   * @param command AssignTufiltToWindContPType4bIECCommand
   */
  @PutMapping("/assignTufilt")
  public void assignTufilt(@RequestBody AssignTufiltToWindContPType4bIECCommand command) {
    try {
      WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().assignTufilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tufilt", exc);
    }
  }

  /**
   * unassign Tufilt on WindContPType4bIEC
   *
   * @param command UnAssignTufiltFromWindContPType4bIECCommand
   */
  @PutMapping("/unAssignTufilt")
  public void unAssignTufilt(
      @RequestBody(required = true) UnAssignTufiltFromWindContPType4bIECCommand command) {
    try {
      WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().unAssignTufilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tufilt", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindContPType4bIEC windContPType4bIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContPType4bIECCommandRestController.class.getName());
}
