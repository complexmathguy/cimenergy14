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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity SvShuntCompensatorSections.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvShuntCompensatorSections")
public class SvShuntCompensatorSectionsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SvShuntCompensatorSections. if not key provided, calls create, otherwise calls
   * save
   *
   * @param SvShuntCompensatorSections svShuntCompensatorSections
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSvShuntCompensatorSectionsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance()
              .createSvShuntCompensatorSections(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SvShuntCompensatorSections. if no key provided, calls create, otherwise
   * calls save
   *
   * @param SvShuntCompensatorSections svShuntCompensatorSections
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSvShuntCompensatorSectionsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSvShuntCompensatorSectionsCommand
      // -----------------------------------------------
      completableFuture =
          SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance()
              .updateSvShuntCompensatorSections(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SvShuntCompensatorSectionsController:update() - successfully update SvShuntCompensatorSections - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SvShuntCompensatorSections entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID svShuntCompensatorSectionsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSvShuntCompensatorSectionsCommand command =
        new DeleteSvShuntCompensatorSectionsCommand(svShuntCompensatorSectionsId);

    try {
      SvShuntCompensatorSectionsBusinessDelegate delegate =
          SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SvShuntCompensatorSections with key "
              + command.getSvShuntCompensatorSectionsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Sections on SvShuntCompensatorSections
   *
   * @param command AssignSectionsToSvShuntCompensatorSectionsCommand
   */
  @PutMapping("/assignSections")
  public void assignSections(
      @RequestBody AssignSectionsToSvShuntCompensatorSectionsCommand command) {
    try {
      SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance()
          .assignSections(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Sections", exc);
    }
  }

  /**
   * unassign Sections on SvShuntCompensatorSections
   *
   * @param command UnAssignSectionsFromSvShuntCompensatorSectionsCommand
   */
  @PutMapping("/unAssignSections")
  public void unAssignSections(
      @RequestBody(required = true) UnAssignSectionsFromSvShuntCompensatorSectionsCommand command) {
    try {
      SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance()
          .unAssignSections(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Sections", exc);
    }
  }

  /**
   * save SvShuntCompensatorSections on SvShuntCompensatorSections
   *
   * @param command AssignSvShuntCompensatorSectionsToSvShuntCompensatorSectionsCommand
   */
  @PutMapping("/assignSvShuntCompensatorSections")
  public void assignSvShuntCompensatorSections(
      @RequestBody AssignSvShuntCompensatorSectionsToSvShuntCompensatorSectionsCommand command) {
    try {
      SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance()
          .assignSvShuntCompensatorSections(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SvShuntCompensatorSections", exc);
    }
  }

  /**
   * unassign SvShuntCompensatorSections on SvShuntCompensatorSections
   *
   * @param command UnAssignSvShuntCompensatorSectionsFromSvShuntCompensatorSectionsCommand
   */
  @PutMapping("/unAssignSvShuntCompensatorSections")
  public void unAssignSvShuntCompensatorSections(
      @RequestBody(required = true)
          UnAssignSvShuntCompensatorSectionsFromSvShuntCompensatorSectionsCommand command) {
    try {
      SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance()
          .unAssignSvShuntCompensatorSections(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SvShuntCompensatorSections", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SvShuntCompensatorSections svShuntCompensatorSections = null;
  private static final Logger LOGGER =
      Logger.getLogger(SvShuntCompensatorSectionsCommandRestController.class.getName());
}
