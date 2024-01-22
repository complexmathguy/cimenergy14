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
 * Implements Spring Controller command CQRS processing for entity AnalogValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogValue")
public class AnalogValueCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a AnalogValue. if not key provided, calls create, otherwise calls save
   *
   * @param AnalogValue analogValue
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateAnalogValueCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          AnalogValueBusinessDelegate.getAnalogValueInstance().createAnalogValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a AnalogValue. if no key provided, calls create, otherwise calls save
   *
   * @param AnalogValue analogValue
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateAnalogValueCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAnalogValueCommand
      // -----------------------------------------------
      completableFuture =
          AnalogValueBusinessDelegate.getAnalogValueInstance().updateAnalogValue(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AnalogValueController:update() - successfully update AnalogValue - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a AnalogValue entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID analogValueId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAnalogValueCommand command = new DeleteAnalogValueCommand(analogValueId);

    try {
      AnalogValueBusinessDelegate delegate = AnalogValueBusinessDelegate.getAnalogValueInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted AnalogValue with key " + command.getAnalogValueId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on AnalogValue
   *
   * @param command AssignValueToAnalogValueCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToAnalogValueCommand command) {
    try {
      AnalogValueBusinessDelegate.getAnalogValueInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on AnalogValue
   *
   * @param command UnAssignValueFromAnalogValueCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromAnalogValueCommand command) {
    try {
      AnalogValueBusinessDelegate.getAnalogValueInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  /**
   * save AnalogValues on AnalogValue
   *
   * @param command AssignAnalogValuesToAnalogValueCommand
   */
  @PutMapping("/addToAnalogValues")
  public void addToAnalogValues(
      @RequestBody(required = true) AssignAnalogValuesToAnalogValueCommand command) {
    try {
      AnalogValueBusinessDelegate.getAnalogValueInstance().addToAnalogValues(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set AnalogValues", exc);
    }
  }

  /**
   * remove AnalogValues on AnalogValue
   *
   * @param command RemoveAnalogValuesFromAnalogValueCommand
   */
  @PutMapping("/removeFromAnalogValues")
  public void removeFromAnalogValues(
      @RequestBody(required = true) RemoveAnalogValuesFromAnalogValueCommand command) {
    try {
      AnalogValueBusinessDelegate.getAnalogValueInstance().removeFromAnalogValues(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set AnalogValues", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AnalogValue analogValue = null;
  private static final Logger LOGGER =
      Logger.getLogger(AnalogValueCommandRestController.class.getName());
}
