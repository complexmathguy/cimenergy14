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
 * Implements Spring Controller command CQRS processing for entity RegularIntervalSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegularIntervalSchedule")
public class RegularIntervalScheduleCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a RegularIntervalSchedule. if not key provided, calls create, otherwise calls
   * save
   *
   * @param RegularIntervalSchedule regularIntervalSchedule
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateRegularIntervalScheduleCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
              .createRegularIntervalSchedule(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a RegularIntervalSchedule. if no key provided, calls create, otherwise calls
   * save
   *
   * @param RegularIntervalSchedule regularIntervalSchedule
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateRegularIntervalScheduleCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateRegularIntervalScheduleCommand
      // -----------------------------------------------
      completableFuture =
          RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
              .updateRegularIntervalSchedule(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "RegularIntervalScheduleController:update() - successfully update RegularIntervalSchedule - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a RegularIntervalSchedule entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID regularIntervalScheduleId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteRegularIntervalScheduleCommand command =
        new DeleteRegularIntervalScheduleCommand(regularIntervalScheduleId);

    try {
      RegularIntervalScheduleBusinessDelegate delegate =
          RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted RegularIntervalSchedule with key "
              + command.getRegularIntervalScheduleId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save EndTime on RegularIntervalSchedule
   *
   * @param command AssignEndTimeToRegularIntervalScheduleCommand
   */
  @PutMapping("/assignEndTime")
  public void assignEndTime(@RequestBody AssignEndTimeToRegularIntervalScheduleCommand command) {
    try {
      RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
          .assignEndTime(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EndTime", exc);
    }
  }

  /**
   * unassign EndTime on RegularIntervalSchedule
   *
   * @param command UnAssignEndTimeFromRegularIntervalScheduleCommand
   */
  @PutMapping("/unAssignEndTime")
  public void unAssignEndTime(
      @RequestBody(required = true) UnAssignEndTimeFromRegularIntervalScheduleCommand command) {
    try {
      RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
          .unAssignEndTime(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EndTime", exc);
    }
  }

  /**
   * save TimeStep on RegularIntervalSchedule
   *
   * @param command AssignTimeStepToRegularIntervalScheduleCommand
   */
  @PutMapping("/assignTimeStep")
  public void assignTimeStep(@RequestBody AssignTimeStepToRegularIntervalScheduleCommand command) {
    try {
      RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
          .assignTimeStep(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign TimeStep", exc);
    }
  }

  /**
   * unassign TimeStep on RegularIntervalSchedule
   *
   * @param command UnAssignTimeStepFromRegularIntervalScheduleCommand
   */
  @PutMapping("/unAssignTimeStep")
  public void unAssignTimeStep(
      @RequestBody(required = true) UnAssignTimeStepFromRegularIntervalScheduleCommand command) {
    try {
      RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
          .unAssignTimeStep(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign TimeStep", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RegularIntervalSchedule regularIntervalSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(RegularIntervalScheduleCommandRestController.class.getName());
}
