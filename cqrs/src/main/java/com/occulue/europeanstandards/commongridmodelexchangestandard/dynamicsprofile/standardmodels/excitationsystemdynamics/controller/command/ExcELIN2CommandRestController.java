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
 * Implements Spring Controller command CQRS processing for entity ExcELIN2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcELIN2")
public class ExcELIN2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcELIN2. if not key provided, calls create, otherwise calls save
   *
   * @param ExcELIN2 excELIN2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcELIN2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcELIN2BusinessDelegate.getExcELIN2Instance().createExcELIN2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcELIN2. if no key provided, calls create, otherwise calls save
   *
   * @param ExcELIN2 excELIN2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcELIN2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcELIN2Command
      // -----------------------------------------------
      completableFuture = ExcELIN2BusinessDelegate.getExcELIN2Instance().updateExcELIN2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcELIN2Controller:update() - successfully update ExcELIN2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcELIN2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excELIN2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcELIN2Command command = new DeleteExcELIN2Command(excELIN2Id);

    try {
      ExcELIN2BusinessDelegate delegate = ExcELIN2BusinessDelegate.getExcELIN2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcELIN2 with key " + command.getExcELIN2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdbas on ExcELIN2
   *
   * @param command AssignEfdbasToExcELIN2Command
   */
  @PutMapping("/assignEfdbas")
  public void assignEfdbas(@RequestBody AssignEfdbasToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignEfdbas(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdbas", exc);
    }
  }

  /**
   * unassign Efdbas on ExcELIN2
   *
   * @param command UnAssignEfdbasFromExcELIN2Command
   */
  @PutMapping("/unAssignEfdbas")
  public void unAssignEfdbas(
      @RequestBody(required = true) UnAssignEfdbasFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignEfdbas(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdbas", exc);
    }
  }

  /**
   * save Iefmax on ExcELIN2
   *
   * @param command AssignIefmaxToExcELIN2Command
   */
  @PutMapping("/assignIefmax")
  public void assignIefmax(@RequestBody AssignIefmaxToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignIefmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Iefmax", exc);
    }
  }

  /**
   * unassign Iefmax on ExcELIN2
   *
   * @param command UnAssignIefmaxFromExcELIN2Command
   */
  @PutMapping("/unAssignIefmax")
  public void unAssignIefmax(
      @RequestBody(required = true) UnAssignIefmaxFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignIefmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Iefmax", exc);
    }
  }

  /**
   * save Iefmax2 on ExcELIN2
   *
   * @param command AssignIefmax2ToExcELIN2Command
   */
  @PutMapping("/assignIefmax2")
  public void assignIefmax2(@RequestBody AssignIefmax2ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignIefmax2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Iefmax2", exc);
    }
  }

  /**
   * unassign Iefmax2 on ExcELIN2
   *
   * @param command UnAssignIefmax2FromExcELIN2Command
   */
  @PutMapping("/unAssignIefmax2")
  public void unAssignIefmax2(
      @RequestBody(required = true) UnAssignIefmax2FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignIefmax2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Iefmax2", exc);
    }
  }

  /**
   * save Iefmin on ExcELIN2
   *
   * @param command AssignIefminToExcELIN2Command
   */
  @PutMapping("/assignIefmin")
  public void assignIefmin(@RequestBody AssignIefminToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignIefmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Iefmin", exc);
    }
  }

  /**
   * unassign Iefmin on ExcELIN2
   *
   * @param command UnAssignIefminFromExcELIN2Command
   */
  @PutMapping("/unAssignIefmin")
  public void unAssignIefmin(
      @RequestBody(required = true) UnAssignIefminFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignIefmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Iefmin", exc);
    }
  }

  /**
   * save K1 on ExcELIN2
   *
   * @param command AssignK1ToExcELIN2Command
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on ExcELIN2
   *
   * @param command UnAssignK1FromExcELIN2Command
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K1ec on ExcELIN2
   *
   * @param command AssignK1ecToExcELIN2Command
   */
  @PutMapping("/assignK1ec")
  public void assignK1ec(@RequestBody AssignK1ecToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignK1ec(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1ec", exc);
    }
  }

  /**
   * unassign K1ec on ExcELIN2
   *
   * @param command UnAssignK1ecFromExcELIN2Command
   */
  @PutMapping("/unAssignK1ec")
  public void unAssignK1ec(@RequestBody(required = true) UnAssignK1ecFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignK1ec(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1ec", exc);
    }
  }

  /**
   * save K2 on ExcELIN2
   *
   * @param command AssignK2ToExcELIN2Command
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on ExcELIN2
   *
   * @param command UnAssignK2FromExcELIN2Command
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save K3 on ExcELIN2
   *
   * @param command AssignK3ToExcELIN2Command
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on ExcELIN2
   *
   * @param command UnAssignK3FromExcELIN2Command
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save K4 on ExcELIN2
   *
   * @param command AssignK4ToExcELIN2Command
   */
  @PutMapping("/assignK4")
  public void assignK4(@RequestBody AssignK4ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignK4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K4", exc);
    }
  }

  /**
   * unassign K4 on ExcELIN2
   *
   * @param command UnAssignK4FromExcELIN2Command
   */
  @PutMapping("/unAssignK4")
  public void unAssignK4(@RequestBody(required = true) UnAssignK4FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignK4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K4", exc);
    }
  }

  /**
   * save Kd1 on ExcELIN2
   *
   * @param command AssignKd1ToExcELIN2Command
   */
  @PutMapping("/assignKd1")
  public void assignKd1(@RequestBody AssignKd1ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignKd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd1", exc);
    }
  }

  /**
   * unassign Kd1 on ExcELIN2
   *
   * @param command UnAssignKd1FromExcELIN2Command
   */
  @PutMapping("/unAssignKd1")
  public void unAssignKd1(@RequestBody(required = true) UnAssignKd1FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignKd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd1", exc);
    }
  }

  /**
   * save Ke2 on ExcELIN2
   *
   * @param command AssignKe2ToExcELIN2Command
   */
  @PutMapping("/assignKe2")
  public void assignKe2(@RequestBody AssignKe2ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignKe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke2", exc);
    }
  }

  /**
   * unassign Ke2 on ExcELIN2
   *
   * @param command UnAssignKe2FromExcELIN2Command
   */
  @PutMapping("/unAssignKe2")
  public void unAssignKe2(@RequestBody(required = true) UnAssignKe2FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignKe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke2", exc);
    }
  }

  /**
   * save Ketb on ExcELIN2
   *
   * @param command AssignKetbToExcELIN2Command
   */
  @PutMapping("/assignKetb")
  public void assignKetb(@RequestBody AssignKetbToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignKetb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ketb", exc);
    }
  }

  /**
   * unassign Ketb on ExcELIN2
   *
   * @param command UnAssignKetbFromExcELIN2Command
   */
  @PutMapping("/unAssignKetb")
  public void unAssignKetb(@RequestBody(required = true) UnAssignKetbFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignKetb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ketb", exc);
    }
  }

  /**
   * save Pid1max on ExcELIN2
   *
   * @param command AssignPid1maxToExcELIN2Command
   */
  @PutMapping("/assignPid1max")
  public void assignPid1max(@RequestBody AssignPid1maxToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignPid1max(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pid1max", exc);
    }
  }

  /**
   * unassign Pid1max on ExcELIN2
   *
   * @param command UnAssignPid1maxFromExcELIN2Command
   */
  @PutMapping("/unAssignPid1max")
  public void unAssignPid1max(
      @RequestBody(required = true) UnAssignPid1maxFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignPid1max(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pid1max", exc);
    }
  }

  /**
   * save Seve1 on ExcELIN2
   *
   * @param command AssignSeve1ToExcELIN2Command
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcELIN2
   *
   * @param command UnAssignSeve1FromExcELIN2Command
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(
      @RequestBody(required = true) UnAssignSeve1FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcELIN2
   *
   * @param command AssignSeve2ToExcELIN2Command
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcELIN2
   *
   * @param command UnAssignSeve2FromExcELIN2Command
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(
      @RequestBody(required = true) UnAssignSeve2FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Tb1 on ExcELIN2
   *
   * @param command AssignTb1ToExcELIN2Command
   */
  @PutMapping("/assignTb1")
  public void assignTb1(@RequestBody AssignTb1ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignTb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb1", exc);
    }
  }

  /**
   * unassign Tb1 on ExcELIN2
   *
   * @param command UnAssignTb1FromExcELIN2Command
   */
  @PutMapping("/unAssignTb1")
  public void unAssignTb1(@RequestBody(required = true) UnAssignTb1FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignTb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb1", exc);
    }
  }

  /**
   * save Te on ExcELIN2
   *
   * @param command AssignTeToExcELIN2Command
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcELIN2
   *
   * @param command UnAssignTeFromExcELIN2Command
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Te2 on ExcELIN2
   *
   * @param command AssignTe2ToExcELIN2Command
   */
  @PutMapping("/assignTe2")
  public void assignTe2(@RequestBody AssignTe2ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignTe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te2", exc);
    }
  }

  /**
   * unassign Te2 on ExcELIN2
   *
   * @param command UnAssignTe2FromExcELIN2Command
   */
  @PutMapping("/unAssignTe2")
  public void unAssignTe2(@RequestBody(required = true) UnAssignTe2FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignTe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te2", exc);
    }
  }

  /**
   * save Ti1 on ExcELIN2
   *
   * @param command AssignTi1ToExcELIN2Command
   */
  @PutMapping("/assignTi1")
  public void assignTi1(@RequestBody AssignTi1ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignTi1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti1", exc);
    }
  }

  /**
   * unassign Ti1 on ExcELIN2
   *
   * @param command UnAssignTi1FromExcELIN2Command
   */
  @PutMapping("/unAssignTi1")
  public void unAssignTi1(@RequestBody(required = true) UnAssignTi1FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignTi1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti1", exc);
    }
  }

  /**
   * save Ti3 on ExcELIN2
   *
   * @param command AssignTi3ToExcELIN2Command
   */
  @PutMapping("/assignTi3")
  public void assignTi3(@RequestBody AssignTi3ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignTi3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti3", exc);
    }
  }

  /**
   * unassign Ti3 on ExcELIN2
   *
   * @param command UnAssignTi3FromExcELIN2Command
   */
  @PutMapping("/unAssignTi3")
  public void unAssignTi3(@RequestBody(required = true) UnAssignTi3FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignTi3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti3", exc);
    }
  }

  /**
   * save Ti4 on ExcELIN2
   *
   * @param command AssignTi4ToExcELIN2Command
   */
  @PutMapping("/assignTi4")
  public void assignTi4(@RequestBody AssignTi4ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignTi4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti4", exc);
    }
  }

  /**
   * unassign Ti4 on ExcELIN2
   *
   * @param command UnAssignTi4FromExcELIN2Command
   */
  @PutMapping("/unAssignTi4")
  public void unAssignTi4(@RequestBody(required = true) UnAssignTi4FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignTi4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti4", exc);
    }
  }

  /**
   * save Tr4 on ExcELIN2
   *
   * @param command AssignTr4ToExcELIN2Command
   */
  @PutMapping("/assignTr4")
  public void assignTr4(@RequestBody AssignTr4ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignTr4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr4", exc);
    }
  }

  /**
   * unassign Tr4 on ExcELIN2
   *
   * @param command UnAssignTr4FromExcELIN2Command
   */
  @PutMapping("/unAssignTr4")
  public void unAssignTr4(@RequestBody(required = true) UnAssignTr4FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignTr4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr4", exc);
    }
  }

  /**
   * save Upmax on ExcELIN2
   *
   * @param command AssignUpmaxToExcELIN2Command
   */
  @PutMapping("/assignUpmax")
  public void assignUpmax(@RequestBody AssignUpmaxToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignUpmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Upmax", exc);
    }
  }

  /**
   * unassign Upmax on ExcELIN2
   *
   * @param command UnAssignUpmaxFromExcELIN2Command
   */
  @PutMapping("/unAssignUpmax")
  public void unAssignUpmax(
      @RequestBody(required = true) UnAssignUpmaxFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignUpmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Upmax", exc);
    }
  }

  /**
   * save Upmin on ExcELIN2
   *
   * @param command AssignUpminToExcELIN2Command
   */
  @PutMapping("/assignUpmin")
  public void assignUpmin(@RequestBody AssignUpminToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignUpmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Upmin", exc);
    }
  }

  /**
   * unassign Upmin on ExcELIN2
   *
   * @param command UnAssignUpminFromExcELIN2Command
   */
  @PutMapping("/unAssignUpmin")
  public void unAssignUpmin(
      @RequestBody(required = true) UnAssignUpminFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignUpmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Upmin", exc);
    }
  }

  /**
   * save Ve1 on ExcELIN2
   *
   * @param command AssignVe1ToExcELIN2Command
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcELIN2
   *
   * @param command UnAssignVe1FromExcELIN2Command
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcELIN2
   *
   * @param command AssignVe2ToExcELIN2Command
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcELIN2
   *
   * @param command UnAssignVe2FromExcELIN2Command
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Xp on ExcELIN2
   *
   * @param command AssignXpToExcELIN2Command
   */
  @PutMapping("/assignXp")
  public void assignXp(@RequestBody AssignXpToExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().assignXp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xp", exc);
    }
  }

  /**
   * unassign Xp on ExcELIN2
   *
   * @param command UnAssignXpFromExcELIN2Command
   */
  @PutMapping("/unAssignXp")
  public void unAssignXp(@RequestBody(required = true) UnAssignXpFromExcELIN2Command command) {
    try {
      ExcELIN2BusinessDelegate.getExcELIN2Instance().unAssignXp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xp", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcELIN2 excELIN2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcELIN2CommandRestController.class.getName());
}
