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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ControlAreaGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ControlAreaGeneratingUnit")
public class ControlAreaGeneratingUnitCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ControlAreaGeneratingUnit. if not key provided, calls create, otherwise calls
   * save
   *
   * @param ControlAreaGeneratingUnit controlAreaGeneratingUnit
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateControlAreaGeneratingUnitCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance()
              .createControlAreaGeneratingUnit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ControlAreaGeneratingUnit. if no key provided, calls create, otherwise calls
   * save
   *
   * @param ControlAreaGeneratingUnit controlAreaGeneratingUnit
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateControlAreaGeneratingUnitCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateControlAreaGeneratingUnitCommand
      // -----------------------------------------------
      completableFuture =
          ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance()
              .updateControlAreaGeneratingUnit(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ControlAreaGeneratingUnitController:update() - successfully update ControlAreaGeneratingUnit - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ControlAreaGeneratingUnit entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID controlAreaGeneratingUnitId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteControlAreaGeneratingUnitCommand command =
        new DeleteControlAreaGeneratingUnitCommand(controlAreaGeneratingUnitId);

    try {
      ControlAreaGeneratingUnitBusinessDelegate delegate =
          ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ControlAreaGeneratingUnit with key "
              + command.getControlAreaGeneratingUnitId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save ControlAreaGeneratingUnit on ControlAreaGeneratingUnit
   *
   * @param command AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand
   */
  @PutMapping("/addToControlAreaGeneratingUnit")
  public void addToControlAreaGeneratingUnit(
      @RequestBody(required = true)
          AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand command) {
    try {
      ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance()
          .addToControlAreaGeneratingUnit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set ControlAreaGeneratingUnit", exc);
    }
  }

  /**
   * remove ControlAreaGeneratingUnit on ControlAreaGeneratingUnit
   *
   * @param command RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand
   */
  @PutMapping("/removeFromControlAreaGeneratingUnit")
  public void removeFromControlAreaGeneratingUnit(
      @RequestBody(required = true)
          RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand command) {
    try {
      ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance()
          .removeFromControlAreaGeneratingUnit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set ControlAreaGeneratingUnit", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ControlAreaGeneratingUnit controlAreaGeneratingUnit = null;
  private static final Logger LOGGER =
      Logger.getLogger(ControlAreaGeneratingUnitCommandRestController.class.getName());
}
