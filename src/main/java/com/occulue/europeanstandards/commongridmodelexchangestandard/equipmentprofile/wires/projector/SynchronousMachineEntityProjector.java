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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SynchronousMachine as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SynchronousMachineAggregate
 *
 * @author your_name_here
 */
@Component("synchronousMachine-entity-projector")
public class SynchronousMachineEntityProjector {

  // core constructor
  public SynchronousMachineEntityProjector(SynchronousMachineRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SynchronousMachine
   *
   * @param	entity SynchronousMachine
   */
  public SynchronousMachine create(SynchronousMachine entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SynchronousMachine
   *
   * @param	entity SynchronousMachine
   */
  public SynchronousMachine update(SynchronousMachine entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SynchronousMachine
   *
   * @param	id		UUID
   */
  public SynchronousMachine delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SynchronousMachine entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Earthing
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignEarthing(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Earthing as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Earthing to the parent entity
    // ------------------------------------------
    parentEntity.setEarthing(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Earthing
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignEarthing(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Earthing on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Earthing on the parent entithy
    // ------------------------------------------
    parentEntity.setEarthing(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EarthingStarPointR
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignEarthingStarPointR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning EarthingStarPointR as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the EarthingStarPointR to the parent entity
    // ------------------------------------------
    parentEntity.setEarthingStarPointR(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EarthingStarPointR
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignEarthingStarPointR(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EarthingStarPointR on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EarthingStarPointR on the parent entithy
    // ------------------------------------------
    parentEntity.setEarthingStarPointR(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EarthingStarPointX
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignEarthingStarPointX(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning EarthingStarPointX as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the EarthingStarPointX to the parent entity
    // ------------------------------------------
    parentEntity.setEarthingStarPointX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EarthingStarPointX
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignEarthingStarPointX(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EarthingStarPointX on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EarthingStarPointX on the parent entithy
    // ------------------------------------------
    parentEntity.setEarthingStarPointX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ikk
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignIkk(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning Ikk as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the Ikk to the parent entity
    // ------------------------------------------
    parentEntity.setIkk(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ikk
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignIkk(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ikk on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ikk on the parent entithy
    // ------------------------------------------
    parentEntity.setIkk(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxQ
   *
   * @param	parentId	UUID
   * @param	assignment 	ReactivePower
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignMaxQ(UUID parentId, ReactivePower assignment) {
    LOGGER.info("assigning MaxQ as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = ReactivePowerProjector.find(assignment.getReactivePowerId());

    // ------------------------------------------
    // assign the MaxQ to the parent entity
    // ------------------------------------------
    parentEntity.setMaxQ(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxQ
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignMaxQ(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxQ on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxQ on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxQ(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinQ
   *
   * @param	parentId	UUID
   * @param	assignment 	ReactivePower
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignMinQ(UUID parentId, ReactivePower assignment) {
    LOGGER.info("assigning MinQ as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = ReactivePowerProjector.find(assignment.getReactivePowerId());

    // ------------------------------------------
    // assign the MinQ to the parent entity
    // ------------------------------------------
    parentEntity.setMinQ(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinQ
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignMinQ(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinQ on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinQ on the parent entithy
    // ------------------------------------------
    parentEntity.setMinQ(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mu
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignMu(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Mu as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Mu to the parent entity
    // ------------------------------------------
    parentEntity.setMu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mu
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignMu(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mu on the parent entithy
    // ------------------------------------------
    parentEntity.setMu(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a QPercent
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignQPercent(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning QPercent as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the QPercent to the parent entity
    // ------------------------------------------
    parentEntity.setQPercent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the QPercent
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignQPercent(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning QPercent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the QPercent on the parent entithy
    // ------------------------------------------
    parentEntity.setQPercent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R to the parent entity
    // ------------------------------------------
    parentEntity.setR(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignR(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R on the parent entithy
    // ------------------------------------------
    parentEntity.setR(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignR0(UUID parentId, PU assignment) {
    LOGGER.info("assigning R0 as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the R0 to the parent entity
    // ------------------------------------------
    parentEntity.setR0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R0
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignR0(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R0 on the parent entithy
    // ------------------------------------------
    parentEntity.setR0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignR2(UUID parentId, PU assignment) {
    LOGGER.info("assigning R2 as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the R2 to the parent entity
    // ------------------------------------------
    parentEntity.setR2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R2
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignR2(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R2 on the parent entithy
    // ------------------------------------------
    parentEntity.setR2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SatDirectSubtransX
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignSatDirectSubtransX(UUID parentId, PU assignment) {
    LOGGER.info("assigning SatDirectSubtransX as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the SatDirectSubtransX to the parent entity
    // ------------------------------------------
    parentEntity.setSatDirectSubtransX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SatDirectSubtransX
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignSatDirectSubtransX(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SatDirectSubtransX on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SatDirectSubtransX on the parent entithy
    // ------------------------------------------
    parentEntity.setSatDirectSubtransX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SatDirectSyncX
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignSatDirectSyncX(UUID parentId, PU assignment) {
    LOGGER.info("assigning SatDirectSyncX as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the SatDirectSyncX to the parent entity
    // ------------------------------------------
    parentEntity.setSatDirectSyncX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SatDirectSyncX
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignSatDirectSyncX(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SatDirectSyncX on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SatDirectSyncX on the parent entithy
    // ------------------------------------------
    parentEntity.setSatDirectSyncX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SatDirectTransX
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignSatDirectTransX(UUID parentId, PU assignment) {
    LOGGER.info("assigning SatDirectTransX as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the SatDirectTransX to the parent entity
    // ------------------------------------------
    parentEntity.setSatDirectTransX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SatDirectTransX
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignSatDirectTransX(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SatDirectTransX on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SatDirectTransX on the parent entithy
    // ------------------------------------------
    parentEntity.setSatDirectTransX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a VoltageRegulationRange
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignVoltageRegulationRange(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning VoltageRegulationRange as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the VoltageRegulationRange to the parent entity
    // ------------------------------------------
    parentEntity.setVoltageRegulationRange(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VoltageRegulationRange
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignVoltageRegulationRange(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VoltageRegulationRange on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VoltageRegulationRange on the parent entithy
    // ------------------------------------------
    parentEntity.setVoltageRegulationRange(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignX0(UUID parentId, PU assignment) {
    LOGGER.info("assigning X0 as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the X0 to the parent entity
    // ------------------------------------------
    parentEntity.setX0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X0
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignX0(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X0 on the parent entithy
    // ------------------------------------------
    parentEntity.setX0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachine
   */
  public SynchronousMachine assignX2(UUID parentId, PU assignment) {
    LOGGER.info("assigning X2 as " + assignment.toString());

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the X2 to the parent entity
    // ------------------------------------------
    parentEntity.setX2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X2
   *
   * @param	parentId		UUID
   * @return	SynchronousMachine
   */
  public SynchronousMachine unAssignX2(UUID parentId) {
    SynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X2 on the parent entithy
    // ------------------------------------------
    parentEntity.setX2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the InitiallyUsedBySynchronousMachines
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	SynchronousMachine
   */
  public SynchronousMachine addToInitiallyUsedBySynchronousMachines(
      UUID parentId, SynchronousMachine addTo) {
    LOGGER.info("handling AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent - ");

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    SynchronousMachine child = SynchronousMachineProjector.find(addTo.getSynchronousMachineId());

    parentEntity.getInitiallyUsedBySynchronousMachines().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the InitiallyUsedBySynchronousMachines
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	SynchronousMachine
   */
  public SynchronousMachine removeFromInitiallyUsedBySynchronousMachines(
      UUID parentId, SynchronousMachine removeFrom) {
    LOGGER.info("handling RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent ");

    SynchronousMachine parentEntity = repository.findById(parentId).get();
    SynchronousMachine child =
        SynchronousMachineProjector.find(removeFrom.getSynchronousMachineId());

    parentEntity.getInitiallyUsedBySynchronousMachines().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SynchronousMachine via an FindSynchronousMachineQuery
   *
   * @return query FindSynchronousMachineQuery
   */
  @SuppressWarnings("unused")
  public SynchronousMachine find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SynchronousMachine - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachines
   *
   * @param query FindAllSynchronousMachineQuery
   * @return List<SynchronousMachine>
   */
  @SuppressWarnings("unused")
  public List<SynchronousMachine> findAll(FindAllSynchronousMachineQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SynchronousMachine - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SynchronousMachineRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  @Autowired
  @Qualifier(value = "reactivePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactivePowerEntityProjector
      ReactivePowerProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "perCent-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PerCentEntityProjector
      PerCentProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "synchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .SynchronousMachineEntityProjector
      SynchronousMachineProjector;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineEntityProjector.class.getName());
}
