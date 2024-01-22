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
 * Implements Spring Controller command CQRS processing for entity PssSB4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSB4")
public class PssSB4CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssSB4. if not key provided, calls create, otherwise calls save
   *
   * @param PssSB4 pssSB4
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePssSB4Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssSB4BusinessDelegate.getPssSB4Instance().createPssSB4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssSB4. if no key provided, calls create, otherwise calls save
   *
   * @param PssSB4 pssSB4
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePssSB4Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssSB4Command
      // -----------------------------------------------
      completableFuture = PssSB4BusinessDelegate.getPssSB4Instance().updatePssSB4(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssSB4Controller:update() - successfully update PssSB4 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssSB4 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssSB4Id) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssSB4Command command = new DeletePssSB4Command(pssSB4Id);

    try {
      PssSB4BusinessDelegate delegate = PssSB4BusinessDelegate.getPssSB4Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted PssSB4 with key " + command.getPssSB4Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kx on PssSB4
   *
   * @param command AssignKxToPssSB4Command
   */
  @PutMapping("/assignKx")
  public void assignKx(@RequestBody AssignKxToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignKx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kx", exc);
    }
  }

  /**
   * unassign Kx on PssSB4
   *
   * @param command UnAssignKxFromPssSB4Command
   */
  @PutMapping("/unAssignKx")
  public void unAssignKx(@RequestBody(required = true) UnAssignKxFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignKx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kx", exc);
    }
  }

  /**
   * save Ta on PssSB4
   *
   * @param command AssignTaToPssSB4Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on PssSB4
   *
   * @param command UnAssignTaFromPssSB4Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on PssSB4
   *
   * @param command AssignTbToPssSB4Command
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on PssSB4
   *
   * @param command UnAssignTbFromPssSB4Command
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on PssSB4
   *
   * @param command AssignTcToPssSB4Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on PssSB4
   *
   * @param command UnAssignTcFromPssSB4Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Td on PssSB4
   *
   * @param command AssignTdToPssSB4Command
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on PssSB4
   *
   * @param command UnAssignTdFromPssSB4Command
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Te on PssSB4
   *
   * @param command AssignTeToPssSB4Command
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on PssSB4
   *
   * @param command UnAssignTeFromPssSB4Command
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tt on PssSB4
   *
   * @param command AssignTtToPssSB4Command
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on PssSB4
   *
   * @param command UnAssignTtFromPssSB4Command
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  /**
   * save Tx1 on PssSB4
   *
   * @param command AssignTx1ToPssSB4Command
   */
  @PutMapping("/assignTx1")
  public void assignTx1(@RequestBody AssignTx1ToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignTx1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tx1", exc);
    }
  }

  /**
   * unassign Tx1 on PssSB4
   *
   * @param command UnAssignTx1FromPssSB4Command
   */
  @PutMapping("/unAssignTx1")
  public void unAssignTx1(@RequestBody(required = true) UnAssignTx1FromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignTx1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tx1", exc);
    }
  }

  /**
   * save Tx2 on PssSB4
   *
   * @param command AssignTx2ToPssSB4Command
   */
  @PutMapping("/assignTx2")
  public void assignTx2(@RequestBody AssignTx2ToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignTx2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tx2", exc);
    }
  }

  /**
   * unassign Tx2 on PssSB4
   *
   * @param command UnAssignTx2FromPssSB4Command
   */
  @PutMapping("/unAssignTx2")
  public void unAssignTx2(@RequestBody(required = true) UnAssignTx2FromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignTx2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tx2", exc);
    }
  }

  /**
   * save Vsmax on PssSB4
   *
   * @param command AssignVsmaxToPssSB4Command
   */
  @PutMapping("/assignVsmax")
  public void assignVsmax(@RequestBody AssignVsmaxToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignVsmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmax", exc);
    }
  }

  /**
   * unassign Vsmax on PssSB4
   *
   * @param command UnAssignVsmaxFromPssSB4Command
   */
  @PutMapping("/unAssignVsmax")
  public void unAssignVsmax(@RequestBody(required = true) UnAssignVsmaxFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignVsmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmax", exc);
    }
  }

  /**
   * save Vsmin on PssSB4
   *
   * @param command AssignVsminToPssSB4Command
   */
  @PutMapping("/assignVsmin")
  public void assignVsmin(@RequestBody AssignVsminToPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().assignVsmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmin", exc);
    }
  }

  /**
   * unassign Vsmin on PssSB4
   *
   * @param command UnAssignVsminFromPssSB4Command
   */
  @PutMapping("/unAssignVsmin")
  public void unAssignVsmin(@RequestBody(required = true) UnAssignVsminFromPssSB4Command command) {
    try {
      PssSB4BusinessDelegate.getPssSB4Instance().unAssignVsmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssSB4 pssSB4 = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssSB4CommandRestController.class.getName());
}
