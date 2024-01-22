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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC2A")
public class ExcIEEEAC2ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEAC2A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC2A excIEEEAC2A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEAC2ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().createExcIEEEAC2A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEAC2A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC2A excIEEEAC2A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEAC2ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEAC2ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().updateExcIEEEAC2A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEAC2AController:update() - successfully update ExcIEEEAC2A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEAC2A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEAC2AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEAC2ACommand command = new DeleteExcIEEEAC2ACommand(excIEEEAC2AId);

    try {
      ExcIEEEAC2ABusinessDelegate delegate = ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEAC2A with key " + command.getExcIEEEAC2AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcIEEEAC2A
   *
   * @param command AssignKaToExcIEEEAC2ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEAC2A
   *
   * @param command UnAssignKaFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kb on ExcIEEEAC2A
   *
   * @param command AssignKbToExcIEEEAC2ACommand
   */
  @PutMapping("/assignKb")
  public void assignKb(@RequestBody AssignKbToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignKb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kb", exc);
    }
  }

  /**
   * unassign Kb on ExcIEEEAC2A
   *
   * @param command UnAssignKbFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignKb")
  public void unAssignKb(@RequestBody(required = true) UnAssignKbFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignKb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kb", exc);
    }
  }

  /**
   * save Kc on ExcIEEEAC2A
   *
   * @param command AssignKcToExcIEEEAC2ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEAC2A
   *
   * @param command UnAssignKcFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcIEEEAC2A
   *
   * @param command AssignKdToExcIEEEAC2ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcIEEEAC2A
   *
   * @param command UnAssignKdFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcIEEEAC2A
   *
   * @param command AssignKeToExcIEEEAC2ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEAC2A
   *
   * @param command UnAssignKeFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcIEEEAC2A
   *
   * @param command AssignKfToExcIEEEAC2ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEAC2A
   *
   * @param command UnAssignKfFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Kh on ExcIEEEAC2A
   *
   * @param command AssignKhToExcIEEEAC2ACommand
   */
  @PutMapping("/assignKh")
  public void assignKh(@RequestBody AssignKhToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignKh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh", exc);
    }
  }

  /**
   * unassign Kh on ExcIEEEAC2A
   *
   * @param command UnAssignKhFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignKh")
  public void unAssignKh(@RequestBody(required = true) UnAssignKhFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignKh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh", exc);
    }
  }

  /**
   * save Seve1 on ExcIEEEAC2A
   *
   * @param command AssignSeve1ToExcIEEEAC2ACommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcIEEEAC2A
   *
   * @param command UnAssignSeve1FromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(
      @RequestBody(required = true) UnAssignSeve1FromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcIEEEAC2A
   *
   * @param command AssignSeve2ToExcIEEEAC2ACommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcIEEEAC2A
   *
   * @param command UnAssignSeve2FromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(
      @RequestBody(required = true) UnAssignSeve2FromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEAC2A
   *
   * @param command AssignTaToExcIEEEAC2ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEAC2A
   *
   * @param command UnAssignTaFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEAC2A
   *
   * @param command AssignTbToExcIEEEAC2ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEAC2A
   *
   * @param command UnAssignTbFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEAC2A
   *
   * @param command AssignTcToExcIEEEAC2ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEAC2A
   *
   * @param command UnAssignTcFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcIEEEAC2A
   *
   * @param command AssignTeToExcIEEEAC2ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEAC2A
   *
   * @param command UnAssignTeFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcIEEEAC2A
   *
   * @param command AssignTfToExcIEEEAC2ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEAC2A
   *
   * @param command UnAssignTfFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcIEEEAC2A
   *
   * @param command AssignVamaxToExcIEEEAC2ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcIEEEAC2A
   *
   * @param command UnAssignVamaxFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(
      @RequestBody(required = true) UnAssignVamaxFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcIEEEAC2A
   *
   * @param command AssignVaminToExcIEEEAC2ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcIEEEAC2A
   *
   * @param command UnAssignVaminFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(
      @RequestBody(required = true) UnAssignVaminFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcIEEEAC2A
   *
   * @param command AssignVe1ToExcIEEEAC2ACommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcIEEEAC2A
   *
   * @param command UnAssignVe1FromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcIEEEAC2A
   *
   * @param command AssignVe2ToExcIEEEAC2ACommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcIEEEAC2A
   *
   * @param command UnAssignVe2FromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vfemax on ExcIEEEAC2A
   *
   * @param command AssignVfemaxToExcIEEEAC2ACommand
   */
  @PutMapping("/assignVfemax")
  public void assignVfemax(@RequestBody AssignVfemaxToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignVfemax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfemax", exc);
    }
  }

  /**
   * unassign Vfemax on ExcIEEEAC2A
   *
   * @param command UnAssignVfemaxFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignVfemax")
  public void unAssignVfemax(
      @RequestBody(required = true) UnAssignVfemaxFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignVfemax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfemax", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEAC2A
   *
   * @param command AssignVrmaxToExcIEEEAC2ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEAC2A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEAC2A
   *
   * @param command AssignVrminToExcIEEEAC2ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEAC2A
   *
   * @param command UnAssignVrminFromExcIEEEAC2ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEAC2ACommand command) {
    try {
      ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEAC2A excIEEEAC2A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC2ACommandRestController.class.getName());
}
