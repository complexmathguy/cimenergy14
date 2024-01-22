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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity EquipmentVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquipmentVersion")
public class EquipmentVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EquipmentVersion. if not key provided, calls create, otherwise calls save
   *
   * @param EquipmentVersion equipmentVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEquipmentVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
              .createEquipmentVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EquipmentVersion. if no key provided, calls create, otherwise calls save
   *
   * @param EquipmentVersion equipmentVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEquipmentVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEquipmentVersionCommand
      // -----------------------------------------------
      completableFuture =
          EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
              .updateEquipmentVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EquipmentVersionController:update() - successfully update EquipmentVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EquipmentVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID equipmentVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEquipmentVersionCommand command = new DeleteEquipmentVersionCommand(equipmentVersionId);

    try {
      EquipmentVersionBusinessDelegate delegate =
          EquipmentVersionBusinessDelegate.getEquipmentVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EquipmentVersion with key " + command.getEquipmentVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on EquipmentVersion
   *
   * @param command AssignBaseUMLToEquipmentVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(@RequestBody AssignBaseUMLToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on EquipmentVersion
   *
   * @param command UnAssignBaseUMLFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURIcore on EquipmentVersion
   *
   * @param command AssignBaseURIcoreToEquipmentVersionCommand
   */
  @PutMapping("/assignBaseURIcore")
  public void assignBaseURIcore(@RequestBody AssignBaseURIcoreToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().assignBaseURIcore(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURIcore", exc);
    }
  }

  /**
   * unassign BaseURIcore on EquipmentVersion
   *
   * @param command UnAssignBaseURIcoreFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignBaseURIcore")
  public void unAssignBaseURIcore(
      @RequestBody(required = true) UnAssignBaseURIcoreFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().unAssignBaseURIcore(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURIcore", exc);
    }
  }

  /**
   * save BaseURIoperation on EquipmentVersion
   *
   * @param command AssignBaseURIoperationToEquipmentVersionCommand
   */
  @PutMapping("/assignBaseURIoperation")
  public void assignBaseURIoperation(
      @RequestBody AssignBaseURIoperationToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .assignBaseURIoperation(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURIoperation", exc);
    }
  }

  /**
   * unassign BaseURIoperation on EquipmentVersion
   *
   * @param command UnAssignBaseURIoperationFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignBaseURIoperation")
  public void unAssignBaseURIoperation(
      @RequestBody(required = true) UnAssignBaseURIoperationFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .unAssignBaseURIoperation(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURIoperation", exc);
    }
  }

  /**
   * save BaseURIshortCircuit on EquipmentVersion
   *
   * @param command AssignBaseURIshortCircuitToEquipmentVersionCommand
   */
  @PutMapping("/assignBaseURIshortCircuit")
  public void assignBaseURIshortCircuit(
      @RequestBody AssignBaseURIshortCircuitToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .assignBaseURIshortCircuit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURIshortCircuit", exc);
    }
  }

  /**
   * unassign BaseURIshortCircuit on EquipmentVersion
   *
   * @param command UnAssignBaseURIshortCircuitFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignBaseURIshortCircuit")
  public void unAssignBaseURIshortCircuit(
      @RequestBody(required = true)
          UnAssignBaseURIshortCircuitFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .unAssignBaseURIshortCircuit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURIshortCircuit", exc);
    }
  }

  /**
   * save Date on EquipmentVersion
   *
   * @param command AssignDateToEquipmentVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on EquipmentVersion
   *
   * @param command UnAssignDateFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on EquipmentVersion
   *
   * @param command AssignDifferenceModelURIToEquipmentVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on EquipmentVersion
   *
   * @param command UnAssignDifferenceModelURIFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true) UnAssignDifferenceModelURIFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on EquipmentVersion
   *
   * @param command AssignEntsoeUMLToEquipmentVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(@RequestBody AssignEntsoeUMLToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on EquipmentVersion
   *
   * @param command UnAssignEntsoeUMLFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true) UnAssignEntsoeUMLFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURIcore on EquipmentVersion
   *
   * @param command AssignEntsoeURIcoreToEquipmentVersionCommand
   */
  @PutMapping("/assignEntsoeURIcore")
  public void assignEntsoeURIcore(
      @RequestBody AssignEntsoeURIcoreToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().assignEntsoeURIcore(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURIcore", exc);
    }
  }

  /**
   * unassign EntsoeURIcore on EquipmentVersion
   *
   * @param command UnAssignEntsoeURIcoreFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignEntsoeURIcore")
  public void unAssignEntsoeURIcore(
      @RequestBody(required = true) UnAssignEntsoeURIcoreFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().unAssignEntsoeURIcore(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURIcore", exc);
    }
  }

  /**
   * save EntsoeURIoperation on EquipmentVersion
   *
   * @param command AssignEntsoeURIoperationToEquipmentVersionCommand
   */
  @PutMapping("/assignEntsoeURIoperation")
  public void assignEntsoeURIoperation(
      @RequestBody AssignEntsoeURIoperationToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .assignEntsoeURIoperation(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURIoperation", exc);
    }
  }

  /**
   * unassign EntsoeURIoperation on EquipmentVersion
   *
   * @param command UnAssignEntsoeURIoperationFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignEntsoeURIoperation")
  public void unAssignEntsoeURIoperation(
      @RequestBody(required = true) UnAssignEntsoeURIoperationFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .unAssignEntsoeURIoperation(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURIoperation", exc);
    }
  }

  /**
   * save EntsoeURIshortCircuit on EquipmentVersion
   *
   * @param command AssignEntsoeURIshortCircuitToEquipmentVersionCommand
   */
  @PutMapping("/assignEntsoeURIshortCircuit")
  public void assignEntsoeURIshortCircuit(
      @RequestBody AssignEntsoeURIshortCircuitToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .assignEntsoeURIshortCircuit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURIshortCircuit", exc);
    }
  }

  /**
   * unassign EntsoeURIshortCircuit on EquipmentVersion
   *
   * @param command UnAssignEntsoeURIshortCircuitFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignEntsoeURIshortCircuit")
  public void unAssignEntsoeURIshortCircuit(
      @RequestBody(required = true)
          UnAssignEntsoeURIshortCircuitFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .unAssignEntsoeURIshortCircuit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURIshortCircuit", exc);
    }
  }

  /**
   * save ModelDescriptionURI on EquipmentVersion
   *
   * @param command AssignModelDescriptionURIToEquipmentVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on EquipmentVersion
   *
   * @param command UnAssignModelDescriptionURIFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true)
          UnAssignModelDescriptionURIFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on EquipmentVersion
   *
   * @param command AssignNamespaceRDFToEquipmentVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(@RequestBody AssignNamespaceRDFToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on EquipmentVersion
   *
   * @param command UnAssignNamespaceRDFFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true) UnAssignNamespaceRDFFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on EquipmentVersion
   *
   * @param command AssignNamespaceUMLToEquipmentVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(@RequestBody AssignNamespaceUMLToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on EquipmentVersion
   *
   * @param command UnAssignNamespaceUMLFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true) UnAssignNamespaceUMLFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on EquipmentVersion
   *
   * @param command AssignShortNameToEquipmentVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(@RequestBody AssignShortNameToEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on EquipmentVersion
   *
   * @param command UnAssignShortNameFromEquipmentVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromEquipmentVersionCommand command) {
    try {
      EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EquipmentVersion equipmentVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(EquipmentVersionCommandRestController.class.getName());
}
