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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity UnderexcLimX1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimX1")
public class UnderexcLimX1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a UnderexcLimX1. if not key provided, calls create, otherwise calls save
   *
   * @param UnderexcLimX1 underexcLimX1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateUnderexcLimX1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().createUnderexcLimX1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a UnderexcLimX1. if no key provided, calls create, otherwise calls save
   *
   * @param UnderexcLimX1 underexcLimX1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateUnderexcLimX1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateUnderexcLimX1Command
      // -----------------------------------------------
      completableFuture =
          UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().updateUnderexcLimX1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "UnderexcLimX1Controller:update() - successfully update UnderexcLimX1 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a UnderexcLimX1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID underexcLimX1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteUnderexcLimX1Command command = new DeleteUnderexcLimX1Command(underexcLimX1Id);

    try {
      UnderexcLimX1BusinessDelegate delegate =
          UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted UnderexcLimX1 with key " + command.getUnderexcLimX1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K on UnderexcLimX1
   *
   * @param command AssignKToUnderexcLimX1Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on UnderexcLimX1
   *
   * @param command UnAssignKFromUnderexcLimX1Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save Kf2 on UnderexcLimX1
   *
   * @param command AssignKf2ToUnderexcLimX1Command
   */
  @PutMapping("/assignKf2")
  public void assignKf2(@RequestBody AssignKf2ToUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().assignKf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf2", exc);
    }
  }

  /**
   * unassign Kf2 on UnderexcLimX1
   *
   * @param command UnAssignKf2FromUnderexcLimX1Command
   */
  @PutMapping("/unAssignKf2")
  public void unAssignKf2(
      @RequestBody(required = true) UnAssignKf2FromUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().unAssignKf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf2", exc);
    }
  }

  /**
   * save Km on UnderexcLimX1
   *
   * @param command AssignKmToUnderexcLimX1Command
   */
  @PutMapping("/assignKm")
  public void assignKm(@RequestBody AssignKmToUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().assignKm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Km", exc);
    }
  }

  /**
   * unassign Km on UnderexcLimX1
   *
   * @param command UnAssignKmFromUnderexcLimX1Command
   */
  @PutMapping("/unAssignKm")
  public void unAssignKm(@RequestBody(required = true) UnAssignKmFromUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().unAssignKm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Km", exc);
    }
  }

  /**
   * save Melmax on UnderexcLimX1
   *
   * @param command AssignMelmaxToUnderexcLimX1Command
   */
  @PutMapping("/assignMelmax")
  public void assignMelmax(@RequestBody AssignMelmaxToUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().assignMelmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Melmax", exc);
    }
  }

  /**
   * unassign Melmax on UnderexcLimX1
   *
   * @param command UnAssignMelmaxFromUnderexcLimX1Command
   */
  @PutMapping("/unAssignMelmax")
  public void unAssignMelmax(
      @RequestBody(required = true) UnAssignMelmaxFromUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().unAssignMelmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Melmax", exc);
    }
  }

  /**
   * save Tf2 on UnderexcLimX1
   *
   * @param command AssignTf2ToUnderexcLimX1Command
   */
  @PutMapping("/assignTf2")
  public void assignTf2(@RequestBody AssignTf2ToUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().assignTf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf2", exc);
    }
  }

  /**
   * unassign Tf2 on UnderexcLimX1
   *
   * @param command UnAssignTf2FromUnderexcLimX1Command
   */
  @PutMapping("/unAssignTf2")
  public void unAssignTf2(
      @RequestBody(required = true) UnAssignTf2FromUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().unAssignTf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf2", exc);
    }
  }

  /**
   * save Tm on UnderexcLimX1
   *
   * @param command AssignTmToUnderexcLimX1Command
   */
  @PutMapping("/assignTm")
  public void assignTm(@RequestBody AssignTmToUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().assignTm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tm", exc);
    }
  }

  /**
   * unassign Tm on UnderexcLimX1
   *
   * @param command UnAssignTmFromUnderexcLimX1Command
   */
  @PutMapping("/unAssignTm")
  public void unAssignTm(@RequestBody(required = true) UnAssignTmFromUnderexcLimX1Command command) {
    try {
      UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().unAssignTm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tm", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected UnderexcLimX1 underexcLimX1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLimX1CommandRestController.class.getName());
}
