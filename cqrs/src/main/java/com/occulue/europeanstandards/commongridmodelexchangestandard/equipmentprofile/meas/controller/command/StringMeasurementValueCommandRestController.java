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
 * Implements Spring Controller command CQRS processing for entity StringMeasurementValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StringMeasurementValue")
public class StringMeasurementValueCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a StringMeasurementValue. if not key provided, calls create, otherwise calls
   * save
   *
   * @param StringMeasurementValue stringMeasurementValue
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateStringMeasurementValueCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
              .createStringMeasurementValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a StringMeasurementValue. if no key provided, calls create, otherwise calls
   * save
   *
   * @param StringMeasurementValue stringMeasurementValue
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateStringMeasurementValueCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateStringMeasurementValueCommand
      // -----------------------------------------------
      completableFuture =
          StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
              .updateStringMeasurementValue(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "StringMeasurementValueController:update() - successfully update StringMeasurementValue - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a StringMeasurementValue entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID stringMeasurementValueId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteStringMeasurementValueCommand command =
        new DeleteStringMeasurementValueCommand(stringMeasurementValueId);

    try {
      StringMeasurementValueBusinessDelegate delegate =
          StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted StringMeasurementValue with key "
              + command.getStringMeasurementValueId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on StringMeasurementValue
   *
   * @param command AssignValueToStringMeasurementValueCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToStringMeasurementValueCommand command) {
    try {
      StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
          .assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on StringMeasurementValue
   *
   * @param command UnAssignValueFromStringMeasurementValueCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromStringMeasurementValueCommand command) {
    try {
      StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
          .unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  /**
   * save StringMeasurementValues on StringMeasurementValue
   *
   * @param command AssignStringMeasurementValuesToStringMeasurementValueCommand
   */
  @PutMapping("/addToStringMeasurementValues")
  public void addToStringMeasurementValues(
      @RequestBody(required = true)
          AssignStringMeasurementValuesToStringMeasurementValueCommand command) {
    try {
      StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
          .addToStringMeasurementValues(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set StringMeasurementValues", exc);
    }
  }

  /**
   * remove StringMeasurementValues on StringMeasurementValue
   *
   * @param command RemoveStringMeasurementValuesFromStringMeasurementValueCommand
   */
  @PutMapping("/removeFromStringMeasurementValues")
  public void removeFromStringMeasurementValues(
      @RequestBody(required = true)
          RemoveStringMeasurementValuesFromStringMeasurementValueCommand command) {
    try {
      StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
          .removeFromStringMeasurementValues(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set StringMeasurementValues", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected StringMeasurementValue stringMeasurementValue = null;
  private static final Logger LOGGER =
      Logger.getLogger(StringMeasurementValueCommandRestController.class.getName());
}
