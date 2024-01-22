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
 * Implements Spring Controller command CQRS processing for entity WindType3or4UserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindType3or4UserDefined")
public class WindType3or4UserDefinedCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindType3or4UserDefined. if not key provided, calls create, otherwise calls
   * save
   *
   * @param WindType3or4UserDefined windType3or4UserDefined
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindType3or4UserDefinedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance()
              .createWindType3or4UserDefined(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindType3or4UserDefined. if no key provided, calls create, otherwise calls
   * save
   *
   * @param WindType3or4UserDefined windType3or4UserDefined
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindType3or4UserDefinedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindType3or4UserDefinedCommand
      // -----------------------------------------------
      completableFuture =
          WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance()
              .updateWindType3or4UserDefined(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindType3or4UserDefinedController:update() - successfully update WindType3or4UserDefined - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindType3or4UserDefined entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windType3or4UserDefinedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindType3or4UserDefinedCommand command =
        new DeleteWindType3or4UserDefinedCommand(windType3or4UserDefinedId);

    try {
      WindType3or4UserDefinedBusinessDelegate delegate =
          WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindType3or4UserDefined with key "
              + command.getWindType3or4UserDefinedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Proprietary on WindType3or4UserDefined
   *
   * @param command AssignProprietaryToWindType3or4UserDefinedCommand
   */
  @PutMapping("/assignProprietary")
  public void assignProprietary(
      @RequestBody AssignProprietaryToWindType3or4UserDefinedCommand command) {
    try {
      WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance()
          .assignProprietary(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Proprietary", exc);
    }
  }

  /**
   * unassign Proprietary on WindType3or4UserDefined
   *
   * @param command UnAssignProprietaryFromWindType3or4UserDefinedCommand
   */
  @PutMapping("/unAssignProprietary")
  public void unAssignProprietary(
      @RequestBody(required = true) UnAssignProprietaryFromWindType3or4UserDefinedCommand command) {
    try {
      WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance()
          .unAssignProprietary(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Proprietary", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindType3or4UserDefined windType3or4UserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindType3or4UserDefinedCommandRestController.class.getName());
}
