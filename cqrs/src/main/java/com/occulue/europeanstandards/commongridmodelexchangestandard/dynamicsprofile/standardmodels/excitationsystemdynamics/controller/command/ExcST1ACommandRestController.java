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
 * Implements Spring Controller command CQRS processing for entity ExcST1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST1A")
public class ExcST1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcST1A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcST1A excST1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcST1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcST1ABusinessDelegate.getExcST1AInstance().createExcST1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcST1A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcST1A excST1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcST1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcST1ACommand
      // -----------------------------------------------
      completableFuture = ExcST1ABusinessDelegate.getExcST1AInstance().updateExcST1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcST1AController:update() - successfully update ExcST1A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcST1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excST1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcST1ACommand command = new DeleteExcST1ACommand(excST1AId);

    try {
      ExcST1ABusinessDelegate delegate = ExcST1ABusinessDelegate.getExcST1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcST1A with key " + command.getExcST1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ilr on ExcST1A
   *
   * @param command AssignIlrToExcST1ACommand
   */
  @PutMapping("/assignIlr")
  public void assignIlr(@RequestBody AssignIlrToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignIlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ilr", exc);
    }
  }

  /**
   * unassign Ilr on ExcST1A
   *
   * @param command UnAssignIlrFromExcST1ACommand
   */
  @PutMapping("/unAssignIlr")
  public void unAssignIlr(@RequestBody(required = true) UnAssignIlrFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignIlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ilr", exc);
    }
  }

  /**
   * save Ka on ExcST1A
   *
   * @param command AssignKaToExcST1ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcST1A
   *
   * @param command UnAssignKaFromExcST1ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcST1A
   *
   * @param command AssignKcToExcST1ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcST1A
   *
   * @param command UnAssignKcFromExcST1ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kf on ExcST1A
   *
   * @param command AssignKfToExcST1ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcST1A
   *
   * @param command UnAssignKfFromExcST1ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Klr on ExcST1A
   *
   * @param command AssignKlrToExcST1ACommand
   */
  @PutMapping("/assignKlr")
  public void assignKlr(@RequestBody AssignKlrToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignKlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Klr", exc);
    }
  }

  /**
   * unassign Klr on ExcST1A
   *
   * @param command UnAssignKlrFromExcST1ACommand
   */
  @PutMapping("/unAssignKlr")
  public void unAssignKlr(@RequestBody(required = true) UnAssignKlrFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignKlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Klr", exc);
    }
  }

  /**
   * save Ta on ExcST1A
   *
   * @param command AssignTaToExcST1ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcST1A
   *
   * @param command UnAssignTaFromExcST1ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcST1A
   *
   * @param command AssignTbToExcST1ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcST1A
   *
   * @param command UnAssignTbFromExcST1ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tb1 on ExcST1A
   *
   * @param command AssignTb1ToExcST1ACommand
   */
  @PutMapping("/assignTb1")
  public void assignTb1(@RequestBody AssignTb1ToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignTb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb1", exc);
    }
  }

  /**
   * unassign Tb1 on ExcST1A
   *
   * @param command UnAssignTb1FromExcST1ACommand
   */
  @PutMapping("/unAssignTb1")
  public void unAssignTb1(@RequestBody(required = true) UnAssignTb1FromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignTb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb1", exc);
    }
  }

  /**
   * save Tc on ExcST1A
   *
   * @param command AssignTcToExcST1ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcST1A
   *
   * @param command UnAssignTcFromExcST1ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tc1 on ExcST1A
   *
   * @param command AssignTc1ToExcST1ACommand
   */
  @PutMapping("/assignTc1")
  public void assignTc1(@RequestBody AssignTc1ToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignTc1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc1", exc);
    }
  }

  /**
   * unassign Tc1 on ExcST1A
   *
   * @param command UnAssignTc1FromExcST1ACommand
   */
  @PutMapping("/unAssignTc1")
  public void unAssignTc1(@RequestBody(required = true) UnAssignTc1FromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignTc1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc1", exc);
    }
  }

  /**
   * save Tf on ExcST1A
   *
   * @param command AssignTfToExcST1ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcST1A
   *
   * @param command UnAssignTfFromExcST1ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcST1A
   *
   * @param command AssignVamaxToExcST1ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcST1A
   *
   * @param command UnAssignVamaxFromExcST1ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(@RequestBody(required = true) UnAssignVamaxFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcST1A
   *
   * @param command AssignVaminToExcST1ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcST1A
   *
   * @param command UnAssignVaminFromExcST1ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(@RequestBody(required = true) UnAssignVaminFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Vimax on ExcST1A
   *
   * @param command AssignVimaxToExcST1ACommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcST1A
   *
   * @param command UnAssignVimaxFromExcST1ACommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(@RequestBody(required = true) UnAssignVimaxFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on ExcST1A
   *
   * @param command AssignViminToExcST1ACommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on ExcST1A
   *
   * @param command UnAssignViminFromExcST1ACommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(@RequestBody(required = true) UnAssignViminFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vrmax on ExcST1A
   *
   * @param command AssignVrmaxToExcST1ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcST1A
   *
   * @param command UnAssignVrmaxFromExcST1ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcST1A
   *
   * @param command AssignVrminToExcST1ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcST1A
   *
   * @param command UnAssignVrminFromExcST1ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Xe on ExcST1A
   *
   * @param command AssignXeToExcST1ACommand
   */
  @PutMapping("/assignXe")
  public void assignXe(@RequestBody AssignXeToExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().assignXe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xe", exc);
    }
  }

  /**
   * unassign Xe on ExcST1A
   *
   * @param command UnAssignXeFromExcST1ACommand
   */
  @PutMapping("/unAssignXe")
  public void unAssignXe(@RequestBody(required = true) UnAssignXeFromExcST1ACommand command) {
    try {
      ExcST1ABusinessDelegate.getExcST1AInstance().unAssignXe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xe", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcST1A excST1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcST1ACommandRestController.class.getName());
}
