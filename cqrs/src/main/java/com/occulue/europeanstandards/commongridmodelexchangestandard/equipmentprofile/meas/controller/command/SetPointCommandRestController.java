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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity SetPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SetPoint")
public class SetPointCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SetPoint. if not key provided, calls create, otherwise calls save
   *
   * @param SetPoint setPoint
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSetPointCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = SetPointBusinessDelegate.getSetPointInstance().createSetPoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SetPoint. if no key provided, calls create, otherwise calls save
   *
   * @param SetPoint setPoint
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSetPointCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSetPointCommand
      // -----------------------------------------------
      completableFuture = SetPointBusinessDelegate.getSetPointInstance().updateSetPoint(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SetPointController:update() - successfully update SetPoint - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SetPoint entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID setPointId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSetPointCommand command = new DeleteSetPointCommand(setPointId);

    try {
      SetPointBusinessDelegate delegate = SetPointBusinessDelegate.getSetPointInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted SetPoint with key " + command.getSetPointId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save NormalValue on SetPoint
   *
   * @param command AssignNormalValueToSetPointCommand
   */
  @PutMapping("/assignNormalValue")
  public void assignNormalValue(@RequestBody AssignNormalValueToSetPointCommand command) {
    try {
      SetPointBusinessDelegate.getSetPointInstance().assignNormalValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NormalValue", exc);
    }
  }

  /**
   * unassign NormalValue on SetPoint
   *
   * @param command UnAssignNormalValueFromSetPointCommand
   */
  @PutMapping("/unAssignNormalValue")
  public void unAssignNormalValue(
      @RequestBody(required = true) UnAssignNormalValueFromSetPointCommand command) {
    try {
      SetPointBusinessDelegate.getSetPointInstance().unAssignNormalValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NormalValue", exc);
    }
  }

  /**
   * save Value on SetPoint
   *
   * @param command AssignValueToSetPointCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToSetPointCommand command) {
    try {
      SetPointBusinessDelegate.getSetPointInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on SetPoint
   *
   * @param command UnAssignValueFromSetPointCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromSetPointCommand command) {
    try {
      SetPointBusinessDelegate.getSetPointInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SetPoint setPoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(SetPointCommandRestController.class.getName());
}
