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
 * Implements Spring Controller command CQRS processing for entity VoltageAdjusterUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageAdjusterUserDefined")
public class VoltageAdjusterUserDefinedCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VoltageAdjusterUserDefined. if not key provided, calls create, otherwise calls
   * save
   *
   * @param VoltageAdjusterUserDefined voltageAdjusterUserDefined
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVoltageAdjusterUserDefinedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance()
              .createVoltageAdjusterUserDefined(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VoltageAdjusterUserDefined. if no key provided, calls create, otherwise
   * calls save
   *
   * @param VoltageAdjusterUserDefined voltageAdjusterUserDefined
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVoltageAdjusterUserDefinedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVoltageAdjusterUserDefinedCommand
      // -----------------------------------------------
      completableFuture =
          VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance()
              .updateVoltageAdjusterUserDefined(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VoltageAdjusterUserDefinedController:update() - successfully update VoltageAdjusterUserDefined - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VoltageAdjusterUserDefined entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID voltageAdjusterUserDefinedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVoltageAdjusterUserDefinedCommand command =
        new DeleteVoltageAdjusterUserDefinedCommand(voltageAdjusterUserDefinedId);

    try {
      VoltageAdjusterUserDefinedBusinessDelegate delegate =
          VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted VoltageAdjusterUserDefined with key "
              + command.getVoltageAdjusterUserDefinedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Proprietary on VoltageAdjusterUserDefined
   *
   * @param command AssignProprietaryToVoltageAdjusterUserDefinedCommand
   */
  @PutMapping("/assignProprietary")
  public void assignProprietary(
      @RequestBody AssignProprietaryToVoltageAdjusterUserDefinedCommand command) {
    try {
      VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance()
          .assignProprietary(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Proprietary", exc);
    }
  }

  /**
   * unassign Proprietary on VoltageAdjusterUserDefined
   *
   * @param command UnAssignProprietaryFromVoltageAdjusterUserDefinedCommand
   */
  @PutMapping("/unAssignProprietary")
  public void unAssignProprietary(
      @RequestBody(required = true)
          UnAssignProprietaryFromVoltageAdjusterUserDefinedCommand command) {
    try {
      VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance()
          .unAssignProprietary(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Proprietary", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VoltageAdjusterUserDefined voltageAdjusterUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(VoltageAdjusterUserDefinedCommandRestController.class.getName());
}
