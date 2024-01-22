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
 * Implements Spring Controller command CQRS processing for entity WindPlantUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantUserDefined")
public class WindPlantUserDefinedCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindPlantUserDefined. if not key provided, calls create, otherwise calls save
   *
   * @param WindPlantUserDefined windPlantUserDefined
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindPlantUserDefinedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance()
              .createWindPlantUserDefined(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindPlantUserDefined. if no key provided, calls create, otherwise calls save
   *
   * @param WindPlantUserDefined windPlantUserDefined
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindPlantUserDefinedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindPlantUserDefinedCommand
      // -----------------------------------------------
      completableFuture =
          WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance()
              .updateWindPlantUserDefined(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindPlantUserDefinedController:update() - successfully update WindPlantUserDefined - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindPlantUserDefined entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windPlantUserDefinedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindPlantUserDefinedCommand command =
        new DeleteWindPlantUserDefinedCommand(windPlantUserDefinedId);

    try {
      WindPlantUserDefinedBusinessDelegate delegate =
          WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindPlantUserDefined with key "
              + command.getWindPlantUserDefinedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Proprietary on WindPlantUserDefined
   *
   * @param command AssignProprietaryToWindPlantUserDefinedCommand
   */
  @PutMapping("/assignProprietary")
  public void assignProprietary(
      @RequestBody AssignProprietaryToWindPlantUserDefinedCommand command) {
    try {
      WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance()
          .assignProprietary(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Proprietary", exc);
    }
  }

  /**
   * unassign Proprietary on WindPlantUserDefined
   *
   * @param command UnAssignProprietaryFromWindPlantUserDefinedCommand
   */
  @PutMapping("/unAssignProprietary")
  public void unAssignProprietary(
      @RequestBody(required = true) UnAssignProprietaryFromWindPlantUserDefinedCommand command) {
    try {
      WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance()
          .unAssignProprietary(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Proprietary", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindPlantUserDefined windPlantUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantUserDefinedCommandRestController.class.getName());
}
