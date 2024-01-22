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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC3A")
public class ExcIEEEAC3ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEAC3A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC3A excIEEEAC3A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEAC3ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().createExcIEEEAC3A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEAC3A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC3A excIEEEAC3A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEAC3ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEAC3ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().updateExcIEEEAC3A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEAC3AController:update() - successfully update ExcIEEEAC3A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEAC3A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEAC3AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEAC3ACommand command = new DeleteExcIEEEAC3ACommand(excIEEEAC3AId);

    try {
      ExcIEEEAC3ABusinessDelegate delegate = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEAC3A with key " + command.getExcIEEEAC3AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdn on ExcIEEEAC3A
   *
   * @param command AssignEfdnToExcIEEEAC3ACommand
   */
  @PutMapping("/assignEfdn")
  public void assignEfdn(@RequestBody AssignEfdnToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignEfdn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdn", exc);
    }
  }

  /**
   * unassign Efdn on ExcIEEEAC3A
   *
   * @param command UnAssignEfdnFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignEfdn")
  public void unAssignEfdn(
      @RequestBody(required = true) UnAssignEfdnFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignEfdn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdn", exc);
    }
  }

  /**
   * save Ka on ExcIEEEAC3A
   *
   * @param command AssignKaToExcIEEEAC3ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEAC3A
   *
   * @param command UnAssignKaFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcIEEEAC3A
   *
   * @param command AssignKcToExcIEEEAC3ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEAC3A
   *
   * @param command UnAssignKcFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcIEEEAC3A
   *
   * @param command AssignKdToExcIEEEAC3ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcIEEEAC3A
   *
   * @param command UnAssignKdFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcIEEEAC3A
   *
   * @param command AssignKeToExcIEEEAC3ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEAC3A
   *
   * @param command UnAssignKeFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcIEEEAC3A
   *
   * @param command AssignKfToExcIEEEAC3ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEAC3A
   *
   * @param command UnAssignKfFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Kn on ExcIEEEAC3A
   *
   * @param command AssignKnToExcIEEEAC3ACommand
   */
  @PutMapping("/assignKn")
  public void assignKn(@RequestBody AssignKnToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignKn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kn", exc);
    }
  }

  /**
   * unassign Kn on ExcIEEEAC3A
   *
   * @param command UnAssignKnFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignKn")
  public void unAssignKn(@RequestBody(required = true) UnAssignKnFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignKn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kn", exc);
    }
  }

  /**
   * save Kr on ExcIEEEAC3A
   *
   * @param command AssignKrToExcIEEEAC3ACommand
   */
  @PutMapping("/assignKr")
  public void assignKr(@RequestBody AssignKrToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignKr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kr", exc);
    }
  }

  /**
   * unassign Kr on ExcIEEEAC3A
   *
   * @param command UnAssignKrFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignKr")
  public void unAssignKr(@RequestBody(required = true) UnAssignKrFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignKr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kr", exc);
    }
  }

  /**
   * save Seve1 on ExcIEEEAC3A
   *
   * @param command AssignSeve1ToExcIEEEAC3ACommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcIEEEAC3A
   *
   * @param command UnAssignSeve1FromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(
      @RequestBody(required = true) UnAssignSeve1FromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcIEEEAC3A
   *
   * @param command AssignSeve2ToExcIEEEAC3ACommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcIEEEAC3A
   *
   * @param command UnAssignSeve2FromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(
      @RequestBody(required = true) UnAssignSeve2FromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEAC3A
   *
   * @param command AssignTaToExcIEEEAC3ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEAC3A
   *
   * @param command UnAssignTaFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEAC3A
   *
   * @param command AssignTbToExcIEEEAC3ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEAC3A
   *
   * @param command UnAssignTbFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEAC3A
   *
   * @param command AssignTcToExcIEEEAC3ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEAC3A
   *
   * @param command UnAssignTcFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcIEEEAC3A
   *
   * @param command AssignTeToExcIEEEAC3ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEAC3A
   *
   * @param command UnAssignTeFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcIEEEAC3A
   *
   * @param command AssignTfToExcIEEEAC3ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEAC3A
   *
   * @param command UnAssignTfFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcIEEEAC3A
   *
   * @param command AssignVamaxToExcIEEEAC3ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcIEEEAC3A
   *
   * @param command UnAssignVamaxFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(
      @RequestBody(required = true) UnAssignVamaxFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcIEEEAC3A
   *
   * @param command AssignVaminToExcIEEEAC3ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcIEEEAC3A
   *
   * @param command UnAssignVaminFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(
      @RequestBody(required = true) UnAssignVaminFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcIEEEAC3A
   *
   * @param command AssignVe1ToExcIEEEAC3ACommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcIEEEAC3A
   *
   * @param command UnAssignVe1FromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcIEEEAC3A
   *
   * @param command AssignVe2ToExcIEEEAC3ACommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcIEEEAC3A
   *
   * @param command UnAssignVe2FromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vemin on ExcIEEEAC3A
   *
   * @param command AssignVeminToExcIEEEAC3ACommand
   */
  @PutMapping("/assignVemin")
  public void assignVemin(@RequestBody AssignVeminToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignVemin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vemin", exc);
    }
  }

  /**
   * unassign Vemin on ExcIEEEAC3A
   *
   * @param command UnAssignVeminFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignVemin")
  public void unAssignVemin(
      @RequestBody(required = true) UnAssignVeminFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignVemin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vemin", exc);
    }
  }

  /**
   * save Vfemax on ExcIEEEAC3A
   *
   * @param command AssignVfemaxToExcIEEEAC3ACommand
   */
  @PutMapping("/assignVfemax")
  public void assignVfemax(@RequestBody AssignVfemaxToExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().assignVfemax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfemax", exc);
    }
  }

  /**
   * unassign Vfemax on ExcIEEEAC3A
   *
   * @param command UnAssignVfemaxFromExcIEEEAC3ACommand
   */
  @PutMapping("/unAssignVfemax")
  public void unAssignVfemax(
      @RequestBody(required = true) UnAssignVfemaxFromExcIEEEAC3ACommand command) {
    try {
      ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().unAssignVfemax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfemax", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEAC3A excIEEEAC3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC3ACommandRestController.class.getName());
}
