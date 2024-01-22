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
 * Implements Spring Controller command CQRS processing for entity ExcAC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC3A")
public class ExcAC3ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAC3A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAC3A excAC3A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAC3ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAC3ABusinessDelegate.getExcAC3AInstance().createExcAC3A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAC3A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAC3A excAC3A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAC3ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAC3ACommand
      // -----------------------------------------------
      completableFuture = ExcAC3ABusinessDelegate.getExcAC3AInstance().updateExcAC3A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAC3AController:update() - successfully update ExcAC3A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAC3A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAC3AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAC3ACommand command = new DeleteExcAC3ACommand(excAC3AId);

    try {
      ExcAC3ABusinessDelegate delegate = ExcAC3ABusinessDelegate.getExcAC3AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAC3A with key " + command.getExcAC3AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdn on ExcAC3A
   *
   * @param command AssignEfdnToExcAC3ACommand
   */
  @PutMapping("/assignEfdn")
  public void assignEfdn(@RequestBody AssignEfdnToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignEfdn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdn", exc);
    }
  }

  /**
   * unassign Efdn on ExcAC3A
   *
   * @param command UnAssignEfdnFromExcAC3ACommand
   */
  @PutMapping("/unAssignEfdn")
  public void unAssignEfdn(@RequestBody(required = true) UnAssignEfdnFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignEfdn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdn", exc);
    }
  }

  /**
   * save Ka on ExcAC3A
   *
   * @param command AssignKaToExcAC3ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAC3A
   *
   * @param command UnAssignKaFromExcAC3ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcAC3A
   *
   * @param command AssignKcToExcAC3ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcAC3A
   *
   * @param command UnAssignKcFromExcAC3ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcAC3A
   *
   * @param command AssignKdToExcAC3ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcAC3A
   *
   * @param command UnAssignKdFromExcAC3ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcAC3A
   *
   * @param command AssignKeToExcAC3ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcAC3A
   *
   * @param command UnAssignKeFromExcAC3ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcAC3A
   *
   * @param command AssignKfToExcAC3ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcAC3A
   *
   * @param command UnAssignKfFromExcAC3ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Kf1 on ExcAC3A
   *
   * @param command AssignKf1ToExcAC3ACommand
   */
  @PutMapping("/assignKf1")
  public void assignKf1(@RequestBody AssignKf1ToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf1", exc);
    }
  }

  /**
   * unassign Kf1 on ExcAC3A
   *
   * @param command UnAssignKf1FromExcAC3ACommand
   */
  @PutMapping("/unAssignKf1")
  public void unAssignKf1(@RequestBody(required = true) UnAssignKf1FromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf1", exc);
    }
  }

  /**
   * save Kf2 on ExcAC3A
   *
   * @param command AssignKf2ToExcAC3ACommand
   */
  @PutMapping("/assignKf2")
  public void assignKf2(@RequestBody AssignKf2ToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf2", exc);
    }
  }

  /**
   * unassign Kf2 on ExcAC3A
   *
   * @param command UnAssignKf2FromExcAC3ACommand
   */
  @PutMapping("/unAssignKf2")
  public void unAssignKf2(@RequestBody(required = true) UnAssignKf2FromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf2", exc);
    }
  }

  /**
   * save Klv on ExcAC3A
   *
   * @param command AssignKlvToExcAC3ACommand
   */
  @PutMapping("/assignKlv")
  public void assignKlv(@RequestBody AssignKlvToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKlv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Klv", exc);
    }
  }

  /**
   * unassign Klv on ExcAC3A
   *
   * @param command UnAssignKlvFromExcAC3ACommand
   */
  @PutMapping("/unAssignKlv")
  public void unAssignKlv(@RequestBody(required = true) UnAssignKlvFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKlv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Klv", exc);
    }
  }

  /**
   * save Kn on ExcAC3A
   *
   * @param command AssignKnToExcAC3ACommand
   */
  @PutMapping("/assignKn")
  public void assignKn(@RequestBody AssignKnToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kn", exc);
    }
  }

  /**
   * unassign Kn on ExcAC3A
   *
   * @param command UnAssignKnFromExcAC3ACommand
   */
  @PutMapping("/unAssignKn")
  public void unAssignKn(@RequestBody(required = true) UnAssignKnFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kn", exc);
    }
  }

  /**
   * save Kr on ExcAC3A
   *
   * @param command AssignKrToExcAC3ACommand
   */
  @PutMapping("/assignKr")
  public void assignKr(@RequestBody AssignKrToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kr", exc);
    }
  }

  /**
   * unassign Kr on ExcAC3A
   *
   * @param command UnAssignKrFromExcAC3ACommand
   */
  @PutMapping("/unAssignKr")
  public void unAssignKr(@RequestBody(required = true) UnAssignKrFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kr", exc);
    }
  }

  /**
   * save Ks on ExcAC3A
   *
   * @param command AssignKsToExcAC3ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcAC3A
   *
   * @param command UnAssignKsFromExcAC3ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Seve1 on ExcAC3A
   *
   * @param command AssignSeve1ToExcAC3ACommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcAC3A
   *
   * @param command UnAssignSeve1FromExcAC3ACommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(@RequestBody(required = true) UnAssignSeve1FromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcAC3A
   *
   * @param command AssignSeve2ToExcAC3ACommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcAC3A
   *
   * @param command UnAssignSeve2FromExcAC3ACommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(@RequestBody(required = true) UnAssignSeve2FromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcAC3A
   *
   * @param command AssignTaToExcAC3ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAC3A
   *
   * @param command UnAssignTaFromExcAC3ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcAC3A
   *
   * @param command AssignTbToExcAC3ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcAC3A
   *
   * @param command UnAssignTbFromExcAC3ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcAC3A
   *
   * @param command AssignTcToExcAC3ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcAC3A
   *
   * @param command UnAssignTcFromExcAC3ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcAC3A
   *
   * @param command AssignTeToExcAC3ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAC3A
   *
   * @param command UnAssignTeFromExcAC3ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcAC3A
   *
   * @param command AssignTfToExcAC3ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcAC3A
   *
   * @param command UnAssignTfFromExcAC3ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcAC3A
   *
   * @param command AssignVamaxToExcAC3ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcAC3A
   *
   * @param command UnAssignVamaxFromExcAC3ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(@RequestBody(required = true) UnAssignVamaxFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcAC3A
   *
   * @param command AssignVaminToExcAC3ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcAC3A
   *
   * @param command UnAssignVaminFromExcAC3ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(@RequestBody(required = true) UnAssignVaminFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcAC3A
   *
   * @param command AssignVe1ToExcAC3ACommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcAC3A
   *
   * @param command UnAssignVe1FromExcAC3ACommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcAC3A
   *
   * @param command AssignVe2ToExcAC3ACommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcAC3A
   *
   * @param command UnAssignVe2FromExcAC3ACommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vemin on ExcAC3A
   *
   * @param command AssignVeminToExcAC3ACommand
   */
  @PutMapping("/assignVemin")
  public void assignVemin(@RequestBody AssignVeminToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignVemin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vemin", exc);
    }
  }

  /**
   * unassign Vemin on ExcAC3A
   *
   * @param command UnAssignVeminFromExcAC3ACommand
   */
  @PutMapping("/unAssignVemin")
  public void unAssignVemin(@RequestBody(required = true) UnAssignVeminFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignVemin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vemin", exc);
    }
  }

  /**
   * save Vfemax on ExcAC3A
   *
   * @param command AssignVfemaxToExcAC3ACommand
   */
  @PutMapping("/assignVfemax")
  public void assignVfemax(@RequestBody AssignVfemaxToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignVfemax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfemax", exc);
    }
  }

  /**
   * unassign Vfemax on ExcAC3A
   *
   * @param command UnAssignVfemaxFromExcAC3ACommand
   */
  @PutMapping("/unAssignVfemax")
  public void unAssignVfemax(
      @RequestBody(required = true) UnAssignVfemaxFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignVfemax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfemax", exc);
    }
  }

  /**
   * save Vlv on ExcAC3A
   *
   * @param command AssignVlvToExcAC3ACommand
   */
  @PutMapping("/assignVlv")
  public void assignVlv(@RequestBody AssignVlvToExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().assignVlv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vlv", exc);
    }
  }

  /**
   * unassign Vlv on ExcAC3A
   *
   * @param command UnAssignVlvFromExcAC3ACommand
   */
  @PutMapping("/unAssignVlv")
  public void unAssignVlv(@RequestBody(required = true) UnAssignVlvFromExcAC3ACommand command) {
    try {
      ExcAC3ABusinessDelegate.getExcAC3AInstance().unAssignVlv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vlv", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAC3A excAC3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAC3ACommandRestController.class.getName());
}
