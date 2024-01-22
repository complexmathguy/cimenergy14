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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity WindContQIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContQIEC")
public class WindContQIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindContQIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindContQIEC windContQIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindContQIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindContQIECBusinessDelegate.getWindContQIECInstance().createWindContQIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindContQIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindContQIEC windContQIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindContQIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindContQIECCommand
      // -----------------------------------------------
      completableFuture =
          WindContQIECBusinessDelegate.getWindContQIECInstance().updateWindContQIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindContQIECController:update() - successfully update WindContQIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindContQIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windContQIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindContQIECCommand command = new DeleteWindContQIECCommand(windContQIECId);

    try {
      WindContQIECBusinessDelegate delegate =
          WindContQIECBusinessDelegate.getWindContQIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindContQIEC with key " + command.getWindContQIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Iqh1 on WindContQIEC
   *
   * @param command AssignIqh1ToWindContQIECCommand
   */
  @PutMapping("/assignIqh1")
  public void assignIqh1(@RequestBody AssignIqh1ToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignIqh1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Iqh1", exc);
    }
  }

  /**
   * unassign Iqh1 on WindContQIEC
   *
   * @param command UnAssignIqh1FromWindContQIECCommand
   */
  @PutMapping("/unAssignIqh1")
  public void unAssignIqh1(
      @RequestBody(required = true) UnAssignIqh1FromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignIqh1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Iqh1", exc);
    }
  }

  /**
   * save Iqmax on WindContQIEC
   *
   * @param command AssignIqmaxToWindContQIECCommand
   */
  @PutMapping("/assignIqmax")
  public void assignIqmax(@RequestBody AssignIqmaxToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignIqmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Iqmax", exc);
    }
  }

  /**
   * unassign Iqmax on WindContQIEC
   *
   * @param command UnAssignIqmaxFromWindContQIECCommand
   */
  @PutMapping("/unAssignIqmax")
  public void unAssignIqmax(
      @RequestBody(required = true) UnAssignIqmaxFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignIqmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Iqmax", exc);
    }
  }

  /**
   * save Iqmin on WindContQIEC
   *
   * @param command AssignIqminToWindContQIECCommand
   */
  @PutMapping("/assignIqmin")
  public void assignIqmin(@RequestBody AssignIqminToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignIqmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Iqmin", exc);
    }
  }

  /**
   * unassign Iqmin on WindContQIEC
   *
   * @param command UnAssignIqminFromWindContQIECCommand
   */
  @PutMapping("/unAssignIqmin")
  public void unAssignIqmin(
      @RequestBody(required = true) UnAssignIqminFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignIqmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Iqmin", exc);
    }
  }

  /**
   * save Iqpost on WindContQIEC
   *
   * @param command AssignIqpostToWindContQIECCommand
   */
  @PutMapping("/assignIqpost")
  public void assignIqpost(@RequestBody AssignIqpostToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignIqpost(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Iqpost", exc);
    }
  }

  /**
   * unassign Iqpost on WindContQIEC
   *
   * @param command UnAssignIqpostFromWindContQIECCommand
   */
  @PutMapping("/unAssignIqpost")
  public void unAssignIqpost(
      @RequestBody(required = true) UnAssignIqpostFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignIqpost(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Iqpost", exc);
    }
  }

  /**
   * save Kiq on WindContQIEC
   *
   * @param command AssignKiqToWindContQIECCommand
   */
  @PutMapping("/assignKiq")
  public void assignKiq(@RequestBody AssignKiqToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignKiq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kiq", exc);
    }
  }

  /**
   * unassign Kiq on WindContQIEC
   *
   * @param command UnAssignKiqFromWindContQIECCommand
   */
  @PutMapping("/unAssignKiq")
  public void unAssignKiq(
      @RequestBody(required = true) UnAssignKiqFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignKiq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kiq", exc);
    }
  }

  /**
   * save Kiu on WindContQIEC
   *
   * @param command AssignKiuToWindContQIECCommand
   */
  @PutMapping("/assignKiu")
  public void assignKiu(@RequestBody AssignKiuToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignKiu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kiu", exc);
    }
  }

  /**
   * unassign Kiu on WindContQIEC
   *
   * @param command UnAssignKiuFromWindContQIECCommand
   */
  @PutMapping("/unAssignKiu")
  public void unAssignKiu(
      @RequestBody(required = true) UnAssignKiuFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignKiu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kiu", exc);
    }
  }

  /**
   * save Kpq on WindContQIEC
   *
   * @param command AssignKpqToWindContQIECCommand
   */
  @PutMapping("/assignKpq")
  public void assignKpq(@RequestBody AssignKpqToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignKpq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpq", exc);
    }
  }

  /**
   * unassign Kpq on WindContQIEC
   *
   * @param command UnAssignKpqFromWindContQIECCommand
   */
  @PutMapping("/unAssignKpq")
  public void unAssignKpq(
      @RequestBody(required = true) UnAssignKpqFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignKpq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpq", exc);
    }
  }

  /**
   * save Kpu on WindContQIEC
   *
   * @param command AssignKpuToWindContQIECCommand
   */
  @PutMapping("/assignKpu")
  public void assignKpu(@RequestBody AssignKpuToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignKpu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpu", exc);
    }
  }

  /**
   * unassign Kpu on WindContQIEC
   *
   * @param command UnAssignKpuFromWindContQIECCommand
   */
  @PutMapping("/unAssignKpu")
  public void unAssignKpu(
      @RequestBody(required = true) UnAssignKpuFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignKpu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpu", exc);
    }
  }

  /**
   * save Kqv on WindContQIEC
   *
   * @param command AssignKqvToWindContQIECCommand
   */
  @PutMapping("/assignKqv")
  public void assignKqv(@RequestBody AssignKqvToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignKqv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kqv", exc);
    }
  }

  /**
   * unassign Kqv on WindContQIEC
   *
   * @param command UnAssignKqvFromWindContQIECCommand
   */
  @PutMapping("/unAssignKqv")
  public void unAssignKqv(
      @RequestBody(required = true) UnAssignKqvFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignKqv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kqv", exc);
    }
  }

  /**
   * save Qmax on WindContQIEC
   *
   * @param command AssignQmaxToWindContQIECCommand
   */
  @PutMapping("/assignQmax")
  public void assignQmax(@RequestBody AssignQmaxToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignQmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qmax", exc);
    }
  }

  /**
   * unassign Qmax on WindContQIEC
   *
   * @param command UnAssignQmaxFromWindContQIECCommand
   */
  @PutMapping("/unAssignQmax")
  public void unAssignQmax(
      @RequestBody(required = true) UnAssignQmaxFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignQmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qmax", exc);
    }
  }

  /**
   * save Qmin on WindContQIEC
   *
   * @param command AssignQminToWindContQIECCommand
   */
  @PutMapping("/assignQmin")
  public void assignQmin(@RequestBody AssignQminToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignQmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qmin", exc);
    }
  }

  /**
   * unassign Qmin on WindContQIEC
   *
   * @param command UnAssignQminFromWindContQIECCommand
   */
  @PutMapping("/unAssignQmin")
  public void unAssignQmin(
      @RequestBody(required = true) UnAssignQminFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignQmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qmin", exc);
    }
  }

  /**
   * save Rdroop on WindContQIEC
   *
   * @param command AssignRdroopToWindContQIECCommand
   */
  @PutMapping("/assignRdroop")
  public void assignRdroop(@RequestBody AssignRdroopToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignRdroop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rdroop", exc);
    }
  }

  /**
   * unassign Rdroop on WindContQIEC
   *
   * @param command UnAssignRdroopFromWindContQIECCommand
   */
  @PutMapping("/unAssignRdroop")
  public void unAssignRdroop(
      @RequestBody(required = true) UnAssignRdroopFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignRdroop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rdroop", exc);
    }
  }

  /**
   * save Tiq on WindContQIEC
   *
   * @param command AssignTiqToWindContQIECCommand
   */
  @PutMapping("/assignTiq")
  public void assignTiq(@RequestBody AssignTiqToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignTiq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tiq", exc);
    }
  }

  /**
   * unassign Tiq on WindContQIEC
   *
   * @param command UnAssignTiqFromWindContQIECCommand
   */
  @PutMapping("/unAssignTiq")
  public void unAssignTiq(
      @RequestBody(required = true) UnAssignTiqFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignTiq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tiq", exc);
    }
  }

  /**
   * save Tpfilt on WindContQIEC
   *
   * @param command AssignTpfiltToWindContQIECCommand
   */
  @PutMapping("/assignTpfilt")
  public void assignTpfilt(@RequestBody AssignTpfiltToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignTpfilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpfilt", exc);
    }
  }

  /**
   * unassign Tpfilt on WindContQIEC
   *
   * @param command UnAssignTpfiltFromWindContQIECCommand
   */
  @PutMapping("/unAssignTpfilt")
  public void unAssignTpfilt(
      @RequestBody(required = true) UnAssignTpfiltFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignTpfilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpfilt", exc);
    }
  }

  /**
   * save Tpost on WindContQIEC
   *
   * @param command AssignTpostToWindContQIECCommand
   */
  @PutMapping("/assignTpost")
  public void assignTpost(@RequestBody AssignTpostToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignTpost(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpost", exc);
    }
  }

  /**
   * unassign Tpost on WindContQIEC
   *
   * @param command UnAssignTpostFromWindContQIECCommand
   */
  @PutMapping("/unAssignTpost")
  public void unAssignTpost(
      @RequestBody(required = true) UnAssignTpostFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignTpost(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpost", exc);
    }
  }

  /**
   * save Tqord on WindContQIEC
   *
   * @param command AssignTqordToWindContQIECCommand
   */
  @PutMapping("/assignTqord")
  public void assignTqord(@RequestBody AssignTqordToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignTqord(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tqord", exc);
    }
  }

  /**
   * unassign Tqord on WindContQIEC
   *
   * @param command UnAssignTqordFromWindContQIECCommand
   */
  @PutMapping("/unAssignTqord")
  public void unAssignTqord(
      @RequestBody(required = true) UnAssignTqordFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignTqord(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tqord", exc);
    }
  }

  /**
   * save Tufilt on WindContQIEC
   *
   * @param command AssignTufiltToWindContQIECCommand
   */
  @PutMapping("/assignTufilt")
  public void assignTufilt(@RequestBody AssignTufiltToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignTufilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tufilt", exc);
    }
  }

  /**
   * unassign Tufilt on WindContQIEC
   *
   * @param command UnAssignTufiltFromWindContQIECCommand
   */
  @PutMapping("/unAssignTufilt")
  public void unAssignTufilt(
      @RequestBody(required = true) UnAssignTufiltFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignTufilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tufilt", exc);
    }
  }

  /**
   * save Udb1 on WindContQIEC
   *
   * @param command AssignUdb1ToWindContQIECCommand
   */
  @PutMapping("/assignUdb1")
  public void assignUdb1(@RequestBody AssignUdb1ToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignUdb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Udb1", exc);
    }
  }

  /**
   * unassign Udb1 on WindContQIEC
   *
   * @param command UnAssignUdb1FromWindContQIECCommand
   */
  @PutMapping("/unAssignUdb1")
  public void unAssignUdb1(
      @RequestBody(required = true) UnAssignUdb1FromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignUdb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Udb1", exc);
    }
  }

  /**
   * save Udb2 on WindContQIEC
   *
   * @param command AssignUdb2ToWindContQIECCommand
   */
  @PutMapping("/assignUdb2")
  public void assignUdb2(@RequestBody AssignUdb2ToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignUdb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Udb2", exc);
    }
  }

  /**
   * unassign Udb2 on WindContQIEC
   *
   * @param command UnAssignUdb2FromWindContQIECCommand
   */
  @PutMapping("/unAssignUdb2")
  public void unAssignUdb2(
      @RequestBody(required = true) UnAssignUdb2FromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignUdb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Udb2", exc);
    }
  }

  /**
   * save Umax on WindContQIEC
   *
   * @param command AssignUmaxToWindContQIECCommand
   */
  @PutMapping("/assignUmax")
  public void assignUmax(@RequestBody AssignUmaxToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignUmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Umax", exc);
    }
  }

  /**
   * unassign Umax on WindContQIEC
   *
   * @param command UnAssignUmaxFromWindContQIECCommand
   */
  @PutMapping("/unAssignUmax")
  public void unAssignUmax(
      @RequestBody(required = true) UnAssignUmaxFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignUmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Umax", exc);
    }
  }

  /**
   * save Umin on WindContQIEC
   *
   * @param command AssignUminToWindContQIECCommand
   */
  @PutMapping("/assignUmin")
  public void assignUmin(@RequestBody AssignUminToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignUmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Umin", exc);
    }
  }

  /**
   * unassign Umin on WindContQIEC
   *
   * @param command UnAssignUminFromWindContQIECCommand
   */
  @PutMapping("/unAssignUmin")
  public void unAssignUmin(
      @RequestBody(required = true) UnAssignUminFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignUmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Umin", exc);
    }
  }

  /**
   * save Uqdip on WindContQIEC
   *
   * @param command AssignUqdipToWindContQIECCommand
   */
  @PutMapping("/assignUqdip")
  public void assignUqdip(@RequestBody AssignUqdipToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignUqdip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uqdip", exc);
    }
  }

  /**
   * unassign Uqdip on WindContQIEC
   *
   * @param command UnAssignUqdipFromWindContQIECCommand
   */
  @PutMapping("/unAssignUqdip")
  public void unAssignUqdip(
      @RequestBody(required = true) UnAssignUqdipFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignUqdip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uqdip", exc);
    }
  }

  /**
   * save Uref0 on WindContQIEC
   *
   * @param command AssignUref0ToWindContQIECCommand
   */
  @PutMapping("/assignUref0")
  public void assignUref0(@RequestBody AssignUref0ToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignUref0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uref0", exc);
    }
  }

  /**
   * unassign Uref0 on WindContQIEC
   *
   * @param command UnAssignUref0FromWindContQIECCommand
   */
  @PutMapping("/unAssignUref0")
  public void unAssignUref0(
      @RequestBody(required = true) UnAssignUref0FromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignUref0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uref0", exc);
    }
  }

  /**
   * save Xdroop on WindContQIEC
   *
   * @param command AssignXdroopToWindContQIECCommand
   */
  @PutMapping("/assignXdroop")
  public void assignXdroop(@RequestBody AssignXdroopToWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().assignXdroop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xdroop", exc);
    }
  }

  /**
   * unassign Xdroop on WindContQIEC
   *
   * @param command UnAssignXdroopFromWindContQIECCommand
   */
  @PutMapping("/unAssignXdroop")
  public void unAssignXdroop(
      @RequestBody(required = true) UnAssignXdroopFromWindContQIECCommand command) {
    try {
      WindContQIECBusinessDelegate.getWindContQIECInstance().unAssignXdroop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xdroop", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindContQIEC windContQIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContQIECCommandRestController.class.getName());
}
