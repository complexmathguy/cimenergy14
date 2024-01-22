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
 * Implements Spring Controller command CQRS processing for entity ExcREXS.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcREXS")
public class ExcREXSCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcREXS. if not key provided, calls create, otherwise calls save
   *
   * @param ExcREXS excREXS
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcREXSCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcREXSBusinessDelegate.getExcREXSInstance().createExcREXS(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcREXS. if no key provided, calls create, otherwise calls save
   *
   * @param ExcREXS excREXS
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcREXSCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcREXSCommand
      // -----------------------------------------------
      completableFuture = ExcREXSBusinessDelegate.getExcREXSInstance().updateExcREXS(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcREXSController:update() - successfully update ExcREXS - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcREXS entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excREXSId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcREXSCommand command = new DeleteExcREXSCommand(excREXSId);

    try {
      ExcREXSBusinessDelegate delegate = ExcREXSBusinessDelegate.getExcREXSInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcREXS with key " + command.getExcREXSId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save E1 on ExcREXS
   *
   * @param command AssignE1ToExcREXSCommand
   */
  @PutMapping("/assignE1")
  public void assignE1(@RequestBody AssignE1ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignE1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E1", exc);
    }
  }

  /**
   * unassign E1 on ExcREXS
   *
   * @param command UnAssignE1FromExcREXSCommand
   */
  @PutMapping("/unAssignE1")
  public void unAssignE1(@RequestBody(required = true) UnAssignE1FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignE1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E1", exc);
    }
  }

  /**
   * save E2 on ExcREXS
   *
   * @param command AssignE2ToExcREXSCommand
   */
  @PutMapping("/assignE2")
  public void assignE2(@RequestBody AssignE2ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignE2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E2", exc);
    }
  }

  /**
   * unassign E2 on ExcREXS
   *
   * @param command UnAssignE2FromExcREXSCommand
   */
  @PutMapping("/unAssignE2")
  public void unAssignE2(@RequestBody(required = true) UnAssignE2FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignE2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E2", exc);
    }
  }

  /**
   * save Flimf on ExcREXS
   *
   * @param command AssignFlimfToExcREXSCommand
   */
  @PutMapping("/assignFlimf")
  public void assignFlimf(@RequestBody AssignFlimfToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignFlimf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flimf", exc);
    }
  }

  /**
   * unassign Flimf on ExcREXS
   *
   * @param command UnAssignFlimfFromExcREXSCommand
   */
  @PutMapping("/unAssignFlimf")
  public void unAssignFlimf(@RequestBody(required = true) UnAssignFlimfFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignFlimf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flimf", exc);
    }
  }

  /**
   * save Kc on ExcREXS
   *
   * @param command AssignKcToExcREXSCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcREXS
   *
   * @param command UnAssignKcFromExcREXSCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcREXS
   *
   * @param command AssignKdToExcREXSCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcREXS
   *
   * @param command UnAssignKdFromExcREXSCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcREXS
   *
   * @param command AssignKeToExcREXSCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcREXS
   *
   * @param command UnAssignKeFromExcREXSCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kefd on ExcREXS
   *
   * @param command AssignKefdToExcREXSCommand
   */
  @PutMapping("/assignKefd")
  public void assignKefd(@RequestBody AssignKefdToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKefd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kefd", exc);
    }
  }

  /**
   * unassign Kefd on ExcREXS
   *
   * @param command UnAssignKefdFromExcREXSCommand
   */
  @PutMapping("/unAssignKefd")
  public void unAssignKefd(@RequestBody(required = true) UnAssignKefdFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKefd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kefd", exc);
    }
  }

  /**
   * save Kf on ExcREXS
   *
   * @param command AssignKfToExcREXSCommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcREXS
   *
   * @param command UnAssignKfFromExcREXSCommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Kh on ExcREXS
   *
   * @param command AssignKhToExcREXSCommand
   */
  @PutMapping("/assignKh")
  public void assignKh(@RequestBody AssignKhToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh", exc);
    }
  }

  /**
   * unassign Kh on ExcREXS
   *
   * @param command UnAssignKhFromExcREXSCommand
   */
  @PutMapping("/unAssignKh")
  public void unAssignKh(@RequestBody(required = true) UnAssignKhFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh", exc);
    }
  }

  /**
   * save Kii on ExcREXS
   *
   * @param command AssignKiiToExcREXSCommand
   */
  @PutMapping("/assignKii")
  public void assignKii(@RequestBody AssignKiiToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKii(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kii", exc);
    }
  }

  /**
   * unassign Kii on ExcREXS
   *
   * @param command UnAssignKiiFromExcREXSCommand
   */
  @PutMapping("/unAssignKii")
  public void unAssignKii(@RequestBody(required = true) UnAssignKiiFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKii(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kii", exc);
    }
  }

  /**
   * save Kip on ExcREXS
   *
   * @param command AssignKipToExcREXSCommand
   */
  @PutMapping("/assignKip")
  public void assignKip(@RequestBody AssignKipToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kip", exc);
    }
  }

  /**
   * unassign Kip on ExcREXS
   *
   * @param command UnAssignKipFromExcREXSCommand
   */
  @PutMapping("/unAssignKip")
  public void unAssignKip(@RequestBody(required = true) UnAssignKipFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kip", exc);
    }
  }

  /**
   * save Ks on ExcREXS
   *
   * @param command AssignKsToExcREXSCommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcREXS
   *
   * @param command UnAssignKsFromExcREXSCommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Kvi on ExcREXS
   *
   * @param command AssignKviToExcREXSCommand
   */
  @PutMapping("/assignKvi")
  public void assignKvi(@RequestBody AssignKviToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKvi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kvi", exc);
    }
  }

  /**
   * unassign Kvi on ExcREXS
   *
   * @param command UnAssignKviFromExcREXSCommand
   */
  @PutMapping("/unAssignKvi")
  public void unAssignKvi(@RequestBody(required = true) UnAssignKviFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKvi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kvi", exc);
    }
  }

  /**
   * save Kvp on ExcREXS
   *
   * @param command AssignKvpToExcREXSCommand
   */
  @PutMapping("/assignKvp")
  public void assignKvp(@RequestBody AssignKvpToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKvp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kvp", exc);
    }
  }

  /**
   * unassign Kvp on ExcREXS
   *
   * @param command UnAssignKvpFromExcREXSCommand
   */
  @PutMapping("/unAssignKvp")
  public void unAssignKvp(@RequestBody(required = true) UnAssignKvpFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKvp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kvp", exc);
    }
  }

  /**
   * save Kvphz on ExcREXS
   *
   * @param command AssignKvphzToExcREXSCommand
   */
  @PutMapping("/assignKvphz")
  public void assignKvphz(@RequestBody AssignKvphzToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignKvphz(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kvphz", exc);
    }
  }

  /**
   * unassign Kvphz on ExcREXS
   *
   * @param command UnAssignKvphzFromExcREXSCommand
   */
  @PutMapping("/unAssignKvphz")
  public void unAssignKvphz(@RequestBody(required = true) UnAssignKvphzFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignKvphz(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kvphz", exc);
    }
  }

  /**
   * save Nvphz on ExcREXS
   *
   * @param command AssignNvphzToExcREXSCommand
   */
  @PutMapping("/assignNvphz")
  public void assignNvphz(@RequestBody AssignNvphzToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignNvphz(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Nvphz", exc);
    }
  }

  /**
   * unassign Nvphz on ExcREXS
   *
   * @param command UnAssignNvphzFromExcREXSCommand
   */
  @PutMapping("/unAssignNvphz")
  public void unAssignNvphz(@RequestBody(required = true) UnAssignNvphzFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignNvphz(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Nvphz", exc);
    }
  }

  /**
   * save Se1 on ExcREXS
   *
   * @param command AssignSe1ToExcREXSCommand
   */
  @PutMapping("/assignSe1")
  public void assignSe1(@RequestBody AssignSe1ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignSe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se1", exc);
    }
  }

  /**
   * unassign Se1 on ExcREXS
   *
   * @param command UnAssignSe1FromExcREXSCommand
   */
  @PutMapping("/unAssignSe1")
  public void unAssignSe1(@RequestBody(required = true) UnAssignSe1FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignSe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se1", exc);
    }
  }

  /**
   * save Se2 on ExcREXS
   *
   * @param command AssignSe2ToExcREXSCommand
   */
  @PutMapping("/assignSe2")
  public void assignSe2(@RequestBody AssignSe2ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignSe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se2", exc);
    }
  }

  /**
   * unassign Se2 on ExcREXS
   *
   * @param command UnAssignSe2FromExcREXSCommand
   */
  @PutMapping("/unAssignSe2")
  public void unAssignSe2(@RequestBody(required = true) UnAssignSe2FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignSe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se2", exc);
    }
  }

  /**
   * save Ta on ExcREXS
   *
   * @param command AssignTaToExcREXSCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcREXS
   *
   * @param command UnAssignTaFromExcREXSCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb1 on ExcREXS
   *
   * @param command AssignTb1ToExcREXSCommand
   */
  @PutMapping("/assignTb1")
  public void assignTb1(@RequestBody AssignTb1ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb1", exc);
    }
  }

  /**
   * unassign Tb1 on ExcREXS
   *
   * @param command UnAssignTb1FromExcREXSCommand
   */
  @PutMapping("/unAssignTb1")
  public void unAssignTb1(@RequestBody(required = true) UnAssignTb1FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb1", exc);
    }
  }

  /**
   * save Tb2 on ExcREXS
   *
   * @param command AssignTb2ToExcREXSCommand
   */
  @PutMapping("/assignTb2")
  public void assignTb2(@RequestBody AssignTb2ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb2", exc);
    }
  }

  /**
   * unassign Tb2 on ExcREXS
   *
   * @param command UnAssignTb2FromExcREXSCommand
   */
  @PutMapping("/unAssignTb2")
  public void unAssignTb2(@RequestBody(required = true) UnAssignTb2FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb2", exc);
    }
  }

  /**
   * save Tc1 on ExcREXS
   *
   * @param command AssignTc1ToExcREXSCommand
   */
  @PutMapping("/assignTc1")
  public void assignTc1(@RequestBody AssignTc1ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTc1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc1", exc);
    }
  }

  /**
   * unassign Tc1 on ExcREXS
   *
   * @param command UnAssignTc1FromExcREXSCommand
   */
  @PutMapping("/unAssignTc1")
  public void unAssignTc1(@RequestBody(required = true) UnAssignTc1FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTc1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc1", exc);
    }
  }

  /**
   * save Tc2 on ExcREXS
   *
   * @param command AssignTc2ToExcREXSCommand
   */
  @PutMapping("/assignTc2")
  public void assignTc2(@RequestBody AssignTc2ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTc2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc2", exc);
    }
  }

  /**
   * unassign Tc2 on ExcREXS
   *
   * @param command UnAssignTc2FromExcREXSCommand
   */
  @PutMapping("/unAssignTc2")
  public void unAssignTc2(@RequestBody(required = true) UnAssignTc2FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTc2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc2", exc);
    }
  }

  /**
   * save Te on ExcREXS
   *
   * @param command AssignTeToExcREXSCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcREXS
   *
   * @param command UnAssignTeFromExcREXSCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcREXS
   *
   * @param command AssignTfToExcREXSCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcREXS
   *
   * @param command UnAssignTfFromExcREXSCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tf1 on ExcREXS
   *
   * @param command AssignTf1ToExcREXSCommand
   */
  @PutMapping("/assignTf1")
  public void assignTf1(@RequestBody AssignTf1ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf1", exc);
    }
  }

  /**
   * unassign Tf1 on ExcREXS
   *
   * @param command UnAssignTf1FromExcREXSCommand
   */
  @PutMapping("/unAssignTf1")
  public void unAssignTf1(@RequestBody(required = true) UnAssignTf1FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf1", exc);
    }
  }

  /**
   * save Tf2 on ExcREXS
   *
   * @param command AssignTf2ToExcREXSCommand
   */
  @PutMapping("/assignTf2")
  public void assignTf2(@RequestBody AssignTf2ToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf2", exc);
    }
  }

  /**
   * unassign Tf2 on ExcREXS
   *
   * @param command UnAssignTf2FromExcREXSCommand
   */
  @PutMapping("/unAssignTf2")
  public void unAssignTf2(@RequestBody(required = true) UnAssignTf2FromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf2", exc);
    }
  }

  /**
   * save Tp on ExcREXS
   *
   * @param command AssignTpToExcREXSCommand
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on ExcREXS
   *
   * @param command UnAssignTpFromExcREXSCommand
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Vcmax on ExcREXS
   *
   * @param command AssignVcmaxToExcREXSCommand
   */
  @PutMapping("/assignVcmax")
  public void assignVcmax(@RequestBody AssignVcmaxToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignVcmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vcmax", exc);
    }
  }

  /**
   * unassign Vcmax on ExcREXS
   *
   * @param command UnAssignVcmaxFromExcREXSCommand
   */
  @PutMapping("/unAssignVcmax")
  public void unAssignVcmax(@RequestBody(required = true) UnAssignVcmaxFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignVcmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vcmax", exc);
    }
  }

  /**
   * save Vfmax on ExcREXS
   *
   * @param command AssignVfmaxToExcREXSCommand
   */
  @PutMapping("/assignVfmax")
  public void assignVfmax(@RequestBody AssignVfmaxToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignVfmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfmax", exc);
    }
  }

  /**
   * unassign Vfmax on ExcREXS
   *
   * @param command UnAssignVfmaxFromExcREXSCommand
   */
  @PutMapping("/unAssignVfmax")
  public void unAssignVfmax(@RequestBody(required = true) UnAssignVfmaxFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignVfmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfmax", exc);
    }
  }

  /**
   * save Vfmin on ExcREXS
   *
   * @param command AssignVfminToExcREXSCommand
   */
  @PutMapping("/assignVfmin")
  public void assignVfmin(@RequestBody AssignVfminToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignVfmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfmin", exc);
    }
  }

  /**
   * unassign Vfmin on ExcREXS
   *
   * @param command UnAssignVfminFromExcREXSCommand
   */
  @PutMapping("/unAssignVfmin")
  public void unAssignVfmin(@RequestBody(required = true) UnAssignVfminFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignVfmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfmin", exc);
    }
  }

  /**
   * save Vimax on ExcREXS
   *
   * @param command AssignVimaxToExcREXSCommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcREXS
   *
   * @param command UnAssignVimaxFromExcREXSCommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(@RequestBody(required = true) UnAssignVimaxFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vrmax on ExcREXS
   *
   * @param command AssignVrmaxToExcREXSCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcREXS
   *
   * @param command UnAssignVrmaxFromExcREXSCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcREXS
   *
   * @param command AssignVrminToExcREXSCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcREXS
   *
   * @param command UnAssignVrminFromExcREXSCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Xc on ExcREXS
   *
   * @param command AssignXcToExcREXSCommand
   */
  @PutMapping("/assignXc")
  public void assignXc(@RequestBody AssignXcToExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().assignXc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xc", exc);
    }
  }

  /**
   * unassign Xc on ExcREXS
   *
   * @param command UnAssignXcFromExcREXSCommand
   */
  @PutMapping("/unAssignXc")
  public void unAssignXc(@RequestBody(required = true) UnAssignXcFromExcREXSCommand command) {
    try {
      ExcREXSBusinessDelegate.getExcREXSInstance().unAssignXc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xc", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcREXS excREXS = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcREXSCommandRestController.class.getName());
}
