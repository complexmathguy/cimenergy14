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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity DynamicsFunctionBlock.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DynamicsFunctionBlock")
public class DynamicsFunctionBlockCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DynamicsFunctionBlock. if not key provided, calls create, otherwise calls save
   *
   * @param DynamicsFunctionBlock dynamicsFunctionBlock
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDynamicsFunctionBlockCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance()
              .createDynamicsFunctionBlock(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DynamicsFunctionBlock. if no key provided, calls create, otherwise calls
   * save
   *
   * @param DynamicsFunctionBlock dynamicsFunctionBlock
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDynamicsFunctionBlockCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDynamicsFunctionBlockCommand
      // -----------------------------------------------
      completableFuture =
          DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance()
              .updateDynamicsFunctionBlock(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DynamicsFunctionBlockController:update() - successfully update DynamicsFunctionBlock - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DynamicsFunctionBlock entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID dynamicsFunctionBlockId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDynamicsFunctionBlockCommand command =
        new DeleteDynamicsFunctionBlockCommand(dynamicsFunctionBlockId);

    try {
      DynamicsFunctionBlockBusinessDelegate delegate =
          DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DynamicsFunctionBlock with key "
              + command.getDynamicsFunctionBlockId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Enabled on DynamicsFunctionBlock
   *
   * @param command AssignEnabledToDynamicsFunctionBlockCommand
   */
  @PutMapping("/assignEnabled")
  public void assignEnabled(@RequestBody AssignEnabledToDynamicsFunctionBlockCommand command) {
    try {
      DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance()
          .assignEnabled(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Enabled", exc);
    }
  }

  /**
   * unassign Enabled on DynamicsFunctionBlock
   *
   * @param command UnAssignEnabledFromDynamicsFunctionBlockCommand
   */
  @PutMapping("/unAssignEnabled")
  public void unAssignEnabled(
      @RequestBody(required = true) UnAssignEnabledFromDynamicsFunctionBlockCommand command) {
    try {
      DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance()
          .unAssignEnabled(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Enabled", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DynamicsFunctionBlock dynamicsFunctionBlock = null;
  private static final Logger LOGGER =
      Logger.getLogger(DynamicsFunctionBlockCommandRestController.class.getName());
}
