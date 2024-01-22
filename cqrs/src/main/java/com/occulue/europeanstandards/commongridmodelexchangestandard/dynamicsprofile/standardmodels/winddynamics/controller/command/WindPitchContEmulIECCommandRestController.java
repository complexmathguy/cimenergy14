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
 * Implements Spring Controller command CQRS processing for entity WindPitchContEmulIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPitchContEmulIEC")
public class WindPitchContEmulIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindPitchContEmulIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindPitchContEmulIEC windPitchContEmulIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindPitchContEmulIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
              .createWindPitchContEmulIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindPitchContEmulIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindPitchContEmulIEC windPitchContEmulIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindPitchContEmulIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindPitchContEmulIECCommand
      // -----------------------------------------------
      completableFuture =
          WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
              .updateWindPitchContEmulIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindPitchContEmulIECController:update() - successfully update WindPitchContEmulIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindPitchContEmulIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windPitchContEmulIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindPitchContEmulIECCommand command =
        new DeleteWindPitchContEmulIECCommand(windPitchContEmulIECId);

    try {
      WindPitchContEmulIECBusinessDelegate delegate =
          WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindPitchContEmulIEC with key "
              + command.getWindPitchContEmulIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kdroop on WindPitchContEmulIEC
   *
   * @param command AssignKdroopToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignKdroop")
  public void assignKdroop(@RequestBody AssignKdroopToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().assignKdroop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdroop", exc);
    }
  }

  /**
   * unassign Kdroop on WindPitchContEmulIEC
   *
   * @param command UnAssignKdroopFromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignKdroop")
  public void unAssignKdroop(
      @RequestBody(required = true) UnAssignKdroopFromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
          .unAssignKdroop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdroop", exc);
    }
  }

  /**
   * save Kipce on WindPitchContEmulIEC
   *
   * @param command AssignKipceToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignKipce")
  public void assignKipce(@RequestBody AssignKipceToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().assignKipce(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kipce", exc);
    }
  }

  /**
   * unassign Kipce on WindPitchContEmulIEC
   *
   * @param command UnAssignKipceFromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignKipce")
  public void unAssignKipce(
      @RequestBody(required = true) UnAssignKipceFromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().unAssignKipce(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kipce", exc);
    }
  }

  /**
   * save Komegaaero on WindPitchContEmulIEC
   *
   * @param command AssignKomegaaeroToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignKomegaaero")
  public void assignKomegaaero(@RequestBody AssignKomegaaeroToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
          .assignKomegaaero(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Komegaaero", exc);
    }
  }

  /**
   * unassign Komegaaero on WindPitchContEmulIEC
   *
   * @param command UnAssignKomegaaeroFromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignKomegaaero")
  public void unAssignKomegaaero(
      @RequestBody(required = true) UnAssignKomegaaeroFromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
          .unAssignKomegaaero(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Komegaaero", exc);
    }
  }

  /**
   * save Kppce on WindPitchContEmulIEC
   *
   * @param command AssignKppceToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignKppce")
  public void assignKppce(@RequestBody AssignKppceToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().assignKppce(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kppce", exc);
    }
  }

  /**
   * unassign Kppce on WindPitchContEmulIEC
   *
   * @param command UnAssignKppceFromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignKppce")
  public void unAssignKppce(
      @RequestBody(required = true) UnAssignKppceFromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().unAssignKppce(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kppce", exc);
    }
  }

  /**
   * save Omegaref on WindPitchContEmulIEC
   *
   * @param command AssignOmegarefToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignOmegaref")
  public void assignOmegaref(@RequestBody AssignOmegarefToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
          .assignOmegaref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Omegaref", exc);
    }
  }

  /**
   * unassign Omegaref on WindPitchContEmulIEC
   *
   * @param command UnAssignOmegarefFromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignOmegaref")
  public void unAssignOmegaref(
      @RequestBody(required = true) UnAssignOmegarefFromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
          .unAssignOmegaref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Omegaref", exc);
    }
  }

  /**
   * save Pimax on WindPitchContEmulIEC
   *
   * @param command AssignPimaxToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignPimax")
  public void assignPimax(@RequestBody AssignPimaxToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().assignPimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pimax", exc);
    }
  }

  /**
   * unassign Pimax on WindPitchContEmulIEC
   *
   * @param command UnAssignPimaxFromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignPimax")
  public void unAssignPimax(
      @RequestBody(required = true) UnAssignPimaxFromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().unAssignPimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pimax", exc);
    }
  }

  /**
   * save Pimin on WindPitchContEmulIEC
   *
   * @param command AssignPiminToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignPimin")
  public void assignPimin(@RequestBody AssignPiminToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().assignPimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pimin", exc);
    }
  }

  /**
   * unassign Pimin on WindPitchContEmulIEC
   *
   * @param command UnAssignPiminFromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignPimin")
  public void unAssignPimin(
      @RequestBody(required = true) UnAssignPiminFromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().unAssignPimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pimin", exc);
    }
  }

  /**
   * save T1 on WindPitchContEmulIEC
   *
   * @param command AssignT1ToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on WindPitchContEmulIEC
   *
   * @param command UnAssignT1FromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(
      @RequestBody(required = true) UnAssignT1FromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on WindPitchContEmulIEC
   *
   * @param command AssignT2ToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on WindPitchContEmulIEC
   *
   * @param command UnAssignT2FromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(
      @RequestBody(required = true) UnAssignT2FromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save Tpe on WindPitchContEmulIEC
   *
   * @param command AssignTpeToWindPitchContEmulIECCommand
   */
  @PutMapping("/assignTpe")
  public void assignTpe(@RequestBody AssignTpeToWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().assignTpe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpe", exc);
    }
  }

  /**
   * unassign Tpe on WindPitchContEmulIEC
   *
   * @param command UnAssignTpeFromWindPitchContEmulIECCommand
   */
  @PutMapping("/unAssignTpe")
  public void unAssignTpe(
      @RequestBody(required = true) UnAssignTpeFromWindPitchContEmulIECCommand command) {
    try {
      WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().unAssignTpe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpe", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindPitchContEmulIEC windPitchContEmulIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPitchContEmulIECCommandRestController.class.getName());
}
