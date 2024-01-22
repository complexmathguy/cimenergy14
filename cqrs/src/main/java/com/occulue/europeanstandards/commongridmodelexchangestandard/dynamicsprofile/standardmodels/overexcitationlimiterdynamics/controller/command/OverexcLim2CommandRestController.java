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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity OverexcLim2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLim2")
public class OverexcLim2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a OverexcLim2. if not key provided, calls create, otherwise calls save
   *
   * @param OverexcLim2 overexcLim2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateOverexcLim2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          OverexcLim2BusinessDelegate.getOverexcLim2Instance().createOverexcLim2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a OverexcLim2. if no key provided, calls create, otherwise calls save
   *
   * @param OverexcLim2 overexcLim2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateOverexcLim2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateOverexcLim2Command
      // -----------------------------------------------
      completableFuture =
          OverexcLim2BusinessDelegate.getOverexcLim2Instance().updateOverexcLim2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "OverexcLim2Controller:update() - successfully update OverexcLim2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a OverexcLim2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID overexcLim2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteOverexcLim2Command command = new DeleteOverexcLim2Command(overexcLim2Id);

    try {
      OverexcLim2BusinessDelegate delegate = OverexcLim2BusinessDelegate.getOverexcLim2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted OverexcLim2 with key " + command.getOverexcLim2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ifdlim on OverexcLim2
   *
   * @param command AssignIfdlimToOverexcLim2Command
   */
  @PutMapping("/assignIfdlim")
  public void assignIfdlim(@RequestBody AssignIfdlimToOverexcLim2Command command) {
    try {
      OverexcLim2BusinessDelegate.getOverexcLim2Instance().assignIfdlim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ifdlim", exc);
    }
  }

  /**
   * unassign Ifdlim on OverexcLim2
   *
   * @param command UnAssignIfdlimFromOverexcLim2Command
   */
  @PutMapping("/unAssignIfdlim")
  public void unAssignIfdlim(
      @RequestBody(required = true) UnAssignIfdlimFromOverexcLim2Command command) {
    try {
      OverexcLim2BusinessDelegate.getOverexcLim2Instance().unAssignIfdlim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ifdlim", exc);
    }
  }

  /**
   * save Koi on OverexcLim2
   *
   * @param command AssignKoiToOverexcLim2Command
   */
  @PutMapping("/assignKoi")
  public void assignKoi(@RequestBody AssignKoiToOverexcLim2Command command) {
    try {
      OverexcLim2BusinessDelegate.getOverexcLim2Instance().assignKoi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Koi", exc);
    }
  }

  /**
   * unassign Koi on OverexcLim2
   *
   * @param command UnAssignKoiFromOverexcLim2Command
   */
  @PutMapping("/unAssignKoi")
  public void unAssignKoi(@RequestBody(required = true) UnAssignKoiFromOverexcLim2Command command) {
    try {
      OverexcLim2BusinessDelegate.getOverexcLim2Instance().unAssignKoi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Koi", exc);
    }
  }

  /**
   * save Voimax on OverexcLim2
   *
   * @param command AssignVoimaxToOverexcLim2Command
   */
  @PutMapping("/assignVoimax")
  public void assignVoimax(@RequestBody AssignVoimaxToOverexcLim2Command command) {
    try {
      OverexcLim2BusinessDelegate.getOverexcLim2Instance().assignVoimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Voimax", exc);
    }
  }

  /**
   * unassign Voimax on OverexcLim2
   *
   * @param command UnAssignVoimaxFromOverexcLim2Command
   */
  @PutMapping("/unAssignVoimax")
  public void unAssignVoimax(
      @RequestBody(required = true) UnAssignVoimaxFromOverexcLim2Command command) {
    try {
      OverexcLim2BusinessDelegate.getOverexcLim2Instance().unAssignVoimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Voimax", exc);
    }
  }

  /**
   * save Voimin on OverexcLim2
   *
   * @param command AssignVoiminToOverexcLim2Command
   */
  @PutMapping("/assignVoimin")
  public void assignVoimin(@RequestBody AssignVoiminToOverexcLim2Command command) {
    try {
      OverexcLim2BusinessDelegate.getOverexcLim2Instance().assignVoimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Voimin", exc);
    }
  }

  /**
   * unassign Voimin on OverexcLim2
   *
   * @param command UnAssignVoiminFromOverexcLim2Command
   */
  @PutMapping("/unAssignVoimin")
  public void unAssignVoimin(
      @RequestBody(required = true) UnAssignVoiminFromOverexcLim2Command command) {
    try {
      OverexcLim2BusinessDelegate.getOverexcLim2Instance().unAssignVoimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Voimin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OverexcLim2 overexcLim2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcLim2CommandRestController.class.getName());
}
