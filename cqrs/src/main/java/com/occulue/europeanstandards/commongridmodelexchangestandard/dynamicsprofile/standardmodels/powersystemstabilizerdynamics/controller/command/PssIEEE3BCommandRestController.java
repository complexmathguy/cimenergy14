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
 * Implements Spring Controller command CQRS processing for entity PssIEEE3B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE3B")
public class PssIEEE3BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssIEEE3B. if not key provided, calls create, otherwise calls save
   *
   * @param PssIEEE3B pssIEEE3B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePssIEEE3BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().createPssIEEE3B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssIEEE3B. if no key provided, calls create, otherwise calls save
   *
   * @param PssIEEE3B pssIEEE3B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePssIEEE3BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssIEEE3BCommand
      // -----------------------------------------------
      completableFuture = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().updatePssIEEE3B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssIEEE3BController:update() - successfully update PssIEEE3B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssIEEE3B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssIEEE3BId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssIEEE3BCommand command = new DeletePssIEEE3BCommand(pssIEEE3BId);

    try {
      PssIEEE3BBusinessDelegate delegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted PssIEEE3B with key " + command.getPssIEEE3BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A1 on PssIEEE3B
   *
   * @param command AssignA1ToPssIEEE3BCommand
   */
  @PutMapping("/assignA1")
  public void assignA1(@RequestBody AssignA1ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignA1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A1", exc);
    }
  }

  /**
   * unassign A1 on PssIEEE3B
   *
   * @param command UnAssignA1FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignA1")
  public void unAssignA1(@RequestBody(required = true) UnAssignA1FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignA1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A1", exc);
    }
  }

  /**
   * save A2 on PssIEEE3B
   *
   * @param command AssignA2ToPssIEEE3BCommand
   */
  @PutMapping("/assignA2")
  public void assignA2(@RequestBody AssignA2ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignA2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A2", exc);
    }
  }

  /**
   * unassign A2 on PssIEEE3B
   *
   * @param command UnAssignA2FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignA2")
  public void unAssignA2(@RequestBody(required = true) UnAssignA2FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignA2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A2", exc);
    }
  }

  /**
   * save A3 on PssIEEE3B
   *
   * @param command AssignA3ToPssIEEE3BCommand
   */
  @PutMapping("/assignA3")
  public void assignA3(@RequestBody AssignA3ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignA3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A3", exc);
    }
  }

  /**
   * unassign A3 on PssIEEE3B
   *
   * @param command UnAssignA3FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignA3")
  public void unAssignA3(@RequestBody(required = true) UnAssignA3FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignA3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A3", exc);
    }
  }

  /**
   * save A4 on PssIEEE3B
   *
   * @param command AssignA4ToPssIEEE3BCommand
   */
  @PutMapping("/assignA4")
  public void assignA4(@RequestBody AssignA4ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignA4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A4", exc);
    }
  }

  /**
   * unassign A4 on PssIEEE3B
   *
   * @param command UnAssignA4FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignA4")
  public void unAssignA4(@RequestBody(required = true) UnAssignA4FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignA4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A4", exc);
    }
  }

  /**
   * save A5 on PssIEEE3B
   *
   * @param command AssignA5ToPssIEEE3BCommand
   */
  @PutMapping("/assignA5")
  public void assignA5(@RequestBody AssignA5ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignA5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A5", exc);
    }
  }

  /**
   * unassign A5 on PssIEEE3B
   *
   * @param command UnAssignA5FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignA5")
  public void unAssignA5(@RequestBody(required = true) UnAssignA5FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignA5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A5", exc);
    }
  }

  /**
   * save A6 on PssIEEE3B
   *
   * @param command AssignA6ToPssIEEE3BCommand
   */
  @PutMapping("/assignA6")
  public void assignA6(@RequestBody AssignA6ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignA6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A6", exc);
    }
  }

  /**
   * unassign A6 on PssIEEE3B
   *
   * @param command UnAssignA6FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignA6")
  public void unAssignA6(@RequestBody(required = true) UnAssignA6FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignA6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A6", exc);
    }
  }

  /**
   * save A7 on PssIEEE3B
   *
   * @param command AssignA7ToPssIEEE3BCommand
   */
  @PutMapping("/assignA7")
  public void assignA7(@RequestBody AssignA7ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignA7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A7", exc);
    }
  }

  /**
   * unassign A7 on PssIEEE3B
   *
   * @param command UnAssignA7FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignA7")
  public void unAssignA7(@RequestBody(required = true) UnAssignA7FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignA7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A7", exc);
    }
  }

  /**
   * save A8 on PssIEEE3B
   *
   * @param command AssignA8ToPssIEEE3BCommand
   */
  @PutMapping("/assignA8")
  public void assignA8(@RequestBody AssignA8ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignA8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A8", exc);
    }
  }

  /**
   * unassign A8 on PssIEEE3B
   *
   * @param command UnAssignA8FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignA8")
  public void unAssignA8(@RequestBody(required = true) UnAssignA8FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignA8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A8", exc);
    }
  }

  /**
   * save Ks1 on PssIEEE3B
   *
   * @param command AssignKs1ToPssIEEE3BCommand
   */
  @PutMapping("/assignKs1")
  public void assignKs1(@RequestBody AssignKs1ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignKs1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks1", exc);
    }
  }

  /**
   * unassign Ks1 on PssIEEE3B
   *
   * @param command UnAssignKs1FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignKs1")
  public void unAssignKs1(@RequestBody(required = true) UnAssignKs1FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignKs1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks1", exc);
    }
  }

  /**
   * save Ks2 on PssIEEE3B
   *
   * @param command AssignKs2ToPssIEEE3BCommand
   */
  @PutMapping("/assignKs2")
  public void assignKs2(@RequestBody AssignKs2ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignKs2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks2", exc);
    }
  }

  /**
   * unassign Ks2 on PssIEEE3B
   *
   * @param command UnAssignKs2FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignKs2")
  public void unAssignKs2(@RequestBody(required = true) UnAssignKs2FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignKs2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks2", exc);
    }
  }

  /**
   * save T1 on PssIEEE3B
   *
   * @param command AssignT1ToPssIEEE3BCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on PssIEEE3B
   *
   * @param command UnAssignT1FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on PssIEEE3B
   *
   * @param command AssignT2ToPssIEEE3BCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on PssIEEE3B
   *
   * @param command UnAssignT2FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save Tw1 on PssIEEE3B
   *
   * @param command AssignTw1ToPssIEEE3BCommand
   */
  @PutMapping("/assignTw1")
  public void assignTw1(@RequestBody AssignTw1ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignTw1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw1", exc);
    }
  }

  /**
   * unassign Tw1 on PssIEEE3B
   *
   * @param command UnAssignTw1FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignTw1")
  public void unAssignTw1(@RequestBody(required = true) UnAssignTw1FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignTw1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw1", exc);
    }
  }

  /**
   * save Tw2 on PssIEEE3B
   *
   * @param command AssignTw2ToPssIEEE3BCommand
   */
  @PutMapping("/assignTw2")
  public void assignTw2(@RequestBody AssignTw2ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignTw2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw2", exc);
    }
  }

  /**
   * unassign Tw2 on PssIEEE3B
   *
   * @param command UnAssignTw2FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignTw2")
  public void unAssignTw2(@RequestBody(required = true) UnAssignTw2FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignTw2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw2", exc);
    }
  }

  /**
   * save Tw3 on PssIEEE3B
   *
   * @param command AssignTw3ToPssIEEE3BCommand
   */
  @PutMapping("/assignTw3")
  public void assignTw3(@RequestBody AssignTw3ToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignTw3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw3", exc);
    }
  }

  /**
   * unassign Tw3 on PssIEEE3B
   *
   * @param command UnAssignTw3FromPssIEEE3BCommand
   */
  @PutMapping("/unAssignTw3")
  public void unAssignTw3(@RequestBody(required = true) UnAssignTw3FromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignTw3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw3", exc);
    }
  }

  /**
   * save Vstmax on PssIEEE3B
   *
   * @param command AssignVstmaxToPssIEEE3BCommand
   */
  @PutMapping("/assignVstmax")
  public void assignVstmax(@RequestBody AssignVstmaxToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignVstmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vstmax", exc);
    }
  }

  /**
   * unassign Vstmax on PssIEEE3B
   *
   * @param command UnAssignVstmaxFromPssIEEE3BCommand
   */
  @PutMapping("/unAssignVstmax")
  public void unAssignVstmax(
      @RequestBody(required = true) UnAssignVstmaxFromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignVstmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vstmax", exc);
    }
  }

  /**
   * save Vstmin on PssIEEE3B
   *
   * @param command AssignVstminToPssIEEE3BCommand
   */
  @PutMapping("/assignVstmin")
  public void assignVstmin(@RequestBody AssignVstminToPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().assignVstmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vstmin", exc);
    }
  }

  /**
   * unassign Vstmin on PssIEEE3B
   *
   * @param command UnAssignVstminFromPssIEEE3BCommand
   */
  @PutMapping("/unAssignVstmin")
  public void unAssignVstmin(
      @RequestBody(required = true) UnAssignVstminFromPssIEEE3BCommand command) {
    try {
      PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().unAssignVstmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vstmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssIEEE3B pssIEEE3B = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssIEEE3BCommandRestController.class.getName());
}
