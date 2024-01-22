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
 * Projector for UnderexcLimX2 as outlined for the CQRS pattern. All event handling and query
 * handling related to UnderexcLimX2 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by UnderexcLimX2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("underexcLimX2")
@Component("underexcLimX2-projector")
public class UnderexcLimX2Projector extends UnderexcLimX2EntityProjector {

  // core constructor
  public UnderexcLimX2Projector(
      UnderexcLimX2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateUnderexcLimX2Event
   */
  @EventHandler(payloadType = CreateUnderexcLimX2Event.class)
  public void handle(CreateUnderexcLimX2Event event) {
    LOGGER.info("handling CreateUnderexcLimX2Event - " + event);
    UnderexcLimX2 entity = new UnderexcLimX2();
    entity.setUnderexcLimX2Id(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event UpdateUnderexcLimX2Event
   */
  @EventHandler(payloadType = UpdateUnderexcLimX2Event.class)
  public void handle(UpdateUnderexcLimX2Event event) {
    LOGGER.info("handling UpdateUnderexcLimX2Event - " + event);

    UnderexcLimX2 entity = new UnderexcLimX2();
    entity.setUnderexcLimX2Id(event.getUnderexcLimX2Id());
    entity.setKf2(event.getKf2());
    entity.setKm(event.getKm());
    entity.setMelmax(event.getMelmax());
    entity.setQo(event.getQo());
    entity.setR(event.getR());
    entity.setTf2(event.getTf2());
    entity.setTm(event.getTm());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event DeleteUnderexcLimX2Event
   */
  @EventHandler(payloadType = DeleteUnderexcLimX2Event.class)
  public void handle(DeleteUnderexcLimX2Event event) {
    LOGGER.info("handling DeleteUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    UnderexcLimX2 entity = delete(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event AssignKf2ToUnderexcLimX2Event
   */
  @EventHandler(payloadType = AssignKf2ToUnderexcLimX2Event.class)
  public void handle(AssignKf2ToUnderexcLimX2Event event) {
    LOGGER.info("handling AssignKf2ToUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX2 entity = assignKf2(event.getUnderexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event UnAssignKf2FromUnderexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignKf2FromUnderexcLimX2Event.class)
  public void handle(UnAssignKf2FromUnderexcLimX2Event event) {
    LOGGER.info("handling UnAssignKf2FromUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX2 entity = unAssignKf2(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event AssignKmToUnderexcLimX2Event
   */
  @EventHandler(payloadType = AssignKmToUnderexcLimX2Event.class)
  public void handle(AssignKmToUnderexcLimX2Event event) {
    LOGGER.info("handling AssignKmToUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX2 entity = assignKm(event.getUnderexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event UnAssignKmFromUnderexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignKmFromUnderexcLimX2Event.class)
  public void handle(UnAssignKmFromUnderexcLimX2Event event) {
    LOGGER.info("handling UnAssignKmFromUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX2 entity = unAssignKm(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event AssignMelmaxToUnderexcLimX2Event
   */
  @EventHandler(payloadType = AssignMelmaxToUnderexcLimX2Event.class)
  public void handle(AssignMelmaxToUnderexcLimX2Event event) {
    LOGGER.info("handling AssignMelmaxToUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX2 entity = assignMelmax(event.getUnderexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event UnAssignMelmaxFromUnderexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignMelmaxFromUnderexcLimX2Event.class)
  public void handle(UnAssignMelmaxFromUnderexcLimX2Event event) {
    LOGGER.info("handling UnAssignMelmaxFromUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX2 entity = unAssignMelmax(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event AssignQoToUnderexcLimX2Event
   */
  @EventHandler(payloadType = AssignQoToUnderexcLimX2Event.class)
  public void handle(AssignQoToUnderexcLimX2Event event) {
    LOGGER.info("handling AssignQoToUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX2 entity = assignQo(event.getUnderexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event UnAssignQoFromUnderexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignQoFromUnderexcLimX2Event.class)
  public void handle(UnAssignQoFromUnderexcLimX2Event event) {
    LOGGER.info("handling UnAssignQoFromUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX2 entity = unAssignQo(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event AssignRToUnderexcLimX2Event
   */
  @EventHandler(payloadType = AssignRToUnderexcLimX2Event.class)
  public void handle(AssignRToUnderexcLimX2Event event) {
    LOGGER.info("handling AssignRToUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX2 entity = assignR(event.getUnderexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event UnAssignRFromUnderexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignRFromUnderexcLimX2Event.class)
  public void handle(UnAssignRFromUnderexcLimX2Event event) {
    LOGGER.info("handling UnAssignRFromUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX2 entity = unAssignR(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event AssignTf2ToUnderexcLimX2Event
   */
  @EventHandler(payloadType = AssignTf2ToUnderexcLimX2Event.class)
  public void handle(AssignTf2ToUnderexcLimX2Event event) {
    LOGGER.info("handling AssignTf2ToUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX2 entity = assignTf2(event.getUnderexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event UnAssignTf2FromUnderexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignTf2FromUnderexcLimX2Event.class)
  public void handle(UnAssignTf2FromUnderexcLimX2Event event) {
    LOGGER.info("handling UnAssignTf2FromUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX2 entity = unAssignTf2(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event AssignTmToUnderexcLimX2Event
   */
  @EventHandler(payloadType = AssignTmToUnderexcLimX2Event.class)
  public void handle(AssignTmToUnderexcLimX2Event event) {
    LOGGER.info("handling AssignTmToUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimX2 entity = assignTm(event.getUnderexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /*
   * @param	event UnAssignTmFromUnderexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignTmFromUnderexcLimX2Event.class)
  public void handle(UnAssignTmFromUnderexcLimX2Event event) {
    LOGGER.info("handling UnAssignTmFromUnderexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimX2 entity = unAssignTm(event.getUnderexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimX2(entity);
  }

  /**
   * Method to retrieve the UnderexcLimX2 via an UnderexcLimX2PrimaryKey.
   *
   * @param id Long
   * @return UnderexcLimX2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public UnderexcLimX2 handle(FindUnderexcLimX2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getUnderexcLimX2Id());
  }

  /**
   * Method to retrieve a collection of all UnderexcLimX2s
   *
   * @param query FindAllUnderexcLimX2Query
   * @return List<UnderexcLimX2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<UnderexcLimX2> handle(FindAllUnderexcLimX2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindUnderexcLimX2, but only if the id matches
   *
   * @param entity UnderexcLimX2
   */
  protected void emitFindUnderexcLimX2(UnderexcLimX2 entity) {
    LOGGER.info("handling emitFindUnderexcLimX2");

    queryUpdateEmitter.emit(
        FindUnderexcLimX2Query.class,
        query -> query.getFilter().getUnderexcLimX2Id().equals(entity.getUnderexcLimX2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllUnderexcLimX2
   *
   * @param entity UnderexcLimX2
   */
  protected void emitFindAllUnderexcLimX2(UnderexcLimX2 entity) {
    LOGGER.info("handling emitFindAllUnderexcLimX2");

    queryUpdateEmitter.emit(FindAllUnderexcLimX2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(UnderexcLimX2Projector.class.getName());
}
