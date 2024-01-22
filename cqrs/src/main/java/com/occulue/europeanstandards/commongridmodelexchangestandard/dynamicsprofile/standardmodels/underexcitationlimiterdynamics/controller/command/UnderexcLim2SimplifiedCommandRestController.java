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
 * Implements Spring Controller command CQRS processing for entity UnderexcLim2Simplified.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLim2Simplified")
public class UnderexcLim2SimplifiedCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a UnderexcLim2Simplified. if not key provided, calls create, otherwise calls
   * save
   *
   * @param UnderexcLim2Simplified underexcLim2Simplified
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateUnderexcLim2SimplifiedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
              .createUnderexcLim2Simplified(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a UnderexcLim2Simplified. if no key provided, calls create, otherwise calls
   * save
   *
   * @param UnderexcLim2Simplified underexcLim2Simplified
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateUnderexcLim2SimplifiedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateUnderexcLim2SimplifiedCommand
      // -----------------------------------------------
      completableFuture =
          UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
              .updateUnderexcLim2Simplified(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "UnderexcLim2SimplifiedController:update() - successfully update UnderexcLim2Simplified - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a UnderexcLim2Simplified entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID underexcLim2SimplifiedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteUnderexcLim2SimplifiedCommand command =
        new DeleteUnderexcLim2SimplifiedCommand(underexcLim2SimplifiedId);

    try {
      UnderexcLim2SimplifiedBusinessDelegate delegate =
          UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted UnderexcLim2Simplified with key "
              + command.getUnderexcLim2SimplifiedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kui on UnderexcLim2Simplified
   *
   * @param command AssignKuiToUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/assignKui")
  public void assignKui(@RequestBody AssignKuiToUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().assignKui(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kui", exc);
    }
  }

  /**
   * unassign Kui on UnderexcLim2Simplified
   *
   * @param command UnAssignKuiFromUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/unAssignKui")
  public void unAssignKui(
      @RequestBody(required = true) UnAssignKuiFromUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .unAssignKui(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kui", exc);
    }
  }

  /**
   * save P0 on UnderexcLim2Simplified
   *
   * @param command AssignP0ToUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/assignP0")
  public void assignP0(@RequestBody AssignP0ToUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().assignP0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P0", exc);
    }
  }

  /**
   * unassign P0 on UnderexcLim2Simplified
   *
   * @param command UnAssignP0FromUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/unAssignP0")
  public void unAssignP0(
      @RequestBody(required = true) UnAssignP0FromUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .unAssignP0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P0", exc);
    }
  }

  /**
   * save P1 on UnderexcLim2Simplified
   *
   * @param command AssignP1ToUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/assignP1")
  public void assignP1(@RequestBody AssignP1ToUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().assignP1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P1", exc);
    }
  }

  /**
   * unassign P1 on UnderexcLim2Simplified
   *
   * @param command UnAssignP1FromUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/unAssignP1")
  public void unAssignP1(
      @RequestBody(required = true) UnAssignP1FromUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .unAssignP1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P1", exc);
    }
  }

  /**
   * save Q0 on UnderexcLim2Simplified
   *
   * @param command AssignQ0ToUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/assignQ0")
  public void assignQ0(@RequestBody AssignQ0ToUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().assignQ0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q0", exc);
    }
  }

  /**
   * unassign Q0 on UnderexcLim2Simplified
   *
   * @param command UnAssignQ0FromUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/unAssignQ0")
  public void unAssignQ0(
      @RequestBody(required = true) UnAssignQ0FromUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .unAssignQ0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q0", exc);
    }
  }

  /**
   * save Q1 on UnderexcLim2Simplified
   *
   * @param command AssignQ1ToUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/assignQ1")
  public void assignQ1(@RequestBody AssignQ1ToUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().assignQ1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q1", exc);
    }
  }

  /**
   * unassign Q1 on UnderexcLim2Simplified
   *
   * @param command UnAssignQ1FromUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/unAssignQ1")
  public void unAssignQ1(
      @RequestBody(required = true) UnAssignQ1FromUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .unAssignQ1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q1", exc);
    }
  }

  /**
   * save Vuimax on UnderexcLim2Simplified
   *
   * @param command AssignVuimaxToUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/assignVuimax")
  public void assignVuimax(@RequestBody AssignVuimaxToUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .assignVuimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vuimax", exc);
    }
  }

  /**
   * unassign Vuimax on UnderexcLim2Simplified
   *
   * @param command UnAssignVuimaxFromUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/unAssignVuimax")
  public void unAssignVuimax(
      @RequestBody(required = true) UnAssignVuimaxFromUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .unAssignVuimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vuimax", exc);
    }
  }

  /**
   * save Vuimin on UnderexcLim2Simplified
   *
   * @param command AssignVuiminToUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/assignVuimin")
  public void assignVuimin(@RequestBody AssignVuiminToUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .assignVuimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vuimin", exc);
    }
  }

  /**
   * unassign Vuimin on UnderexcLim2Simplified
   *
   * @param command UnAssignVuiminFromUnderexcLim2SimplifiedCommand
   */
  @PutMapping("/unAssignVuimin")
  public void unAssignVuimin(
      @RequestBody(required = true) UnAssignVuiminFromUnderexcLim2SimplifiedCommand command) {
    try {
      UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
          .unAssignVuimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vuimin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected UnderexcLim2Simplified underexcLim2Simplified = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLim2SimplifiedCommandRestController.class.getName());
}
