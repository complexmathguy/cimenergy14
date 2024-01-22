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
 * Implements Spring Controller command CQRS processing for entity WindContPType3IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType3IEC")
public class WindContPType3IECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindContPType3IEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindContPType3IEC windContPType3IEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindContPType3IECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindContPType3IECBusinessDelegate.getWindContPType3IECInstance()
              .createWindContPType3IEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindContPType3IEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindContPType3IEC windContPType3IEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindContPType3IECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindContPType3IECCommand
      // -----------------------------------------------
      completableFuture =
          WindContPType3IECBusinessDelegate.getWindContPType3IECInstance()
              .updateWindContPType3IEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindContPType3IECController:update() - successfully update WindContPType3IEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindContPType3IEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windContPType3IECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindContPType3IECCommand command =
        new DeleteWindContPType3IECCommand(windContPType3IECId);

    try {
      WindContPType3IECBusinessDelegate delegate =
          WindContPType3IECBusinessDelegate.getWindContPType3IECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindContPType3IEC with key " + command.getWindContPType3IECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dpmax on WindContPType3IEC
   *
   * @param command AssignDpmaxToWindContPType3IECCommand
   */
  @PutMapping("/assignDpmax")
  public void assignDpmax(@RequestBody AssignDpmaxToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignDpmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dpmax", exc);
    }
  }

  /**
   * unassign Dpmax on WindContPType3IEC
   *
   * @param command UnAssignDpmaxFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignDpmax")
  public void unAssignDpmax(
      @RequestBody(required = true) UnAssignDpmaxFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignDpmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dpmax", exc);
    }
  }

  /**
   * save Dtrisemaxlvrt on WindContPType3IEC
   *
   * @param command AssignDtrisemaxlvrtToWindContPType3IECCommand
   */
  @PutMapping("/assignDtrisemaxlvrt")
  public void assignDtrisemaxlvrt(
      @RequestBody AssignDtrisemaxlvrtToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignDtrisemaxlvrt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dtrisemaxlvrt", exc);
    }
  }

  /**
   * unassign Dtrisemaxlvrt on WindContPType3IEC
   *
   * @param command UnAssignDtrisemaxlvrtFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignDtrisemaxlvrt")
  public void unAssignDtrisemaxlvrt(
      @RequestBody(required = true) UnAssignDtrisemaxlvrtFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance()
          .unAssignDtrisemaxlvrt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dtrisemaxlvrt", exc);
    }
  }

  /**
   * save Kdtd on WindContPType3IEC
   *
   * @param command AssignKdtdToWindContPType3IECCommand
   */
  @PutMapping("/assignKdtd")
  public void assignKdtd(@RequestBody AssignKdtdToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignKdtd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdtd", exc);
    }
  }

  /**
   * unassign Kdtd on WindContPType3IEC
   *
   * @param command UnAssignKdtdFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignKdtd")
  public void unAssignKdtd(
      @RequestBody(required = true) UnAssignKdtdFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignKdtd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdtd", exc);
    }
  }

  /**
   * save Kip on WindContPType3IEC
   *
   * @param command AssignKipToWindContPType3IECCommand
   */
  @PutMapping("/assignKip")
  public void assignKip(@RequestBody AssignKipToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignKip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kip", exc);
    }
  }

  /**
   * unassign Kip on WindContPType3IEC
   *
   * @param command UnAssignKipFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignKip")
  public void unAssignKip(
      @RequestBody(required = true) UnAssignKipFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignKip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kip", exc);
    }
  }

  /**
   * save Kpp on WindContPType3IEC
   *
   * @param command AssignKppToWindContPType3IECCommand
   */
  @PutMapping("/assignKpp")
  public void assignKpp(@RequestBody AssignKppToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignKpp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpp", exc);
    }
  }

  /**
   * unassign Kpp on WindContPType3IEC
   *
   * @param command UnAssignKppFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignKpp")
  public void unAssignKpp(
      @RequestBody(required = true) UnAssignKppFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignKpp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpp", exc);
    }
  }

  /**
   * save Mplvrt on WindContPType3IEC
   *
   * @param command AssignMplvrtToWindContPType3IECCommand
   */
  @PutMapping("/assignMplvrt")
  public void assignMplvrt(@RequestBody AssignMplvrtToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignMplvrt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mplvrt", exc);
    }
  }

  /**
   * unassign Mplvrt on WindContPType3IEC
   *
   * @param command UnAssignMplvrtFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignMplvrt")
  public void unAssignMplvrt(
      @RequestBody(required = true) UnAssignMplvrtFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignMplvrt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mplvrt", exc);
    }
  }

  /**
   * save Omegaoffset on WindContPType3IEC
   *
   * @param command AssignOmegaoffsetToWindContPType3IECCommand
   */
  @PutMapping("/assignOmegaoffset")
  public void assignOmegaoffset(@RequestBody AssignOmegaoffsetToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignOmegaoffset(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Omegaoffset", exc);
    }
  }

  /**
   * unassign Omegaoffset on WindContPType3IEC
   *
   * @param command UnAssignOmegaoffsetFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignOmegaoffset")
  public void unAssignOmegaoffset(
      @RequestBody(required = true) UnAssignOmegaoffsetFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignOmegaoffset(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Omegaoffset", exc);
    }
  }

  /**
   * save Pdtdmax on WindContPType3IEC
   *
   * @param command AssignPdtdmaxToWindContPType3IECCommand
   */
  @PutMapping("/assignPdtdmax")
  public void assignPdtdmax(@RequestBody AssignPdtdmaxToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignPdtdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pdtdmax", exc);
    }
  }

  /**
   * unassign Pdtdmax on WindContPType3IEC
   *
   * @param command UnAssignPdtdmaxFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignPdtdmax")
  public void unAssignPdtdmax(
      @RequestBody(required = true) UnAssignPdtdmaxFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignPdtdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pdtdmax", exc);
    }
  }

  /**
   * save Rramp on WindContPType3IEC
   *
   * @param command AssignRrampToWindContPType3IECCommand
   */
  @PutMapping("/assignRramp")
  public void assignRramp(@RequestBody AssignRrampToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignRramp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rramp", exc);
    }
  }

  /**
   * unassign Rramp on WindContPType3IEC
   *
   * @param command UnAssignRrampFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignRramp")
  public void unAssignRramp(
      @RequestBody(required = true) UnAssignRrampFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignRramp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rramp", exc);
    }
  }

  /**
   * save Tdvs on WindContPType3IEC
   *
   * @param command AssignTdvsToWindContPType3IECCommand
   */
  @PutMapping("/assignTdvs")
  public void assignTdvs(@RequestBody AssignTdvsToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignTdvs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdvs", exc);
    }
  }

  /**
   * unassign Tdvs on WindContPType3IEC
   *
   * @param command UnAssignTdvsFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignTdvs")
  public void unAssignTdvs(
      @RequestBody(required = true) UnAssignTdvsFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignTdvs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdvs", exc);
    }
  }

  /**
   * save Temin on WindContPType3IEC
   *
   * @param command AssignTeminToWindContPType3IECCommand
   */
  @PutMapping("/assignTemin")
  public void assignTemin(@RequestBody AssignTeminToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignTemin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Temin", exc);
    }
  }

  /**
   * unassign Temin on WindContPType3IEC
   *
   * @param command UnAssignTeminFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignTemin")
  public void unAssignTemin(
      @RequestBody(required = true) UnAssignTeminFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignTemin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Temin", exc);
    }
  }

  /**
   * save Tomegafilt on WindContPType3IEC
   *
   * @param command AssignTomegafiltToWindContPType3IECCommand
   */
  @PutMapping("/assignTomegafilt")
  public void assignTomegafilt(@RequestBody AssignTomegafiltToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignTomegafilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tomegafilt", exc);
    }
  }

  /**
   * unassign Tomegafilt on WindContPType3IEC
   *
   * @param command UnAssignTomegafiltFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignTomegafilt")
  public void unAssignTomegafilt(
      @RequestBody(required = true) UnAssignTomegafiltFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignTomegafilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tomegafilt", exc);
    }
  }

  /**
   * save Tpfilt on WindContPType3IEC
   *
   * @param command AssignTpfiltToWindContPType3IECCommand
   */
  @PutMapping("/assignTpfilt")
  public void assignTpfilt(@RequestBody AssignTpfiltToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignTpfilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpfilt", exc);
    }
  }

  /**
   * unassign Tpfilt on WindContPType3IEC
   *
   * @param command UnAssignTpfiltFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignTpfilt")
  public void unAssignTpfilt(
      @RequestBody(required = true) UnAssignTpfiltFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignTpfilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpfilt", exc);
    }
  }

  /**
   * save Tpord on WindContPType3IEC
   *
   * @param command AssignTpordToWindContPType3IECCommand
   */
  @PutMapping("/assignTpord")
  public void assignTpord(@RequestBody AssignTpordToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignTpord(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpord", exc);
    }
  }

  /**
   * unassign Tpord on WindContPType3IEC
   *
   * @param command UnAssignTpordFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignTpord")
  public void unAssignTpord(
      @RequestBody(required = true) UnAssignTpordFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignTpord(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpord", exc);
    }
  }

  /**
   * save Tufilt on WindContPType3IEC
   *
   * @param command AssignTufiltToWindContPType3IECCommand
   */
  @PutMapping("/assignTufilt")
  public void assignTufilt(@RequestBody AssignTufiltToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignTufilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tufilt", exc);
    }
  }

  /**
   * unassign Tufilt on WindContPType3IEC
   *
   * @param command UnAssignTufiltFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignTufilt")
  public void unAssignTufilt(
      @RequestBody(required = true) UnAssignTufiltFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignTufilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tufilt", exc);
    }
  }

  /**
   * save Tuscale on WindContPType3IEC
   *
   * @param command AssignTuscaleToWindContPType3IECCommand
   */
  @PutMapping("/assignTuscale")
  public void assignTuscale(@RequestBody AssignTuscaleToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignTuscale(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tuscale", exc);
    }
  }

  /**
   * unassign Tuscale on WindContPType3IEC
   *
   * @param command UnAssignTuscaleFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignTuscale")
  public void unAssignTuscale(
      @RequestBody(required = true) UnAssignTuscaleFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignTuscale(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tuscale", exc);
    }
  }

  /**
   * save Twref on WindContPType3IEC
   *
   * @param command AssignTwrefToWindContPType3IECCommand
   */
  @PutMapping("/assignTwref")
  public void assignTwref(@RequestBody AssignTwrefToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignTwref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twref", exc);
    }
  }

  /**
   * unassign Twref on WindContPType3IEC
   *
   * @param command UnAssignTwrefFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignTwref")
  public void unAssignTwref(
      @RequestBody(required = true) UnAssignTwrefFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignTwref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twref", exc);
    }
  }

  /**
   * save Udvs on WindContPType3IEC
   *
   * @param command AssignUdvsToWindContPType3IECCommand
   */
  @PutMapping("/assignUdvs")
  public void assignUdvs(@RequestBody AssignUdvsToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignUdvs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Udvs", exc);
    }
  }

  /**
   * unassign Udvs on WindContPType3IEC
   *
   * @param command UnAssignUdvsFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignUdvs")
  public void unAssignUdvs(
      @RequestBody(required = true) UnAssignUdvsFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignUdvs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Udvs", exc);
    }
  }

  /**
   * save Updip on WindContPType3IEC
   *
   * @param command AssignUpdipToWindContPType3IECCommand
   */
  @PutMapping("/assignUpdip")
  public void assignUpdip(@RequestBody AssignUpdipToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignUpdip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Updip", exc);
    }
  }

  /**
   * unassign Updip on WindContPType3IEC
   *
   * @param command UnAssignUpdipFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignUpdip")
  public void unAssignUpdip(
      @RequestBody(required = true) UnAssignUpdipFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignUpdip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Updip", exc);
    }
  }

  /**
   * save Wdtd on WindContPType3IEC
   *
   * @param command AssignWdtdToWindContPType3IECCommand
   */
  @PutMapping("/assignWdtd")
  public void assignWdtd(@RequestBody AssignWdtdToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignWdtd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wdtd", exc);
    }
  }

  /**
   * unassign Wdtd on WindContPType3IEC
   *
   * @param command UnAssignWdtdFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignWdtd")
  public void unAssignWdtd(
      @RequestBody(required = true) UnAssignWdtdFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignWdtd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wdtd", exc);
    }
  }

  /**
   * save Zeta on WindContPType3IEC
   *
   * @param command AssignZetaToWindContPType3IECCommand
   */
  @PutMapping("/assignZeta")
  public void assignZeta(@RequestBody AssignZetaToWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().assignZeta(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Zeta", exc);
    }
  }

  /**
   * unassign Zeta on WindContPType3IEC
   *
   * @param command UnAssignZetaFromWindContPType3IECCommand
   */
  @PutMapping("/unAssignZeta")
  public void unAssignZeta(
      @RequestBody(required = true) UnAssignZetaFromWindContPType3IECCommand command) {
    try {
      WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().unAssignZeta(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Zeta", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindContPType3IEC windContPType3IEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContPType3IECCommandRestController.class.getName());
}
