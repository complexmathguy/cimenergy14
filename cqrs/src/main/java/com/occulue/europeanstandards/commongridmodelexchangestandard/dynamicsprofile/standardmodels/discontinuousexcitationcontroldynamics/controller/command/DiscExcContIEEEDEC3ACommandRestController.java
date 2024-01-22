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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity DiscExcContIEEEDEC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC3A")
public class DiscExcContIEEEDEC3ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DiscExcContIEEEDEC3A. if not key provided, calls create, otherwise calls save
   *
   * @param DiscExcContIEEEDEC3A discExcContIEEEDEC3A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDiscExcContIEEEDEC3ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance()
              .createDiscExcContIEEEDEC3A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DiscExcContIEEEDEC3A. if no key provided, calls create, otherwise calls save
   *
   * @param DiscExcContIEEEDEC3A discExcContIEEEDEC3A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDiscExcContIEEEDEC3ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDiscExcContIEEEDEC3ACommand
      // -----------------------------------------------
      completableFuture =
          DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance()
              .updateDiscExcContIEEEDEC3A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DiscExcContIEEEDEC3AController:update() - successfully update DiscExcContIEEEDEC3A - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DiscExcContIEEEDEC3A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID discExcContIEEEDEC3AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDiscExcContIEEEDEC3ACommand command =
        new DeleteDiscExcContIEEEDEC3ACommand(discExcContIEEEDEC3AId);

    try {
      DiscExcContIEEEDEC3ABusinessDelegate delegate =
          DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DiscExcContIEEEDEC3A with key "
              + command.getDiscExcContIEEEDEC3AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Tdr on DiscExcContIEEEDEC3A
   *
   * @param command AssignTdrToDiscExcContIEEEDEC3ACommand
   */
  @PutMapping("/assignTdr")
  public void assignTdr(@RequestBody AssignTdrToDiscExcContIEEEDEC3ACommand command) {
    try {
      DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().assignTdr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdr", exc);
    }
  }

  /**
   * unassign Tdr on DiscExcContIEEEDEC3A
   *
   * @param command UnAssignTdrFromDiscExcContIEEEDEC3ACommand
   */
  @PutMapping("/unAssignTdr")
  public void unAssignTdr(
      @RequestBody(required = true) UnAssignTdrFromDiscExcContIEEEDEC3ACommand command) {
    try {
      DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().unAssignTdr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdr", exc);
    }
  }

  /**
   * save Vtmin on DiscExcContIEEEDEC3A
   *
   * @param command AssignVtminToDiscExcContIEEEDEC3ACommand
   */
  @PutMapping("/assignVtmin")
  public void assignVtmin(@RequestBody AssignVtminToDiscExcContIEEEDEC3ACommand command) {
    try {
      DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().assignVtmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtmin", exc);
    }
  }

  /**
   * unassign Vtmin on DiscExcContIEEEDEC3A
   *
   * @param command UnAssignVtminFromDiscExcContIEEEDEC3ACommand
   */
  @PutMapping("/unAssignVtmin")
  public void unAssignVtmin(
      @RequestBody(required = true) UnAssignVtminFromDiscExcContIEEEDEC3ACommand command) {
    try {
      DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().unAssignVtmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DiscExcContIEEEDEC3A discExcContIEEEDEC3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC3ACommandRestController.class.getName());
}
