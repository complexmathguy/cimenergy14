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
 * Implements Spring Controller command CQRS processing for entity OverexcLimIEEE.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLimIEEE")
public class OverexcLimIEEECommandRestController extends BaseSpringRestController {

  /**
   * Handles create a OverexcLimIEEE. if not key provided, calls create, otherwise calls save
   *
   * @param OverexcLimIEEE overexcLimIEEE
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateOverexcLimIEEECommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().createOverexcLimIEEE(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a OverexcLimIEEE. if no key provided, calls create, otherwise calls save
   *
   * @param OverexcLimIEEE overexcLimIEEE
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateOverexcLimIEEECommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateOverexcLimIEEECommand
      // -----------------------------------------------
      completableFuture =
          OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().updateOverexcLimIEEE(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "OverexcLimIEEEController:update() - successfully update OverexcLimIEEE - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a OverexcLimIEEE entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID overexcLimIEEEId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteOverexcLimIEEECommand command = new DeleteOverexcLimIEEECommand(overexcLimIEEEId);

    try {
      OverexcLimIEEEBusinessDelegate delegate =
          OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted OverexcLimIEEE with key " + command.getOverexcLimIEEEId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Hyst on OverexcLimIEEE
   *
   * @param command AssignHystToOverexcLimIEEECommand
   */
  @PutMapping("/assignHyst")
  public void assignHyst(@RequestBody AssignHystToOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().assignHyst(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hyst", exc);
    }
  }

  /**
   * unassign Hyst on OverexcLimIEEE
   *
   * @param command UnAssignHystFromOverexcLimIEEECommand
   */
  @PutMapping("/unAssignHyst")
  public void unAssignHyst(
      @RequestBody(required = true) UnAssignHystFromOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().unAssignHyst(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hyst", exc);
    }
  }

  /**
   * save Ifdlim on OverexcLimIEEE
   *
   * @param command AssignIfdlimToOverexcLimIEEECommand
   */
  @PutMapping("/assignIfdlim")
  public void assignIfdlim(@RequestBody AssignIfdlimToOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().assignIfdlim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ifdlim", exc);
    }
  }

  /**
   * unassign Ifdlim on OverexcLimIEEE
   *
   * @param command UnAssignIfdlimFromOverexcLimIEEECommand
   */
  @PutMapping("/unAssignIfdlim")
  public void unAssignIfdlim(
      @RequestBody(required = true) UnAssignIfdlimFromOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().unAssignIfdlim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ifdlim", exc);
    }
  }

  /**
   * save Ifdmax on OverexcLimIEEE
   *
   * @param command AssignIfdmaxToOverexcLimIEEECommand
   */
  @PutMapping("/assignIfdmax")
  public void assignIfdmax(@RequestBody AssignIfdmaxToOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().assignIfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ifdmax", exc);
    }
  }

  /**
   * unassign Ifdmax on OverexcLimIEEE
   *
   * @param command UnAssignIfdmaxFromOverexcLimIEEECommand
   */
  @PutMapping("/unAssignIfdmax")
  public void unAssignIfdmax(
      @RequestBody(required = true) UnAssignIfdmaxFromOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().unAssignIfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ifdmax", exc);
    }
  }

  /**
   * save Itfpu on OverexcLimIEEE
   *
   * @param command AssignItfpuToOverexcLimIEEECommand
   */
  @PutMapping("/assignItfpu")
  public void assignItfpu(@RequestBody AssignItfpuToOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().assignItfpu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Itfpu", exc);
    }
  }

  /**
   * unassign Itfpu on OverexcLimIEEE
   *
   * @param command UnAssignItfpuFromOverexcLimIEEECommand
   */
  @PutMapping("/unAssignItfpu")
  public void unAssignItfpu(
      @RequestBody(required = true) UnAssignItfpuFromOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().unAssignItfpu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Itfpu", exc);
    }
  }

  /**
   * save Kcd on OverexcLimIEEE
   *
   * @param command AssignKcdToOverexcLimIEEECommand
   */
  @PutMapping("/assignKcd")
  public void assignKcd(@RequestBody AssignKcdToOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().assignKcd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kcd", exc);
    }
  }

  /**
   * unassign Kcd on OverexcLimIEEE
   *
   * @param command UnAssignKcdFromOverexcLimIEEECommand
   */
  @PutMapping("/unAssignKcd")
  public void unAssignKcd(
      @RequestBody(required = true) UnAssignKcdFromOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().unAssignKcd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kcd", exc);
    }
  }

  /**
   * save Kramp on OverexcLimIEEE
   *
   * @param command AssignKrampToOverexcLimIEEECommand
   */
  @PutMapping("/assignKramp")
  public void assignKramp(@RequestBody AssignKrampToOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().assignKramp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kramp", exc);
    }
  }

  /**
   * unassign Kramp on OverexcLimIEEE
   *
   * @param command UnAssignKrampFromOverexcLimIEEECommand
   */
  @PutMapping("/unAssignKramp")
  public void unAssignKramp(
      @RequestBody(required = true) UnAssignKrampFromOverexcLimIEEECommand command) {
    try {
      OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().unAssignKramp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kramp", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OverexcLimIEEE overexcLimIEEE = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimIEEECommandRestController.class.getName());
}
