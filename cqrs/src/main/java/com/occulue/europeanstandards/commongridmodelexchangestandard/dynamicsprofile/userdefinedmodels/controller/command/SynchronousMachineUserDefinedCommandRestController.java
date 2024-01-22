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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachineUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineUserDefined")
public class SynchronousMachineUserDefinedCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SynchronousMachineUserDefined. if not key provided, calls create, otherwise
   * calls save
   *
   * @param SynchronousMachineUserDefined synchronousMachineUserDefined
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSynchronousMachineUserDefinedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance()
              .createSynchronousMachineUserDefined(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SynchronousMachineUserDefined. if no key provided, calls create, otherwise
   * calls save
   *
   * @param SynchronousMachineUserDefined synchronousMachineUserDefined
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSynchronousMachineUserDefinedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSynchronousMachineUserDefinedCommand
      // -----------------------------------------------
      completableFuture =
          SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance()
              .updateSynchronousMachineUserDefined(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SynchronousMachineUserDefinedController:update() - successfully update SynchronousMachineUserDefined - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SynchronousMachineUserDefined entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID synchronousMachineUserDefinedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSynchronousMachineUserDefinedCommand command =
        new DeleteSynchronousMachineUserDefinedCommand(synchronousMachineUserDefinedId);

    try {
      SynchronousMachineUserDefinedBusinessDelegate delegate =
          SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SynchronousMachineUserDefined with key "
              + command.getSynchronousMachineUserDefinedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Proprietary on SynchronousMachineUserDefined
   *
   * @param command AssignProprietaryToSynchronousMachineUserDefinedCommand
   */
  @PutMapping("/assignProprietary")
  public void assignProprietary(
      @RequestBody AssignProprietaryToSynchronousMachineUserDefinedCommand command) {
    try {
      SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance()
          .assignProprietary(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Proprietary", exc);
    }
  }

  /**
   * unassign Proprietary on SynchronousMachineUserDefined
   *
   * @param command UnAssignProprietaryFromSynchronousMachineUserDefinedCommand
   */
  @PutMapping("/unAssignProprietary")
  public void unAssignProprietary(
      @RequestBody(required = true)
          UnAssignProprietaryFromSynchronousMachineUserDefinedCommand command) {
    try {
      SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance()
          .unAssignProprietary(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Proprietary", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SynchronousMachineUserDefined synchronousMachineUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineUserDefinedCommandRestController.class.getName());
}
