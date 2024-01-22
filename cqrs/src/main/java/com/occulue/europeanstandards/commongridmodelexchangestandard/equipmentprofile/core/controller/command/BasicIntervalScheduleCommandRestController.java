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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity BasicIntervalSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BasicIntervalSchedule")
public class BasicIntervalScheduleCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a BasicIntervalSchedule. if not key provided, calls create, otherwise calls save
   *
   * @param BasicIntervalSchedule basicIntervalSchedule
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateBasicIntervalScheduleCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance()
              .createBasicIntervalSchedule(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a BasicIntervalSchedule. if no key provided, calls create, otherwise calls
   * save
   *
   * @param BasicIntervalSchedule basicIntervalSchedule
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateBasicIntervalScheduleCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateBasicIntervalScheduleCommand
      // -----------------------------------------------
      completableFuture =
          BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance()
              .updateBasicIntervalSchedule(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "BasicIntervalScheduleController:update() - successfully update BasicIntervalSchedule - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a BasicIntervalSchedule entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID basicIntervalScheduleId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteBasicIntervalScheduleCommand command =
        new DeleteBasicIntervalScheduleCommand(basicIntervalScheduleId);

    try {
      BasicIntervalScheduleBusinessDelegate delegate =
          BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted BasicIntervalSchedule with key "
              + command.getBasicIntervalScheduleId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save StartTime on BasicIntervalSchedule
   *
   * @param command AssignStartTimeToBasicIntervalScheduleCommand
   */
  @PutMapping("/assignStartTime")
  public void assignStartTime(@RequestBody AssignStartTimeToBasicIntervalScheduleCommand command) {
    try {
      BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance()
          .assignStartTime(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign StartTime", exc);
    }
  }

  /**
   * unassign StartTime on BasicIntervalSchedule
   *
   * @param command UnAssignStartTimeFromBasicIntervalScheduleCommand
   */
  @PutMapping("/unAssignStartTime")
  public void unAssignStartTime(
      @RequestBody(required = true) UnAssignStartTimeFromBasicIntervalScheduleCommand command) {
    try {
      BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance()
          .unAssignStartTime(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign StartTime", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected BasicIntervalSchedule basicIntervalSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(BasicIntervalScheduleCommandRestController.class.getName());
}
