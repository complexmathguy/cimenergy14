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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST5B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST5B")
public class ExcIEEEST5BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEST5B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST5B excIEEEST5B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEST5BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().createExcIEEEST5B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEST5B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST5B excIEEEST5B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEST5BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEST5BCommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().updateExcIEEEST5B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEST5BController:update() - successfully update ExcIEEEST5B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEST5B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEST5BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEST5BCommand command = new DeleteExcIEEEST5BCommand(excIEEEST5BId);

    try {
      ExcIEEEST5BBusinessDelegate delegate = ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEST5B with key " + command.getExcIEEEST5BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kc on ExcIEEEST5B
   *
   * @param command AssignKcToExcIEEEST5BCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEST5B
   *
   * @param command UnAssignKcFromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kr on ExcIEEEST5B
   *
   * @param command AssignKrToExcIEEEST5BCommand
   */
  @PutMapping("/assignKr")
  public void assignKr(@RequestBody AssignKrToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignKr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kr", exc);
    }
  }

  /**
   * unassign Kr on ExcIEEEST5B
   *
   * @param command UnAssignKrFromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignKr")
  public void unAssignKr(@RequestBody(required = true) UnAssignKrFromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignKr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kr", exc);
    }
  }

  /**
   * save T1 on ExcIEEEST5B
   *
   * @param command AssignT1ToExcIEEEST5BCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on ExcIEEEST5B
   *
   * @param command UnAssignT1FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save Tb1 on ExcIEEEST5B
   *
   * @param command AssignTb1ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTb1")
  public void assignTb1(@RequestBody AssignTb1ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb1", exc);
    }
  }

  /**
   * unassign Tb1 on ExcIEEEST5B
   *
   * @param command UnAssignTb1FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTb1")
  public void unAssignTb1(@RequestBody(required = true) UnAssignTb1FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb1", exc);
    }
  }

  /**
   * save Tb2 on ExcIEEEST5B
   *
   * @param command AssignTb2ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTb2")
  public void assignTb2(@RequestBody AssignTb2ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb2", exc);
    }
  }

  /**
   * unassign Tb2 on ExcIEEEST5B
   *
   * @param command UnAssignTb2FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTb2")
  public void unAssignTb2(@RequestBody(required = true) UnAssignTb2FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb2", exc);
    }
  }

  /**
   * save Tc1 on ExcIEEEST5B
   *
   * @param command AssignTc1ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTc1")
  public void assignTc1(@RequestBody AssignTc1ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTc1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc1", exc);
    }
  }

  /**
   * unassign Tc1 on ExcIEEEST5B
   *
   * @param command UnAssignTc1FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTc1")
  public void unAssignTc1(@RequestBody(required = true) UnAssignTc1FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTc1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc1", exc);
    }
  }

  /**
   * save Tc2 on ExcIEEEST5B
   *
   * @param command AssignTc2ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTc2")
  public void assignTc2(@RequestBody AssignTc2ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTc2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc2", exc);
    }
  }

  /**
   * unassign Tc2 on ExcIEEEST5B
   *
   * @param command UnAssignTc2FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTc2")
  public void unAssignTc2(@RequestBody(required = true) UnAssignTc2FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTc2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc2", exc);
    }
  }

  /**
   * save Tob1 on ExcIEEEST5B
   *
   * @param command AssignTob1ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTob1")
  public void assignTob1(@RequestBody AssignTob1ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTob1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tob1", exc);
    }
  }

  /**
   * unassign Tob1 on ExcIEEEST5B
   *
   * @param command UnAssignTob1FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTob1")
  public void unAssignTob1(
      @RequestBody(required = true) UnAssignTob1FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTob1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tob1", exc);
    }
  }

  /**
   * save Tob2 on ExcIEEEST5B
   *
   * @param command AssignTob2ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTob2")
  public void assignTob2(@RequestBody AssignTob2ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTob2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tob2", exc);
    }
  }

  /**
   * unassign Tob2 on ExcIEEEST5B
   *
   * @param command UnAssignTob2FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTob2")
  public void unAssignTob2(
      @RequestBody(required = true) UnAssignTob2FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTob2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tob2", exc);
    }
  }

  /**
   * save Toc1 on ExcIEEEST5B
   *
   * @param command AssignToc1ToExcIEEEST5BCommand
   */
  @PutMapping("/assignToc1")
  public void assignToc1(@RequestBody AssignToc1ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignToc1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Toc1", exc);
    }
  }

  /**
   * unassign Toc1 on ExcIEEEST5B
   *
   * @param command UnAssignToc1FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignToc1")
  public void unAssignToc1(
      @RequestBody(required = true) UnAssignToc1FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignToc1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Toc1", exc);
    }
  }

  /**
   * save Toc2 on ExcIEEEST5B
   *
   * @param command AssignToc2ToExcIEEEST5BCommand
   */
  @PutMapping("/assignToc2")
  public void assignToc2(@RequestBody AssignToc2ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignToc2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Toc2", exc);
    }
  }

  /**
   * unassign Toc2 on ExcIEEEST5B
   *
   * @param command UnAssignToc2FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignToc2")
  public void unAssignToc2(
      @RequestBody(required = true) UnAssignToc2FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignToc2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Toc2", exc);
    }
  }

  /**
   * save Tub1 on ExcIEEEST5B
   *
   * @param command AssignTub1ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTub1")
  public void assignTub1(@RequestBody AssignTub1ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTub1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tub1", exc);
    }
  }

  /**
   * unassign Tub1 on ExcIEEEST5B
   *
   * @param command UnAssignTub1FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTub1")
  public void unAssignTub1(
      @RequestBody(required = true) UnAssignTub1FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTub1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tub1", exc);
    }
  }

  /**
   * save Tub2 on ExcIEEEST5B
   *
   * @param command AssignTub2ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTub2")
  public void assignTub2(@RequestBody AssignTub2ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTub2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tub2", exc);
    }
  }

  /**
   * unassign Tub2 on ExcIEEEST5B
   *
   * @param command UnAssignTub2FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTub2")
  public void unAssignTub2(
      @RequestBody(required = true) UnAssignTub2FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTub2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tub2", exc);
    }
  }

  /**
   * save Tuc1 on ExcIEEEST5B
   *
   * @param command AssignTuc1ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTuc1")
  public void assignTuc1(@RequestBody AssignTuc1ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTuc1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tuc1", exc);
    }
  }

  /**
   * unassign Tuc1 on ExcIEEEST5B
   *
   * @param command UnAssignTuc1FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTuc1")
  public void unAssignTuc1(
      @RequestBody(required = true) UnAssignTuc1FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTuc1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tuc1", exc);
    }
  }

  /**
   * save Tuc2 on ExcIEEEST5B
   *
   * @param command AssignTuc2ToExcIEEEST5BCommand
   */
  @PutMapping("/assignTuc2")
  public void assignTuc2(@RequestBody AssignTuc2ToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignTuc2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tuc2", exc);
    }
  }

  /**
   * unassign Tuc2 on ExcIEEEST5B
   *
   * @param command UnAssignTuc2FromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignTuc2")
  public void unAssignTuc2(
      @RequestBody(required = true) UnAssignTuc2FromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignTuc2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tuc2", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEST5B
   *
   * @param command AssignVrmaxToExcIEEEST5BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEST5B
   *
   * @param command UnAssignVrmaxFromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEST5B
   *
   * @param command AssignVrminToExcIEEEST5BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEST5B
   *
   * @param command UnAssignVrminFromExcIEEEST5BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEST5BCommand command) {
    try {
      ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEST5B excIEEEST5B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEST5BCommandRestController.class.getName());
}
