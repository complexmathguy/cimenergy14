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
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SynchronousMachine as outlined for the CQRS pattern. All event handling and query
 * handling related to SynchronousMachine are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by SynchronousMachineAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("synchronousMachine")
@Component("synchronousMachine-projector")
public class SynchronousMachineProjector extends SynchronousMachineEntityProjector {

  // core constructor
  public SynchronousMachineProjector(
      SynchronousMachineRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSynchronousMachineEvent
   */
  @EventHandler(payloadType = CreateSynchronousMachineEvent.class)
  public void handle(CreateSynchronousMachineEvent event) {
    LOGGER.info("handling CreateSynchronousMachineEvent - " + event);
    SynchronousMachine entity = new SynchronousMachine();
    entity.setSynchronousMachineId(event.getSynchronousMachineId());
    entity.setShortCircuitRotorType(event.getShortCircuitRotorType());
    entity.setType(event.getType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UpdateSynchronousMachineEvent
   */
  @EventHandler(payloadType = UpdateSynchronousMachineEvent.class)
  public void handle(UpdateSynchronousMachineEvent event) {
    LOGGER.info("handling UpdateSynchronousMachineEvent - " + event);

    SynchronousMachine entity = new SynchronousMachine();
    entity.setSynchronousMachineId(event.getSynchronousMachineId());
    entity.setEarthing(event.getEarthing());
    entity.setEarthingStarPointR(event.getEarthingStarPointR());
    entity.setEarthingStarPointX(event.getEarthingStarPointX());
    entity.setIkk(event.getIkk());
    entity.setMaxQ(event.getMaxQ());
    entity.setMinQ(event.getMinQ());
    entity.setMu(event.getMu());
    entity.setQPercent(event.getQPercent());
    entity.setR(event.getR());
    entity.setR0(event.getR0());
    entity.setR2(event.getR2());
    entity.setSatDirectSubtransX(event.getSatDirectSubtransX());
    entity.setSatDirectSyncX(event.getSatDirectSyncX());
    entity.setSatDirectTransX(event.getSatDirectTransX());
    entity.setShortCircuitRotorType(event.getShortCircuitRotorType());
    entity.setType(event.getType());
    entity.setVoltageRegulationRange(event.getVoltageRegulationRange());
    entity.setX0(event.getX0());
    entity.setX2(event.getX2());
    entity.setInitiallyUsedBySynchronousMachines(event.getInitiallyUsedBySynchronousMachines());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event DeleteSynchronousMachineEvent
   */
  @EventHandler(payloadType = DeleteSynchronousMachineEvent.class)
  public void handle(DeleteSynchronousMachineEvent event) {
    LOGGER.info("handling DeleteSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SynchronousMachine entity = delete(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignEarthingToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignEarthingToSynchronousMachineEvent.class)
  public void handle(AssignEarthingToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignEarthingToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity =
        assignEarthing(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignEarthingFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignEarthingFromSynchronousMachineEvent.class)
  public void handle(UnAssignEarthingFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignEarthingFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignEarthing(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignEarthingStarPointRToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignEarthingStarPointRToSynchronousMachineEvent.class)
  public void handle(AssignEarthingStarPointRToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignEarthingStarPointRToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity =
        assignEarthingStarPointR(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignEarthingStarPointRFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignEarthingStarPointRFromSynchronousMachineEvent.class)
  public void handle(UnAssignEarthingStarPointRFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignEarthingStarPointRFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignEarthingStarPointR(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignEarthingStarPointXToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignEarthingStarPointXToSynchronousMachineEvent.class)
  public void handle(AssignEarthingStarPointXToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignEarthingStarPointXToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity =
        assignEarthingStarPointX(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignEarthingStarPointXFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignEarthingStarPointXFromSynchronousMachineEvent.class)
  public void handle(UnAssignEarthingStarPointXFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignEarthingStarPointXFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignEarthingStarPointX(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignIkkToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignIkkToSynchronousMachineEvent.class)
  public void handle(AssignIkkToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignIkkToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignIkk(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignIkkFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignIkkFromSynchronousMachineEvent.class)
  public void handle(UnAssignIkkFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignIkkFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignIkk(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignMaxQToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignMaxQToSynchronousMachineEvent.class)
  public void handle(AssignMaxQToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignMaxQToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignMaxQ(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignMaxQFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignMaxQFromSynchronousMachineEvent.class)
  public void handle(UnAssignMaxQFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignMaxQFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignMaxQ(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignMinQToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignMinQToSynchronousMachineEvent.class)
  public void handle(AssignMinQToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignMinQToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignMinQ(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignMinQFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignMinQFromSynchronousMachineEvent.class)
  public void handle(UnAssignMinQFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignMinQFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignMinQ(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignMuToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignMuToSynchronousMachineEvent.class)
  public void handle(AssignMuToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignMuToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignMu(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignMuFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignMuFromSynchronousMachineEvent.class)
  public void handle(UnAssignMuFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignMuFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignMu(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignQPercentToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignQPercentToSynchronousMachineEvent.class)
  public void handle(AssignQPercentToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignQPercentToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity =
        assignQPercent(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignQPercentFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignQPercentFromSynchronousMachineEvent.class)
  public void handle(UnAssignQPercentFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignQPercentFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignQPercent(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignRToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignRToSynchronousMachineEvent.class)
  public void handle(AssignRToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignRToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignR(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignRFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignRFromSynchronousMachineEvent.class)
  public void handle(UnAssignRFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignRFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignR(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignR0ToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignR0ToSynchronousMachineEvent.class)
  public void handle(AssignR0ToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignR0ToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignR0(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignR0FromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignR0FromSynchronousMachineEvent.class)
  public void handle(UnAssignR0FromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignR0FromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignR0(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignR2ToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignR2ToSynchronousMachineEvent.class)
  public void handle(AssignR2ToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignR2ToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignR2(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignR2FromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignR2FromSynchronousMachineEvent.class)
  public void handle(UnAssignR2FromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignR2FromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignR2(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignSatDirectSubtransXToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignSatDirectSubtransXToSynchronousMachineEvent.class)
  public void handle(AssignSatDirectSubtransXToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignSatDirectSubtransXToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity =
        assignSatDirectSubtransX(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignSatDirectSubtransXFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignSatDirectSubtransXFromSynchronousMachineEvent.class)
  public void handle(UnAssignSatDirectSubtransXFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignSatDirectSubtransXFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignSatDirectSubtransX(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignSatDirectSyncXToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignSatDirectSyncXToSynchronousMachineEvent.class)
  public void handle(AssignSatDirectSyncXToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignSatDirectSyncXToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity =
        assignSatDirectSyncX(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignSatDirectSyncXFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignSatDirectSyncXFromSynchronousMachineEvent.class)
  public void handle(UnAssignSatDirectSyncXFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignSatDirectSyncXFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignSatDirectSyncX(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignSatDirectTransXToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignSatDirectTransXToSynchronousMachineEvent.class)
  public void handle(AssignSatDirectTransXToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignSatDirectTransXToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity =
        assignSatDirectTransX(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignSatDirectTransXFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignSatDirectTransXFromSynchronousMachineEvent.class)
  public void handle(UnAssignSatDirectTransXFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignSatDirectTransXFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignSatDirectTransX(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignVoltageRegulationRangeToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignVoltageRegulationRangeToSynchronousMachineEvent.class)
  public void handle(AssignVoltageRegulationRangeToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignVoltageRegulationRangeToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity =
        assignVoltageRegulationRange(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignVoltageRegulationRangeFromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignVoltageRegulationRangeFromSynchronousMachineEvent.class)
  public void handle(UnAssignVoltageRegulationRangeFromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignVoltageRegulationRangeFromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignVoltageRegulationRange(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignX0ToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignX0ToSynchronousMachineEvent.class)
  public void handle(AssignX0ToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignX0ToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignX0(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignX0FromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignX0FromSynchronousMachineEvent.class)
  public void handle(UnAssignX0FromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignX0FromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignX0(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignX2ToSynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignX2ToSynchronousMachineEvent.class)
  public void handle(AssignX2ToSynchronousMachineEvent event) {
    LOGGER.info("handling AssignX2ToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachine entity = assignX2(event.getSynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignX2FromSynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignX2FromSynchronousMachineEvent.class)
  public void handle(UnAssignX2FromSynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignX2FromSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachine entity = unAssignX2(event.getSynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent
   */
  @EventHandler(
      payloadType = AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent.class)
  public void handle(AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent event) {
    LOGGER.info(
        "handling AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    SynchronousMachine entity =
        addToInitiallyUsedBySynchronousMachines(event.getSynchronousMachineId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /*
   * @param	event RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent
   */
  @EventHandler(
      payloadType = RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent.class)
  public void handle(RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent event) {
    LOGGER.info(
        "handling RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent - " + event);

    SynchronousMachine entity =
        removeFromInitiallyUsedBySynchronousMachines(
            event.getSynchronousMachineId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachine(entity);
  }

  /**
   * Method to retrieve the SynchronousMachine via an SynchronousMachinePrimaryKey.
   *
   * @param id Long
   * @return SynchronousMachine
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SynchronousMachine handle(FindSynchronousMachineQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSynchronousMachineId());
  }

  /**
   * Method to retrieve a collection of all SynchronousMachines
   *
   * @param query FindAllSynchronousMachineQuery
   * @return List<SynchronousMachine>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SynchronousMachine> handle(FindAllSynchronousMachineQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSynchronousMachine, but only if the id matches
   *
   * @param entity SynchronousMachine
   */
  protected void emitFindSynchronousMachine(SynchronousMachine entity) {
    LOGGER.info("handling emitFindSynchronousMachine");

    queryUpdateEmitter.emit(
        FindSynchronousMachineQuery.class,
        query ->
            query.getFilter().getSynchronousMachineId().equals(entity.getSynchronousMachineId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSynchronousMachine
   *
   * @param entity SynchronousMachine
   */
  protected void emitFindAllSynchronousMachine(SynchronousMachine entity) {
    LOGGER.info("handling emitFindAllSynchronousMachine");

    queryUpdateEmitter.emit(FindAllSynchronousMachineQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineProjector.class.getName());
}
