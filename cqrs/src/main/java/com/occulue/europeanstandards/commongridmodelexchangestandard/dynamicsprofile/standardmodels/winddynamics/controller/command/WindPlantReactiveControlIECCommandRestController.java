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
 * Implements Spring Controller command CQRS processing for entity WindPlantReactiveControlIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantReactiveControlIEC")
public class WindPlantReactiveControlIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindPlantReactiveControlIEC. if not key provided, calls create, otherwise
   * calls save
   *
   * @param WindPlantReactiveControlIEC windPlantReactiveControlIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindPlantReactiveControlIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
              .createWindPlantReactiveControlIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindPlantReactiveControlIEC. if no key provided, calls create, otherwise
   * calls save
   *
   * @param WindPlantReactiveControlIEC windPlantReactiveControlIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindPlantReactiveControlIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindPlantReactiveControlIECCommand
      // -----------------------------------------------
      completableFuture =
          WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
              .updateWindPlantReactiveControlIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindPlantReactiveControlIECController:update() - successfully update WindPlantReactiveControlIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindPlantReactiveControlIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windPlantReactiveControlIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindPlantReactiveControlIECCommand command =
        new DeleteWindPlantReactiveControlIECCommand(windPlantReactiveControlIECId);

    try {
      WindPlantReactiveControlIECBusinessDelegate delegate =
          WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindPlantReactiveControlIEC with key "
              + command.getWindPlantReactiveControlIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kiwpx on WindPlantReactiveControlIEC
   *
   * @param command AssignKiwpxToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignKiwpx")
  public void assignKiwpx(@RequestBody AssignKiwpxToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignKiwpx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kiwpx", exc);
    }
  }

  /**
   * unassign Kiwpx on WindPlantReactiveControlIEC
   *
   * @param command UnAssignKiwpxFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignKiwpx")
  public void unAssignKiwpx(
      @RequestBody(required = true) UnAssignKiwpxFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignKiwpx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kiwpx", exc);
    }
  }

  /**
   * save Kpwpx on WindPlantReactiveControlIEC
   *
   * @param command AssignKpwpxToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignKpwpx")
  public void assignKpwpx(@RequestBody AssignKpwpxToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignKpwpx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpwpx", exc);
    }
  }

  /**
   * unassign Kpwpx on WindPlantReactiveControlIEC
   *
   * @param command UnAssignKpwpxFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignKpwpx")
  public void unAssignKpwpx(
      @RequestBody(required = true) UnAssignKpwpxFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignKpwpx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpwpx", exc);
    }
  }

  /**
   * save Kwpqu on WindPlantReactiveControlIEC
   *
   * @param command AssignKwpquToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignKwpqu")
  public void assignKwpqu(@RequestBody AssignKwpquToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignKwpqu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kwpqu", exc);
    }
  }

  /**
   * unassign Kwpqu on WindPlantReactiveControlIEC
   *
   * @param command UnAssignKwpquFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignKwpqu")
  public void unAssignKwpqu(
      @RequestBody(required = true) UnAssignKwpquFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignKwpqu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kwpqu", exc);
    }
  }

  /**
   * save Mwppf on WindPlantReactiveControlIEC
   *
   * @param command AssignMwppfToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignMwppf")
  public void assignMwppf(@RequestBody AssignMwppfToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignMwppf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwppf", exc);
    }
  }

  /**
   * unassign Mwppf on WindPlantReactiveControlIEC
   *
   * @param command UnAssignMwppfFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignMwppf")
  public void unAssignMwppf(
      @RequestBody(required = true) UnAssignMwppfFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignMwppf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwppf", exc);
    }
  }

  /**
   * save Mwpu on WindPlantReactiveControlIEC
   *
   * @param command AssignMwpuToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignMwpu")
  public void assignMwpu(@RequestBody AssignMwpuToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignMwpu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwpu", exc);
    }
  }

  /**
   * unassign Mwpu on WindPlantReactiveControlIEC
   *
   * @param command UnAssignMwpuFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignMwpu")
  public void unAssignMwpu(
      @RequestBody(required = true) UnAssignMwpuFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignMwpu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwpu", exc);
    }
  }

  /**
   * save Twppfilt on WindPlantReactiveControlIEC
   *
   * @param command AssignTwppfiltToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignTwppfilt")
  public void assignTwppfilt(
      @RequestBody AssignTwppfiltToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignTwppfilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twppfilt", exc);
    }
  }

  /**
   * unassign Twppfilt on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwppfiltFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignTwppfilt")
  public void unAssignTwppfilt(
      @RequestBody(required = true)
          UnAssignTwppfiltFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignTwppfilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twppfilt", exc);
    }
  }

  /**
   * save Twpqfilt on WindPlantReactiveControlIEC
   *
   * @param command AssignTwpqfiltToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignTwpqfilt")
  public void assignTwpqfilt(
      @RequestBody AssignTwpqfiltToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignTwpqfilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twpqfilt", exc);
    }
  }

  /**
   * unassign Twpqfilt on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignTwpqfilt")
  public void unAssignTwpqfilt(
      @RequestBody(required = true)
          UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignTwpqfilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twpqfilt", exc);
    }
  }

  /**
   * save Twpufilt on WindPlantReactiveControlIEC
   *
   * @param command AssignTwpufiltToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignTwpufilt")
  public void assignTwpufilt(
      @RequestBody AssignTwpufiltToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignTwpufilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twpufilt", exc);
    }
  }

  /**
   * unassign Twpufilt on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwpufiltFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignTwpufilt")
  public void unAssignTwpufilt(
      @RequestBody(required = true)
          UnAssignTwpufiltFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignTwpufilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twpufilt", exc);
    }
  }

  /**
   * save Txft on WindPlantReactiveControlIEC
   *
   * @param command AssignTxftToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignTxft")
  public void assignTxft(@RequestBody AssignTxftToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignTxft(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Txft", exc);
    }
  }

  /**
   * unassign Txft on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTxftFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignTxft")
  public void unAssignTxft(
      @RequestBody(required = true) UnAssignTxftFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignTxft(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Txft", exc);
    }
  }

  /**
   * save Txfv on WindPlantReactiveControlIEC
   *
   * @param command AssignTxfvToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignTxfv")
  public void assignTxfv(@RequestBody AssignTxfvToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignTxfv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Txfv", exc);
    }
  }

  /**
   * unassign Txfv on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTxfvFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignTxfv")
  public void unAssignTxfv(
      @RequestBody(required = true) UnAssignTxfvFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignTxfv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Txfv", exc);
    }
  }

  /**
   * save Uwpqdip on WindPlantReactiveControlIEC
   *
   * @param command AssignUwpqdipToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignUwpqdip")
  public void assignUwpqdip(
      @RequestBody AssignUwpqdipToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignUwpqdip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uwpqdip", exc);
    }
  }

  /**
   * unassign Uwpqdip on WindPlantReactiveControlIEC
   *
   * @param command UnAssignUwpqdipFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignUwpqdip")
  public void unAssignUwpqdip(
      @RequestBody(required = true) UnAssignUwpqdipFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignUwpqdip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uwpqdip", exc);
    }
  }

  /**
   * save Xrefmax on WindPlantReactiveControlIEC
   *
   * @param command AssignXrefmaxToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignXrefmax")
  public void assignXrefmax(
      @RequestBody AssignXrefmaxToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignXrefmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xrefmax", exc);
    }
  }

  /**
   * unassign Xrefmax on WindPlantReactiveControlIEC
   *
   * @param command UnAssignXrefmaxFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignXrefmax")
  public void unAssignXrefmax(
      @RequestBody(required = true) UnAssignXrefmaxFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignXrefmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xrefmax", exc);
    }
  }

  /**
   * save Xrefmin on WindPlantReactiveControlIEC
   *
   * @param command AssignXrefminToWindPlantReactiveControlIECCommand
   */
  @PutMapping("/assignXrefmin")
  public void assignXrefmin(
      @RequestBody AssignXrefminToWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .assignXrefmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xrefmin", exc);
    }
  }

  /**
   * unassign Xrefmin on WindPlantReactiveControlIEC
   *
   * @param command UnAssignXrefminFromWindPlantReactiveControlIECCommand
   */
  @PutMapping("/unAssignXrefmin")
  public void unAssignXrefmin(
      @RequestBody(required = true) UnAssignXrefminFromWindPlantReactiveControlIECCommand command) {
    try {
      WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
          .unAssignXrefmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xrefmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindPlantReactiveControlIEC windPlantReactiveControlIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantReactiveControlIECCommandRestController.class.getName());
}
