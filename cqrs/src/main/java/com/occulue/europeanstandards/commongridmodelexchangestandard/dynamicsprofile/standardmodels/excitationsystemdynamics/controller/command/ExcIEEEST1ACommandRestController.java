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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST1A")
public class ExcIEEEST1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEST1A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST1A excIEEEST1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEST1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().createExcIEEEST1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEST1A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST1A excIEEEST1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEST1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEST1ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().updateExcIEEEST1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEST1AController:update() - successfully update ExcIEEEST1A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEST1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEST1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEST1ACommand command = new DeleteExcIEEEST1ACommand(excIEEEST1AId);

    try {
      ExcIEEEST1ABusinessDelegate delegate = ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEST1A with key " + command.getExcIEEEST1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ilr on ExcIEEEST1A
   *
   * @param command AssignIlrToExcIEEEST1ACommand
   */
  @PutMapping("/assignIlr")
  public void assignIlr(@RequestBody AssignIlrToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignIlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ilr", exc);
    }
  }

  /**
   * unassign Ilr on ExcIEEEST1A
   *
   * @param command UnAssignIlrFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignIlr")
  public void unAssignIlr(@RequestBody(required = true) UnAssignIlrFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignIlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ilr", exc);
    }
  }

  /**
   * save Ka on ExcIEEEST1A
   *
   * @param command AssignKaToExcIEEEST1ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEST1A
   *
   * @param command UnAssignKaFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcIEEEST1A
   *
   * @param command AssignKcToExcIEEEST1ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEST1A
   *
   * @param command UnAssignKcFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kf on ExcIEEEST1A
   *
   * @param command AssignKfToExcIEEEST1ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEST1A
   *
   * @param command UnAssignKfFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Klr on ExcIEEEST1A
   *
   * @param command AssignKlrToExcIEEEST1ACommand
   */
  @PutMapping("/assignKlr")
  public void assignKlr(@RequestBody AssignKlrToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignKlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Klr", exc);
    }
  }

  /**
   * unassign Klr on ExcIEEEST1A
   *
   * @param command UnAssignKlrFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignKlr")
  public void unAssignKlr(@RequestBody(required = true) UnAssignKlrFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignKlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Klr", exc);
    }
  }

  /**
   * save Pssin on ExcIEEEST1A
   *
   * @param command AssignPssinToExcIEEEST1ACommand
   */
  @PutMapping("/assignPssin")
  public void assignPssin(@RequestBody AssignPssinToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignPssin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pssin", exc);
    }
  }

  /**
   * unassign Pssin on ExcIEEEST1A
   *
   * @param command UnAssignPssinFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignPssin")
  public void unAssignPssin(
      @RequestBody(required = true) UnAssignPssinFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignPssin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pssin", exc);
    }
  }

  /**
   * save Ta on ExcIEEEST1A
   *
   * @param command AssignTaToExcIEEEST1ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEST1A
   *
   * @param command UnAssignTaFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEST1A
   *
   * @param command AssignTbToExcIEEEST1ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEST1A
   *
   * @param command UnAssignTbFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tb1 on ExcIEEEST1A
   *
   * @param command AssignTb1ToExcIEEEST1ACommand
   */
  @PutMapping("/assignTb1")
  public void assignTb1(@RequestBody AssignTb1ToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignTb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb1", exc);
    }
  }

  /**
   * unassign Tb1 on ExcIEEEST1A
   *
   * @param command UnAssignTb1FromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignTb1")
  public void unAssignTb1(@RequestBody(required = true) UnAssignTb1FromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignTb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb1", exc);
    }
  }

  /**
   * save Tc on ExcIEEEST1A
   *
   * @param command AssignTcToExcIEEEST1ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEST1A
   *
   * @param command UnAssignTcFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tc1 on ExcIEEEST1A
   *
   * @param command AssignTc1ToExcIEEEST1ACommand
   */
  @PutMapping("/assignTc1")
  public void assignTc1(@RequestBody AssignTc1ToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignTc1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc1", exc);
    }
  }

  /**
   * unassign Tc1 on ExcIEEEST1A
   *
   * @param command UnAssignTc1FromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignTc1")
  public void unAssignTc1(@RequestBody(required = true) UnAssignTc1FromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignTc1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc1", exc);
    }
  }

  /**
   * save Tf on ExcIEEEST1A
   *
   * @param command AssignTfToExcIEEEST1ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEST1A
   *
   * @param command UnAssignTfFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcIEEEST1A
   *
   * @param command AssignVamaxToExcIEEEST1ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcIEEEST1A
   *
   * @param command UnAssignVamaxFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(
      @RequestBody(required = true) UnAssignVamaxFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcIEEEST1A
   *
   * @param command AssignVaminToExcIEEEST1ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcIEEEST1A
   *
   * @param command UnAssignVaminFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(
      @RequestBody(required = true) UnAssignVaminFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Vimax on ExcIEEEST1A
   *
   * @param command AssignVimaxToExcIEEEST1ACommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcIEEEST1A
   *
   * @param command UnAssignVimaxFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(
      @RequestBody(required = true) UnAssignVimaxFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on ExcIEEEST1A
   *
   * @param command AssignViminToExcIEEEST1ACommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on ExcIEEEST1A
   *
   * @param command UnAssignViminFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(
      @RequestBody(required = true) UnAssignViminFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEST1A
   *
   * @param command AssignVrmaxToExcIEEEST1ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEST1A
   *
   * @param command UnAssignVrmaxFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEST1A
   *
   * @param command AssignVrminToExcIEEEST1ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEST1A
   *
   * @param command UnAssignVrminFromExcIEEEST1ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEST1ACommand command) {
    try {
      ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEST1A excIEEEST1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEST1ACommandRestController.class.getName());
}
