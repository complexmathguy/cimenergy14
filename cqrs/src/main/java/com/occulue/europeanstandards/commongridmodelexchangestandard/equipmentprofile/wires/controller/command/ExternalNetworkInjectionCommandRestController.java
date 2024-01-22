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
 * Implements Spring Controller command CQRS processing for entity ExternalNetworkInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExternalNetworkInjection")
public class ExternalNetworkInjectionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExternalNetworkInjection. if not key provided, calls create, otherwise calls
   * save
   *
   * @param ExternalNetworkInjection externalNetworkInjection
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExternalNetworkInjectionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
              .createExternalNetworkInjection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExternalNetworkInjection. if no key provided, calls create, otherwise calls
   * save
   *
   * @param ExternalNetworkInjection externalNetworkInjection
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExternalNetworkInjectionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExternalNetworkInjectionCommand
      // -----------------------------------------------
      completableFuture =
          ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
              .updateExternalNetworkInjection(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExternalNetworkInjectionController:update() - successfully update ExternalNetworkInjection - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExternalNetworkInjection entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID externalNetworkInjectionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExternalNetworkInjectionCommand command =
        new DeleteExternalNetworkInjectionCommand(externalNetworkInjectionId);

    try {
      ExternalNetworkInjectionBusinessDelegate delegate =
          ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ExternalNetworkInjection with key "
              + command.getExternalNetworkInjectionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save GovernorSCD on ExternalNetworkInjection
   *
   * @param command AssignGovernorSCDToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignGovernorSCD")
  public void assignGovernorSCD(
      @RequestBody AssignGovernorSCDToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignGovernorSCD(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign GovernorSCD", exc);
    }
  }

  /**
   * unassign GovernorSCD on ExternalNetworkInjection
   *
   * @param command UnAssignGovernorSCDFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignGovernorSCD")
  public void unAssignGovernorSCD(
      @RequestBody(required = true)
          UnAssignGovernorSCDFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignGovernorSCD(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign GovernorSCD", exc);
    }
  }

  /**
   * save IkSecond on ExternalNetworkInjection
   *
   * @param command AssignIkSecondToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignIkSecond")
  public void assignIkSecond(@RequestBody AssignIkSecondToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignIkSecond(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign IkSecond", exc);
    }
  }

  /**
   * unassign IkSecond on ExternalNetworkInjection
   *
   * @param command UnAssignIkSecondFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignIkSecond")
  public void unAssignIkSecond(
      @RequestBody(required = true) UnAssignIkSecondFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignIkSecond(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign IkSecond", exc);
    }
  }

  /**
   * save MaxInitialSymShCCurrent on ExternalNetworkInjection
   *
   * @param command AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMaxInitialSymShCCurrent")
  public void assignMaxInitialSymShCCurrent(
      @RequestBody AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMaxInitialSymShCCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxInitialSymShCCurrent", exc);
    }
  }

  /**
   * unassign MaxInitialSymShCCurrent on ExternalNetworkInjection
   *
   * @param command UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMaxInitialSymShCCurrent")
  public void unAssignMaxInitialSymShCCurrent(
      @RequestBody(required = true)
          UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMaxInitialSymShCCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxInitialSymShCCurrent", exc);
    }
  }

  /**
   * save MaxP on ExternalNetworkInjection
   *
   * @param command AssignMaxPToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMaxP")
  public void assignMaxP(@RequestBody AssignMaxPToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMaxP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxP", exc);
    }
  }

  /**
   * unassign MaxP on ExternalNetworkInjection
   *
   * @param command UnAssignMaxPFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMaxP")
  public void unAssignMaxP(
      @RequestBody(required = true) UnAssignMaxPFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMaxP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxP", exc);
    }
  }

  /**
   * save MaxQ on ExternalNetworkInjection
   *
   * @param command AssignMaxQToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMaxQ")
  public void assignMaxQ(@RequestBody AssignMaxQToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMaxQ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxQ", exc);
    }
  }

  /**
   * unassign MaxQ on ExternalNetworkInjection
   *
   * @param command UnAssignMaxQFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMaxQ")
  public void unAssignMaxQ(
      @RequestBody(required = true) UnAssignMaxQFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMaxQ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxQ", exc);
    }
  }

  /**
   * save MaxR0ToX0Ratio on ExternalNetworkInjection
   *
   * @param command AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMaxR0ToX0Ratio")
  public void assignMaxR0ToX0Ratio(
      @RequestBody AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMaxR0ToX0Ratio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxR0ToX0Ratio", exc);
    }
  }

  /**
   * unassign MaxR0ToX0Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMaxR0ToX0Ratio")
  public void unAssignMaxR0ToX0Ratio(
      @RequestBody(required = true)
          UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMaxR0ToX0Ratio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxR0ToX0Ratio", exc);
    }
  }

  /**
   * save MaxR1ToX1Ratio on ExternalNetworkInjection
   *
   * @param command AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMaxR1ToX1Ratio")
  public void assignMaxR1ToX1Ratio(
      @RequestBody AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMaxR1ToX1Ratio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxR1ToX1Ratio", exc);
    }
  }

  /**
   * unassign MaxR1ToX1Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMaxR1ToX1Ratio")
  public void unAssignMaxR1ToX1Ratio(
      @RequestBody(required = true)
          UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMaxR1ToX1Ratio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxR1ToX1Ratio", exc);
    }
  }

  /**
   * save MaxZ0ToZ1Ratio on ExternalNetworkInjection
   *
   * @param command AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMaxZ0ToZ1Ratio")
  public void assignMaxZ0ToZ1Ratio(
      @RequestBody AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMaxZ0ToZ1Ratio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxZ0ToZ1Ratio", exc);
    }
  }

  /**
   * unassign MaxZ0ToZ1Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMaxZ0ToZ1Ratio")
  public void unAssignMaxZ0ToZ1Ratio(
      @RequestBody(required = true)
          UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMaxZ0ToZ1Ratio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxZ0ToZ1Ratio", exc);
    }
  }

  /**
   * save MinInitialSymShCCurrent on ExternalNetworkInjection
   *
   * @param command AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMinInitialSymShCCurrent")
  public void assignMinInitialSymShCCurrent(
      @RequestBody AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMinInitialSymShCCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinInitialSymShCCurrent", exc);
    }
  }

  /**
   * unassign MinInitialSymShCCurrent on ExternalNetworkInjection
   *
   * @param command UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMinInitialSymShCCurrent")
  public void unAssignMinInitialSymShCCurrent(
      @RequestBody(required = true)
          UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMinInitialSymShCCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinInitialSymShCCurrent", exc);
    }
  }

  /**
   * save MinP on ExternalNetworkInjection
   *
   * @param command AssignMinPToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMinP")
  public void assignMinP(@RequestBody AssignMinPToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMinP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinP", exc);
    }
  }

  /**
   * unassign MinP on ExternalNetworkInjection
   *
   * @param command UnAssignMinPFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMinP")
  public void unAssignMinP(
      @RequestBody(required = true) UnAssignMinPFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMinP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinP", exc);
    }
  }

  /**
   * save MinQ on ExternalNetworkInjection
   *
   * @param command AssignMinQToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMinQ")
  public void assignMinQ(@RequestBody AssignMinQToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMinQ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinQ", exc);
    }
  }

  /**
   * unassign MinQ on ExternalNetworkInjection
   *
   * @param command UnAssignMinQFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMinQ")
  public void unAssignMinQ(
      @RequestBody(required = true) UnAssignMinQFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMinQ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinQ", exc);
    }
  }

  /**
   * save MinR0ToX0Ratio on ExternalNetworkInjection
   *
   * @param command AssignMinR0ToX0RatioToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMinR0ToX0Ratio")
  public void assignMinR0ToX0Ratio(
      @RequestBody AssignMinR0ToX0RatioToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMinR0ToX0Ratio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinR0ToX0Ratio", exc);
    }
  }

  /**
   * unassign MinR0ToX0Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMinR0ToX0Ratio")
  public void unAssignMinR0ToX0Ratio(
      @RequestBody(required = true)
          UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMinR0ToX0Ratio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinR0ToX0Ratio", exc);
    }
  }

  /**
   * save MinR1ToX1Ratio on ExternalNetworkInjection
   *
   * @param command AssignMinR1ToX1RatioToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMinR1ToX1Ratio")
  public void assignMinR1ToX1Ratio(
      @RequestBody AssignMinR1ToX1RatioToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMinR1ToX1Ratio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinR1ToX1Ratio", exc);
    }
  }

  /**
   * unassign MinR1ToX1Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMinR1ToX1Ratio")
  public void unAssignMinR1ToX1Ratio(
      @RequestBody(required = true)
          UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMinR1ToX1Ratio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinR1ToX1Ratio", exc);
    }
  }

  /**
   * save MinZ0ToZ1Ratio on ExternalNetworkInjection
   *
   * @param command AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignMinZ0ToZ1Ratio")
  public void assignMinZ0ToZ1Ratio(
      @RequestBody AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignMinZ0ToZ1Ratio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinZ0ToZ1Ratio", exc);
    }
  }

  /**
   * unassign MinZ0ToZ1Ratio on ExternalNetworkInjection
   *
   * @param command UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignMinZ0ToZ1Ratio")
  public void unAssignMinZ0ToZ1Ratio(
      @RequestBody(required = true)
          UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignMinZ0ToZ1Ratio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinZ0ToZ1Ratio", exc);
    }
  }

  /**
   * save VoltageFactor on ExternalNetworkInjection
   *
   * @param command AssignVoltageFactorToExternalNetworkInjectionCommand
   */
  @PutMapping("/assignVoltageFactor")
  public void assignVoltageFactor(
      @RequestBody AssignVoltageFactorToExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .assignVoltageFactor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VoltageFactor", exc);
    }
  }

  /**
   * unassign VoltageFactor on ExternalNetworkInjection
   *
   * @param command UnAssignVoltageFactorFromExternalNetworkInjectionCommand
   */
  @PutMapping("/unAssignVoltageFactor")
  public void unAssignVoltageFactor(
      @RequestBody(required = true)
          UnAssignVoltageFactorFromExternalNetworkInjectionCommand command) {
    try {
      ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
          .unAssignVoltageFactor(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VoltageFactor", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExternalNetworkInjection externalNetworkInjection = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExternalNetworkInjectionCommandRestController.class.getName());
}
