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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ConformLoadSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConformLoadSchedule")
public class ConformLoadScheduleCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ConformLoadSchedule. if not key provided, calls create, otherwise calls save
   *
   * @param ConformLoadSchedule conformLoadSchedule
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateConformLoadScheduleCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance()
              .createConformLoadSchedule(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ConformLoadSchedule. if no key provided, calls create, otherwise calls save
   *
   * @param ConformLoadSchedule conformLoadSchedule
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateConformLoadScheduleCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateConformLoadScheduleCommand
      // -----------------------------------------------
      completableFuture =
          ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance()
              .updateConformLoadSchedule(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ConformLoadScheduleController:update() - successfully update ConformLoadSchedule - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ConformLoadSchedule entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID conformLoadScheduleId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteConformLoadScheduleCommand command =
        new DeleteConformLoadScheduleCommand(conformLoadScheduleId);

    try {
      ConformLoadScheduleBusinessDelegate delegate =
          ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ConformLoadSchedule with key "
              + command.getConformLoadScheduleId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save ConformLoadSchedules on ConformLoadSchedule
   *
   * @param command AssignConformLoadSchedulesToConformLoadScheduleCommand
   */
  @PutMapping("/addToConformLoadSchedules")
  public void addToConformLoadSchedules(
      @RequestBody(required = true)
          AssignConformLoadSchedulesToConformLoadScheduleCommand command) {
    try {
      ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance()
          .addToConformLoadSchedules(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set ConformLoadSchedules", exc);
    }
  }

  /**
   * remove ConformLoadSchedules on ConformLoadSchedule
   *
   * @param command RemoveConformLoadSchedulesFromConformLoadScheduleCommand
   */
  @PutMapping("/removeFromConformLoadSchedules")
  public void removeFromConformLoadSchedules(
      @RequestBody(required = true)
          RemoveConformLoadSchedulesFromConformLoadScheduleCommand command) {
    try {
      ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance()
          .removeFromConformLoadSchedules(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set ConformLoadSchedules", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ConformLoadSchedule conformLoadSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConformLoadScheduleCommandRestController.class.getName());
}
