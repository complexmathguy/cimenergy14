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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity EquivalentEquipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentEquipment")
public class EquivalentEquipmentCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EquivalentEquipment. if not key provided, calls create, otherwise calls save
   *
   * @param EquivalentEquipment equivalentEquipment
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEquivalentEquipmentCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance()
              .createEquivalentEquipment(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EquivalentEquipment. if no key provided, calls create, otherwise calls save
   *
   * @param EquivalentEquipment equivalentEquipment
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEquivalentEquipmentCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEquivalentEquipmentCommand
      // -----------------------------------------------
      completableFuture =
          EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance()
              .updateEquivalentEquipment(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EquivalentEquipmentController:update() - successfully update EquivalentEquipment - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EquivalentEquipment entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID equivalentEquipmentId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEquivalentEquipmentCommand command =
        new DeleteEquivalentEquipmentCommand(equivalentEquipmentId);

    try {
      EquivalentEquipmentBusinessDelegate delegate =
          EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EquivalentEquipment with key "
              + command.getEquivalentEquipmentId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save EquivalentEquipments on EquivalentEquipment
   *
   * @param command AssignEquivalentEquipmentsToEquivalentEquipmentCommand
   */
  @PutMapping("/addToEquivalentEquipments")
  public void addToEquivalentEquipments(
      @RequestBody(required = true)
          AssignEquivalentEquipmentsToEquivalentEquipmentCommand command) {
    try {
      EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance()
          .addToEquivalentEquipments(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set EquivalentEquipments", exc);
    }
  }

  /**
   * remove EquivalentEquipments on EquivalentEquipment
   *
   * @param command RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand
   */
  @PutMapping("/removeFromEquivalentEquipments")
  public void removeFromEquivalentEquipments(
      @RequestBody(required = true)
          RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand command) {
    try {
      EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance()
          .removeFromEquivalentEquipments(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set EquivalentEquipments", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EquivalentEquipment equivalentEquipment = null;
  private static final Logger LOGGER =
      Logger.getLogger(EquivalentEquipmentCommandRestController.class.getName());
}
