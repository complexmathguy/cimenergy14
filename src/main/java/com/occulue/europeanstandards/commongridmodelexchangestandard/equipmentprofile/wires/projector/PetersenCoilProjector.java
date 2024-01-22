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
 * Projector for PetersenCoil as outlined for the CQRS pattern. All event handling and query
 * handling related to PetersenCoil are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by PetersenCoilAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("petersenCoil")
@Component("petersenCoil-projector")
public class PetersenCoilProjector extends PetersenCoilEntityProjector {

  // core constructor
  public PetersenCoilProjector(
      PetersenCoilRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePetersenCoilEvent
   */
  @EventHandler(payloadType = CreatePetersenCoilEvent.class)
  public void handle(CreatePetersenCoilEvent event) {
    LOGGER.info("handling CreatePetersenCoilEvent - " + event);
    PetersenCoil entity = new PetersenCoil();
    entity.setPetersenCoilId(event.getPetersenCoilId());
    entity.setMode(event.getMode());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event UpdatePetersenCoilEvent
   */
  @EventHandler(payloadType = UpdatePetersenCoilEvent.class)
  public void handle(UpdatePetersenCoilEvent event) {
    LOGGER.info("handling UpdatePetersenCoilEvent - " + event);

    PetersenCoil entity = new PetersenCoil();
    entity.setPetersenCoilId(event.getPetersenCoilId());
    entity.setMode(event.getMode());
    entity.setNominalU(event.getNominalU());
    entity.setOffsetCurrent(event.getOffsetCurrent());
    entity.setPositionCurrent(event.getPositionCurrent());
    entity.setXGroundMax(event.getXGroundMax());
    entity.setXGroundMin(event.getXGroundMin());
    entity.setXGroundNominal(event.getXGroundNominal());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event DeletePetersenCoilEvent
   */
  @EventHandler(payloadType = DeletePetersenCoilEvent.class)
  public void handle(DeletePetersenCoilEvent event) {
    LOGGER.info("handling DeletePetersenCoilEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PetersenCoil entity = delete(event.getPetersenCoilId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event AssignNominalUToPetersenCoilEvent
   */
  @EventHandler(payloadType = AssignNominalUToPetersenCoilEvent.class)
  public void handle(AssignNominalUToPetersenCoilEvent event) {
    LOGGER.info("handling AssignNominalUToPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PetersenCoil entity = assignNominalU(event.getPetersenCoilId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event UnAssignNominalUFromPetersenCoilEvent
   */
  @EventHandler(payloadType = UnAssignNominalUFromPetersenCoilEvent.class)
  public void handle(UnAssignNominalUFromPetersenCoilEvent event) {
    LOGGER.info("handling UnAssignNominalUFromPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PetersenCoil entity = unAssignNominalU(event.getPetersenCoilId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event AssignOffsetCurrentToPetersenCoilEvent
   */
  @EventHandler(payloadType = AssignOffsetCurrentToPetersenCoilEvent.class)
  public void handle(AssignOffsetCurrentToPetersenCoilEvent event) {
    LOGGER.info("handling AssignOffsetCurrentToPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PetersenCoil entity = assignOffsetCurrent(event.getPetersenCoilId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event UnAssignOffsetCurrentFromPetersenCoilEvent
   */
  @EventHandler(payloadType = UnAssignOffsetCurrentFromPetersenCoilEvent.class)
  public void handle(UnAssignOffsetCurrentFromPetersenCoilEvent event) {
    LOGGER.info("handling UnAssignOffsetCurrentFromPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PetersenCoil entity = unAssignOffsetCurrent(event.getPetersenCoilId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event AssignPositionCurrentToPetersenCoilEvent
   */
  @EventHandler(payloadType = AssignPositionCurrentToPetersenCoilEvent.class)
  public void handle(AssignPositionCurrentToPetersenCoilEvent event) {
    LOGGER.info("handling AssignPositionCurrentToPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PetersenCoil entity = assignPositionCurrent(event.getPetersenCoilId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event UnAssignPositionCurrentFromPetersenCoilEvent
   */
  @EventHandler(payloadType = UnAssignPositionCurrentFromPetersenCoilEvent.class)
  public void handle(UnAssignPositionCurrentFromPetersenCoilEvent event) {
    LOGGER.info("handling UnAssignPositionCurrentFromPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PetersenCoil entity = unAssignPositionCurrent(event.getPetersenCoilId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event AssignXGroundMaxToPetersenCoilEvent
   */
  @EventHandler(payloadType = AssignXGroundMaxToPetersenCoilEvent.class)
  public void handle(AssignXGroundMaxToPetersenCoilEvent event) {
    LOGGER.info("handling AssignXGroundMaxToPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PetersenCoil entity = assignXGroundMax(event.getPetersenCoilId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event UnAssignXGroundMaxFromPetersenCoilEvent
   */
  @EventHandler(payloadType = UnAssignXGroundMaxFromPetersenCoilEvent.class)
  public void handle(UnAssignXGroundMaxFromPetersenCoilEvent event) {
    LOGGER.info("handling UnAssignXGroundMaxFromPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PetersenCoil entity = unAssignXGroundMax(event.getPetersenCoilId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event AssignXGroundMinToPetersenCoilEvent
   */
  @EventHandler(payloadType = AssignXGroundMinToPetersenCoilEvent.class)
  public void handle(AssignXGroundMinToPetersenCoilEvent event) {
    LOGGER.info("handling AssignXGroundMinToPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PetersenCoil entity = assignXGroundMin(event.getPetersenCoilId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event UnAssignXGroundMinFromPetersenCoilEvent
   */
  @EventHandler(payloadType = UnAssignXGroundMinFromPetersenCoilEvent.class)
  public void handle(UnAssignXGroundMinFromPetersenCoilEvent event) {
    LOGGER.info("handling UnAssignXGroundMinFromPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PetersenCoil entity = unAssignXGroundMin(event.getPetersenCoilId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event AssignXGroundNominalToPetersenCoilEvent
   */
  @EventHandler(payloadType = AssignXGroundNominalToPetersenCoilEvent.class)
  public void handle(AssignXGroundNominalToPetersenCoilEvent event) {
    LOGGER.info("handling AssignXGroundNominalToPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PetersenCoil entity = assignXGroundNominal(event.getPetersenCoilId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /*
   * @param	event UnAssignXGroundNominalFromPetersenCoilEvent
   */
  @EventHandler(payloadType = UnAssignXGroundNominalFromPetersenCoilEvent.class)
  public void handle(UnAssignXGroundNominalFromPetersenCoilEvent event) {
    LOGGER.info("handling UnAssignXGroundNominalFromPetersenCoilEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PetersenCoil entity = unAssignXGroundNominal(event.getPetersenCoilId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPetersenCoil(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPetersenCoil(entity);
  }

  /**
   * Method to retrieve the PetersenCoil via an PetersenCoilPrimaryKey.
   *
   * @param id Long
   * @return PetersenCoil
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PetersenCoil handle(FindPetersenCoilQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPetersenCoilId());
  }

  /**
   * Method to retrieve a collection of all PetersenCoils
   *
   * @param query FindAllPetersenCoilQuery
   * @return List<PetersenCoil>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PetersenCoil> handle(FindAllPetersenCoilQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPetersenCoil, but only if the id matches
   *
   * @param entity PetersenCoil
   */
  protected void emitFindPetersenCoil(PetersenCoil entity) {
    LOGGER.info("handling emitFindPetersenCoil");

    queryUpdateEmitter.emit(
        FindPetersenCoilQuery.class,
        query -> query.getFilter().getPetersenCoilId().equals(entity.getPetersenCoilId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPetersenCoil
   *
   * @param entity PetersenCoil
   */
  protected void emitFindAllPetersenCoil(PetersenCoil entity) {
    LOGGER.info("handling emitFindAllPetersenCoil");

    queryUpdateEmitter.emit(FindAllPetersenCoilQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PetersenCoilProjector.class.getName());
}
