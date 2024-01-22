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
 * Implements Spring Controller command CQRS processing for entity ExcAC5A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC5A")
public class ExcAC5ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAC5A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAC5A excAC5A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAC5ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAC5ABusinessDelegate.getExcAC5AInstance().createExcAC5A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAC5A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAC5A excAC5A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAC5ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAC5ACommand
      // -----------------------------------------------
      completableFuture = ExcAC5ABusinessDelegate.getExcAC5AInstance().updateExcAC5A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAC5AController:update() - successfully update ExcAC5A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAC5A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAC5AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAC5ACommand command = new DeleteExcAC5ACommand(excAC5AId);

    try {
      ExcAC5ABusinessDelegate delegate = ExcAC5ABusinessDelegate.getExcAC5AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAC5A with key " + command.getExcAC5AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A on ExcAC5A
   *
   * @param command AssignAToExcAC5ACommand
   */
  @PutMapping("/assignA")
  public void assignA(@RequestBody AssignAToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignA(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A", exc);
    }
  }

  /**
   * unassign A on ExcAC5A
   *
   * @param command UnAssignAFromExcAC5ACommand
   */
  @PutMapping("/unAssignA")
  public void unAssignA(@RequestBody(required = true) UnAssignAFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignA(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A", exc);
    }
  }

  /**
   * save Efd1 on ExcAC5A
   *
   * @param command AssignEfd1ToExcAC5ACommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcAC5A
   *
   * @param command UnAssignEfd1FromExcAC5ACommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(@RequestBody(required = true) UnAssignEfd1FromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcAC5A
   *
   * @param command AssignEfd2ToExcAC5ACommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcAC5A
   *
   * @param command UnAssignEfd2FromExcAC5ACommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(@RequestBody(required = true) UnAssignEfd2FromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Ka on ExcAC5A
   *
   * @param command AssignKaToExcAC5ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAC5A
   *
   * @param command UnAssignKaFromExcAC5ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcAC5A
   *
   * @param command AssignKeToExcAC5ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcAC5A
   *
   * @param command UnAssignKeFromExcAC5ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcAC5A
   *
   * @param command AssignKfToExcAC5ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcAC5A
   *
   * @param command UnAssignKfFromExcAC5ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ks on ExcAC5A
   *
   * @param command AssignKsToExcAC5ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcAC5A
   *
   * @param command UnAssignKsFromExcAC5ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Seefd1 on ExcAC5A
   *
   * @param command AssignSeefd1ToExcAC5ACommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcAC5A
   *
   * @param command UnAssignSeefd1FromExcAC5ACommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcAC5A
   *
   * @param command AssignSeefd2ToExcAC5ACommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcAC5A
   *
   * @param command UnAssignSeefd2FromExcAC5ACommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Ta on ExcAC5A
   *
   * @param command AssignTaToExcAC5ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAC5A
   *
   * @param command UnAssignTaFromExcAC5ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcAC5A
   *
   * @param command AssignTbToExcAC5ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcAC5A
   *
   * @param command UnAssignTbFromExcAC5ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcAC5A
   *
   * @param command AssignTcToExcAC5ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcAC5A
   *
   * @param command UnAssignTcFromExcAC5ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcAC5A
   *
   * @param command AssignTeToExcAC5ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAC5A
   *
   * @param command UnAssignTeFromExcAC5ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf1 on ExcAC5A
   *
   * @param command AssignTf1ToExcAC5ACommand
   */
  @PutMapping("/assignTf1")
  public void assignTf1(@RequestBody AssignTf1ToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignTf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf1", exc);
    }
  }

  /**
   * unassign Tf1 on ExcAC5A
   *
   * @param command UnAssignTf1FromExcAC5ACommand
   */
  @PutMapping("/unAssignTf1")
  public void unAssignTf1(@RequestBody(required = true) UnAssignTf1FromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignTf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf1", exc);
    }
  }

  /**
   * save Tf2 on ExcAC5A
   *
   * @param command AssignTf2ToExcAC5ACommand
   */
  @PutMapping("/assignTf2")
  public void assignTf2(@RequestBody AssignTf2ToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignTf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf2", exc);
    }
  }

  /**
   * unassign Tf2 on ExcAC5A
   *
   * @param command UnAssignTf2FromExcAC5ACommand
   */
  @PutMapping("/unAssignTf2")
  public void unAssignTf2(@RequestBody(required = true) UnAssignTf2FromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignTf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf2", exc);
    }
  }

  /**
   * save Tf3 on ExcAC5A
   *
   * @param command AssignTf3ToExcAC5ACommand
   */
  @PutMapping("/assignTf3")
  public void assignTf3(@RequestBody AssignTf3ToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignTf3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf3", exc);
    }
  }

  /**
   * unassign Tf3 on ExcAC5A
   *
   * @param command UnAssignTf3FromExcAC5ACommand
   */
  @PutMapping("/unAssignTf3")
  public void unAssignTf3(@RequestBody(required = true) UnAssignTf3FromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignTf3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf3", exc);
    }
  }

  /**
   * save Vrmax on ExcAC5A
   *
   * @param command AssignVrmaxToExcAC5ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcAC5A
   *
   * @param command UnAssignVrmaxFromExcAC5ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcAC5A
   *
   * @param command AssignVrminToExcAC5ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcAC5A
   *
   * @param command UnAssignVrminFromExcAC5ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcAC5ACommand command) {
    try {
      ExcAC5ABusinessDelegate.getExcAC5AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAC5A excAC5A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAC5ACommandRestController.class.getName());
}
