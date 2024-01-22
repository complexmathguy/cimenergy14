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
 * Implements Spring Controller command CQRS processing for entity NonConformLoad.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonConformLoad")
public class NonConformLoadCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a NonConformLoad. if not key provided, calls create, otherwise calls save
   *
   * @param NonConformLoad nonConformLoad
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateNonConformLoadCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          NonConformLoadBusinessDelegate.getNonConformLoadInstance().createNonConformLoad(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a NonConformLoad. if no key provided, calls create, otherwise calls save
   *
   * @param NonConformLoad nonConformLoad
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateNonConformLoadCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateNonConformLoadCommand
      // -----------------------------------------------
      completableFuture =
          NonConformLoadBusinessDelegate.getNonConformLoadInstance().updateNonConformLoad(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "NonConformLoadController:update() - successfully update NonConformLoad - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a NonConformLoad entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID nonConformLoadId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteNonConformLoadCommand command = new DeleteNonConformLoadCommand(nonConformLoadId);

    try {
      NonConformLoadBusinessDelegate delegate =
          NonConformLoadBusinessDelegate.getNonConformLoadInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted NonConformLoad with key " + command.getNonConformLoadId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save EnergyConsumers on NonConformLoad
   *
   * @param command AssignEnergyConsumersToNonConformLoadCommand
   */
  @PutMapping("/addToEnergyConsumers")
  public void addToEnergyConsumers(
      @RequestBody(required = true) AssignEnergyConsumersToNonConformLoadCommand command) {
    try {
      NonConformLoadBusinessDelegate.getNonConformLoadInstance().addToEnergyConsumers(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set EnergyConsumers", exc);
    }
  }

  /**
   * remove EnergyConsumers on NonConformLoad
   *
   * @param command RemoveEnergyConsumersFromNonConformLoadCommand
   */
  @PutMapping("/removeFromEnergyConsumers")
  public void removeFromEnergyConsumers(
      @RequestBody(required = true) RemoveEnergyConsumersFromNonConformLoadCommand command) {
    try {
      NonConformLoadBusinessDelegate.getNonConformLoadInstance().removeFromEnergyConsumers(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set EnergyConsumers", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected NonConformLoad nonConformLoad = null;
  private static final Logger LOGGER =
      Logger.getLogger(NonConformLoadCommandRestController.class.getName());
}
