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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity EquivalentInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentInjection")
public class EquivalentInjectionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EquivalentInjection. if not key provided, calls create, otherwise calls save
   *
   * @param EquivalentInjection equivalentInjection
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEquivalentInjectionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance()
              .createEquivalentInjection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EquivalentInjection. if no key provided, calls create, otherwise calls save
   *
   * @param EquivalentInjection equivalentInjection
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEquivalentInjectionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEquivalentInjectionCommand
      // -----------------------------------------------
      completableFuture =
          EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance()
              .updateEquivalentInjection(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EquivalentInjectionController:update() - successfully update EquivalentInjection - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EquivalentInjection entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID equivalentInjectionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEquivalentInjectionCommand command =
        new DeleteEquivalentInjectionCommand(equivalentInjectionId);

    try {
      EquivalentInjectionBusinessDelegate delegate =
          EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EquivalentInjection with key "
              + command.getEquivalentInjectionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save MaxP on EquivalentInjection
   *
   * @param command AssignMaxPToEquivalentInjectionCommand
   */
  @PutMapping("/assignMaxP")
  public void assignMaxP(@RequestBody AssignMaxPToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignMaxP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxP", exc);
    }
  }

  /**
   * unassign MaxP on EquivalentInjection
   *
   * @param command UnAssignMaxPFromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignMaxP")
  public void unAssignMaxP(
      @RequestBody(required = true) UnAssignMaxPFromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignMaxP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxP", exc);
    }
  }

  /**
   * save MaxQ on EquivalentInjection
   *
   * @param command AssignMaxQToEquivalentInjectionCommand
   */
  @PutMapping("/assignMaxQ")
  public void assignMaxQ(@RequestBody AssignMaxQToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignMaxQ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxQ", exc);
    }
  }

  /**
   * unassign MaxQ on EquivalentInjection
   *
   * @param command UnAssignMaxQFromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignMaxQ")
  public void unAssignMaxQ(
      @RequestBody(required = true) UnAssignMaxQFromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignMaxQ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxQ", exc);
    }
  }

  /**
   * save MinP on EquivalentInjection
   *
   * @param command AssignMinPToEquivalentInjectionCommand
   */
  @PutMapping("/assignMinP")
  public void assignMinP(@RequestBody AssignMinPToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignMinP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinP", exc);
    }
  }

  /**
   * unassign MinP on EquivalentInjection
   *
   * @param command UnAssignMinPFromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignMinP")
  public void unAssignMinP(
      @RequestBody(required = true) UnAssignMinPFromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignMinP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinP", exc);
    }
  }

  /**
   * save MinQ on EquivalentInjection
   *
   * @param command AssignMinQToEquivalentInjectionCommand
   */
  @PutMapping("/assignMinQ")
  public void assignMinQ(@RequestBody AssignMinQToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignMinQ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinQ", exc);
    }
  }

  /**
   * unassign MinQ on EquivalentInjection
   *
   * @param command UnAssignMinQFromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignMinQ")
  public void unAssignMinQ(
      @RequestBody(required = true) UnAssignMinQFromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignMinQ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinQ", exc);
    }
  }

  /**
   * save R on EquivalentInjection
   *
   * @param command AssignRToEquivalentInjectionCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on EquivalentInjection
   *
   * @param command UnAssignRFromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(
      @RequestBody(required = true) UnAssignRFromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save R0 on EquivalentInjection
   *
   * @param command AssignR0ToEquivalentInjectionCommand
   */
  @PutMapping("/assignR0")
  public void assignR0(@RequestBody AssignR0ToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignR0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R0", exc);
    }
  }

  /**
   * unassign R0 on EquivalentInjection
   *
   * @param command UnAssignR0FromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignR0")
  public void unAssignR0(
      @RequestBody(required = true) UnAssignR0FromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignR0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R0", exc);
    }
  }

  /**
   * save R2 on EquivalentInjection
   *
   * @param command AssignR2ToEquivalentInjectionCommand
   */
  @PutMapping("/assignR2")
  public void assignR2(@RequestBody AssignR2ToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignR2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R2", exc);
    }
  }

  /**
   * unassign R2 on EquivalentInjection
   *
   * @param command UnAssignR2FromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignR2")
  public void unAssignR2(
      @RequestBody(required = true) UnAssignR2FromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignR2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R2", exc);
    }
  }

  /**
   * save RegulationCapability on EquivalentInjection
   *
   * @param command AssignRegulationCapabilityToEquivalentInjectionCommand
   */
  @PutMapping("/assignRegulationCapability")
  public void assignRegulationCapability(
      @RequestBody AssignRegulationCapabilityToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance()
          .assignRegulationCapability(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RegulationCapability", exc);
    }
  }

  /**
   * unassign RegulationCapability on EquivalentInjection
   *
   * @param command UnAssignRegulationCapabilityFromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignRegulationCapability")
  public void unAssignRegulationCapability(
      @RequestBody(required = true)
          UnAssignRegulationCapabilityFromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance()
          .unAssignRegulationCapability(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RegulationCapability", exc);
    }
  }

  /**
   * save X on EquivalentInjection
   *
   * @param command AssignXToEquivalentInjectionCommand
   */
  @PutMapping("/assignX")
  public void assignX(@RequestBody AssignXToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X", exc);
    }
  }

  /**
   * unassign X on EquivalentInjection
   *
   * @param command UnAssignXFromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignX")
  public void unAssignX(
      @RequestBody(required = true) UnAssignXFromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X", exc);
    }
  }

  /**
   * save X0 on EquivalentInjection
   *
   * @param command AssignX0ToEquivalentInjectionCommand
   */
  @PutMapping("/assignX0")
  public void assignX0(@RequestBody AssignX0ToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignX0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X0", exc);
    }
  }

  /**
   * unassign X0 on EquivalentInjection
   *
   * @param command UnAssignX0FromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignX0")
  public void unAssignX0(
      @RequestBody(required = true) UnAssignX0FromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignX0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X0", exc);
    }
  }

  /**
   * save X2 on EquivalentInjection
   *
   * @param command AssignX2ToEquivalentInjectionCommand
   */
  @PutMapping("/assignX2")
  public void assignX2(@RequestBody AssignX2ToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().assignX2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X2", exc);
    }
  }

  /**
   * unassign X2 on EquivalentInjection
   *
   * @param command UnAssignX2FromEquivalentInjectionCommand
   */
  @PutMapping("/unAssignX2")
  public void unAssignX2(
      @RequestBody(required = true) UnAssignX2FromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().unAssignX2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X2", exc);
    }
  }

  /**
   * save EquivalentInjection on EquivalentInjection
   *
   * @param command AssignEquivalentInjectionToEquivalentInjectionCommand
   */
  @PutMapping("/addToEquivalentInjection")
  public void addToEquivalentInjection(
      @RequestBody(required = true) AssignEquivalentInjectionToEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance()
          .addToEquivalentInjection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set EquivalentInjection", exc);
    }
  }

  /**
   * remove EquivalentInjection on EquivalentInjection
   *
   * @param command RemoveEquivalentInjectionFromEquivalentInjectionCommand
   */
  @PutMapping("/removeFromEquivalentInjection")
  public void removeFromEquivalentInjection(
      @RequestBody(required = true)
          RemoveEquivalentInjectionFromEquivalentInjectionCommand command) {
    try {
      EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance()
          .removeFromEquivalentInjection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set EquivalentInjection", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EquivalentInjection equivalentInjection = null;
  private static final Logger LOGGER =
      Logger.getLogger(EquivalentInjectionCommandRestController.class.getName());
}
