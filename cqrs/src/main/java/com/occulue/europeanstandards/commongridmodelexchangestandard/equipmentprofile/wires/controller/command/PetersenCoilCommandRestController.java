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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PetersenCoil.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PetersenCoil")
public class PetersenCoilCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PetersenCoil. if not key provided, calls create, otherwise calls save
   *
   * @param PetersenCoil petersenCoil
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePetersenCoilCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PetersenCoilBusinessDelegate.getPetersenCoilInstance().createPetersenCoil(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PetersenCoil. if no key provided, calls create, otherwise calls save
   *
   * @param PetersenCoil petersenCoil
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePetersenCoilCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePetersenCoilCommand
      // -----------------------------------------------
      completableFuture =
          PetersenCoilBusinessDelegate.getPetersenCoilInstance().updatePetersenCoil(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PetersenCoilController:update() - successfully update PetersenCoil - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PetersenCoil entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID petersenCoilId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePetersenCoilCommand command = new DeletePetersenCoilCommand(petersenCoilId);

    try {
      PetersenCoilBusinessDelegate delegate =
          PetersenCoilBusinessDelegate.getPetersenCoilInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PetersenCoil with key " + command.getPetersenCoilId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save NominalU on PetersenCoil
   *
   * @param command AssignNominalUToPetersenCoilCommand
   */
  @PutMapping("/assignNominalU")
  public void assignNominalU(@RequestBody AssignNominalUToPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().assignNominalU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NominalU", exc);
    }
  }

  /**
   * unassign NominalU on PetersenCoil
   *
   * @param command UnAssignNominalUFromPetersenCoilCommand
   */
  @PutMapping("/unAssignNominalU")
  public void unAssignNominalU(
      @RequestBody(required = true) UnAssignNominalUFromPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().unAssignNominalU(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NominalU", exc);
    }
  }

  /**
   * save OffsetCurrent on PetersenCoil
   *
   * @param command AssignOffsetCurrentToPetersenCoilCommand
   */
  @PutMapping("/assignOffsetCurrent")
  public void assignOffsetCurrent(@RequestBody AssignOffsetCurrentToPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().assignOffsetCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OffsetCurrent", exc);
    }
  }

  /**
   * unassign OffsetCurrent on PetersenCoil
   *
   * @param command UnAssignOffsetCurrentFromPetersenCoilCommand
   */
  @PutMapping("/unAssignOffsetCurrent")
  public void unAssignOffsetCurrent(
      @RequestBody(required = true) UnAssignOffsetCurrentFromPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().unAssignOffsetCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OffsetCurrent", exc);
    }
  }

  /**
   * save PositionCurrent on PetersenCoil
   *
   * @param command AssignPositionCurrentToPetersenCoilCommand
   */
  @PutMapping("/assignPositionCurrent")
  public void assignPositionCurrent(
      @RequestBody AssignPositionCurrentToPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().assignPositionCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PositionCurrent", exc);
    }
  }

  /**
   * unassign PositionCurrent on PetersenCoil
   *
   * @param command UnAssignPositionCurrentFromPetersenCoilCommand
   */
  @PutMapping("/unAssignPositionCurrent")
  public void unAssignPositionCurrent(
      @RequestBody(required = true) UnAssignPositionCurrentFromPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().unAssignPositionCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PositionCurrent", exc);
    }
  }

  /**
   * save XGroundMax on PetersenCoil
   *
   * @param command AssignXGroundMaxToPetersenCoilCommand
   */
  @PutMapping("/assignXGroundMax")
  public void assignXGroundMax(@RequestBody AssignXGroundMaxToPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().assignXGroundMax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XGroundMax", exc);
    }
  }

  /**
   * unassign XGroundMax on PetersenCoil
   *
   * @param command UnAssignXGroundMaxFromPetersenCoilCommand
   */
  @PutMapping("/unAssignXGroundMax")
  public void unAssignXGroundMax(
      @RequestBody(required = true) UnAssignXGroundMaxFromPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().unAssignXGroundMax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XGroundMax", exc);
    }
  }

  /**
   * save XGroundMin on PetersenCoil
   *
   * @param command AssignXGroundMinToPetersenCoilCommand
   */
  @PutMapping("/assignXGroundMin")
  public void assignXGroundMin(@RequestBody AssignXGroundMinToPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().assignXGroundMin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XGroundMin", exc);
    }
  }

  /**
   * unassign XGroundMin on PetersenCoil
   *
   * @param command UnAssignXGroundMinFromPetersenCoilCommand
   */
  @PutMapping("/unAssignXGroundMin")
  public void unAssignXGroundMin(
      @RequestBody(required = true) UnAssignXGroundMinFromPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().unAssignXGroundMin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XGroundMin", exc);
    }
  }

  /**
   * save XGroundNominal on PetersenCoil
   *
   * @param command AssignXGroundNominalToPetersenCoilCommand
   */
  @PutMapping("/assignXGroundNominal")
  public void assignXGroundNominal(@RequestBody AssignXGroundNominalToPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().assignXGroundNominal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XGroundNominal", exc);
    }
  }

  /**
   * unassign XGroundNominal on PetersenCoil
   *
   * @param command UnAssignXGroundNominalFromPetersenCoilCommand
   */
  @PutMapping("/unAssignXGroundNominal")
  public void unAssignXGroundNominal(
      @RequestBody(required = true) UnAssignXGroundNominalFromPetersenCoilCommand command) {
    try {
      PetersenCoilBusinessDelegate.getPetersenCoilInstance().unAssignXGroundNominal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XGroundNominal", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PetersenCoil petersenCoil = null;
  private static final Logger LOGGER =
      Logger.getLogger(PetersenCoilCommandRestController.class.getName());
}
