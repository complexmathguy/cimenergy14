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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PssPTIST1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssPTIST1")
public class PssPTIST1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssPTIST1. if not key provided, calls create, otherwise calls save
   *
   * @param PssPTIST1 pssPTIST1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePssPTIST1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssPTIST1BusinessDelegate.getPssPTIST1Instance().createPssPTIST1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssPTIST1. if no key provided, calls create, otherwise calls save
   *
   * @param PssPTIST1 pssPTIST1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePssPTIST1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssPTIST1Command
      // -----------------------------------------------
      completableFuture = PssPTIST1BusinessDelegate.getPssPTIST1Instance().updatePssPTIST1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssPTIST1Controller:update() - successfully update PssPTIST1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssPTIST1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssPTIST1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssPTIST1Command command = new DeletePssPTIST1Command(pssPTIST1Id);

    try {
      PssPTIST1BusinessDelegate delegate = PssPTIST1BusinessDelegate.getPssPTIST1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted PssPTIST1 with key " + command.getPssPTIST1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dtc on PssPTIST1
   *
   * @param command AssignDtcToPssPTIST1Command
   */
  @PutMapping("/assignDtc")
  public void assignDtc(@RequestBody AssignDtcToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignDtc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dtc", exc);
    }
  }

  /**
   * unassign Dtc on PssPTIST1
   *
   * @param command UnAssignDtcFromPssPTIST1Command
   */
  @PutMapping("/unAssignDtc")
  public void unAssignDtc(@RequestBody(required = true) UnAssignDtcFromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignDtc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dtc", exc);
    }
  }

  /**
   * save Dtf on PssPTIST1
   *
   * @param command AssignDtfToPssPTIST1Command
   */
  @PutMapping("/assignDtf")
  public void assignDtf(@RequestBody AssignDtfToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignDtf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dtf", exc);
    }
  }

  /**
   * unassign Dtf on PssPTIST1
   *
   * @param command UnAssignDtfFromPssPTIST1Command
   */
  @PutMapping("/unAssignDtf")
  public void unAssignDtf(@RequestBody(required = true) UnAssignDtfFromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignDtf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dtf", exc);
    }
  }

  /**
   * save Dtp on PssPTIST1
   *
   * @param command AssignDtpToPssPTIST1Command
   */
  @PutMapping("/assignDtp")
  public void assignDtp(@RequestBody AssignDtpToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignDtp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dtp", exc);
    }
  }

  /**
   * unassign Dtp on PssPTIST1
   *
   * @param command UnAssignDtpFromPssPTIST1Command
   */
  @PutMapping("/unAssignDtp")
  public void unAssignDtp(@RequestBody(required = true) UnAssignDtpFromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignDtp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dtp", exc);
    }
  }

  /**
   * save K on PssPTIST1
   *
   * @param command AssignKToPssPTIST1Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on PssPTIST1
   *
   * @param command UnAssignKFromPssPTIST1Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save M on PssPTIST1
   *
   * @param command AssignMToPssPTIST1Command
   */
  @PutMapping("/assignM")
  public void assignM(@RequestBody AssignMToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignM(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign M", exc);
    }
  }

  /**
   * unassign M on PssPTIST1
   *
   * @param command UnAssignMFromPssPTIST1Command
   */
  @PutMapping("/unAssignM")
  public void unAssignM(@RequestBody(required = true) UnAssignMFromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignM(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign M", exc);
    }
  }

  /**
   * save T1 on PssPTIST1
   *
   * @param command AssignT1ToPssPTIST1Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on PssPTIST1
   *
   * @param command UnAssignT1FromPssPTIST1Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on PssPTIST1
   *
   * @param command AssignT2ToPssPTIST1Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on PssPTIST1
   *
   * @param command UnAssignT2FromPssPTIST1Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on PssPTIST1
   *
   * @param command AssignT3ToPssPTIST1Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on PssPTIST1
   *
   * @param command UnAssignT3FromPssPTIST1Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on PssPTIST1
   *
   * @param command AssignT4ToPssPTIST1Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on PssPTIST1
   *
   * @param command UnAssignT4FromPssPTIST1Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save Tf on PssPTIST1
   *
   * @param command AssignTfToPssPTIST1Command
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on PssPTIST1
   *
   * @param command UnAssignTfFromPssPTIST1Command
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tp on PssPTIST1
   *
   * @param command AssignTpToPssPTIST1Command
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on PssPTIST1
   *
   * @param command UnAssignTpFromPssPTIST1Command
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromPssPTIST1Command command) {
    try {
      PssPTIST1BusinessDelegate.getPssPTIST1Instance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssPTIST1 pssPTIST1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssPTIST1CommandRestController.class.getName());
}
