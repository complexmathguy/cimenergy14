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
 * Implements Spring Controller command CQRS processing for entity WindPlantFreqPcontrolIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantFreqPcontrolIEC")
public class WindPlantFreqPcontrolIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindPlantFreqPcontrolIEC. if not key provided, calls create, otherwise calls
   * save
   *
   * @param WindPlantFreqPcontrolIEC windPlantFreqPcontrolIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindPlantFreqPcontrolIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
              .createWindPlantFreqPcontrolIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindPlantFreqPcontrolIEC. if no key provided, calls create, otherwise calls
   * save
   *
   * @param WindPlantFreqPcontrolIEC windPlantFreqPcontrolIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindPlantFreqPcontrolIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindPlantFreqPcontrolIECCommand
      // -----------------------------------------------
      completableFuture =
          WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
              .updateWindPlantFreqPcontrolIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindPlantFreqPcontrolIECController:update() - successfully update WindPlantFreqPcontrolIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindPlantFreqPcontrolIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windPlantFreqPcontrolIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindPlantFreqPcontrolIECCommand command =
        new DeleteWindPlantFreqPcontrolIECCommand(windPlantFreqPcontrolIECId);

    try {
      WindPlantFreqPcontrolIECBusinessDelegate delegate =
          WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindPlantFreqPcontrolIEC with key "
              + command.getWindPlantFreqPcontrolIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dprefmax on WindPlantFreqPcontrolIEC
   *
   * @param command AssignDprefmaxToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignDprefmax")
  public void assignDprefmax(@RequestBody AssignDprefmaxToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignDprefmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dprefmax", exc);
    }
  }

  /**
   * unassign Dprefmax on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignDprefmax")
  public void unAssignDprefmax(
      @RequestBody(required = true) UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignDprefmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dprefmax", exc);
    }
  }

  /**
   * save Dprefmin on WindPlantFreqPcontrolIEC
   *
   * @param command AssignDprefminToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignDprefmin")
  public void assignDprefmin(@RequestBody AssignDprefminToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignDprefmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dprefmin", exc);
    }
  }

  /**
   * unassign Dprefmin on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignDprefminFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignDprefmin")
  public void unAssignDprefmin(
      @RequestBody(required = true) UnAssignDprefminFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignDprefmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dprefmin", exc);
    }
  }

  /**
   * save Kiwpp on WindPlantFreqPcontrolIEC
   *
   * @param command AssignKiwppToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignKiwpp")
  public void assignKiwpp(@RequestBody AssignKiwppToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignKiwpp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kiwpp", exc);
    }
  }

  /**
   * unassign Kiwpp on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignKiwppFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignKiwpp")
  public void unAssignKiwpp(
      @RequestBody(required = true) UnAssignKiwppFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignKiwpp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kiwpp", exc);
    }
  }

  /**
   * save Kpwpp on WindPlantFreqPcontrolIEC
   *
   * @param command AssignKpwppToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignKpwpp")
  public void assignKpwpp(@RequestBody AssignKpwppToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignKpwpp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpwpp", exc);
    }
  }

  /**
   * unassign Kpwpp on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignKpwppFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignKpwpp")
  public void unAssignKpwpp(
      @RequestBody(required = true) UnAssignKpwppFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignKpwpp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpwpp", exc);
    }
  }

  /**
   * save Prefmax on WindPlantFreqPcontrolIEC
   *
   * @param command AssignPrefmaxToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignPrefmax")
  public void assignPrefmax(@RequestBody AssignPrefmaxToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignPrefmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Prefmax", exc);
    }
  }

  /**
   * unassign Prefmax on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignPrefmax")
  public void unAssignPrefmax(
      @RequestBody(required = true) UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignPrefmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Prefmax", exc);
    }
  }

  /**
   * save Prefmin on WindPlantFreqPcontrolIEC
   *
   * @param command AssignPrefminToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignPrefmin")
  public void assignPrefmin(@RequestBody AssignPrefminToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignPrefmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Prefmin", exc);
    }
  }

  /**
   * unassign Prefmin on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignPrefminFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignPrefmin")
  public void unAssignPrefmin(
      @RequestBody(required = true) UnAssignPrefminFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignPrefmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Prefmin", exc);
    }
  }

  /**
   * save Tpft on WindPlantFreqPcontrolIEC
   *
   * @param command AssignTpftToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignTpft")
  public void assignTpft(@RequestBody AssignTpftToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignTpft(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpft", exc);
    }
  }

  /**
   * unassign Tpft on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTpftFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignTpft")
  public void unAssignTpft(
      @RequestBody(required = true) UnAssignTpftFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignTpft(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpft", exc);
    }
  }

  /**
   * save Tpfv on WindPlantFreqPcontrolIEC
   *
   * @param command AssignTpfvToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignTpfv")
  public void assignTpfv(@RequestBody AssignTpfvToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignTpfv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpfv", exc);
    }
  }

  /**
   * unassign Tpfv on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTpfvFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignTpfv")
  public void unAssignTpfv(
      @RequestBody(required = true) UnAssignTpfvFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignTpfv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpfv", exc);
    }
  }

  /**
   * save Twpffilt on WindPlantFreqPcontrolIEC
   *
   * @param command AssignTwpffiltToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignTwpffilt")
  public void assignTwpffilt(@RequestBody AssignTwpffiltToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignTwpffilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twpffilt", exc);
    }
  }

  /**
   * unassign Twpffilt on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignTwpffilt")
  public void unAssignTwpffilt(
      @RequestBody(required = true) UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignTwpffilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twpffilt", exc);
    }
  }

  /**
   * save Twppfilt on WindPlantFreqPcontrolIEC
   *
   * @param command AssignTwppfiltToWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/assignTwppfilt")
  public void assignTwppfilt(@RequestBody AssignTwppfiltToWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .assignTwppfilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twppfilt", exc);
    }
  }

  /**
   * unassign Twppfilt on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand
   */
  @PutMapping("/unAssignTwppfilt")
  public void unAssignTwppfilt(
      @RequestBody(required = true) UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand command) {
    try {
      WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
          .unAssignTwppfilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twppfilt", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindPlantFreqPcontrolIEC windPlantFreqPcontrolIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantFreqPcontrolIECCommandRestController.class.getName());
}
