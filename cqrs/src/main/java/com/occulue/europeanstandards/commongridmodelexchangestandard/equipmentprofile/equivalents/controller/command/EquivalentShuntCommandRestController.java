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
 * Implements Spring Controller command CQRS processing for entity EquivalentShunt.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentShunt")
public class EquivalentShuntCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EquivalentShunt. if not key provided, calls create, otherwise calls save
   *
   * @param EquivalentShunt equivalentShunt
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEquivalentShuntCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EquivalentShuntBusinessDelegate.getEquivalentShuntInstance()
              .createEquivalentShunt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EquivalentShunt. if no key provided, calls create, otherwise calls save
   *
   * @param EquivalentShunt equivalentShunt
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEquivalentShuntCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEquivalentShuntCommand
      // -----------------------------------------------
      completableFuture =
          EquivalentShuntBusinessDelegate.getEquivalentShuntInstance()
              .updateEquivalentShunt(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EquivalentShuntController:update() - successfully update EquivalentShunt - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EquivalentShunt entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID equivalentShuntId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEquivalentShuntCommand command = new DeleteEquivalentShuntCommand(equivalentShuntId);

    try {
      EquivalentShuntBusinessDelegate delegate =
          EquivalentShuntBusinessDelegate.getEquivalentShuntInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EquivalentShunt with key " + command.getEquivalentShuntId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save B on EquivalentShunt
   *
   * @param command AssignBToEquivalentShuntCommand
   */
  @PutMapping("/assignB")
  public void assignB(@RequestBody AssignBToEquivalentShuntCommand command) {
    try {
      EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().assignB(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B", exc);
    }
  }

  /**
   * unassign B on EquivalentShunt
   *
   * @param command UnAssignBFromEquivalentShuntCommand
   */
  @PutMapping("/unAssignB")
  public void unAssignB(@RequestBody(required = true) UnAssignBFromEquivalentShuntCommand command) {
    try {
      EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().unAssignB(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B", exc);
    }
  }

  /**
   * save G on EquivalentShunt
   *
   * @param command AssignGToEquivalentShuntCommand
   */
  @PutMapping("/assignG")
  public void assignG(@RequestBody AssignGToEquivalentShuntCommand command) {
    try {
      EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().assignG(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G", exc);
    }
  }

  /**
   * unassign G on EquivalentShunt
   *
   * @param command UnAssignGFromEquivalentShuntCommand
   */
  @PutMapping("/unAssignG")
  public void unAssignG(@RequestBody(required = true) UnAssignGFromEquivalentShuntCommand command) {
    try {
      EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().unAssignG(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EquivalentShunt equivalentShunt = null;
  private static final Logger LOGGER =
      Logger.getLogger(EquivalentShuntCommandRestController.class.getName());
}
