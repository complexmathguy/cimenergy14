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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssELIN2 as outlined for the CQRS pattern. All event handling and query handling
 * related to PssELIN2 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssELIN2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssELIN2")
@Component("pssELIN2-projector")
public class PssELIN2Projector extends PssELIN2EntityProjector {

  // core constructor
  public PssELIN2Projector(PssELIN2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssELIN2Event
   */
  @EventHandler(payloadType = CreatePssELIN2Event.class)
  public void handle(CreatePssELIN2Event event) {
    LOGGER.info("handling CreatePssELIN2Event - " + event);
    PssELIN2 entity = new PssELIN2();
    entity.setPssELIN2Id(event.getPssELIN2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UpdatePssELIN2Event
   */
  @EventHandler(payloadType = UpdatePssELIN2Event.class)
  public void handle(UpdatePssELIN2Event event) {
    LOGGER.info("handling UpdatePssELIN2Event - " + event);

    PssELIN2 entity = new PssELIN2();
    entity.setPssELIN2Id(event.getPssELIN2Id());
    entity.setApss(event.getApss());
    entity.setKs1(event.getKs1());
    entity.setKs2(event.getKs2());
    entity.setPpss(event.getPpss());
    entity.setPsslim(event.getPsslim());
    entity.setTs1(event.getTs1());
    entity.setTs2(event.getTs2());
    entity.setTs3(event.getTs3());
    entity.setTs4(event.getTs4());
    entity.setTs5(event.getTs5());
    entity.setTs6(event.getTs6());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event DeletePssELIN2Event
   */
  @EventHandler(payloadType = DeletePssELIN2Event.class)
  public void handle(DeletePssELIN2Event event) {
    LOGGER.info("handling DeletePssELIN2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssELIN2 entity = delete(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignApssToPssELIN2Event
   */
  @EventHandler(payloadType = AssignApssToPssELIN2Event.class)
  public void handle(AssignApssToPssELIN2Event event) {
    LOGGER.info("handling AssignApssToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignApss(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignApssFromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignApssFromPssELIN2Event.class)
  public void handle(UnAssignApssFromPssELIN2Event event) {
    LOGGER.info("handling UnAssignApssFromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignApss(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignKs1ToPssELIN2Event
   */
  @EventHandler(payloadType = AssignKs1ToPssELIN2Event.class)
  public void handle(AssignKs1ToPssELIN2Event event) {
    LOGGER.info("handling AssignKs1ToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignKs1(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignKs1FromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignKs1FromPssELIN2Event.class)
  public void handle(UnAssignKs1FromPssELIN2Event event) {
    LOGGER.info("handling UnAssignKs1FromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignKs1(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignKs2ToPssELIN2Event
   */
  @EventHandler(payloadType = AssignKs2ToPssELIN2Event.class)
  public void handle(AssignKs2ToPssELIN2Event event) {
    LOGGER.info("handling AssignKs2ToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignKs2(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignKs2FromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignKs2FromPssELIN2Event.class)
  public void handle(UnAssignKs2FromPssELIN2Event event) {
    LOGGER.info("handling UnAssignKs2FromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignKs2(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignPpssToPssELIN2Event
   */
  @EventHandler(payloadType = AssignPpssToPssELIN2Event.class)
  public void handle(AssignPpssToPssELIN2Event event) {
    LOGGER.info("handling AssignPpssToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignPpss(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignPpssFromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignPpssFromPssELIN2Event.class)
  public void handle(UnAssignPpssFromPssELIN2Event event) {
    LOGGER.info("handling UnAssignPpssFromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignPpss(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignPsslimToPssELIN2Event
   */
  @EventHandler(payloadType = AssignPsslimToPssELIN2Event.class)
  public void handle(AssignPsslimToPssELIN2Event event) {
    LOGGER.info("handling AssignPsslimToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignPsslim(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignPsslimFromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignPsslimFromPssELIN2Event.class)
  public void handle(UnAssignPsslimFromPssELIN2Event event) {
    LOGGER.info("handling UnAssignPsslimFromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignPsslim(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignTs1ToPssELIN2Event
   */
  @EventHandler(payloadType = AssignTs1ToPssELIN2Event.class)
  public void handle(AssignTs1ToPssELIN2Event event) {
    LOGGER.info("handling AssignTs1ToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignTs1(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignTs1FromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignTs1FromPssELIN2Event.class)
  public void handle(UnAssignTs1FromPssELIN2Event event) {
    LOGGER.info("handling UnAssignTs1FromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignTs1(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignTs2ToPssELIN2Event
   */
  @EventHandler(payloadType = AssignTs2ToPssELIN2Event.class)
  public void handle(AssignTs2ToPssELIN2Event event) {
    LOGGER.info("handling AssignTs2ToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignTs2(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignTs2FromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignTs2FromPssELIN2Event.class)
  public void handle(UnAssignTs2FromPssELIN2Event event) {
    LOGGER.info("handling UnAssignTs2FromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignTs2(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignTs3ToPssELIN2Event
   */
  @EventHandler(payloadType = AssignTs3ToPssELIN2Event.class)
  public void handle(AssignTs3ToPssELIN2Event event) {
    LOGGER.info("handling AssignTs3ToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignTs3(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignTs3FromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignTs3FromPssELIN2Event.class)
  public void handle(UnAssignTs3FromPssELIN2Event event) {
    LOGGER.info("handling UnAssignTs3FromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignTs3(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignTs4ToPssELIN2Event
   */
  @EventHandler(payloadType = AssignTs4ToPssELIN2Event.class)
  public void handle(AssignTs4ToPssELIN2Event event) {
    LOGGER.info("handling AssignTs4ToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignTs4(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignTs4FromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignTs4FromPssELIN2Event.class)
  public void handle(UnAssignTs4FromPssELIN2Event event) {
    LOGGER.info("handling UnAssignTs4FromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignTs4(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignTs5ToPssELIN2Event
   */
  @EventHandler(payloadType = AssignTs5ToPssELIN2Event.class)
  public void handle(AssignTs5ToPssELIN2Event event) {
    LOGGER.info("handling AssignTs5ToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignTs5(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignTs5FromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignTs5FromPssELIN2Event.class)
  public void handle(UnAssignTs5FromPssELIN2Event event) {
    LOGGER.info("handling UnAssignTs5FromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignTs5(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event AssignTs6ToPssELIN2Event
   */
  @EventHandler(payloadType = AssignTs6ToPssELIN2Event.class)
  public void handle(AssignTs6ToPssELIN2Event event) {
    LOGGER.info("handling AssignTs6ToPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssELIN2 entity = assignTs6(event.getPssELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /*
   * @param	event UnAssignTs6FromPssELIN2Event
   */
  @EventHandler(payloadType = UnAssignTs6FromPssELIN2Event.class)
  public void handle(UnAssignTs6FromPssELIN2Event event) {
    LOGGER.info("handling UnAssignTs6FromPssELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssELIN2 entity = unAssignTs6(event.getPssELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssELIN2(entity);
  }

  /**
   * Method to retrieve the PssELIN2 via an PssELIN2PrimaryKey.
   *
   * @param id Long
   * @return PssELIN2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssELIN2 handle(FindPssELIN2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssELIN2Id());
  }

  /**
   * Method to retrieve a collection of all PssELIN2s
   *
   * @param query FindAllPssELIN2Query
   * @return List<PssELIN2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssELIN2> handle(FindAllPssELIN2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssELIN2, but only if the id matches
   *
   * @param entity PssELIN2
   */
  protected void emitFindPssELIN2(PssELIN2 entity) {
    LOGGER.info("handling emitFindPssELIN2");

    queryUpdateEmitter.emit(
        FindPssELIN2Query.class,
        query -> query.getFilter().getPssELIN2Id().equals(entity.getPssELIN2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssELIN2
   *
   * @param entity PssELIN2
   */
  protected void emitFindAllPssELIN2(PssELIN2 entity) {
    LOGGER.info("handling emitFindAllPssELIN2");

    queryUpdateEmitter.emit(FindAllPssELIN2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssELIN2Projector.class.getName());
}
