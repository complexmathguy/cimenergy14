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
 * Implements Spring Controller command CQRS processing for entity Substation.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Substation")
public class SubstationCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Substation. if not key provided, calls create, otherwise calls save
   *
   * @param Substation substation
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSubstationCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SubstationBusinessDelegate.getSubstationInstance().createSubstation(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Substation. if no key provided, calls create, otherwise calls save
   *
   * @param Substation substation
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSubstationCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSubstationCommand
      // -----------------------------------------------
      completableFuture =
          SubstationBusinessDelegate.getSubstationInstance().updateSubstation(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SubstationController:update() - successfully update Substation - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Substation entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID substationId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSubstationCommand command = new DeleteSubstationCommand(substationId);

    try {
      SubstationBusinessDelegate delegate = SubstationBusinessDelegate.getSubstationInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Substation with key " + command.getSubstationId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Substations on Substation
   *
   * @param command AssignSubstationsToSubstationCommand
   */
  @PutMapping("/addToSubstations")
  public void addToSubstations(
      @RequestBody(required = true) AssignSubstationsToSubstationCommand command) {
    try {
      SubstationBusinessDelegate.getSubstationInstance().addToSubstations(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Substations", exc);
    }
  }

  /**
   * remove Substations on Substation
   *
   * @param command RemoveSubstationsFromSubstationCommand
   */
  @PutMapping("/removeFromSubstations")
  public void removeFromSubstations(
      @RequestBody(required = true) RemoveSubstationsFromSubstationCommand command) {
    try {
      SubstationBusinessDelegate.getSubstationInstance().removeFromSubstations(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Substations", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Substation substation = null;
  private static final Logger LOGGER =
      Logger.getLogger(SubstationCommandRestController.class.getName());
}
