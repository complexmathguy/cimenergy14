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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity GeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GeneratingUnit")
public class GeneratingUnitCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GeneratingUnit. if not key provided, calls create, otherwise calls save
   *
   * @param GeneratingUnit generatingUnit
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGeneratingUnitCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().createGeneratingUnit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GeneratingUnit. if no key provided, calls create, otherwise calls save
   *
   * @param GeneratingUnit generatingUnit
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGeneratingUnitCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGeneratingUnitCommand
      // -----------------------------------------------
      completableFuture =
          GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().updateGeneratingUnit(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GeneratingUnitController:update() - successfully update GeneratingUnit - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GeneratingUnit entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID generatingUnitId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGeneratingUnitCommand command = new DeleteGeneratingUnitCommand(generatingUnitId);

    try {
      GeneratingUnitBusinessDelegate delegate =
          GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GeneratingUnit with key " + command.getGeneratingUnitId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save GovernorSCD on GeneratingUnit
   *
   * @param command AssignGovernorSCDToGeneratingUnitCommand
   */
  @PutMapping("/assignGovernorSCD")
  public void assignGovernorSCD(@RequestBody AssignGovernorSCDToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignGovernorSCD(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign GovernorSCD", exc);
    }
  }

  /**
   * unassign GovernorSCD on GeneratingUnit
   *
   * @param command UnAssignGovernorSCDFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignGovernorSCD")
  public void unAssignGovernorSCD(
      @RequestBody(required = true) UnAssignGovernorSCDFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignGovernorSCD(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign GovernorSCD", exc);
    }
  }

  /**
   * save InitialP on GeneratingUnit
   *
   * @param command AssignInitialPToGeneratingUnitCommand
   */
  @PutMapping("/assignInitialP")
  public void assignInitialP(@RequestBody AssignInitialPToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignInitialP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign InitialP", exc);
    }
  }

  /**
   * unassign InitialP on GeneratingUnit
   *
   * @param command UnAssignInitialPFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignInitialP")
  public void unAssignInitialP(
      @RequestBody(required = true) UnAssignInitialPFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignInitialP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign InitialP", exc);
    }
  }

  /**
   * save LongPF on GeneratingUnit
   *
   * @param command AssignLongPFToGeneratingUnitCommand
   */
  @PutMapping("/assignLongPF")
  public void assignLongPF(@RequestBody AssignLongPFToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignLongPF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign LongPF", exc);
    }
  }

  /**
   * unassign LongPF on GeneratingUnit
   *
   * @param command UnAssignLongPFFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignLongPF")
  public void unAssignLongPF(
      @RequestBody(required = true) UnAssignLongPFFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignLongPF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign LongPF", exc);
    }
  }

  /**
   * save MaximumAllowableSpinningReserve on GeneratingUnit
   *
   * @param command AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand
   */
  @PutMapping("/assignMaximumAllowableSpinningReserve")
  public void assignMaximumAllowableSpinningReserve(
      @RequestBody AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance()
          .assignMaximumAllowableSpinningReserve(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaximumAllowableSpinningReserve", exc);
    }
  }

  /**
   * unassign MaximumAllowableSpinningReserve on GeneratingUnit
   *
   * @param command UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignMaximumAllowableSpinningReserve")
  public void unAssignMaximumAllowableSpinningReserve(
      @RequestBody(required = true)
          UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance()
          .unAssignMaximumAllowableSpinningReserve(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaximumAllowableSpinningReserve", exc);
    }
  }

  /**
   * save MaxOperatingP on GeneratingUnit
   *
   * @param command AssignMaxOperatingPToGeneratingUnitCommand
   */
  @PutMapping("/assignMaxOperatingP")
  public void assignMaxOperatingP(@RequestBody AssignMaxOperatingPToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignMaxOperatingP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxOperatingP", exc);
    }
  }

  /**
   * unassign MaxOperatingP on GeneratingUnit
   *
   * @param command UnAssignMaxOperatingPFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignMaxOperatingP")
  public void unAssignMaxOperatingP(
      @RequestBody(required = true) UnAssignMaxOperatingPFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignMaxOperatingP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxOperatingP", exc);
    }
  }

  /**
   * save MinOperatingP on GeneratingUnit
   *
   * @param command AssignMinOperatingPToGeneratingUnitCommand
   */
  @PutMapping("/assignMinOperatingP")
  public void assignMinOperatingP(@RequestBody AssignMinOperatingPToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignMinOperatingP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinOperatingP", exc);
    }
  }

  /**
   * unassign MinOperatingP on GeneratingUnit
   *
   * @param command UnAssignMinOperatingPFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignMinOperatingP")
  public void unAssignMinOperatingP(
      @RequestBody(required = true) UnAssignMinOperatingPFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignMinOperatingP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinOperatingP", exc);
    }
  }

  /**
   * save NominalP on GeneratingUnit
   *
   * @param command AssignNominalPToGeneratingUnitCommand
   */
  @PutMapping("/assignNominalP")
  public void assignNominalP(@RequestBody AssignNominalPToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignNominalP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NominalP", exc);
    }
  }

  /**
   * unassign NominalP on GeneratingUnit
   *
   * @param command UnAssignNominalPFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignNominalP")
  public void unAssignNominalP(
      @RequestBody(required = true) UnAssignNominalPFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignNominalP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NominalP", exc);
    }
  }

  /**
   * save RatedGrossMaxP on GeneratingUnit
   *
   * @param command AssignRatedGrossMaxPToGeneratingUnitCommand
   */
  @PutMapping("/assignRatedGrossMaxP")
  public void assignRatedGrossMaxP(
      @RequestBody AssignRatedGrossMaxPToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignRatedGrossMaxP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedGrossMaxP", exc);
    }
  }

  /**
   * unassign RatedGrossMaxP on GeneratingUnit
   *
   * @param command UnAssignRatedGrossMaxPFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignRatedGrossMaxP")
  public void unAssignRatedGrossMaxP(
      @RequestBody(required = true) UnAssignRatedGrossMaxPFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignRatedGrossMaxP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedGrossMaxP", exc);
    }
  }

  /**
   * save RatedGrossMinP on GeneratingUnit
   *
   * @param command AssignRatedGrossMinPToGeneratingUnitCommand
   */
  @PutMapping("/assignRatedGrossMinP")
  public void assignRatedGrossMinP(
      @RequestBody AssignRatedGrossMinPToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignRatedGrossMinP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedGrossMinP", exc);
    }
  }

  /**
   * unassign RatedGrossMinP on GeneratingUnit
   *
   * @param command UnAssignRatedGrossMinPFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignRatedGrossMinP")
  public void unAssignRatedGrossMinP(
      @RequestBody(required = true) UnAssignRatedGrossMinPFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignRatedGrossMinP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedGrossMinP", exc);
    }
  }

  /**
   * save RatedNetMaxP on GeneratingUnit
   *
   * @param command AssignRatedNetMaxPToGeneratingUnitCommand
   */
  @PutMapping("/assignRatedNetMaxP")
  public void assignRatedNetMaxP(@RequestBody AssignRatedNetMaxPToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignRatedNetMaxP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedNetMaxP", exc);
    }
  }

  /**
   * unassign RatedNetMaxP on GeneratingUnit
   *
   * @param command UnAssignRatedNetMaxPFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignRatedNetMaxP")
  public void unAssignRatedNetMaxP(
      @RequestBody(required = true) UnAssignRatedNetMaxPFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignRatedNetMaxP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedNetMaxP", exc);
    }
  }

  /**
   * save ShortPF on GeneratingUnit
   *
   * @param command AssignShortPFToGeneratingUnitCommand
   */
  @PutMapping("/assignShortPF")
  public void assignShortPF(@RequestBody AssignShortPFToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignShortPF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortPF", exc);
    }
  }

  /**
   * unassign ShortPF on GeneratingUnit
   *
   * @param command UnAssignShortPFFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignShortPF")
  public void unAssignShortPF(
      @RequestBody(required = true) UnAssignShortPFFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignShortPF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortPF", exc);
    }
  }

  /**
   * save StartupCost on GeneratingUnit
   *
   * @param command AssignStartupCostToGeneratingUnitCommand
   */
  @PutMapping("/assignStartupCost")
  public void assignStartupCost(@RequestBody AssignStartupCostToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignStartupCost(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign StartupCost", exc);
    }
  }

  /**
   * unassign StartupCost on GeneratingUnit
   *
   * @param command UnAssignStartupCostFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignStartupCost")
  public void unAssignStartupCost(
      @RequestBody(required = true) UnAssignStartupCostFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignStartupCost(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign StartupCost", exc);
    }
  }

  /**
   * save TotalEfficiency on GeneratingUnit
   *
   * @param command AssignTotalEfficiencyToGeneratingUnitCommand
   */
  @PutMapping("/assignTotalEfficiency")
  public void assignTotalEfficiency(
      @RequestBody AssignTotalEfficiencyToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignTotalEfficiency(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign TotalEfficiency", exc);
    }
  }

  /**
   * unassign TotalEfficiency on GeneratingUnit
   *
   * @param command UnAssignTotalEfficiencyFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignTotalEfficiency")
  public void unAssignTotalEfficiency(
      @RequestBody(required = true) UnAssignTotalEfficiencyFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignTotalEfficiency(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign TotalEfficiency", exc);
    }
  }

  /**
   * save VariableCost on GeneratingUnit
   *
   * @param command AssignVariableCostToGeneratingUnitCommand
   */
  @PutMapping("/assignVariableCost")
  public void assignVariableCost(@RequestBody AssignVariableCostToGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().assignVariableCost(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VariableCost", exc);
    }
  }

  /**
   * unassign VariableCost on GeneratingUnit
   *
   * @param command UnAssignVariableCostFromGeneratingUnitCommand
   */
  @PutMapping("/unAssignVariableCost")
  public void unAssignVariableCost(
      @RequestBody(required = true) UnAssignVariableCostFromGeneratingUnitCommand command) {
    try {
      GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().unAssignVariableCost(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VariableCost", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GeneratingUnit generatingUnit = null;
  private static final Logger LOGGER =
      Logger.getLogger(GeneratingUnitCommandRestController.class.getName());
}
