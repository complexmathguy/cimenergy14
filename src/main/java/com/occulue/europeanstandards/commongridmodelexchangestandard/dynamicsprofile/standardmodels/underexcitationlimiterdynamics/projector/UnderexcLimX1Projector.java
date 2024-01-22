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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for UnderexcLimX1 as outlined for the CQRS pattern. All event handling and query
 * handling related to UnderexcLimX1 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by UnderexcLimX1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("underexcLimX1")
@Component("underexcLimX1-projector")
public class UnderexcLimX1Projector extends UnderexcLimX1EntityProjector {

  // core constructor
  public UnderexcLimX1Projector(
      UnderexcLimX1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateUnderexcLimX1Event
   */
  @EventHandler(payloadType = CreateUnderexcLimX1Event.class)
  public void handle(CreateUnderexcLimX1Event event) {
    LOGGER.info("handling CreateUnderexcLimX1Event - " + event);
    UnderexcLimX1 entity = new UnderexcLimX1();
    entity.setUnderexcLimX1Id(event.getUnderexcLimX1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event UpdateUnderexcLimX1Event
   */
  @EventHandler(payloadType = UpdateUnderexcLimX1Event.class)
  public void handle(UpdateUnderexcLimX1Event event) {
    LOGGER.info("handling UpdateUnderexcLimX1Event - " + event);

    UnderexcLimX1 entity = new UnderexcLimX1();
    entity.setUnderexcLimX1Id(event.getUnderexcLimX1Id());
    entity.setK(event.getK());
    entity.setKf2(event.getKf2());
    entity.setKm(event.getKm());
    entity.setMelmax(event.getMelmax());
    entity.setTf2(event.getTf2());
    entity.setTm(event.getTm());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event DeleteUnderexcLimX1Event
   */
  @EventHandler(payloadType = DeleteUnderexcLimX1Event.class)
  public void handle(DeleteUnderexcLimX1Event event) {
    LOGGER.info("handling DeleteUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    UnderexcLimX1 entity = delete(event.getUnderexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event AssignKToUnderexcLimX1Event
   */
  @EventHandler(payloadType = AssignKToUnderexcLimX1Event.class)
  public void handle(AssignKToUnderexcLimX1Event event) {
    LOGGER.info("handling AssignKToUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX1 entity = assignK(event.getUnderexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event UnAssignKFromUnderexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignKFromUnderexcLimX1Event.class)
  public void handle(UnAssignKFromUnderexcLimX1Event event) {
    LOGGER.info("handling UnAssignKFromUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX1 entity = unAssignK(event.getUnderexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event AssignKf2ToUnderexcLimX1Event
   */
  @EventHandler(payloadType = AssignKf2ToUnderexcLimX1Event.class)
  public void handle(AssignKf2ToUnderexcLimX1Event event) {
    LOGGER.info("handling AssignKf2ToUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX1 entity = assignKf2(event.getUnderexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event UnAssignKf2FromUnderexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignKf2FromUnderexcLimX1Event.class)
  public void handle(UnAssignKf2FromUnderexcLimX1Event event) {
    LOGGER.info("handling UnAssignKf2FromUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX1 entity = unAssignKf2(event.getUnderexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event AssignKmToUnderexcLimX1Event
   */
  @EventHandler(payloadType = AssignKmToUnderexcLimX1Event.class)
  public void handle(AssignKmToUnderexcLimX1Event event) {
    LOGGER.info("handling AssignKmToUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX1 entity = assignKm(event.getUnderexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event UnAssignKmFromUnderexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignKmFromUnderexcLimX1Event.class)
  public void handle(UnAssignKmFromUnderexcLimX1Event event) {
    LOGGER.info("handling UnAssignKmFromUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX1 entity = unAssignKm(event.getUnderexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event AssignMelmaxToUnderexcLimX1Event
   */
  @EventHandler(payloadType = AssignMelmaxToUnderexcLimX1Event.class)
  public void handle(AssignMelmaxToUnderexcLimX1Event event) {
    LOGGER.info("handling AssignMelmaxToUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX1 entity = assignMelmax(event.getUnderexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event UnAssignMelmaxFromUnderexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignMelmaxFromUnderexcLimX1Event.class)
  public void handle(UnAssignMelmaxFromUnderexcLimX1Event event) {
    LOGGER.info("handling UnAssignMelmaxFromUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX1 entity = unAssignMelmax(event.getUnderexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event AssignTf2ToUnderexcLimX1Event
   */
  @EventHandler(payloadType = AssignTf2ToUnderexcLimX1Event.class)
  public void handle(AssignTf2ToUnderexcLimX1Event event) {
    LOGGER.info("handling AssignTf2ToUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX1 entity = assignTf2(event.getUnderexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event UnAssignTf2FromUnderexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignTf2FromUnderexcLimX1Event.class)
  public void handle(UnAssignTf2FromUnderexcLimX1Event event) {
    LOGGER.info("handling UnAssignTf2FromUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX1 entity = unAssignTf2(event.getUnderexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event AssignTmToUnderexcLimX1Event
   */
  @EventHandler(payloadType = AssignTmToUnderexcLimX1Event.class)
  public void handle(AssignTmToUnderexcLimX1Event event) {
    LOGGER.info("handling AssignTmToUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX1 entity = assignTm(event.getUnderexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /*
   * @param	event UnAssignTmFromUnderexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignTmFromUnderexcLimX1Event.class)
  public void handle(UnAssignTmFromUnderexcLimX1Event event) {
    LOGGER.info("handling UnAssignTmFromUnderexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX1 entity = unAssignTm(event.getUnderexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX1(entity);
  }

  /**
   * Method to retrieve the UnderexcLimX1 via an UnderexcLimX1PrimaryKey.
   *
   * @param id Long
   * @return UnderexcLimX1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public UnderexcLimX1 handle(FindUnderexcLimX1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getUnderexcLimX1Id());
  }

  /**
   * Method to retrieve a collection of all UnderexcLimX1s
   *
   * @param query FindAllUnderexcLimX1Query
   * @return List<UnderexcLimX1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<UnderexcLimX1> handle(FindAllUnderexcLimX1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindUnderexcLimX1, but only if the id matches
   *
   * @param entity UnderexcLimX1
   */
  protected void emitFindUnderexcLimX1(UnderexcLimX1 entity) {
    LOGGER.info("handling emitFindUnderexcLimX1");

    queryUpdateEmitter.emit(
        FindUnderexcLimX1Query.class,
        query -> query.getFilter().getUnderexcLimX1Id().equals(entity.getUnderexcLimX1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllUnderexcLimX1
   *
   * @param entity UnderexcLimX1
   */
  protected void emitFindAllUnderexcLimX1(UnderexcLimX1 entity) {
    LOGGER.info("handling emitFindAllUnderexcLimX1");

    queryUpdateEmitter.emit(FindAllUnderexcLimX1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(UnderexcLimX1Projector.class.getName());
}
