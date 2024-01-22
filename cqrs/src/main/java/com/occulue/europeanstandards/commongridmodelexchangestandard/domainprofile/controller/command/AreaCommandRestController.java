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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Area.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Area")
public class AreaCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Area. if not key provided, calls create, otherwise calls save
   *
   * @param Area area
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateAreaCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = AreaBusinessDelegate.getAreaInstance().createArea(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Area. if no key provided, calls create, otherwise calls save
   *
   * @param Area area
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateAreaCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAreaCommand
      // -----------------------------------------------
      completableFuture = AreaBusinessDelegate.getAreaInstance().updateArea(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AreaController:update() - successfully update Area - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Area entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID areaId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAreaCommand command = new DeleteAreaCommand(areaId);

    try {
      AreaBusinessDelegate delegate = AreaBusinessDelegate.getAreaInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Area with key " + command.getAreaId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Area
   *
   * @param command AssignValueToAreaCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToAreaCommand command) {
    try {
      AreaBusinessDelegate.getAreaInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Area
   *
   * @param command UnAssignValueFromAreaCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(@RequestBody(required = true) UnAssignValueFromAreaCommand command) {
    try {
      AreaBusinessDelegate.getAreaInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Area area = null;
  private static final Logger LOGGER = Logger.getLogger(AreaCommandRestController.class.getName());
}
