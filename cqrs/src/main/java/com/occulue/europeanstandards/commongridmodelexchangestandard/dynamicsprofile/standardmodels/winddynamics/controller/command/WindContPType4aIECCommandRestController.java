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
 * Implements Spring Controller command CQRS processing for entity WindContPType4aIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType4aIEC")
public class WindContPType4aIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindContPType4aIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindContPType4aIEC windContPType4aIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindContPType4aIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance()
              .createWindContPType4aIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindContPType4aIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindContPType4aIEC windContPType4aIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindContPType4aIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindContPType4aIECCommand
      // -----------------------------------------------
      completableFuture =
          WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance()
              .updateWindContPType4aIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindContPType4aIECController:update() - successfully update WindContPType4aIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindContPType4aIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windContPType4aIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindContPType4aIECCommand command =
        new DeleteWindContPType4aIECCommand(windContPType4aIECId);

    try {
      WindContPType4aIECBusinessDelegate delegate =
          WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindContPType4aIEC with key " + command.getWindContPType4aIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dpmax on WindContPType4aIEC
   *
   * @param command AssignDpmaxToWindContPType4aIECCommand
   */
  @PutMapping("/assignDpmax")
  public void assignDpmax(@RequestBody AssignDpmaxToWindContPType4aIECCommand command) {
    try {
      WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().assignDpmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dpmax", exc);
    }
  }

  /**
   * unassign Dpmax on WindContPType4aIEC
   *
   * @param command UnAssignDpmaxFromWindContPType4aIECCommand
   */
  @PutMapping("/unAssignDpmax")
  public void unAssignDpmax(
      @RequestBody(required = true) UnAssignDpmaxFromWindContPType4aIECCommand command) {
    try {
      WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().unAssignDpmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dpmax", exc);
    }
  }

  /**
   * save Tpord on WindContPType4aIEC
   *
   * @param command AssignTpordToWindContPType4aIECCommand
   */
  @PutMapping("/assignTpord")
  public void assignTpord(@RequestBody AssignTpordToWindContPType4aIECCommand command) {
    try {
      WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().assignTpord(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpord", exc);
    }
  }

  /**
   * unassign Tpord on WindContPType4aIEC
   *
   * @param command UnAssignTpordFromWindContPType4aIECCommand
   */
  @PutMapping("/unAssignTpord")
  public void unAssignTpord(
      @RequestBody(required = true) UnAssignTpordFromWindContPType4aIECCommand command) {
    try {
      WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().unAssignTpord(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpord", exc);
    }
  }

  /**
   * save Tufilt on WindContPType4aIEC
   *
   * @param command AssignTufiltToWindContPType4aIECCommand
   */
  @PutMapping("/assignTufilt")
  public void assignTufilt(@RequestBody AssignTufiltToWindContPType4aIECCommand command) {
    try {
      WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().assignTufilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tufilt", exc);
    }
  }

  /**
   * unassign Tufilt on WindContPType4aIEC
   *
   * @param command UnAssignTufiltFromWindContPType4aIECCommand
   */
  @PutMapping("/unAssignTufilt")
  public void unAssignTufilt(
      @RequestBody(required = true) UnAssignTufiltFromWindContPType4aIECCommand command) {
    try {
      WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().unAssignTufilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tufilt", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindContPType4aIEC windContPType4aIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContPType4aIECCommandRestController.class.getName());
}
