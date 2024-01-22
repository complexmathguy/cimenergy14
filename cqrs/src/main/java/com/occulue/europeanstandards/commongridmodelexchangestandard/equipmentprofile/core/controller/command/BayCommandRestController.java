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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Bay.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Bay")
public class BayCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Bay. if not key provided, calls create, otherwise calls save
   *
   * @param Bay bay
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateBayCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = BayBusinessDelegate.getBayInstance().createBay(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Bay. if no key provided, calls create, otherwise calls save
   *
   * @param Bay bay
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateBayCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateBayCommand
      // -----------------------------------------------
      completableFuture = BayBusinessDelegate.getBayInstance().updateBay(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING, "BayController:update() - successfully update Bay - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Bay entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID bayId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteBayCommand command = new DeleteBayCommand(bayId);

    try {
      BayBusinessDelegate delegate = BayBusinessDelegate.getBayInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Bay with key " + command.getBayId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Bays on Bay
   *
   * @param command AssignBaysToBayCommand
   */
  @PutMapping("/addToBays")
  public void addToBays(@RequestBody(required = true) AssignBaysToBayCommand command) {
    try {
      BayBusinessDelegate.getBayInstance().addToBays(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Bays", exc);
    }
  }

  /**
   * remove Bays on Bay
   *
   * @param command RemoveBaysFromBayCommand
   */
  @PutMapping("/removeFromBays")
  public void removeFromBays(@RequestBody(required = true) RemoveBaysFromBayCommand command) {
    try {
      BayBusinessDelegate.getBayInstance().removeFromBays(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Bays", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Bay bay = null;
  private static final Logger LOGGER = Logger.getLogger(BayCommandRestController.class.getName());
}
