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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ExcELIN1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcELIN1")
public class ExcELIN1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcELIN1. if not key provided, calls create, otherwise calls save
   *
   * @param ExcELIN1 excELIN1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcELIN1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcELIN1BusinessDelegate.getExcELIN1Instance().createExcELIN1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcELIN1. if no key provided, calls create, otherwise calls save
   *
   * @param ExcELIN1 excELIN1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcELIN1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcELIN1Command
      // -----------------------------------------------
      completableFuture = ExcELIN1BusinessDelegate.getExcELIN1Instance().updateExcELIN1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcELIN1Controller:update() - successfully update ExcELIN1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcELIN1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excELIN1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcELIN1Command command = new DeleteExcELIN1Command(excELIN1Id);

    try {
      ExcELIN1BusinessDelegate delegate = ExcELIN1BusinessDelegate.getExcELIN1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcELIN1 with key " + command.getExcELIN1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dpnf on ExcELIN1
   *
   * @param command AssignDpnfToExcELIN1Command
   */
  @PutMapping("/assignDpnf")
  public void assignDpnf(@RequestBody AssignDpnfToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignDpnf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dpnf", exc);
    }
  }

  /**
   * unassign Dpnf on ExcELIN1
   *
   * @param command UnAssignDpnfFromExcELIN1Command
   */
  @PutMapping("/unAssignDpnf")
  public void unAssignDpnf(@RequestBody(required = true) UnAssignDpnfFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignDpnf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dpnf", exc);
    }
  }

  /**
   * save Efmax on ExcELIN1
   *
   * @param command AssignEfmaxToExcELIN1Command
   */
  @PutMapping("/assignEfmax")
  public void assignEfmax(@RequestBody AssignEfmaxToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignEfmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efmax", exc);
    }
  }

  /**
   * unassign Efmax on ExcELIN1
   *
   * @param command UnAssignEfmaxFromExcELIN1Command
   */
  @PutMapping("/unAssignEfmax")
  public void unAssignEfmax(
      @RequestBody(required = true) UnAssignEfmaxFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignEfmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efmax", exc);
    }
  }

  /**
   * save Efmin on ExcELIN1
   *
   * @param command AssignEfminToExcELIN1Command
   */
  @PutMapping("/assignEfmin")
  public void assignEfmin(@RequestBody AssignEfminToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignEfmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efmin", exc);
    }
  }

  /**
   * unassign Efmin on ExcELIN1
   *
   * @param command UnAssignEfminFromExcELIN1Command
   */
  @PutMapping("/unAssignEfmin")
  public void unAssignEfmin(
      @RequestBody(required = true) UnAssignEfminFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignEfmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efmin", exc);
    }
  }

  /**
   * save Ks1 on ExcELIN1
   *
   * @param command AssignKs1ToExcELIN1Command
   */
  @PutMapping("/assignKs1")
  public void assignKs1(@RequestBody AssignKs1ToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignKs1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks1", exc);
    }
  }

  /**
   * unassign Ks1 on ExcELIN1
   *
   * @param command UnAssignKs1FromExcELIN1Command
   */
  @PutMapping("/unAssignKs1")
  public void unAssignKs1(@RequestBody(required = true) UnAssignKs1FromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignKs1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks1", exc);
    }
  }

  /**
   * save Ks2 on ExcELIN1
   *
   * @param command AssignKs2ToExcELIN1Command
   */
  @PutMapping("/assignKs2")
  public void assignKs2(@RequestBody AssignKs2ToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignKs2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks2", exc);
    }
  }

  /**
   * unassign Ks2 on ExcELIN1
   *
   * @param command UnAssignKs2FromExcELIN1Command
   */
  @PutMapping("/unAssignKs2")
  public void unAssignKs2(@RequestBody(required = true) UnAssignKs2FromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignKs2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks2", exc);
    }
  }

  /**
   * save Smax on ExcELIN1
   *
   * @param command AssignSmaxToExcELIN1Command
   */
  @PutMapping("/assignSmax")
  public void assignSmax(@RequestBody AssignSmaxToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignSmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Smax", exc);
    }
  }

  /**
   * unassign Smax on ExcELIN1
   *
   * @param command UnAssignSmaxFromExcELIN1Command
   */
  @PutMapping("/unAssignSmax")
  public void unAssignSmax(@RequestBody(required = true) UnAssignSmaxFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignSmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Smax", exc);
    }
  }

  /**
   * save Tfi on ExcELIN1
   *
   * @param command AssignTfiToExcELIN1Command
   */
  @PutMapping("/assignTfi")
  public void assignTfi(@RequestBody AssignTfiToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignTfi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tfi", exc);
    }
  }

  /**
   * unassign Tfi on ExcELIN1
   *
   * @param command UnAssignTfiFromExcELIN1Command
   */
  @PutMapping("/unAssignTfi")
  public void unAssignTfi(@RequestBody(required = true) UnAssignTfiFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignTfi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tfi", exc);
    }
  }

  /**
   * save Tnu on ExcELIN1
   *
   * @param command AssignTnuToExcELIN1Command
   */
  @PutMapping("/assignTnu")
  public void assignTnu(@RequestBody AssignTnuToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignTnu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tnu", exc);
    }
  }

  /**
   * unassign Tnu on ExcELIN1
   *
   * @param command UnAssignTnuFromExcELIN1Command
   */
  @PutMapping("/unAssignTnu")
  public void unAssignTnu(@RequestBody(required = true) UnAssignTnuFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignTnu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tnu", exc);
    }
  }

  /**
   * save Ts1 on ExcELIN1
   *
   * @param command AssignTs1ToExcELIN1Command
   */
  @PutMapping("/assignTs1")
  public void assignTs1(@RequestBody AssignTs1ToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignTs1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts1", exc);
    }
  }

  /**
   * unassign Ts1 on ExcELIN1
   *
   * @param command UnAssignTs1FromExcELIN1Command
   */
  @PutMapping("/unAssignTs1")
  public void unAssignTs1(@RequestBody(required = true) UnAssignTs1FromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignTs1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts1", exc);
    }
  }

  /**
   * save Ts2 on ExcELIN1
   *
   * @param command AssignTs2ToExcELIN1Command
   */
  @PutMapping("/assignTs2")
  public void assignTs2(@RequestBody AssignTs2ToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignTs2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts2", exc);
    }
  }

  /**
   * unassign Ts2 on ExcELIN1
   *
   * @param command UnAssignTs2FromExcELIN1Command
   */
  @PutMapping("/unAssignTs2")
  public void unAssignTs2(@RequestBody(required = true) UnAssignTs2FromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignTs2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts2", exc);
    }
  }

  /**
   * save Tsw on ExcELIN1
   *
   * @param command AssignTswToExcELIN1Command
   */
  @PutMapping("/assignTsw")
  public void assignTsw(@RequestBody AssignTswToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignTsw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tsw", exc);
    }
  }

  /**
   * unassign Tsw on ExcELIN1
   *
   * @param command UnAssignTswFromExcELIN1Command
   */
  @PutMapping("/unAssignTsw")
  public void unAssignTsw(@RequestBody(required = true) UnAssignTswFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignTsw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tsw", exc);
    }
  }

  /**
   * save Vpi on ExcELIN1
   *
   * @param command AssignVpiToExcELIN1Command
   */
  @PutMapping("/assignVpi")
  public void assignVpi(@RequestBody AssignVpiToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignVpi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vpi", exc);
    }
  }

  /**
   * unassign Vpi on ExcELIN1
   *
   * @param command UnAssignVpiFromExcELIN1Command
   */
  @PutMapping("/unAssignVpi")
  public void unAssignVpi(@RequestBody(required = true) UnAssignVpiFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignVpi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vpi", exc);
    }
  }

  /**
   * save Vpnf on ExcELIN1
   *
   * @param command AssignVpnfToExcELIN1Command
   */
  @PutMapping("/assignVpnf")
  public void assignVpnf(@RequestBody AssignVpnfToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignVpnf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vpnf", exc);
    }
  }

  /**
   * unassign Vpnf on ExcELIN1
   *
   * @param command UnAssignVpnfFromExcELIN1Command
   */
  @PutMapping("/unAssignVpnf")
  public void unAssignVpnf(@RequestBody(required = true) UnAssignVpnfFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignVpnf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vpnf", exc);
    }
  }

  /**
   * save Vpu on ExcELIN1
   *
   * @param command AssignVpuToExcELIN1Command
   */
  @PutMapping("/assignVpu")
  public void assignVpu(@RequestBody AssignVpuToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignVpu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vpu", exc);
    }
  }

  /**
   * unassign Vpu on ExcELIN1
   *
   * @param command UnAssignVpuFromExcELIN1Command
   */
  @PutMapping("/unAssignVpu")
  public void unAssignVpu(@RequestBody(required = true) UnAssignVpuFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignVpu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vpu", exc);
    }
  }

  /**
   * save Xe on ExcELIN1
   *
   * @param command AssignXeToExcELIN1Command
   */
  @PutMapping("/assignXe")
  public void assignXe(@RequestBody AssignXeToExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().assignXe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xe", exc);
    }
  }

  /**
   * unassign Xe on ExcELIN1
   *
   * @param command UnAssignXeFromExcELIN1Command
   */
  @PutMapping("/unAssignXe")
  public void unAssignXe(@RequestBody(required = true) UnAssignXeFromExcELIN1Command command) {
    try {
      ExcELIN1BusinessDelegate.getExcELIN1Instance().unAssignXe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xe", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcELIN1 excELIN1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcELIN1CommandRestController.class.getName());
}
