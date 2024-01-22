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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity GenICompensationForGenJ.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GenICompensationForGenJ")
public class GenICompensationForGenJCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GenICompensationForGenJ. if not key provided, calls create, otherwise calls
   * save
   *
   * @param GenICompensationForGenJ genICompensationForGenJ
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGenICompensationForGenJCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
              .createGenICompensationForGenJ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GenICompensationForGenJ. if no key provided, calls create, otherwise calls
   * save
   *
   * @param GenICompensationForGenJ genICompensationForGenJ
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGenICompensationForGenJCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGenICompensationForGenJCommand
      // -----------------------------------------------
      completableFuture =
          GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
              .updateGenICompensationForGenJ(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GenICompensationForGenJController:update() - successfully update GenICompensationForGenJ - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GenICompensationForGenJ entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID genICompensationForGenJId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGenICompensationForGenJCommand command =
        new DeleteGenICompensationForGenJCommand(genICompensationForGenJId);

    try {
      GenICompensationForGenJBusinessDelegate delegate =
          GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GenICompensationForGenJ with key "
              + command.getGenICompensationForGenJId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Rcij on GenICompensationForGenJ
   *
   * @param command AssignRcijToGenICompensationForGenJCommand
   */
  @PutMapping("/assignRcij")
  public void assignRcij(@RequestBody AssignRcijToGenICompensationForGenJCommand command) {
    try {
      GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
          .assignRcij(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rcij", exc);
    }
  }

  /**
   * unassign Rcij on GenICompensationForGenJ
   *
   * @param command UnAssignRcijFromGenICompensationForGenJCommand
   */
  @PutMapping("/unAssignRcij")
  public void unAssignRcij(
      @RequestBody(required = true) UnAssignRcijFromGenICompensationForGenJCommand command) {
    try {
      GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
          .unAssignRcij(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rcij", exc);
    }
  }

  /**
   * save Xcij on GenICompensationForGenJ
   *
   * @param command AssignXcijToGenICompensationForGenJCommand
   */
  @PutMapping("/assignXcij")
  public void assignXcij(@RequestBody AssignXcijToGenICompensationForGenJCommand command) {
    try {
      GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
          .assignXcij(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xcij", exc);
    }
  }

  /**
   * unassign Xcij on GenICompensationForGenJ
   *
   * @param command UnAssignXcijFromGenICompensationForGenJCommand
   */
  @PutMapping("/unAssignXcij")
  public void unAssignXcij(
      @RequestBody(required = true) UnAssignXcijFromGenICompensationForGenJCommand command) {
    try {
      GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
          .unAssignXcij(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xcij", exc);
    }
  }

  /**
   * save GenICompensationForGenJ on GenICompensationForGenJ
   *
   * @param command AssignGenICompensationForGenJToGenICompensationForGenJCommand
   */
  @PutMapping("/addToGenICompensationForGenJ")
  public void addToGenICompensationForGenJ(
      @RequestBody(required = true)
          AssignGenICompensationForGenJToGenICompensationForGenJCommand command) {
    try {
      GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
          .addToGenICompensationForGenJ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set GenICompensationForGenJ", exc);
    }
  }

  /**
   * remove GenICompensationForGenJ on GenICompensationForGenJ
   *
   * @param command RemoveGenICompensationForGenJFromGenICompensationForGenJCommand
   */
  @PutMapping("/removeFromGenICompensationForGenJ")
  public void removeFromGenICompensationForGenJ(
      @RequestBody(required = true)
          RemoveGenICompensationForGenJFromGenICompensationForGenJCommand command) {
    try {
      GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
          .removeFromGenICompensationForGenJ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set GenICompensationForGenJ", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GenICompensationForGenJ genICompensationForGenJ = null;
  private static final Logger LOGGER =
      Logger.getLogger(GenICompensationForGenJCommandRestController.class.getName());
}
