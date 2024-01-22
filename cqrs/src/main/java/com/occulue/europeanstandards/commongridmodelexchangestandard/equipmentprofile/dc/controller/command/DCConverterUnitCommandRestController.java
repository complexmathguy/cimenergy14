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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity DCConverterUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCConverterUnit")
public class DCConverterUnitCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DCConverterUnit. if not key provided, calls create, otherwise calls save
   *
   * @param DCConverterUnit dCConverterUnit
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDCConverterUnitCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DCConverterUnitBusinessDelegate.getDCConverterUnitInstance()
              .createDCConverterUnit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DCConverterUnit. if no key provided, calls create, otherwise calls save
   *
   * @param DCConverterUnit dCConverterUnit
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDCConverterUnitCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDCConverterUnitCommand
      // -----------------------------------------------
      completableFuture =
          DCConverterUnitBusinessDelegate.getDCConverterUnitInstance()
              .updateDCConverterUnit(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DCConverterUnitController:update() - successfully update DCConverterUnit - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DCConverterUnit entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dCConverterUnitId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDCConverterUnitCommand command = new DeleteDCConverterUnitCommand(dCConverterUnitId);

    try {
      DCConverterUnitBusinessDelegate delegate =
          DCConverterUnitBusinessDelegate.getDCConverterUnitInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DCConverterUnit with key " + command.getDCConverterUnitId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save DCConverterUnit on DCConverterUnit
   *
   * @param command AssignDCConverterUnitToDCConverterUnitCommand
   */
  @PutMapping("/addToDCConverterUnit")
  public void addToDCConverterUnit(
      @RequestBody(required = true) AssignDCConverterUnitToDCConverterUnitCommand command) {
    try {
      DCConverterUnitBusinessDelegate.getDCConverterUnitInstance().addToDCConverterUnit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set DCConverterUnit", exc);
    }
  }

  /**
   * remove DCConverterUnit on DCConverterUnit
   *
   * @param command RemoveDCConverterUnitFromDCConverterUnitCommand
   */
  @PutMapping("/removeFromDCConverterUnit")
  public void removeFromDCConverterUnit(
      @RequestBody(required = true) RemoveDCConverterUnitFromDCConverterUnitCommand command) {
    try {
      DCConverterUnitBusinessDelegate.getDCConverterUnitInstance()
          .removeFromDCConverterUnit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set DCConverterUnit", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCConverterUnit dCConverterUnit = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCConverterUnitCommandRestController.class.getName());
}
