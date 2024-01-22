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
 * Implements Spring Controller command CQRS processing for entity Pss5.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss5")
public class Pss5CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Pss5. if not key provided, calls create, otherwise calls save
   *
   * @param Pss5 pss5
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePss5Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = Pss5BusinessDelegate.getPss5Instance().createPss5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Pss5. if no key provided, calls create, otherwise calls save
   *
   * @param Pss5 pss5
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePss5Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePss5Command
      // -----------------------------------------------
      completableFuture = Pss5BusinessDelegate.getPss5Instance().updatePss5(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "Pss5Controller:update() - successfully update Pss5 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Pss5 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pss5Id) {
    CompletableFuture<Void> completableFuture = null;
    DeletePss5Command command = new DeletePss5Command(pss5Id);

    try {
      Pss5BusinessDelegate delegate = Pss5BusinessDelegate.getPss5Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Pss5 with key " + command.getPss5Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ctw2 on Pss5
   *
   * @param command AssignCtw2ToPss5Command
   */
  @PutMapping("/assignCtw2")
  public void assignCtw2(@RequestBody AssignCtw2ToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignCtw2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ctw2", exc);
    }
  }

  /**
   * unassign Ctw2 on Pss5
   *
   * @param command UnAssignCtw2FromPss5Command
   */
  @PutMapping("/unAssignCtw2")
  public void unAssignCtw2(@RequestBody(required = true) UnAssignCtw2FromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignCtw2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ctw2", exc);
    }
  }

  /**
   * save Deadband on Pss5
   *
   * @param command AssignDeadbandToPss5Command
   */
  @PutMapping("/assignDeadband")
  public void assignDeadband(@RequestBody AssignDeadbandToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignDeadband(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Deadband", exc);
    }
  }

  /**
   * unassign Deadband on Pss5
   *
   * @param command UnAssignDeadbandFromPss5Command
   */
  @PutMapping("/unAssignDeadband")
  public void unAssignDeadband(
      @RequestBody(required = true) UnAssignDeadbandFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignDeadband(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Deadband", exc);
    }
  }

  /**
   * save Isfreq on Pss5
   *
   * @param command AssignIsfreqToPss5Command
   */
  @PutMapping("/assignIsfreq")
  public void assignIsfreq(@RequestBody AssignIsfreqToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignIsfreq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Isfreq", exc);
    }
  }

  /**
   * unassign Isfreq on Pss5
   *
   * @param command UnAssignIsfreqFromPss5Command
   */
  @PutMapping("/unAssignIsfreq")
  public void unAssignIsfreq(@RequestBody(required = true) UnAssignIsfreqFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignIsfreq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Isfreq", exc);
    }
  }

  /**
   * save Kf on Pss5
   *
   * @param command AssignKfToPss5Command
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on Pss5
   *
   * @param command UnAssignKfFromPss5Command
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Kpe on Pss5
   *
   * @param command AssignKpeToPss5Command
   */
  @PutMapping("/assignKpe")
  public void assignKpe(@RequestBody AssignKpeToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignKpe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpe", exc);
    }
  }

  /**
   * unassign Kpe on Pss5
   *
   * @param command UnAssignKpeFromPss5Command
   */
  @PutMapping("/unAssignKpe")
  public void unAssignKpe(@RequestBody(required = true) UnAssignKpeFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignKpe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpe", exc);
    }
  }

  /**
   * save Kpss on Pss5
   *
   * @param command AssignKpssToPss5Command
   */
  @PutMapping("/assignKpss")
  public void assignKpss(@RequestBody AssignKpssToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignKpss(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpss", exc);
    }
  }

  /**
   * unassign Kpss on Pss5
   *
   * @param command UnAssignKpssFromPss5Command
   */
  @PutMapping("/unAssignKpss")
  public void unAssignKpss(@RequestBody(required = true) UnAssignKpssFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignKpss(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpss", exc);
    }
  }

  /**
   * save Pmm on Pss5
   *
   * @param command AssignPmmToPss5Command
   */
  @PutMapping("/assignPmm")
  public void assignPmm(@RequestBody AssignPmmToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignPmm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmm", exc);
    }
  }

  /**
   * unassign Pmm on Pss5
   *
   * @param command UnAssignPmmFromPss5Command
   */
  @PutMapping("/unAssignPmm")
  public void unAssignPmm(@RequestBody(required = true) UnAssignPmmFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignPmm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmm", exc);
    }
  }

  /**
   * save Tl1 on Pss5
   *
   * @param command AssignTl1ToPss5Command
   */
  @PutMapping("/assignTl1")
  public void assignTl1(@RequestBody AssignTl1ToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignTl1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl1", exc);
    }
  }

  /**
   * unassign Tl1 on Pss5
   *
   * @param command UnAssignTl1FromPss5Command
   */
  @PutMapping("/unAssignTl1")
  public void unAssignTl1(@RequestBody(required = true) UnAssignTl1FromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignTl1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl1", exc);
    }
  }

  /**
   * save Tl2 on Pss5
   *
   * @param command AssignTl2ToPss5Command
   */
  @PutMapping("/assignTl2")
  public void assignTl2(@RequestBody AssignTl2ToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignTl2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl2", exc);
    }
  }

  /**
   * unassign Tl2 on Pss5
   *
   * @param command UnAssignTl2FromPss5Command
   */
  @PutMapping("/unAssignTl2")
  public void unAssignTl2(@RequestBody(required = true) UnAssignTl2FromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignTl2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl2", exc);
    }
  }

  /**
   * save Tl3 on Pss5
   *
   * @param command AssignTl3ToPss5Command
   */
  @PutMapping("/assignTl3")
  public void assignTl3(@RequestBody AssignTl3ToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignTl3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl3", exc);
    }
  }

  /**
   * unassign Tl3 on Pss5
   *
   * @param command UnAssignTl3FromPss5Command
   */
  @PutMapping("/unAssignTl3")
  public void unAssignTl3(@RequestBody(required = true) UnAssignTl3FromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignTl3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl3", exc);
    }
  }

  /**
   * save Tl4 on Pss5
   *
   * @param command AssignTl4ToPss5Command
   */
  @PutMapping("/assignTl4")
  public void assignTl4(@RequestBody AssignTl4ToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignTl4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl4", exc);
    }
  }

  /**
   * unassign Tl4 on Pss5
   *
   * @param command UnAssignTl4FromPss5Command
   */
  @PutMapping("/unAssignTl4")
  public void unAssignTl4(@RequestBody(required = true) UnAssignTl4FromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignTl4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl4", exc);
    }
  }

  /**
   * save Tpe on Pss5
   *
   * @param command AssignTpeToPss5Command
   */
  @PutMapping("/assignTpe")
  public void assignTpe(@RequestBody AssignTpeToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignTpe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpe", exc);
    }
  }

  /**
   * unassign Tpe on Pss5
   *
   * @param command UnAssignTpeFromPss5Command
   */
  @PutMapping("/unAssignTpe")
  public void unAssignTpe(@RequestBody(required = true) UnAssignTpeFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignTpe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpe", exc);
    }
  }

  /**
   * save Tw1 on Pss5
   *
   * @param command AssignTw1ToPss5Command
   */
  @PutMapping("/assignTw1")
  public void assignTw1(@RequestBody AssignTw1ToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignTw1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw1", exc);
    }
  }

  /**
   * unassign Tw1 on Pss5
   *
   * @param command UnAssignTw1FromPss5Command
   */
  @PutMapping("/unAssignTw1")
  public void unAssignTw1(@RequestBody(required = true) UnAssignTw1FromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignTw1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw1", exc);
    }
  }

  /**
   * save Tw2 on Pss5
   *
   * @param command AssignTw2ToPss5Command
   */
  @PutMapping("/assignTw2")
  public void assignTw2(@RequestBody AssignTw2ToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignTw2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw2", exc);
    }
  }

  /**
   * unassign Tw2 on Pss5
   *
   * @param command UnAssignTw2FromPss5Command
   */
  @PutMapping("/unAssignTw2")
  public void unAssignTw2(@RequestBody(required = true) UnAssignTw2FromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignTw2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw2", exc);
    }
  }

  /**
   * save Vadat on Pss5
   *
   * @param command AssignVadatToPss5Command
   */
  @PutMapping("/assignVadat")
  public void assignVadat(@RequestBody AssignVadatToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignVadat(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vadat", exc);
    }
  }

  /**
   * unassign Vadat on Pss5
   *
   * @param command UnAssignVadatFromPss5Command
   */
  @PutMapping("/unAssignVadat")
  public void unAssignVadat(@RequestBody(required = true) UnAssignVadatFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignVadat(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vadat", exc);
    }
  }

  /**
   * save Vsmn on Pss5
   *
   * @param command AssignVsmnToPss5Command
   */
  @PutMapping("/assignVsmn")
  public void assignVsmn(@RequestBody AssignVsmnToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignVsmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmn", exc);
    }
  }

  /**
   * unassign Vsmn on Pss5
   *
   * @param command UnAssignVsmnFromPss5Command
   */
  @PutMapping("/unAssignVsmn")
  public void unAssignVsmn(@RequestBody(required = true) UnAssignVsmnFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignVsmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmn", exc);
    }
  }

  /**
   * save Vsmx on Pss5
   *
   * @param command AssignVsmxToPss5Command
   */
  @PutMapping("/assignVsmx")
  public void assignVsmx(@RequestBody AssignVsmxToPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().assignVsmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmx", exc);
    }
  }

  /**
   * unassign Vsmx on Pss5
   *
   * @param command UnAssignVsmxFromPss5Command
   */
  @PutMapping("/unAssignVsmx")
  public void unAssignVsmx(@RequestBody(required = true) UnAssignVsmxFromPss5Command command) {
    try {
      Pss5BusinessDelegate.getPss5Instance().unAssignVsmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmx", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Pss5 pss5 = null;
  private static final Logger LOGGER = Logger.getLogger(Pss5CommandRestController.class.getName());
}
