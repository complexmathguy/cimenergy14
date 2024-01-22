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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity
 * UnderexcitationLimiterUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcitationLimiterUserDefined")
public class UnderexcitationLimiterUserDefinedCommandRestController
    extends BaseSpringRestController {

  /**
   * Handles create a UnderexcitationLimiterUserDefined. if not key provided, calls create,
   * otherwise calls save
   *
   * @param UnderexcitationLimiterUserDefined underexcitationLimiterUserDefined
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateUnderexcitationLimiterUserDefinedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          UnderexcitationLimiterUserDefinedBusinessDelegate
              .getUnderexcitationLimiterUserDefinedInstance()
              .createUnderexcitationLimiterUserDefined(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a UnderexcitationLimiterUserDefined. if no key provided, calls create,
   * otherwise calls save
   *
   * @param UnderexcitationLimiterUserDefined underexcitationLimiterUserDefined
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateUnderexcitationLimiterUserDefinedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateUnderexcitationLimiterUserDefinedCommand
      // -----------------------------------------------
      completableFuture =
          UnderexcitationLimiterUserDefinedBusinessDelegate
              .getUnderexcitationLimiterUserDefinedInstance()
              .updateUnderexcitationLimiterUserDefined(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "UnderexcitationLimiterUserDefinedController:update() - successfully update UnderexcitationLimiterUserDefined - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a UnderexcitationLimiterUserDefined entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID underexcitationLimiterUserDefinedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteUnderexcitationLimiterUserDefinedCommand command =
        new DeleteUnderexcitationLimiterUserDefinedCommand(underexcitationLimiterUserDefinedId);

    try {
      UnderexcitationLimiterUserDefinedBusinessDelegate delegate =
          UnderexcitationLimiterUserDefinedBusinessDelegate
              .getUnderexcitationLimiterUserDefinedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted UnderexcitationLimiterUserDefined with key "
              + command.getUnderexcitationLimiterUserDefinedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Proprietary on UnderexcitationLimiterUserDefined
   *
   * @param command AssignProprietaryToUnderexcitationLimiterUserDefinedCommand
   */
  @PutMapping("/assignProprietary")
  public void assignProprietary(
      @RequestBody AssignProprietaryToUnderexcitationLimiterUserDefinedCommand command) {
    try {
      UnderexcitationLimiterUserDefinedBusinessDelegate
          .getUnderexcitationLimiterUserDefinedInstance()
          .assignProprietary(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Proprietary", exc);
    }
  }

  /**
   * unassign Proprietary on UnderexcitationLimiterUserDefined
   *
   * @param command UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand
   */
  @PutMapping("/unAssignProprietary")
  public void unAssignProprietary(
      @RequestBody(required = true)
          UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand command) {
    try {
      UnderexcitationLimiterUserDefinedBusinessDelegate
          .getUnderexcitationLimiterUserDefinedInstance()
          .unAssignProprietary(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Proprietary", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected UnderexcitationLimiterUserDefined underexcitationLimiterUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcitationLimiterUserDefinedCommandRestController.class.getName());
}
