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
 * Implements Spring Controller command CQRS processing for entity ConformLoad.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConformLoad")
public class ConformLoadCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ConformLoad. if not key provided, calls create, otherwise calls save
   *
   * @param ConformLoad conformLoad
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateConformLoadCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ConformLoadBusinessDelegate.getConformLoadInstance().createConformLoad(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ConformLoad. if no key provided, calls create, otherwise calls save
   *
   * @param ConformLoad conformLoad
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateConformLoadCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateConformLoadCommand
      // -----------------------------------------------
      completableFuture =
          ConformLoadBusinessDelegate.getConformLoadInstance().updateConformLoad(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ConformLoadController:update() - successfully update ConformLoad - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ConformLoad entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID conformLoadId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteConformLoadCommand command = new DeleteConformLoadCommand(conformLoadId);

    try {
      ConformLoadBusinessDelegate delegate = ConformLoadBusinessDelegate.getConformLoadInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ConformLoad with key " + command.getConformLoadId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save EnergyConsumers on ConformLoad
   *
   * @param command AssignEnergyConsumersToConformLoadCommand
   */
  @PutMapping("/addToEnergyConsumers")
  public void addToEnergyConsumers(
      @RequestBody(required = true) AssignEnergyConsumersToConformLoadCommand command) {
    try {
      ConformLoadBusinessDelegate.getConformLoadInstance().addToEnergyConsumers(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set EnergyConsumers", exc);
    }
  }

  /**
   * remove EnergyConsumers on ConformLoad
   *
   * @param command RemoveEnergyConsumersFromConformLoadCommand
   */
  @PutMapping("/removeFromEnergyConsumers")
  public void removeFromEnergyConsumers(
      @RequestBody(required = true) RemoveEnergyConsumersFromConformLoadCommand command) {
    try {
      ConformLoadBusinessDelegate.getConformLoadInstance().removeFromEnergyConsumers(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set EnergyConsumers", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ConformLoad conformLoad = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConformLoadCommandRestController.class.getName());
}
