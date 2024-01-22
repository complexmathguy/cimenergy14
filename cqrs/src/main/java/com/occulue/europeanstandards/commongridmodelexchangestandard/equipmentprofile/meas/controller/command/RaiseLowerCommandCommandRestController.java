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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity RaiseLowerCommand.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RaiseLowerCommand")
public class RaiseLowerCommandCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a RaiseLowerCommand. if not key provided, calls create, otherwise calls save
   *
   * @param RaiseLowerCommand raiseLowerCommand
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateRaiseLowerCommandCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance()
              .createRaiseLowerCommand(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a RaiseLowerCommand. if no key provided, calls create, otherwise calls save
   *
   * @param RaiseLowerCommand raiseLowerCommand
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateRaiseLowerCommandCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateRaiseLowerCommandCommand
      // -----------------------------------------------
      completableFuture =
          RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance()
              .updateRaiseLowerCommand(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "RaiseLowerCommandController:update() - successfully update RaiseLowerCommand - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a RaiseLowerCommand entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID raiseLowerCommandId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteRaiseLowerCommandCommand command =
        new DeleteRaiseLowerCommandCommand(raiseLowerCommandId);

    try {
      RaiseLowerCommandBusinessDelegate delegate =
          RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted RaiseLowerCommand with key " + command.getRaiseLowerCommandId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save RaiseLowerCommands on RaiseLowerCommand
   *
   * @param command AssignRaiseLowerCommandsToRaiseLowerCommandCommand
   */
  @PutMapping("/addToRaiseLowerCommands")
  public void addToRaiseLowerCommands(
      @RequestBody(required = true) AssignRaiseLowerCommandsToRaiseLowerCommandCommand command) {
    try {
      RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance()
          .addToRaiseLowerCommands(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set RaiseLowerCommands", exc);
    }
  }

  /**
   * remove RaiseLowerCommands on RaiseLowerCommand
   *
   * @param command RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand
   */
  @PutMapping("/removeFromRaiseLowerCommands")
  public void removeFromRaiseLowerCommands(
      @RequestBody(required = true) RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand command) {
    try {
      RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance()
          .removeFromRaiseLowerCommands(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set RaiseLowerCommands", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RaiseLowerCommand raiseLowerCommand = null;
  private static final Logger LOGGER =
      Logger.getLogger(RaiseLowerCommandCommandRestController.class.getName());
}
