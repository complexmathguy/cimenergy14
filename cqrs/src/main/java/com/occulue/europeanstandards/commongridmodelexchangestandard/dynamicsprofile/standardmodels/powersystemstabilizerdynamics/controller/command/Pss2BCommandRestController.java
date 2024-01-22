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
 * Implements Spring Controller command CQRS processing for entity Pss2B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss2B")
public class Pss2BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Pss2B. if not key provided, calls create, otherwise calls save
   *
   * @param Pss2B pss2B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePss2BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = Pss2BBusinessDelegate.getPss2BInstance().createPss2B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Pss2B. if no key provided, calls create, otherwise calls save
   *
   * @param Pss2B pss2B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePss2BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePss2BCommand
      // -----------------------------------------------
      completableFuture = Pss2BBusinessDelegate.getPss2BInstance().updatePss2B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "Pss2BController:update() - successfully update Pss2B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Pss2B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pss2BId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePss2BCommand command = new DeletePss2BCommand(pss2BId);

    try {
      Pss2BBusinessDelegate delegate = Pss2BBusinessDelegate.getPss2BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Pss2B with key " + command.getPss2BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A on Pss2B
   *
   * @param command AssignAToPss2BCommand
   */
  @PutMapping("/assignA")
  public void assignA(@RequestBody AssignAToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignA(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A", exc);
    }
  }

  /**
   * unassign A on Pss2B
   *
   * @param command UnAssignAFromPss2BCommand
   */
  @PutMapping("/unAssignA")
  public void unAssignA(@RequestBody(required = true) UnAssignAFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignA(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A", exc);
    }
  }

  /**
   * save Ks1 on Pss2B
   *
   * @param command AssignKs1ToPss2BCommand
   */
  @PutMapping("/assignKs1")
  public void assignKs1(@RequestBody AssignKs1ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignKs1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks1", exc);
    }
  }

  /**
   * unassign Ks1 on Pss2B
   *
   * @param command UnAssignKs1FromPss2BCommand
   */
  @PutMapping("/unAssignKs1")
  public void unAssignKs1(@RequestBody(required = true) UnAssignKs1FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignKs1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks1", exc);
    }
  }

  /**
   * save Ks2 on Pss2B
   *
   * @param command AssignKs2ToPss2BCommand
   */
  @PutMapping("/assignKs2")
  public void assignKs2(@RequestBody AssignKs2ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignKs2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks2", exc);
    }
  }

  /**
   * unassign Ks2 on Pss2B
   *
   * @param command UnAssignKs2FromPss2BCommand
   */
  @PutMapping("/unAssignKs2")
  public void unAssignKs2(@RequestBody(required = true) UnAssignKs2FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignKs2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks2", exc);
    }
  }

  /**
   * save Ks3 on Pss2B
   *
   * @param command AssignKs3ToPss2BCommand
   */
  @PutMapping("/assignKs3")
  public void assignKs3(@RequestBody AssignKs3ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignKs3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks3", exc);
    }
  }

  /**
   * unassign Ks3 on Pss2B
   *
   * @param command UnAssignKs3FromPss2BCommand
   */
  @PutMapping("/unAssignKs3")
  public void unAssignKs3(@RequestBody(required = true) UnAssignKs3FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignKs3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks3", exc);
    }
  }

  /**
   * save Ks4 on Pss2B
   *
   * @param command AssignKs4ToPss2BCommand
   */
  @PutMapping("/assignKs4")
  public void assignKs4(@RequestBody AssignKs4ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignKs4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks4", exc);
    }
  }

  /**
   * unassign Ks4 on Pss2B
   *
   * @param command UnAssignKs4FromPss2BCommand
   */
  @PutMapping("/unAssignKs4")
  public void unAssignKs4(@RequestBody(required = true) UnAssignKs4FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignKs4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks4", exc);
    }
  }

  /**
   * save M on Pss2B
   *
   * @param command AssignMToPss2BCommand
   */
  @PutMapping("/assignM")
  public void assignM(@RequestBody AssignMToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignM(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign M", exc);
    }
  }

  /**
   * unassign M on Pss2B
   *
   * @param command UnAssignMFromPss2BCommand
   */
  @PutMapping("/unAssignM")
  public void unAssignM(@RequestBody(required = true) UnAssignMFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignM(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign M", exc);
    }
  }

  /**
   * save N on Pss2B
   *
   * @param command AssignNToPss2BCommand
   */
  @PutMapping("/assignN")
  public void assignN(@RequestBody AssignNToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignN(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign N", exc);
    }
  }

  /**
   * unassign N on Pss2B
   *
   * @param command UnAssignNFromPss2BCommand
   */
  @PutMapping("/unAssignN")
  public void unAssignN(@RequestBody(required = true) UnAssignNFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignN(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign N", exc);
    }
  }

  /**
   * save T1 on Pss2B
   *
   * @param command AssignT1ToPss2BCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on Pss2B
   *
   * @param command UnAssignT1FromPss2BCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T10 on Pss2B
   *
   * @param command AssignT10ToPss2BCommand
   */
  @PutMapping("/assignT10")
  public void assignT10(@RequestBody AssignT10ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T10", exc);
    }
  }

  /**
   * unassign T10 on Pss2B
   *
   * @param command UnAssignT10FromPss2BCommand
   */
  @PutMapping("/unAssignT10")
  public void unAssignT10(@RequestBody(required = true) UnAssignT10FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T10", exc);
    }
  }

  /**
   * save T11 on Pss2B
   *
   * @param command AssignT11ToPss2BCommand
   */
  @PutMapping("/assignT11")
  public void assignT11(@RequestBody AssignT11ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T11", exc);
    }
  }

  /**
   * unassign T11 on Pss2B
   *
   * @param command UnAssignT11FromPss2BCommand
   */
  @PutMapping("/unAssignT11")
  public void unAssignT11(@RequestBody(required = true) UnAssignT11FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T11", exc);
    }
  }

  /**
   * save T2 on Pss2B
   *
   * @param command AssignT2ToPss2BCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on Pss2B
   *
   * @param command UnAssignT2FromPss2BCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on Pss2B
   *
   * @param command AssignT3ToPss2BCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on Pss2B
   *
   * @param command UnAssignT3FromPss2BCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on Pss2B
   *
   * @param command AssignT4ToPss2BCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on Pss2B
   *
   * @param command UnAssignT4FromPss2BCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T6 on Pss2B
   *
   * @param command AssignT6ToPss2BCommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on Pss2B
   *
   * @param command UnAssignT6FromPss2BCommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save T7 on Pss2B
   *
   * @param command AssignT7ToPss2BCommand
   */
  @PutMapping("/assignT7")
  public void assignT7(@RequestBody AssignT7ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T7", exc);
    }
  }

  /**
   * unassign T7 on Pss2B
   *
   * @param command UnAssignT7FromPss2BCommand
   */
  @PutMapping("/unAssignT7")
  public void unAssignT7(@RequestBody(required = true) UnAssignT7FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T7", exc);
    }
  }

  /**
   * save T8 on Pss2B
   *
   * @param command AssignT8ToPss2BCommand
   */
  @PutMapping("/assignT8")
  public void assignT8(@RequestBody AssignT8ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T8", exc);
    }
  }

  /**
   * unassign T8 on Pss2B
   *
   * @param command UnAssignT8FromPss2BCommand
   */
  @PutMapping("/unAssignT8")
  public void unAssignT8(@RequestBody(required = true) UnAssignT8FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T8", exc);
    }
  }

  /**
   * save T9 on Pss2B
   *
   * @param command AssignT9ToPss2BCommand
   */
  @PutMapping("/assignT9")
  public void assignT9(@RequestBody AssignT9ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignT9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T9", exc);
    }
  }

  /**
   * unassign T9 on Pss2B
   *
   * @param command UnAssignT9FromPss2BCommand
   */
  @PutMapping("/unAssignT9")
  public void unAssignT9(@RequestBody(required = true) UnAssignT9FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignT9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T9", exc);
    }
  }

  /**
   * save Ta on Pss2B
   *
   * @param command AssignTaToPss2BCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on Pss2B
   *
   * @param command UnAssignTaFromPss2BCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on Pss2B
   *
   * @param command AssignTbToPss2BCommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on Pss2B
   *
   * @param command UnAssignTbFromPss2BCommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tw1 on Pss2B
   *
   * @param command AssignTw1ToPss2BCommand
   */
  @PutMapping("/assignTw1")
  public void assignTw1(@RequestBody AssignTw1ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignTw1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw1", exc);
    }
  }

  /**
   * unassign Tw1 on Pss2B
   *
   * @param command UnAssignTw1FromPss2BCommand
   */
  @PutMapping("/unAssignTw1")
  public void unAssignTw1(@RequestBody(required = true) UnAssignTw1FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignTw1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw1", exc);
    }
  }

  /**
   * save Tw2 on Pss2B
   *
   * @param command AssignTw2ToPss2BCommand
   */
  @PutMapping("/assignTw2")
  public void assignTw2(@RequestBody AssignTw2ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignTw2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw2", exc);
    }
  }

  /**
   * unassign Tw2 on Pss2B
   *
   * @param command UnAssignTw2FromPss2BCommand
   */
  @PutMapping("/unAssignTw2")
  public void unAssignTw2(@RequestBody(required = true) UnAssignTw2FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignTw2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw2", exc);
    }
  }

  /**
   * save Tw3 on Pss2B
   *
   * @param command AssignTw3ToPss2BCommand
   */
  @PutMapping("/assignTw3")
  public void assignTw3(@RequestBody AssignTw3ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignTw3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw3", exc);
    }
  }

  /**
   * unassign Tw3 on Pss2B
   *
   * @param command UnAssignTw3FromPss2BCommand
   */
  @PutMapping("/unAssignTw3")
  public void unAssignTw3(@RequestBody(required = true) UnAssignTw3FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignTw3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw3", exc);
    }
  }

  /**
   * save Tw4 on Pss2B
   *
   * @param command AssignTw4ToPss2BCommand
   */
  @PutMapping("/assignTw4")
  public void assignTw4(@RequestBody AssignTw4ToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignTw4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw4", exc);
    }
  }

  /**
   * unassign Tw4 on Pss2B
   *
   * @param command UnAssignTw4FromPss2BCommand
   */
  @PutMapping("/unAssignTw4")
  public void unAssignTw4(@RequestBody(required = true) UnAssignTw4FromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignTw4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw4", exc);
    }
  }

  /**
   * save Vsi1max on Pss2B
   *
   * @param command AssignVsi1maxToPss2BCommand
   */
  @PutMapping("/assignVsi1max")
  public void assignVsi1max(@RequestBody AssignVsi1maxToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignVsi1max(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsi1max", exc);
    }
  }

  /**
   * unassign Vsi1max on Pss2B
   *
   * @param command UnAssignVsi1maxFromPss2BCommand
   */
  @PutMapping("/unAssignVsi1max")
  public void unAssignVsi1max(
      @RequestBody(required = true) UnAssignVsi1maxFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignVsi1max(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsi1max", exc);
    }
  }

  /**
   * save Vsi1min on Pss2B
   *
   * @param command AssignVsi1minToPss2BCommand
   */
  @PutMapping("/assignVsi1min")
  public void assignVsi1min(@RequestBody AssignVsi1minToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignVsi1min(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsi1min", exc);
    }
  }

  /**
   * unassign Vsi1min on Pss2B
   *
   * @param command UnAssignVsi1minFromPss2BCommand
   */
  @PutMapping("/unAssignVsi1min")
  public void unAssignVsi1min(
      @RequestBody(required = true) UnAssignVsi1minFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignVsi1min(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsi1min", exc);
    }
  }

  /**
   * save Vsi2max on Pss2B
   *
   * @param command AssignVsi2maxToPss2BCommand
   */
  @PutMapping("/assignVsi2max")
  public void assignVsi2max(@RequestBody AssignVsi2maxToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignVsi2max(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsi2max", exc);
    }
  }

  /**
   * unassign Vsi2max on Pss2B
   *
   * @param command UnAssignVsi2maxFromPss2BCommand
   */
  @PutMapping("/unAssignVsi2max")
  public void unAssignVsi2max(
      @RequestBody(required = true) UnAssignVsi2maxFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignVsi2max(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsi2max", exc);
    }
  }

  /**
   * save Vsi2min on Pss2B
   *
   * @param command AssignVsi2minToPss2BCommand
   */
  @PutMapping("/assignVsi2min")
  public void assignVsi2min(@RequestBody AssignVsi2minToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignVsi2min(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsi2min", exc);
    }
  }

  /**
   * unassign Vsi2min on Pss2B
   *
   * @param command UnAssignVsi2minFromPss2BCommand
   */
  @PutMapping("/unAssignVsi2min")
  public void unAssignVsi2min(
      @RequestBody(required = true) UnAssignVsi2minFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignVsi2min(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsi2min", exc);
    }
  }

  /**
   * save Vstmax on Pss2B
   *
   * @param command AssignVstmaxToPss2BCommand
   */
  @PutMapping("/assignVstmax")
  public void assignVstmax(@RequestBody AssignVstmaxToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignVstmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vstmax", exc);
    }
  }

  /**
   * unassign Vstmax on Pss2B
   *
   * @param command UnAssignVstmaxFromPss2BCommand
   */
  @PutMapping("/unAssignVstmax")
  public void unAssignVstmax(@RequestBody(required = true) UnAssignVstmaxFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignVstmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vstmax", exc);
    }
  }

  /**
   * save Vstmin on Pss2B
   *
   * @param command AssignVstminToPss2BCommand
   */
  @PutMapping("/assignVstmin")
  public void assignVstmin(@RequestBody AssignVstminToPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().assignVstmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vstmin", exc);
    }
  }

  /**
   * unassign Vstmin on Pss2B
   *
   * @param command UnAssignVstminFromPss2BCommand
   */
  @PutMapping("/unAssignVstmin")
  public void unAssignVstmin(@RequestBody(required = true) UnAssignVstminFromPss2BCommand command) {
    try {
      Pss2BBusinessDelegate.getPss2BInstance().unAssignVstmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vstmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Pss2B pss2B = null;
  private static final Logger LOGGER = Logger.getLogger(Pss2BCommandRestController.class.getName());
}
