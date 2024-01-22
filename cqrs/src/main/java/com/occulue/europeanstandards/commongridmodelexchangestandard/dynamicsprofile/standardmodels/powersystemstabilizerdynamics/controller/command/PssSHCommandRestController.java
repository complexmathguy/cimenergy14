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
 * Implements Spring Controller command CQRS processing for entity PssSH.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSH")
public class PssSHCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssSH. if not key provided, calls create, otherwise calls save
   *
   * @param PssSH pssSH
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePssSHCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssSHBusinessDelegate.getPssSHInstance().createPssSH(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssSH. if no key provided, calls create, otherwise calls save
   *
   * @param PssSH pssSH
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePssSHCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssSHCommand
      // -----------------------------------------------
      completableFuture = PssSHBusinessDelegate.getPssSHInstance().updatePssSH(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssSHController:update() - successfully update PssSH - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssSH entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssSHId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssSHCommand command = new DeletePssSHCommand(pssSHId);

    try {
      PssSHBusinessDelegate delegate = PssSHBusinessDelegate.getPssSHInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted PssSH with key " + command.getPssSHId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K on PssSH
   *
   * @param command AssignKToPssSHCommand
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on PssSH
   *
   * @param command UnAssignKFromPssSHCommand
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save K0 on PssSH
   *
   * @param command AssignK0ToPssSHCommand
   */
  @PutMapping("/assignK0")
  public void assignK0(@RequestBody AssignK0ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignK0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K0", exc);
    }
  }

  /**
   * unassign K0 on PssSH
   *
   * @param command UnAssignK0FromPssSHCommand
   */
  @PutMapping("/unAssignK0")
  public void unAssignK0(@RequestBody(required = true) UnAssignK0FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignK0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K0", exc);
    }
  }

  /**
   * save K1 on PssSH
   *
   * @param command AssignK1ToPssSHCommand
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on PssSH
   *
   * @param command UnAssignK1FromPssSHCommand
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on PssSH
   *
   * @param command AssignK2ToPssSHCommand
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on PssSH
   *
   * @param command UnAssignK2FromPssSHCommand
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save K3 on PssSH
   *
   * @param command AssignK3ToPssSHCommand
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on PssSH
   *
   * @param command UnAssignK3FromPssSHCommand
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save K4 on PssSH
   *
   * @param command AssignK4ToPssSHCommand
   */
  @PutMapping("/assignK4")
  public void assignK4(@RequestBody AssignK4ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignK4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K4", exc);
    }
  }

  /**
   * unassign K4 on PssSH
   *
   * @param command UnAssignK4FromPssSHCommand
   */
  @PutMapping("/unAssignK4")
  public void unAssignK4(@RequestBody(required = true) UnAssignK4FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignK4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K4", exc);
    }
  }

  /**
   * save T1 on PssSH
   *
   * @param command AssignT1ToPssSHCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on PssSH
   *
   * @param command UnAssignT1FromPssSHCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on PssSH
   *
   * @param command AssignT2ToPssSHCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on PssSH
   *
   * @param command UnAssignT2FromPssSHCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on PssSH
   *
   * @param command AssignT3ToPssSHCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on PssSH
   *
   * @param command UnAssignT3FromPssSHCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on PssSH
   *
   * @param command AssignT4ToPssSHCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on PssSH
   *
   * @param command UnAssignT4FromPssSHCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save Td on PssSH
   *
   * @param command AssignTdToPssSHCommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on PssSH
   *
   * @param command UnAssignTdFromPssSHCommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Vsmax on PssSH
   *
   * @param command AssignVsmaxToPssSHCommand
   */
  @PutMapping("/assignVsmax")
  public void assignVsmax(@RequestBody AssignVsmaxToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignVsmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmax", exc);
    }
  }

  /**
   * unassign Vsmax on PssSH
   *
   * @param command UnAssignVsmaxFromPssSHCommand
   */
  @PutMapping("/unAssignVsmax")
  public void unAssignVsmax(@RequestBody(required = true) UnAssignVsmaxFromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignVsmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmax", exc);
    }
  }

  /**
   * save Vsmin on PssSH
   *
   * @param command AssignVsminToPssSHCommand
   */
  @PutMapping("/assignVsmin")
  public void assignVsmin(@RequestBody AssignVsminToPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().assignVsmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmin", exc);
    }
  }

  /**
   * unassign Vsmin on PssSH
   *
   * @param command UnAssignVsminFromPssSHCommand
   */
  @PutMapping("/unAssignVsmin")
  public void unAssignVsmin(@RequestBody(required = true) UnAssignVsminFromPssSHCommand command) {
    try {
      PssSHBusinessDelegate.getPssSHInstance().unAssignVsmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssSH pssSH = null;
  private static final Logger LOGGER = Logger.getLogger(PssSHCommandRestController.class.getName());
}
