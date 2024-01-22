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
 * Implements Spring Controller command CQRS processing for entity PssIEEE2B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE2B")
public class PssIEEE2BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssIEEE2B. if not key provided, calls create, otherwise calls save
   *
   * @param PssIEEE2B pssIEEE2B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePssIEEE2BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().createPssIEEE2B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssIEEE2B. if no key provided, calls create, otherwise calls save
   *
   * @param PssIEEE2B pssIEEE2B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePssIEEE2BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssIEEE2BCommand
      // -----------------------------------------------
      completableFuture = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().updatePssIEEE2B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssIEEE2BController:update() - successfully update PssIEEE2B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssIEEE2B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssIEEE2BId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssIEEE2BCommand command = new DeletePssIEEE2BCommand(pssIEEE2BId);

    try {
      PssIEEE2BBusinessDelegate delegate = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted PssIEEE2B with key " + command.getPssIEEE2BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ks1 on PssIEEE2B
   *
   * @param command AssignKs1ToPssIEEE2BCommand
   */
  @PutMapping("/assignKs1")
  public void assignKs1(@RequestBody AssignKs1ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignKs1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks1", exc);
    }
  }

  /**
   * unassign Ks1 on PssIEEE2B
   *
   * @param command UnAssignKs1FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignKs1")
  public void unAssignKs1(@RequestBody(required = true) UnAssignKs1FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignKs1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks1", exc);
    }
  }

  /**
   * save Ks2 on PssIEEE2B
   *
   * @param command AssignKs2ToPssIEEE2BCommand
   */
  @PutMapping("/assignKs2")
  public void assignKs2(@RequestBody AssignKs2ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignKs2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks2", exc);
    }
  }

  /**
   * unassign Ks2 on PssIEEE2B
   *
   * @param command UnAssignKs2FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignKs2")
  public void unAssignKs2(@RequestBody(required = true) UnAssignKs2FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignKs2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks2", exc);
    }
  }

  /**
   * save Ks3 on PssIEEE2B
   *
   * @param command AssignKs3ToPssIEEE2BCommand
   */
  @PutMapping("/assignKs3")
  public void assignKs3(@RequestBody AssignKs3ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignKs3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks3", exc);
    }
  }

  /**
   * unassign Ks3 on PssIEEE2B
   *
   * @param command UnAssignKs3FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignKs3")
  public void unAssignKs3(@RequestBody(required = true) UnAssignKs3FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignKs3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks3", exc);
    }
  }

  /**
   * save M on PssIEEE2B
   *
   * @param command AssignMToPssIEEE2BCommand
   */
  @PutMapping("/assignM")
  public void assignM(@RequestBody AssignMToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignM(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign M", exc);
    }
  }

  /**
   * unassign M on PssIEEE2B
   *
   * @param command UnAssignMFromPssIEEE2BCommand
   */
  @PutMapping("/unAssignM")
  public void unAssignM(@RequestBody(required = true) UnAssignMFromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignM(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign M", exc);
    }
  }

  /**
   * save N on PssIEEE2B
   *
   * @param command AssignNToPssIEEE2BCommand
   */
  @PutMapping("/assignN")
  public void assignN(@RequestBody AssignNToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignN(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign N", exc);
    }
  }

  /**
   * unassign N on PssIEEE2B
   *
   * @param command UnAssignNFromPssIEEE2BCommand
   */
  @PutMapping("/unAssignN")
  public void unAssignN(@RequestBody(required = true) UnAssignNFromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignN(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign N", exc);
    }
  }

  /**
   * save T1 on PssIEEE2B
   *
   * @param command AssignT1ToPssIEEE2BCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on PssIEEE2B
   *
   * @param command UnAssignT1FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T10 on PssIEEE2B
   *
   * @param command AssignT10ToPssIEEE2BCommand
   */
  @PutMapping("/assignT10")
  public void assignT10(@RequestBody AssignT10ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T10", exc);
    }
  }

  /**
   * unassign T10 on PssIEEE2B
   *
   * @param command UnAssignT10FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT10")
  public void unAssignT10(@RequestBody(required = true) UnAssignT10FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T10", exc);
    }
  }

  /**
   * save T11 on PssIEEE2B
   *
   * @param command AssignT11ToPssIEEE2BCommand
   */
  @PutMapping("/assignT11")
  public void assignT11(@RequestBody AssignT11ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T11", exc);
    }
  }

  /**
   * unassign T11 on PssIEEE2B
   *
   * @param command UnAssignT11FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT11")
  public void unAssignT11(@RequestBody(required = true) UnAssignT11FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T11", exc);
    }
  }

  /**
   * save T2 on PssIEEE2B
   *
   * @param command AssignT2ToPssIEEE2BCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on PssIEEE2B
   *
   * @param command UnAssignT2FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on PssIEEE2B
   *
   * @param command AssignT3ToPssIEEE2BCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on PssIEEE2B
   *
   * @param command UnAssignT3FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on PssIEEE2B
   *
   * @param command AssignT4ToPssIEEE2BCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on PssIEEE2B
   *
   * @param command UnAssignT4FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T6 on PssIEEE2B
   *
   * @param command AssignT6ToPssIEEE2BCommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on PssIEEE2B
   *
   * @param command UnAssignT6FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save T7 on PssIEEE2B
   *
   * @param command AssignT7ToPssIEEE2BCommand
   */
  @PutMapping("/assignT7")
  public void assignT7(@RequestBody AssignT7ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T7", exc);
    }
  }

  /**
   * unassign T7 on PssIEEE2B
   *
   * @param command UnAssignT7FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT7")
  public void unAssignT7(@RequestBody(required = true) UnAssignT7FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T7", exc);
    }
  }

  /**
   * save T8 on PssIEEE2B
   *
   * @param command AssignT8ToPssIEEE2BCommand
   */
  @PutMapping("/assignT8")
  public void assignT8(@RequestBody AssignT8ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T8", exc);
    }
  }

  /**
   * unassign T8 on PssIEEE2B
   *
   * @param command UnAssignT8FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT8")
  public void unAssignT8(@RequestBody(required = true) UnAssignT8FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T8", exc);
    }
  }

  /**
   * save T9 on PssIEEE2B
   *
   * @param command AssignT9ToPssIEEE2BCommand
   */
  @PutMapping("/assignT9")
  public void assignT9(@RequestBody AssignT9ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignT9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T9", exc);
    }
  }

  /**
   * unassign T9 on PssIEEE2B
   *
   * @param command UnAssignT9FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignT9")
  public void unAssignT9(@RequestBody(required = true) UnAssignT9FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignT9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T9", exc);
    }
  }

  /**
   * save Tw1 on PssIEEE2B
   *
   * @param command AssignTw1ToPssIEEE2BCommand
   */
  @PutMapping("/assignTw1")
  public void assignTw1(@RequestBody AssignTw1ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignTw1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw1", exc);
    }
  }

  /**
   * unassign Tw1 on PssIEEE2B
   *
   * @param command UnAssignTw1FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignTw1")
  public void unAssignTw1(@RequestBody(required = true) UnAssignTw1FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignTw1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw1", exc);
    }
  }

  /**
   * save Tw2 on PssIEEE2B
   *
   * @param command AssignTw2ToPssIEEE2BCommand
   */
  @PutMapping("/assignTw2")
  public void assignTw2(@RequestBody AssignTw2ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignTw2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw2", exc);
    }
  }

  /**
   * unassign Tw2 on PssIEEE2B
   *
   * @param command UnAssignTw2FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignTw2")
  public void unAssignTw2(@RequestBody(required = true) UnAssignTw2FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignTw2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw2", exc);
    }
  }

  /**
   * save Tw3 on PssIEEE2B
   *
   * @param command AssignTw3ToPssIEEE2BCommand
   */
  @PutMapping("/assignTw3")
  public void assignTw3(@RequestBody AssignTw3ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignTw3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw3", exc);
    }
  }

  /**
   * unassign Tw3 on PssIEEE2B
   *
   * @param command UnAssignTw3FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignTw3")
  public void unAssignTw3(@RequestBody(required = true) UnAssignTw3FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignTw3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw3", exc);
    }
  }

  /**
   * save Tw4 on PssIEEE2B
   *
   * @param command AssignTw4ToPssIEEE2BCommand
   */
  @PutMapping("/assignTw4")
  public void assignTw4(@RequestBody AssignTw4ToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignTw4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw4", exc);
    }
  }

  /**
   * unassign Tw4 on PssIEEE2B
   *
   * @param command UnAssignTw4FromPssIEEE2BCommand
   */
  @PutMapping("/unAssignTw4")
  public void unAssignTw4(@RequestBody(required = true) UnAssignTw4FromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignTw4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw4", exc);
    }
  }

  /**
   * save Vsi1max on PssIEEE2B
   *
   * @param command AssignVsi1maxToPssIEEE2BCommand
   */
  @PutMapping("/assignVsi1max")
  public void assignVsi1max(@RequestBody AssignVsi1maxToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignVsi1max(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsi1max", exc);
    }
  }

  /**
   * unassign Vsi1max on PssIEEE2B
   *
   * @param command UnAssignVsi1maxFromPssIEEE2BCommand
   */
  @PutMapping("/unAssignVsi1max")
  public void unAssignVsi1max(
      @RequestBody(required = true) UnAssignVsi1maxFromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignVsi1max(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsi1max", exc);
    }
  }

  /**
   * save Vsi1min on PssIEEE2B
   *
   * @param command AssignVsi1minToPssIEEE2BCommand
   */
  @PutMapping("/assignVsi1min")
  public void assignVsi1min(@RequestBody AssignVsi1minToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignVsi1min(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsi1min", exc);
    }
  }

  /**
   * unassign Vsi1min on PssIEEE2B
   *
   * @param command UnAssignVsi1minFromPssIEEE2BCommand
   */
  @PutMapping("/unAssignVsi1min")
  public void unAssignVsi1min(
      @RequestBody(required = true) UnAssignVsi1minFromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignVsi1min(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsi1min", exc);
    }
  }

  /**
   * save Vsi2max on PssIEEE2B
   *
   * @param command AssignVsi2maxToPssIEEE2BCommand
   */
  @PutMapping("/assignVsi2max")
  public void assignVsi2max(@RequestBody AssignVsi2maxToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignVsi2max(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsi2max", exc);
    }
  }

  /**
   * unassign Vsi2max on PssIEEE2B
   *
   * @param command UnAssignVsi2maxFromPssIEEE2BCommand
   */
  @PutMapping("/unAssignVsi2max")
  public void unAssignVsi2max(
      @RequestBody(required = true) UnAssignVsi2maxFromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignVsi2max(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsi2max", exc);
    }
  }

  /**
   * save Vsi2min on PssIEEE2B
   *
   * @param command AssignVsi2minToPssIEEE2BCommand
   */
  @PutMapping("/assignVsi2min")
  public void assignVsi2min(@RequestBody AssignVsi2minToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignVsi2min(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsi2min", exc);
    }
  }

  /**
   * unassign Vsi2min on PssIEEE2B
   *
   * @param command UnAssignVsi2minFromPssIEEE2BCommand
   */
  @PutMapping("/unAssignVsi2min")
  public void unAssignVsi2min(
      @RequestBody(required = true) UnAssignVsi2minFromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignVsi2min(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsi2min", exc);
    }
  }

  /**
   * save Vstmax on PssIEEE2B
   *
   * @param command AssignVstmaxToPssIEEE2BCommand
   */
  @PutMapping("/assignVstmax")
  public void assignVstmax(@RequestBody AssignVstmaxToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignVstmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vstmax", exc);
    }
  }

  /**
   * unassign Vstmax on PssIEEE2B
   *
   * @param command UnAssignVstmaxFromPssIEEE2BCommand
   */
  @PutMapping("/unAssignVstmax")
  public void unAssignVstmax(
      @RequestBody(required = true) UnAssignVstmaxFromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignVstmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vstmax", exc);
    }
  }

  /**
   * save Vstmin on PssIEEE2B
   *
   * @param command AssignVstminToPssIEEE2BCommand
   */
  @PutMapping("/assignVstmin")
  public void assignVstmin(@RequestBody AssignVstminToPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().assignVstmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vstmin", exc);
    }
  }

  /**
   * unassign Vstmin on PssIEEE2B
   *
   * @param command UnAssignVstminFromPssIEEE2BCommand
   */
  @PutMapping("/unAssignVstmin")
  public void unAssignVstmin(
      @RequestBody(required = true) UnAssignVstminFromPssIEEE2BCommand command) {
    try {
      PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().unAssignVstmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vstmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssIEEE2B pssIEEE2B = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssIEEE2BCommandRestController.class.getName());
}
