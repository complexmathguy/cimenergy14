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
 * Implements Spring Controller command CQRS processing for entity PssPTIST3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssPTIST3")
public class PssPTIST3CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssPTIST3. if not key provided, calls create, otherwise calls save
   *
   * @param PssPTIST3 pssPTIST3
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePssPTIST3Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssPTIST3BusinessDelegate.getPssPTIST3Instance().createPssPTIST3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssPTIST3. if no key provided, calls create, otherwise calls save
   *
   * @param PssPTIST3 pssPTIST3
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePssPTIST3Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssPTIST3Command
      // -----------------------------------------------
      completableFuture = PssPTIST3BusinessDelegate.getPssPTIST3Instance().updatePssPTIST3(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssPTIST3Controller:update() - successfully update PssPTIST3 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssPTIST3 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssPTIST3Id) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssPTIST3Command command = new DeletePssPTIST3Command(pssPTIST3Id);

    try {
      PssPTIST3BusinessDelegate delegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted PssPTIST3 with key " + command.getPssPTIST3Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A0 on PssPTIST3
   *
   * @param command AssignA0ToPssPTIST3Command
   */
  @PutMapping("/assignA0")
  public void assignA0(@RequestBody AssignA0ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignA0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A0", exc);
    }
  }

  /**
   * unassign A0 on PssPTIST3
   *
   * @param command UnAssignA0FromPssPTIST3Command
   */
  @PutMapping("/unAssignA0")
  public void unAssignA0(@RequestBody(required = true) UnAssignA0FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignA0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A0", exc);
    }
  }

  /**
   * save A1 on PssPTIST3
   *
   * @param command AssignA1ToPssPTIST3Command
   */
  @PutMapping("/assignA1")
  public void assignA1(@RequestBody AssignA1ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignA1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A1", exc);
    }
  }

  /**
   * unassign A1 on PssPTIST3
   *
   * @param command UnAssignA1FromPssPTIST3Command
   */
  @PutMapping("/unAssignA1")
  public void unAssignA1(@RequestBody(required = true) UnAssignA1FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignA1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A1", exc);
    }
  }

  /**
   * save A2 on PssPTIST3
   *
   * @param command AssignA2ToPssPTIST3Command
   */
  @PutMapping("/assignA2")
  public void assignA2(@RequestBody AssignA2ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignA2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A2", exc);
    }
  }

  /**
   * unassign A2 on PssPTIST3
   *
   * @param command UnAssignA2FromPssPTIST3Command
   */
  @PutMapping("/unAssignA2")
  public void unAssignA2(@RequestBody(required = true) UnAssignA2FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignA2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A2", exc);
    }
  }

  /**
   * save A3 on PssPTIST3
   *
   * @param command AssignA3ToPssPTIST3Command
   */
  @PutMapping("/assignA3")
  public void assignA3(@RequestBody AssignA3ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignA3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A3", exc);
    }
  }

  /**
   * unassign A3 on PssPTIST3
   *
   * @param command UnAssignA3FromPssPTIST3Command
   */
  @PutMapping("/unAssignA3")
  public void unAssignA3(@RequestBody(required = true) UnAssignA3FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignA3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A3", exc);
    }
  }

  /**
   * save A4 on PssPTIST3
   *
   * @param command AssignA4ToPssPTIST3Command
   */
  @PutMapping("/assignA4")
  public void assignA4(@RequestBody AssignA4ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignA4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A4", exc);
    }
  }

  /**
   * unassign A4 on PssPTIST3
   *
   * @param command UnAssignA4FromPssPTIST3Command
   */
  @PutMapping("/unAssignA4")
  public void unAssignA4(@RequestBody(required = true) UnAssignA4FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignA4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A4", exc);
    }
  }

  /**
   * save A5 on PssPTIST3
   *
   * @param command AssignA5ToPssPTIST3Command
   */
  @PutMapping("/assignA5")
  public void assignA5(@RequestBody AssignA5ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignA5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A5", exc);
    }
  }

  /**
   * unassign A5 on PssPTIST3
   *
   * @param command UnAssignA5FromPssPTIST3Command
   */
  @PutMapping("/unAssignA5")
  public void unAssignA5(@RequestBody(required = true) UnAssignA5FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignA5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A5", exc);
    }
  }

  /**
   * save Al on PssPTIST3
   *
   * @param command AssignAlToPssPTIST3Command
   */
  @PutMapping("/assignAl")
  public void assignAl(@RequestBody AssignAlToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignAl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Al", exc);
    }
  }

  /**
   * unassign Al on PssPTIST3
   *
   * @param command UnAssignAlFromPssPTIST3Command
   */
  @PutMapping("/unAssignAl")
  public void unAssignAl(@RequestBody(required = true) UnAssignAlFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignAl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Al", exc);
    }
  }

  /**
   * save Athres on PssPTIST3
   *
   * @param command AssignAthresToPssPTIST3Command
   */
  @PutMapping("/assignAthres")
  public void assignAthres(@RequestBody AssignAthresToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignAthres(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Athres", exc);
    }
  }

  /**
   * unassign Athres on PssPTIST3
   *
   * @param command UnAssignAthresFromPssPTIST3Command
   */
  @PutMapping("/unAssignAthres")
  public void unAssignAthres(
      @RequestBody(required = true) UnAssignAthresFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignAthres(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Athres", exc);
    }
  }

  /**
   * save B0 on PssPTIST3
   *
   * @param command AssignB0ToPssPTIST3Command
   */
  @PutMapping("/assignB0")
  public void assignB0(@RequestBody AssignB0ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignB0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B0", exc);
    }
  }

  /**
   * unassign B0 on PssPTIST3
   *
   * @param command UnAssignB0FromPssPTIST3Command
   */
  @PutMapping("/unAssignB0")
  public void unAssignB0(@RequestBody(required = true) UnAssignB0FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignB0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B0", exc);
    }
  }

  /**
   * save B1 on PssPTIST3
   *
   * @param command AssignB1ToPssPTIST3Command
   */
  @PutMapping("/assignB1")
  public void assignB1(@RequestBody AssignB1ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignB1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B1", exc);
    }
  }

  /**
   * unassign B1 on PssPTIST3
   *
   * @param command UnAssignB1FromPssPTIST3Command
   */
  @PutMapping("/unAssignB1")
  public void unAssignB1(@RequestBody(required = true) UnAssignB1FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignB1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B1", exc);
    }
  }

  /**
   * save B2 on PssPTIST3
   *
   * @param command AssignB2ToPssPTIST3Command
   */
  @PutMapping("/assignB2")
  public void assignB2(@RequestBody AssignB2ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignB2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B2", exc);
    }
  }

  /**
   * unassign B2 on PssPTIST3
   *
   * @param command UnAssignB2FromPssPTIST3Command
   */
  @PutMapping("/unAssignB2")
  public void unAssignB2(@RequestBody(required = true) UnAssignB2FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignB2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B2", exc);
    }
  }

  /**
   * save B3 on PssPTIST3
   *
   * @param command AssignB3ToPssPTIST3Command
   */
  @PutMapping("/assignB3")
  public void assignB3(@RequestBody AssignB3ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignB3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B3", exc);
    }
  }

  /**
   * unassign B3 on PssPTIST3
   *
   * @param command UnAssignB3FromPssPTIST3Command
   */
  @PutMapping("/unAssignB3")
  public void unAssignB3(@RequestBody(required = true) UnAssignB3FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignB3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B3", exc);
    }
  }

  /**
   * save B4 on PssPTIST3
   *
   * @param command AssignB4ToPssPTIST3Command
   */
  @PutMapping("/assignB4")
  public void assignB4(@RequestBody AssignB4ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignB4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B4", exc);
    }
  }

  /**
   * unassign B4 on PssPTIST3
   *
   * @param command UnAssignB4FromPssPTIST3Command
   */
  @PutMapping("/unAssignB4")
  public void unAssignB4(@RequestBody(required = true) UnAssignB4FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignB4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B4", exc);
    }
  }

  /**
   * save B5 on PssPTIST3
   *
   * @param command AssignB5ToPssPTIST3Command
   */
  @PutMapping("/assignB5")
  public void assignB5(@RequestBody AssignB5ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignB5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B5", exc);
    }
  }

  /**
   * unassign B5 on PssPTIST3
   *
   * @param command UnAssignB5FromPssPTIST3Command
   */
  @PutMapping("/unAssignB5")
  public void unAssignB5(@RequestBody(required = true) UnAssignB5FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignB5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B5", exc);
    }
  }

  /**
   * save Dl on PssPTIST3
   *
   * @param command AssignDlToPssPTIST3Command
   */
  @PutMapping("/assignDl")
  public void assignDl(@RequestBody AssignDlToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignDl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dl", exc);
    }
  }

  /**
   * unassign Dl on PssPTIST3
   *
   * @param command UnAssignDlFromPssPTIST3Command
   */
  @PutMapping("/unAssignDl")
  public void unAssignDl(@RequestBody(required = true) UnAssignDlFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignDl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dl", exc);
    }
  }

  /**
   * save Dtc on PssPTIST3
   *
   * @param command AssignDtcToPssPTIST3Command
   */
  @PutMapping("/assignDtc")
  public void assignDtc(@RequestBody AssignDtcToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignDtc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dtc", exc);
    }
  }

  /**
   * unassign Dtc on PssPTIST3
   *
   * @param command UnAssignDtcFromPssPTIST3Command
   */
  @PutMapping("/unAssignDtc")
  public void unAssignDtc(@RequestBody(required = true) UnAssignDtcFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignDtc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dtc", exc);
    }
  }

  /**
   * save Dtf on PssPTIST3
   *
   * @param command AssignDtfToPssPTIST3Command
   */
  @PutMapping("/assignDtf")
  public void assignDtf(@RequestBody AssignDtfToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignDtf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dtf", exc);
    }
  }

  /**
   * unassign Dtf on PssPTIST3
   *
   * @param command UnAssignDtfFromPssPTIST3Command
   */
  @PutMapping("/unAssignDtf")
  public void unAssignDtf(@RequestBody(required = true) UnAssignDtfFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignDtf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dtf", exc);
    }
  }

  /**
   * save Dtp on PssPTIST3
   *
   * @param command AssignDtpToPssPTIST3Command
   */
  @PutMapping("/assignDtp")
  public void assignDtp(@RequestBody AssignDtpToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignDtp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dtp", exc);
    }
  }

  /**
   * unassign Dtp on PssPTIST3
   *
   * @param command UnAssignDtpFromPssPTIST3Command
   */
  @PutMapping("/unAssignDtp")
  public void unAssignDtp(@RequestBody(required = true) UnAssignDtpFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignDtp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dtp", exc);
    }
  }

  /**
   * save Isw on PssPTIST3
   *
   * @param command AssignIswToPssPTIST3Command
   */
  @PutMapping("/assignIsw")
  public void assignIsw(@RequestBody AssignIswToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignIsw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Isw", exc);
    }
  }

  /**
   * unassign Isw on PssPTIST3
   *
   * @param command UnAssignIswFromPssPTIST3Command
   */
  @PutMapping("/unAssignIsw")
  public void unAssignIsw(@RequestBody(required = true) UnAssignIswFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignIsw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Isw", exc);
    }
  }

  /**
   * save K on PssPTIST3
   *
   * @param command AssignKToPssPTIST3Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on PssPTIST3
   *
   * @param command UnAssignKFromPssPTIST3Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save Lthres on PssPTIST3
   *
   * @param command AssignLthresToPssPTIST3Command
   */
  @PutMapping("/assignLthres")
  public void assignLthres(@RequestBody AssignLthresToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignLthres(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lthres", exc);
    }
  }

  /**
   * unassign Lthres on PssPTIST3
   *
   * @param command UnAssignLthresFromPssPTIST3Command
   */
  @PutMapping("/unAssignLthres")
  public void unAssignLthres(
      @RequestBody(required = true) UnAssignLthresFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignLthres(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lthres", exc);
    }
  }

  /**
   * save M on PssPTIST3
   *
   * @param command AssignMToPssPTIST3Command
   */
  @PutMapping("/assignM")
  public void assignM(@RequestBody AssignMToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignM(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign M", exc);
    }
  }

  /**
   * unassign M on PssPTIST3
   *
   * @param command UnAssignMFromPssPTIST3Command
   */
  @PutMapping("/unAssignM")
  public void unAssignM(@RequestBody(required = true) UnAssignMFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignM(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign M", exc);
    }
  }

  /**
   * save Nav on PssPTIST3
   *
   * @param command AssignNavToPssPTIST3Command
   */
  @PutMapping("/assignNav")
  public void assignNav(@RequestBody AssignNavToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignNav(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Nav", exc);
    }
  }

  /**
   * unassign Nav on PssPTIST3
   *
   * @param command UnAssignNavFromPssPTIST3Command
   */
  @PutMapping("/unAssignNav")
  public void unAssignNav(@RequestBody(required = true) UnAssignNavFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignNav(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Nav", exc);
    }
  }

  /**
   * save Ncl on PssPTIST3
   *
   * @param command AssignNclToPssPTIST3Command
   */
  @PutMapping("/assignNcl")
  public void assignNcl(@RequestBody AssignNclToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignNcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ncl", exc);
    }
  }

  /**
   * unassign Ncl on PssPTIST3
   *
   * @param command UnAssignNclFromPssPTIST3Command
   */
  @PutMapping("/unAssignNcl")
  public void unAssignNcl(@RequestBody(required = true) UnAssignNclFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignNcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ncl", exc);
    }
  }

  /**
   * save Ncr on PssPTIST3
   *
   * @param command AssignNcrToPssPTIST3Command
   */
  @PutMapping("/assignNcr")
  public void assignNcr(@RequestBody AssignNcrToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignNcr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ncr", exc);
    }
  }

  /**
   * unassign Ncr on PssPTIST3
   *
   * @param command UnAssignNcrFromPssPTIST3Command
   */
  @PutMapping("/unAssignNcr")
  public void unAssignNcr(@RequestBody(required = true) UnAssignNcrFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignNcr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ncr", exc);
    }
  }

  /**
   * save Pmin on PssPTIST3
   *
   * @param command AssignPminToPssPTIST3Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on PssPTIST3
   *
   * @param command UnAssignPminFromPssPTIST3Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(@RequestBody(required = true) UnAssignPminFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save T1 on PssPTIST3
   *
   * @param command AssignT1ToPssPTIST3Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on PssPTIST3
   *
   * @param command UnAssignT1FromPssPTIST3Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on PssPTIST3
   *
   * @param command AssignT2ToPssPTIST3Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on PssPTIST3
   *
   * @param command UnAssignT2FromPssPTIST3Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on PssPTIST3
   *
   * @param command AssignT3ToPssPTIST3Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on PssPTIST3
   *
   * @param command UnAssignT3FromPssPTIST3Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on PssPTIST3
   *
   * @param command AssignT4ToPssPTIST3Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on PssPTIST3
   *
   * @param command UnAssignT4FromPssPTIST3Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on PssPTIST3
   *
   * @param command AssignT5ToPssPTIST3Command
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on PssPTIST3
   *
   * @param command UnAssignT5FromPssPTIST3Command
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on PssPTIST3
   *
   * @param command AssignT6ToPssPTIST3Command
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on PssPTIST3
   *
   * @param command UnAssignT6FromPssPTIST3Command
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save Tf on PssPTIST3
   *
   * @param command AssignTfToPssPTIST3Command
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on PssPTIST3
   *
   * @param command UnAssignTfFromPssPTIST3Command
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tp on PssPTIST3
   *
   * @param command AssignTpToPssPTIST3Command
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on PssPTIST3
   *
   * @param command UnAssignTpFromPssPTIST3Command
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromPssPTIST3Command command) {
    try {
      PssPTIST3BusinessDelegate.getPssPTIST3Instance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssPTIST3 pssPTIST3 = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssPTIST3CommandRestController.class.getName());
}
