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
 * Implements Spring Controller command CQRS processing for entity Command.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Command")
public class CommandCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Command. if not key provided, calls create, otherwise calls save
   *
   * @param Command command
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateCommandCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = CommandBusinessDelegate.getCommandInstance().createCommand(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Command. if no key provided, calls create, otherwise calls save
   *
   * @param Command command
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateCommandCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateCommandCommand
      // -----------------------------------------------
      completableFuture = CommandBusinessDelegate.getCommandInstance().updateCommand(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "CommandController:update() - successfully update Command - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Command entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID commandId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteCommandCommand command = new DeleteCommandCommand(commandId);

    try {
      CommandBusinessDelegate delegate = CommandBusinessDelegate.getCommandInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Command with key " + command.getCommandId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save NormalValue on Command
   *
   * @param command AssignNormalValueToCommandCommand
   */
  @PutMapping("/assignNormalValue")
  public void assignNormalValue(@RequestBody AssignNormalValueToCommandCommand command) {
    try {
      CommandBusinessDelegate.getCommandInstance().assignNormalValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NormalValue", exc);
    }
  }

  /**
   * unassign NormalValue on Command
   *
   * @param command UnAssignNormalValueFromCommandCommand
   */
  @PutMapping("/unAssignNormalValue")
  public void unAssignNormalValue(
      @RequestBody(required = true) UnAssignNormalValueFromCommandCommand command) {
    try {
      CommandBusinessDelegate.getCommandInstance().unAssignNormalValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NormalValue", exc);
    }
  }

  /**
   * save Value on Command
   *
   * @param command AssignValueToCommandCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToCommandCommand command) {
    try {
      CommandBusinessDelegate.getCommandInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Command
   *
   * @param command UnAssignValueFromCommandCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(@RequestBody(required = true) UnAssignValueFromCommandCommand command) {
    try {
      CommandBusinessDelegate.getCommandInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  /**
   * save Command on Command
   *
   * @param command AssignCommandToCommandCommand
   */
  @PutMapping("/assignCommand")
  public void assignCommand(@RequestBody AssignCommandToCommandCommand command) {
    try {
      CommandBusinessDelegate.getCommandInstance().assignCommand(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Command", exc);
    }
  }

  /**
   * unassign Command on Command
   *
   * @param command UnAssignCommandFromCommandCommand
   */
  @PutMapping("/unAssignCommand")
  public void unAssignCommand(
      @RequestBody(required = true) UnAssignCommandFromCommandCommand command) {
    try {
      CommandBusinessDelegate.getCommandInstance().unAssignCommand(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Command", exc);
    }
  }

  /**
   * save Commands on Command
   *
   * @param command AssignCommandsToCommandCommand
   */
  @PutMapping("/addToCommands")
  public void addToCommands(@RequestBody(required = true) AssignCommandsToCommandCommand command) {
    try {
      CommandBusinessDelegate.getCommandInstance().addToCommands(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Commands", exc);
    }
  }

  /**
   * remove Commands on Command
   *
   * @param command RemoveCommandsFromCommandCommand
   */
  @PutMapping("/removeFromCommands")
  public void removeFromCommands(
      @RequestBody(required = true) RemoveCommandsFromCommandCommand command) {
    try {
      CommandBusinessDelegate.getCommandInstance().removeFromCommands(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Commands", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Command command = null;
  private static final Logger LOGGER =
      Logger.getLogger(CommandCommandRestController.class.getName());
}
