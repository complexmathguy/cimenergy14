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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEDC4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC4B")
public class ExcIEEEDC4BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEDC4B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEDC4B excIEEEDC4B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEDC4BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().createExcIEEEDC4B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEDC4B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEDC4B excIEEEDC4B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEDC4BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEDC4BCommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().updateExcIEEEDC4B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEDC4BController:update() - successfully update ExcIEEEDC4B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEDC4B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEDC4BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEDC4BCommand command = new DeleteExcIEEEDC4BCommand(excIEEEDC4BId);

    try {
      ExcIEEEDC4BBusinessDelegate delegate = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEDC4B with key " + command.getExcIEEEDC4BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efd1 on ExcIEEEDC4B
   *
   * @param command AssignEfd1ToExcIEEEDC4BCommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcIEEEDC4B
   *
   * @param command UnAssignEfd1FromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(
      @RequestBody(required = true) UnAssignEfd1FromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcIEEEDC4B
   *
   * @param command AssignEfd2ToExcIEEEDC4BCommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcIEEEDC4B
   *
   * @param command UnAssignEfd2FromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(
      @RequestBody(required = true) UnAssignEfd2FromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Ka on ExcIEEEDC4B
   *
   * @param command AssignKaToExcIEEEDC4BCommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEDC4B
   *
   * @param command UnAssignKaFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kd on ExcIEEEDC4B
   *
   * @param command AssignKdToExcIEEEDC4BCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcIEEEDC4B
   *
   * @param command UnAssignKdFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcIEEEDC4B
   *
   * @param command AssignKeToExcIEEEDC4BCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEDC4B
   *
   * @param command UnAssignKeFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcIEEEDC4B
   *
   * @param command AssignKfToExcIEEEDC4BCommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEDC4B
   *
   * @param command UnAssignKfFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ki on ExcIEEEDC4B
   *
   * @param command AssignKiToExcIEEEDC4BCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcIEEEDC4B
   *
   * @param command UnAssignKiFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on ExcIEEEDC4B
   *
   * @param command AssignKpToExcIEEEDC4BCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcIEEEDC4B
   *
   * @param command UnAssignKpFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Oelin on ExcIEEEDC4B
   *
   * @param command AssignOelinToExcIEEEDC4BCommand
   */
  @PutMapping("/assignOelin")
  public void assignOelin(@RequestBody AssignOelinToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignOelin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Oelin", exc);
    }
  }

  /**
   * unassign Oelin on ExcIEEEDC4B
   *
   * @param command UnAssignOelinFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignOelin")
  public void unAssignOelin(
      @RequestBody(required = true) UnAssignOelinFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignOelin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Oelin", exc);
    }
  }

  /**
   * save Seefd1 on ExcIEEEDC4B
   *
   * @param command AssignSeefd1ToExcIEEEDC4BCommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcIEEEDC4B
   *
   * @param command UnAssignSeefd1FromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcIEEEDC4B
   *
   * @param command AssignSeefd2ToExcIEEEDC4BCommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcIEEEDC4B
   *
   * @param command UnAssignSeefd2FromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEDC4B
   *
   * @param command AssignTaToExcIEEEDC4BCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEDC4B
   *
   * @param command UnAssignTaFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Td on ExcIEEEDC4B
   *
   * @param command AssignTdToExcIEEEDC4BCommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on ExcIEEEDC4B
   *
   * @param command UnAssignTdFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Te on ExcIEEEDC4B
   *
   * @param command AssignTeToExcIEEEDC4BCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEDC4B
   *
   * @param command UnAssignTeFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcIEEEDC4B
   *
   * @param command AssignTfToExcIEEEDC4BCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEDC4B
   *
   * @param command UnAssignTfFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Uelin on ExcIEEEDC4B
   *
   * @param command AssignUelinToExcIEEEDC4BCommand
   */
  @PutMapping("/assignUelin")
  public void assignUelin(@RequestBody AssignUelinToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignUelin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uelin", exc);
    }
  }

  /**
   * unassign Uelin on ExcIEEEDC4B
   *
   * @param command UnAssignUelinFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignUelin")
  public void unAssignUelin(
      @RequestBody(required = true) UnAssignUelinFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignUelin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uelin", exc);
    }
  }

  /**
   * save Vemin on ExcIEEEDC4B
   *
   * @param command AssignVeminToExcIEEEDC4BCommand
   */
  @PutMapping("/assignVemin")
  public void assignVemin(@RequestBody AssignVeminToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignVemin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vemin", exc);
    }
  }

  /**
   * unassign Vemin on ExcIEEEDC4B
   *
   * @param command UnAssignVeminFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignVemin")
  public void unAssignVemin(
      @RequestBody(required = true) UnAssignVeminFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignVemin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vemin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEDC4B
   *
   * @param command AssignVrmaxToExcIEEEDC4BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEDC4B
   *
   * @param command UnAssignVrmaxFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEDC4B
   *
   * @param command AssignVrminToExcIEEEDC4BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEDC4B
   *
   * @param command UnAssignVrminFromExcIEEEDC4BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEDC4BCommand command) {
    try {
      ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEDC4B excIEEEDC4B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEDC4BCommandRestController.class.getName());
}
