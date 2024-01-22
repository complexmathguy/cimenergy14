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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC5A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC5A")
public class ExcIEEEAC5ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEAC5A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC5A excIEEEAC5A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEAC5ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().createExcIEEEAC5A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEAC5A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC5A excIEEEAC5A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEAC5ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEAC5ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().updateExcIEEEAC5A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEAC5AController:update() - successfully update ExcIEEEAC5A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEAC5A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEAC5AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEAC5ACommand command = new DeleteExcIEEEAC5ACommand(excIEEEAC5AId);

    try {
      ExcIEEEAC5ABusinessDelegate delegate = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEAC5A with key " + command.getExcIEEEAC5AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efd1 on ExcIEEEAC5A
   *
   * @param command AssignEfd1ToExcIEEEAC5ACommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcIEEEAC5A
   *
   * @param command UnAssignEfd1FromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(
      @RequestBody(required = true) UnAssignEfd1FromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcIEEEAC5A
   *
   * @param command AssignEfd2ToExcIEEEAC5ACommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcIEEEAC5A
   *
   * @param command UnAssignEfd2FromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(
      @RequestBody(required = true) UnAssignEfd2FromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Ka on ExcIEEEAC5A
   *
   * @param command AssignKaToExcIEEEAC5ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEAC5A
   *
   * @param command UnAssignKaFromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcIEEEAC5A
   *
   * @param command AssignKeToExcIEEEAC5ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEAC5A
   *
   * @param command UnAssignKeFromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcIEEEAC5A
   *
   * @param command AssignKfToExcIEEEAC5ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEAC5A
   *
   * @param command UnAssignKfFromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Seefd1 on ExcIEEEAC5A
   *
   * @param command AssignSeefd1ToExcIEEEAC5ACommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcIEEEAC5A
   *
   * @param command UnAssignSeefd1FromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcIEEEAC5A
   *
   * @param command AssignSeefd2ToExcIEEEAC5ACommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcIEEEAC5A
   *
   * @param command UnAssignSeefd2FromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEAC5A
   *
   * @param command AssignTaToExcIEEEAC5ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEAC5A
   *
   * @param command UnAssignTaFromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Te on ExcIEEEAC5A
   *
   * @param command AssignTeToExcIEEEAC5ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEAC5A
   *
   * @param command UnAssignTeFromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf1 on ExcIEEEAC5A
   *
   * @param command AssignTf1ToExcIEEEAC5ACommand
   */
  @PutMapping("/assignTf1")
  public void assignTf1(@RequestBody AssignTf1ToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignTf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf1", exc);
    }
  }

  /**
   * unassign Tf1 on ExcIEEEAC5A
   *
   * @param command UnAssignTf1FromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignTf1")
  public void unAssignTf1(@RequestBody(required = true) UnAssignTf1FromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignTf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf1", exc);
    }
  }

  /**
   * save Tf2 on ExcIEEEAC5A
   *
   * @param command AssignTf2ToExcIEEEAC5ACommand
   */
  @PutMapping("/assignTf2")
  public void assignTf2(@RequestBody AssignTf2ToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignTf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf2", exc);
    }
  }

  /**
   * unassign Tf2 on ExcIEEEAC5A
   *
   * @param command UnAssignTf2FromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignTf2")
  public void unAssignTf2(@RequestBody(required = true) UnAssignTf2FromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignTf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf2", exc);
    }
  }

  /**
   * save Tf3 on ExcIEEEAC5A
   *
   * @param command AssignTf3ToExcIEEEAC5ACommand
   */
  @PutMapping("/assignTf3")
  public void assignTf3(@RequestBody AssignTf3ToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignTf3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf3", exc);
    }
  }

  /**
   * unassign Tf3 on ExcIEEEAC5A
   *
   * @param command UnAssignTf3FromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignTf3")
  public void unAssignTf3(@RequestBody(required = true) UnAssignTf3FromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignTf3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf3", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEAC5A
   *
   * @param command AssignVrmaxToExcIEEEAC5ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEAC5A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEAC5A
   *
   * @param command AssignVrminToExcIEEEAC5ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEAC5A
   *
   * @param command UnAssignVrminFromExcIEEEAC5ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEAC5ACommand command) {
    try {
      ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEAC5A excIEEEAC5A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC5ACommandRestController.class.getName());
}
