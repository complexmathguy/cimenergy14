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
 * Implements Spring Controller command CQRS processing for entity ExcST6B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST6B")
public class ExcST6BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcST6B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcST6B excST6B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcST6BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcST6BBusinessDelegate.getExcST6BInstance().createExcST6B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcST6B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcST6B excST6B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcST6BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcST6BCommand
      // -----------------------------------------------
      completableFuture = ExcST6BBusinessDelegate.getExcST6BInstance().updateExcST6B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcST6BController:update() - successfully update ExcST6B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcST6B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excST6BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcST6BCommand command = new DeleteExcST6BCommand(excST6BId);

    try {
      ExcST6BBusinessDelegate delegate = ExcST6BBusinessDelegate.getExcST6BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcST6B with key " + command.getExcST6BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ilr on ExcST6B
   *
   * @param command AssignIlrToExcST6BCommand
   */
  @PutMapping("/assignIlr")
  public void assignIlr(@RequestBody AssignIlrToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignIlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ilr", exc);
    }
  }

  /**
   * unassign Ilr on ExcST6B
   *
   * @param command UnAssignIlrFromExcST6BCommand
   */
  @PutMapping("/unAssignIlr")
  public void unAssignIlr(@RequestBody(required = true) UnAssignIlrFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignIlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ilr", exc);
    }
  }

  /**
   * save K1 on ExcST6B
   *
   * @param command AssignK1ToExcST6BCommand
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on ExcST6B
   *
   * @param command UnAssignK1FromExcST6BCommand
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save Kcl on ExcST6B
   *
   * @param command AssignKclToExcST6BCommand
   */
  @PutMapping("/assignKcl")
  public void assignKcl(@RequestBody AssignKclToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignKcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kcl", exc);
    }
  }

  /**
   * unassign Kcl on ExcST6B
   *
   * @param command UnAssignKclFromExcST6BCommand
   */
  @PutMapping("/unAssignKcl")
  public void unAssignKcl(@RequestBody(required = true) UnAssignKclFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignKcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kcl", exc);
    }
  }

  /**
   * save Kff on ExcST6B
   *
   * @param command AssignKffToExcST6BCommand
   */
  @PutMapping("/assignKff")
  public void assignKff(@RequestBody AssignKffToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignKff(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kff", exc);
    }
  }

  /**
   * unassign Kff on ExcST6B
   *
   * @param command UnAssignKffFromExcST6BCommand
   */
  @PutMapping("/unAssignKff")
  public void unAssignKff(@RequestBody(required = true) UnAssignKffFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignKff(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kff", exc);
    }
  }

  /**
   * save Kg on ExcST6B
   *
   * @param command AssignKgToExcST6BCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on ExcST6B
   *
   * @param command UnAssignKgFromExcST6BCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Kia on ExcST6B
   *
   * @param command AssignKiaToExcST6BCommand
   */
  @PutMapping("/assignKia")
  public void assignKia(@RequestBody AssignKiaToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignKia(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kia", exc);
    }
  }

  /**
   * unassign Kia on ExcST6B
   *
   * @param command UnAssignKiaFromExcST6BCommand
   */
  @PutMapping("/unAssignKia")
  public void unAssignKia(@RequestBody(required = true) UnAssignKiaFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignKia(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kia", exc);
    }
  }

  /**
   * save Klr on ExcST6B
   *
   * @param command AssignKlrToExcST6BCommand
   */
  @PutMapping("/assignKlr")
  public void assignKlr(@RequestBody AssignKlrToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignKlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Klr", exc);
    }
  }

  /**
   * unassign Klr on ExcST6B
   *
   * @param command UnAssignKlrFromExcST6BCommand
   */
  @PutMapping("/unAssignKlr")
  public void unAssignKlr(@RequestBody(required = true) UnAssignKlrFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignKlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Klr", exc);
    }
  }

  /**
   * save Km on ExcST6B
   *
   * @param command AssignKmToExcST6BCommand
   */
  @PutMapping("/assignKm")
  public void assignKm(@RequestBody AssignKmToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignKm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Km", exc);
    }
  }

  /**
   * unassign Km on ExcST6B
   *
   * @param command UnAssignKmFromExcST6BCommand
   */
  @PutMapping("/unAssignKm")
  public void unAssignKm(@RequestBody(required = true) UnAssignKmFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignKm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Km", exc);
    }
  }

  /**
   * save Kpa on ExcST6B
   *
   * @param command AssignKpaToExcST6BCommand
   */
  @PutMapping("/assignKpa")
  public void assignKpa(@RequestBody AssignKpaToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignKpa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpa", exc);
    }
  }

  /**
   * unassign Kpa on ExcST6B
   *
   * @param command UnAssignKpaFromExcST6BCommand
   */
  @PutMapping("/unAssignKpa")
  public void unAssignKpa(@RequestBody(required = true) UnAssignKpaFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignKpa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpa", exc);
    }
  }

  /**
   * save Kvd on ExcST6B
   *
   * @param command AssignKvdToExcST6BCommand
   */
  @PutMapping("/assignKvd")
  public void assignKvd(@RequestBody AssignKvdToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignKvd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kvd", exc);
    }
  }

  /**
   * unassign Kvd on ExcST6B
   *
   * @param command UnAssignKvdFromExcST6BCommand
   */
  @PutMapping("/unAssignKvd")
  public void unAssignKvd(@RequestBody(required = true) UnAssignKvdFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignKvd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kvd", exc);
    }
  }

  /**
   * save Tg on ExcST6B
   *
   * @param command AssignTgToExcST6BCommand
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on ExcST6B
   *
   * @param command UnAssignTgFromExcST6BCommand
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Ts on ExcST6B
   *
   * @param command AssignTsToExcST6BCommand
   */
  @PutMapping("/assignTs")
  public void assignTs(@RequestBody AssignTsToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignTs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts", exc);
    }
  }

  /**
   * unassign Ts on ExcST6B
   *
   * @param command UnAssignTsFromExcST6BCommand
   */
  @PutMapping("/unAssignTs")
  public void unAssignTs(@RequestBody(required = true) UnAssignTsFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignTs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts", exc);
    }
  }

  /**
   * save Tvd on ExcST6B
   *
   * @param command AssignTvdToExcST6BCommand
   */
  @PutMapping("/assignTvd")
  public void assignTvd(@RequestBody AssignTvdToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignTvd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tvd", exc);
    }
  }

  /**
   * unassign Tvd on ExcST6B
   *
   * @param command UnAssignTvdFromExcST6BCommand
   */
  @PutMapping("/unAssignTvd")
  public void unAssignTvd(@RequestBody(required = true) UnAssignTvdFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignTvd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tvd", exc);
    }
  }

  /**
   * save Vamax on ExcST6B
   *
   * @param command AssignVamaxToExcST6BCommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcST6B
   *
   * @param command UnAssignVamaxFromExcST6BCommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(@RequestBody(required = true) UnAssignVamaxFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcST6B
   *
   * @param command AssignVaminToExcST6BCommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcST6B
   *
   * @param command UnAssignVaminFromExcST6BCommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(@RequestBody(required = true) UnAssignVaminFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Vilim on ExcST6B
   *
   * @param command AssignVilimToExcST6BCommand
   */
  @PutMapping("/assignVilim")
  public void assignVilim(@RequestBody AssignVilimToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignVilim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vilim", exc);
    }
  }

  /**
   * unassign Vilim on ExcST6B
   *
   * @param command UnAssignVilimFromExcST6BCommand
   */
  @PutMapping("/unAssignVilim")
  public void unAssignVilim(@RequestBody(required = true) UnAssignVilimFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignVilim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vilim", exc);
    }
  }

  /**
   * save Vimax on ExcST6B
   *
   * @param command AssignVimaxToExcST6BCommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcST6B
   *
   * @param command UnAssignVimaxFromExcST6BCommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(@RequestBody(required = true) UnAssignVimaxFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on ExcST6B
   *
   * @param command AssignViminToExcST6BCommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on ExcST6B
   *
   * @param command UnAssignViminFromExcST6BCommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(@RequestBody(required = true) UnAssignViminFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vmult on ExcST6B
   *
   * @param command AssignVmultToExcST6BCommand
   */
  @PutMapping("/assignVmult")
  public void assignVmult(@RequestBody AssignVmultToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignVmult(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmult", exc);
    }
  }

  /**
   * unassign Vmult on ExcST6B
   *
   * @param command UnAssignVmultFromExcST6BCommand
   */
  @PutMapping("/unAssignVmult")
  public void unAssignVmult(@RequestBody(required = true) UnAssignVmultFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignVmult(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmult", exc);
    }
  }

  /**
   * save Vrmax on ExcST6B
   *
   * @param command AssignVrmaxToExcST6BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcST6B
   *
   * @param command UnAssignVrmaxFromExcST6BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcST6B
   *
   * @param command AssignVrminToExcST6BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcST6B
   *
   * @param command UnAssignVrminFromExcST6BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Xc on ExcST6B
   *
   * @param command AssignXcToExcST6BCommand
   */
  @PutMapping("/assignXc")
  public void assignXc(@RequestBody AssignXcToExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().assignXc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xc", exc);
    }
  }

  /**
   * unassign Xc on ExcST6B
   *
   * @param command UnAssignXcFromExcST6BCommand
   */
  @PutMapping("/unAssignXc")
  public void unAssignXc(@RequestBody(required = true) UnAssignXcFromExcST6BCommand command) {
    try {
      ExcST6BBusinessDelegate.getExcST6BInstance().unAssignXc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xc", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcST6B excST6B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcST6BCommandRestController.class.getName());
}
