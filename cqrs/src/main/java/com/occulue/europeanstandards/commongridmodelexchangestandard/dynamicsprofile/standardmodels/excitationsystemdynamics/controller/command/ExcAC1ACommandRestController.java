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
 * Implements Spring Controller command CQRS processing for entity ExcAC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC1A")
public class ExcAC1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAC1A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAC1A excAC1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAC1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAC1ABusinessDelegate.getExcAC1AInstance().createExcAC1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAC1A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAC1A excAC1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAC1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAC1ACommand
      // -----------------------------------------------
      completableFuture = ExcAC1ABusinessDelegate.getExcAC1AInstance().updateExcAC1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAC1AController:update() - successfully update ExcAC1A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAC1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAC1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAC1ACommand command = new DeleteExcAC1ACommand(excAC1AId);

    try {
      ExcAC1ABusinessDelegate delegate = ExcAC1ABusinessDelegate.getExcAC1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAC1A with key " + command.getExcAC1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Hvlvgates on ExcAC1A
   *
   * @param command AssignHvlvgatesToExcAC1ACommand
   */
  @PutMapping("/assignHvlvgates")
  public void assignHvlvgates(@RequestBody AssignHvlvgatesToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignHvlvgates(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hvlvgates", exc);
    }
  }

  /**
   * unassign Hvlvgates on ExcAC1A
   *
   * @param command UnAssignHvlvgatesFromExcAC1ACommand
   */
  @PutMapping("/unAssignHvlvgates")
  public void unAssignHvlvgates(
      @RequestBody(required = true) UnAssignHvlvgatesFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignHvlvgates(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hvlvgates", exc);
    }
  }

  /**
   * save Ka on ExcAC1A
   *
   * @param command AssignKaToExcAC1ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAC1A
   *
   * @param command UnAssignKaFromExcAC1ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcAC1A
   *
   * @param command AssignKcToExcAC1ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcAC1A
   *
   * @param command UnAssignKcFromExcAC1ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcAC1A
   *
   * @param command AssignKdToExcAC1ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcAC1A
   *
   * @param command UnAssignKdFromExcAC1ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcAC1A
   *
   * @param command AssignKeToExcAC1ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcAC1A
   *
   * @param command UnAssignKeFromExcAC1ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcAC1A
   *
   * @param command AssignKfToExcAC1ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcAC1A
   *
   * @param command UnAssignKfFromExcAC1ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Kf1 on ExcAC1A
   *
   * @param command AssignKf1ToExcAC1ACommand
   */
  @PutMapping("/assignKf1")
  public void assignKf1(@RequestBody AssignKf1ToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignKf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf1", exc);
    }
  }

  /**
   * unassign Kf1 on ExcAC1A
   *
   * @param command UnAssignKf1FromExcAC1ACommand
   */
  @PutMapping("/unAssignKf1")
  public void unAssignKf1(@RequestBody(required = true) UnAssignKf1FromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignKf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf1", exc);
    }
  }

  /**
   * save Kf2 on ExcAC1A
   *
   * @param command AssignKf2ToExcAC1ACommand
   */
  @PutMapping("/assignKf2")
  public void assignKf2(@RequestBody AssignKf2ToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignKf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf2", exc);
    }
  }

  /**
   * unassign Kf2 on ExcAC1A
   *
   * @param command UnAssignKf2FromExcAC1ACommand
   */
  @PutMapping("/unAssignKf2")
  public void unAssignKf2(@RequestBody(required = true) UnAssignKf2FromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignKf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf2", exc);
    }
  }

  /**
   * save Ks on ExcAC1A
   *
   * @param command AssignKsToExcAC1ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcAC1A
   *
   * @param command UnAssignKsFromExcAC1ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Seve1 on ExcAC1A
   *
   * @param command AssignSeve1ToExcAC1ACommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcAC1A
   *
   * @param command UnAssignSeve1FromExcAC1ACommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(@RequestBody(required = true) UnAssignSeve1FromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcAC1A
   *
   * @param command AssignSeve2ToExcAC1ACommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcAC1A
   *
   * @param command UnAssignSeve2FromExcAC1ACommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(@RequestBody(required = true) UnAssignSeve2FromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcAC1A
   *
   * @param command AssignTaToExcAC1ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAC1A
   *
   * @param command UnAssignTaFromExcAC1ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcAC1A
   *
   * @param command AssignTbToExcAC1ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcAC1A
   *
   * @param command UnAssignTbFromExcAC1ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcAC1A
   *
   * @param command AssignTcToExcAC1ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcAC1A
   *
   * @param command UnAssignTcFromExcAC1ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcAC1A
   *
   * @param command AssignTeToExcAC1ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAC1A
   *
   * @param command UnAssignTeFromExcAC1ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcAC1A
   *
   * @param command AssignTfToExcAC1ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcAC1A
   *
   * @param command UnAssignTfFromExcAC1ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcAC1A
   *
   * @param command AssignVamaxToExcAC1ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcAC1A
   *
   * @param command UnAssignVamaxFromExcAC1ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(@RequestBody(required = true) UnAssignVamaxFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcAC1A
   *
   * @param command AssignVaminToExcAC1ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcAC1A
   *
   * @param command UnAssignVaminFromExcAC1ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(@RequestBody(required = true) UnAssignVaminFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcAC1A
   *
   * @param command AssignVe1ToExcAC1ACommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcAC1A
   *
   * @param command UnAssignVe1FromExcAC1ACommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcAC1A
   *
   * @param command AssignVe2ToExcAC1ACommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcAC1A
   *
   * @param command UnAssignVe2FromExcAC1ACommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vrmax on ExcAC1A
   *
   * @param command AssignVrmaxToExcAC1ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcAC1A
   *
   * @param command UnAssignVrmaxFromExcAC1ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcAC1A
   *
   * @param command AssignVrminToExcAC1ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcAC1A
   *
   * @param command UnAssignVrminFromExcAC1ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcAC1ACommand command) {
    try {
      ExcAC1ABusinessDelegate.getExcAC1AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAC1A excAC1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAC1ACommandRestController.class.getName());
}
