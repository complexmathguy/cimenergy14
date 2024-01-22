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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ExcAC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC2A")
public class ExcAC2ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAC2A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAC2A excAC2A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAC2ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAC2ABusinessDelegate.getExcAC2AInstance().createExcAC2A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAC2A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAC2A excAC2A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAC2ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAC2ACommand
      // -----------------------------------------------
      completableFuture = ExcAC2ABusinessDelegate.getExcAC2AInstance().updateExcAC2A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAC2AController:update() - successfully update ExcAC2A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAC2A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAC2AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAC2ACommand command = new DeleteExcAC2ACommand(excAC2AId);

    try {
      ExcAC2ABusinessDelegate delegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAC2A with key " + command.getExcAC2AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Hvgate on ExcAC2A
   *
   * @param command AssignHvgateToExcAC2ACommand
   */
  @PutMapping("/assignHvgate")
  public void assignHvgate(@RequestBody AssignHvgateToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignHvgate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hvgate", exc);
    }
  }

  /**
   * unassign Hvgate on ExcAC2A
   *
   * @param command UnAssignHvgateFromExcAC2ACommand
   */
  @PutMapping("/unAssignHvgate")
  public void unAssignHvgate(
      @RequestBody(required = true) UnAssignHvgateFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignHvgate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hvgate", exc);
    }
  }

  /**
   * save Ka on ExcAC2A
   *
   * @param command AssignKaToExcAC2ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAC2A
   *
   * @param command UnAssignKaFromExcAC2ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kb on ExcAC2A
   *
   * @param command AssignKbToExcAC2ACommand
   */
  @PutMapping("/assignKb")
  public void assignKb(@RequestBody AssignKbToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kb", exc);
    }
  }

  /**
   * unassign Kb on ExcAC2A
   *
   * @param command UnAssignKbFromExcAC2ACommand
   */
  @PutMapping("/unAssignKb")
  public void unAssignKb(@RequestBody(required = true) UnAssignKbFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kb", exc);
    }
  }

  /**
   * save Kb1 on ExcAC2A
   *
   * @param command AssignKb1ToExcAC2ACommand
   */
  @PutMapping("/assignKb1")
  public void assignKb1(@RequestBody AssignKb1ToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kb1", exc);
    }
  }

  /**
   * unassign Kb1 on ExcAC2A
   *
   * @param command UnAssignKb1FromExcAC2ACommand
   */
  @PutMapping("/unAssignKb1")
  public void unAssignKb1(@RequestBody(required = true) UnAssignKb1FromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kb1", exc);
    }
  }

  /**
   * save Kc on ExcAC2A
   *
   * @param command AssignKcToExcAC2ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcAC2A
   *
   * @param command UnAssignKcFromExcAC2ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcAC2A
   *
   * @param command AssignKdToExcAC2ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcAC2A
   *
   * @param command UnAssignKdFromExcAC2ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcAC2A
   *
   * @param command AssignKeToExcAC2ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcAC2A
   *
   * @param command UnAssignKeFromExcAC2ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcAC2A
   *
   * @param command AssignKfToExcAC2ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcAC2A
   *
   * @param command UnAssignKfFromExcAC2ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Kh on ExcAC2A
   *
   * @param command AssignKhToExcAC2ACommand
   */
  @PutMapping("/assignKh")
  public void assignKh(@RequestBody AssignKhToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh", exc);
    }
  }

  /**
   * unassign Kh on ExcAC2A
   *
   * @param command UnAssignKhFromExcAC2ACommand
   */
  @PutMapping("/unAssignKh")
  public void unAssignKh(@RequestBody(required = true) UnAssignKhFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh", exc);
    }
  }

  /**
   * save Kl on ExcAC2A
   *
   * @param command AssignKlToExcAC2ACommand
   */
  @PutMapping("/assignKl")
  public void assignKl(@RequestBody AssignKlToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl", exc);
    }
  }

  /**
   * unassign Kl on ExcAC2A
   *
   * @param command UnAssignKlFromExcAC2ACommand
   */
  @PutMapping("/unAssignKl")
  public void unAssignKl(@RequestBody(required = true) UnAssignKlFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl", exc);
    }
  }

  /**
   * save Kl1 on ExcAC2A
   *
   * @param command AssignKl1ToExcAC2ACommand
   */
  @PutMapping("/assignKl1")
  public void assignKl1(@RequestBody AssignKl1ToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKl1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl1", exc);
    }
  }

  /**
   * unassign Kl1 on ExcAC2A
   *
   * @param command UnAssignKl1FromExcAC2ACommand
   */
  @PutMapping("/unAssignKl1")
  public void unAssignKl1(@RequestBody(required = true) UnAssignKl1FromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKl1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl1", exc);
    }
  }

  /**
   * save Ks on ExcAC2A
   *
   * @param command AssignKsToExcAC2ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcAC2A
   *
   * @param command UnAssignKsFromExcAC2ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Lvgate on ExcAC2A
   *
   * @param command AssignLvgateToExcAC2ACommand
   */
  @PutMapping("/assignLvgate")
  public void assignLvgate(@RequestBody AssignLvgateToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignLvgate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lvgate", exc);
    }
  }

  /**
   * unassign Lvgate on ExcAC2A
   *
   * @param command UnAssignLvgateFromExcAC2ACommand
   */
  @PutMapping("/unAssignLvgate")
  public void unAssignLvgate(
      @RequestBody(required = true) UnAssignLvgateFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignLvgate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lvgate", exc);
    }
  }

  /**
   * save Seve1 on ExcAC2A
   *
   * @param command AssignSeve1ToExcAC2ACommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcAC2A
   *
   * @param command UnAssignSeve1FromExcAC2ACommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(@RequestBody(required = true) UnAssignSeve1FromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcAC2A
   *
   * @param command AssignSeve2ToExcAC2ACommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcAC2A
   *
   * @param command UnAssignSeve2FromExcAC2ACommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(@RequestBody(required = true) UnAssignSeve2FromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcAC2A
   *
   * @param command AssignTaToExcAC2ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAC2A
   *
   * @param command UnAssignTaFromExcAC2ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcAC2A
   *
   * @param command AssignTbToExcAC2ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcAC2A
   *
   * @param command UnAssignTbFromExcAC2ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcAC2A
   *
   * @param command AssignTcToExcAC2ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcAC2A
   *
   * @param command UnAssignTcFromExcAC2ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcAC2A
   *
   * @param command AssignTeToExcAC2ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAC2A
   *
   * @param command UnAssignTeFromExcAC2ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcAC2A
   *
   * @param command AssignTfToExcAC2ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcAC2A
   *
   * @param command UnAssignTfFromExcAC2ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcAC2A
   *
   * @param command AssignVamaxToExcAC2ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcAC2A
   *
   * @param command UnAssignVamaxFromExcAC2ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(@RequestBody(required = true) UnAssignVamaxFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcAC2A
   *
   * @param command AssignVaminToExcAC2ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcAC2A
   *
   * @param command UnAssignVaminFromExcAC2ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(@RequestBody(required = true) UnAssignVaminFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcAC2A
   *
   * @param command AssignVe1ToExcAC2ACommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcAC2A
   *
   * @param command UnAssignVe1FromExcAC2ACommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcAC2A
   *
   * @param command AssignVe2ToExcAC2ACommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcAC2A
   *
   * @param command UnAssignVe2FromExcAC2ACommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vfemax on ExcAC2A
   *
   * @param command AssignVfemaxToExcAC2ACommand
   */
  @PutMapping("/assignVfemax")
  public void assignVfemax(@RequestBody AssignVfemaxToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignVfemax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfemax", exc);
    }
  }

  /**
   * unassign Vfemax on ExcAC2A
   *
   * @param command UnAssignVfemaxFromExcAC2ACommand
   */
  @PutMapping("/unAssignVfemax")
  public void unAssignVfemax(
      @RequestBody(required = true) UnAssignVfemaxFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignVfemax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfemax", exc);
    }
  }

  /**
   * save Vlr on ExcAC2A
   *
   * @param command AssignVlrToExcAC2ACommand
   */
  @PutMapping("/assignVlr")
  public void assignVlr(@RequestBody AssignVlrToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignVlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vlr", exc);
    }
  }

  /**
   * unassign Vlr on ExcAC2A
   *
   * @param command UnAssignVlrFromExcAC2ACommand
   */
  @PutMapping("/unAssignVlr")
  public void unAssignVlr(@RequestBody(required = true) UnAssignVlrFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignVlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vlr", exc);
    }
  }

  /**
   * save Vrmax on ExcAC2A
   *
   * @param command AssignVrmaxToExcAC2ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcAC2A
   *
   * @param command UnAssignVrmaxFromExcAC2ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcAC2A
   *
   * @param command AssignVrminToExcAC2ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcAC2A
   *
   * @param command UnAssignVrminFromExcAC2ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcAC2ACommand command) {
    try {
      ExcAC2ABusinessDelegate.getExcAC2AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAC2A excAC2A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAC2ACommandRestController.class.getName());
}
