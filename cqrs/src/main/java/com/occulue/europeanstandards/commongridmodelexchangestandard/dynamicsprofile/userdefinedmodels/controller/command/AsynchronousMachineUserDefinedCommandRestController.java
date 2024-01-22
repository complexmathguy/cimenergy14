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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity AsynchronousMachineUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineUserDefined")
public class AsynchronousMachineUserDefinedCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a AsynchronousMachineUserDefined. if not key provided, calls create, otherwise
   * calls save
   *
   * @param AsynchronousMachineUserDefined asynchronousMachineUserDefined
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateAsynchronousMachineUserDefinedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance()
              .createAsynchronousMachineUserDefined(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a AsynchronousMachineUserDefined. if no key provided, calls create, otherwise
   * calls save
   *
   * @param AsynchronousMachineUserDefined asynchronousMachineUserDefined
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateAsynchronousMachineUserDefinedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAsynchronousMachineUserDefinedCommand
      // -----------------------------------------------
      completableFuture =
          AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance()
              .updateAsynchronousMachineUserDefined(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AsynchronousMachineUserDefinedController:update() - successfully update AsynchronousMachineUserDefined - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a AsynchronousMachineUserDefined entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID asynchronousMachineUserDefinedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAsynchronousMachineUserDefinedCommand command =
        new DeleteAsynchronousMachineUserDefinedCommand(asynchronousMachineUserDefinedId);

    try {
      AsynchronousMachineUserDefinedBusinessDelegate delegate =
          AsynchronousMachineUserDefinedBusinessDelegate
              .getAsynchronousMachineUserDefinedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted AsynchronousMachineUserDefined with key "
              + command.getAsynchronousMachineUserDefinedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Proprietary on AsynchronousMachineUserDefined
   *
   * @param command AssignProprietaryToAsynchronousMachineUserDefinedCommand
   */
  @PutMapping("/assignProprietary")
  public void assignProprietary(
      @RequestBody AssignProprietaryToAsynchronousMachineUserDefinedCommand command) {
    try {
      AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance()
          .assignProprietary(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Proprietary", exc);
    }
  }

  /**
   * unassign Proprietary on AsynchronousMachineUserDefined
   *
   * @param command UnAssignProprietaryFromAsynchronousMachineUserDefinedCommand
   */
  @PutMapping("/unAssignProprietary")
  public void unAssignProprietary(
      @RequestBody(required = true)
          UnAssignProprietaryFromAsynchronousMachineUserDefinedCommand command) {
    try {
      AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance()
          .unAssignProprietary(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Proprietary", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AsynchronousMachineUserDefined asynchronousMachineUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineUserDefinedCommandRestController.class.getName());
}
