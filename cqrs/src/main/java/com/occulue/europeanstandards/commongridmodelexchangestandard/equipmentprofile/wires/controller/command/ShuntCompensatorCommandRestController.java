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
 * Implements Spring Controller command CQRS processing for entity ShuntCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ShuntCompensator")
public class ShuntCompensatorCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ShuntCompensator. if not key provided, calls create, otherwise calls save
   *
   * @param ShuntCompensator shuntCompensator
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateShuntCompensatorCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
              .createShuntCompensator(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ShuntCompensator. if no key provided, calls create, otherwise calls save
   *
   * @param ShuntCompensator shuntCompensator
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateShuntCompensatorCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateShuntCompensatorCommand
      // -----------------------------------------------
      completableFuture =
          ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
              .updateShuntCompensator(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ShuntCompensatorController:update() - successfully update ShuntCompensator - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ShuntCompensator entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID shuntCompensatorId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteShuntCompensatorCommand command = new DeleteShuntCompensatorCommand(shuntCompensatorId);

    try {
      ShuntCompensatorBusinessDelegate delegate =
          ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ShuntCompensator with key " + command.getShuntCompensatorId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save AVRDelay on ShuntCompensator
   *
   * @param command AssignAVRDelayToShuntCompensatorCommand
   */
  @PutMapping("/assignAVRDelay")
  public void assignAVRDelay(@RequestBody AssignAVRDelayToShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().assignAVRDelay(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign AVRDelay", exc);
    }
  }

  /**
   * unassign AVRDelay on ShuntCompensator
   *
   * @param command UnAssignAVRDelayFromShuntCompensatorCommand
   */
  @PutMapping("/unAssignAVRDelay")
  public void unAssignAVRDelay(
      @RequestBody(required = true) UnAssignAVRDelayFromShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().unAssignAVRDelay(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign AVRDelay", exc);
    }
  }

  /**
   * save Grounded on ShuntCompensator
   *
   * @param command AssignGroundedToShuntCompensatorCommand
   */
  @PutMapping("/assignGrounded")
  public void assignGrounded(@RequestBody AssignGroundedToShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().assignGrounded(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Grounded", exc);
    }
  }

  /**
   * unassign Grounded on ShuntCompensator
   *
   * @param command UnAssignGroundedFromShuntCompensatorCommand
   */
  @PutMapping("/unAssignGrounded")
  public void unAssignGrounded(
      @RequestBody(required = true) UnAssignGroundedFromShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().unAssignGrounded(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Grounded", exc);
    }
  }

  /**
   * save MaximumSections on ShuntCompensator
   *
   * @param command AssignMaximumSectionsToShuntCompensatorCommand
   */
  @PutMapping("/assignMaximumSections")
  public void assignMaximumSections(
      @RequestBody AssignMaximumSectionsToShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().assignMaximumSections(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaximumSections", exc);
    }
  }

  /**
   * unassign MaximumSections on ShuntCompensator
   *
   * @param command UnAssignMaximumSectionsFromShuntCompensatorCommand
   */
  @PutMapping("/unAssignMaximumSections")
  public void unAssignMaximumSections(
      @RequestBody(required = true) UnAssignMaximumSectionsFromShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
          .unAssignMaximumSections(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaximumSections", exc);
    }
  }

  /**
   * save NomU on ShuntCompensator
   *
   * @param command AssignNomUToShuntCompensatorCommand
   */
  @PutMapping("/assignNomU")
  public void assignNomU(@RequestBody AssignNomUToShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().assignNomU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NomU", exc);
    }
  }

  /**
   * unassign NomU on ShuntCompensator
   *
   * @param command UnAssignNomUFromShuntCompensatorCommand
   */
  @PutMapping("/unAssignNomU")
  public void unAssignNomU(
      @RequestBody(required = true) UnAssignNomUFromShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().unAssignNomU(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NomU", exc);
    }
  }

  /**
   * save NormalSections on ShuntCompensator
   *
   * @param command AssignNormalSectionsToShuntCompensatorCommand
   */
  @PutMapping("/assignNormalSections")
  public void assignNormalSections(
      @RequestBody AssignNormalSectionsToShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().assignNormalSections(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NormalSections", exc);
    }
  }

  /**
   * unassign NormalSections on ShuntCompensator
   *
   * @param command UnAssignNormalSectionsFromShuntCompensatorCommand
   */
  @PutMapping("/unAssignNormalSections")
  public void unAssignNormalSections(
      @RequestBody(required = true) UnAssignNormalSectionsFromShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
          .unAssignNormalSections(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NormalSections", exc);
    }
  }

  /**
   * save SwitchOnCount on ShuntCompensator
   *
   * @param command AssignSwitchOnCountToShuntCompensatorCommand
   */
  @PutMapping("/assignSwitchOnCount")
  public void assignSwitchOnCount(
      @RequestBody AssignSwitchOnCountToShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().assignSwitchOnCount(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SwitchOnCount", exc);
    }
  }

  /**
   * unassign SwitchOnCount on ShuntCompensator
   *
   * @param command UnAssignSwitchOnCountFromShuntCompensatorCommand
   */
  @PutMapping("/unAssignSwitchOnCount")
  public void unAssignSwitchOnCount(
      @RequestBody(required = true) UnAssignSwitchOnCountFromShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().unAssignSwitchOnCount(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SwitchOnCount", exc);
    }
  }

  /**
   * save SwitchOnDate on ShuntCompensator
   *
   * @param command AssignSwitchOnDateToShuntCompensatorCommand
   */
  @PutMapping("/assignSwitchOnDate")
  public void assignSwitchOnDate(@RequestBody AssignSwitchOnDateToShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().assignSwitchOnDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SwitchOnDate", exc);
    }
  }

  /**
   * unassign SwitchOnDate on ShuntCompensator
   *
   * @param command UnAssignSwitchOnDateFromShuntCompensatorCommand
   */
  @PutMapping("/unAssignSwitchOnDate")
  public void unAssignSwitchOnDate(
      @RequestBody(required = true) UnAssignSwitchOnDateFromShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().unAssignSwitchOnDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SwitchOnDate", exc);
    }
  }

  /**
   * save VoltageSensitivity on ShuntCompensator
   *
   * @param command AssignVoltageSensitivityToShuntCompensatorCommand
   */
  @PutMapping("/assignVoltageSensitivity")
  public void assignVoltageSensitivity(
      @RequestBody AssignVoltageSensitivityToShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
          .assignVoltageSensitivity(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VoltageSensitivity", exc);
    }
  }

  /**
   * unassign VoltageSensitivity on ShuntCompensator
   *
   * @param command UnAssignVoltageSensitivityFromShuntCompensatorCommand
   */
  @PutMapping("/unAssignVoltageSensitivity")
  public void unAssignVoltageSensitivity(
      @RequestBody(required = true) UnAssignVoltageSensitivityFromShuntCompensatorCommand command) {
    try {
      ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
          .unAssignVoltageSensitivity(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VoltageSensitivity", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ShuntCompensator shuntCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(ShuntCompensatorCommandRestController.class.getName());
}
