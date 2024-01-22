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
 * Implements Spring Controller command CQRS processing for entity SvTapStep.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvTapStep")
public class SvTapStepCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SvTapStep. if not key provided, calls create, otherwise calls save
   *
   * @param SvTapStep svTapStep
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSvTapStepCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = SvTapStepBusinessDelegate.getSvTapStepInstance().createSvTapStep(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SvTapStep. if no key provided, calls create, otherwise calls save
   *
   * @param SvTapStep svTapStep
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSvTapStepCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSvTapStepCommand
      // -----------------------------------------------
      completableFuture = SvTapStepBusinessDelegate.getSvTapStepInstance().updateSvTapStep(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SvTapStepController:update() - successfully update SvTapStep - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SvTapStep entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID svTapStepId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSvTapStepCommand command = new DeleteSvTapStepCommand(svTapStepId);

    try {
      SvTapStepBusinessDelegate delegate = SvTapStepBusinessDelegate.getSvTapStepInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted SvTapStep with key " + command.getSvTapStepId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Position on SvTapStep
   *
   * @param command AssignPositionToSvTapStepCommand
   */
  @PutMapping("/assignPosition")
  public void assignPosition(@RequestBody AssignPositionToSvTapStepCommand command) {
    try {
      SvTapStepBusinessDelegate.getSvTapStepInstance().assignPosition(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Position", exc);
    }
  }

  /**
   * unassign Position on SvTapStep
   *
   * @param command UnAssignPositionFromSvTapStepCommand
   */
  @PutMapping("/unAssignPosition")
  public void unAssignPosition(
      @RequestBody(required = true) UnAssignPositionFromSvTapStepCommand command) {
    try {
      SvTapStepBusinessDelegate.getSvTapStepInstance().unAssignPosition(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Position", exc);
    }
  }

  /**
   * save SvTapStep on SvTapStep
   *
   * @param command AssignSvTapStepToSvTapStepCommand
   */
  @PutMapping("/assignSvTapStep")
  public void assignSvTapStep(@RequestBody AssignSvTapStepToSvTapStepCommand command) {
    try {
      SvTapStepBusinessDelegate.getSvTapStepInstance().assignSvTapStep(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SvTapStep", exc);
    }
  }

  /**
   * unassign SvTapStep on SvTapStep
   *
   * @param command UnAssignSvTapStepFromSvTapStepCommand
   */
  @PutMapping("/unAssignSvTapStep")
  public void unAssignSvTapStep(
      @RequestBody(required = true) UnAssignSvTapStepFromSvTapStepCommand command) {
    try {
      SvTapStepBusinessDelegate.getSvTapStepInstance().unAssignSvTapStep(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SvTapStep", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SvTapStep svTapStep = null;
  private static final Logger LOGGER =
      Logger.getLogger(SvTapStepCommandRestController.class.getName());
}
