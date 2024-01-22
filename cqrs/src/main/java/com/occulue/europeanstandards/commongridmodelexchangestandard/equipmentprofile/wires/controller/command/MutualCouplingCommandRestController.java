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
 * Implements Spring Controller command CQRS processing for entity MutualCoupling.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MutualCoupling")
public class MutualCouplingCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a MutualCoupling. if not key provided, calls create, otherwise calls save
   *
   * @param MutualCoupling mutualCoupling
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateMutualCouplingCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          MutualCouplingBusinessDelegate.getMutualCouplingInstance().createMutualCoupling(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a MutualCoupling. if no key provided, calls create, otherwise calls save
   *
   * @param MutualCoupling mutualCoupling
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateMutualCouplingCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateMutualCouplingCommand
      // -----------------------------------------------
      completableFuture =
          MutualCouplingBusinessDelegate.getMutualCouplingInstance().updateMutualCoupling(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "MutualCouplingController:update() - successfully update MutualCoupling - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a MutualCoupling entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID mutualCouplingId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteMutualCouplingCommand command = new DeleteMutualCouplingCommand(mutualCouplingId);

    try {
      MutualCouplingBusinessDelegate delegate =
          MutualCouplingBusinessDelegate.getMutualCouplingInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted MutualCoupling with key " + command.getMutualCouplingId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save B0ch on MutualCoupling
   *
   * @param command AssignB0chToMutualCouplingCommand
   */
  @PutMapping("/assignB0ch")
  public void assignB0ch(@RequestBody AssignB0chToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().assignB0ch(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B0ch", exc);
    }
  }

  /**
   * unassign B0ch on MutualCoupling
   *
   * @param command UnAssignB0chFromMutualCouplingCommand
   */
  @PutMapping("/unAssignB0ch")
  public void unAssignB0ch(
      @RequestBody(required = true) UnAssignB0chFromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().unAssignB0ch(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B0ch", exc);
    }
  }

  /**
   * save Distance11 on MutualCoupling
   *
   * @param command AssignDistance11ToMutualCouplingCommand
   */
  @PutMapping("/assignDistance11")
  public void assignDistance11(@RequestBody AssignDistance11ToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().assignDistance11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Distance11", exc);
    }
  }

  /**
   * unassign Distance11 on MutualCoupling
   *
   * @param command UnAssignDistance11FromMutualCouplingCommand
   */
  @PutMapping("/unAssignDistance11")
  public void unAssignDistance11(
      @RequestBody(required = true) UnAssignDistance11FromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().unAssignDistance11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Distance11", exc);
    }
  }

  /**
   * save Distance12 on MutualCoupling
   *
   * @param command AssignDistance12ToMutualCouplingCommand
   */
  @PutMapping("/assignDistance12")
  public void assignDistance12(@RequestBody AssignDistance12ToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().assignDistance12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Distance12", exc);
    }
  }

  /**
   * unassign Distance12 on MutualCoupling
   *
   * @param command UnAssignDistance12FromMutualCouplingCommand
   */
  @PutMapping("/unAssignDistance12")
  public void unAssignDistance12(
      @RequestBody(required = true) UnAssignDistance12FromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().unAssignDistance12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Distance12", exc);
    }
  }

  /**
   * save Distance21 on MutualCoupling
   *
   * @param command AssignDistance21ToMutualCouplingCommand
   */
  @PutMapping("/assignDistance21")
  public void assignDistance21(@RequestBody AssignDistance21ToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().assignDistance21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Distance21", exc);
    }
  }

  /**
   * unassign Distance21 on MutualCoupling
   *
   * @param command UnAssignDistance21FromMutualCouplingCommand
   */
  @PutMapping("/unAssignDistance21")
  public void unAssignDistance21(
      @RequestBody(required = true) UnAssignDistance21FromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().unAssignDistance21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Distance21", exc);
    }
  }

  /**
   * save Distance22 on MutualCoupling
   *
   * @param command AssignDistance22ToMutualCouplingCommand
   */
  @PutMapping("/assignDistance22")
  public void assignDistance22(@RequestBody AssignDistance22ToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().assignDistance22(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Distance22", exc);
    }
  }

  /**
   * unassign Distance22 on MutualCoupling
   *
   * @param command UnAssignDistance22FromMutualCouplingCommand
   */
  @PutMapping("/unAssignDistance22")
  public void unAssignDistance22(
      @RequestBody(required = true) UnAssignDistance22FromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().unAssignDistance22(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Distance22", exc);
    }
  }

  /**
   * save G0ch on MutualCoupling
   *
   * @param command AssignG0chToMutualCouplingCommand
   */
  @PutMapping("/assignG0ch")
  public void assignG0ch(@RequestBody AssignG0chToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().assignG0ch(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G0ch", exc);
    }
  }

  /**
   * unassign G0ch on MutualCoupling
   *
   * @param command UnAssignG0chFromMutualCouplingCommand
   */
  @PutMapping("/unAssignG0ch")
  public void unAssignG0ch(
      @RequestBody(required = true) UnAssignG0chFromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().unAssignG0ch(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G0ch", exc);
    }
  }

  /**
   * save R0 on MutualCoupling
   *
   * @param command AssignR0ToMutualCouplingCommand
   */
  @PutMapping("/assignR0")
  public void assignR0(@RequestBody AssignR0ToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().assignR0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R0", exc);
    }
  }

  /**
   * unassign R0 on MutualCoupling
   *
   * @param command UnAssignR0FromMutualCouplingCommand
   */
  @PutMapping("/unAssignR0")
  public void unAssignR0(
      @RequestBody(required = true) UnAssignR0FromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().unAssignR0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R0", exc);
    }
  }

  /**
   * save X0 on MutualCoupling
   *
   * @param command AssignX0ToMutualCouplingCommand
   */
  @PutMapping("/assignX0")
  public void assignX0(@RequestBody AssignX0ToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().assignX0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X0", exc);
    }
  }

  /**
   * unassign X0 on MutualCoupling
   *
   * @param command UnAssignX0FromMutualCouplingCommand
   */
  @PutMapping("/unAssignX0")
  public void unAssignX0(
      @RequestBody(required = true) UnAssignX0FromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance().unAssignX0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X0", exc);
    }
  }

  /**
   * save HasSecondMutualCoupling on MutualCoupling
   *
   * @param command AssignHasSecondMutualCouplingToMutualCouplingCommand
   */
  @PutMapping("/addToHasSecondMutualCoupling")
  public void addToHasSecondMutualCoupling(
      @RequestBody(required = true) AssignHasSecondMutualCouplingToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance()
          .addToHasSecondMutualCoupling(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set HasSecondMutualCoupling", exc);
    }
  }

  /**
   * remove HasSecondMutualCoupling on MutualCoupling
   *
   * @param command RemoveHasSecondMutualCouplingFromMutualCouplingCommand
   */
  @PutMapping("/removeFromHasSecondMutualCoupling")
  public void removeFromHasSecondMutualCoupling(
      @RequestBody(required = true)
          RemoveHasSecondMutualCouplingFromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance()
          .removeFromHasSecondMutualCoupling(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set HasSecondMutualCoupling", exc);
    }
  }

  /**
   * save HasFirstMutualCoupling on MutualCoupling
   *
   * @param command AssignHasFirstMutualCouplingToMutualCouplingCommand
   */
  @PutMapping("/addToHasFirstMutualCoupling")
  public void addToHasFirstMutualCoupling(
      @RequestBody(required = true) AssignHasFirstMutualCouplingToMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance()
          .addToHasFirstMutualCoupling(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set HasFirstMutualCoupling", exc);
    }
  }

  /**
   * remove HasFirstMutualCoupling on MutualCoupling
   *
   * @param command RemoveHasFirstMutualCouplingFromMutualCouplingCommand
   */
  @PutMapping("/removeFromHasFirstMutualCoupling")
  public void removeFromHasFirstMutualCoupling(
      @RequestBody(required = true) RemoveHasFirstMutualCouplingFromMutualCouplingCommand command) {
    try {
      MutualCouplingBusinessDelegate.getMutualCouplingInstance()
          .removeFromHasFirstMutualCoupling(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set HasFirstMutualCoupling", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected MutualCoupling mutualCoupling = null;
  private static final Logger LOGGER =
      Logger.getLogger(MutualCouplingCommandRestController.class.getName());
}
