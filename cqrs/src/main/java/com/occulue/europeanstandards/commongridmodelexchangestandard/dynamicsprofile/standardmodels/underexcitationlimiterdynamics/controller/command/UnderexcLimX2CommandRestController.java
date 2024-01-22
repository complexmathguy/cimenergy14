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
 * Implements Spring Controller command CQRS processing for entity UnderexcLimX2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimX2")
public class UnderexcLimX2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a UnderexcLimX2. if not key provided, calls create, otherwise calls save
   *
   * @param UnderexcLimX2 underexcLimX2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateUnderexcLimX2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().createUnderexcLimX2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a UnderexcLimX2. if no key provided, calls create, otherwise calls save
   *
   * @param UnderexcLimX2 underexcLimX2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateUnderexcLimX2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateUnderexcLimX2Command
      // -----------------------------------------------
      completableFuture =
          UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().updateUnderexcLimX2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "UnderexcLimX2Controller:update() - successfully update UnderexcLimX2 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a UnderexcLimX2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID underexcLimX2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteUnderexcLimX2Command command = new DeleteUnderexcLimX2Command(underexcLimX2Id);

    try {
      UnderexcLimX2BusinessDelegate delegate =
          UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted UnderexcLimX2 with key " + command.getUnderexcLimX2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kf2 on UnderexcLimX2
   *
   * @param command AssignKf2ToUnderexcLimX2Command
   */
  @PutMapping("/assignKf2")
  public void assignKf2(@RequestBody AssignKf2ToUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().assignKf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf2", exc);
    }
  }

  /**
   * unassign Kf2 on UnderexcLimX2
   *
   * @param command UnAssignKf2FromUnderexcLimX2Command
   */
  @PutMapping("/unAssignKf2")
  public void unAssignKf2(
      @RequestBody(required = true) UnAssignKf2FromUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().unAssignKf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf2", exc);
    }
  }

  /**
   * save Km on UnderexcLimX2
   *
   * @param command AssignKmToUnderexcLimX2Command
   */
  @PutMapping("/assignKm")
  public void assignKm(@RequestBody AssignKmToUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().assignKm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Km", exc);
    }
  }

  /**
   * unassign Km on UnderexcLimX2
   *
   * @param command UnAssignKmFromUnderexcLimX2Command
   */
  @PutMapping("/unAssignKm")
  public void unAssignKm(@RequestBody(required = true) UnAssignKmFromUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().unAssignKm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Km", exc);
    }
  }

  /**
   * save Melmax on UnderexcLimX2
   *
   * @param command AssignMelmaxToUnderexcLimX2Command
   */
  @PutMapping("/assignMelmax")
  public void assignMelmax(@RequestBody AssignMelmaxToUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().assignMelmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Melmax", exc);
    }
  }

  /**
   * unassign Melmax on UnderexcLimX2
   *
   * @param command UnAssignMelmaxFromUnderexcLimX2Command
   */
  @PutMapping("/unAssignMelmax")
  public void unAssignMelmax(
      @RequestBody(required = true) UnAssignMelmaxFromUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().unAssignMelmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Melmax", exc);
    }
  }

  /**
   * save Qo on UnderexcLimX2
   *
   * @param command AssignQoToUnderexcLimX2Command
   */
  @PutMapping("/assignQo")
  public void assignQo(@RequestBody AssignQoToUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().assignQo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qo", exc);
    }
  }

  /**
   * unassign Qo on UnderexcLimX2
   *
   * @param command UnAssignQoFromUnderexcLimX2Command
   */
  @PutMapping("/unAssignQo")
  public void unAssignQo(@RequestBody(required = true) UnAssignQoFromUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().unAssignQo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qo", exc);
    }
  }

  /**
   * save R on UnderexcLimX2
   *
   * @param command AssignRToUnderexcLimX2Command
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on UnderexcLimX2
   *
   * @param command UnAssignRFromUnderexcLimX2Command
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save Tf2 on UnderexcLimX2
   *
   * @param command AssignTf2ToUnderexcLimX2Command
   */
  @PutMapping("/assignTf2")
  public void assignTf2(@RequestBody AssignTf2ToUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().assignTf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf2", exc);
    }
  }

  /**
   * unassign Tf2 on UnderexcLimX2
   *
   * @param command UnAssignTf2FromUnderexcLimX2Command
   */
  @PutMapping("/unAssignTf2")
  public void unAssignTf2(
      @RequestBody(required = true) UnAssignTf2FromUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().unAssignTf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf2", exc);
    }
  }

  /**
   * save Tm on UnderexcLimX2
   *
   * @param command AssignTmToUnderexcLimX2Command
   */
  @PutMapping("/assignTm")
  public void assignTm(@RequestBody AssignTmToUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().assignTm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tm", exc);
    }
  }

  /**
   * unassign Tm on UnderexcLimX2
   *
   * @param command UnAssignTmFromUnderexcLimX2Command
   */
  @PutMapping("/unAssignTm")
  public void unAssignTm(@RequestBody(required = true) UnAssignTmFromUnderexcLimX2Command command) {
    try {
      UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().unAssignTm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tm", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected UnderexcLimX2 underexcLimX2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLimX2CommandRestController.class.getName());
}
