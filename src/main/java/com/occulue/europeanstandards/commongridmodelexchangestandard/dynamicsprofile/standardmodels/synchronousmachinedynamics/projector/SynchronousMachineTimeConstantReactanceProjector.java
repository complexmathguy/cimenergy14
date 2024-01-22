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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SynchronousMachineTimeConstantReactance as outlined for the CQRS pattern. All event
 * handling and query handling related to SynchronousMachineTimeConstantReactance are invoked here
 * and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by SynchronousMachineTimeConstantReactanceAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("synchronousMachineTimeConstantReactance")
@Component("synchronousMachineTimeConstantReactance-projector")
public class SynchronousMachineTimeConstantReactanceProjector
    extends SynchronousMachineTimeConstantReactanceEntityProjector {

  // core constructor
  public SynchronousMachineTimeConstantReactanceProjector(
      SynchronousMachineTimeConstantReactanceRepository repository,
      QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = CreateSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(CreateSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling CreateSynchronousMachineTimeConstantReactanceEvent - " + event);
    SynchronousMachineTimeConstantReactance entity = new SynchronousMachineTimeConstantReactance();
    entity.setSynchronousMachineTimeConstantReactanceId(
        event.getSynchronousMachineTimeConstantReactanceId());
    entity.setModelType(event.getModelType());
    entity.setRotorType(event.getRotorType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UpdateSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UpdateSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UpdateSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UpdateSynchronousMachineTimeConstantReactanceEvent - " + event);

    SynchronousMachineTimeConstantReactance entity = new SynchronousMachineTimeConstantReactance();
    entity.setSynchronousMachineTimeConstantReactanceId(
        event.getSynchronousMachineTimeConstantReactanceId());
    entity.setKs(event.getKs());
    entity.setModelType(event.getModelType());
    entity.setRotorType(event.getRotorType());
    entity.setTc(event.getTc());
    entity.setTpdo(event.getTpdo());
    entity.setTppdo(event.getTppdo());
    entity.setTppqo(event.getTppqo());
    entity.setTpqo(event.getTpqo());
    entity.setXDirectSubtrans(event.getXDirectSubtrans());
    entity.setXDirectSync(event.getXDirectSync());
    entity.setXDirectTrans(event.getXDirectTrans());
    entity.setXQuadSubtrans(event.getXQuadSubtrans());
    entity.setXQuadSync(event.getXQuadSync());
    entity.setXQuadTrans(event.getXQuadTrans());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event DeleteSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = DeleteSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(DeleteSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling DeleteSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        delete(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignKsToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignKsToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignKsToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignKsToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignKs(event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignKsFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignKsFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignKsFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UnAssignKsFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignKs(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignTcToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignTcToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignTcToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignTcToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignTc(event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignTcFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignTcFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignTcFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UnAssignTcFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignTc(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignTpdoToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignTpdoToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignTpdoToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignTpdoToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignTpdo(event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignTpdoFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignTpdoFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignTpdoFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UnAssignTpdoFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignTpdo(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignTppdoToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignTppdoToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignTppdoToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignTppdoToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignTppdo(event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignTppdoFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignTppdoFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignTppdoFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignTppdoFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignTppdo(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignTppqoToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignTppqoToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignTppqoToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignTppqoToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignTppqo(event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignTppqoFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignTppqoFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignTppqoFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignTppqoFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignTppqo(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignTpqoToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignTpqoToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignTpqoToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignTpqoToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignTpqo(event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignTpqoFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignTpqoFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignTpqoFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UnAssignTpqoFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignTpqo(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignXDirectSubtrans(
            event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(
      UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceEvent - "
            + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignXDirectSubtrans(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXDirectSyncToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignXDirectSyncToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXDirectSyncToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling AssignXDirectSyncToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignXDirectSync(
            event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignXDirectSync(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXDirectTransToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = AssignXDirectTransToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXDirectTransToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling AssignXDirectTransToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignXDirectTrans(
            event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignXDirectTrans(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignXQuadSubtrans(
            event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceEvent - "
            + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignXQuadSubtrans(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXQuadSyncToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignXQuadSyncToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXQuadSyncToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling AssignXQuadSyncToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignXQuadSync(
            event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignXQuadSync(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXQuadTransToSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignXQuadTransToSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXQuadTransToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling AssignXQuadTransToSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        assignXQuadTrans(
            event.getSynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(
      payloadType = UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity =
        unAssignXQuadTrans(event.getSynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineTimeConstantReactance(entity);
  }

  /**
   * Method to retrieve the SynchronousMachineTimeConstantReactance via an
   * SynchronousMachineTimeConstantReactancePrimaryKey.
   *
   * @param id Long
   * @return SynchronousMachineTimeConstantReactance
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SynchronousMachineTimeConstantReactance handle(
      FindSynchronousMachineTimeConstantReactanceQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSynchronousMachineTimeConstantReactanceId());
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineTimeConstantReactances
   *
   * @param query FindAllSynchronousMachineTimeConstantReactanceQuery
   * @return List<SynchronousMachineTimeConstantReactance>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SynchronousMachineTimeConstantReactance> handle(
      FindAllSynchronousMachineTimeConstantReactanceQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSynchronousMachineTimeConstantReactance, but only if
   * the id matches
   *
   * @param entity SynchronousMachineTimeConstantReactance
   */
  protected void emitFindSynchronousMachineTimeConstantReactance(
      SynchronousMachineTimeConstantReactance entity) {
    LOGGER.info("handling emitFindSynchronousMachineTimeConstantReactance");

    queryUpdateEmitter.emit(
        FindSynchronousMachineTimeConstantReactanceQuery.class,
        query ->
            query
                .getFilter()
                .getSynchronousMachineTimeConstantReactanceId()
                .equals(entity.getSynchronousMachineTimeConstantReactanceId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type
   * FindAllSynchronousMachineTimeConstantReactance
   *
   * @param entity SynchronousMachineTimeConstantReactance
   */
  protected void emitFindAllSynchronousMachineTimeConstantReactance(
      SynchronousMachineTimeConstantReactance entity) {
    LOGGER.info("handling emitFindAllSynchronousMachineTimeConstantReactance");

    queryUpdateEmitter.emit(
        FindAllSynchronousMachineTimeConstantReactanceQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineTimeConstantReactanceProjector.class.getName());
}
