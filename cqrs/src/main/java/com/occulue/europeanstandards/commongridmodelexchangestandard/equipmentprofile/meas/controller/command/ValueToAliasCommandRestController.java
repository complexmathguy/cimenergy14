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
 * Implements Spring Controller command CQRS processing for entity ValueToAlias.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ValueToAlias")
public class ValueToAliasCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ValueToAlias. if not key provided, calls create, otherwise calls save
   *
   * @param ValueToAlias valueToAlias
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateValueToAliasCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ValueToAliasBusinessDelegate.getValueToAliasInstance().createValueToAlias(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ValueToAlias. if no key provided, calls create, otherwise calls save
   *
   * @param ValueToAlias valueToAlias
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateValueToAliasCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateValueToAliasCommand
      // -----------------------------------------------
      completableFuture =
          ValueToAliasBusinessDelegate.getValueToAliasInstance().updateValueToAlias(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ValueToAliasController:update() - successfully update ValueToAlias - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ValueToAlias entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID valueToAliasId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteValueToAliasCommand command = new DeleteValueToAliasCommand(valueToAliasId);

    try {
      ValueToAliasBusinessDelegate delegate =
          ValueToAliasBusinessDelegate.getValueToAliasInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ValueToAlias with key " + command.getValueToAliasId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on ValueToAlias
   *
   * @param command AssignValueToValueToAliasCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToValueToAliasCommand command) {
    try {
      ValueToAliasBusinessDelegate.getValueToAliasInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on ValueToAlias
   *
   * @param command UnAssignValueFromValueToAliasCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromValueToAliasCommand command) {
    try {
      ValueToAliasBusinessDelegate.getValueToAliasInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  /**
   * save Values on ValueToAlias
   *
   * @param command AssignValuesToValueToAliasCommand
   */
  @PutMapping("/addToValues")
  public void addToValues(@RequestBody(required = true) AssignValuesToValueToAliasCommand command) {
    try {
      ValueToAliasBusinessDelegate.getValueToAliasInstance().addToValues(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Values", exc);
    }
  }

  /**
   * remove Values on ValueToAlias
   *
   * @param command RemoveValuesFromValueToAliasCommand
   */
  @PutMapping("/removeFromValues")
  public void removeFromValues(
      @RequestBody(required = true) RemoveValuesFromValueToAliasCommand command) {
    try {
      ValueToAliasBusinessDelegate.getValueToAliasInstance().removeFromValues(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Values", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ValueToAlias valueToAlias = null;
  private static final Logger LOGGER =
      Logger.getLogger(ValueToAliasCommandRestController.class.getName());
}
