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
 * Implements Spring Controller command CQRS processing for entity AnalogControl.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogControl")
public class AnalogControlCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a AnalogControl. if not key provided, calls create, otherwise calls save
   *
   * @param AnalogControl analogControl
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateAnalogControlCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          AnalogControlBusinessDelegate.getAnalogControlInstance().createAnalogControl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a AnalogControl. if no key provided, calls create, otherwise calls save
   *
   * @param AnalogControl analogControl
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateAnalogControlCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAnalogControlCommand
      // -----------------------------------------------
      completableFuture =
          AnalogControlBusinessDelegate.getAnalogControlInstance().updateAnalogControl(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AnalogControlController:update() - successfully update AnalogControl - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a AnalogControl entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID analogControlId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAnalogControlCommand command = new DeleteAnalogControlCommand(analogControlId);

    try {
      AnalogControlBusinessDelegate delegate =
          AnalogControlBusinessDelegate.getAnalogControlInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted AnalogControl with key " + command.getAnalogControlId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save MaxValue on AnalogControl
   *
   * @param command AssignMaxValueToAnalogControlCommand
   */
  @PutMapping("/assignMaxValue")
  public void assignMaxValue(@RequestBody AssignMaxValueToAnalogControlCommand command) {
    try {
      AnalogControlBusinessDelegate.getAnalogControlInstance().assignMaxValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxValue", exc);
    }
  }

  /**
   * unassign MaxValue on AnalogControl
   *
   * @param command UnAssignMaxValueFromAnalogControlCommand
   */
  @PutMapping("/unAssignMaxValue")
  public void unAssignMaxValue(
      @RequestBody(required = true) UnAssignMaxValueFromAnalogControlCommand command) {
    try {
      AnalogControlBusinessDelegate.getAnalogControlInstance().unAssignMaxValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxValue", exc);
    }
  }

  /**
   * save MinValue on AnalogControl
   *
   * @param command AssignMinValueToAnalogControlCommand
   */
  @PutMapping("/assignMinValue")
  public void assignMinValue(@RequestBody AssignMinValueToAnalogControlCommand command) {
    try {
      AnalogControlBusinessDelegate.getAnalogControlInstance().assignMinValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinValue", exc);
    }
  }

  /**
   * unassign MinValue on AnalogControl
   *
   * @param command UnAssignMinValueFromAnalogControlCommand
   */
  @PutMapping("/unAssignMinValue")
  public void unAssignMinValue(
      @RequestBody(required = true) UnAssignMinValueFromAnalogControlCommand command) {
    try {
      AnalogControlBusinessDelegate.getAnalogControlInstance().unAssignMinValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinValue", exc);
    }
  }

  /**
   * save AnalogControl on AnalogControl
   *
   * @param command AssignAnalogControlToAnalogControlCommand
   */
  @PutMapping("/assignAnalogControl")
  public void assignAnalogControl(@RequestBody AssignAnalogControlToAnalogControlCommand command) {
    try {
      AnalogControlBusinessDelegate.getAnalogControlInstance().assignAnalogControl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign AnalogControl", exc);
    }
  }

  /**
   * unassign AnalogControl on AnalogControl
   *
   * @param command UnAssignAnalogControlFromAnalogControlCommand
   */
  @PutMapping("/unAssignAnalogControl")
  public void unAssignAnalogControl(
      @RequestBody(required = true) UnAssignAnalogControlFromAnalogControlCommand command) {
    try {
      AnalogControlBusinessDelegate.getAnalogControlInstance().unAssignAnalogControl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign AnalogControl", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AnalogControl analogControl = null;
  private static final Logger LOGGER =
      Logger.getLogger(AnalogControlCommandRestController.class.getName());
}
